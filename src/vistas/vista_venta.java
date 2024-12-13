/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Producto;
import Logica.Vendedor;
import Logica.Venta;
import Logica.VentaProducto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.Menu;

/**
 *
 * @author Frank
 */
public class vista_venta extends javax.swing.JFrame {

   private Vendedor vendedorentro;    
 
    private Controladora controladora;
      private List<Producto> productosStock;  // Lista de productos para agregar
    private DefaultTableModel modeloVenta;  // Modelo para la tabla de venta
    private Venta ventaActual;  // Venta actual en proceso
private Cliente clienteSeleccionado;
    public vista_venta() {
        initComponents();
       
     controladora = new Controladora();
        productosStock = controladora.getproductos(); // Obtener los productos disponibles
        ventaActual = new Venta(new ArrayList<>()); 
         modeloVenta = (DefaultTableModel) jTable1.getModel();

        // Cargar los productos en el JList
        cargarProductosEnLista();// Crear una nueva venta vacía
     
    }
  

    private void cargarProductosEnLista() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Producto producto : productosStock) {
            listModel.addElement(producto.getNombre() + " - $" + producto.getPrecio());
        }
        jList1.setModel(listModel);
    }
     private void agregarProductoAVenta() {
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex != -1) {
            Producto productoSeleccionado = productosStock.get(selectedIndex);
            int cantidad = Integer.parseInt(jTextField2.getText());

            // Crear un nuevo objeto VentaProducto
            VentaProducto ventaProducto = new VentaProducto(productoSeleccionado, cantidad);

            // Agregar el producto a la venta
            ventaActual.agregarProducto(ventaProducto);

            // Actualizar la tabla
            modeloVenta.addRow(new Object[]{
                productoSeleccionado.getNombre(),
                cantidad,
                productoSeleccionado.getPrecio(),
                ventaProducto.getTotal()
            });

            // Actualizar el total de la venta
           // jLabelTotal.setText("Total: $" + ventaActual.getTotal());
            jLabel2.setText("Total: $" + ventaActual.getTotal());
        }
    }
    private void finalizarVenta() {
       
   

       
        controladora.crearVenta( ventaActual.getProductos());
        
        // Actualizar stock de los productos vendidos
         controladora.actualizarStock(ventaActual.getProductos());

        JOptionPane.showMessageDialog(this, "Venta finalizada. Total: $" + ventaActual.getTotal());

        // Limpiar la venta actual
        ventaActual = new Venta(new ArrayList<>());
        modeloVenta.setRowCount(0);  // Limpiar la tabla
        jLabel2.setText("Total: $0.0");  // Restablecer el total
       //aumenado ultimo 
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 460, 44));

        jButton5.setBackground(new java.awt.Color(255, 153, 153));
        jButton5.setText("Volver");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 120, 36));

        jButton7.setBackground(new java.awt.Color(255, 153, 153));
        jButton7.setText("Vender");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 150, 36));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 410, 260));

        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 140, 40));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 280, 250));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 160, 40));

        jLabel2.setText("Precio");
        jLabel2.setName(" jLabelTotal"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/WhatsApp Image 2024-10-24 at 1.44.51 PM.jpeg"))); // NOI18N
        jLabel6.setText("jLabel3");
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Menu menu = new Menu();
        menu.setVisible(true);

        this.dispose(); //
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
  
        finalizarVenta();
        Menu menu = new Menu();
        menu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
     
    }//GEN-LAST:event_jList1KeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
      agregarProductoAVenta()   ;                           
    }//GEN-LAST:event_jList1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
