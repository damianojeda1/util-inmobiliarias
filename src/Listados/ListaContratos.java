package Listados;

import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListaContratos extends javax.swing.JFrame {

    public ListaContratos() {
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
        
        this.tblAlquiler.setDefaultRenderer(Object.class, new ColoresTablaContratoA());
    }
    
    public void mostrar(){
        llenarTablaContratosA();
        listarContratosV("");
        this.setVisible(true);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tabbedPaneHeader1 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlquiler = new javax.swing.JTable();
        panel3 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        btnNuevo = new org.edisoncor.gui.button.ButtonAction();
        btnMovimientos = new org.edisoncor.gui.button.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        tfBuscar = new javax.swing.JTextField();
        chkVerTodos = new javax.swing.JCheckBox();
        btnServicios = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contratos");

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo2.jpg"))); // NOI18N

        tabbedPaneHeader1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneHeader1StateChanged(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        tblAlquiler.setBackground(new java.awt.Color(254, 254, 254));
        tblAlquiler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblAlquiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Inmueble", "Inquilino", "Estado", "Debe", "Importe", "Servicios", "Importe Actual", "Fecha Creación", "Fin Contrato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlquiler.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAlquiler.setGridColor(new java.awt.Color(26, 42, 37));
        tblAlquiler.setRowHeight(20);
        tblAlquiler.getTableHeader().setReorderingAllowed(false);
        tblAlquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlquilerMouseClicked(evt);
            }
        });
        tblAlquiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAlquilerKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblAlquiler);
        if (tblAlquiler.getColumnModel().getColumnCount() > 0) {
            tblAlquiler.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAlquiler.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        tabbedPaneHeader1.addTab("Contratos Alquiler", panel2);
        panel2.getAccessibleContext().setAccessibleName("");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        tblVenta.setBackground(new java.awt.Color(254, 254, 254));
        tblVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblVenta.setGridColor(new java.awt.Color(26, 42, 37));
        tblVenta.setRowHeight(20);
        tblVenta.getTableHeader().setReorderingAllowed(false);
        tblVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVenta);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        tabbedPaneHeader1.addTab("Contratos Venta", panel3);

        btnNuevo.setText("Nuevo");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevoMousePressed(evt);
            }
        });

        btnMovimientos.setText("Ver Movimientos");
        btnMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMovimientosMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar: ");

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        chkVerTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkVerTodos.setForeground(new java.awt.Color(255, 255, 255));
        chkVerTodos.setText("Incluir rescindidos y finalizados");
        chkVerTodos.setContentAreaFilled(false);
        chkVerTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkVerTodosMouseReleased(evt);
            }
        });

        btnServicios.setText("Pres. Servicios");
        btnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnServiciosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkVerTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkVerTodos)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
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

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        // TODO add your handling code here:
        if (this.tabbedPaneHeader1.getSelectedIndex()==0){
            if (Datos.Instancias.getInstance().abmContratoA == null)
               Datos.Instancias.getInstance().abmContratoA = new ABM.ABMContratoA();    
            Datos.Instancias.getInstance().abmContratoA.mostrar();
        } else {
            if (Datos.Instancias.getInstance().abmContratoV == null)
               Datos.Instancias.getInstance().abmContratoV = new ABM.ABMContratoV();    
            Datos.Instancias.getInstance().abmContratoV.mostrar();
        }
    }//GEN-LAST:event_btnNuevoMousePressed

    private void tblAlquilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlquilerMouseClicked
        if (evt.getClickCount() == 2) {
            if (Datos.Instancias.getInstance().abmContratoA == null)
                Datos.Instancias.getInstance().abmContratoA = new ABM.ABMContratoA();
            Datos.Instancias.getInstance().abmContratoA.editar(Integer.parseInt(tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0).toString()));
        }
    }//GEN-LAST:event_tblAlquilerMouseClicked

    
    private void tblAlquilerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlquilerKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            if(tblAlquiler.getSelectedRow()>=0){
                int fila = tblAlquiler.getSelectedRow();
                String estado = tblAlquiler.getValueAt(fila, 3).toString();
                if(estado.equals("Rescindido")){
                    eliminarContratoA();
                }else{
                    JOptionPane.showMessageDialog(this, "El contrato debe estar rescindido para eliminarlo");
                }               
            }
    }//GEN-LAST:event_tblAlquilerKeyPressed

    private void tblVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            if(tblVenta.getSelectedRow()>=0)
                eliminarContratoV();
        
    }//GEN-LAST:event_tblVentaKeyPressed

    private void btnMovimientosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosMousePressed
        int fila = tblAlquiler.getSelectedRow();
        if (fila > -1){
            int id = Integer.parseInt(tblAlquiler.getValueAt(fila, 0).toString());
            if (Datos.Instancias.getInstance().cuentaCorriente == null)
                Datos.Instancias.getInstance().cuentaCorriente = new Contabilidad.CuentaCorriente();
            Datos.Instancias.getInstance().cuentaCorriente.mostrar(id,tblAlquiler.getValueAt(fila, 3).toString());
        }            
    }//GEN-LAST:event_btnMovimientosMousePressed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        // TODO add your handling code here:
        if (this.tabbedPaneHeader1.getSelectedIndex()==0)
            llenarTablaContratosA();
        else
            listarContratosV("  WHERE UPPER(direccion_inmueble) LIKE '%"+this.tfBuscar.getText().toUpperCase()+"%' OR UPPER(razonsocial_persona) LIKE '%"+this.tfBuscar.getText().toUpperCase()+"%'\n");
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void tabbedPaneHeader1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneHeader1StateChanged
        if(tabbedPaneHeader1.getSelectedIndex() == 1){
            btnMovimientos.setVisible(false);
            btnServicios.setVisible(false);
        } else {
            btnMovimientos.setVisible(true);
            btnServicios.setVisible(true);
        }
    }//GEN-LAST:event_tabbedPaneHeader1StateChanged

    private void chkVerTodosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkVerTodosMouseReleased
        llenarTablaContratosA();
    }//GEN-LAST:event_chkVerTodosMouseReleased

    private void btnServiciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiciosMousePressed
        int fila = tblAlquiler.getSelectedRow();
        if (fila > -1){
            int id = Integer.parseInt(tblAlquiler.getValueAt(fila, 0).toString());
            if (Datos.Instancias.getInstance().presentacionServicios == null)
                Datos.Instancias.getInstance().presentacionServicios = new Listados.PresentacionServicios();
            Datos.Instancias.getInstance().presentacionServicios.mostrar(id);
        }         
    }//GEN-LAST:event_btnServiciosMousePressed

    private void eliminarContratoA(){
        String consulta = "SELECT * FROM inmobiliaria.comprobantealquiler "
                + "INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler_comprobantealquiler = id_contratoalquiler"
                + " WHERE nro_contratoalquiler = "+ tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0);
        ResultSet rs = SqlMetodo.runQuery(consulta);
        try {
            if (rs.next())
                JOptionPane.showMessageDialog(this, "Contrato de alquiler Nro.: "+tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0)+" contiene comprobantes asociados, no puede eleminarse.");
            else{
                String sql = "DELETE FROM inmobiliaria.garantea\n" +
                        " WHERE id_contrato_garantea = (SELECT id_contratoalquiler FROM inmobiliaria.contratoalquiler WHERE nro_contratoalquiler = "+tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0)+");";
                SqlMetodo.runQuery(sql);
                String query = "DELETE FROM inmobiliaria.contratoalquiler\n" +
                        " WHERE nro_contratoalquiler = " +tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0);
                SqlMetodo.runQuery(query);
                JOptionPane.showMessageDialog(this, "Contrato de alquiler Nro.: "+tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 0)+" eliminado exitosamente.");
                llenarTablaContratosA();
            }
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 306 en eliminarContratoA de la ListaContratos: "+ex.toString());
        }
    }
    private void eliminarContratoV(){
        String sql = "DELETE FROM inmobiliaria.garantev\n" +
                     " WHERE id_contrato_garantev = (SELECT id_contratoventa FROM inmobiliaria.contratoventa WHERE nro_contratoventa = "+tblVenta.getValueAt(tblVenta.getSelectedRow(), 0)+");";
        SqlMetodo.runQuery(sql);
        String query = "DELETE FROM inmobiliaria.contratoventa\n" +
                     " WHERE nro_contratoventa = " +tblVenta.getValueAt(tblVenta.getSelectedRow(), 0);
        SqlMetodo.runQuery(query);
        JOptionPane.showMessageDialog(this, "Contrato de venta Nro.: "+tblVenta.getValueAt(tblVenta.getSelectedRow(), 0)+" eliminado exitosamente.");
        listarContratosV("");
    }

    public void listarContratosV(String condicion){
        String[] nombCabecera = {"Número", "Inmueble", "Comprador", "Estado", "Monto", "Fecha Contrato"};
        String consulta = "SELECT nro_contratoventa, direccion_inmueble, razonsocial_persona, estado_contratoventa, \n"+ 
                " monto_contratoventa, fecha_contratoventa FROM inmobiliaria.contratoventa \n" +
                " INNER JOIN inmobiliaria.inmueble ON id_inmueble=id_inmueble_contratoventa \n" +
                " INNER JOIN inmobiliaria.persona ON id_persona=id_comprador_contratoventa \n" + 
                condicion +
                " ORDER BY fecha_contratoventa";
        boolean[] cantEdit = new boolean [] {false, false,false,false,false, false};
        construirTablaContrato(nombCabecera, cantEdit,consulta,tblVenta);
        
    }
    
    public void llenarTablaContratosA(){
        try {
            String condicion = "";
            
            if (!this.tfBuscar.getText().isEmpty()){
                condicion = " WHERE "
                        + " UPPER(direccion_inmueble) LIKE '%"+this.tfBuscar.getText().toUpperCase()+"%' \n"
                        + " OR UPPER(razonsocial_persona) LIKE '%"+this.tfBuscar.getText().toUpperCase()+"%'\n"
                        + (chkVerTodos.isSelected() ? "" : " AND estado_contratoalquiler='Vigente'");
            } else {
                condicion = (chkVerTodos.isSelected() ? "" : " WHERE estado_contratoalquiler='Vigente'");
            }
            
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblAlquiler.getModel();
            while(modelo.getRowCount()>0)modelo.removeRow(0);  
            
            String consulta = "SELECT nro_contratoalquiler, direccion_inmueble, razonsocial_persona, estado_contratoalquiler, monto_contratoalquiler, proximocobro_contratoalquiler, reajuste_contratoalquiler, tiemporeajuste_contratoalquiler, \n" +
                " montoactual_contratoalquiler, recargo_contratoalquiler, diavencimiento_contratoalquiler, fecha_contratoalquiler, \n" +
                " fin_contratoalquiler, \n" +
                "   (SELECT COUNT(*) \n" +
                "      FROM inmobiliaria.serviciocomprobante \n" +
                "      WHERE estado_serviciocomprobante = 0 \n" +
                "         AND id_comprobante_serviciocomprobante IN (SELECT id_comprobantealquiler FROM inmobiliaria.comprobantealquiler WHERE id_contratoalquiler_comprobantealquiler = id_contratoalquiler) ) as servicios\n" +
                " FROM inmobiliaria.contratoalquiler \n" +
                " INNER JOIN inmobiliaria.inmueble ON id_inmueble=id_inmueble_contratoalquiler \n" +
                " INNER JOIN inmobiliaria.persona ON id_persona=id_inquilino_contratoalquiler " +
                condicion + 
                " ORDER BY razonsocial_persona ASC ";
            
            ResultSet rs = SqlMetodo.runQuery(consulta);
            while (rs.next()){
                modelo.setNumRows(tblAlquiler.getModel().getRowCount() + 1);
                tblAlquiler.setModel(modelo);

                tblAlquiler.setValueAt(rs.getInt("nro_contratoalquiler"), tblAlquiler.getModel().getRowCount()-1, 0);  
                tblAlquiler.setValueAt(rs.getString("direccion_inmueble"), tblAlquiler.getModel().getRowCount()-1, 1);  
                tblAlquiler.setValueAt(rs.getString("razonsocial_persona"), tblAlquiler.getModel().getRowCount()-1, 2);  
                tblAlquiler.setValueAt(rs.getString("estado_contratoalquiler"), tblAlquiler.getModel().getRowCount()-1, 3);
                tblAlquiler.setValueAt(new SimpleDateFormat("MM/yyyy").format(rs.getDate("proximocobro_contratoalquiler")), tblAlquiler.getModel().getRowCount()-1, 4);                
                tblAlquiler.setValueAt(rs.getString("monto_contratoalquiler"), tblAlquiler.getModel().getRowCount()-1, 5);  
                tblAlquiler.setValueAt((rs.getInt("servicios")>0)?"DEBE":"OK", tblAlquiler.getModel().getRowCount()-1, 6);  
                tblAlquiler.setValueAt(rs.getString("montoactual_contratoalquiler"), tblAlquiler.getModel().getRowCount()-1, 7);  
                tblAlquiler.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha_contratoalquiler")), tblAlquiler.getModel().getRowCount()-1, 8);
                tblAlquiler.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fin_contratoalquiler")), tblAlquiler.getModel().getRowCount()-1, 9);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void construirTablaContrato(String [] nombCabecera, final boolean[] cantEdit ,String consulta,javax.swing.JTable tblListados){
        ResultSet rs = SqlMetodo.runQuery(consulta);
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(new Object [][] {},nombCabecera) {
           boolean[] canEdit = cantEdit;
           public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
           }
        };
        modelo.setColumnCount(nombCabecera.length);
        int i = 0;
        tblListados.setModel(modelo);
        try {
            while(rs.next()){                  
                  modelo.setNumRows(i + 1);
                  tblListados.setModel(modelo);
                  for(int j=0; j < nombCabecera.length; j++){
                    tblListados.setValueAt(rs.getObject(j + 1), i, j);
                  }
                  i++;
              }
            
          } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 367 en construirTablaContrato de la ListaContratos: "+ex.toString());
          }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnMovimientos;
    private org.edisoncor.gui.button.ButtonAction btnNuevo;
    private org.edisoncor.gui.button.ButtonAction btnServicios;
    private javax.swing.JCheckBox chkVerTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader1;
    private javax.swing.JTable tblAlquiler;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
