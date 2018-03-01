/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Prabhash
 */
public class EncryptHome extends javax.swing.JFrame {
    static String keyVal;
    String line;
    String fullText = "";
    String fullTextReplaced;
    String fullTextShuffled;
    ArrayList<String> char8Array = new ArrayList<>();
    
    public static String getKeyVal() {
        return keyVal;
    }

    public static void setKeyVal(String keyVal) {
        EncryptHome.keyVal = keyVal;
    }
    
    
    public EncryptHome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attachbtn = new javax.swing.JButton();
        pathtxt = new javax.swing.JTextField();
        keyInputtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        attachbtn.setText("Attach");
        attachbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachbtnActionPerformed(evt);
            }
        });

        pathtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathtxtActionPerformed(evt);
            }
        });

        keyInputtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyInputtxtActionPerformed(evt);
            }
        });
        keyInputtxt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                keyInputtxtPropertyChange(evt);
            }
        });
        keyInputtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyInputtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyInputtxtKeyTyped(evt);
            }
        });

        jLabel1.setText("Type a key of 8 characters bellow to generate an encryption key");

        jLabel2.setText("Select a file bellow to encrypt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(keyInputtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(attachbtn)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(keyInputtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attachbtn)
                    .addComponent(pathtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void attachbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachbtnActionPerformed
        JFileChooser chooser = new JFileChooser("C:/Users/Prabhash/Desktop");
        chooser.showOpenDialog(null);
        File file1 = chooser.getSelectedFile();
        String filepath= file1.getAbsolutePath();
        pathtxt.setText(filepath);
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(file1);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                fullText += line + "\n";
            }  
            //System.out.println(fullText);
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file1 + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file1 + "'");    
        }
        
        setKeyVal(Key.generateKey(keyInputtxt.getText()));
        fullTextReplaced = Encryptor.replaceLetters(fullText, char8Array);
        fullTextShuffled = Encryptor.shuffle(keyVal,fullTextReplaced);
        File encryptedFile = new File("C:\\Users\\Prabhash\\Desktop\\EncryptedFile.txt");
        DisplayEncrypt deId = new DisplayEncrypt();
        pathT
        deId.show();
        
    }//GEN-LAST:event_attachbtnActionPerformed

    private void keyInputtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyInputtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyInputtxtActionPerformed

    private void keyInputtxtPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_keyInputtxtPropertyChange
        if(keyInputtxt.getText().length()==8){
            attachbtn.setEnabled(true);
        }
        else{
            attachbtn.setEnabled(false);
        }
    }//GEN-LAST:event_keyInputtxtPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        attachbtn.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void keyInputtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyInputtxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_keyInputtxtKeyTyped

    private void keyInputtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyInputtxtKeyReleased
        if(keyInputtxt.getText().length()==8){
            attachbtn.setEnabled(true);
        }
        else{
            attachbtn.setEnabled(false);
        }
    }//GEN-LAST:event_keyInputtxtKeyReleased

    private void pathtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathtxtActionPerformed

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
            java.util.logging.Logger.getLogger(EncryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField keyInputtxt;
    private javax.swing.JTextField pathtxt;
    // End of variables declaration//GEN-END:variables
}
