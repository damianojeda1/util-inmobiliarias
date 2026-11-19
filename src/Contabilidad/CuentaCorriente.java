
package Contabilidad;

import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import Reportes.CuentaCorrienteReport;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CuentaCorriente extends javax.swing.JFrame {
//    private String nomPersona = null;
//    private String tipo = null;
//    private Date fecha = null;
//    private Integer tel = null;
    private Integer inmueble;

    public CuentaCorriente() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
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
        
        this.tblOperaciones.setDefaultRenderer(Object.class, new ColoresTablaCuentaCorriente());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tfipoInmueble = new javax.swing.JTextField();
        tfDireccionInmueble = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOperaciones = new javax.swing.JTable();
        tfPropietario = new javax.swing.JTextField();
        tfDni = new javax.swing.JTextField();
        fecDesde = new com.toedter.calendar.JDateChooser();
        fecHasta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chkTodo = new javax.swing.JCheckBox();
        lbError = new javax.swing.JLabel();
        btnImprimir = new org.edisoncor.gui.button.ButtonAction();
        btnAnular = new org.edisoncor.gui.button.ButtonAction();
        tfInquilino = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen De Cuenta Corriente");
        setResizable(false);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(51, 102, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tfipoInmueble.setEditable(false);

        tfDireccionInmueble.setEditable(false);

        tfTelefono.setEditable(false);

        tblOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Comprobante", "Detalle", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperaciones.setGridColor(new java.awt.Color(204, 204, 204));
        tblOperaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblOperaciones);
        if (tblOperaciones.getColumnModel().getColumnCount() > 0) {
            tblOperaciones.getColumnModel().getColumn(0).setMinWidth(90);
            tblOperaciones.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblOperaciones.getColumnModel().getColumn(0).setMaxWidth(90);
            tblOperaciones.getColumnModel().getColumn(1).setMinWidth(100);
            tblOperaciones.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblOperaciones.getColumnModel().getColumn(1).setMaxWidth(100);
            tblOperaciones.getColumnModel().getColumn(3).setMinWidth(100);
            tblOperaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblOperaciones.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        tfPropietario.setEditable(false);

        tfDni.setEditable(false);
        tfDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDniActionPerformed(evt);
            }
        });

        fecDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecDesdePropertyChange(evt);
            }
        });

        fecHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecHastaPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha hasta:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha desde:");

        chkTodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkTodo.setForeground(new java.awt.Color(255, 255, 255));
        chkTodo.setSelected(true);
        chkTodo.setText("Todas las operaciones");
        chkTodo.setFocusable(false);
        chkTodo.setOpaque(false);
        chkTodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTodoItemStateChanged(evt);
            }
        });

        lbError.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));

        btnImprimir.setText("Imprimir");
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnImprimirMousePressed(evt);
            }
        });

        btnAnular.setText("Anular ultimo Comprobante");
        btnAnular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnularMousePressed(evt);
            }
        });

        tfInquilino.setEditable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/sai/sai24.PNG"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkTodo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                    .addComponent(tfipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfDireccionInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDireccionInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(chkTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecHastaPropertyChange
        if(!chkTodo.isSelected())    
            if (fecDesde.getDate().compareTo(fecHasta.getDate()) <=0){
                 lbError.setText("");
                 limpiarSinCheck();
                 llenarTF(obtenerInmueble(inmueble));
                 llenarTablaOperaciones();

             }else{
                 lbError.setText("Fecha desde debe ser menor o igual a Fecha Hasta.");

             }
    }//GEN-LAST:event_fecHastaPropertyChange

    private void chkTodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTodoItemStateChanged
        lbError.setText("");
        if(!chkTodo.isSelected())    
            if (fecDesde.getDate().compareTo(fecHasta.getDate()) <=0){
                
                limpiarSinCheck();
                llenarTF(obtenerInmueble(inmueble));
                llenarTablaOperaciones();

            }else{
                lbError.setText("Fecha desde debe ser menor o igual a Fecha Hasta.");

            }
        else{
            limpiarSinCheck();
            llenarTF(obtenerInmueble(inmueble));
            llenarTablaOperaciones();
        }    
    }//GEN-LAST:event_chkTodoItemStateChanged

    private void fecDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecDesdePropertyChange
        if(!chkTodo.isSelected())    
            if (fecDesde.getDate().compareTo(fecHasta.getDate()) <=0){
                lbError.setText("");
                limpiarSinCheck();
                llenarTF(obtenerInmueble(inmueble));
                llenarTablaOperaciones();

            }else{
                lbError.setText("Fecha desde debe ser menor o igual a Fecha Hasta.");

            }
    }//GEN-LAST:event_fecDesdePropertyChange

    private void btnImprimirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMousePressed
        Reportes.Estadisticas.imprimirMovimientos(
            tfipoInmueble.getText()+" - "+tfDireccionInmueble.getText()+"\n"+
            tfPropietario.getText()+"   "+tfDni.getText()+"\n"+tfInquilino.getText(),tblOperaciones);
    }//GEN-LAST:event_btnImprimirMousePressed

    private void btnAnularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnularMousePressed
        if (tblOperaciones.getRowCount()>0){
            anularUltimoComp();            
        }
    }//GEN-LAST:event_btnAnularMousePressed

    private void tfDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDniActionPerformed
    
    private void anularUltimoComp(){
        try {
            Tripla comp = (Tripla) tblOperaciones.getValueAt(tblOperaciones.getRowCount()-1, 1);
            switch(comp.toString()){
                case "Recibo de Alquiler":
                if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea anular el ultimo recibo de alquiler realizado?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
                    SqlMetodo.runQuery("UPDATE inmobiliaria.comprobantealquiler SET estado_comprobantealquiler= 'Anulado' "
                        + " WHERE id_comprobantealquiler = "+comp.getPrimero()+"\n");                     
                    SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET proximocobro_contratoalquiler=(proximocobro_contratoalquiler::date - ('1 month')::interval)::date "
                        + " WHERE nro_contratoalquiler = "+inmueble);
                    llenarTablaOperaciones();
                }                    
                break;
                case "Liquidacion":
                if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea anular la ultima liquidacion realizada?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
                    SqlMetodo.runQuery("UPDATE inmobiliaria.comprobantealquiler SET estado_comprobantealquiler= 'Anulado' "
                        + " WHERE id_comprobantealquiler="+comp.getPrimero()+";"
                        + " UPDATE inmobiliaria.comprobantealquiler SET id_comprobante_liquidacion=0 WHERE id_comprobante_liquidacion="+comp.getPrimero());                    
                    llenarTablaOperaciones();
                }
                break;
            }           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private ResultSet obtenerInmueble(Integer inm){
      ResultSet rs= null;
      String consulta = "SELECT tipo_inmueble, direccion_inmueble, p.razonsocial_persona as nombrep, p.tipodoc_persona as tipodocp, \n"
                      + "p.nrodoc_persona as nrodocp, p.telefono_persona as telp, i.razonsocial_persona as nombrei, i.nrodoc_persona as nrodoci\n"
                      + "FROM inmobiliaria.inmueble "
                      + "INNER JOIN inmobiliaria.contratoalquiler ON id_inmueble = id_inmueble_contratoalquiler "
                      + "INNER JOIN inmobiliaria.persona as p ON id_propietario_inmueble = p.id_persona "
                      + "INNER JOIN inmobiliaria.persona as i ON id_inquilino_contratoalquiler = i.id_persona "
                      + "WHERE nro_contratoalquiler = '" + inm + "'";
      rs = SqlMetodo.runQuery(consulta);
      return rs;
    }

    private void llenarTF(ResultSet rs){
        try {
            if(rs.next()){
                tfipoInmueble.setText(rs.getString("tipo_inmueble"));
                tfDireccionInmueble.setText(rs.getString("direccion_inmueble"));
                tfPropietario.setText("PROPIETARIO: "+rs.getString("nombrep"));
                tfDni.setText(rs.getString("tipodocp").toUpperCase()+": "+rs.getString("nrodocp"));
                tfTelefono.setText("TELÉFONO: "+rs.getString("telp"));
                tfInquilino.setText("INQUILINO: "+rs.getString("nombrei")+"    DNI: "+rs.getString("nrodoci"));
                
            } 
        } catch (SQLException ex) {
            System.out.println("error en llenarTF(CuentaCorriente.java): "+ex);
            Datos.Procedimientos.escribirEnLog("Error en llenarTF(CuentaCorriente.java): "+ex);
        }
    }
    
    private void llenarTablaOperaciones(){        
        String query = "SELECT fecha_item, monto_item, descripcion_item, id_comprobantealquiler, tipo_comprobantealquiler "
                   + "FROM inmobiliaria.item "
                   + "INNER JOIN inmobiliaria.comprobantealquiler ON id_comprobantealquiler = id_comprobantealquiler_item "
                   + "INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_comprobantealquiler "
                   + "WHERE nro_contratoalquiler = '" + inmueble + "' AND estado_comprobantealquiler='Aprobado'";
        if(!chkTodo.isSelected())
            query = query + " and fecha_comprobantealquiler >='"+fecDesde.getDate()+"' and fecha_comprobantealquiler <='"+fecHasta.getDate()+"'";
        
        ResultSet rs = SqlMetodo.runQuery(query);
        
        DefaultTableModel modelo = (DefaultTableModel) tblOperaciones.getModel(); 
        while (modelo.getRowCount()>0) modelo.removeRow(0);
        try {
            while(rs.next()){
                modelo.setNumRows(modelo.getRowCount() + 1);
                tblOperaciones.setModel(modelo);
                tblOperaciones.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_item")), modelo.getRowCount()-1, 0);
                tblOperaciones.setValueAt(new Tripla(rs.getInt("id_comprobantealquiler"), null, rs.getString("tipo_comprobantealquiler")), modelo.getRowCount()-1, 1);
                tblOperaciones.setValueAt(rs.getString("descripcion_item"), modelo.getRowCount()-1, 2);
                tblOperaciones.setValueAt(rs.getFloat("monto_item"), modelo.getRowCount()-1, 3);
            }
        } catch (SQLException ex) {
            System.out.println("error en llenarTablaOperaciones(CuentaCorriente.java): "+ex);
            Datos.Procedimientos.escribirEnLog("Error en llenarTablaOperaciones(CuentaCorriente.java): "+ex);
        }
    }
    
    public void mostrar(Integer inm, String tipoEstado){
        if (tipoEstado.equals("Vigente"))
            btnAnular.setVisible(true);
        else
            btnAnular.setVisible(false);
        inmueble = inm;
        limpiar();
        llenarTF(obtenerInmueble(inmueble));
        llenarTablaOperaciones();
        this.setVisible(true);
    }
    
    private void limpiar(){
        tfipoInmueble.setText("");
        tfPropietario.setText("");
        tfDireccionInmueble.setText("");
        tfDni.setText("");
        tfTelefono.setText("");
        chkTodo.setSelected(true);
        fecDesde.setDate(Calendar.getInstance().getTime());
        fecHasta.setDate(Calendar.getInstance().getTime());
//        DefaultTableModel modelo = (DefaultTableModel) tblOperaciones.getModel(); 
//        modelo.setNumRows(0);
//        tblOperaciones.setModel(modelo);
    }
    private void limpiarSinCheck(){
        tfipoInmueble.setText("");
        tfPropietario.setText("");
        tfDireccionInmueble.setText("");
        tfDni.setText("");
        tfTelefono.setText("");
//        DefaultTableModel modelo = (DefaultTableModel) tblOperaciones.getModel(); 
//        modelo.setNumRows(0);
//        tblOperaciones.setModel(modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnAnular;
    private org.edisoncor.gui.button.ButtonAction btnImprimir;
    private javax.swing.JCheckBox chkTodo;
    private com.toedter.calendar.JDateChooser fecDesde;
    private com.toedter.calendar.JDateChooser fecHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbError;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblOperaciones;
    private javax.swing.JTextField tfDireccionInmueble;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfInquilino;
    private javax.swing.JTextField tfPropietario;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfipoInmueble;
    // End of variables declaration//GEN-END:variables
   
}