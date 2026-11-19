package Listados;

import Datos.Instancias;
import Datos.Procedimientos;
import Facturacion.Facturacion;
import Facturacion.Impresion.ImpresionComprobante;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MisComprobantes extends javax.swing.JFrame {

    public MisComprobantes() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());  
        filtroComps = new TableRowSorter<>(tblComprobantes.getModel());
        tblComprobantes.setRowSorter(filtroComps);
        filtroComps.setRowFilter(null);
    }
    
    private TableRowSorter<TableModel> filtroComps;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listar = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnImprimirFactura = new org.edisoncor.gui.button.ButtonAction();
        btnAnular = new org.edisoncor.gui.button.ButtonAction();
        btnAnular1 = new org.edisoncor.gui.button.ButtonAction();
        jLabel7 = new javax.swing.JLabel();
        fechaDesde = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        fechaHasta = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComprobantes = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRefrescar = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Comprobantes");

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        btnImprimirFactura.setText("Imprimir Comprobante");
        btnImprimirFactura.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnImprimirFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnImprimirReportePressed(evt);
            }
        });

        btnAnular.setText("Anular Comprobante");
        btnAnular.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAnular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnularMousePressed(evt);
            }
        });

        btnAnular1.setText("Ver Comprobantes Anulados");
        btnAnular1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAnular1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnular1MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Desde:");

        fechaDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaDesdeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hasta:");

        fechaHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaHastaActionPerformed(evt);
            }
        });

        tblComprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Nombre", "Comprobante", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblComprobantes);
        if (tblComprobantes.getColumnModel().getColumnCount() > 0) {
            tblComprobantes.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblComprobantes.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");

        btnRefrescar.setText("Refrescar");
        btnRefrescar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefrescarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnular1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
    
    private void btnImprimirReportePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirReportePressed
        int row = tblComprobantes.getSelectedRow();
        if (row>=0){
            Tripla comp = (Tripla) this.tblComprobantes.getValueAt(row, 0);
            String tipo = comp.getSegundo().toString();
            this.btnImprimirFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));            
            ImpresionComprobante ic = new ImpresionComprobante();
            switch (tipo){
                case "Recibo X":                      
                    ic.imprimirReciboDB((Integer) comp.getPrimero());
                break;
                case "Liquidacion":                              
                    ic.imprimirDB((Integer) comp.getPrimero());
                break;                
                case "Recibo de Alquiler": 
                    ic.imprimirDB((Integer) comp.getPrimero());
                break;
            }
            this.btnImprimirFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_btnImprimirReportePressed

    private void btnAnularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnularMousePressed
        // TODO add your handling code here:
        int row = tblComprobantes.getSelectedRow();
        if (row>=0){
            anular(row);                      
        }
    }//GEN-LAST:event_btnAnularMousePressed

    private void btnAnular1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnular1MousePressed
        // TODO add your handling code here:
        Anulados a = new Anulados(fechaDesde.getDate(),fechaHasta.getDate());
        a.setVisible(true);
    }//GEN-LAST:event_btnAnular1MousePressed

    private void fechaDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaDesdeActionPerformed
        llenarTabla();
    }//GEN-LAST:event_fechaDesdeActionPerformed

    private void fechaHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaHastaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_fechaHastaActionPerformed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        String text = tfBuscar.getText().toUpperCase().trim();
        tblComprobantes.clearSelection();
        if (text.length() > 1) {                
            List<RowFilter<Object, Object>> listaFiltros = new ArrayList<>();
            String[] aux = text.replace("*", "").split(" ");
            for (int i = 0; i < aux.length; i++) {
                // El string que esta al principio, es para que no joda el case sensitive
                listaFiltros.add(RowFilter.regexFilter("(?i)" + aux[i], 0, 1));
            }
            filtroComps.setRowFilter(RowFilter.andFilter(listaFiltros));            
        } else {
            filtroComps.setRowFilter(null);            
        }
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void btnRefrescarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMousePressed
        llenarTabla();
    }//GEN-LAST:event_btnRefrescarMousePressed
        
    private void llenarTabla(){
        tfBuscar.setText("");
        filtroComps.setRowFilter(null); 
        
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblComprobantes.getModel();         
        while(modelo.getRowCount()>0)modelo.removeRow(0);           
        
        ResultSet rs = SqlMetodo.runQuery(
            " SELECT * FROM ( SELECT id_comprobante as id, fecha_comprobante as fecha, \n" +
            "      (CASE WHEN id_persona = 1 THEN '-'\n" +
            "            ELSE razonsocial_persona \n" +
            "       END) as nombreInq, \n" +
            "       tipo_comprobante as tipo, nro_comprobante as nro, total_comprobante as total, '' as nombreProp\n" +
            "   FROM inmobiliaria.comprobante       \n" +
            "   INNER JOIN inmobiliaria.persona on id_cliente_comprobante = id_persona    \n" +
            "   WHERE fecha_comprobante >= '"+fechaDesde.getDate()+"' and fecha_comprobante <= '"+fechaHasta.getDate()+"' AND estado_comprobante <> 'Anulado' \n" +
            "\n" +
            " UNION  \n" +
            "\n" +
            " SELECT id_comprobantealquiler as id, fecha_comprobantealquiler as fecha, inq.razonsocial_persona as nombreInq\n" +
            "      , tipo_comprobantealquiler as tipo, nro_comprobantealquiler as nro, total_comprobantealquiler as total \n" +
            "      , prop.razonsocial_persona as nombreProp\n" +
            "   FROM inmobiliaria.comprobantealquiler       \n" +
            "   INNER JOIN inmobiliaria.contratoalquiler on id_contratoalquiler_comprobantealquiler = id_contratoalquiler\n" +
            "   INNER JOIN inmobiliaria.persona inq on id_inquilino_contratoalquiler = inq.id_persona\n" +
            "   INNER JOIN inmobiliaria.inmueble on id_inmueble_contratoalquiler = id_inmueble\n" +
            "   INNER JOIN inmobiliaria.persona prop on id_propietario_inmueble = prop.id_persona \n" +
            "   WHERE fecha_comprobantealquiler >= '"+fechaDesde.getDate()+"' and fecha_comprobantealquiler <= '"+fechaHasta.getDate()+"' AND estado_comprobantealquiler <> 'Anulado') as tabla \n" +
            " ORDER BY tabla.fecha DESC");
        try {
            while(rs.next()){
                modelo.setNumRows(tblComprobantes.getModel().getRowCount() + 1);
                tblComprobantes.setModel(modelo);

                tblComprobantes.setValueAt(new Tripla(rs.getInt("id"),rs.getString("tipo"),new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha"))), tblComprobantes.getModel().getRowCount()-1, 0);  
                if (rs.getString("tipo").equals("Liquidacion")){
                    tblComprobantes.setValueAt(rs.getString("nombreProp"), tblComprobantes.getModel().getRowCount()-1, 1);
                } else {
                    tblComprobantes.setValueAt(rs.getString("nombreInq"), tblComprobantes.getModel().getRowCount()-1, 1);
                }
                tblComprobantes.setValueAt(rs.getString("tipo")+"  0001-"+Procedimientos.completaConCero(rs.getString("nro"), 8), tblComprobantes.getModel().getRowCount()-1, 2);
                tblComprobantes.setValueAt(rs.getFloat("total"), tblComprobantes.getModel().getRowCount()-1, 3);                                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("PANTALLAPRINCIPAL - 1072 -"+ex.toString());
        } 
    }
    
    private void anular(int row){
        Tripla comp = (Tripla) this.tblComprobantes.getValueAt(row, 0);
        String tipo = comp.getSegundo().toString();
        switch (tipo){
            case "Recibo X": 
                if (JOptionPane.showConfirmDialog(rootPane, 
                    "¿Está seguro que desea anular el comprobante nro "+(String) this.tblComprobantes.getValueAt(row, 2)+"?", 
                    "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
                    Tripla tripla = (Tripla) this.tblComprobantes.getValueAt(row, 0);
                    SqlMetodo.runQuery("UPDATE inmobiliaria.comprobante SET estado_comprobante= 'Anulado' "
                            + " WHERE id_comprobante="+tripla.getPrimero()+"");
                    DefaultTableModel m = (DefaultTableModel) tblComprobantes.getModel();
                    m.removeRow(row);
                    tblComprobantes.setModel(m);
                }                    
                break;
            case "Liquidacion":
                if (JOptionPane.showConfirmDialog(rootPane, 
                    "¿Está seguro que desea anular la liquidacion nro "+(String) this.tblComprobantes.getValueAt(row, 2)+"?", 
                    "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
                    Tripla tripla = (Tripla) this.tblComprobantes.getValueAt(row, 0);
                    SqlMetodo.runQuery("UPDATE inmobiliaria.comprobantealquiler SET estado_comprobantealquiler= 'Anulado'  "
                        + " WHERE id_comprobantealquiler="+tripla.getPrimero()+";"
                        + " UPDATE inmobiliaria.comprobantealquiler SET id_comprobante_liquidacion=0 WHERE id_comprobante_liquidacion="+tripla.getPrimero());
                    DefaultTableModel m = (DefaultTableModel) tblComprobantes.getModel();
                    m.removeRow(row);
                    tblComprobantes.setModel(m);
                }
                break;
            case "Recibo de Alquiler":
                JOptionPane.showMessageDialog(this, "Para anular un Recibo de alquiler debe ir movimientos del contrato, desde el menú 'Contratos'");                    
                break;

        } 
    }
    
    public void mostrar(){
        Calendar principio = Calendar.getInstance();
        principio.set(Calendar.MONTH, 0);
        principio.set(Calendar.DAY_OF_YEAR, 1);
        fechaDesde.setDate(principio.getTime());
        fechaHasta.setDate(new java.util.Date());
        llenarTabla();
        setVisible(true);
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnAnular;
    private org.edisoncor.gui.button.ButtonAction btnAnular1;
    private org.edisoncor.gui.button.ButtonAction btnImprimirFactura;
    private org.edisoncor.gui.button.ButtonAction btnRefrescar;
    private org.jdesktop.swingx.JXDatePicker fechaDesde;
    private org.jdesktop.swingx.JXDatePicker fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup listar;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblComprobantes;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
