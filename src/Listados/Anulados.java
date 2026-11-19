/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listados;

import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Damian
 */
public class Anulados extends javax.swing.JFrame {
    private Date desde;
    private Date hasta;
    /**
     * Creates new form Anulados
     */
    public Anulados(Date desde, Date hasta) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        this.desde = desde;
        this.hasta = hasta;
        listarLibroIvaVenta();
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
    
    public void listarLibroIvaVenta(){
        String[] nombCabecera = {"Fecha","Razon Social","Nro. Id.","Tipo Comprobante", "Nro. Comprobante", "Total"};
        String consulta = "Select id, fec, nom, doc, tipo, nro, tot from ((SELECT id_comprobante as id, fecha_comprobante as fec, razonsocial_persona as nom, nrodoc_persona as doc, tipo_comprobante as tipo, "+
        " nro_comprobante as nro, total_comprobante as tot "+
        "FROM inmobiliaria.comprobante inner join inmobiliaria.persona on id_cliente_comprobante = id_persona "+
        "where estado_comprobante='Anulado' order by nro_comprobante, razonsocial_persona) union "
        + "(SELECT id_comprobantealquiler as id, fecha_comprobantealquiler as fec, razonsocial_persona as nom, nrodoc_persona as doc, tipo_comprobantealquiler as tipo, "+
        " nro_comprobantealquiler as nro, total_comprobantealquiler as tot "+
        "FROM inmobiliaria.comprobantealquiler inner join inmobiliaria.contratoalquiler on id_contratoalquiler_comprobantealquiler = id_contratoalquiler\n" +
        "inner join inmobiliaria.persona on id_inquilino_contratoalquiler = id_persona  "+
        "where estado_comprobantealquiler = 'Anulado'  order by razonsocial_persona)) as con order by fec, nom";
        boolean[] cantEdit = new boolean [] {false, false,false,false,false, false};
        construirTablaLibro(nombCabecera, cantEdit,consulta,tblAnulados);
    }
    
    private void construirTablaLibro(String [] nombCabecera, final boolean[] cantEdit ,String consulta,javax.swing.JTable tblListados){
        ResultSet rs = SqlMetodo.runQuery(consulta);
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(new Object [][] {},nombCabecera) {
           boolean[] canEdit = new boolean [] {false, false, false, false, false, false};
           @Override
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
                  tblListados.setValueAt(new Tripla(rs.getInt("id"),null,new SimpleDateFormat("ddMMyyyy").format(rs.getDate("fec"))), i, 0);
                  tblListados.setValueAt(rs.getString("nom").replace("|", ""), i, 1);                
                  tblListados.setValueAt(rs.getString("doc"), i, 2);
                  String tipo = rs.getString("tipo");
                  tblListados.setValueAt(tipo, i, 3);
                  Integer nroComp=rs.getInt("nro");
                  tblListados.setValueAt("0001"+"-"+Datos.Procedimientos.completaConCero((nroComp.toString()),8), i, 4);
                  
                  tblListados.setValueAt(rs.getFloat("tot"), i, 5);                  
                  i++;
              }            
          } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 79 en construirTablaLibro de la Anulados: "+ex.toString());
          }    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnulados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprobantes Anulados");
        setResizable(false);

        panel1.setColorPrimario(new java.awt.Color(0, 102, 102));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        tblAnulados.setBackground(new java.awt.Color(254, 254, 254));
        tblAnulados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblAnulados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAnulados.setGridColor(new java.awt.Color(26, 42, 37));
        tblAnulados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAnulados);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 172 en main de la Anulados: "+ex.toString());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Anulados(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblAnulados;
    // End of variables declaration//GEN-END:variables
}
