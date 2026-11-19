package Consulta;

import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ElegirCliente extends javax.swing.JDialog {

    String tipo;
    public Tripla seleccionado;
    
    public ElegirCliente(java.awt.Frame parent, boolean modal) {
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
        this.tipo = tipo;
        seleccionado = null;
        listarClientes();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCliente = new javax.swing.JList();
        tfCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elegir Cliente");

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo2.jpg"))); // NOI18N

        lstCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lstCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstCliente);

        tfCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void lstClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClienteMousePressed
        int i= lstCliente.getSelectedIndex();
        if(i>=0){
            seleccionado = (Tripla) lstCliente.getSelectedValue();
            dispose();
        }        

    }//GEN-LAST:event_lstClienteMousePressed

    private void tfClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfClienteKeyReleased
        // TODO add your handling code here:
        DefaultListModel modelo = new DefaultListModel();
        SqlMetodo sql = new SqlMetodo();
        ResultSet rs = sql.getByWhere("inmobiliaria.persona ","tipo_persona = '"+tipo+"' \n"
            + "and estado_persona = 'TRUE' and tipo_persona<>'Titular' and tipo_persona<>'Administrador' \n"
            + "and razonsocial_persona ILIKE '%"+tfCliente.getText()+"%' order by razonsocial_persona");
        int i=0;
        try {
            while (rs.next()){
                modelo.add(i, new Tripla(rs.getString("id_persona"), "", rs.getString("razonsocial_persona")));                               
                i++;
            }
            lstCliente.setModel(modelo);
        } catch (SQLException ex) {
            JFrame frame= new JFrame();
            JOptionPane.showMessageDialog(frame,"Error al listar los clientes.","",JOptionPane.WARNING_MESSAGE);
            Datos.Procedimientos.escribirEnLog("Error al listar los clientes linea 184: "+ex);
        }
    }//GEN-LAST:event_tfClienteKeyReleased

     
    public void listarClientes(){
      DefaultListModel modelo = new DefaultListModel();
      SqlMetodo sql = new SqlMetodo();
      ResultSet rs = null;
      rs = sql.getByWhere("inmobiliaria.persona ",
        "tipo_persona = '"+tipo+"' and estado_persona = 'TRUE' and tipo_persona<>'Titular' and tipo_persona<>'Administrador' order by razonsocial_persona");
      int i=0; 
        try {
            while (rs.next()){
                modelo.add(i, new Tripla(rs.getString("id_persona"), "", rs.getString("razonsocial_persona")));                               
                i++;
            }
            lstCliente.setModel(modelo);      
        } catch (SQLException ex) {
            JFrame frame= new JFrame();
            JOptionPane.showMessageDialog(frame,"Error al listar los clientes.","",JOptionPane.WARNING_MESSAGE);
            Datos.Procedimientos.escribirEnLog("Error al listar los clientes linea 79: "+ex);
        }
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstCliente;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField tfCliente;
    // End of variables declaration//GEN-END:variables
}
