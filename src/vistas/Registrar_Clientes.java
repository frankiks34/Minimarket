/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author Frank
 */
public class Registrar_Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_Clientes
     */
    public Registrar_Clientes() {
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

        jButton4 = new javax.swing.JButton();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textField5 = new java.awt.TextField();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 153, 153));
        jButton4.setText("Registro");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 214, 36));

        textField3.setText("textField1");
        textField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField3ActionPerformed(evt);
            }
        });
        getContentPane().add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 291, 29));

        textField4.setText("textField1");
        getContentPane().add(textField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 288, 33));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Telefono");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 103, 44));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 250, 44));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Usuario");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 95, 44));

        textField5.setText("textField1");
        getContentPane().add(textField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 288, 33));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/pngtree-black-house-icon-png-image_6498106.jpg"))); // NOI18N
        jButton6.setText("jButton3");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 140, 40));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Contraseña");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 103, 44));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/WhatsApp Image 2024-10-24 at 1.44.51 PM.jpeg"))); // NOI18N
        jLabel6.setText("jLabel3");
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
/*
        String nombre =  textField5.getText();
        String contrasenia =  textField3.getText();
        String telefono = textField4.getText();

     List<Vendedor> b =a.obtenerVendedores();

        for (Vendedor ven: b) {
            if (ven.getNombre().equals(nombre)) {
                jLabel2.setText("El usuario ya existe ,ingrese otro nombre");
            }
            else
            {
                a.crearvendedor(nombre, contrasenia, telefono);

                Inicio inicio = new Inicio();
                inicio.setVisible(true);

                this.dispose();
            }
        }
*/
    }//GEN-LAST:event_jButton4ActionPerformed

    private void textField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField3ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    // End of variables declaration//GEN-END:variables
}