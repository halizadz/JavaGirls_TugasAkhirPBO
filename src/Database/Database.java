package Database;

import User.*;
import calender.CalendarNote;
import java.awt.Image;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Database {

    // Fungsi untuk membuka koneksi ke database
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/gettokonow", "root", "");
    }

    // Fungsi untuk menambahkan user ke database
    public static boolean addUser(User user) throws FileNotFoundException, IOException {
        String query = "INSERT INTO user(email, password, name, gender, npm, faculty, program, description, photo_path, link) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Menggunakan prepared statement untuk keamanan
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getNpm());
            pstmt.setString(6, user.getFaculty());
            pstmt.setString(7, user.getProgram());
            pstmt.setString(8, user.getDescription());
           
            String imagePath = user.getPhotoPath();
            if(imagePath != null){
                File imageFile = new File (imagePath);
                FileInputStream fis = new FileInputStream(imageFile);
                byte[] imageData = new byte[(int) imageFile.length()];
                fis.read(imageData);
                fis.close();
                pstmt.setBytes(9,imageData);

            }else {
                pstmt.setNull(9, java.sql.Types.BLOB);
            }
            
            pstmt.setString(10, user.getLink());
             
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Jika ada perubahan data, berarti berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     


    // Fungsi untuk memvalidasi login user (email dan password)
    public static boolean validateUser(String email, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;  // Jika ada data yang cocok, login dianggap valid
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
    

    
    public static boolean deleteUserProfile(String email) {
    String query = "DELETE FROM user WHERE email = ?";
    
    try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, email);
        
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    


    // Fungsi untuk mengambil data user berdasarkan email
    public static User getUserData(String email) {
    User user = null;
    String query = "SELECT * FROM user WHERE email = ?";
    
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, email);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                // Membuat objek User dengan 8 parameter
                user = new User(
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("npm"),
                    rs.getString("faculty"),
                    rs.getString("program"),
                    rs.getString("description"),
                    rs.getString("photo_path"),  // Menambahkan path foto yang diambil dari DB
                    rs.getString("link")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}
    
   public static void tampilGambar(JLabel lb_photo, String email) {
    String query = "SELECT photo_path FROM user WHERE email = ?";
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, email);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                byte[] img = rs.getBytes("photo_path");
                if (img != null) {
                    ImageIcon imageIcon = new ImageIcon(
                        new ImageIcon(img).getImage().getScaledInstance(
                            lb_photo.getWidth(),
                            lb_photo.getHeight(),
                            java.awt.Image.SCALE_SMOOTH
                        )
                    );
                    lb_photo.setIcon(imageIcon);
                } else {
                    lb_photo.setIcon(null); // Jika tidak ada gambar
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
}

    
public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                  byte[] photoPath = rs.getBytes("photo_path"); // Ambil BLOB
                System.out.println("Image size for user " + rs.getString("name") + ": " + 
                    (photoPath != null ? photoPath.length : "NULL")); // Log ukuran data
                    User user = new User(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("npm"),
                        rs.getString("faculty"),
                        rs.getString("program"),
                        rs.getString("description"),
                        null,
                        rs.getString("link")
                    );
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

public static ImageIcon loadImageIcon(String email) {
    String query = "SELECT photo_path FROM user WHERE email = ?";
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, email);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                byte[] img = rs.getBytes("photo_path");
                if (img != null) {
                    // Kembalikan ImageIcon yang dapat digunakan di mana saja
                    return new ImageIcon(
                        new ImageIcon(img).getImage().getScaledInstance(122, 131, Image.SCALE_SMOOTH)
                    );
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // Jika tidak ada gambar ditemukan
}



public static boolean addCalendarNote(String creator_Name, String tagged_Name, java.util.Date date, String note) {
    String query = "INSERT INTO calendar_notes (creator_nama, tagged_nama, date, note) VALUES (?, ?, ?, ?)";
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, creator_Name);
        pstmt.setString(2, tagged_Name);
        pstmt.setDate(3, new java.sql.Date(date.getTime())); // Konversi di sini
        pstmt.setString(4, note);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


public static List<CalendarNote> getCalendarNotesByName(String name) {
    List<CalendarNote> notes = new ArrayList<>();
    String query = "SELECT * FROM calendar_notes WHERE creator_nama = ? OR tagged_nama = ?";
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, name);
        pstmt.setString(2, name);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                notes.add(new CalendarNote(
                    rs.getString("creator_nama"),
                    rs.getString("tagged_nama"),
                    new java.util.Date(rs.getDate("date").getTime()), // Konversi java.sql.Date ke java.util.Date
                    rs.getString("note")
                ));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return notes;
}

public static List<CalendarNote> getNotesForUser(String userName) {
    String query = "SELECT creator_nama, tagged_nama, date, note FROM calendar_notes WHERE creator_nama = ? OR tagged_nama = ?";
    List<CalendarNote> notes = new ArrayList<>();
    
    try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setString(1, userName);
        pstmt.setString(2, userName);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String creatorName = rs.getString("creator_nama");
            String taggedName = rs.getString("tagged_nama");
            java.sql.Date date = rs.getDate("date");
            String note = rs.getString("note");

            notes.add(new CalendarNote(creatorName, taggedName, date, note));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return notes;
}



}




   


