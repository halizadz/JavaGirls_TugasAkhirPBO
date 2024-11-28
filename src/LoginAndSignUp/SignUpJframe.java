/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LoginAndSignUp;

import Database.*;
import User.*;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;


public class SignUpJframe extends javax.swing.JFrame {
    private String selectedPhotoPath = ""; 
    
    public SignUpJframe() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Email_txts = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name_txts = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        npm_txts = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        description_txts = new javax.swing.JTextField();
        Pass_txts = new javax.swing.JPasswordField();
        cb_faculty = new javax.swing.JComboBox<>();
        cb_program = new javax.swing.JComboBox<>();
        selectedPhoto = new javax.swing.JButton();
        btnsignups = new javax.swing.JButton();
        btnLogins = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lb_photo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cb_gender = new javax.swing.JComboBox<>();
        link_text = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(239, 178, 185));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11zon_resized (6).png"))); // NOI18N

        jLabel9.setBackground(new java.awt.Color(239, 178, 185));
        jLabel9.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Welcome to SoulMate");

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(428, 500));

        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.setPreferredSize(new java.awt.Dimension(406, 500));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(412, 1700));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 178, 185));
        jLabel1.setText("SIGN UP");

        jLabel3.setText("Password");

        Email_txts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Email_txtsActionPerformed(evt);
            }
        });

        jLabel4.setText("Email");

        jLabel8.setText("Full Name");

        jLabel11.setText("NPM");

        jLabel12.setText("Faculty");

        jLabel13.setText("Program");

        jLabel14.setText("Description");

        Pass_txts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass_txtsActionPerformed(evt);
            }
        });

        cb_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ilmu Komputer", "Hukum", "Ekonomi", "Ilmu Sosial dan Ilmu Politik" }));
        cb_faculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_facultyActionPerformed(evt);
            }
        });

        cb_program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_programActionPerformed(evt);
            }
        });

        selectedPhoto.setText("Choose photo");
        selectedPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedPhotoActionPerformed(evt);
            }
        });

        btnsignups.setBackground(new java.awt.Color(239, 178, 185));
        btnsignups.setText("Sign Up");
        btnsignups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupsActionPerformed(evt);
            }
        });

        btnLogins.setForeground(new java.awt.Color(239, 178, 185));
        btnLogins.setText("Login");
        btnLogins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginsActionPerformed(evt);
            }
        });

        jLabel5.setText("I've an a account");

        lb_photo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Gender");

        cb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Man", "Woman" }));

        jLabel16.setText("Link Sosial Media");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(link_text, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnsignups)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(83, 83, 83)
                                .addComponent(btnLogins)))
                        .addContainerGap(266, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_gender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name_txts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(npm_txts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Email_txts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(description_txts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pass_txts, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_faculty, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_program, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_photo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectedPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Email_txts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pass_txts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_txts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(selectedPhoto)))
                    .addComponent(lb_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(npm_txts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(2, 2, 2)
                .addComponent(cb_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(14, 14, 14)
                .addComponent(cb_program, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(4, 4, 4)
                .addComponent(description_txts, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnsignups, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(link_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(btnLogins))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jToolBar1.add(jScrollPane1);

        jDesktopPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginsActionPerformed
        LoginJframe LoginFrame = new LoginJframe();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLoginsActionPerformed

    private void btnsignupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupsActionPerformed
         // Ambil input dari form dan buat objek User
    User user = new User(
        Email_txts.getText(),
        Pass_txts.getText(),
        name_txts.getText(),
        cb_gender.getSelectedItem().toString(),
        npm_txts.getText(),
        cb_faculty.getSelectedItem().toString(),
        cb_program.getSelectedItem().toString(),
        description_txts.getText(),
        selectedPhotoPath,
        link_text.getText()
        
        
        
    );
    
    // Cek jika ada field yang kosong
    if (user.getEmail().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getPassword().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getName().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Full Name is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getNpm().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "NPM is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getFaculty().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Faculty is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getProgram().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Study Program is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (user.getDescription().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Description is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (selectedPhoto == null) {
        // Tambahkan validasi untuk foto
        JOptionPane.showMessageDialog(new JFrame(), "Please choose a profile photo!", "Error", JOptionPane.ERROR_MESSAGE);
   } else {
    try {
        Long.valueOf(user.getNpm().trim()); // Cek apakah NPM valid sebagai angka

        // Jika semua input terisi, lanjutkan untuk menyimpan data ke database
        boolean success = Database.addUser(user); // Tangkap exception di sini
        if (success) {
            // Reset fields setelah data berhasil disimpan
            Email_txts.setText("");
            Pass_txts.setText("");
            name_txts.setText("");
            cb_gender.setSelectedIndex(0);
            npm_txts.setText("");
            cb_faculty.setSelectedIndex(0);
            cb_program.removeAllItems();
            description_txts.setText("");
            lb_photo.setIcon(null);
            link_text.setText("");

            JOptionPane.showMessageDialog(null, "Account has been created successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error in creating account", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "NPM must be numeric!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException e) { // Tangkap FileNotFoundException
        JOptionPane.showMessageDialog(null, "File gambar tidak ditemukan!\n" + e.getMessage(),
                                      "File Not Found", JOptionPane.ERROR_MESSAGE);
    }   catch (IOException ex) {
            Logger.getLogger(SignUpJframe.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }//GEN-LAST:event_btnsignupsActionPerformed

    private void Pass_txtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass_txtsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pass_txtsActionPerformed

    private void Email_txtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Email_txtsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Email_txtsActionPerformed

    private void cb_facultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_facultyActionPerformed
        String selectedFaculty = (String) cb_faculty.getSelectedItem();
        updateProgramStudi(selectedFaculty); // Panggil fungsi ini

    }//GEN-LAST:event_cb_facultyActionPerformed

    // Fungsi untuk memperbarui program studi berdasarkan fakultas
    private void updateProgramStudi(String fakultas) {
        cb_program.removeAllItems(); // Hapus item sebelumnya
        if (null == fakultas) {
            cb_program.addItem("Pilih Program Studi");
        } else switch (fakultas) {
            case "Ilmu Komputer" -> {
                cb_program.addItem("Informatika");
                cb_program.addItem("Sistem Informasi");
            }
            case "Ekonomi" -> {
                cb_program.addItem("Manajemen");
                cb_program.addItem("Akuntansi");
            }
            case "Hukum" -> cb_program.addItem("Ilmu Hukum");
            case "Ilmu Sosial dan Ilmu Politik" -> {
                cb_program.addItem("Ilmu Komunikasi");
                cb_program.addItem("Ilmu Pemerintahan");
                cb_program.addItem("Hubungan Internasional");
            }
            default -> cb_program.addItem("Pilih Program Studi");
        }
    }
    
    private void cb_programActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_programActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_programActionPerformed
    
        
    private void selectedPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedPhotoActionPerformed
    
    // Membuat JFileChooser untuk memilih gambar
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Select Profile Photo");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
    fileChooser.addChoosableFileFilter(filter);
    
    int result = fileChooser.showSaveDialog(null);
    if(result == JFileChooser.APPROVE_OPTION){
        File selectedFile = fileChooser.getSelectedFile();
        selectedPhotoPath = selectedFile.getAbsolutePath();
        
        try { 
            //konversi blob gambar ke ImageIcon
            byte[] img = Files.readAllBytes(selectedFile.toPath());
            ImageIcon imageIcon = new ImageIcon(img);
            
            //ukuran JLabel yang diinginkan
            int labelWidth = 200;
            int labelHeight = 400;
            
            //ukuran gambar asli
            int imageWidth =imageIcon.getIconWidth();
            int imageHeight =imageIcon.getIconHeight();
            
            //Hitung skala untuk ukuran gambar yang baru
            double scaleX = (double) labelWidth / (double) imageWidth;
            double scaleY = (double) labelHeight / (double) imageHeight;
             double scale = Math.min(scaleX, scaleY);
             
             //Ubah ukuran gambar dengan skala yang sudah dihitung
             Image scaledImage = imageIcon.getImage().getScaledInstance((int) (scale * imageWidth), (int) (scale * imageWidth), Image.SCALE_SMOOTH);
             
             lb_photo.setIcon(new ImageIcon(scaledImage));
            
            
        } catch (IOException ex){
        }
    }
   
    }//GEN-LAST:event_selectedPhotoActionPerformed

         // Metode untuk mengubah ukuran gambar sesuai ukuran label
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email_txts;
    private javax.swing.JPasswordField Pass_txts;
    private javax.swing.JButton btnLogins;
    private javax.swing.JButton btnsignups;
    private javax.swing.JComboBox<String> cb_faculty;
    private javax.swing.JComboBox<String> cb_gender;
    private javax.swing.JComboBox<String> cb_program;
    private javax.swing.JTextField description_txts;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lb_photo;
    private javax.swing.JTextField link_text;
    private javax.swing.JTextField name_txts;
    private javax.swing.JTextField npm_txts;
    private javax.swing.JButton selectedPhoto;
    // End of variables declaration//GEN-END:variables
}
