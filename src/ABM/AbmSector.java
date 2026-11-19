package ABM;

import Datos.Instancias;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AbmSector extends javax.swing.JFrame {

    public AbmSector() {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnNuevaCategoria = new org.edisoncor.gui.button.ButtonAction();
        tfNombreCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Sectores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel1.setColorPrimario(new java.awt.Color(153, 255, 153));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel1.setOpaque(false);

        tblCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        tblCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCategoriaKeyPressed(evt);
            }
        });
        jScrollPane8.setViewportView(tblCategoria);

        btnNuevaCategoria.setText("+");
        btnNuevaCategoria.setToolTipText("Insertar");
        btnNuevaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevaCategoriaMousePressed(evt);
            }
        });
        btnNuevaCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevaCategoriaKeyPressed(evt);
            }
        });

        tfNombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNombreCategoriaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void tblCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCategoriaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
        {
            eliminarCategoria();
            if (Instancias.getInstance().abmInmuebles != null){
                Datos.Procedimientos.llenarCBSector(Datos.Instancias.getInstance().abmInmuebles.cbSector); 
            }
        }
    }//GEN-LAST:event_tblCategoriaKeyPressed

    private void tfNombreCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreCategoriaKeyPressed
        if(tfNombreCategoria.getText().length()> 29){
            tfNombreCategoria.setText(tfNombreCategoria.getText().substring(0, 29));
        } 
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            nuevaCategoria();
            if (Instancias.getInstance().abmInmuebles != null){
                Datos.Procedimientos.llenarCBSector(Datos.Instancias.getInstance().abmInmuebles.cbSector); 
            }
        }
    }//GEN-LAST:event_tfNombreCategoriaKeyPressed

    private void btnNuevaCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaMousePressed
        // TODO add your handling code here:
        nuevaCategoria();
        if (Instancias.getInstance().abmInmuebles != null){
                Datos.Procedimientos.llenarCBSector(Datos.Instancias.getInstance().abmInmuebles.cbSector); 
            }
    }//GEN-LAST:event_btnNuevaCategoriaMousePressed

    private void btnNuevaCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            nuevaCategoria();
            
        }
    }//GEN-LAST:event_btnNuevaCategoriaKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    public void mostrar(){
        this.refrezcarLista();
        this.tfNombreCategoria.setText("");
        this.tfNombreCategoria.grabFocus();
        this.setVisible(true);
    }
    public void refrezcarLista(){
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel)this.tblCategoria.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
        java.sql.ResultSet rsCategoria = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_sector, nombre_sector \n" +
                                                                        "  FROM inmobiliaria.sector;");
        try{
            while (rsCategoria.next()){
                modelo.setNumRows(this.tblCategoria.getModel().getRowCount() + 1);
                this.tblCategoria.setModel(modelo);
                Objetos.Tripla t = new Objetos.Tripla(rsCategoria.getString(1),null,rsCategoria.getString(2));
                this.tblCategoria.setValueAt(t, this.tblCategoria.getModel().getRowCount()-1, 0);
            }    
        } catch (java.sql.SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 215 metodo refrezcarLista en la clase AbmSector.java: "+ex);
        } 
    }
    private boolean categoriaPerteneceATabla(String elem){
        for (int i=0; i<this.tblCategoria.getRowCount(); i++){
            Objetos.Tripla t = (Objetos.Tripla) this.tblCategoria.getValueAt(i, 0);
            if (((String)t.getTercero()).toUpperCase().equals(elem.toUpperCase()))
                return true;
        }       
        return false;
    }    
    private void nuevaCategoria(){
        if (!this.tfNombreCategoria.getText().isEmpty()){
            if (!this.categoriaPerteneceATabla(this.tfNombreCategoria.getText().trim())){
                ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.sector(nombre_sector)\n" +
                                "    VALUES ('"+ this.tfNombreCategoria.getText().trim() +"');");
                java.sql.ResultSet ultimo = ProcedimientosSQL.SqlMetodo.runQuery("SELECT MAX(id_sector) FROM inmobiliaria.sector;");
                try{
                    if (ultimo.next()){
                        Objetos.Tripla nuevaCategoria = new Objetos.Tripla(ultimo.getInt(1),null,this.tfNombreCategoria.getText());
                        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) this.tblCategoria.getModel();
                        modelo.setNumRows(this.tblCategoria.getModel().getRowCount() + 1);
                        this.tblCategoria.setModel(modelo);
                        this.tblCategoria.setValueAt(nuevaCategoria, this.tblCategoria.getModel().getRowCount()-1, 0);
                        if (Datos.Instancias.getInstance().abmInmuebles != null)
                            Datos.Procedimientos.llenarCBSector(Datos.Instancias.getInstance().abmInmuebles.cbSector);
                    }   
                } catch (java.sql.SQLException ex) {
                    Datos.Procedimientos.escribirEnLog("Error en linea 243 metodo nuevaCategoria en la clase AbmSector.java: "+ex);
                }
                this.tfNombreCategoria.setText("");
                this.tfNombreCategoria.grabFocus();
            }    
        }
    }
    private void eliminarCategoria(){
        int row = this.tblCategoria.getSelectedRow();
        if (row > -1){
            Objetos.Tripla t = (Objetos.Tripla) this.tblCategoria.getValueAt(row, 0);
            ProcedimientosSQL.SqlMetodo.runQuery("DELETE FROM inmobiliaria.sector WHERE id_sector = "+t.getPrimero()+";");
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel)this.tblCategoria.getModel();
            int ant = tblCategoria.getRowCount();
            refrezcarLista();          
            if (ant==tblCategoria.getRowCount()){
                JOptionPane.showMessageDialog(this,"No puede eliminar sectores utilizadas por inmuebles");
            }
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnNuevaCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane8;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField tfNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
