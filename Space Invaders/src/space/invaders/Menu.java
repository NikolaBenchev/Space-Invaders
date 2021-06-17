package space.invaders;

/**
 *
 * @author EliteBook
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setSize(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        pnlMenu.setBackground(new java.awt.Color(0, 0, 0));
        pnlMenu.setMaximumSize(new java.awt.Dimension(1024, 640));
        pnlMenu.setPreferredSize(new java.awt.Dimension(1024, 640));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Free Pixel", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Space Invaders - Survival mode");
        pnlMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemy1_big.gif"))); // NOI18N
        pnlMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemy3_big.gif"))); // NOI18N
        pnlMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 180, 78));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enemy2_big.gif"))); // NOI18N
        pnlMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 178, 99));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/playerBullet_big.png"))); // NOI18N
        pnlMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 131, 59));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/player_big.png"))); // NOI18N
        pnlMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 190, 81));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnPlay.setBackground(new java.awt.Color(0, 0, 0));
        btnPlay.setFont(new java.awt.Font("Free Pixel", 1, 48)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(0, 255, 0));
        btnPlay.setText("Play");
        btnPlay.setBorder(null);
        btnPlay.setFocusPainted(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnScore.setBackground(new java.awt.Color(0, 0, 0));
        btnScore.setFont(new java.awt.Font("Free Pixel", 1, 48)); // NOI18N
        btnScore.setForeground(new java.awt.Color(0, 255, 0));
        btnScore.setText("High Scores");
        btnScore.setBorder(null);
        btnScore.setFocusPainted(false);
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(0, 0, 0));
        btnHelp.setFont(new java.awt.Font("Free Pixel", 1, 48)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(0, 255, 0));
        btnHelp.setText("Help");
        btnHelp.setBorder(null);
        btnHelp.setFocusPainted(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScore))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnlMenu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 320, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        this.dispose();
        Window window = new Window();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed
        //pnlMenu.setVisible(false);
        this.dispose();
        Menu_High_Score score = new Menu_High_Score();
    }//GEN-LAST:event_btnScoreActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        this.dispose();
        Menu_Help help = new Menu_Help();
    }//GEN-LAST:event_btnHelpActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
