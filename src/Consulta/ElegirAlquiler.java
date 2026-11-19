package Consulta;

import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ElegirAlquiler extends javax.swing.JDialog {

    public Tripla seleccionado;
    public int tipo; //1:Alquileres 2:Liquidaciones
    
    public ElegirAlquiler(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        
        getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                dispose();
            }
        });
    }
    
    //Tipo  1:Alquiler    2:Liquidacion
    public void mostrar(int tipo){
        seleccionado = null;
        this.tipo = tipo;
        if (tipo==1){
            listarAlquileres();
        } else {
            listarLiquidaciones();
        }
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tfAlquiler = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlquileres = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elegir Cliente");

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo2.jpg"))); // NOI18N

        tfAlquiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAlquilerKeyReleased(evt);
            }
        });

        tblAlquileres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inquilino", "Inmueble"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlquileres.getTableHeader().setReorderingAllowed(false);
        tblAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAlquileresMousePressed(evt);
            }
        });
        tblAlquileres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlquileresKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblAlquileres);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAlquiler)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
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

    private void tfAlquilerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAlquilerKeyReleased
        if (tipo==1){
            listarAlquileres();
        } else {
            listarLiquidaciones();
        }
    }//GEN-LAST:event_tfAlquilerKeyReleased

    private void tblAlquileresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlquileresMousePressed
        if (tblAlquileres.getSelectedRow()>=0){
            seleccionado = (Tripla) tblAlquileres.getValueAt(tblAlquileres.getSelectedRow(), 0);
            dispose();
        }
    }//GEN-LAST:event_tblAlquileresMousePressed

    private void tblAlquileresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlquileresKeyPressed
        
    }//GEN-LAST:event_tblAlquileresKeyPressed

     

    public void listarAlquileres(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblAlquileres.getModel();        
        while(model.getRowCount()>0) model.removeRow(0);   
        SqlMetodo sql = new SqlMetodo();

        ResultSet rs = SqlMetodo.runQuery("(SELECT id_contratoalquiler, direccion_inmueble, razonsocial_persona FROM inmobiliaria.contratoalquiler  INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler\n" +
                                        " INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler\n" +
                                        " WHERE  (razonsocial_persona ILIKE '%"+tfAlquiler.getText()+"%' OR direccion_inmueble ILIKE '%"+tfAlquiler.getText()+"%') AND estado_contratoalquiler='Vigente' ORDER BY razonsocial_persona)\n" +
                                        " UNION\n" +
                                        " (SELECT id_contratoalquiler_inquilinosadicionales, direccion_inmueble, razonsocial_persona FROM inmobiliaria.inquilinosadicionales\n" +
                                        "INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_inquilinosadicionales\n" +
                                        "INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_inquilinosadicionales \n" +
                                        "INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler\n" +
                                        "WHERE  (razonsocial_persona ILIKE '%"+tfAlquiler.getText()+"%' OR direccion_inmueble ILIKE '%"+tfAlquiler.getText()+"%') AND estado_contratoalquiler='Vigente' ORDER BY razonsocial_persona);");
        int i=0;
        try {
              while (rs.next()){
                  model.setNumRows(i+1);
                  tblAlquileres.setModel(model);
                  Tripla t = new Tripla(rs.getInt("id_contratoalquiler"), rs.getString("direccion_inmueble"), rs.getString("razonsocial_persona"));
                  tblAlquileres.setValueAt(t, i, 0);
                  tblAlquileres.setValueAt(rs.getString("direccion_inmueble"), i, 1);

                  i++;
              }
        } catch (SQLException ex) {
              JFrame frame= new JFrame();
              JOptionPane.showMessageDialog(frame,"Error al listar los inmuebles.","",JOptionPane.WARNING_MESSAGE);
              Datos.Procedimientos.escribirEnLog("Error al listar los inmuebles linea 71: "+ex);
        }
    }  

    public void listarLiquidaciones(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblAlquileres.getModel();        
        while(model.getRowCount()>0) model.removeRow(0);   
        SqlMetodo sql = new SqlMetodo();

        ResultSet rs = SqlMetodo.runQuery(
                " SELECT id_contratoalquiler, direccion_inmueble, razonsocial_persona " +
                " FROM inmobiliaria.contratoalquiler " +
                " INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler\n" +
                " INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler\n" +
                " WHERE (razonsocial_persona ILIKE '%"+tfAlquiler.getText()+"%' OR direccion_inmueble ILIKE '%"+tfAlquiler.getText()+"%') AND " +
                " (SELECT COUNT(*) FROM inmobiliaria.comprobantealquiler WHERE id_contratoalquiler_comprobantealquiler=id_contratoalquiler AND tipo_comprobantealquiler='Recibo de Alquiler' AND estado_comprobantealquiler='Aprobado' AND id_comprobante_liquidacion=0)>0 " +
                " ORDER BY razonsocial_persona\n");
        int i=0;
        try {
              while (rs.next()){
                  model.setNumRows(i+1);
                  tblAlquileres.setModel(model);
                  Tripla t = new Tripla(rs.getInt("id_contratoalquiler"), rs.getString("direccion_inmueble"), rs.getString("razonsocial_persona"));
                  tblAlquileres.setValueAt(t, i, 0);
                  tblAlquileres.setValueAt(rs.getString("direccion_inmueble"), i, 1);

                  i++;
              }
        } catch (SQLException ex) {
              JFrame frame= new JFrame();
              JOptionPane.showMessageDialog(frame,"Error al listar los inmuebles.","",JOptionPane.WARNING_MESSAGE);
              Datos.Procedimientos.escribirEnLog("Error al listar los inmuebles linea 71: "+ex);
        }
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblAlquiler;
    private javax.swing.JTable tblAlquileres;
    private javax.swing.JTextField tfAlquiler;
    // End of variables declaration//GEN-END:variables
}
