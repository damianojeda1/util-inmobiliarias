package ABM;

import Consulta.ElegirCliente;
import Datos.Instancias;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ABMContratoA extends javax.swing.JFrame {

    private java.util.Date fechaProximoCobro;
    private boolean editado=false;
    private int id = -1;
    private Date FechaContratoOriginal;
    
    private Tripla inmueble;

    public ABMContratoA() {
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

        grupoHonorarios = new javax.swing.ButtonGroup();
        grupoRecargo = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        btnInquilino = new org.edisoncor.gui.button.ButtonAction();
        jLabel2 = new javax.swing.JLabel();
        btnInmueble = new org.edisoncor.gui.button.ButtonAction();
        tfTipo = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        btnGarante = new org.edisoncor.gui.button.ButtonAction();
        jLabel17 = new javax.swing.JLabel();
        btnGuardar = new org.edisoncor.gui.button.ButtonAction();
        jLabel20 = new javax.swing.JLabel();
        jscroll = new javax.swing.JScrollPane();
        taObs = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGarante = new javax.swing.JTable();
        btnAgregarGarante = new org.edisoncor.gui.button.ButtonAction();
        btnAgregarInquilino = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInquilino = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfNro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechaFinContrato = new com.toedter.calendar.JDateChooser();
        tfDeposito = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        FechaContrato = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        tfComision = new javax.swing.JTextField();
        rbtnHonorariosPorc = new javax.swing.JRadioButton();
        rbtnHonorariosEfe = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfMonto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jsDia = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        tfReajusteAlq = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfRecargo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jsMesesReajuste = new javax.swing.JSpinner();
        rbtnRecargoPorc = new javax.swing.JRadioButton();
        rbtnRecargoEfe = new javax.swing.JRadioButton();
        btnActualizarImportes = new org.edisoncor.gui.button.ButtonAction();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVerInmueble = new org.edisoncor.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrato Alquiler");
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inquilino");

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
        });

        tfDireccion.setEditable(false);
        tfDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGarante.setText("Buscar");
        btnGarante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGarante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGaranteMousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Garante");

        btnGuardar.setText("Guardar Contrato");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Observaciones");

        jscroll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        taObs.setColumns(20);
        taObs.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taObs.setLineWrap(true);
        taObs.setRows(5);
        jscroll.setViewportView(taObs);

        tblGarante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblGarante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Garantes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGarante.setRowHeight(18);
        tblGarante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGaranteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGarante);

        btnAgregarGarante.setText("Nuevo");
        btnAgregarGarante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarGarante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarGaranteMousePressed(evt);
            }
        });

        btnAgregarInquilino.setText("Nuevo");
        btnAgregarInquilino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarInquilino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarInquilinoMousePressed(evt);
            }
        });

        tblInquilino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblInquilino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inquilino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInquilino.setRowHeight(18);
        tblInquilino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblInquilinoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblInquilino);

        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nro. Contrato");

        tfNro.setEditable(false);
        tfNro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfNro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fin Contrato");

        fechaFinContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfDeposito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfDeposito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Depósito");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("$");
        jLabel22.setToolTipText("");

        FechaContrato.setDateFormatString("MM/yyyy");
        FechaContrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Contrato");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");

        cbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vigente ", "Rescindido ", "Finalizado" }));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Honorarios");

        tfComision.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfComision.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        grupoHonorarios.add(rbtnHonorariosPorc);
        rbtnHonorariosPorc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnHonorariosPorc.setForeground(new java.awt.Color(255, 255, 255));
        rbtnHonorariosPorc.setSelected(true);
        rbtnHonorariosPorc.setText("%");
        rbtnHonorariosPorc.setOpaque(false);

        grupoHonorarios.add(rbtnHonorariosEfe);
        rbtnHonorariosEfe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnHonorariosEfe.setForeground(new java.awt.Color(255, 255, 255));
        rbtnHonorariosEfe.setText("$");
        rbtnHonorariosEfe.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnHonorariosPorc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnHonorariosEfe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfComision, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, 0, 126, Short.MAX_VALUE)
                            .addComponent(FechaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNro)
                            .addComponent(fechaFinContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDeposito)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FechaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fechaFinContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbEstado)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnHonorariosPorc)
                        .addComponent(rbtnHonorariosEfe))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(tfComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Importe");

        tfMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Día  vencimiento");
        jLabel8.setToolTipText("");

        jsDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jsDia.setModel(new javax.swing.SpinnerNumberModel(10, 1, 31, 1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reajuste");

        tfReajusteAlq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfReajusteAlq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("%");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("?");
        jLabel9.setToolTipText("Día de vencimiento de pago de alquiler");

        tfRecargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfRecargo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRecargo.setText("1");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("?");
        jLabel11.setToolTipText("Recargo por día de retraso en pago de alquier");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Recargo");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Meses Reajuste");

        jsMesesReajuste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jsMesesReajuste.setModel(new javax.swing.SpinnerNumberModel(6, 1, 12, 1));

        grupoRecargo.add(rbtnRecargoPorc);
        rbtnRecargoPorc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnRecargoPorc.setForeground(new java.awt.Color(255, 255, 255));
        rbtnRecargoPorc.setSelected(true);
        rbtnRecargoPorc.setText("%");
        rbtnRecargoPorc.setOpaque(false);

        grupoRecargo.add(rbtnRecargoEfe);
        rbtnRecargoEfe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnRecargoEfe.setForeground(new java.awt.Color(255, 255, 255));
        rbtnRecargoEfe.setText("$");
        rbtnRecargoEfe.setOpaque(false);

        btnActualizarImportes.setText("Definir");
        btnActualizarImportes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizarImportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarImportesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnActualizarImportesMouseReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Act. Importes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(25, 25, 25)
                                .addComponent(jsDia, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnRecargoPorc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnRecargoEfe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRecargo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnActualizarImportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(jsMesesReajuste, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(tfReajusteAlq)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnRecargoPorc)
                        .addComponent(rbtnRecargoEfe))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfRecargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jsMesesReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReajusteAlq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarImportes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVerInmueble.setBackground(new java.awt.Color(255, 255, 51));
        btnVerInmueble.setText("Ver Inmueble");
        btnVerInmueble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerInmuebleMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnVerInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGarante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarGarante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGarante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarGarante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnInquilinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInquilinoMousePressed
        if (btnInquilino.isEnabled()){
            ElegirCliente ec = new ElegirCliente(this, true);
            ec.mostrar("Cliente");
            if (ec.seleccionado!=null){
                if (Datos.Procedimientos.perteneceATabla(ec.seleccionado, this.tblInquilino, 0) > -1){
                    JOptionPane.showMessageDialog(this, "Ya cargó ese cliente");
                } else if (Datos.Procedimientos.perteneceATabla(ec.seleccionado, this.tblGarante, 0) > -1){ 
                    JOptionPane.showMessageDialog(this, "No se puede seleccionar como inquilino un garante");               
                } else {
                    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) this.tblInquilino.getModel();
                    modelo.setNumRows(this.tblInquilino.getModel().getRowCount() + 1);
                    this.tblInquilino.setModel(modelo);
                    this.tblInquilino.setValueAt(ec.seleccionado, this.tblInquilino.getModel().getRowCount()-1, 0);
                } 
            }
        }
    }//GEN-LAST:event_btnInquilinoMousePressed

    private void btnInmuebleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInmuebleMousePressed
        if(btnInmueble.isEnabled()){
            Consulta.ElegirInmueble ec = new Consulta.ElegirInmueble(this, true);
            ec.mostrar("Alquiler");
            if (ec.seleccionado!=null){
                inmueble = ec.seleccionado;
                ResultSet rs = SqlMetodo.runQuery("SELECT id_propietario_inmueble, valoralquiler_inmueble "
                        + "FROM inmobiliaria.inmueble WHERE id_inmueble = "+inmueble.getPrimero());
                ResultSet rs2 = SqlMetodo.runQuery("SELECT COALESCE(MAX(nro_contratoalquiler), 0)+1 FROM inmobiliaria.contratoalquiler");
                try {
                    if (rs.next()){
                        tfMonto.setText(rs.getFloat(2)+"");
                    }
                    if (rs2.next()){
                        tfNro.setText(Integer.toString(rs2.getInt(1)));
                    }else{
                        tfNro.setText("0");
                    }
                    tfTipo.setText(inmueble.getTercero().toString());
                    tfDireccion.setText(inmueble.getSegundo().toString());
                    editable(true);
                } catch (SQLException ex) {
                    Datos.Procedimientos.escribirEnLog("Falló consulta en evento: tfTipoKeyPressed - de la clase ABMContratoA.java: ->"+ex);
                }

            }
        }
    }//GEN-LAST:event_btnInmuebleMousePressed

    private void btnGaranteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGaranteMousePressed
        if (btnGarante.isEnabled()){
            ElegirCliente ec = new ElegirCliente(this, true);
            ec.mostrar("Cliente");
            if (ec.seleccionado!=null){
                if (Datos.Procedimientos.perteneceATabla(ec.seleccionado, this.tblGarante, 0) > -1){
                    JOptionPane.showMessageDialog(this, "Ya cargó ese garante");
                } else if (Datos.Procedimientos.perteneceATabla(ec.seleccionado, this.tblInquilino, 0) > -1){ 
                    JOptionPane.showMessageDialog(this, "No se puede seleccionar el inquilino como garante");
                } else {
                    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) this.tblGarante.getModel();
                    modelo.setNumRows(this.tblGarante.getModel().getRowCount() + 1);
                    this.tblGarante.setModel(modelo);
                    this.tblGarante.setValueAt(ec.seleccionado, this.tblGarante.getModel().getRowCount()-1, 0);
                } 
            }
        }
    }//GEN-LAST:event_btnGaranteMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        almacenar();
    }//GEN-LAST:event_btnGuardarMousePressed

    private void tfTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipoKeyPressed
  
    }//GEN-LAST:event_tfTipoKeyPressed

    private void btnAgregarGaranteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarGaranteMousePressed
        AltaPersona ap = new AltaPersona(this, true);
        ap.mostrar("");
        if (ap.idPersona>0){
            Tripla nuevo = new Tripla(""+ap.idPersona, "", ap.tfNombre.getText());
            if (Datos.Procedimientos.perteneceATabla(nuevo, this.tblGarante, 0) > -1){
                JOptionPane.showMessageDialog(this, "Ya cargó ese garante");
            } else {                
                javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) this.tblGarante.getModel();
                modelo.setNumRows(this.tblGarante.getModel().getRowCount() + 1);
                this.tblGarante.setModel(modelo);
                this.tblGarante.setValueAt(nuevo, this.tblGarante.getModel().getRowCount()-1, 0);

            }
        }
    }//GEN-LAST:event_btnAgregarGaranteMousePressed

    private void tblGaranteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGaranteKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            if(tblGarante.getSelectedRow()>=0)
                eliminarGarante();
    }//GEN-LAST:event_tblGaranteKeyPressed

    private void btnAgregarInquilinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarInquilinoMousePressed
        AltaPersona ap = new AltaPersona(this, true);
        ap.mostrar("");
        if (ap.idPersona>0){
            Tripla nuevo = new Tripla(""+ap.idPersona, "", ap.tfNombre.getText());
            if (Datos.Procedimientos.perteneceATabla(nuevo, this.tblInquilino, 0) > -1){
                JOptionPane.showMessageDialog(this, "Ya cargó ese cliente");
            } else {
                javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) this.tblInquilino.getModel();
                modelo.setNumRows(this.tblInquilino.getModel().getRowCount() + 1);
                this.tblInquilino.setModel(modelo);
                this.tblInquilino.setValueAt(nuevo, this.tblInquilino.getModel().getRowCount()-1, 0);
            }
        }
    }//GEN-LAST:event_btnAgregarInquilinoMousePressed

    private void tblInquilinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInquilinoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && !editado)
            if(tblInquilino.getSelectedRow()>=0)
                eliminarInquilino();
    }//GEN-LAST:event_tblInquilinoKeyPressed

    private void btnVerInmuebleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerInmuebleMousePressed
        if (inmueble!=null){
            if (Datos.Instancias.getInstance().abmInmuebles == null){
                Datos.Instancias.getInstance().abmInmuebles = new ABMInmuebles();
            }
            Datos.Instancias.getInstance().abmInmuebles.editar(inmueble.getPrimero().toString());
        }
    }//GEN-LAST:event_btnVerInmuebleMousePressed

    private void btnActualizarImportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarImportesMousePressed
        if (editado){
            SqlMetodo.runQuery("DELETE FROM inmobiliaria.importealquiler WHERE id_contratoalquiler_importealquiler="+id);
            ajustarImporteAlquiler(this, id);
        }
    }//GEN-LAST:event_btnActualizarImportesMousePressed

    private void btnActualizarImportesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarImportesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarImportesMouseReleased
    
    private void eliminarGarante(){
        int fila = tblGarante.getSelectedRow();
        if (editado){
            SqlMetodo.runQuery("DELETE FROM inmobiliaria.garantea WHERE id_garante_garantea="+((Tripla) this.tblGarante.getValueAt(fila, 0)).getPrimero()+" AND id_contrato_garantea="+id);
        }
        DefaultTableModel modelo = (DefaultTableModel)tblGarante.getModel();
        modelo.removeRow(fila);
        tblGarante.setModel(modelo);    
        
    }

    private void eliminarInquilino(){
        int fila = tblInquilino.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel)tblInquilino.getModel();
        modelo.removeRow(fila);
        tblInquilino.setModel(modelo);        
    }
    
    private void almacenar(){
        if (!editado){
            if ( controles()){
                String sql = "INSERT INTO inmobiliaria.contratoalquiler(\n" +
                        "nro_contratoalquiler, observacion_contratoalquiler, \n" +
                        "path_contratoalquiler, estado_contratoalquiler, diavencimiento_contratoalquiler, \n" +
                        "monto_contratoalquiler, recargo_contratoalquiler, reajuste_contratoalquiler, \n" +
                        "tiemporeajuste_contratoalquiler, montoactual_contratoalquiler, \n" +
                        "comision_contratoalquiler, fecha_contratoalquiler, fin_contratoalquiler, \n" +
                        "id_inmueble_contratoalquiler, id_inquilino_contratoalquiler, proximoajuste_contratoalquiler,\n" +
                        "deposito_contratoalquiler, proximocobro_contratoalquiler, tipo_comision_contratoalquiler, tipo_recargo_contratoalquiler)\n" +
                        " VALUES ( "+tfNro.getText()+", '"+taObs.getText()+"', \n" +
                        " '', '"+cbEstado.getSelectedItem().toString().trim()+"', '"+jsDia.getValue()+"', \n" +
                        " "+tfMonto.getText()+", "+tfRecargo.getText()+", "+tfReajusteAlq.getText()+", \n" +
                        " "+jsMesesReajuste.getValue()+", "+tfMonto.getText()+", \n" +
                        " "+tfComision.getText()+", '"+FechaContrato.getDate()+"', '"+fechaFinContrato.getDate()+"', \n" +
                        " "+inmueble.getPrimero()+", "+((Tripla) this.tblInquilino.getValueAt(0,0)).getPrimero()+", date '"+FechaContrato.getDate()+"' + interval '"+jsMesesReajuste.getValue()+" month'," +
                        " "+tfDeposito.getText()+", '"+this.fechaProximoCobro+"', "+(rbtnHonorariosPorc.isSelected()? "1":"2")+", "+(rbtnRecargoPorc.isSelected()? "1":"2")+");";
                SqlMetodo.runQuery(sql);
                String consulta = "UPDATE inmobiliaria.inmueble SET estado_inmueble = '"+cbEstado.getSelectedItem().toString().trim()+"' WHERE id_inmueble = "+inmueble.getPrimero();
                SqlMetodo.runQuery(consulta);
                int idContrato = Datos.Procedimientos.obtenerUltimo("id_contratoalquiler", "contratoalquiler");
                for (int i=0; i<tblGarante.getRowCount(); i++){
                    String query = "INSERT INTO inmobiliaria.garantea(\n" +
                    "id_garante_garantea, id_contrato_garantea)\n" +
                    "VALUES ( "+((Tripla) this.tblGarante.getValueAt(i, 0)).getPrimero()+", "+idContrato+");";
                    SqlMetodo.runQuery(query);
                }
                for (int i=1; i<tblInquilino.getRowCount(); i++){
                    String query = "INSERT INTO inmobiliaria.inquilinosAdicionales(\n" +
                    "id_contratoalquiler_inquilinosAdicionales, id_inquilino_inquilinosAdicionales)\n" +
                    "VALUES ( "+idContrato+" , "+((Tripla) this.tblInquilino.getValueAt(i, 0)).getPrimero()+");";
                    SqlMetodo.runQuery(query);
                }
                 
                ajustarImporteAlquiler(this, idContrato);
                
                JOptionPane.showMessageDialog(this, "Contrato almacenado exitosamente");
                Instancias.getInstance().listaContratos.llenarTablaContratosA();
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("Alquiler");
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("AlquilerTodos");
                limpiar();
                editable(false);
                btnInmueble.setEnabled(true);
            }   
        }
        else {
            if ( controles()){
                String sql="UPDATE inmobiliaria.contratoalquiler\n" +
                "   SET estado_contratoalquiler='"+cbEstado.getSelectedItem().toString().trim()+"',\n"
                        + " monto_contratoalquiler = "+tfMonto.getText()+",\n"
                        //+ " montoActual_contratoalquiler = "+tfMonto.getText()+",\n"
                        + " comision_contratoalquiler = "+tfComision.getText()+",\n"
                        + " reajuste_contratoalquiler = "+tfReajusteAlq.getText()+",\n"
                        + " tiemporeajuste_contratoalquiler = "+jsMesesReajuste.getValue()+",\n"
                        + " diavencimiento_contratoalquiler = "+jsDia.getValue()+",\n"
                        + " recargo_contratoalquiler = "+tfRecargo.getText()+",\n"
                        + " observacion_contratoalquiler = '"+taObs.getText()+"',\n"
                        + " fecha_contratoalquiler = '"+FechaContrato.getDate()+"',\n"
                        + " fin_contratoalquiler = '"+fechaFinContrato.getDate()+"',\n"
                        + " proximoajuste_contratoalquiler =  date '"+FechaContrato.getDate()+"' + interval '"+jsMesesReajuste.getValue()+" month',\n"
                        + " tipo_comision_contratoalquiler = "+(rbtnHonorariosPorc.isSelected()? "1":"2")+",\n"
                        + " tipo_recargo_contratoalquiler = "+(rbtnRecargoPorc.isSelected()? "1":"2")+"\n"
                        + " WHERE nro_contratoalquiler = "+id;
                SqlMetodo.runQuery(sql);
                
                try {
                    for (int i=0; i<tblGarante.getRowCount(); i++){
                        String query = " INSERT INTO inmobiliaria.garantea(\n" +
                        "id_garante_garantea, id_contrato_garantea)\n" +
                        "VALUES ( "+((Tripla) this.tblGarante.getValueAt(i, 0)).getPrimero()+", "+id+");";
                        SqlMetodo.runQuery(query);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                if (!cbEstado.getSelectedItem().toString().equals("Vigente")){
                    String consulta = "UPDATE inmobiliaria.inmueble SET estado_inmueble = 'Alquiler' WHERE id_inmueble = "+inmueble.getPrimero();
                    SqlMetodo.runQuery(consulta);
                } else {
                    String consulta = "UPDATE inmobiliaria.inmueble SET estado_inmueble = 'Vigente' WHERE id_inmueble = "+inmueble.getPrimero();
                    SqlMetodo.runQuery(consulta);
                }                    
                
                if (FechaContrato.getDate().compareTo(FechaContratoOriginal)!=0){
                    SqlMetodo.runQuery("DELETE FROM inmobiliaria.importealquiler WHERE id_contratoalquiler_importealquiler="+id);
                    ajustarImporteAlquiler(this, id);
                }
                
                limpiar();
                JOptionPane.showMessageDialog(this, "Contrato modificado exitosamente");
                dispose();
                Instancias.getInstance().listaContratos.llenarTablaContratosA();
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("Alquiler");
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("AlquilerTodos");
                limpiar();
                editable(false);
                btnInmueble.setEnabled(true); 
            }
        }
        
    }
    
    public static void ajustarImporteAlquiler(Frame parent, int idContrato){
        try {
            ResultSet rs = SqlMetodo.runQuery("SELECT monto_contratoalquiler, reajuste_contratoalquiler, \n" +
                "       tiemporeajuste_contratoalquiler, proximocobro_contratoalquiler, \n" +
                "       fecha_contratoalquiler, fin_contratoalquiler\n" +
                "  FROM inmobiliaria.contratoalquiler"+
                "  WHERE id_contratoalquiler = "+idContrato);
            if (rs.next()){            
                double importeAlq = rs.getDouble("monto_contratoalquiler");
                double reajuste = rs.getDouble("reajuste_contratoalquiler");
                
                Calendar cFechaContrato = Calendar.getInstance();
                cFechaContrato.setTime(rs.getDate("fecha_contratoalquiler"));
                
                Calendar proximoCobro = Calendar.getInstance();
                proximoCobro.setTime(rs.getDate("proximocobro_contratoalquiler"));
                
                Calendar cFechaProx = Calendar.getInstance();
                Date proximoAjuste = obtenerProximoReajusteContrato(idContrato);
                if (proximoAjuste==null){  
                    cFechaProx.setTime(rs.getDate("fecha_contratoalquiler"));
                    cFechaProx.add(Calendar.MONTH, rs.getInt("tiemporeajuste_contratoalquiler"));                    
                    SqlMetodo.runQuery(
                        " INSERT INTO inmobiliaria.importealquiler(\n" +
                        "            importe_importealquiler, fecha_importealquiler, \n" +
                        "            proximoajuste_importealquiler, id_contratoalquiler_importealquiler)\n" +
                        "    VALUES ("+importeAlq+", '"+cFechaContrato.getTime()+"', \n" +
                        "            '"+cFechaProx.getTime()+"', "+idContrato+");\n"+
                        " UPDATE inmobiliaria.contratoalquiler SET montoactual_contratoalquiler="+importeAlq+" WHERE id_contratoalquiler="+idContrato);
                } else {
                    cFechaProx.setTime(proximoAjuste);
                }
                
                while (cFechaProx.before(proximoCobro) || cFechaProx.equals(proximoCobro)){
                    SeleccionarTipoReajuste str = new SeleccionarTipoReajuste(parent, true, cFechaProx.getTime(), importeAlq, importeAlq*(1+(reajuste/100)));
                    str.setVisible(true);
                    importeAlq = str.importe;
                                                               
                    cFechaProx.add(Calendar.MONTH, rs.getInt("tiemporeajuste_contratoalquiler"));
                    
                    SqlMetodo.runQuery(
                        " INSERT INTO inmobiliaria.importealquiler(\n" +
                        "            importe_importealquiler, fecha_importealquiler, \n" +
                        "            proximoajuste_importealquiler, id_contratoalquiler_importealquiler)\n" +
                        "    VALUES ("+importeAlq+", '"+cFechaContrato.getTime()+"', \n" +
                        "            '"+cFechaProx.getTime()+"', "+idContrato+");\n" +
                        " UPDATE inmobiliaria.contratoalquiler SET montoactual_contratoalquiler="+importeAlq+" WHERE id_contratoalquiler="+idContrato);

                }                
                                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static Date obtenerProximoReajusteContrato(int idContrato) {
        try {
            ResultSet rs = SqlMetodo.runQuery("SELECT MAX(proximoajuste_importealquiler) as prox FROM inmobiliaria.importealquiler WHERE id_contratoalquiler_importealquiler="+idContrato);
            if (rs.next()){
                return rs.getDate("prox");
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    
    
    public void editar(int idCont){
        id = idCont;
        limpiar();
        editable(false);
        String sql = "SELECT  nro_contratoalquiler, observacion_contratoalquiler, \n" +
                    "       path_contratoalquiler, estado_contratoalquiler, diavencimiento_contratoalquiler, \n" +
                    "       monto_contratoalquiler, recargo_contratoalquiler, reajuste_contratoalquiler, \n" +
                    "       tiemporeajuste_contratoalquiler, montoactual_contratoalquiler, \n" +
                    "       comision_contratoalquiler, fecha_contratoalquiler, fin_contratoalquiler, deposito_contratoalquiler,\n" +
                    "       tipo_inmueble, direccion_inmueble, razonsocial_persona,\n" +
                    "       id_inmueble_contratoalquiler, id_inquilino_contratoalquiler, tipo_comision_contratoalquiler, tipo_recargo_contratoalquiler\n"+
                    "  FROM inmobiliaria.contratoalquiler"+
                    " INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler"+
                    " INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler"+
                    " WHERE nro_contratoalquiler = "+id;
        ResultSet rs = SqlMetodo.runQuery(sql);
        try {
            if (rs.next()){
                editado = true;
                inmueble = new Tripla(rs.getInt("id_inmueble_contratoalquiler"), rs.getString("direccion_inmueble"), rs.getString("tipo_inmueble"));
                taObs.setText(rs.getString("observacion_contratoalquiler"));
                tfComision.setText(String.valueOf(rs.getFloat("comision_contratoalquiler")));
                tfDireccion.setText(rs.getString("direccion_inmueble"));
                DefaultTableModel modelo = (DefaultTableModel)tblInquilino.getModel();
                
                modelo.setNumRows(1);
                tblInquilino.setModel(modelo);
                tblInquilino.setValueAt(rs.getString("razonsocial_persona"), 0, 0);               
                
                tfMonto.setText(String.valueOf(rs.getFloat("monto_contratoalquiler")));
                tfNro.setText(String.valueOf(rs.getInt("nro_contratoalquiler")));
                tfReajusteAlq.setText(String.valueOf(rs.getFloat("reajuste_contratoalquiler")));
                tfRecargo.setText(String.valueOf(rs.getFloat("recargo_contratoalquiler")));
                tfDeposito.setText(String.valueOf(rs.getFloat("deposito_contratoalquiler")));
                tfTipo.setText(rs.getString("tipo_inmueble"));
                jsDia.setValue(rs.getInt("diavencimiento_contratoalquiler"));
                jsMesesReajuste.setValue(rs.getInt("tiemporeajuste_contratoalquiler"));
                cbEstado.setSelectedItem(rs.getString("estado_contratoalquiler"));
                if (rs.getString("estado_contratoalquiler").equals("Vigente")){
                    cbEstado.setEnabled(true);
                    fechaFinContrato.setEnabled(true);
                }                    
                FechaContrato.setDate(rs.getDate("fecha_contratoalquiler"));
                FechaContratoOriginal = rs.getDate("fecha_contratoalquiler");
                fechaFinContrato.setDate(rs.getDate("fin_contratoalquiler"));
                
                if (rs.getInt("tipo_comision_contratoalquiler")==1){
                    rbtnHonorariosPorc.setSelected(true);
                } else {
                    rbtnHonorariosEfe.setSelected(true);
                }
                
                if (rs.getInt("tipo_recargo_contratoalquiler")==1){
                    rbtnRecargoPorc.setSelected(true);
                } else {
                    rbtnRecargoEfe.setSelected(true);
                }
                
            }
            String query = "SELECT id_persona, razonsocial_persona FROM inmobiliaria.persona "
                           + " INNER JOIN inmobiliaria.garantea ON id_persona = id_garante_garantea"
                           + " INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contrato_garantea "
                           + " WHERE nro_contratoalquiler = "+idCont;
            ResultSet rs2=SqlMetodo.runQuery(query);
            int i=0;
            DefaultTableModel modelo = (DefaultTableModel)tblGarante.getModel();
            while(rs2.next()){
                modelo.setNumRows(i + 1);
                tblGarante.setModel(modelo);
                tblGarante.setValueAt(new Tripla(rs2.getInt("id_persona"), null, rs2.getString("razonsocial_persona")), i, 0);
                i++;
            }
            String query2 = "SELECT razonsocial_persona FROM inmobiliaria.persona "
                           + " INNER JOIN inmobiliaria.inquilinosAdicionales ON id_persona = id_inquilino_inquilinosAdicionales"
                           + " INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_inquilinosAdicionales "
                           + " WHERE nro_contratoalquiler = "+idCont;
            ResultSet rs3=SqlMetodo.runQuery(query2);
            i=1;
            DefaultTableModel modelo2 = (DefaultTableModel)tblInquilino.getModel();
            while(rs3.next()){
                modelo2.setNumRows(i + 1);
                tblInquilino.setModel(modelo2);
                tblInquilino.setValueAt(rs3.getString("razonsocial_persona"), i, 0);
                i++;
            }
            taObs.setEnabled(true);
            setVisible(true);
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 921 metodo editar en la clase ABMContratoA.java: "+ex);
        }
    }
    
    private boolean controles(){
        if (tfDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un inmueble");
            btnInmueble.grabFocus();
            return false;
        }
        if (this.tblInquilino.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Ingrese al menos un inquilino");
            btnInquilino.grabFocus();
            return false;
        }
        if (this.tblGarante.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Ingrese al menos un garante");
            btnGarante.grabFocus();
            return false;
        }
        if (tfNro.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el número de contrato");
            tfNro.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfNro.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para número de contrato");
                tfNro.grabFocus();
                return false;
            }else
                if(!controlUnico() && !editado){
                    JOptionPane.showMessageDialog(this, "Número de contrato existente.");
                    tfNro.grabFocus();
                    return false;
                }
        if (fechaFinContrato.getDate().compareTo(FechaContrato.getDate()) <=0){
            JOptionPane.showMessageDialog(this, "Fecha Fin de contrato es menor o igual a fecha de inicio de contrato.");
            fechaFinContrato.grabFocus();
            return false;
        }
        if (tfMonto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el monto inicial");
            tfMonto.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfMonto.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para monto");
                tfMonto.grabFocus();
                return false;
            }
        
        if (tfDeposito.getText().isEmpty())            
            tfDeposito.setText("0");

        if (!Datos.Procedimientos.isNumber(tfDeposito.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el depósito");
            tfDeposito.grabFocus();
            return false;
        }        
        
        if (tfRecargo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el recargo");
            tfRecargo.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfRecargo.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para recargo");
                tfRecargo.grabFocus();
                return false;
            }
        if (tfReajusteAlq.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el reajuste");
            tfReajusteAlq.grabFocus();
            return false;
        }else
            if (!Datos.Procedimientos.isNumber(tfReajusteAlq.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor válido para reajuste");
                tfReajusteAlq.grabFocus();
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
        if (!editado){
            ABM.FechaProximoCobro fpc = new ABM.FechaProximoCobro(this, true);
            fpc.setVisible(true);       
            if (!fpc.ok)
                return false;
            else
                fechaProximoCobro = fpc.dtFecha.getDate();
        }
            
        return true;
    }
    
    private boolean controlUnico(){
        String sql = "SELECT nro_contratoalquiler FROM inmobiliaria.contratoalquiler WHERE nro_contratoalquiler = "+tfNro.getText();
        ResultSet rs = SqlMetodo.runQuery(sql);
        try {
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1030 metodo contratoUnico en la clase ABMContratoA.java: "+ex);
        }
        return true;
    }
    
    public void mostrar(){
        limpiar();
        editable(false);
        btnInmueble.setEnabled(true);
        setVisible(true);
    }
    
    private void limpiar(){
        editado = false;
        inmueble = null;
        tfComision.setText("");
        tfDireccion.setText("");
        tfMonto.setText("");
        tfNro.setText("");
        tfReajusteAlq.setText("");
        tfDeposito.setText("");
        tfRecargo.setText("1");
        tfTipo.setText("");
        limpiarTabla(this.tblGarante);
        limpiarTabla(this.tblInquilino);
        jsDia.setValue(10);
        jsMesesReajuste.setValue(6);
        cbEstado.setSelectedIndex(0);
        FechaContrato.setDate(Calendar.getInstance().getTime());
        fechaFinContrato.setDate(Calendar.getInstance().getTime());
        rbtnHonorariosPorc.setSelected(true);
        rbtnRecargoPorc.setSelected(true);
        taObs.setText("");
        
    }
    
    private void editable(boolean b){
        tfDireccion.setEditable(b);
        tfDeposito.setEditable(b);
        tfTipo.setEditable(b);
        limpiarTabla(this.tblGarante);
        limpiarTabla(this.tblInquilino);
        btnAgregarInquilino.setEnabled(b);
        btnInmueble.setEnabled(b);
        btnInquilino.setEnabled(b);
        cbEstado.setEnabled(b);
        taObs.setEnabled(b);
        
    }
    private void limpiarTabla(javax.swing.JTable tabla){
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
    }  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaContrato;
    private org.edisoncor.gui.button.ButtonAction btnActualizarImportes;
    private org.edisoncor.gui.button.ButtonAction btnAgregarGarante;
    private org.edisoncor.gui.button.ButtonAction btnAgregarInquilino;
    private org.edisoncor.gui.button.ButtonAction btnGarante;
    private org.edisoncor.gui.button.ButtonAction btnGuardar;
    private org.edisoncor.gui.button.ButtonAction btnInmueble;
    private org.edisoncor.gui.button.ButtonAction btnInquilino;
    private org.edisoncor.gui.button.ButtonColoredAction btnVerInmueble;
    private javax.swing.JComboBox cbEstado;
    private com.toedter.calendar.JDateChooser fechaFinContrato;
    private javax.swing.ButtonGroup grupoHonorarios;
    private javax.swing.ButtonGroup grupoRecargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jsDia;
    private javax.swing.JSpinner jsMesesReajuste;
    private javax.swing.JScrollPane jscroll;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JRadioButton rbtnHonorariosEfe;
    private javax.swing.JRadioButton rbtnHonorariosPorc;
    private javax.swing.JRadioButton rbtnRecargoEfe;
    private javax.swing.JRadioButton rbtnRecargoPorc;
    private javax.swing.JTextArea taObs;
    private javax.swing.JTable tblGarante;
    private javax.swing.JTable tblInquilino;
    private javax.swing.JTextField tfComision;
    private javax.swing.JTextField tfDeposito;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfNro;
    private javax.swing.JTextField tfReajusteAlq;
    private javax.swing.JTextField tfRecargo;
    private javax.swing.JTextField tfTipo;
    // End of variables declaration//GEN-END:variables
}
