package Facturacion;

import ABM.ABMContratoA;
import Consulta.ElegirAlquiler;
import Consulta.ElegirCliente;
import Datos.Instancias;
import Datos.Macros;
import static Datos.Procedimientos.isNumber;
import Facturacion.Impresion.ImpresionComprobante;
import Objetos.Comprobante;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Facturacion extends javax.swing.JFrame {
    private LinkedList<Tripla> item = new LinkedList();
    private LinkedList<Tripla> itemLiq = new LinkedList();
    private int maxFactura = 0;
    private int maxRecibo = 0;
    private int maxLiquidacion = 0;
    
    private int id_comprobantealquiler_asociado;
    private int id_alquiler = -1;
    private int id_alquilerliquidacion = -1;
    private int id_clienteR = -1;
    public Comprobante comp = new Comprobante();
    public Comprobante compR = new Comprobante();
    public Comprobante compLiq = new Comprobante();

    public Facturacion() {
        initComponents();
        configurarCamposPago();
        panel4.setVisible(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        dateFecha.setDate(Calendar.getInstance().getTime());
        dateFechaR.setDate(dateFecha.getDate());
        calcularNroComprobantes();
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

    public void mostrar(){
       this.limpiarPantalla();
       this.limpiarPantallaRecibo();
       this.limpiarPantallaLiquidacion();
       this.tfCuit.grabFocus();
       this.setVisible(true);
    }
    
    private javax.swing.JTextArea crearAreaConHint(String hint) {
        return new javax.swing.JTextArea() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);

                if (!getText().isEmpty()) {
                    return;
                }

                java.awt.Graphics copia = g.create();
                try {
                    java.awt.Insets margen = getInsets();
                    copia.setFont(getFont());
                    copia.setColor(new java.awt.Color(110, 110, 110));

                    int x = margen.left + 2;
                    int y = margen.top + copia.getFontMetrics().getAscent();

                    copia.drawString(hint, x, y);
                } finally {
                    copia.dispose();
                }
            }
        };
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panel2 = new org.edisoncor.gui.panel.Panel();
        tabComp = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panel3 = new org.edisoncor.gui.panel.Panel();
        btnFacturar = new org.edisoncor.gui.button.ButtonAction();
        dateFecha = new com.toedter.calendar.JDateChooser();
        lbNroFactura = new javax.swing.JLabel();
        lbNroFacturaLiq3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbTipoInmueble = new javax.swing.JLabel();
        tfTipoInmueble = new javax.swing.JTextField();
        lbDireccionInmueble = new javax.swing.JLabel();
        tfDireccionInmueble = new javax.swing.JTextField();
        lbPersona = new javax.swing.JLabel();
        tfPersona = new javax.swing.JTextField();
        lbDoc = new javax.swing.JLabel();
        tfCuit = new javax.swing.JTextField();
        btnBuscarContrato = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTalonario = new javax.swing.JTable();
        dateFechaItem = new com.toedter.calendar.JDateChooser();
        tfDescripcion = new javax.swing.JTextField();
        tfMonto = new javax.swing.JTextField();
        btnAgregar = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane6 = new javax.swing.JScrollPane();
        taObsTalonario = crearAreaConHint("Observaciones (opcional)");
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chkExpensas = new javax.swing.JCheckBox();
        chkMunicipal = new javax.swing.JCheckBox();
        chkEmos = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        tfTalonarioEfe = new javax.swing.JTextField();
        tfTalonarioCheque = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnGenerarR = new org.edisoncor.gui.button.ButtonAction();
        lbNroFacturaR = new javax.swing.JLabel();
        dateFechaR = new com.toedter.calendar.JDateChooser();
        lbNroFacturaLiq2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbPersonaR = new javax.swing.JLabel();
        tfPersonaR = new javax.swing.JTextField();
        btnBuscarClienteR = new org.edisoncor.gui.button.ButtonAction();
        lbDocR = new javax.swing.JLabel();
        tfCuitR = new javax.swing.JTextField();
        lbDireccionR = new javax.swing.JLabel();
        tfDireccionR = new javax.swing.JTextField();
        tfCiudadR = new javax.swing.JTextField();
        tfProvinciaR = new javax.swing.JTextField();
        lbPesosR = new javax.swing.JLabel();
        tfPesosR = new javax.swing.JTextField();
        lbConceptoR = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taConceptoR = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tfReciboEfe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfReciboCheque = new javax.swing.JTextField();
        lbTotalR = new javax.swing.JLabel();
        tfTotalR = new javax.swing.JTextField();
        panel4 = new org.edisoncor.gui.panel.Panel();
        btnGenerarLiquidacion = new org.edisoncor.gui.button.ButtonAction();
        dateFechaLiq = new com.toedter.calendar.JDateChooser();
        lbNroFacturaLiq = new javax.swing.JLabel();
        lbNroFacturaLiq1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbTipoInmueble1 = new javax.swing.JLabel();
        tfTipoInmuebleLiq = new javax.swing.JTextField();
        lbDireccionInmueble1 = new javax.swing.JLabel();
        tfDireccionInmuebleLiq = new javax.swing.JTextField();
        lbPersona1 = new javax.swing.JLabel();
        tfPropietario = new javax.swing.JTextField();
        lbDoc1 = new javax.swing.JLabel();
        tfCuitPropietario = new javax.swing.JTextField();
        btnBuscarContratoLiq = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTalonarioLiq = new javax.swing.JTable();
        dateFechaItemLiq = new com.toedter.calendar.JDateChooser();
        tfDescripcionLiq = new javax.swing.JTextField();
        tfMontoLiq = new javax.swing.JTextField();
        btnAgregarLiq = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObsLiquidacion = crearAreaConHint("Observaciones (opcional)");
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfLiquidacionEfe = new javax.swing.JTextField();
        tfLiquidacionCheque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbTotal1 = new javax.swing.JLabel();
        tfTotalLiq = new javax.swing.JTextField();

        jPopupMenu1.setToolTipText("Eliminar Columna");
        jPopupMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturacion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel3.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel3.setColorSecundario(new java.awt.Color(255, 255, 255));

        btnFacturar.setText("Generar Recibo De Alquiler");
        btnFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFacturarMousePressed(evt);
            }
        });

        dateFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbNroFactura.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFactura.setText("Nº");

        lbNroFacturaLiq3.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFacturaLiq3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFacturaLiq3.setText("RECIBO ALQUILER");

        lbTipoInmueble.setBackground(new java.awt.Color(255, 255, 255));
        lbTipoInmueble.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTipoInmueble.setText("Inmueble:");

        tfTipoInmueble.setEditable(false);
        tfTipoInmueble.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbDireccionInmueble.setBackground(new java.awt.Color(255, 255, 255));
        lbDireccionInmueble.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDireccionInmueble.setText("Domicilio");

        tfDireccionInmueble.setEditable(false);
        tfDireccionInmueble.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbPersona.setBackground(new java.awt.Color(255, 255, 255));
        lbPersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPersona.setText("Señor/a:");

        tfPersona.setEditable(false);
        tfPersona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbDoc.setBackground(new java.awt.Color(255, 255, 255));
        lbDoc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDoc.setText("DNI");

        tfCuit.setEditable(false);
        tfCuit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscarContrato.setText("Buscar Inmueble");
        btnBuscarContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarContratoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPersona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDireccionInmueble)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDireccionInmueble))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDireccionInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccionInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTalonario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Descripcion", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTalonario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTalonarioMousePressed(evt);
            }
        });
        tblTalonario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTalonarioKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblTalonario);
        if (tblTalonario.getColumnModel().getColumnCount() > 0) {
            tblTalonario.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblTalonario.getColumnModel().getColumn(1).setPreferredWidth(500);
            tblTalonario.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        dateFechaItem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tfDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tfMonto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfMonto.setText("0");
        tfMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfMontoFocusGained(evt);
            }
        });
        tfMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMontoKeyPressed(evt);
            }
        });

        btnAgregar.setText("+");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });

        taObsTalonario.setColumns(20);
        taObsTalonario.setLineWrap(true);
        taObsTalonario.setRows(3);
        jScrollPane6.setViewportView(taObsTalonario);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("SERVICIOS");

        chkExpensas.setSelected(true);
        chkExpensas.setText("EXPENSAS");

        chkMunicipal.setSelected(true);
        chkMunicipal.setText("MUNICIPAL");

        chkEmos.setSelected(true);
        chkEmos.setText("EMOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(chkExpensas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEmos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkExpensas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMunicipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkEmos)
                .addContainerGap())
        );

        jLabel6.setText("Efectivo");

        jLabel7.setText("Cheque");

        lbTotal.setBackground(new java.awt.Color(255, 255, 255));
        lbTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTotal.setText("Total            $");

        tfTalonarioEfe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTalonarioEfeFocusGained(evt);
            }
        });

        tfTalonarioCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTalonarioChequeFocusGained(evt);
            }
        });

        tfTotal.setEditable(false);
        tfTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotal.setText("0");
        tfTotal.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTalonarioEfe, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tfTalonarioCheque))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTalonarioEfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTalonarioCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotal)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(lbNroFacturaLiq3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(dateFechaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFacturaLiq3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFechaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabComp.addTab("TALONARIO", panel3);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));

        btnGenerarR.setText("Generar Recibo");
        btnGenerarR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerarRMousePressed(evt);
            }
        });
        btnGenerarR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGenerarRKeyPressed(evt);
            }
        });

        lbNroFacturaR.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFacturaR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFacturaR.setText("Nº");

        dateFechaR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbNroFacturaLiq2.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFacturaLiq2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFacturaLiq2.setText("RECIBO SIMPLE");

        lbPersonaR.setBackground(new java.awt.Color(255, 255, 255));
        lbPersonaR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPersonaR.setText("Recibi de:");

        tfPersonaR.setBackground(new java.awt.Color(204, 255, 204));
        tfPersonaR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPersonaR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPersonaRFocusLost(evt);
            }
        });

        btnBuscarClienteR.setText("Buscar");
        btnBuscarClienteR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarClienteRMousePressed(evt);
            }
        });

        lbDocR.setBackground(new java.awt.Color(255, 255, 255));
        lbDocR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDocR.setText("DNI");

        tfCuitR.setEditable(false);
        tfCuitR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbDireccionR.setBackground(new java.awt.Color(255, 255, 255));
        lbDireccionR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDireccionR.setText("Domicilio");

        tfDireccionR.setEditable(false);
        tfDireccionR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfCiudadR.setEditable(false);
        tfCiudadR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfProvinciaR.setEditable(false);
        tfProvinciaR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbPersonaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPersonaR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarClienteR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbDocR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCuitR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbDireccionR)
                        .addGap(12, 12, 12)
                        .addComponent(tfDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCiudadR, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfProvinciaR, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPersonaR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPersonaR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDocR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCuitR, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClienteR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccionR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCiudadR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProvinciaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbPesosR.setBackground(new java.awt.Color(255, 255, 255));
        lbPesosR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPesosR.setText("La suma de pesos:");

        tfPesosR.setBackground(new java.awt.Color(204, 255, 204));
        tfPesosR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPesosR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPesosR.setNextFocusableComponent(taConceptoR);
        tfPesosR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPesosRFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesosRFocusLost(evt);
            }
        });
        tfPesosR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesosRKeyPressed(evt);
            }
        });

        lbConceptoR.setBackground(new java.awt.Color(255, 255, 255));
        lbConceptoR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbConceptoR.setText("En concepto:");

        taConceptoR.setColumns(20);
        taConceptoR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taConceptoR.setLineWrap(true);
        taConceptoR.setRows(5);
        taConceptoR.setNextFocusableComponent(btnGenerarR);
        taConceptoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taConceptoRKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(taConceptoR);

        jLabel2.setText("Efectivo");

        tfReciboEfe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfReciboEfeFocusGained(evt);
            }
        });

        jLabel3.setText("Cheque");

        tfReciboCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfReciboChequeFocusGained(evt);
            }
        });

        lbTotalR.setBackground(new java.awt.Color(255, 255, 255));
        lbTotalR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTotalR.setText("Total            $");

        tfTotalR.setEditable(false);
        tfTotalR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotalR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotalR.setText("0");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lbNroFacturaLiq2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNroFacturaR, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFechaR, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPesosR)
                                    .addComponent(lbConceptoR, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTotalR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTotalR, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfReciboCheque)
                                        .addComponent(tfReciboEfe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfPesosR, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFechaR, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFacturaR, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFacturaLiq2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesosR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesosR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbConceptoR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReciboEfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReciboCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalR))
                .addGap(122, 122, 122)
                .addComponent(btnGenerarR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabComp.addTab("RECIBOS", panel1);

        panel4.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel4.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel4.setEnabled(false);

        btnGenerarLiquidacion.setText("Generar Liquidación");
        btnGenerarLiquidacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerarLiquidacionMousePressed(evt);
            }
        });

        dateFechaLiq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbNroFacturaLiq.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFacturaLiq.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFacturaLiq.setText("Nº");

        lbNroFacturaLiq1.setBackground(new java.awt.Color(255, 255, 255));
        lbNroFacturaLiq1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroFacturaLiq1.setText("LIQUIDACION");

        lbTipoInmueble1.setBackground(new java.awt.Color(255, 255, 255));
        lbTipoInmueble1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTipoInmueble1.setText("Inmueble:");

        tfTipoInmuebleLiq.setEditable(false);
        tfTipoInmuebleLiq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbDireccionInmueble1.setBackground(new java.awt.Color(255, 255, 255));
        lbDireccionInmueble1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDireccionInmueble1.setText("Domicilio");

        tfDireccionInmuebleLiq.setEditable(false);
        tfDireccionInmuebleLiq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbPersona1.setBackground(new java.awt.Color(255, 255, 255));
        lbPersona1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPersona1.setText("Señor/a:");

        tfPropietario.setEditable(false);
        tfPropietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbDoc1.setBackground(new java.awt.Color(255, 255, 255));
        lbDoc1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDoc1.setText("DNI");

        tfCuitPropietario.setEditable(false);
        tfCuitPropietario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscarContratoLiq.setText("Buscar Inmueble");
        btnBuscarContratoLiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarContratoLiqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTipoInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPersona1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCuitPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarContratoLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfTipoInmuebleLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDireccionInmueble1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDireccionInmuebleLiq)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTipoInmuebleLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipoInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDireccionInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccionInmuebleLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPersona1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCuitPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarContratoLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTalonarioLiq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Descripcion", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTalonarioLiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTalonarioLiqMousePressed(evt);
            }
        });
        tblTalonarioLiq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTalonarioLiqKeyPressed(evt);
            }
        });
        jScrollPane8.setViewportView(tblTalonarioLiq);
        if (tblTalonarioLiq.getColumnModel().getColumnCount() > 0) {
            tblTalonarioLiq.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblTalonarioLiq.getColumnModel().getColumn(1).setPreferredWidth(500);
            tblTalonarioLiq.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

        dateFechaItemLiq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tfDescripcionLiq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfDescripcionLiq.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tfMontoLiq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfMontoLiq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfMontoLiq.setText("0");

        btnAgregarLiq.setText("+");
        btnAgregarLiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarLiqMousePressed(evt);
            }
        });

        taObsLiquidacion.setColumns(20);
        taObsLiquidacion.setLineWrap(true);
        taObsLiquidacion.setRows(3);
        jScrollPane1.setViewportView(taObsLiquidacion);

        jLabel4.setText("Efectivo");

        tfLiquidacionEfe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLiquidacionEfeFocusGained(evt);
            }
        });

        tfLiquidacionCheque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfLiquidacionChequeFocusGained(evt);
            }
        });

        jLabel5.setText("Cheque");

        lbTotal1.setBackground(new java.awt.Color(255, 255, 255));
        lbTotal1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTotal1.setText("Total            $");

        tfTotalLiq.setEditable(false);
        tfTotalLiq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotalLiq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTotalLiq.setText("0");
        tfTotalLiq.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLiquidacionCheque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLiquidacionEfe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTotalLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLiquidacionEfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLiquidacionCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotal1)
                    .addComponent(tfTotalLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarLiquidacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(dateFechaItemLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDescripcionLiq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMontoLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(lbNroFacturaLiq1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNroFacturaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFechaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateFechaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFacturaLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroFacturaLiq1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDescripcionLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfMontoLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateFechaItemLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarLiquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabComp.addTab("LIQUIDACION", panel4);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabComp, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabComp, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );

        tabComp.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarClienteRMousePressed
        ElegirCliente ec = new ElegirCliente(this, true);
        ec.mostrar("Cliente");
        if (ec.seleccionado!=null){
            tfPersonaR.setText(ec.seleccionado.toString());
            cargarClienteR();
        }
    }//GEN-LAST:event_btnBuscarClienteRMousePressed

    private void btnGenerarRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGenerarRKeyPressed

    }//GEN-LAST:event_btnGenerarRKeyPressed

    private void btnGenerarRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarRMousePressed
        btnGenerarR.setCursor(new Cursor(Cursor.WAIT_CURSOR));        
        calcularNroComprobantes();
        this.facturarRecibo();
        btnGenerarR.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnGenerarRMousePressed

    private void tfPesosRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesosRKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            actualizarMontoRecibo();
            this.taConceptoR.grabFocus();
        }
    }//GEN-LAST:event_tfPesosRKeyPressed

    private void tfPesosRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesosRFocusLost
        actualizarMontoRecibo();
    }//GEN-LAST:event_tfPesosRFocusLost

    private void taConceptoRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taConceptoRKeyPressed
        // TODO add your handling code here:
        if(taConceptoR.getText().length()> 199){
            taConceptoR.setText(taConceptoR.getText().substring(0, 199));
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            this.btnGenerarR.grabFocus();
        }        
    }//GEN-LAST:event_taConceptoRKeyPressed

    private void tfPesosRFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesosRFocusGained
        this.tfPesosR.selectAll();
    }//GEN-LAST:event_tfPesosRFocusGained

    private void btnFacturarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturarMousePressed
        btnFacturar.setCursor(new Cursor(Cursor.WAIT_CURSOR));        
        calcularNroComprobantes();
        this.facturar();
        btnFacturar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnFacturarMousePressed

    private void tblTalonarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTalonarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && tblTalonario.getSelectedRow() > 0)
            eliminarProducto(tblTalonario.getSelectedRow());        
    }//GEN-LAST:event_tblTalonarioKeyPressed

    private void tfPersonaRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPersonaRFocusLost
        cargarClienteR();
    }//GEN-LAST:event_tfPersonaRFocusLost

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        cargarProducto();
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnBuscarContratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarContratoMousePressed
        ElegirAlquiler ea = new ElegirAlquiler(this, true);
        ea.mostrar(1);
        if (ea.seleccionado!=null){
            cargarContrato((Integer) ea.seleccionado.getPrimero());
        }
    }//GEN-LAST:event_btnBuscarContratoMousePressed

    private void tfMontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMontoFocusGained
        // TODO add your handling code here:
        this.tfMonto.setText("");
    }//GEN-LAST:event_tfMontoFocusGained

    private void tfMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMontoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            cargarProducto();
    }//GEN-LAST:event_tfMontoKeyPressed

    private void btnGenerarLiquidacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarLiquidacionMousePressed
        btnFacturar.setCursor(new Cursor(Cursor.WAIT_CURSOR));          
        calcularNroComprobantes();
        this.facturarLiq();
        btnFacturar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnGenerarLiquidacionMousePressed

    private void tblTalonarioLiqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTalonarioLiqKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && tblTalonarioLiq.getSelectedRow() > 0)
            eliminarProductoLiq(tblTalonarioLiq.getSelectedRow());  
    }//GEN-LAST:event_tblTalonarioLiqKeyPressed

    private void btnBuscarContratoLiqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarContratoLiqMousePressed
        ElegirAlquiler ea = new ElegirAlquiler(this, true);
        ea.mostrar(2);
        if (ea.seleccionado!=null){
            cargarLiquidacion((Integer) ea.seleccionado.getPrimero());
        }
    }//GEN-LAST:event_btnBuscarContratoLiqMousePressed

    private void btnAgregarLiqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarLiqMousePressed
        cargarProductoLiq();
    }//GEN-LAST:event_btnAgregarLiqMousePressed

    private void tblTalonarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTalonarioMousePressed
        if (evt.getClickCount()==2 && tblTalonario.getSelectedRow()>=0){            
            cambiarPrecio(tblTalonario.getSelectedRow());
        }
    }//GEN-LAST:event_tblTalonarioMousePressed

    private void tblTalonarioLiqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTalonarioLiqMousePressed
        if (evt.getClickCount()==2 && tblTalonarioLiq.getSelectedRow()>=0){            
            cambiarPrecioLiq(tblTalonarioLiq.getSelectedRow());
        }
    }//GEN-LAST:event_tblTalonarioLiqMousePressed

    private void tfTalonarioEfeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTalonarioEfeFocusGained
        tfTalonarioEfe.setSelectionStart(0);
        tfTalonarioEfe.setSelectionEnd(tfTalonarioEfe.getText().length());
    }//GEN-LAST:event_tfTalonarioEfeFocusGained

    private void tfTalonarioChequeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTalonarioChequeFocusGained
        tfTalonarioCheque.setSelectionStart(0);
        tfTalonarioCheque.setSelectionEnd(tfTalonarioCheque.getText().length());
    }//GEN-LAST:event_tfTalonarioChequeFocusGained

    private void tfReciboEfeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfReciboEfeFocusGained
        tfReciboEfe.setSelectionStart(0);
        tfReciboEfe.setSelectionEnd(tfReciboEfe.getText().length());
    }//GEN-LAST:event_tfReciboEfeFocusGained

    private void tfReciboChequeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfReciboChequeFocusGained
        tfReciboCheque.setSelectionStart(0);
        tfReciboCheque.setSelectionEnd(tfReciboCheque.getText().length());
    }//GEN-LAST:event_tfReciboChequeFocusGained

    private void tfLiquidacionChequeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLiquidacionChequeFocusGained
        tfLiquidacionCheque.setSelectionStart(0);
        tfLiquidacionCheque.setSelectionEnd(tfLiquidacionCheque.getText().length());
    }//GEN-LAST:event_tfLiquidacionChequeFocusGained

    private void tfLiquidacionEfeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfLiquidacionEfeFocusGained
        tfLiquidacionEfe.setSelectionStart(0);
        tfLiquidacionEfe.setSelectionEnd(tfLiquidacionEfe.getText().length());
    }//GEN-LAST:event_tfLiquidacionEfeFocusGained

    //--------------------- Talonario  ----------------------------------
    
    public void facturar(){
        if (controlGeneral()){
            cargarObjetoComprobante();
            LogicaFactura l = new LogicaFactura(comp);
            l.guardarFactura();
            imprimirFactura();
            limpiarPantalla();
            Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("Alquiler");
            Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("AlquilerTodos");
        }
    }    
    
    public void facturarLiq(){    
        if (controlGeneralLiq()){
            cargarObjetoComprobanteLiq();
            LogicaFactura l = new LogicaFactura(compLiq);
            l.guardarLiquidacion(id_alquilerliquidacion, id_comprobantealquiler_asociado);                
            imprimirLiquidacion();
            limpiarPantalla();
        }
    }    
    
    private void facturarRecibo(){
        if (controlGeneralRecibo()){
            cargarObjetoComprobanteRecibo();
            LogicaFactura l = new LogicaFactura(comp);
            l.guardarRecibo(); 
            imprimirRecibo();
            limpiarPantalla();
        }   
    }
    
    //Eliminar     
    private void eliminarProducto(int fila){
        actualizarTotal(Float.parseFloat(tblTalonario.getValueAt(fila, 2).toString()),Float.parseFloat("0"));
        item.remove(fila);
        quitarProductoDeTabla(fila, tblTalonario);
        tfTalonarioEfe.requestFocusInWindow();
    }
    //Eliminar     
    private void eliminarProductoLiq(int fila){
        actualizarTotalLiq(Float.parseFloat(tblTalonarioLiq.getValueAt(fila, 2).toString()),Float.parseFloat("0"));
        itemLiq.remove(fila);
        quitarProductoDeTabla(fila, tblTalonarioLiq);
        tfLiquidacionEfe.requestFocusInWindow();
    }
    
    //Actualizaciones  
    private void actualizarTotal(Float restar, Float sumar){
        Float total = Float.parseFloat(tfTotal.getText());
        total = (total - restar) + sumar;
        tfTotal.setText(Datos.Procedimientos.truncar(total));
        sugerirEfectivo(tfTotal, tfTalonarioEfe, tfTalonarioCheque);
    }
       
    private void actualizarTotalLiq(Float restar, Float sumar){
        Float total = Float.parseFloat(tfTotalLiq.getText());
        total = (total - restar) + sumar;
        tfTotalLiq.setText(Datos.Procedimientos.truncar(total));
        sugerirEfectivo(tfTotalLiq, tfLiquidacionEfe, tfLiquidacionCheque);
    }
            

    private boolean actualizarMontoRecibo() {
        try {
            BigDecimal monto = leerImportePago(tfPesosR);
            if (monto.compareTo(leerTotal(tfTotalR)) != 0) {
                tfTotalR.setText(monto.toPlainString());
                sugerirEfectivo(tfTotalR, tfReciboEfe, tfReciboCheque);
            }
            return true;
        } catch (NumberFormatException ex) {
            // Se conserva lo escrito para que el usuario pueda corregirlo.
            return false;
        }
    }
    
    private void cambiarPrecio(int index){
        try {
            CambiarPrecio cp = new CambiarPrecio(this, true);
            cp.tfValor.setText(tblTalonario.getValueAt(index, 2).toString());
            cp.mostrar();
            if (cp.todoOk){
                float valorAnterior = (Float) tblTalonario.getValueAt(index, 2);
                float valornuevo = Float.parseFloat(cp.tfValor.getText());                
                
                item.get(index).setTercero(Float.parseFloat(cp.tfValor.getText()));
                tblTalonario.setValueAt(valornuevo, index, 2);
                actualizarTotal(valorAnterior,valornuevo);
                                
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void cambiarPrecioLiq(int index){
        try {
            CambiarPrecio cp = new CambiarPrecio(this, true);
            cp.tfValor.setText(tblTalonarioLiq.getValueAt(index, 2).toString());
            cp.mostrar();
            if (cp.todoOk){
                float valorAnterior = (Float) tblTalonarioLiq.getValueAt(index, 2);
                float valornuevo = Float.parseFloat(cp.tfValor.getText());                
                
                itemLiq.get(index).setTercero(Float.parseFloat(cp.tfValor.getText()));
                tblTalonarioLiq.setValueAt(valornuevo, index, 2);
                actualizarTotalLiq(valorAnterior,valornuevo);
                                
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    //Calculos
    public void calcularTotalFila(int fila, int col){
        if (tblTalonario.getValueAt(fila, col).equals(""))
            tblTalonario.setValueAt(0,fila, col);
        if (isNumber(tblTalonario.getValueAt(fila, 0).toString()) && isNumber(tblTalonario.getValueAt(fila, 3).toString())){
            int cant = Integer.parseInt(tblTalonario.getValueAt(fila, 0).toString());
            if (cant < 0){
                cant = 1;
                tblTalonario.setValueAt(1,fila, 0);
            }
            float precio = Float.parseFloat(tblTalonario.getValueAt(fila, 3).toString());
            actualizarTotal(Float.parseFloat(tblTalonario.getValueAt(fila, 4).toString()),(cant * precio));
            tblTalonario.setValueAt((cant * precio),fila, 4);
        }else{
            tblTalonario.setValueAt(0,fila, col);
            tblTalonario.setValueAt(0,fila, 4);
        }
        
    }
    
    //Cargas    
    private void cargarProducto(){
        if (controlProducto()){
            int fila = agregarFila(tblTalonario);
            float montoItem = Float.parseFloat(tfMonto.getText());
            Tripla p = new Tripla ("",tfDescripcion.getText(),montoItem);
            item.add(p);
            tblTalonario.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(dateFechaItem.getDate()),fila,0);
            tblTalonario.setValueAt(tfDescripcion.getText(),fila,1);
            tblTalonario.setValueAt(montoItem,fila,2);
            actualizarTotal(Float.parseFloat("0"),montoItem);
            limpiarItem();
            tfDescripcion.grabFocus(); 
        }
    }
    //Cargas    
    private void cargarProductoLiq(){
        if (controlProductoLiq()){
            int fila = agregarFila(tblTalonarioLiq);
            float montoItem = Float.parseFloat(tfMontoLiq.getText());
            Tripla p = new Tripla ("",tfDescripcionLiq.getText(),montoItem);
            itemLiq.add(p);
            tblTalonarioLiq.setValueAt(new SimpleDateFormat("dd/MM/yyyy").format(dateFechaItemLiq.getDate()),fila,0);
            tblTalonarioLiq.setValueAt(tfDescripcionLiq.getText(),fila,1);
            tblTalonarioLiq.setValueAt(montoItem,fila,2);
            actualizarTotalLiq(Float.parseFloat("0"),montoItem);
            limpiarItemLiq();
            tfDescripcionLiq.grabFocus(); 
        }
    }
    
    public void cargarContrato(int id){
        
        ABMContratoA.ajustarImporteAlquiler(this, id);
        
        ResultSet rs = SqlMetodo.runQuery("SELECT tipo_inmueble, direccion_inmueble, id_inquilino_contratoalquiler, piso_departamento, dpto_departamento  \n"
                    + " FROM inmobiliaria.contratoalquiler "
                    + " INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler\n"
                    + " LEFT JOIN inmobiliaria.departamento ON id_inmueble_departamento = id_inmueble \n"
                    + " WHERE  id_contratoalquiler = "+id);
        try {
            if (rs.next()){
                limpiarPantalla();
                id_alquiler = id;
                tfTipoInmueble.setText(rs.getString(1));
                if (rs.getString("piso_departamento")!=null){
                    tfDireccionInmueble.setText(rs.getString(2)+" Piso:"+rs.getString("piso_departamento")+"-"+rs.getString("dpto_departamento"));
                } else {
                    tfDireccionInmueble.setText(rs.getString(2));
                }
                
                cargarCliente(rs.getInt(3));
                cargarItems(id,rs.getString(1));
            } 
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1328 en cargarContacto de la facturacion: "+ex.toString());
        }
    }
    
    private void cargarCliente(int idCli){
        String consulta= "SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                         "mail_persona, telefono_persona, direccion_persona,  \n" +
                         "nombre_ciudad, nombre_provincia\n" +
                        " FROM inmobiliaria.persona INNER JOIN inmobiliaria.ciudad ON id_ciudad_persona = id_ciudad "+
                        "INNER JOIN inmobiliaria.provincia ON id_provincia_ciudad =  id_provincia "+ 
                        "WHERE id_persona = "+idCli+" and tipo_persona<>'Titular' and tipo_persona<>'Administrador'";
        ResultSet join= SqlMetodo.runQuery(consulta);
        try {
            if (join.next()){
                tfPersona.setText(join.getString(2));
                tfCuit.setText(join.getString(4));
            } 
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1352 en cargarCliente de la facturacion: "+ex.toString());
        }  
    }
    
    private void cargarItems(int idAlq, String tipo){
        ResultSet rs = SqlMetodo.runQuery("SELECT montoactual_contratoalquiler, proximocobro_contratoalquiler, " +                
                    "(\n" +
                    "  CASE WHEN tipo_recargo_contratoalquiler=1 THEN \n" +
                    "    ( (montoactual_contratoalquiler * recargo_contratoalquiler/100) * date_part('day', current_date - (proximocobro_contratoalquiler + (diavencimiento_contratoalquiler-1 || ' day')::interval)))    \n" +
                    "  WHEN tipo_recargo_contratoalquiler=2 THEN\n" +
                    "    (recargo_contratoalquiler * date_part('day', current_date - (proximocobro_contratoalquiler + (diavencimiento_contratoalquiler-1 || ' day')::interval)))\n" +
                    "  END\n" +
                    ") as Recargo,\n" +              
                    " id_inmueble_contratoalquiler, saldo_contratoalquiler, " +
                    " extract(year from age(proximocobro_contratoalquiler, fecha_contratoalquiler))*12 + extract(month from age(proximocobro_contratoalquiler, fecha_contratoalquiler)) + 1 as mesesAbonados,\n" +
                    " extract(year from age(fin_contratoalquiler, fecha_contratoalquiler))*12 + extract(month from age(fin_contratoalquiler, fecha_contratoalquiler)) + 1 as mesesTotal\n" +
                    " FROM inmobiliaria.contratoalquiler " +
                    " WHERE id_contratoalquiler = "+idAlq);
        try {
            if (rs.next()){
                int mesPago = Integer.parseInt(new SimpleDateFormat("MM").format(rs.getDate("proximocobro_contratoalquiler")));
                int anioPago = Integer.parseInt(new SimpleDateFormat("yyyy").format(rs.getDate("proximocobro_contratoalquiler")));
                                
                dateFechaItem.setDate(rs.getDate("proximocobro_contratoalquiler"));
                tfDescripcion.setText("Alquiler del mes "+mesPago+" del "+anioPago+"  "+rs.getString("mesesAbonados")+"/"+rs.getString("mesesTotal"));
                tfMonto.setText(Float.toString(rs.getFloat("montoactual_contratoalquiler")));
                cargarProducto();
                if (rs.getFloat(3) > 0){
                    tfDescripcion.setText("Recargo por retraso en el pago");
                    tfMonto.setText(Float.toString(rs.getFloat("Recargo")));
                    cargarProducto();
                }
                ResultSet rsExpensas = SqlMetodo.runQuery("SELECT montoExpensas_inmueble, montoMunicipal_inmueble, montoEMOS_inmueble "
                        + " FROM inmobiliaria.inmueble "
                        + " WHERE id_inmueble = "+rs.getInt(4));
                if (rsExpensas.next()){
                    if (rsExpensas.getFloat("montoExpensas_inmueble")>0){
                        dateFechaItem.setDate(rs.getDate(2));
                        tfDescripcion.setText("Expensas del mes "+new SimpleDateFormat("MM").format(rs.getDate(2))+" del "+new SimpleDateFormat("yyyy").format(rs.getDate(2)));
                        tfMonto.setText(Float.toString(rsExpensas.getFloat("montoExpensas_inmueble")));
                        cargarProducto();
                    }
                    if (rsExpensas.getFloat("montoMunicipal_inmueble")>0){
                        dateFechaItem.setDate(rs.getDate(2));
                        tfDescripcion.setText("Imp. Municipal "+new SimpleDateFormat("MM").format(rs.getDate(2))+"/"+new SimpleDateFormat("yyyy").format(rs.getDate(2)));
                        tfMonto.setText(Float.toString(rsExpensas.getFloat("montoMunicipal_inmueble")));
                        cargarProducto();
                    }
                    if (rsExpensas.getFloat("montoEMOS_inmueble")>0){
                        dateFechaItem.setDate(rs.getDate(2));
                        tfDescripcion.setText("EMOS "+new SimpleDateFormat("MM").format(rs.getDate(2))+"/"+new SimpleDateFormat("yyyy").format(rs.getDate(2)));
                        tfMonto.setText(Float.toString(rsExpensas.getFloat("montoEMOS_inmueble")));
                        cargarProducto();
                    }
                }
                if (rs.getFloat(5) > 0){
                    dateFechaItem.setDate(rs.getDate(2));
                    tfDescripcion.setText("Bonificacion saldo anterior");
                    tfMonto.setText(Float.toString(rs.getFloat(5)*-1));
                    cargarProducto();
                }
            } 
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1395 en cargarItems de la facturacion: "+ex.toString());
        }
    }
        
    //----------------------------RECIBO----------------------------------------
    boolean cargandoCliente = false;
    private String nombreClienteRValidado = "";

    private void invalidarClienteRecibo() {
        id_clienteR = -1;
        nombreClienteRValidado = "";
        tfCuitR.setText("");
        tfDireccionR.setText("");
        tfCiudadR.setText("");
        tfProvinciaR.setText("");
    }

    private void cargarClienteR() {
        if (cargandoCliente) {
            return;
        }

        String nombre = tfPersonaR.getText().trim();

        if (nombre.isEmpty()) {
            invalidarClienteRecibo();
            return;
        }

        if (id_clienteR > 0 && nombre.equals(nombreClienteRValidado)) {
            return;
        }

        cargandoCliente = true;
        invalidarClienteRecibo();

        try {
            // Literal escapado de PostgreSQL para la API actual de SqlMetodo.
            String nombreSql = "E'" + nombre.replace("\\", "\\\\")
                    .replace("'", "''") + "'";

            String consulta =
                    "SELECT p.id_persona, p.razonsocial_persona, p.nrodoc_persona, "
                    + "p.direccion_persona, c.nombre_ciudad, pr.nombre_provincia "
                    + "FROM inmobiliaria.persona p "
                    + "LEFT JOIN inmobiliaria.ciudad c ON c.id_ciudad = p.id_ciudad_persona "
                    + "LEFT JOIN inmobiliaria.provincia pr ON pr.id_provincia = c.id_provincia_ciudad "
                    + "WHERE lower(p.razonsocial_persona) = lower(" + nombreSql + ") "
                    + "AND p.tipo_persona NOT IN ('Titular', 'Administrador') "
                    + "LIMIT 2";

            boolean duplicado = false;

            try (ResultSet rs = SqlMetodo.runQuery(consulta)) {
                if (rs == null) {
                    throw new SQLException("La consulta de cliente no devolvió un resultado.");
                }

                if (rs.next()) {
                    int id = rs.getInt("id_persona");
                    String razonSocial = rs.getString("razonsocial_persona");
                    String documento = rs.getString("nrodoc_persona");
                    String direccion = rs.getString("direccion_persona");
                    String ciudad = rs.getString("nombre_ciudad");
                    String provincia = rs.getString("nombre_provincia");

                    duplicado = rs.next();

                    if (!duplicado) {
                        tfPersonaR.setText(razonSocial);
                        tfCuitR.setText(documento);
                        tfDireccionR.setText(direccion);
                        tfCiudadR.setText(ciudad);
                        tfProvinciaR.setText(provincia);
                        nombreClienteRValidado = razonSocial.trim();
                        id_clienteR = id;
                        return;
                    }
                }
            }

            if (duplicado) {
                JOptionPane.showMessageDialog(this,
                        "Hay más de un cliente con ese nombre. "
                        + "No se puede identificar a cuál corresponde el recibo.");
                return;
            }

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "No se encontró al cliente.\n¿Querés darlo de alta?",
                    "Facturación",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                if (Instancias.getInstance().abmPersona == null) {
                    Instancias.getInstance().abmPersona = new ABM.AbmPersona();
                }
                Instancias.getInstance().abmPersona.mostrar(nombre);
            }
        } catch (SQLException ex) {
            invalidarClienteRecibo();
            Datos.Procedimientos.escribirEnLog("Error en cargarClienteR: " + ex);
            JOptionPane.showMessageDialog(this, "No se pudo consultar el cliente.");
        } finally {
            cargandoCliente = false;
        }
    }
    
    private void cargarObjetoComprobante(){
        comp.setNumeroComprobante(maxFactura);
        comp.setFechaComprobante(dateFecha.getDate());
        comp.setTotalComprobante(Float.parseFloat(tfTotal.getText()));
        comp.setClienteComprobante(id_alquiler);
        String tipo = "Recibo de Alquiler";
        comp.setTipoComprobante(tipo);
        //RENGLONES
        LinkedList<Tripla> items = new LinkedList();
        for (int i = 0; i < item.size(); i++){
            Tripla p; 
            try {
                p = new Tripla (new SimpleDateFormat("dd/MM/yyyy").parse(tblTalonario.getValueAt(i, 0).toString()),tblTalonario.getValueAt(i, 1).toString(),Float.parseFloat(tblTalonario.getValueAt(i, 2).toString()));
                items.add(p);
            } catch (ParseException ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 1454 en cargarObjetoComprobante de la facturacion: "+ex.toString());
            }
             
        }
        comp.setItemComprobante(items);
        //PAGOS
        comp.setPagoComprobante(armarPagos(tfTalonarioEfe, tfTalonarioCheque));
        //SERVICIOS ABONADOS
        LinkedList<Tripla> servicios = new LinkedList();
        if (chkMunicipal.isSelected()) servicios.add(new Tripla(1, 1, "MUNICIPAL")); else servicios.add(new Tripla(0, 1, "MUNICIPAL"));
        if (chkEmos.isSelected()) servicios.add(new Tripla(1, 2, "EMOS")); else servicios.add(new Tripla(0, 2, "EMOS"));
        if (chkExpensas.isSelected()) servicios.add(new Tripla(1, 3, "EXPENSAS")); else servicios.add(new Tripla(0, 3, "EXPENSAS"));
        comp.setServicios(servicios);        
        comp.setObservacion(taObsTalonario.getText());        
    }    
    
    private void cargarObjetoComprobanteLiq(){
        compLiq.setNumeroComprobante(maxLiquidacion);
        compLiq.setFechaComprobante(dateFechaLiq.getDate());
        compLiq.setTotalComprobante(Float.parseFloat(tfTotalLiq.getText()));
        compLiq.setClienteComprobante(id_alquilerliquidacion);
        String tipo = "Liquidacion";
        compLiq.setTipoComprobante(tipo);
        LinkedList<Tripla> items = new LinkedList();
        for (int i = 0; i < itemLiq.size(); i++){
            Tripla p; 
            try {
                p = new Tripla (new SimpleDateFormat("dd/MM/yyyy").parse(tblTalonarioLiq.getValueAt(i, 0).toString()),tblTalonarioLiq.getValueAt(i, 1).toString(),Float.parseFloat(tblTalonarioLiq.getValueAt(i, 2).toString()));
                items.add(p);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
             
        }
        compLiq.setItemComprobante(items);
        compLiq.setPagoComprobante(armarPagos(tfLiquidacionEfe, tfLiquidacionCheque));
        
        compLiq.setObservacion(taObsLiquidacion.getText());
    }    
    
    private void cargarObjetoComprobanteRecibo(){
        comp.setNumeroComprobante(maxRecibo);
        comp.setFechaComprobante(dateFechaR.getDate());
        comp.setTotalComprobante(Float.parseFloat(tfTotalR.getText()));
        comp.setClienteComprobante(tfPersonaR.getText().trim().isEmpty() ? 1 : id_clienteR);
        comp.setTipoComprobante("Recibo X");
        comp.setObservacion(taConceptoR.getText());
        comp.setPagoComprobante(armarPagos(tfReciboEfe, tfReciboCheque));
    }
            
    public void cargarNuevoRecibo(String nroComp, Date fecha, LinkedList<Tripla> pagos, String nombrePersona,
                                      String motivo, float totalRecibo){
        this.tabComp.setSelectedIndex(1);
        this.dateFechaR.setDate(fecha);
        this.lbNroFacturaR.setText("Nº "+nroComp);        
        tfPersonaR.setText(nombrePersona);
        cargarClienteR();
        BigDecimal total = new BigDecimal(Float.toString(totalRecibo))
                .setScale(2, RoundingMode.HALF_UP);
        tfPesosR.setText(total.toPlainString());
        tfTotalR.setText(total.toPlainString());
        taConceptoR.setText(motivo);

        BigDecimal efectivo = BigDecimal.ZERO;
        BigDecimal cheque = BigDecimal.ZERO;
        for (Tripla pago : pagos) {
            BigDecimal monto = new BigDecimal(pago.getTercero().toString());
            if ("Cheque".equals(pago.getPrimero())) {
                cheque = cheque.add(monto);
            } else {
                efectivo = efectivo.add(monto);
            }
        }
        if (pagos.isEmpty()) {
            efectivo = total;
        }
        tfReciboEfe.setText(efectivo.setScale(2, RoundingMode.HALF_UP).toPlainString());
        tfReciboCheque.setText(cheque.setScale(2, RoundingMode.HALF_UP).toPlainString());
    }  
            
    //-----------------------LIQUIDACION----------------------------------------
        
    public void cargarLiquidacion(int idContratoAlq){
        ResultSet rs = SqlMetodo.runQuery("SELECT tipo_inmueble, direccion_inmueble, id_propietario_inmueble, comision_contratoalquiler FROM inmobiliaria.contratoalquiler "
                    + " INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler\n"
                    + " WHERE  id_contratoalquiler = "+idContratoAlq);
        try {
            if (rs.next()){
                limpiarPantalla();
                id_alquilerliquidacion = idContratoAlq;
                tfTipoInmuebleLiq.setText(rs.getString(1));
                tfDireccionInmuebleLiq.setText(rs.getString(2));
                cargarPropietario(rs.getInt(3));                
                id_comprobantealquiler_asociado = cargarItemsLiq(idContratoAlq);
            } 
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1328 en cargarContacto de la facturacion: "+ex.toString());
        }
    }
    
    private void cargarPropietario(int idCli){
        String consulta= "SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                         "mail_persona, telefono_persona, direccion_persona,  \n" +
                         "nombre_ciudad, nombre_provincia\n" +
                        " FROM inmobiliaria.persona INNER JOIN inmobiliaria.ciudad ON id_ciudad_persona = id_ciudad "+
                        "INNER JOIN inmobiliaria.provincia ON id_provincia_ciudad =  id_provincia "+ 
                        "WHERE id_persona = "+idCli+" and tipo_persona<>'Titular' and tipo_persona<>'Administrador'";
        ResultSet join= SqlMetodo.runQuery(consulta);
        try {
            if (join.next()){
                tfPropietario.setText(join.getString(2));
                tfCuitPropietario.setText(join.getString(4));
            } 
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1352 en cargarCliente de la facturacion: "+ex.toString());
        }  
    }

    private int cargarItemsLiq(int idContratoAlq){
        ResultSet rs = SqlMetodo.runQuery("SELECT id_comprobantealquiler, tipo_comprobantealquiler, nro_comprobantealquiler, \n" +
            "       total_comprobantealquiler, fecha_comprobantealquiler, id_contratoalquiler_comprobantealquiler, \n" +
            "       id_vendedor_comprobantealquiler, observacion_comprobantealquiler, \n" +
            "       estado_comprobantealquiler, comision_contratoalquiler, tipo_comision_contratoalquiler\n" +
            "  FROM inmobiliaria.comprobantealquiler\n" +
            "  INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_comprobantealquiler \n" +
            "  WHERE estado_comprobantealquiler='Aprobado' AND tipo_comprobantealquiler='Recibo de Alquiler' AND id_comprobante_liquidacion=0 AND id_contratoalquiler_comprobantealquiler = "+idContratoAlq+
            "  ORDER BY id_comprobantealquiler ASC");
        try {
            if (rs.next()){
                ResultSet rsItems = SqlMetodo.runQuery(" SELECT descripcion_item, fecha_item, monto_item "
                        + " FROM inmobiliaria.item "
                        + " WHERE id_comprobantealquiler_item="+rs.getString("id_comprobantealquiler"));
                double totalAlq = 0;
                double recargo = 0;
                while (rsItems.next()){
                    dateFechaItemLiq.setDate(rs.getDate("fecha_comprobantealquiler"));
                    tfDescripcionLiq.setText(rsItems.getString("descripcion_item"));
                    tfMontoLiq.setText(rsItems.getString("monto_item"));
                    cargarProductoLiq();
                    if (rsItems.getString("descripcion_item").startsWith("Alquiler del mes") && totalAlq==0){
                        totalAlq = rsItems.getDouble("monto_item");
                    }
                    if (rsItems.getString("descripcion_item").trim().equals("Recargo por retraso en el pago")){
                        recargo = rsItems.getDouble("monto_item");
                    }
                    
                }
                                
                dateFechaItemLiq.setDate(new Date());
                tfDescripcionLiq.setText("Administración");
                if (rs.getInt("tipo_comision_contratoalquiler")==1){
                    tfMontoLiq.setText(""+(-1*(totalAlq+recargo)*(rs.getDouble("comision_contratoalquiler")/100)));
                } else {
                    tfMontoLiq.setText(""+(-1*rs.getDouble("comision_contratoalquiler")));
                }
                cargarProductoLiq();
                return rs.getInt("id_comprobantealquiler");
            } else {
                return -1;
            }             
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }    
    
    //-----------------------Funciones De Limpieza.-----------------------------
    private void quitarProductoDeTabla(int fila, javax.swing.JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(fila);
        tabla.setModel(modelo);
    }
    
    public void limpiarTabla(javax.swing.JTable tabla, LinkedList<Tripla> lst){
        while (lst.size() != 0){
            quitarProductoDeTabla(lst.size()-1, tabla);
            lst.remove(lst.size()-1);
        }    
    }
    
    
    public void limpiarCliente(){
        tfPersona.setText("");
        tfCuit.setText("");
        limpiarItem();
        tfTipoInmueble.setText("");
        tfDireccionInmueble.setText("");
    }
    
    public void limpiarPropietario(){
        tfPropietario.setText("");
        tfCuitPropietario.setText("");
        limpiarItemLiq();
        tfTipoInmuebleLiq.setText("");
        tfDireccionInmuebleLiq.setText("");
    }
    
    public void limpiarPantalla(){
        comp = new Comprobante();
        id_alquiler = -1;
        id_alquilerliquidacion = -1;
        id_comprobantealquiler_asociado = -1;
        limpiarCamposPago(tfTalonarioEfe, tfTalonarioCheque);
        limpiarCamposPago(tfLiquidacionEfe, tfLiquidacionCheque);
        limpiarTabla(tblTalonario, item);
        limpiarTabla(tblTalonarioLiq, itemLiq);
        limpiarCliente();
        limpiarPropietario();
        tfTotal.setText("0");
        tfCuit.setText("");
        tfTotalLiq.setText("0");
        tfCuitPropietario.setText("");
        dateFecha.setDate(Calendar.getInstance().getTime());
        dateFechaLiq.setDate(Calendar.getInstance().getTime());
        calcularNroComprobantes();
        comp = new Comprobante();
        compR = new Comprobante();
        compLiq = new Comprobante();
        chkEmos.setSelected(true);
        chkExpensas.setSelected(true);
        chkMunicipal.setSelected(true);
        taObsLiquidacion.setText("");
        taObsTalonario.setText("");
    }
    
    public void limpiarClienteRecibo(){
        tfPersonaR.setText("");
        invalidarClienteRecibo();
    }
    
    public void limpiarPantallaRecibo(){        
        limpiarCamposPago(tfReciboEfe, tfReciboCheque);
        compR = new Comprobante();
        id_clienteR = -1;
        limpiarClienteRecibo();
        tfPesosR.setText("0");
        tfTotalR.setText("0");
        taConceptoR.setText("");
    }
    
    public void limpiarPantallaLiquidacion(){ 
        limpiarTabla(tblTalonarioLiq, itemLiq);       
        limpiarCamposPago(tfLiquidacionEfe, tfLiquidacionCheque);
        tfTotalLiq.setText("0");
        compLiq = new Comprobante();
        id_alquilerliquidacion = -1;
        id_comprobantealquiler_asociado = -1;
    }
    
    public void limpiarItem(){
        tfMonto.setText("0");
        tfDescripcion.setText("");
        dateFechaItem.setDate(Calendar.getInstance().getTime());
    }
    
    public void limpiarItemLiq(){
        tfMontoLiq.setText("0");
        tfDescripcionLiq.setText("");
        dateFechaItemLiq.setDate(Calendar.getInstance().getTime());
    }
    //Calculos
    private void calcularNroComprobantes(){
        String consulta="(SELECT coalesce(Max(nro_comprobante),0), tipo_comprobante  FROM inmobiliaria.comprobante WHERE tipo_comprobante = 'Recibo X' GROUP BY  tipo_comprobante)\n" +
                        "UNION\n" +
                        "(SELECT coalesce(Max(nro_comprobantealquiler),0), tipo_comprobantealquiler FROM inmobiliaria.comprobantealquiler WHERE tipo_comprobantealquiler = 'Recibo de Alquiler' GROUP BY  tipo_comprobantealquiler)\n" +
                        "UNION\n" +
                        "(SELECT coalesce(Max(nro_comprobantealquiler),0), tipo_comprobantealquiler FROM inmobiliaria.comprobantealquiler WHERE tipo_comprobantealquiler = 'Liquidacion' GROUP BY  tipo_comprobantealquiler)";
        ResultSet nroComps= SqlMetodo.runQuery(consulta);
        maxFactura = 0;
        maxRecibo = 0;
        maxLiquidacion = 0;
        try {
            while (nroComps.next()){
                if (nroComps.getString(2).equals("Recibo X"))
                    maxRecibo = nroComps.getInt(1);
                if (nroComps.getString(2).equals("Recibo de Alquiler"))
                    maxFactura = nroComps.getInt(1);
                if (nroComps.getString(2).equals("Liquidacion"))
                    maxLiquidacion = nroComps.getInt(1);
            }
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en linea 1207 en calcularNroComprobantes de la facturacion: "+ex.toString());
        }
        maxFactura ++;
        maxRecibo ++;
        maxLiquidacion ++;
        lbNroFactura.setText("Nº 0001-"+Datos.Procedimientos.completaConCero(Integer.toString(maxFactura), 8));
        lbNroFacturaR.setText("Nº 0001-"+Datos.Procedimientos.completaConCero(Integer.toString(maxRecibo), 8));
        lbNroFacturaLiq.setText("Nº 0001-"+Datos.Procedimientos.completaConCero(Integer.toString(maxLiquidacion), 8));
    }
    
    //Controles
    private boolean controlGeneral(){
        if (id_alquiler == -1){
            JOptionPane.showMessageDialog(this, "Ingrese un alquiler para poder generar el comprobante");
            return false;
        }
        if (Float.parseFloat(tfTotal.getText()) == 0){
            JOptionPane.showMessageDialog(this, "El total del comprobante no puede ser cero");
            return false;
        }
        return controlPago(tfTotal, tfTalonarioEfe, tfTalonarioCheque);
    }
    
    private boolean controlGeneralLiq() {
        if (id_alquilerliquidacion <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccioná un alquiler para generar la liquidación.");
            return false;
        }

        if (id_comprobantealquiler_asociado <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No hay un recibo de alquiler pendiente asociado a esta liquidación. "
                    + "Volvé a seleccionar el alquiler.");
            return false;
        }

        if (leerTotal(tfTotalLiq).signum() == 0) {
            JOptionPane.showMessageDialog(this,
                    "El total de la liquidación no puede ser cero.");
            return false;
        }

        return controlPago(tfTotalLiq, tfLiquidacionEfe, tfLiquidacionCheque);
    }
    

    private boolean controlGeneralRecibo() {
        if (!actualizarMontoRecibo() || leerTotal(tfTotalR).signum() <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Ingresá un importe positivo con hasta dos decimales.");
            tfPesosR.requestFocusInWindow();
            return false;
        }

        if (taConceptoR.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el concepto");
            return false;
        }

        if (!controlPago(tfTotalR, tfReciboEfe, tfReciboCheque)) {
            return false;
        }

        String nombre = tfPersonaR.getText().trim();
        if (!nombre.isEmpty()) {
            cargarClienteR();

            if (id_clienteR <= 0
                    || !tfPersonaR.getText().trim().equals(nombreClienteRValidado)) {
                return false;
            }
        }

        return true;
    }
    

    private void configurarCamposPago() {
        JTextField[] campos = {
            tfTalonarioEfe, tfTalonarioCheque, tfReciboEfe,
            tfReciboCheque, tfLiquidacionEfe, tfLiquidacionCheque
        };
        for (JTextField campo : campos) {
            campo.setHorizontalAlignment(JTextField.RIGHT);
            campo.setText("0");
        }
        tfTotalR.setText("0");
    }

    private void limpiarCamposPago(JTextField efectivo, JTextField cheque) {
        efectivo.setText("0");
        cheque.setText("0");
    }

    private static BigDecimal leerImportePago(JTextField campo) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            return BigDecimal.ZERO;
        }
        if (!texto.matches("(?:[0-9]+(?:[.,][0-9]{1,2})?|[.,][0-9]{1,2})")) {
            throw new NumberFormatException("Importe inválido");
        }
        BigDecimal importe = new BigDecimal(texto.replace(',', '.'));
        if (Float.isInfinite(importe.floatValue())) {
            throw new NumberFormatException("Importe fuera de rango");
        }
        return importe;
    }

    private static BigDecimal leerTotal(JTextField campo) {
        String texto = campo.getText().trim();
        return texto.isEmpty() ? BigDecimal.ZERO : new BigDecimal(texto.replace(',', '.'));
    }

    private void sugerirEfectivo(JTextField total, JTextField efectivo, JTextField cheque) {
        try {
            BigDecimal saldo = leerTotal(total).subtract(leerImportePago(cheque));
            efectivo.setText(saldo.max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP)
                    .toPlainString());
        } catch (NumberFormatException ex) {
            // No pisar los importes mientras el cheque sea inválido.
        }
    }

    private boolean controlPago(JTextField total, JTextField efectivo, JTextField cheque) {
        JTextField campo = efectivo;
        try {
            BigDecimal suma = leerImportePago(efectivo);
            campo = cheque;
            suma = suma.add(leerImportePago(cheque));
            // Los comprobantes negativos se pueden emitir sin registrar un pago.
            BigDecimal esperado = leerTotal(total).max(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
            if (suma.compareTo(esperado) != 0) {
                JOptionPane.showMessageDialog(this, "Efectivo más cheque debe sumar "
                        + esperado.toPlainString() + ".");
                efectivo.requestFocusInWindow();
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            String tipo = campo == efectivo ? "Efectivo" : "Cheque";
            JOptionPane.showMessageDialog(this, tipo
                    + " debe ser un importe no negativo con hasta dos decimales.");
            campo.requestFocusInWindow();
            return false;
        }
    }

    private LinkedList<Tripla> armarPagos(JTextField efectivo, JTextField cheque) {
        LinkedList<Tripla> pagos = new LinkedList<>();
        agregarPago(pagos, "Efectivo", efectivo);
        agregarPago(pagos, "Cheque", cheque);
        return pagos;
    }

    private void agregarPago(LinkedList<Tripla> pagos, String tipo, JTextField campo) {
        BigDecimal monto = leerImportePago(campo);
        if (monto.signum() > 0) {
            pagos.add(new Tripla(tipo, monto.floatValue(), null));
        }
    }
    
     
    public boolean controlProducto(){
        if (this.tfDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una descripción");
            return false;
        }
        if (!Datos.Procedimientos.isNumber(tfMonto.getText())){
            JOptionPane.showMessageDialog(this, "El monto debe ser un numero");
            tfMonto.setText("0");
            return false;
        }
        return true;
    }
     
    public boolean controlProductoLiq(){
        if (this.tfDescripcionLiq.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una descripcion");
            return false;
        }
        if (!Datos.Procedimientos.isNumber(tfMontoLiq.getText())){
            JOptionPane.showMessageDialog(this, "El monto debe ser un numero");
            tfMontoLiq.setText("0");
            return false;
        }
        return true;
    }
    
    //Impresiones
    public void imprimirFactura(){
        ImpresionComprobante ic = new ImpresionComprobante();
        ic.imprimirDB(comp.getIdComprobante());
    }
    
    public void imprimirRecibo(){
        ImpresionComprobante ic = new ImpresionComprobante();
        ic.imprimirReciboDB(comp.getIdComprobante());    
        limpiarPantallaRecibo(); 
    }    
    
    public void imprimirLiquidacion(){
        ImpresionComprobante ic = new ImpresionComprobante();
        ic.imprimirDB(compLiq.getIdComprobante());       
    }    
        
    //Otras
    private int agregarFila(javax.swing.JTable tabla){
        int fila = tabla.getModel().getRowCount();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setNumRows(fila + 1);
        tabla.setModel(modelo);
        return fila;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnAgregar;
    private org.edisoncor.gui.button.ButtonAction btnAgregarLiq;
    private org.edisoncor.gui.button.ButtonAction btnBuscarClienteR;
    private org.edisoncor.gui.button.ButtonAction btnBuscarContrato;
    private org.edisoncor.gui.button.ButtonAction btnBuscarContratoLiq;
    private org.edisoncor.gui.button.ButtonAction btnFacturar;
    private org.edisoncor.gui.button.ButtonAction btnGenerarLiquidacion;
    private org.edisoncor.gui.button.ButtonAction btnGenerarR;
    private javax.swing.JCheckBox chkEmos;
    private javax.swing.JCheckBox chkExpensas;
    private javax.swing.JCheckBox chkMunicipal;
    private com.toedter.calendar.JDateChooser dateFecha;
    private com.toedter.calendar.JDateChooser dateFechaItem;
    private com.toedter.calendar.JDateChooser dateFechaItemLiq;
    private com.toedter.calendar.JDateChooser dateFechaLiq;
    private com.toedter.calendar.JDateChooser dateFechaR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbConceptoR;
    private javax.swing.JLabel lbDireccionInmueble;
    private javax.swing.JLabel lbDireccionInmueble1;
    private javax.swing.JLabel lbDireccionR;
    private javax.swing.JLabel lbDoc;
    private javax.swing.JLabel lbDoc1;
    private javax.swing.JLabel lbDocR;
    private javax.swing.JLabel lbNroFactura;
    private javax.swing.JLabel lbNroFacturaLiq;
    private javax.swing.JLabel lbNroFacturaLiq1;
    private javax.swing.JLabel lbNroFacturaLiq2;
    private javax.swing.JLabel lbNroFacturaLiq3;
    private javax.swing.JLabel lbNroFacturaR;
    private javax.swing.JLabel lbPersona;
    private javax.swing.JLabel lbPersona1;
    private javax.swing.JLabel lbPersonaR;
    private javax.swing.JLabel lbPesosR;
    private javax.swing.JLabel lbTipoInmueble;
    private javax.swing.JLabel lbTipoInmueble1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotal1;
    private javax.swing.JLabel lbTotalR;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    private javax.swing.JTextArea taConceptoR;
    private javax.swing.JTextArea taObsLiquidacion;
    private javax.swing.JTextArea taObsTalonario;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabComp;
    private javax.swing.JTable tblTalonario;
    private javax.swing.JTable tblTalonarioLiq;
    private javax.swing.JTextField tfCiudadR;
    private javax.swing.JTextField tfCuit;
    private javax.swing.JTextField tfCuitPropietario;
    private javax.swing.JTextField tfCuitR;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfDescripcionLiq;
    private javax.swing.JTextField tfDireccionInmueble;
    private javax.swing.JTextField tfDireccionInmuebleLiq;
    private javax.swing.JTextField tfDireccionR;
    private javax.swing.JTextField tfLiquidacionCheque;
    private javax.swing.JTextField tfLiquidacionEfe;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfMontoLiq;
    private javax.swing.JTextField tfPersona;
    private javax.swing.JTextField tfPersonaR;
    private javax.swing.JTextField tfPesosR;
    private javax.swing.JTextField tfPropietario;
    private javax.swing.JTextField tfProvinciaR;
    private javax.swing.JTextField tfReciboCheque;
    private javax.swing.JTextField tfReciboEfe;
    private javax.swing.JTextField tfTalonarioCheque;
    private javax.swing.JTextField tfTalonarioEfe;
    private javax.swing.JTextField tfTipoInmueble;
    private javax.swing.JTextField tfTipoInmuebleLiq;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTotalLiq;
    private javax.swing.JTextField tfTotalR;
    // End of variables declaration//GEN-END:variables
}
