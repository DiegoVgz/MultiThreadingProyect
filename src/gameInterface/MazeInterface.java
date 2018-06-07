/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameInterface;

import domain.FastCharacter;
import domain.FuriousCharacter;
import domain.MazeLevels;
import domain.Maze;
import domain.PositionCharacter;
import domain.SerializableFile;
import domain.SmartCharacter;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author 1
 */
public class MazeInterface extends javax.swing.JFrame implements Serializable {

    private Dimension dim;
    Maze m1;
    MazeLevels m;
    String maze[][];
    /**
     * Creates new form MazeInterface
     */
    ArrayList<PositionCharacter> array = new ArrayList<>();

    ;
    public MazeInterface() throws IOException, ClassNotFoundException {
        initComponents();
        mostrar();
        dim = super.getToolkit().getScreenSize();
        super.setSize(dim);
        BufferedImage img = ImageIO.read(new File("wall.jpg"));
        String gameLevel = jTextField1.getText();
        BufferedImage doors = ImageIO.read(new File("door.png"));
        BufferedImage exit = ImageIO.read(new File("door.gif"));

        int mazeSize = 0;
        int mazeLevel = 0;
        int mazeWidth = 0;
        int mazeHight = 0;

        if (gameLevel.equalsIgnoreCase("hard")) {
            mazeSize = 11;
            mazeLevel = 12;
            mazeWidth = 733;
            mazeHight = 903;

            img = ImageIO.read(new File("lava.gif"));

        } else if (gameLevel.equalsIgnoreCase("normal")) {
            mazeSize = 15;
            mazeLevel = 11;
            mazeWidth = 750;
            mazeHight = 850;
            img = ImageIO.read(new File("ice.jpg"));
        } else {
            mazeSize = 15;
            mazeLevel = 10;
            mazeWidth = 650;
            mazeHight = 750;
        }

        m1 = new Maze(0, 0, img, gameLevel, doors, exit);
        m = new MazeLevels(m1, 0, 0, 0);
        jPanel1.setSize(m.getWidth(), m.getWidth());
        jPanel1.add(m);

        m.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        CreateFast = new javax.swing.JButton();
        createFurious = new javax.swing.JButton();
        createSmart = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jButton1.setText("Acccept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("easy");

        CreateFast.setText("Fast");
        CreateFast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateFastActionPerformed(evt);
            }
        });

        createFurious.setText("Furious");
        createFurious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFuriousActionPerformed(evt);
            }
        });

        createSmart.setText("Smart");
        createSmart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSmartActionPerformed(evt);
            }
        });

        jButton2.setText("exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(CreateFast)
                        .addGap(33, 33, 33)
                        .addComponent(createFurious)
                        .addGap(41, 41, 41)
                        .addComponent(createSmart)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(32, 32, 32)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(68, 68, 68))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateFast)
                            .addComponent(createFurious)
                            .addComponent(createSmart))
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();

        try {
            BufferedImage img = ImageIO.read(new File("wall.jpg"));
            String gameLevel = jTextField1.getText();
            BufferedImage doors = ImageIO.read(new File("door.png"));
            BufferedImage exit = ImageIO.read(new File("door.gif"));

            int mazeSize = 0;
            int mazeLevel = 0;
            int mazeWidth = 0;
            int mazeHight = 0;

            if (gameLevel.equalsIgnoreCase("hard")) {
                mazeSize = 14;
                mazeLevel = 12;
                mazeWidth = 770;
                mazeHight = 900;

                img = ImageIO.read(new File("lava.gif"));

            } else if (gameLevel.equalsIgnoreCase("normal")) {
                mazeSize = 15;
                mazeLevel = 11;
                mazeWidth = 750;
                mazeHight = 850;
                img = ImageIO.read(new File("ice.jpg"));
            } else {
                mazeSize = 15;
                mazeLevel = 10;
                mazeWidth = 650;
                mazeHight = 750;
            }
            new SerializableFile().escribir(new ArrayList<>(), "Time.obj");
            m1 = new Maze(mazeLevel, mazeLevel, img, gameLevel, doors, exit);
            m = new MazeLevels(m1, mazeSize, mazeWidth, mazeHight);
            jPanel1.setSize(m.getWidth(), m.getWidth());
            jPanel1.add(m);
            m.run();
            m.repaint();
            mostrar();

        } catch (IOException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void CreateFastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateFastActionPerformed
        try {

            FastCharacter f = new FastCharacter(0, 25, 25, 0,
                    m.getNum(), "Kevin", "fast", 30, jPanel1, this);
            m.addCharacter(f, "fast");
            m.run();
            m.repaint();

        } catch (IOException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_CreateFastActionPerformed

    private void createFuriousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFuriousActionPerformed

        try {

            FuriousCharacter fu = new FuriousCharacter(0, 25, 25, 0, m.getNum(), "Kevin", "furious", 120, jPanel1, this);

            m.addCharacter(fu, "furious");
            m.run();
            m.repaint();

        } catch (IOException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_createFuriousActionPerformed

    private void createSmartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSmartActionPerformed
        try {

            SmartCharacter s = new SmartCharacter(0, 25, 25, 0, m.getNum(), "Kevin", "fast", 120, jPanel1, this);

            m.addCharacter(s, "smart");
            m.run();
            m.repaint();

        } catch (IOException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createSmartActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new SerializableFile().escribir(new ArrayList<>(), "Time.obj");
        try {
            mostrar();
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void mostrar() throws ClassNotFoundException {
        array = new SerializableFile().cargar(new ArrayList<>(), "Time.obj");
        if (array != null) {
            String maze[][] = new String[array.size()][2];

            for (int i = 0; i < array.size(); i++) {
                maze[i][0] = array.get(i).getName();
                maze[i][1] = array.get(i).getTime();
            }

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    maze,
                    new String[]{
                        "Name", "Time"
                    }
            ));
        }
    }

    public ArrayList<PositionCharacter> getArray() {
        return array;
    }

    public void setArray(ArrayList<PositionCharacter> array) {
        this.array = array;
    }

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
            java.util.logging.Logger.getLogger(MazeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MazeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MazeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MazeInterface().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MazeInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateFast;
    private javax.swing.JButton createFurious;
    private javax.swing.JButton createSmart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
