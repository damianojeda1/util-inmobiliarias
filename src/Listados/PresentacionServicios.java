package Listados;

import Datos.Procedimientos;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PresentacionServicios extends javax.swing.JFrame {

    public PresentacionServicios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
    }
    
    int idContrato;
    
    public void mostrar(Integer idContrato){
        this.idContrato = idContrato;
        llenarTabla();
        setVisible(true);
    }
    
        
    private void llenarTabla(){
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblComprobantes.getModel();         
        while(modelo.getRowCount()>0)modelo.removeRow(0);              
        
        ResultSet rs = SqlMetodo.runQuery(
            " SELECT id_comprobantealquiler as id, fecha_comprobantealquiler as fecha, inq.razonsocial_persona as nombreInq\n" +
            "      , tipo_comprobantealquiler as tipo, nro_comprobantealquiler as nro, total_comprobantealquiler as total \n" +
            "      , prop.razonsocial_persona as nombreProp\n" +
            "   FROM inmobiliaria.comprobantealquiler       \n" +
            "   INNER JOIN inmobiliaria.contratoalquiler on id_contratoalquiler_comprobantealquiler = id_contratoalquiler\n" +
            "   INNER JOIN inmobiliaria.persona inq on id_inquilino_contratoalquiler = inq.id_persona\n" +
            "   INNER JOIN inmobiliaria.inmueble on id_inmueble_contratoalquiler = id_inmueble\n" +
            "   INNER JOIN inmobiliaria.persona prop on id_propietario_inmueble = prop.id_persona \n" +
            "   WHERE estado_comprobantealquiler <> 'Anulado' AND id_contratoalquiler_comprobantealquiler="+idContrato+" \n" +
            "     AND (SELECT COUNT(*) \n" +
            "           FROM inmobiliaria.serviciocomprobante \n" +
            "           WHERE estado_serviciocomprobante > -1 \n" +
            "             AND id_comprobante_serviciocomprobante = id_comprobantealquiler) > 0\n" +
            " ORDER BY fecha DESC");
        try {
            while(rs.next()){
                modelo.setNumRows(tblComprobantes.getModel().getRowCount() + 1);
                tblComprobantes.setModel(modelo);
                tblComprobantes.setValueAt(new Tripla(rs.getInt("id"), rs.getString("tipo"), new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha"))), tblComprobantes.getModel().getRowCount()-1, 0);
                tblComprobantes.setValueAt(rs.getString("tipo")+"  0001-"+Procedimientos.completaConCero(rs.getString("nro"), 8), tblComprobantes.getModel().getRowCount()-1, 1);
                tblComprobantes.setValueAt(servicios(rs.getInt("id")), tblComprobantes.getModel().getRowCount()-1, 2); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("PANTALLAPRINCIPAL - 1072 -"+ex.toString());
        } 
    }
    
    private Tripla servicios(int id){
        try {
            ResultSet rs = SqlMetodo.runQuery("SELECT detalle_servicio, estado_serviciocomprobante, id_servicio_serviciocomprobante \n"
                    + " FROM inmobiliaria.servicio \n"
                    + " INNER JOIN inmobiliaria.serviciocomprobante ON id_servicio_serviciocomprobante = id_servicio\n"
                    + " WHERE id_comprobante_serviciocomprobante ="+id);
            String serv = "";
            int cant=0;
            while (rs.next()){
                serv += rs.getString("detalle_servicio")+":"+(rs.getInt("estado_serviciocomprobante")==0 ? "DEBE" : "OK")+"  ";
                switch (rs.getInt("id_servicio_serviciocomprobante")){
                    case 1: chkMunicipal.setSelected(rs.getInt("estado_serviciocomprobante")==1); break;
                    case 2: chkEmos.setSelected(rs.getInt("estado_serviciocomprobante")==1); break;
                    case 3: chkExpensas.setSelected(rs.getInt("estado_serviciocomprobante")==1); break;
                }
                cant += rs.getInt("estado_serviciocomprobante")==0 ? 1 : 0;
            }
            return new Tripla(cant, null, serv);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComprobantes = new javax.swing.JTable();
        btnServicios = new org.edisoncor.gui.button.ButtonAction();
        chkExpensas = new javax.swing.JCheckBox();
        chkMunicipal = new javax.swing.JCheckBox();
        chkEmos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Presentación de servicios");
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tblComprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Comprobante", "Debe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComprobantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblComprobantesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblComprobantes);
        if (tblComprobantes.getColumnModel().getColumnCount() > 0) {
            tblComprobantes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblComprobantes.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        btnServicios.setText("Presentar Servicios");
        btnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnServiciosMousePressed(evt);
            }
        });

        chkExpensas.setForeground(new java.awt.Color(255, 255, 255));
        chkExpensas.setSelected(true);
        chkExpensas.setText("EXPENSAS");
        chkExpensas.setOpaque(false);

        chkMunicipal.setForeground(new java.awt.Color(255, 255, 255));
        chkMunicipal.setSelected(true);
        chkMunicipal.setText("MUNICIPAL");
        chkMunicipal.setOpaque(false);

        chkEmos.setForeground(new java.awt.Color(255, 255, 255));
        chkEmos.setSelected(true);
        chkEmos.setText("EMOS");
        chkEmos.setOpaque(false);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chkExpensas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkMunicipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkEmos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkExpensas)
                    .addComponent(chkMunicipal)
                    .addComponent(chkEmos))
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

    private void btnServiciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiciosMousePressed
        int fila = tblComprobantes.getSelectedRow();
        if (fila > -1){            
            int id = (Integer) (((Tripla) tblComprobantes.getValueAt(tblComprobantes.getSelectedRow(), 0)).getPrimero());
            SqlMetodo.runQuery("UPDATE inmobiliaria.serviciocomprobante "
                + " SET estado_serviciocomprobante="+(chkMunicipal.isSelected()? 1 : 0)
                + " WHERE id_servicio_serviciocomprobante=1"
                + "     AND id_comprobante_serviciocomprobante="+id);
            SqlMetodo.runQuery("UPDATE inmobiliaria.serviciocomprobante "
                + " SET estado_serviciocomprobante="+(chkEmos.isSelected()? 1 : 0)
                + " WHERE id_servicio_serviciocomprobante=2"
                + "     AND id_comprobante_serviciocomprobante="+id);
            SqlMetodo.runQuery("UPDATE inmobiliaria.serviciocomprobante "
                + " SET estado_serviciocomprobante="+(chkExpensas.isSelected()? 1 : 0)
                + " WHERE id_servicio_serviciocomprobante=3"
                + "     AND id_comprobante_serviciocomprobante="+id);
            JOptionPane.showMessageDialog(this, "Presentacion de servicios actualizada");
            llenarTabla();
            Datos.Instancias.getInstance().listaContratos.llenarTablaContratosA();
        }
    }//GEN-LAST:event_btnServiciosMousePressed

    private void tblComprobantesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprobantesMouseReleased
        if (tblComprobantes.getSelectedRow()>=0){
            int id = (Integer) (((Tripla) tblComprobantes.getValueAt(tblComprobantes.getSelectedRow(), 0)).getPrimero());
            servicios(id);
        }
    }//GEN-LAST:event_tblComprobantesMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnServicios;
    private javax.swing.JCheckBox chkEmos;
    private javax.swing.JCheckBox chkExpensas;
    private javax.swing.JCheckBox chkMunicipal;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblComprobantes;
    // End of variables declaration//GEN-END:variables
}
