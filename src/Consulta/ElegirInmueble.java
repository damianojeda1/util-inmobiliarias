package Consulta;

import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ElegirInmueble extends javax.swing.JDialog {

    String estado;
    public Tripla seleccionado;
    
    public ElegirInmueble(java.awt.Frame parent, boolean modal) {
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
    
    public void mostrar(String tipo){
        this.estado = tipo;
        seleccionado = null;
        listarInmuebles();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tfInmueble = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViaje = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elegir Inmueble");

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo2.jpg"))); // NOI18N

        tfInmueble.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfInmueble.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfInmuebleKeyReleased(evt);
            }
        });

        tblViaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblViaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inmueble", "Dirección"
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
        tblViaje.getTableHeader().setReorderingAllowed(false);
        tblViaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblViajeMousePressed(evt);
            }
        });
        tblViaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblViajeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblViaje);
        if (tblViaje.getColumnModel().getColumnCount() > 0) {
            tblViaje.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(tfInmueble))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfInmuebleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfInmuebleKeyReleased
        listarInmuebles();
    }//GEN-LAST:event_tfInmuebleKeyReleased

    private void tblViajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViajeMousePressed
        if (tblViaje.getSelectedRow()>=0){
            seleccionado = (Tripla) tblViaje.getValueAt(tblViaje.getSelectedRow(), 0);
            dispose();
        }
    }//GEN-LAST:event_tblViajeMousePressed

    private void tblViajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblViajeKeyPressed
        listarInmuebles();
    }//GEN-LAST:event_tblViajeKeyPressed


    public void listarInmuebles(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblViaje.getModel();        
        while(model.getRowCount()>0) model.removeRow(0);   
        SqlMetodo sql = new SqlMetodo();
        ResultSet rs = SqlMetodo.runQuery("SELECT id_inmueble, direccion_inmueble, tipo_inmueble, piso_departamento, dpto_departamento \n"
                    + " FROM inmobiliaria.inmueble \n"                
                    + " LEFT JOIN inmobiliaria.departamento ON id_inmueble_departamento = id_inmueble \n"
                    + " WHERE  (direccion_inmueble ILIKE '%"+tfInmueble.getText()+"%' OR tipo_inmueble ILIKE '%"+tfInmueble.getText()+"%')\n"
                    + " AND id_inmueble NOT IN (SELECT id_inmueble_contratoalquiler FROM inmobiliaria.contratoalquiler WHERE estado_contratoalquiler = 'Vigente')\n"       
                    + " AND (estado_inmueble='Alquiler-Venta' OR estado_inmueble='Finalizado' OR estado_inmueble='Alquiler' OR estado_inmueble='"+this.estado+"') \n"
                    + " ORDER BY tipo_inmueble;");
        int i=0;
        try {
              while (rs.next()){
                  model.setNumRows(i+1);
                  tblViaje.setModel(model);
                  String direccion = rs.getString("direccion_inmueble")+(rs.getString("tipo_inmueble").equals("Departamento") ? " Piso:"+rs.getString("piso_departamento")+"-"+rs.getString("dpto_departamento") : "");
                  Tripla t = new Tripla(rs.getInt("id_inmueble"), direccion, rs.getString("tipo_inmueble"));
                  tblViaje.setValueAt(t, i, 0);
                  tblViaje.setValueAt(direccion, i, 1);

                  i++;
              }
        } catch (SQLException ex) {
              JFrame frame= new JFrame();
              JOptionPane.showMessageDialog(frame,"Error al listar los inmuebles.","",JOptionPane.WARNING_MESSAGE);
              Datos.Procedimientos.escribirEnLog("Error al listar los inmuebles linea 80: "+ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblViaje;
    private javax.swing.JTextField tfInmueble;
    // End of variables declaration//GEN-END:variables
}
