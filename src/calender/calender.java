/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calender;

import Database.Database;
import Find.FindYourPatner;
import Home.Profile;
import LoginAndSignUp.LoginJframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class calender extends javax.swing.JFrame {

   private int month, year; // Untuk mengatur bulan dan tahun
    private Calendar calendar = new GregorianCalendar();
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private String userName;
    private String email;
    
    public calender() {
        
        initComponents();
        setupCalendar();
    }
    
    // Konstruktor dengan parameter email
    public calender(String userName) {
        this. userName = userName; // Simpan email pengguna
        initComponents();
        setTitle("Calendar - Welcome, " + userName); // Tampilkan nama pengguna di judul
        setupCalendar();
    }

    
private void setupCalendar() {
    month = calendar.get(Calendar.MONTH);
    year = calendar.get(Calendar.YEAR);

    // Tambahkan panel kalender ke UI
    calendarPanel = new JPanel();
    calendarPanel.setLayout(new GridLayout(7, 7, 5, 5)); // 7 baris x 7 kolom
    calendarPanel.setBackground(Color.WHITE);

    // Label untuk menampilkan nama bulan
    monthLabel = new JLabel("", JLabel.CENTER);
    monthLabel.setFont(new Font("Arial", Font.BOLD, 24));
    monthLabel.setForeground(Color.BLACK);

    // Tombol navigasi
    JButton prevButton = new JButton("<");
    prevButton.addActionListener(e -> changeMonth(-1));

    JButton nextButton = new JButton(">");
    nextButton.addActionListener(e -> changeMonth(1));

    // Panel navigasi
    JPanel navigationPanel = new JPanel(new BorderLayout());
    navigationPanel.add(prevButton, BorderLayout.WEST);
    navigationPanel.add(monthLabel, BorderLayout.CENTER);
    navigationPanel.add(nextButton, BorderLayout.EAST);

    // Panel utama kalender
    JPanel mainCalendarPanel = new JPanel(new BorderLayout());
    mainCalendarPanel.add(navigationPanel, BorderLayout.NORTH);
    mainCalendarPanel.add(calendarPanel, BorderLayout.CENTER);

    // Tambahkan ke panel_calender
    panel_calender.setLayout(new BorderLayout());
    panel_calender.add(mainCalendarPanel);

    // Muat hari-hari dalam bulan
    refreshCalendar();
    loadNotesToPanel();
}
private void changeMonth(int delta) {
    month += delta;
    if (month < 0) {
        month = 11;
        year--;
    } else if (month > 11) {
        month = 0;
        year++;
    }
    refreshCalendar();
}


 private void refreshCalendar() {
        calendarPanel.removeAll();

        // Header hari
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JButton headerButton = new JButton(day);
            headerButton.setEnabled(false); // Header tidak bisa diklik
            calendarPanel.add(headerButton);
        }

        // Setup kalender
        Calendar cal = new GregorianCalendar(year, month, 1);
        int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Hari pertama bulan
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Isi tombol kosong sebelum tanggal pertama
        for (int i = 0; i < startDay; i++) {
            calendarPanel.add(new JButton());
        }

        // Tambahkan tanggal
        List<CalendarNote> notes = Database.getCalendarNotesByName( userName); // Ambil janji berdasarkan pengguna
        for (int day = 1; day <= daysInMonth; day++) {
            final int currentDay = day;
            JButton dayButton = new JButton(String.valueOf(day));

            // Highlight jika ada janji
            Date currentDate = new GregorianCalendar(year, month, currentDay).getTime();
            for (CalendarNote note : notes) {
                if (note.getDate().equals(currentDate)) {
                    dayButton.setBackground(new Color(255, 255, 150)); // Warna untuk tanggal dengan janji
                    dayButton.setToolTipText(note.getNote()); // Tampilkan catatan sebagai tooltip
                }
            }

            // Tambahkan event listener untuk membuka dialog tambah janji
            dayButton.addActionListener(e -> openAddNoteDialog(currentDay));
            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

 /**
     * Membuka dialog untuk menambahkan janji
     */
    private void openAddNoteDialog(int day) {
    String taggedName = JOptionPane.showInputDialog(this, "Enter the name of the tagged user:");
    String note = JOptionPane.showInputDialog(this, "Enter your note:");

    if (taggedName != null && note != null && !taggedName.trim().isEmpty() && !note.trim().isEmpty()) {
        Calendar selectedDate = new GregorianCalendar(year, month, day);
        java.util.Date utilDate = selectedDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Konversi ke java.sql.Date

        boolean success = Database.addCalendarNote( userName, taggedName, sqlDate, note);

        if (success) {
            JOptionPane.showMessageDialog(this, "Note added successfully!");
            refreshCalendar(); // Perbarui kalender setelah menambah janji
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add note. Please try again.");
        }
    }
}

    private void loadNotesToPanel() {
    panel_keterangan.removeAll(); // Hapus konten lama
    List<CalendarNote> notes = Database.getNotesForUser( userName);

    if (notes.isEmpty()) {
        JLabel noNotesLabel = new JLabel("No notes available.");
        panel_keterangan.add(noNotesLabel);
    } else {
        panel_keterangan.setLayout(new BoxLayout(panel_keterangan, BoxLayout.Y_AXIS));
        for (CalendarNote note : notes) {
            JLabel noteLabel = new JLabel(formatNoteDisplay(note));
            panel_keterangan.add(noteLabel);
        }
    }

    panel_keterangan.revalidate();
    panel_keterangan.repaint();
}

// Metode untuk format tampilan note
private String formatNoteDisplay(CalendarNote note) {
    return "<html>"
        + "<b>Creator:</b> " + note.getCreatorName() + "<br>"
        + "<b>Tagged:</b> " + note.getTaggedName() + "<br>"
        + "<b>Date:</b> " + note.getDate() + "<br>"
        + "<b>Note:</b> " + note.getNote()
        + "</html>";
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_profile = new javax.swing.JButton();
        btn_Find = new javax.swing.JButton();
        btn_calender = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_calender = new javax.swing.JPanel();
        panel_keterangan = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(239, 178, 185));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 15)); // NOI18N
        jLabel1.setText("SoulMate.");

        btn_profile.setText("Profile");
        btn_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profileActionPerformed(evt);
            }
        });

        btn_Find.setText("Find Your Patner");
        btn_Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FindActionPerformed(evt);
            }
        });

        btn_calender.setText("Calender");
        btn_calender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calenderActionPerformed(evt);
            }
        });

        jButton8.setText("Log Out");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11zon_resized (7).png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calender, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Find)
                    .addComponent(btn_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_profile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Find, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_calender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Calender");

        panel_calender.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_calenderLayout = new javax.swing.GroupLayout(panel_calender);
        panel_calender.setLayout(panel_calenderLayout);
        panel_calenderLayout.setHorizontalGroup(
            panel_calenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        panel_calenderLayout.setVerticalGroup(
            panel_calenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        panel_keterangan.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_keteranganLayout = new javax.swing.GroupLayout(panel_keterangan);
        panel_keterangan.setLayout(panel_keteranganLayout);
        panel_keteranganLayout.setHorizontalGroup(
            panel_keteranganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        panel_keteranganLayout.setVerticalGroup(
            panel_keteranganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_keterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_keterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_calender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profileActionPerformed
        Profile ProfileFrame = new Profile(email, userName); // Kirim nama pengguna
        ProfileFrame.setVisible(true);
        this.dispose(); // Tutup halaman Profile
    }//GEN-LAST:event_btn_profileActionPerformed

    private void btn_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindActionPerformed
         FindYourPatner findFrame = new FindYourPatner(userName); // Kirim nama pengguna
        findFrame.setVisible(true);
        this.dispose(); // Tutup halaman Profile
    }//GEN-LAST:event_btn_FindActionPerformed

    private void btn_calenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_calenderActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
   // Konfirmasi logout
    int confirm = JOptionPane.showConfirmDialog(
            this, // Parent component
            "Are you sure you want to logout?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        // Tutup jendela saat ini
        this.dispose();

        // Opsional: Alihkan ke halaman login
        LoginJframe loginFrame = new LoginJframe(); // Ganti dengan nama kelas frame login Anda
        loginFrame.setVisible(true); // Tampilkan frame login
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null); // Posisikan di tengah layar
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Find;
    private javax.swing.JButton btn_calender;
    private javax.swing.JButton btn_profile;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_calender;
    private javax.swing.JPanel panel_keterangan;
    // End of variables declaration//GEN-END:variables
}
