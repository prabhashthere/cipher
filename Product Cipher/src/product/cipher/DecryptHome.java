/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static product.cipher.EncryptHome.fullTextShuffled;

/**
 *
 * @author Prabhash
 */
public class DecryptHome extends javax.swing.JFrame {

    static String decryptKey;
    String line;
    String fullText = "";
    String fullTextReOrdered;
    String fullTextPlaced;

    public DecryptHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pathDecryptedTxt = new javax.swing.JTextField();
        decryptKeyTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        decryptAttachBtn = new javax.swing.JButton();
        encryptSelectPathTxt = new javax.swing.JTextField();
        keySubmitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Enter  Secret Key of the Document (8 Characters)");

        jLabel2.setText("Your Decrypted document is at,");

        decryptKeyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptKeyTxtActionPerformed(evt);
            }
        });
        decryptKeyTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                decryptKeyTxtKeyReleased(evt);
            }
        });

        jLabel3.setText("Select a file bellow to decrypt");

        decryptAttachBtn.setText("Attach");
        decryptAttachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptAttachBtnActionPerformed(evt);
            }
        });

        encryptSelectPathTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptSelectPathTxtActionPerformed(evt);
            }
        });

        keySubmitBtn.setText("Submit");
        keySubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keySubmitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pathDecryptedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(encryptSelectPathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decryptKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keySubmitBtn)
                            .addComponent(decryptAttachBtn))))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decryptAttachBtn)
                    .addComponent(encryptSelectPathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decryptKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keySubmitBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pathDecryptedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decryptKeyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptKeyTxtActionPerformed

    }//GEN-LAST:event_decryptKeyTxtActionPerformed

    private void decryptAttachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptAttachBtnActionPerformed
        JFileChooser chooser = new JFileChooser("C:/Users/Prabhash/Desktop");
        chooser.showOpenDialog(null);
        File file1 = chooser.getSelectedFile();
        String filepath = file1.getAbsolutePath();
        encryptSelectPathTxt.setText(filepath);

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(file1);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                fullText += line + "\n";
            }
            //System.out.println(fullText);

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + file1 + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + file1 + "'");
        }


    }//GEN-LAST:event_decryptAttachBtnActionPerformed

    private void encryptSelectPathTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptSelectPathTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encryptSelectPathTxtActionPerformed

    private void keySubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keySubmitBtnActionPerformed
        decryptKey = decryptKeyTxt.getText();
        try {
        fullTextReOrdered = EncryptorDecryptor.reOrder(decryptKey, fullText);
        fullTextPlaced = EncryptorDecryptor.placeLetters(decryptKey, fullTextReOrdered);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Decryption Key", "OPZ...", JOptionPane.WARNING_MESSAGE);
        }
        File deCryptedFile = new File("C:\\Users\\Prabhash\\Desktop\\DecryptedFile.txt");
        System.out.println(fullTextPlaced);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(deCryptedFile));
            writer.write(fullTextPlaced);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(EncryptHome.class.getName()).log(Level.SEVERE, null, ex);
        }

        pathDecryptedTxt.setText(deCryptedFile.getAbsolutePath());
    }//GEN-LAST:event_keySubmitBtnActionPerformed

    private void decryptKeyTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_decryptKeyTxtKeyReleased
        if (decryptKeyTxt.getText().length() == 8) {
            keySubmitBtn.setEnabled(true);
        } else {
            keySubmitBtn.setEnabled(false);
        }
    }//GEN-LAST:event_decryptKeyTxtKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        keySubmitBtn.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(DecryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DecryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DecryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DecryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DecryptHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptAttachBtn;
    private javax.swing.JTextField decryptKeyTxt;
    private javax.swing.JTextField encryptSelectPathTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton keySubmitBtn;
    private javax.swing.JTextField pathDecryptedTxt;
    // End of variables declaration//GEN-END:variables
}
