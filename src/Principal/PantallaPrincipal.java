package Principal;

import ABM.ABMInmuebles;
import Busqueda.BusquedaAvanzada;
import Datos.Instancias;
import Facturacion.Facturacion;
import Listados.ListaContratos;
import Objetos.Tripla;
import ProcedimientosSQL.Conexion;
import ProcedimientosSQL.SqlMetodo;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PantallaPrincipal extends javax.swing.JFrame implements MouseListener, WindowListener, ItemListener, KeyListener, ActionListener {

    String condicionFiltro = "";
    String tablasInmueble = "inmobiliaria.inmueble";
    
    public PantallaPrincipal() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) { 
            Datos.Procedimientos.escribirEnLog("Error liean 49 en el constructor de la pantallaPrincipal: " + e.getMessage()); 
        }        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        dtCajaDiaria.setDate(new java.util.Date());
        llenarTablasCaja();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tabbedPaneHeader1 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panel5 = new org.edisoncor.gui.panel.Panel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblInmuebles = new javax.swing.JTable();
        cbTipoI = new javax.swing.JComboBox();
        btnBuscar = new org.edisoncor.gui.button.ButtonAction();
        cbEstadoInm = new javax.swing.JComboBox();
        btnLimpiar = new org.edisoncor.gui.button.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        btnNuevoI = new org.edisoncor.gui.button.ButtonColoredAction();
        tfBuscadorInmueble = new javax.swing.JTextField();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnNuevo = new org.edisoncor.gui.button.ButtonAction();
        lbBuscador = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        panel3 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlquieres = new javax.swing.JTable();
        btnAbonar = new org.edisoncor.gui.button.ButtonAction();
        panel4 = new org.edisoncor.gui.panel.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlquieresTodos = new javax.swing.JTable();
        btnDeshacerAbonado = new org.edisoncor.gui.button.ButtonAction();
        panel6 = new org.edisoncor.gui.panel.Panel();
        panel7 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEgresos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        btnGasto = new org.edisoncor.gui.button.ButtonAction();
        dtCajaDiaria = new org.jdesktop.swingx.JXDatePicker();
        btnReporteCaja = new org.edisoncor.gui.button.ButtonAction();
        btnRefrezcar = new org.edisoncor.gui.button.ButtonAction();
        btnAporte = new org.edisoncor.gui.button.ButtonAction();
        tfTotalEgreso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfTotalIngreso = new javax.swing.JTextField();
        tfTotalCaja = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfTotalIngreso1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnFacturacion = new javax.swing.JButton();
        btnContrato = new javax.swing.JButton();
        btnBrowser = new javax.swing.JButton();
        btnOpciones = new javax.swing.JButton();
        btnListados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menú Principal");
        addWindowListener(this);

        panel1.setColorPrimario(new java.awt.Color(102, 102, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        panel5.setColorPrimario(new java.awt.Color(0, 102, 204));
        panel5.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tblInmuebles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblInmuebles.addMouseListener(this);
        tblInmuebles.addKeyListener(this);
        jScrollPane4.setViewportView(tblInmuebles);

        cbTipoI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbTipoI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Casa", "Departamento", "Local", "Cochera", "Campo", "Terreno", "Galpón" }));
        cbTipoI.addItemListener(this);

        btnBuscar.setText("Búsqueda Avanzada");
        btnBuscar.addMouseListener(this);

        cbEstadoInm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbEstadoInm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Alquiler", "Venta", "Alquilados", "Vendidos", "No disponibles" }));
        cbEstadoInm.addItemListener(this);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(this);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR");

        btnNuevoI.setBackground(new java.awt.Color(0, 204, 0));
        btnNuevoI.setText("Cargar Nuevo");
        btnNuevoI.addMouseListener(this);

        tfBuscadorInmueble.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfBuscadorInmueble.addKeyListener(this);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoI, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfBuscadorInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstadoInm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoInm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBuscadorInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHeader1.addTab("Inmuebles", panel5);

        panel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(this);
        tblCliente.addKeyListener(this);
        jScrollPane1.setViewportView(tblCliente);

        btnNuevo.setText("Nuevo Cliente");
        btnNuevo.addMouseListener(this);

        lbBuscador.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbBuscador.setForeground(new java.awt.Color(255, 255, 255));
        lbBuscador.setText("Buscar");

        txtBuscador.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtBuscador.addKeyListener(this);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBuscador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBuscador))
                .addContainerGap())
        );

        tabbedPaneHeader1.addTab("Clientes", panel2);

        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tblAlquieres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblAlquieres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblAlquieres.setToolTipText("");
        tblAlquieres.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAlquieres);

        btnAbonar.setText("Abonar Mes");
        btnAbonar.addMouseListener(this);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAbonar.setVisible(false);

        tabbedPaneHeader1.addTab("Alquileres Pendientes", panel3);

        panel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        tblAlquieresTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblAlquieresTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblAlquieresTodos.setToolTipText("");
        tblAlquieresTodos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblAlquieresTodos);

        btnDeshacerAbonado.setText("Deshacer ultimo mes abonado");
        btnDeshacerAbonado.addMouseListener(this);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeshacerAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(754, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeshacerAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneHeader1.addTab("Alquileres", panel4);

        panel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresos Fecha:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Egresos");

        tblEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Monto", "Descripción", "Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEgresos.getTableHeader().setReorderingAllowed(false);
        tblEgresos.addKeyListener(this);
        jScrollPane5.setViewportView(tblEgresos);
        if (tblEgresos.getColumnModel().getColumnCount() > 0) {
            tblEgresos.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Responsable", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIngresos.getTableHeader().setReorderingAllowed(false);
        tblIngresos.addKeyListener(this);
        jScrollPane6.setViewportView(tblIngresos);
        if (tblIngresos.getColumnModel().getColumnCount() > 0) {
            tblIngresos.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        btnGasto.setText("Egreso +");
        btnGasto.addMouseListener(this);

        dtCajaDiaria.addActionListener(this);

        btnReporteCaja.setText("Generar Reporte");
        btnReporteCaja.addMouseListener(this);

        btnRefrezcar.setText("Refrezcar Pantalla");
        btnRefrezcar.addMouseListener(this);

        btnAporte.setText("Aporte +");
        btnAporte.addMouseListener(this);

        tfTotalEgreso.setEditable(false);
        tfTotalEgreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Egresos:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingresos:");

        tfTotalIngreso.setEditable(false);
        tfTotalIngreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tfTotalCaja.setEditable(false);
        tfTotalCaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total:");

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class
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
        tblAdmin.getTableHeader().setReorderingAllowed(false);
        tblAdmin.addKeyListener(this);
        jScrollPane7.setViewportView(tblAdmin);
        if (tblAdmin.getColumnModel().getColumnCount() > 0) {
            tblAdmin.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Administración");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Administración");

        tfTotalIngreso1.setEditable(false);
        tfTotalIngreso1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtCajaDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addComponent(tfTotalIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(7, 7, 7)
                                .addComponent(tfTotalEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTotalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTotalIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                .addComponent(btnReporteCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefrezcar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dtCajaDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfTotalEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(tfTotalIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(14, 14, 14))
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotalIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefrezcar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporteCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPaneHeader1.addTab("Caja Diaria", panel6);

        jPanel2.setOpaque(false);

        btnFacturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFacturacion.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/iconoFacturacion.png"))); // NOI18N
        btnFacturacion.setText("Facturación");
        btnFacturacion.setActionCommand("");
        btnFacturacion.setBorder(null);
        btnFacturacion.setBorderPainted(false);
        btnFacturacion.setContentAreaFilled(false);
        btnFacturacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFacturacion.setFocusPainted(false);
        btnFacturacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFacturacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFacturacion.addMouseListener(this);

        btnContrato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnContrato.setForeground(new java.awt.Color(255, 255, 255));
        btnContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/contrato3.png"))); // NOI18N
        btnContrato.setText("Contratos");
        btnContrato.setActionCommand("");
        btnContrato.setBorder(null);
        btnContrato.setBorderPainted(false);
        btnContrato.setContentAreaFilled(false);
        btnContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContrato.setFocusPainted(false);
        btnContrato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContrato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnContrato.addMouseListener(this);

        btnBrowser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBrowser.setForeground(new java.awt.Color(255, 255, 255));
        btnBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/comprobante.png"))); // NOI18N
        btnBrowser.setText("Mis Comprobantes");
        btnBrowser.setBorder(null);
        btnBrowser.setBorderPainted(false);
        btnBrowser.setContentAreaFilled(false);
        btnBrowser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBrowser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBrowser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBrowser.addMouseListener(this);

        btnOpciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOpciones.setForeground(new java.awt.Color(255, 255, 255));
        btnOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/iconoCargaDatos.png"))); // NOI18N
        btnOpciones.setText("Cargar Datos");
        btnOpciones.setBorder(null);
        btnOpciones.setBorderPainted(false);
        btnOpciones.setContentAreaFilled(false);
        btnOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOpciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpciones.addMouseListener(this);

        btnListados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnListados.setForeground(new java.awt.Color(255, 255, 255));
        btnListados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/iconoOpciones.png"))); // NOI18N
        btnListados.setText("Opciones");
        btnListados.setBorder(null);
        btnListados.setBorderPainted(false);
        btnListados.setContentAreaFilled(false);
        btnListados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnListados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListados.addMouseListener(this);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBrowser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        tabbedPaneHeader1.getAccessibleContext().setAccessibleName("art");

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
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == dtCajaDiaria) {
            PantallaPrincipal.this.dtCajaDiariaActionPerformed(evt);
        }
    }

    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getSource() == cbTipoI) {
            PantallaPrincipal.this.cbTipoIItemStateChanged(evt);
        }
        else if (evt.getSource() == cbEstadoInm) {
            PantallaPrincipal.this.cbEstadoInmItemStateChanged(evt);
        }
    }

    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == tblInmuebles) {
            PantallaPrincipal.this.tblInmueblesKeyPressed(evt);
        }
        else if (evt.getSource() == tblCliente) {
            PantallaPrincipal.this.tblClienteKeyPressed(evt);
        }
        else if (evt.getSource() == tblEgresos) {
            PantallaPrincipal.this.tblEgresosKeyPressed(evt);
        }
        else if (evt.getSource() == tblIngresos) {
            PantallaPrincipal.this.tblIngresosKeyPressed(evt);
        }
        else if (evt.getSource() == tblAdmin) {
            PantallaPrincipal.this.tblAdminKeyPressed(evt);
        }
    }

    public void keyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == tfBuscadorInmueble) {
            PantallaPrincipal.this.tfBuscadorInmuebleKeyReleased(evt);
        }
        else if (evt.getSource() == txtBuscador) {
            PantallaPrincipal.this.txtBuscadorKeyReleased(evt);
        }
    }

    public void keyTyped(java.awt.event.KeyEvent evt) {
    }

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == tblInmuebles) {
            PantallaPrincipal.this.tblInmueblesMouseClicked(evt);
        }
        else if (evt.getSource() == tblCliente) {
            PantallaPrincipal.this.tblClienteMouseClicked(evt);
        }
        else if (evt.getSource() == btnBrowser) {
            PantallaPrincipal.this.clickListar(evt);
        }
    }

    public void mouseEntered(java.awt.event.MouseEvent evt) {
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
    }

    public void mousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == btnBuscar) {
            PantallaPrincipal.this.btnBuscarMousePressed(evt);
        }
        else if (evt.getSource() == btnLimpiar) {
            PantallaPrincipal.this.btnLimpiarMousePressed(evt);
        }
        else if (evt.getSource() == btnNuevoI) {
            PantallaPrincipal.this.btnNuevoIMousePressed(evt);
        }
        else if (evt.getSource() == btnNuevo) {
            PantallaPrincipal.this.btnNuevoMousePressed(evt);
        }
        else if (evt.getSource() == btnAbonar) {
            PantallaPrincipal.this.btnAbonarMousePressed(evt);
        }
        else if (evt.getSource() == btnDeshacerAbonado) {
            PantallaPrincipal.this.btnDeshacerAbonadoMousePressed(evt);
        }
        else if (evt.getSource() == btnGasto) {
            PantallaPrincipal.this.btnGastoMousePressed(evt);
        }
        else if (evt.getSource() == btnReporteCaja) {
            PantallaPrincipal.this.btnReporteCajaMousePressed(evt);
        }
        else if (evt.getSource() == btnRefrezcar) {
            PantallaPrincipal.this.btnRefrezcarMousePressed(evt);
        }
        else if (evt.getSource() == btnAporte) {
            PantallaPrincipal.this.btnAporteMousePressed(evt);
        }
        else if (evt.getSource() == btnFacturacion) {
            PantallaPrincipal.this.btnFacturacionMousePressed(evt);
        }
        else if (evt.getSource() == btnContrato) {
            PantallaPrincipal.this.btnContratoPresses(evt);
        }
        else if (evt.getSource() == btnBrowser) {
            PantallaPrincipal.this.clickListar(evt);
        }
        else if (evt.getSource() == btnOpciones) {
            PantallaPrincipal.this.btnOpcionesMousePressed1(evt);
        }
        else if (evt.getSource() == btnListados) {
            PantallaPrincipal.this.btnOpcionesMousePressed(evt);
        }
    }

    public void mouseReleased(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == btnReporteCaja) {
            PantallaPrincipal.this.btnReporteCajaMouseReleased(evt);
        }
    }

    public void windowActivated(java.awt.event.WindowEvent evt) {
    }

    public void windowClosed(java.awt.event.WindowEvent evt) {
    }

    public void windowClosing(java.awt.event.WindowEvent evt) {
        if (evt.getSource() == PantallaPrincipal.this) {
            PantallaPrincipal.this.formWindowClosing(evt);
        }
    }

    public void windowDeactivated(java.awt.event.WindowEvent evt) {
    }

    public void windowDeiconified(java.awt.event.WindowEvent evt) {
    }

    public void windowIconified(java.awt.event.WindowEvent evt) {
    }

    public void windowOpened(java.awt.event.WindowEvent evt) {
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnContratoPresses(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContratoPresses
        this.btnContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if (Instancias.getInstance().listaContratos == null)
            Instancias.getInstance().listaContratos = new ListaContratos();          
        Instancias.getInstance().listaContratos.mostrar();
        this.btnContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnContratoPresses

    private void clickListar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickListar
        this.btnBrowser.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if (Instancias.getInstance().browser == null)
                    Instancias.getInstance().browser = new Listados.MisComprobantes();
        Instancias.getInstance().browser.mostrar();
        this.btnBrowser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_clickListar

    private void btnOpcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionesMousePressed
        if (Instancias.getInstance().pantallaOpciones == null){
           Instancias.getInstance().pantallaOpciones = new Configuracion.PantallaOpciones();
        }
        Instancias.getInstance().pantallaOpciones.setVisible(true);
    }//GEN-LAST:event_btnOpcionesMousePressed

    private void btnOpcionesMousePressed1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionesMousePressed1
         if (Instancias.getInstance().pantallaAbmDatos == null)
           Instancias.getInstance().pantallaAbmDatos = new ABM.PantallaABMDatos();    
        Instancias.getInstance().pantallaAbmDatos.setVisible(true);
    }//GEN-LAST:event_btnOpcionesMousePressed1

    private void btnNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMousePressed
        // TODO add your handling code here:
        this.btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            if (Instancias.getInstance().abmPersona == null){
                Instancias.getInstance().abmPersona = new ABM.AbmPersona();
            }
            Instancias.getInstance().abmPersona.mostrar("");
        this.btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnNuevoMousePressed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        if (evt.getClickCount() == 2 && tblCliente.getSelectedRow()>=0) {
            if (Datos.Instancias.getInstance().abmPersona == null)
                Datos.Instancias.getInstance().abmPersona = new ABM.AbmPersona();
            Datos.Instancias.getInstance().abmPersona.mostrar(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tblClienteMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            java.awt.Toolkit.getDefaultToolkit().beep();
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir de la aplicación?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){                   
                this.dispose();
                Conexion.getInstance().close();
                Datos.Procedimientos.escribirEnLog("Fin sesión "+Calendar.getInstance().getTime().toString()+"\n");
                System.exit(0);
            }          
        } catch (SQLException ex) {
            JFrame frame= new JFrame();
            JOptionPane.showMessageDialog(frame,"Error al desconectar con la base de datos.","",JOptionPane.WARNING_MESSAGE);
            Datos.Procedimientos.escribirEnLog("Error al desconectar con la base de datos.\n"+ex.toString());
        } catch (HeadlessException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            Datos.Procedimientos.escribirEnLog("Error linea 631 del evento cerror en pantalla principal: "+ex.toString());
        }       
    }//GEN-LAST:event_formWindowClosing

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        // TODO add your handling code here:
        busquedaAvanzada();
    }//GEN-LAST:event_btnBuscarMousePressed

    private void cbTipoIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoIItemStateChanged
        // TODO add your handling code here:  
        this.condicionFiltro = "";
        this.tablasInmueble = " inmobiliaria.inmueble ";
        refrezcarListas("Inmueble");
        if (evt.getStateChange()==1){
            this.tablasInmueble = " inmobiliaria.inmueble ";            
            refrezcarListas("Inmueble");
        }
    }//GEN-LAST:event_cbTipoIItemStateChanged

    private void tblInmueblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInmueblesMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblInmuebles.getSelectedRow();
            String id = ((Tripla) tblInmuebles.getValueAt(row, 0)).getPrimero().toString();
            //String tipo = ((Tripla) tblInmuebles.getValueAt(row, 0)).getTercero().toString();            
            if (Datos.Instancias.getInstance().abmInmuebles == null){
                Datos.Instancias.getInstance().abmInmuebles = new ABMInmuebles();
            }
            Datos.Instancias.getInstance().abmInmuebles.editar(id);
            //ABM.DatosInmueble di = new ABM.DatosInmueble();
            //di.mostrar(id,tipo);
        }        
    }//GEN-LAST:event_tblInmueblesMouseClicked

    private void btnFacturacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturacionMousePressed
        // TODO add your handling code here:
        this.btnFacturacion.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if (Instancias.getInstance().facturacion == null)
            Instancias.getInstance().facturacion = new Facturacion();          
        Instancias.getInstance().facturacion.mostrar();
        this.btnFacturacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));        
    }//GEN-LAST:event_btnFacturacionMousePressed

    private void cbEstadoInmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoInmItemStateChanged
        // TODO add your handling code here:
        if (this.cbEstadoInm.getSelectedItem().toString().equals("Todos")){
            this.condicionFiltro = "";
            this.tablasInmueble = " inmobiliaria.inmueble ";
            refrezcarListas("Inmueble");
        }
        if (evt.getStateChange()==1){
            refrezcarListas("Inmueble");
        }
    }//GEN-LAST:event_cbEstadoInmItemStateChanged

    private void tblInmueblesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInmueblesKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            if(tblInmuebles.getSelectedRow()>=0)
                eliminarInmueble();
    }//GEN-LAST:event_tblInmueblesKeyPressed

    private void btnLimpiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMousePressed
        tfBuscadorInmueble.setText("");
        condicionFiltro = "";
        tablasInmueble = " inmobiliaria.inmueble ";
        refrezcarListas("Inmueble");
    }//GEN-LAST:event_btnLimpiarMousePressed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        if (tblCliente.getModel().getColumnCount() == 0) {
            refrezcarListas("Cliente");
            return;
        }

        aplicarFiltroClientes();
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void btnNuevoIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoIMousePressed
        // TODO add your handling code here:
        this.btnNuevoI.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));        
        if (Instancias.getInstance().abmInmuebles == null){
            Instancias.getInstance().abmInmuebles = new ABM.ABMInmuebles();
        }
        Instancias.getInstance().abmInmuebles.mostrar();    
        this.btnNuevoI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));         
    }//GEN-LAST:event_btnNuevoIMousePressed

    private void btnAbonarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbonarMousePressed
        int fila = tblAlquieres.getSelectedRow();
        if (fila > -1){
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente abonar mes?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){                   
                int id = Integer.parseInt(((Tripla)tblAlquieres.getValueAt(fila, 0)).getPrimero().toString());
                SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET proximocobro_contratoalquiler=(proximocobro_contratoalquiler::date + ('1 month')::interval)::date WHERE id_contratoalquiler = "+id);
                refrezcarListas("Alquiler");
                refrezcarListas("AlquilerTodos");
                JOptionPane.showMessageDialog(this, "Mes abonado con éxito.");
            }
        }
    }//GEN-LAST:event_btnAbonarMousePressed

    private void btnDeshacerAbonadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeshacerAbonadoMousePressed
        // TODO add your handling code here:
        int fila = tblAlquieresTodos.getSelectedRow();
        if (fila > -1){
            if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea restar 1 mes a la fecha de cobro?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){                   
                int id = Integer.parseInt(((Tripla)tblAlquieresTodos.getValueAt(fila, 0)).getPrimero().toString());
                SqlMetodo.runQuery("UPDATE inmobiliaria.contratoalquiler SET proximocobro_contratoalquiler=(proximocobro_contratoalquiler::date - ('1 month')::interval)::date WHERE id_contratoalquiler = "+id);
                refrezcarListas("Alquiler");
                refrezcarListas("AlquilerTodos");
                JOptionPane.showMessageDialog(this, "Se quito 1 mes a la fecha de abonado de "+tblAlquieresTodos.getValueAt(fila, 1));
            }
        }        
    }//GEN-LAST:event_btnDeshacerAbonadoMousePressed

    private void tblEgresosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEgresosKeyPressed
        // TODO add your handling code here:
        eliminarEgreso();
    }//GEN-LAST:event_tblEgresosKeyPressed

    private void tblIngresosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblIngresosKeyPressed
        // TODO add your handling code here:
        eliminarIngreso();
    }//GEN-LAST:event_tblIngresosKeyPressed

    private void btnGastoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGastoMousePressed
        // TODO add your handling code here:
        Contabilidad.AltaEgreso a = new Contabilidad.AltaEgreso(this,true);
        a.setVisible(true);
        llenarTablasCaja();
    }//GEN-LAST:event_btnGastoMousePressed

    private void dtCajaDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtCajaDiariaActionPerformed
        // TODO add your handling code here:
        llenarTablasCaja();
    }//GEN-LAST:event_dtCajaDiariaActionPerformed

    private void btnReporteCajaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteCajaMousePressed
        // TODO add your handling code here:
        llenarTablasCaja();
    }//GEN-LAST:event_btnReporteCajaMousePressed

    private void btnReporteCajaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteCajaMouseReleased
        // TODO add your handling code here:
        llenarTablasCaja();
        btnReporteCaja.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Reportes.Estadisticas.planillaCaja(dtCajaDiaria.getDate(),tblIngresos, tblEgresos, tfTotalIngreso.getText(), tfTotalEgreso.getText(), tfTotalCaja.getText());
        btnReporteCaja.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnReporteCajaMouseReleased

    private void btnRefrezcarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrezcarMousePressed
        // TODO add your handling code here:
        llenarTablasCaja();
    }//GEN-LAST:event_btnRefrezcarMousePressed

    private void btnAporteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAporteMousePressed
        Contabilidad.AltaAporte a = new Contabilidad.AltaAporte(this,true);
        a.setVisible(true);
    }//GEN-LAST:event_btnAporteMousePressed

    private void borrarCliente(int id){
        ProcedimientosSQL.SqlMetodo.runQuery("DELETE FROM inmobiliaria.persona WHERE id_persona="+id+";");  
    }
    
    private void tblClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClienteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            if(tblCliente.getSelectedRow()>=0){
                    int id = Integer.parseInt(((Tripla)tblCliente.getValueAt(tblCliente.getSelectedRow(), 0)).getPrimero().toString());
                    if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea borrar este cliente '"
                                            + "'?\nPerderá toda la infomación de este Cliente\nSe recomienda NO borrar","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){          
                        borrarCliente(id);
                        Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("Cliente");                    
                    }
                } 
    }//GEN-LAST:event_tblClienteKeyPressed

    private void tblAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAdminKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAdminKeyPressed

    private void tfBuscadorInmuebleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscadorInmuebleKeyReleased
        aplicarFiltroInmuebles();
    }//GEN-LAST:event_tfBuscadorInmuebleKeyReleased
     
    //CAJA DIARIA//
    public void llenarTablasCaja(){
        javax.swing.table.DefaultTableModel modeloE = (javax.swing.table.DefaultTableModel) tblEgresos.getModel();        
        javax.swing.table.DefaultTableModel modeloI = (javax.swing.table.DefaultTableModel) tblIngresos.getModel();        
        while(modeloE.getRowCount()>0)modeloE.removeRow(0);  
        while(modeloI.getRowCount()>0)modeloI.removeRow(0);  
        String consulta = "(SELECT id_movimiento as id, CONCAT(descripcion_movimiento,' (',persona_movimiento,')') as descripcion, tipo_movimiento as tipo,\n" +
        "  monto_movimiento as monto, id_usuario_movimiento, razonsocial_persona as nombre\n" +
        "  FROM inmobiliaria.movimiento INNER JOIN inmobiliaria.usuario ON id_usuario = id_usuario_movimiento   \n" +
        "  INNER JOIN inmobiliaria.persona ON id_persona_usuario = id_persona   \n" +
        "  WHERE fecha_movimiento ='"+dtCajaDiaria.getDate()+"')\n" +
        "UNION ALL\n" +
        "(SELECT 0 as id, \n" +
        "      (CASE WHEN cliente.id_persona = 1 THEN Concat('Recibo de Pago Nro ', nro_comprobante)\n" +
        "            ELSE Concat('Recibo de Pago Nro ', nro_comprobante,' - ', cliente.razonsocial_persona) \n" +
        "       END) as descripcion, \n" +
        "  'Pago' as tipo, \n" +
        "  monto_pago as monto, 1 as parche,vendedor.razonsocial_persona as nombre  \n" +
        "  \n" +
        "  FROM inmobiliaria.pago INNER JOIN inmobiliaria.comprobante ON (id_comprobante_pago=id_comprobante)\n" +
        "  INNER JOIN inmobiliaria.persona AS cliente ON (id_cliente_comprobante=cliente.id_persona) \n" +
        "  INNER JOIN inmobiliaria.persona AS vendedor ON (id_vendedor_comprobante=vendedor.id_persona) \n" +
        "  WHERE fecha_pago='"+dtCajaDiaria.getDate()+"' AND estado_comprobante='Aprobado')\n" +
        "UNION ALL\n" +
        " (SELECT 0 as id, Concat('Recibo de Alquiler Nro ',nro_comprobantealquiler,' - ',inquilino.razonsocial_persona) as descripcion, 'PagoAlquiler' as tipo, \n" +
        "  monto_pagoalquiler as monto, 1 as parche,vendedor.razonsocial_persona as nombre  \n" +
        "  FROM inmobiliaria.pagoalquiler INNER JOIN inmobiliaria.comprobantealquiler ON (id_comprobantealquiler_pagoalquiler=id_comprobantealquiler)\n" +
        "  INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_comprobantealquiler\n" +
        "  INNER JOIN inmobiliaria.persona AS inquilino ON (id_inquilino_contratoalquiler=inquilino.id_persona)  \n" +
        "  INNER JOIN inmobiliaria.persona AS vendedor ON (id_vendedor_comprobantealquiler=vendedor.id_persona) \n" +
        "  WHERE fecha_pagoalquiler='"+dtCajaDiaria.getDate()+"' AND tipo_comprobanteAlquiler='Recibo de Alquiler' AND estado_comprobantealquiler='Aprobado')\n"+
        "UNION ALL\n" +
        " (SELECT 0 as id, Concat('Liquidacion ',nro_comprobantealquiler,' - ',inquilino.razonsocial_persona) as descripcion, 'Egreso' as tipo, \n" +
        "  monto_pagoalquiler as monto, 1 as parche,vendedor.razonsocial_persona as nombre  \n" +
        "  FROM inmobiliaria.pagoalquiler INNER JOIN inmobiliaria.comprobantealquiler ON (id_comprobantealquiler_pagoalquiler=id_comprobantealquiler)\n" +
        "  INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler = id_contratoalquiler_comprobantealquiler\n" +
        "  INNER JOIN inmobiliaria.persona AS inquilino ON (id_inquilino_contratoalquiler=inquilino.id_persona)  \n" +
        "  INNER JOIN inmobiliaria.persona AS vendedor ON (id_vendedor_comprobantealquiler=vendedor.id_persona) \n" +
        "  WHERE fecha_pagoalquiler='"+dtCajaDiaria.getDate()+"' AND tipo_comprobanteAlquiler='Liquidacion' AND estado_comprobantealquiler='Aprobado')";
        
        ResultSet rs = SqlMetodo.runQuery(consulta);
        BigDecimal totalEgreso = BigDecimal.ZERO;
        BigDecimal totalIngreso = BigDecimal.ZERO;
        try {
            while(rs.next()){
                BigDecimal monto = rs.getBigDecimal("monto");
                if (monto == null) {
                    monto = BigDecimal.ZERO;
                }
                if (rs.getString("tipo").equals("Egreso")){
                    modeloE.setNumRows(tblEgresos.getModel().getRowCount() + 1);
                    tblEgresos.setModel(modeloE);
                    totalEgreso = totalEgreso.add(monto);
                    tblEgresos.setValueAt(new Tripla(rs.getInt("id"),null,rs.getString("monto")), tblEgresos.getModel().getRowCount()-1, 0);
                    tblEgresos.setValueAt(rs.getString("descripcion"), tblEgresos.getModel().getRowCount()-1, 1);  
                    tblEgresos.setValueAt(rs.getString("nombre"), tblEgresos.getModel().getRowCount()-1, 2); 
                } else {
                    modeloI.setNumRows(tblIngresos.getModel().getRowCount() + 1);
                    tblIngresos.setModel(modeloI);
                    totalIngreso = totalIngreso.add(monto);
                    tblIngresos.setValueAt(rs.getString("nombre"), tblIngresos.getModel().getRowCount()-1, 1);
                    tblIngresos.setValueAt(rs.getFloat("monto"), tblIngresos.getModel().getRowCount()-1, 2);
                    tblIngresos.setValueAt(new Tripla(rs.getInt("id"),null,rs.getString("descripcion")), tblIngresos.getModel().getRowCount()-1, 0);  
                }                
            }               
            tfTotalEgreso.setText(formatearTotalCaja(totalEgreso));
            tfTotalIngreso.setText(formatearTotalCaja(totalIngreso));
            tfTotalCaja.setText(formatearTotalCaja(totalIngreso.subtract(totalEgreso)));
            llenarTablaAdmin();
        } catch (Exception ex) {
            ex.printStackTrace();
            Datos.Procedimientos.escribirEnLog("PANTALLAPRINCIPAL - 1072 -"+ex.toString());
        }       
    } 
        
    private void llenarTablaAdmin(){
        try {            
            javax.swing.table.DefaultTableModel modeloAdmin = (javax.swing.table.DefaultTableModel) tblAdmin.getModel();        
            while(modeloAdmin.getRowCount()>0)modeloAdmin.removeRow(0);  
            ResultSet rs = SqlMetodo.runQuery("SELECT nro_comprobantealquiler, razonsocial_persona, monto_item  \n" +
                "FROM inmobiliaria.item  \n" +
                " INNER JOIN inmobiliaria.comprobantealquiler ON inmobiliaria.item.id_comprobantealquiler_item = inmobiliaria.comprobantealquiler.id_comprobantealquiler\n" +
                " INNER JOIN inmobiliaria.contratoalquiler ON id_contratoalquiler_comprobantealquiler = id_contratoalquiler\n" +
                " INNER JOIN inmobiliaria.persona ON id_inquilino_contratoalquiler = id_persona \n" +
                " WHERE tipo_comprobantealquiler = 'Liquidacion'\n" +
                "   AND estado_comprobantealquiler = 'Aprobado'\n" +
                "   AND descripcion_item = 'Administración'\n" +
                "   AND fecha_comprobantealquiler='"+dtCajaDiaria.getDate()+"'");
            BigDecimal total = BigDecimal.ZERO;
            while (rs.next()){
                BigDecimal montoItem = rs.getBigDecimal("monto_item");
                if (montoItem != null) {
                    total = total.subtract(montoItem);
                }                
                modeloAdmin.setNumRows(tblAdmin.getModel().getRowCount() + 1);
                tblAdmin.setModel(modeloAdmin);
                tblAdmin.setValueAt("Administración Liq Nro "+rs.getString("nro_comprobantealquiler")+"  "+rs.getString("razonsocial_persona"), tblAdmin.getModel().getRowCount()-1, 0);
                tblAdmin.setValueAt(rs.getFloat("monto_item")*-1, tblAdmin.getModel().getRowCount()-1, 1);
            }           
            
            tfTotalIngreso1.setText(formatearTotalCaja(total));
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void eliminarIngreso(){  
        if (tblIngresos.getSelectedRow()>=0){
            Tripla ingreso = (Tripla) tblIngresos.getValueAt(tblIngresos.getSelectedRow(), 0);
            if (ingreso.getTercero().toString().substring(0, 6).equals("Aporte")){
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar el ingreso?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    SqlMetodo.runQuery("DELETE FROM inmobiliaria.movimiento WHERE id_movimiento = "+ingreso.getPrimero());
                    llenarTablasCaja();
                }    
            }
        }
    }
    
    private void eliminarEgreso(){   
        if (this.tblEgresos.getSelectedRow()>=0){
            Tripla egreso = (Tripla) tblEgresos.getValueAt(tblEgresos.getSelectedRow(), 0);
            if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar el egreso?", "Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                SqlMetodo.runQuery("DELETE FROM inmobiliaria.movimiento WHERE id_movimiento = "+egreso.getPrimero());
                llenarTablasCaja();
            }   
        }        
    }    
    
    //---------
    private void aplicarFiltroInmuebles() {
        String texto = tfBuscadorInmueble.getText().trim();
        javax.swing.table.TableModel modelo = tblInmuebles.getModel();

        if (texto.isEmpty() || modelo.getColumnCount() < 5) {
            tblInmuebles.setRowSorter(null);
            return;
        }

        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter =
                new javax.swing.table.TableRowSorter<>(modelo);

        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                "(?iu)" + java.util.regex.Pattern.quote(texto), 1, 4));

        tblInmuebles.setRowSorter(sorter);
    }

    private void aplicarFiltroClientes() {
        javax.swing.table.TableModel modelo = tblCliente.getModel();
        String texto = txtBuscador.getText().trim();

        if (texto.isEmpty() || modelo.getColumnCount() == 0) {
            tblCliente.setRowSorter(null);
            return;
        }

        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter =
                new javax.swing.table.TableRowSorter<>(modelo);

        sorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                "(?iu)" + java.util.regex.Pattern.quote(texto), 0));

        tblCliente.setRowSorter(sorter);
    }    
    
    public void busquedaAvanzada(){
        BusquedaAvanzada ba = new BusquedaAvanzada(this, true);
        ba.setVisible(true);
        if (ba.busquedaRealizada){
            cbTipoI.setSelectedIndex(0);
            cbEstadoInm.setSelectedIndex(0);
            this.tablasInmueble = ba.obtenerInner();
            this.condicionFiltro = ba.obtenerCondicion();
        }
        refrezcarListas("Inmueble");
    }
    
    public void refrezcarListas(String refrescar){
        if ("Cliente".equals(refrescar)) {
            tblCliente.setRowSorter(null);
            listarPersona(
                    " WHERE tipo_persona = 'Cliente' AND estado_persona = TRUE",
                    tblCliente);
            aplicarFiltroClientes();
        }
        if(refrescar.equals("Inmueble")){
            String condicion;
            if (!cbTipoI.getSelectedItem().equals("Todos")){
                if (cbTipoI.getSelectedItem().equals("Galpón"))
                    condicion = " WHERE tipo_inmueble LIKE '%Galpon%' ";
                else
                    condicion = " WHERE tipo_inmueble LIKE '%"+this.cbTipoI.getSelectedItem()+"%' ";
            } else {
                condicion = "WHERE true ";
            }
            listarInmueble(condicion);
        }
        if(refrescar.equals("Alquiler")){
            listarAlquileres(" AND proximocobro_contratoalquiler<'"+new java.util.Date()+"'");
        }        
        if(refrescar.equals("AlquilerTodos")){
            listarAlquileresTodos("");
        }        
    }
    
    private void listarPersona(String condicion, javax.swing.JTable tbl){
       String[] nombCabecera = {"Nombre","DNI","E-Mail","Teléfono","Dirección","Localidad"};
       String consulta = "Select id_persona, razonsocial_persona, nrodoc_persona, mail_persona, telefono_persona, direccion_persona, "
                            + "(select nombre_ciudad from inmobiliaria.ciudad where id_ciudad= id_ciudad_persona) "
                            + "from inmobiliaria.persona "+condicion+" order by razonsocial_persona";
       boolean[] cantEdit = new boolean [] {false, false, false, false, false, false};
       construirTablaId(nombCabecera, cantEdit,consulta, tbl);   
    }    
    
    private void listarInmueble(String condicion) {
        String estadoInmueble = "";

        switch (cbEstadoInm.getSelectedIndex()) {
            case 1:
                estadoInmueble = " AND estado_inmueble IN "
                        + "('Alquiler', 'Alquiler-Venta', 'Rescindido', 'Finalizado') ";
                break;
            case 2:
                estadoInmueble = " AND estado_inmueble IN ('Venta', 'Alquiler-Venta') ";
                break;
            case 3:
                estadoInmueble = " AND estado_inmueble = 'Vigente' ";
                break;
            case 4:
                estadoInmueble = " AND estado_inmueble = 'Vendido' ";
                break;
            case 5:
                estadoInmueble = " AND estado_inmueble = 'No disponible' ";
                break;
        }

        String[] cabeceras = {
            "Inmueble", "Dirección y localidad", "Sector", "Servicios", "Propietario"
        };

        String consulta =
                "SELECT id_inmueble, tipo_inmueble, "
                + "CONCAT_WS(' · ', NULLIF(BTRIM(direccion_inmueble), ''), "
                + "NULLIF(CONCAT_WS(', ', NULLIF(BTRIM(nombre_ciudad), ''), "
                + "NULLIF(BTRIM(nombre_provincia), '')), '')), "
                + "nombre_sector, "
                + "CONCAT_WS(', ', "
                + "CASE WHEN agua_inmueble THEN 'Agua' END, "
                + "CASE WHEN luz_inmueble THEN 'Luz' END, "
                + "CASE WHEN gas_inmueble THEN 'Gas' END, "
                + "CASE WHEN cloaca_inmueble THEN 'Cloaca' END, "
                + "CASE WHEN pavimento_inmueble THEN 'Pavimento' END, "
                + "CASE WHEN telefono_inmueble THEN 'Telefonía' END), "
                + "razonsocial_persona "
                + "FROM " + tablasInmueble
                + " INNER JOIN inmobiliaria.sector ON id_sector = id_sector_inmueble "
                + "INNER JOIN inmobiliaria.ciudad ON id_ciudad = id_ciudad_inmueble "
                + "INNER JOIN inmobiliaria.provincia ON id_provincia = id_provincia_ciudad "
                + "INNER JOIN inmobiliaria.persona ON id_persona = id_propietario_inmueble "
                + condicion + " " + estadoInmueble + " " + condicionFiltro
                + " ORDER BY direccion_inmueble";

        tblInmuebles.setRowSorter(null);
        construirTablaId(cabeceras, new boolean[cabeceras.length], consulta, tblInmuebles);

        javax.swing.table.TableColumnModel columnas = tblInmuebles.getColumnModel();
        int[] anchos = {160, 340, 100, 170, 180};

        for (int i = 0; i < anchos.length; i++) {
            columnas.getColumn(i).setPreferredWidth(anchos[i]);
        }

        columnas.getColumn(0).setCellRenderer(
                new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object valor) {
                if (!(valor instanceof Tripla)) {
                    super.setValue(valor);
                    return;
                }

                Tripla inmueble = (Tripla) valor;
                Object tipoOriginal = inmueble.getTercero();
                String tipo = tipoOriginal == null ? "" : tipoOriginal.toString().trim();
                tipo = tipo.isEmpty() ? "Sin tipo" : tipo.replace(" - ", " / ");

                super.setValue(tipo + " · #" + inmueble.getPrimero());
            }
        });
        aplicarFiltroInmuebles();
    }
    
    private void listarAlquileres(String condicion){
        String[] nombCabecera = {"Inmueble","Cliente","Monto", "Próximo Mes Cobro"};
        String consulta = "SELECT id_contratoalquiler, direccion_inmueble, razonsocial_persona, montoactual_contratoalquiler, proximocobro_contratoalquiler FROM\n"
                + "inmobiliaria.contratoalquiler INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler\n"
                + "INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler WHERE estado_contratoalquiler='Vigente' "+condicion+"\n"
                + "ORDER BY razonsocial_persona";
        boolean[] cantEdit = new boolean [] {false, false, false, false};
        construirTablaId(nombCabecera, cantEdit,consulta, this.tblAlquieres);  
    }
    
    private void listarAlquileresTodos(String condicion){
        String[] nombCabecera = {"Inmueble","Cliente","Monto", "Próximo Mes Cobro"};
        String consulta = "SELECT id_contratoalquiler, direccion_inmueble, razonsocial_persona, montoactual_contratoalquiler, proximocobro_contratoalquiler FROM\n"
                + "inmobiliaria.contratoalquiler INNER JOIN inmobiliaria.persona ON id_persona = id_inquilino_contratoalquiler\n"
                + "INNER JOIN inmobiliaria.inmueble ON id_inmueble = id_inmueble_contratoalquiler WHERE estado_contratoalquiler='Vigente' "+condicion+"\n"
                + "ORDER BY razonsocial_persona";
        boolean[] cantEdit = new boolean [] {false, false, false, false};
        construirTablaId(nombCabecera, cantEdit,consulta, this.tblAlquieresTodos);  
    }
    
    private void construirTabla(String [] nombCabecera, final boolean[] cantEdit ,String consulta,javax.swing.JTable tblListados){
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
                    tblListados.setValueAt(rs.getString(j + 1), i, j);
                  }
                  i++;
              }
            
          } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en la linea 915 del metodo construirTabla en pantallaPrincipal: "+ex.toString());
          }
    }
    
    private void construirTablaId(String [] nombCabecera, final boolean[] cantEdit ,String consulta,javax.swing.JTable tblListados){
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
                  Tripla t = new Tripla(rs.getString(1),null, rs.getString(2));
                  tblListados.setValueAt(t, i, 0);
                  for(int j=1; j < nombCabecera.length; j++){
                      if (j==7 && !rs.getString(j + 2).isEmpty()) //Esto se hace para sacar la última coma en los servicios
                        tblListados.setValueAt(rs.getString(j + 2).substring(0, rs.getString(j + 2).length()-2), i, j);
                      else
                        tblListados.setValueAt(rs.getString(j + 2), i, j);
                      
                  }
                  i++;
              }
            
          } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en construirTablaId en pantallaPrincipal linea 947: "+ex.toString());
          }
    }
    
    private void eliminarInmueble() {
        int fila = tblInmuebles.getSelectedRow();
        if (fila < 0) {
            return;
        }

        Tripla inmueble = (Tripla) tblInmuebles.getValueAt(fila, 0);
        int id = Integer.parseInt(inmueble.getPrimero().toString());

        int opcion = JOptionPane.showConfirmDialog(
                rootPane,
                "¿Deseás eliminar el inmueble #" + id + "?",
                "Eliminar inmueble",
                JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            if (borrarInmuebleEnTransaccion(id)) {
                refrezcarListas("Inmueble");
            } else {
                JOptionPane.showMessageDialog(this, "El inmueble ya no existe.");
            }
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error al eliminar inmueble #" + id + ": " + ex);

            String mensaje = "23503".equals(ex.getSQLState())
                    ? "No se puede eliminar el inmueble porque tiene contratos "
                      + "u otros registros asociados."
                    : "No se pudo completar el borrado del inmueble.";

            JOptionPane.showMessageDialog(this, mensaje);
        }
    }

    private boolean borrarInmuebleEnTransaccion(int id) throws SQLException {
        Connection cn = Conexion.getInstance();

        if (cn == null || cn.isClosed() || !cn.getAutoCommit()) {
            throw new SQLException("No hay una conexión disponible para iniciar el borrado.");
        }

        String[] subtipos = {
            "local", "casa", "departamento", "campo", "cochera", "galpon"
        };

        cn.setAutoCommit(false);
        boolean transaccionCerrada = false;

        try {
            for (String tabla : subtipos) {
                String sql = "DELETE FROM inmobiliaria." + tabla
                        + " WHERE id_inmueble_" + tabla + " = ?";

                try (PreparedStatement ps = cn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
            }

            int filas;
            try (PreparedStatement ps = cn.prepareStatement(
                    "DELETE FROM inmobiliaria.inmueble WHERE id_inmueble = ?")) {
                ps.setInt(1, id);
                filas = ps.executeUpdate();
            }

            if (filas == 1) {
                cn.commit();
            } else {
                cn.rollback();
            }

            transaccionCerrada = true;
            return filas == 1;
        } catch (SQLException | RuntimeException ex) {
            try {
                cn.rollback();
                transaccionCerrada = true;
            } catch (SQLException rollbackEx) {
                ex.addSuppressed(rollbackEx);
            }
            throw ex;
        } finally {
            if (transaccionCerrada) {
                cn.setAutoCommit(true);
            }
        }
    }

    private static String formatearTotalCaja(BigDecimal monto) {
        return monto.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.edisoncor.gui.button.ButtonAction btnAbonar;
    org.edisoncor.gui.button.ButtonAction btnAporte;
    javax.swing.JButton btnBrowser;
    org.edisoncor.gui.button.ButtonAction btnBuscar;
    javax.swing.JButton btnContrato;
    org.edisoncor.gui.button.ButtonAction btnDeshacerAbonado;
    javax.swing.JButton btnFacturacion;
    org.edisoncor.gui.button.ButtonAction btnGasto;
    org.edisoncor.gui.button.ButtonAction btnLimpiar;
    javax.swing.JButton btnListados;
    org.edisoncor.gui.button.ButtonAction btnNuevo;
    org.edisoncor.gui.button.ButtonColoredAction btnNuevoI;
    javax.swing.JButton btnOpciones;
    org.edisoncor.gui.button.ButtonAction btnRefrezcar;
    org.edisoncor.gui.button.ButtonAction btnReporteCaja;
    public javax.swing.JComboBox cbEstadoInm;
    javax.swing.JComboBox cbTipoI;
    org.jdesktop.swingx.JXDatePicker dtCajaDiaria;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JScrollPane jScrollPane5;
    javax.swing.JScrollPane jScrollPane6;
    javax.swing.JScrollPane jScrollPane7;
    javax.swing.JLabel lbBuscador;
    org.edisoncor.gui.panel.Panel panel1;
    org.edisoncor.gui.panel.Panel panel2;
    org.edisoncor.gui.panel.Panel panel3;
    org.edisoncor.gui.panel.Panel panel4;
    org.edisoncor.gui.panel.Panel panel5;
    org.edisoncor.gui.panel.Panel panel6;
    org.edisoncor.gui.panel.Panel panel7;
    org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader1;
    javax.swing.JTable tblAdmin;
    public javax.swing.JTable tblAlquieres;
    public javax.swing.JTable tblAlquieresTodos;
    public javax.swing.JTable tblCliente;
    javax.swing.JTable tblEgresos;
    javax.swing.JTable tblIngresos;
    javax.swing.JTable tblInmuebles;
    javax.swing.JTextField tfBuscadorInmueble;
    javax.swing.JTextField tfTotalCaja;
    javax.swing.JTextField tfTotalEgreso;
    javax.swing.JTextField tfTotalIngreso;
    javax.swing.JTextField tfTotalIngreso1;
    javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
    
}
