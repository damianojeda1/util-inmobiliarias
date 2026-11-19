/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABM;

import Consulta.ElegirCliente;
import Datos.Instancias;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ABMContratoV extends javax.swing.JFrame {

    private boolean editado=false;
    private int id = -1;
    private Tripla cliente;
    private Tripla inmueble;

    public ABMContratoV() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        //cerrar ventana con esc
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                dispose();
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        tfInquilino = new javax.swing.JTextField();
        btnInquilino = new org.edisoncor.gui.button.ButtonAction();
        jLabel2 = new javax.swing.JLabel();
        btnInmueble = new org.edisoncor.gui.button.ButtonAction();
        tfTipo = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tfMonto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfComision = new javax.swing.JTextField();
        btnGuardar = new org.edisoncor.gui.button.ButtonAction();
        jLabel20 = new javax.swing.JLabel();
        jscroll = new javax.swing.JScrollPane();
        taObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrato Venta");
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Comprador");

        tfInquilino.setEditable(false);
        tfInquilino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnInquilino.setText("Buscar");
        btnInquilino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInquilino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInquilinoMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inmueble");

        btnInmueble.setText("Buscar");
        btnInmueble.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInmueble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInmuebleMousePressed(evt);
            }
        });

        tfTipo.setEditable(false);
        tfTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTipoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTipoKeyReleased(evt);
            }
        });

        tfDireccion.setEditable(false);
        tfDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nro. Contrato");

        tfNro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfNro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Contrato");

        dateFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monto             $");

        tfMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Comisión  %");

        tfComision.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGuardar.setText("Guardar Contrato");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Observación");

        jscroll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        taObs.setColumns(20);
        taObs.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taObs.setLineWrap(true);
        taObs.setRows(5);
        jscroll.setViewportView(taObs);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfInquilino)))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(jLabel18)
                                    .addGap(51, 51, 51))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfNro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(jLabel5)
                                    .addGap(32, 32, 32)))
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfComision, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(tfComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInquilinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInquilinoMousePressed
        ElegirCliente ec = new ElegirCliente(this, true);
        ec.mostrar("Cliente");
        if (ec.seleccionado!=null){
            cliente = ec.seleccionado;
            tfInquilino.setText(cliente.toString());
        }
    }//GEN-LAST:event_btnInquilinoMousePressed

    private void btnInmuebleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInmuebleMousePressed
        Consulta.ElegirInmueble ec = new Consulta.ElegirInmueble(this, true);
        ec.mostrar("Venta");
        if (ec.seleccionado!=null){
            inmueble = ec.seleccionado;
            tfTipo.setText(inmueble.getTercero().toString());
            tfDireccion.setText(inmueble.getSegundo().toString());
        }
    }//GEN-LAST:event_btnInmuebleMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        if(controles())
            almacenar();
    }//GEN-LAST:event_btnGuardarMousePressed

    private void tfTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipoKeyReleased
       
    }//GEN-LAST:event_tfTipoKeyReleased

    private void tfTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipoKeyPressed

    }//GEN-LAST:event_tfTipoKeyPressed
    
    
    private void almacenar(){
        String sql = "INSERT INTO inmobiliaria.contratoventa(\n" +
        "            nro_contratoventa, observacion_contratoventa, \n" +
        "            path_contratoventa, estado_contratoventa, monto_contratoventa, \n" +
        "            comision_contratoventa, fecha_contratoventa, id_inmueble_contratoventa, \n" +
        "            id_comprador_contratoventa)\n" +
        "    VALUES ( "+tfNro.getText()+", '"+taObs.getText()+"', '', \n" +
        "            'Realizado', "+tfMonto.getText()+", "+tfComision.getText()+", \n" +
        "            '"+dateFecha.getDate()+"', "+inmueble.getPrimero()+", "+cliente.getPrimero()+");";
        SqlMetodo.runQuery(sql);
        String query ="UPDATE inmobiliaria.inmueble SET estado_inmueble = 'Vendido' WHERE id_inmueble = "+inmueble.getPrimero();
        SqlMetodo.runQuery(query);
        JOptionPane.showMessageDialog(this, "Contrato almacenado exitosamente");
        Instancias.getInstance().listaContratos.listarContratosV("");
        limpiar();
    }
    
    private boolean controles(){
        if (tfDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un inmueble");
            btnInmueble.grabFocus();
            return false;
        }
        if (tfInquilino.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un comprador");
            btnInquilino.grabFocus();
            return false;
        }
        if (tfMonto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el monto de venta");
            tfMonto.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfMonto.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para monto");
                tfMonto.grabFocus();
                return false;
            }
        if (tfComision.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese la comisión");
            tfComision.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfComision.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para comisión");
                tfComision.grabFocus();
                return false;
            }        
        
        if (tfNro.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el número de contrato");
            tfNro.grabFocus();
            return false;
        }else {
            if (!Datos.Procedimientos.isNumber(tfNro.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para número de contrato");
                tfNro.grabFocus();
                return false;
            }
             else
                if(!controlUnico()){
                    JOptionPane.showMessageDialog(this, "Número de contrato existente.");
                    tfNro.grabFocus();
                    return false;
                }
        }
        return true;
    }
    
    private boolean controlUnico(){
        String sql = "SELECT nro_contratoventa FROM inmobiliaria.contratoventa WHERE nro_contratoventa = "+tfNro.getText();
        ResultSet rs = SqlMetodo.runQuery(sql);
        try {
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 379 metodo contratoUnico en la clase ABMContratoV.java: "+ex);
        }
        return true;
    }
    public void mostrar(){
        limpiar();
        setVisible(true);
    }
    
    private void limpiar(){
        editado = false;
        cliente = null;
        tfComision.setText("");
        tfDireccion.setText("");
        tfInquilino.setText("");
        tfMonto.setText("");
        tfNro.setText("");
        tfTipo.setText("");
        dateFecha.setDate(Calendar.getInstance().getTime());
        taObs.setText("");
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnGuardar;
    private org.edisoncor.gui.button.ButtonAction btnInmueble;
    private org.edisoncor.gui.button.ButtonAction btnInquilino;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jscroll;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextArea taObs;
    private javax.swing.JTextField tfComision;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfInquilino;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfNro;
    private javax.swing.JTextField tfTipo;
    // End of variables declaration//GEN-END:variables
}
