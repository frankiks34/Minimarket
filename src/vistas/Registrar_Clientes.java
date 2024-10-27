/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Logica.Controladora;
import Logica.TipoCliente;
import Logica.Vendedor;
import minimarket.Sesion;

/**
 *
 * @author Frank
 */
public class Registrar_Clientes extends javax.swing.JFrame {
  private Vendedor vendedorentro;    
     Controladora control = new Controladora();
    public Registrar_Clientes() {
        initComponents();
        
          vendedorentro = Sesion.getUsuarioActual();
        
          if (vendedorentro != null) {
            System.out.println("Usuario logueado: " + vendedorentro.getNombre());
          
        } else {
            System.out.println("No hay un usuario logueado.");
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        textField3 = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textField5 = new java.awt.TextField();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textField6 = new java.awt.TextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 153, 153));
        jButton4.setText("Guardar");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 120, 36));

        textField3.setText("textField1");
        textField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField3ActionPerformed(evt);
            }
        });
        getContentPane().add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 291, 29));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Tipo de Cliente");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 150, 44));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 460, 44));

        textField5.setText("textField1");
        getContentPane().add(textField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 288, 33));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/pngtree-black-house-icon-png-image_6498106.jpg"))); // NOI18N
        jButton6.setText("jButton3");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 140, 40));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Direccion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 103, 44));

        textField6.setText("textField1");
        getContentPane().add(textField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 288, 33));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "VIP", "" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 290, 30));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("Telefono");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 103, 44));

        jButton5.setBackground(new java.awt.Color(255, 153, 153));
        jButton5.setText("Volver");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 120, 36));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Nombre");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 95, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/WhatsApp Image 2024-10-24 at 1.44.51 PM.jpeg"))); // NOI18N
        jLabel6.setText("jLabel3");
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String nombre =  textField5.getText();
        String direccion =  textField3.getText();
        String telefono = textField6.getText();
        String a = jComboBox1.getSelectedItem().toString();
         
       
             control.agregarClienteALista(nombre, direccion, telefono,a);
           
             jLabel4.setText("El Usuario se agrego correctamente"); 
             
         
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void textField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        
            Menu menu = new Menu();
        menu.setVisible(true);
    
       this.dispose(); //
        
    }//GEN-LAST:event_jButton5ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField textField3;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    // End of variables declaration//GEN-END:variables
}
