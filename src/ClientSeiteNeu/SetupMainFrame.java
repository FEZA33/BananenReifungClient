/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ClientSeiteNeu;

/**
 * 
 * @author alisi
 */
public class SetupMainFrame extends javax.swing.JFrame {

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    /**
     * @param jButton1 the jButton1 to set
     */
    public void setjButton1(javax.swing.JButton jButton1) {
        this.jButton1 = jButton1;
    }

    /**
     * @return the jFileChooser1
     */
    /**
     * Creates new form SetupMainFrame
     */
    public SetupMainFrame() {
//         try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            initComponents();
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(SetupMainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SetupMainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(SetupMainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(SetupMainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
    initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldParameters = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSollDaten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIstDaten = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOffnen = new javax.swing.JMenuItem();
        jMenuItemSpeichern = new javax.swing.JMenuItem();
        jMenuItemDefault = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemTextLoschen = new javax.swing.JMenuItem();
        jMenuItemSetPathParameter = new javax.swing.JMenuItem();
        jMenuItemSetSollDatenPath = new javax.swing.JMenuItem();
        jMenuItemIstDatenPath = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setText("Parameters");

        jTextFieldParameters.setText("jTextField1");

        jLabel2.setText("Soll Daten");

        jTextFieldSollDaten.setText("jTextField2");

        jLabel3.setText("Ist Daten");

        jTextFieldIstDaten.setText("jTextField3");

        jButton1.setText("jButton1");

        jMenu1.setText("File");

        jMenuItemOffnen.setText("Offnen");
        jMenuItemOffnen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOffnenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOffnen);

        jMenuItemSpeichern.setText("Speichern");
        jMenu1.add(jMenuItemSpeichern);

        jMenuItemDefault.setText("Load Default File");
        jMenu1.add(jMenuItemDefault);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Edit");

        jMenuItemTextLoschen.setText("ClearScreen");
        jMenu5.add(jMenuItemTextLoschen);

        jMenuItemSetPathParameter.setText("ParameterPath");
        jMenu5.add(jMenuItemSetPathParameter);

        jMenuItemSetSollDatenPath.setText("SollDatenPath");
        jMenu5.add(jMenuItemSetSollDatenPath);

        jMenuItemIstDatenPath.setText("IstDatenPath");
        jMenuItemIstDatenPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIstDatenPathActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemIstDatenPath);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSollDaten, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(jTextFieldIstDaten)
                            .addComponent(jTextFieldParameters))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSollDaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldIstDaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemIstDatenPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIstDatenPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemIstDatenPathActionPerformed

    private void jMenuItemOffnenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOffnenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemOffnenActionPerformed

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
            java.util.logging.Logger.getLogger(SetupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetupMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupMainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemDefault;
    private javax.swing.JMenuItem jMenuItemIstDatenPath;
    private javax.swing.JMenuItem jMenuItemOffnen;
    private javax.swing.JMenuItem jMenuItemSetPathParameter;
    private javax.swing.JMenuItem jMenuItemSetSollDatenPath;
    private javax.swing.JMenuItem jMenuItemSpeichern;
    private javax.swing.JMenuItem jMenuItemTextLoschen;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldIstDaten;
    private javax.swing.JTextField jTextFieldParameters;
    private javax.swing.JTextField jTextFieldSollDaten;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the jMenu1
     */
    public javax.swing.JMenu getjMenu1() {
        return jMenu1;
    }

    /**
     * @param jMenu1 the jMenu1 to set
     */
    public void setjMenu1(javax.swing.JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    /**
     * @return the jMenu5
     */
    public javax.swing.JMenu getjMenu5() {
        return jMenu5;
    }

    /**
     * @param jMenu5 the jMenu5 to set
     */
    public void setjMenu5(javax.swing.JMenu jMenu5) {
        this.jMenu5 = jMenu5;
    }

    /**
     * @return the jMenuBar1
     */
    public javax.swing.JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    /**
     * @param jMenuBar1 the jMenuBar1 to set
     */
    public void setjMenuBar1(javax.swing.JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    /**
     * @return the jMenuItemDefault
     */
    public javax.swing.JMenuItem getjMenuItemDefault() {
        return jMenuItemDefault;
    }

    /**
     * @param jMenuItemDefault the jMenuItemDefault to set
     */
    public void setjMenuItemDefault(javax.swing.JMenuItem jMenuItemDefault) {
        this.jMenuItemDefault = jMenuItemDefault;
    }

    /**
     * @return the jMenuItemIstDatenPath
     */
    public javax.swing.JMenuItem getjMenuItemIstDatenPath() {
        return jMenuItemIstDatenPath;
    }

    /**
     * @param jMenuItemIstDatenPath the jMenuItemIstDatenPath to set
     */
    public void setjMenuItemIstDatenPath(javax.swing.JMenuItem jMenuItemIstDatenPath) {
        this.jMenuItemIstDatenPath = jMenuItemIstDatenPath;
    }

    /**
     * @return the jMenuItemSetPathParameter
     */
    public javax.swing.JMenuItem getjMenuItemSetPathParameter() {
        return jMenuItemSetPathParameter;
    }

    /**
     * @param jMenuItemSetPathParameter the jMenuItemSetPathParameter to set
     */
    public void setjMenuItemSetPathParameter(javax.swing.JMenuItem jMenuItemSetPathParameter) {
        this.jMenuItemSetPathParameter = jMenuItemSetPathParameter;
    }

    /**
     * @return the jMenuItemSetSollDatenPath
     */
    public javax.swing.JMenuItem getjMenuItemSetSollDatenPath() {
        return jMenuItemSetSollDatenPath;
    }

    /**
     * @param jMenuItemSetSollDatenPath the jMenuItemSetSollDatenPath to set
     */
    public void setjMenuItemSetSollDatenPath(javax.swing.JMenuItem jMenuItemSetSollDatenPath) {
        this.jMenuItemSetSollDatenPath = jMenuItemSetSollDatenPath;
    }

    /**
     * @return the jMenuItemSpeichern
     */
    public javax.swing.JMenuItem getjMenuItemSpeichern() {
        return jMenuItemSpeichern;
    }

    /**
     * @param jMenuItemSpeichern the jMenuItemSpeichern to set
     */
    public void setjMenuItemSpeichern(javax.swing.JMenuItem jMenuItemSpeichern) {
        this.jMenuItemSpeichern = jMenuItemSpeichern;
    }

    /**
     * @return the jMenuItemTextLöschen
     */
    public javax.swing.JMenuItem getjMenuItemTextLöschen() {
        return jMenuItemTextLoschen;
    }

    /**
     * @param jMenuItemTextLöschen the jMenuItemTextLöschen to set
     */
    public void setjMenuItemTextLöschen(javax.swing.JMenuItem jMenuItemTextLöschen) {
        this.jMenuItemTextLoschen = jMenuItemTextLöschen;
    }

    /**
     * @return the jMenuItemÖffnen
     */
    public javax.swing.JMenuItem getjMenuItemÖffnen() {
        return jMenuItemOffnen;
    }

    /**
     * @param jMenuItemÖffnen the jMenuItemÖffnen to set
     */
    public void setjMenuItemÖffnen(javax.swing.JMenuItem jMenuItemÖffnen) {
        this.jMenuItemOffnen = jMenuItemÖffnen;
    }

    /**
     * @return the jScrollPane2
     */
    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    /**
     * @param jScrollPane2 the jScrollPane2 to set
     */
    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    /**
     * @return the jTextArea2
     */
    public javax.swing.JTextArea getjTextArea2() {
        return jTextArea2;
    }

    /**
     * @param jTextArea2 the jTextArea2 to set
     */
    public void setjTextArea2(javax.swing.JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }

    /**
     * @return the jTextFieldIstDaten
     */
    public javax.swing.JTextField getjTextFieldIstDaten() {
        return jTextFieldIstDaten;
    }

    /**
     * @param jTextFieldIstDaten the jTextFieldIstDaten to set
     */
    public void setjTextFieldIstDaten(javax.swing.JTextField jTextFieldIstDaten) {
        this.jTextFieldIstDaten = jTextFieldIstDaten;
    }

    /**
     * @return the jTextFieldParameters
     */
    public javax.swing.JTextField getjTextFieldParameters() {
        return jTextFieldParameters;
    }

    /**
     * @param jTextFieldParameters the jTextFieldParameters to set
     */
    public void setjTextFieldParameters(javax.swing.JTextField jTextFieldParameters) {
        this.jTextFieldParameters = jTextFieldParameters;
    }

    /**
     * @return the jTextFieldSollDaten
     */
    public javax.swing.JTextField getjTextFieldSollDaten() {
        return jTextFieldSollDaten;
    }

    /**
     * @param jTextFieldSollDaten the jTextFieldSollDaten to set
     */
    public void setjTextFieldSollDaten(javax.swing.JTextField jTextFieldSollDaten) {
        this.jTextFieldSollDaten = jTextFieldSollDaten;
    }

}