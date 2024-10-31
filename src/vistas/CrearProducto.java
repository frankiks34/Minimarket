/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Logica.Controladora;
import Logica.Producto;
import Logica.Vendedor;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import minimarket.Sesion;

/**
 *
 * @author Frank
 */
public class CrearProducto extends javax.swing.JFrame {

    private Vendedor vendedorentro;
    Controladora control = new Controladora();
    
    public CrearProducto() {
        initComponents();
         SetImagenLabel(jLabel1,"src/vistas/imagenes/casa.jpeg");
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
        jLabel7 = new javax.swing.JLabel();
        textField6 = new java.awt.TextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textField7 = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 120, 36));

        textField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField3ActionPerformed(evt);
            }
        });
        getContentPane().add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 291, 70));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Categoria");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 150, 44));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 460, 44));
        getContentPane().add(textField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 288, 33));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Descripcion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 44));
        getContentPane().add(textField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 293, 288, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electrónica", "Ropa", "Alimentos" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 290, 30));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("Precio");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 103, 44));

        jButton5.setBackground(new java.awt.Color(255, 153, 153));
        jButton5.setText("Volver");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 120, 36));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Nombre");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, 50));
        getContentPane().add(textField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 288, 33));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setText("Stock");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 150, 44));

        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 140, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/WhatsApp Image 2024-10-24 at 1.44.51 PM.jpeg"))); // NOI18N
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String nombre =  textField5.getText();
        String descripcion =  textField3.getText();
        float precio = Float.parseFloat(textField7.getText());
        int stock = Integer.parseInt(textField6.getText());
        String categoria = jComboBox1.getSelectedItem().toString();
        
        
        control.agregarProductoALista(nombre, precio, stock, descripcion, categoria);
        

        jLabel4.setText("El producto se agrego correctamente");

    }//GEN-LAST:event_jButton4ActionPerformed
  public void SetImagenLabel(JLabel LabelName , String root)
    {
    ImageIcon image = new ImageIcon(root);
    Icon icon = new ImageIcon(
    image.getImage().getScaledInstance(LabelName.getWidth(), LabelName.getHeight(),Image.SCALE_DEFAULT)
    );
       LabelName.setIcon(icon);
       this.repaint();
    
    
    }
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextField textField3;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    // End of variables declaration//GEN-END:variables
}
