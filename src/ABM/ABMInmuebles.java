package ABM;

import Datos.Instancias;
import static Datos.Procedimientos.obtenerUltimo;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ABMInmuebles extends javax.swing.JFrame {
    boolean editando = false;
    String idInmueble = "-1";
    String estadoInm = "Nuevo";
    /**
     * Creates new form ABMInmueble
     */
    public ABMInmuebles() {
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

        groupContrato = new javax.swing.ButtonGroup();
        groupEstado = new javax.swing.ButtonGroup();
        buttonGroupPatioC = new javax.swing.ButtonGroup();
        buttonGroupAsadorC = new javax.swing.ButtonGroup();
        buttonGroupPiletaC = new javax.swing.ButtonGroup();
        buttonGroupQuinchoC = new javax.swing.ButtonGroup();
        buttonGroupBalconD = new javax.swing.ButtonGroup();
        buttonGroupAsadorD = new javax.swing.ButtonGroup();
        buttonGroupCocheraD = new javax.swing.ButtonGroup();
        buttonGroupEstL = new javax.swing.ButtonGroup();
        buttonGroupCocinaL = new javax.swing.ButtonGroup();
        buttonGroupAireL = new javax.swing.ButtonGroup();
        buttonGroupAlamCam = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        panelTipo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chkCasa = new javax.swing.JCheckBox();
        chkDepto = new javax.swing.JCheckBox();
        chkLocal = new javax.swing.JCheckBox();
        chkCochera = new javax.swing.JCheckBox();
        chkCampo = new javax.swing.JCheckBox();
        chkTerreno = new javax.swing.JCheckBox();
        chkGalpon = new javax.swing.JCheckBox();
        btnContinuar = new org.edisoncor.gui.button.ButtonColoredAction();
        jPanel2 = new javax.swing.JPanel();
        rbtnAquiler = new javax.swing.JRadioButton();
        tfAlquiler = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtnVenta = new javax.swing.JRadioButton();
        rbtnAV = new javax.swing.JRadioButton();
        jLabel68 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        chkLuz = new javax.swing.JCheckBox();
        chkAgua = new javax.swing.JCheckBox();
        chkGas = new javax.swing.JCheckBox();
        chkCloaca = new javax.swing.JCheckBox();
        chkTelefono = new javax.swing.JCheckBox();
        chkPavimento = new javax.swing.JCheckBox();
        jLabel45 = new javax.swing.JLabel();
        tfExpensas = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        tfEMOS = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        tfMunicipal = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbLocalidad = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox();
        lbProvincia = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox();
        lbLocalidad1 = new javax.swing.JLabel();
        cbSector = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDimension = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbLocalidad2 = new javax.swing.JLabel();
        cbPropietario = new javax.swing.JComboBox();
        buttonAction1 = new org.edisoncor.gui.button.ButtonAction();
        buttonAction2 = new org.edisoncor.gui.button.ButtonAction();
        panelEstado = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rbtnDisp = new javax.swing.JRadioButton();
        rbtnNoDisp = new javax.swing.JRadioButton();
        tabbInmueble = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panelCasa = new org.edisoncor.gui.panel.Panel();
        jLabel27 = new javax.swing.JLabel();
        tfEdificadoC = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObsC = new javax.swing.JTextArea();
        tfAmbientesC = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tfDormC = new javax.swing.JTextField();
        tfBanoC = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tfGarajeC = new javax.swing.JTextField();
        tfPisosC = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        rbtnPatioNC = new javax.swing.JRadioButton();
        rbtnPatioSC = new javax.swing.JRadioButton();
        rbtnAsaSC = new javax.swing.JRadioButton();
        rbtnAsaNC = new javax.swing.JRadioButton();
        rbtnPileNC = new javax.swing.JRadioButton();
        rbtnPileSC = new javax.swing.JRadioButton();
        rbtnQuinSC = new javax.swing.JRadioButton();
        rbtnQuinNC = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelDepto = new org.edisoncor.gui.panel.Panel();
        jPanel5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        tfEdificadoD = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tfAmbientesD = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        tfBanoD = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        tfDormD = new javax.swing.JTextField();
        rbtnBalconSD = new javax.swing.JRadioButton();
        rbtnBalconND = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rbtnAsadorSD = new javax.swing.JRadioButton();
        rbtnAsadorND = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        rbtnCocheraSD = new javax.swing.JRadioButton();
        rbtnCocheraND = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taObsD = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        cbPisoD = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        tfDptoD = new javax.swing.JTextField();
        panelLocal = new org.edisoncor.gui.panel.Panel();
        jPanel6 = new javax.swing.JPanel();
        lbLocalidad3 = new javax.swing.JLabel();
        cbCalefL = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        tfEdificadoL = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfCapacidadCL = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rbtnEstSL = new javax.swing.JRadioButton();
        rbtnEstNL = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        tfAmbientesL = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        rbtnCocinaSL = new javax.swing.JRadioButton();
        rbtnCocinaNL = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        tfBanosL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rbtnAireSL = new javax.swing.JRadioButton();
        rbtnAireNL = new javax.swing.JRadioButton();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taObsL = new javax.swing.JTextArea();
        panelCochera = new org.edisoncor.gui.panel.Panel();
        jPanel7 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        tfCapacidadCo = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        tfCapacidadTCo = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        tfOficinasCo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfBanosCo = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        tfPisosCo = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taObsCo = new javax.swing.JTextArea();
        panelCampo = new org.edisoncor.gui.panel.Panel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfGalponesCam = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfCorralesCam = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfSilosCam = new javax.swing.JTextField();
        rbtnAlamNCam = new javax.swing.JRadioButton();
        rbtnAlamSCam = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfBretesCam = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taObsCam = new javax.swing.JTextArea();
        tfSupGCam = new javax.swing.JTextField();
        tfSupACam = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cbTipoCam = new javax.swing.JComboBox();
        panelGalpon = new org.edisoncor.gui.panel.Panel();
        jPanel9 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        tfEdificadoG = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        tfCapacidadG = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        tfOficinasG = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        tfBanosG = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        taObsG = new javax.swing.JTextArea();
        jLabel67 = new javax.swing.JLabel();
        panelGalpon1 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        btnVerContrato = new org.edisoncor.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Inmueble");
        setResizable(false);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        panelTipo.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Inmueble");

        chkCasa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCasa.setForeground(new java.awt.Color(255, 255, 255));
        chkCasa.setText("Casa");
        chkCasa.setOpaque(false);
        chkCasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkCasaMouseReleased(evt);
            }
        });

        chkDepto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkDepto.setForeground(new java.awt.Color(255, 255, 255));
        chkDepto.setText("Departamento");
        chkDepto.setOpaque(false);
        chkDepto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkDeptoMouseReleased(evt);
            }
        });

        chkLocal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkLocal.setForeground(new java.awt.Color(255, 255, 255));
        chkLocal.setText("Local");
        chkLocal.setOpaque(false);
        chkLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkLocalMouseReleased(evt);
            }
        });

        chkCochera.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCochera.setForeground(new java.awt.Color(255, 255, 255));
        chkCochera.setText("Cochera");
        chkCochera.setOpaque(false);
        chkCochera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkCocheraMouseReleased(evt);
            }
        });

        chkCampo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCampo.setForeground(new java.awt.Color(255, 255, 255));
        chkCampo.setText("Campo");
        chkCampo.setOpaque(false);
        chkCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkCampoMouseReleased(evt);
            }
        });

        chkTerreno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkTerreno.setForeground(new java.awt.Color(255, 255, 255));
        chkTerreno.setText("Terreno");
        chkTerreno.setOpaque(false);
        chkTerreno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkTerrenoMouseReleased(evt);
            }
        });

        chkGalpon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkGalpon.setForeground(new java.awt.Color(255, 255, 255));
        chkGalpon.setText("Galpón");
        chkGalpon.setOpaque(false);
        chkGalpon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkGalponMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelTipoLayout = new javax.swing.GroupLayout(panelTipo);
        panelTipo.setLayout(panelTipoLayout);
        panelTipoLayout.setHorizontalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49))
            .addGroup(panelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkLocal)
                    .addComponent(chkDepto)
                    .addComponent(chkCasa)
                    .addComponent(chkCochera))
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTipoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkGalpon)
                            .addComponent(chkCampo))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTerreno)
                        .addContainerGap())))
        );
        panelTipoLayout.setVerticalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTipoLayout.createSequentialGroup()
                        .addComponent(chkCasa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDepto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkCochera)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTipoLayout.createSequentialGroup()
                        .addComponent(chkCampo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkGalpon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkTerreno)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        btnContinuar.setBackground(new java.awt.Color(102, 0, 204));
        btnContinuar.setText("Guardar");
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnContinuarMousePressed(evt);
            }
        });

        jPanel2.setOpaque(false);

        groupContrato.add(rbtnAquiler);
        rbtnAquiler.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAquiler.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAquiler.setText("Alquiler");
        rbtnAquiler.setOpaque(false);
        rbtnAquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rbtnAquilerMouseReleased(evt);
            }
        });

        tfAlquiler.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("$");

        tfVenta.setEditable(false);
        tfVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("$");

        groupContrato.add(rbtnVenta);
        rbtnVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnVenta.setForeground(new java.awt.Color(255, 255, 255));
        rbtnVenta.setText("Venta");
        rbtnVenta.setOpaque(false);
        rbtnVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rbtnVentaMouseReleased(evt);
            }
        });

        groupContrato.add(rbtnAV);
        rbtnAV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAV.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAV.setText("Alquiler-Venta");
        rbtnAV.setOpaque(false);
        rbtnAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rbtnAVMouseReleased(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Tipo de Contrato");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnVenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnAquiler, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rbtnAV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtnAquiler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnVenta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(0, 0, 0)
                .addComponent(rbtnAV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Servicios");

        chkLuz.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkLuz.setForeground(new java.awt.Color(255, 255, 255));
        chkLuz.setSelected(true);
        chkLuz.setText("Luz");
        chkLuz.setOpaque(false);

        chkAgua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkAgua.setForeground(new java.awt.Color(255, 255, 255));
        chkAgua.setSelected(true);
        chkAgua.setText("Agua");
        chkAgua.setOpaque(false);

        chkGas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkGas.setForeground(new java.awt.Color(255, 255, 255));
        chkGas.setSelected(true);
        chkGas.setText("Gas Natural");
        chkGas.setOpaque(false);

        chkCloaca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCloaca.setForeground(new java.awt.Color(255, 255, 255));
        chkCloaca.setSelected(true);
        chkCloaca.setText("Cloaca");
        chkCloaca.setOpaque(false);

        chkTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkTelefono.setForeground(new java.awt.Color(255, 255, 255));
        chkTelefono.setSelected(true);
        chkTelefono.setText("Telefonía");
        chkTelefono.setOpaque(false);

        chkPavimento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkPavimento.setForeground(new java.awt.Color(255, 255, 255));
        chkPavimento.setSelected(true);
        chkPavimento.setText("Pavimento");
        chkPavimento.setOpaque(false);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Expensas");

        tfExpensas.setBackground(new java.awt.Color(231, 255, 239));
        tfExpensas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("$");

        tfEMOS.setBackground(new java.awt.Color(231, 255, 239));
        tfEMOS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("$");

        jLabel72.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("$");

        tfMunicipal.setBackground(new java.awt.Color(231, 255, 239));
        tfMunicipal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel71.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Municipal");

        jLabel69.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("EMOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkGas)
                            .addComponent(chkAgua)
                            .addComponent(chkLuz))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkCloaca)
                            .addComponent(chkTelefono)
                            .addComponent(chkPavimento))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel50))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel70)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEMOS, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(tfExpensas)
                            .addComponent(tfMunicipal))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(tfExpensas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(tfEMOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(tfMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkLuz)
                            .addComponent(chkCloaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkAgua)
                            .addComponent(chkTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkGas)
                            .addComponent(chkPavimento))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dirección");

        tfDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lbLocalidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        lbLocalidad.setText("Provincia");

        cbProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProvinciaItemStateChanged(evt);
            }
        });

        lbProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lbProvincia.setText("Localidad");

        cbLocalidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lbLocalidad1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLocalidad1.setForeground(new java.awt.Color(255, 255, 255));
        lbLocalidad1.setText("Sector");

        cbSector.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Datos Generales");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dimension");

        tfDimension.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("m2");

        lbLocalidad2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLocalidad2.setForeground(new java.awt.Color(255, 255, 255));
        lbLocalidad2.setText("Propietario");

        cbPropietario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbPropietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbPropietarioMousePressed(evt);
            }
        });

        buttonAction1.setText("+");
        buttonAction1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonAction1MousePressed(evt);
            }
        });

        buttonAction2.setText("+");
        buttonAction2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonAction2MousePressed(evt);
            }
        });

        panelEstado.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado del Inmueble");

        groupEstado.add(rbtnDisp);
        rbtnDisp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnDisp.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDisp.setSelected(true);
        rbtnDisp.setText("Disponible");
        rbtnDisp.setOpaque(false);

        groupEstado.add(rbtnNoDisp);
        rbtnNoDisp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnNoDisp.setForeground(new java.awt.Color(255, 255, 255));
        rbtnNoDisp.setText("No Disponible");
        rbtnNoDisp.setOpaque(false);

        javax.swing.GroupLayout panelEstadoLayout = new javax.swing.GroupLayout(panelEstado);
        panelEstado.setLayout(panelEstadoLayout);
        panelEstadoLayout.setHorizontalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEstadoLayout.createSequentialGroup()
                        .addComponent(rbtnDisp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnNoDisp))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEstadoLayout.setVerticalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnDisp)
                    .addComponent(rbtnNoDisp))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbProvincia)
                        .addComponent(lbLocalidad))
                    .addComponent(jLabel5)
                    .addComponent(lbLocalidad1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel10))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProvincia))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalidad1)
                    .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalidad2)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbInmueble.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbInmuebleStateChanged(evt);
            }
        });

        panelCasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Edificado");

        tfEdificadoC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfEdificadoC.setNextFocusableComponent(tfAmbientesC);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("m2");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Observaciones");

        taObsC.setColumns(20);
        taObsC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsC.setLineWrap(true);
        taObsC.setRows(5);
        jScrollPane1.setViewportView(taObsC);

        tfAmbientesC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Nro Ambientes");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nro Dormitorios");

        tfDormC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tfBanoC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nro Baños");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Cap. Garaje");

        tfGarajeC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tfPisosC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Nro de Pisos");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("¿Patio?");

        buttonGroupPatioC.add(rbtnPatioNC);
        rbtnPatioNC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnPatioNC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPatioNC.setText("No");
        rbtnPatioNC.setOpaque(false);

        buttonGroupPatioC.add(rbtnPatioSC);
        rbtnPatioSC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnPatioSC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPatioSC.setSelected(true);
        rbtnPatioSC.setText("Si");
        rbtnPatioSC.setOpaque(false);

        buttonGroupAsadorC.add(rbtnAsaSC);
        rbtnAsaSC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAsaSC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAsaSC.setSelected(true);
        rbtnAsaSC.setText("Si");
        rbtnAsaSC.setOpaque(false);

        buttonGroupAsadorC.add(rbtnAsaNC);
        rbtnAsaNC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAsaNC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAsaNC.setText("No");
        rbtnAsaNC.setOpaque(false);

        buttonGroupPiletaC.add(rbtnPileNC);
        rbtnPileNC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnPileNC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPileNC.setText("No");
        rbtnPileNC.setOpaque(false);

        buttonGroupPiletaC.add(rbtnPileSC);
        rbtnPileSC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnPileSC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPileSC.setSelected(true);
        rbtnPileSC.setText("Si");
        rbtnPileSC.setOpaque(false);

        buttonGroupQuinchoC.add(rbtnQuinSC);
        rbtnQuinSC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnQuinSC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnQuinSC.setSelected(true);
        rbtnQuinSC.setText("Si");
        rbtnQuinSC.setOpaque(false);

        buttonGroupQuinchoC.add(rbtnQuinNC);
        rbtnQuinNC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnQuinNC.setForeground(new java.awt.Color(255, 255, 255));
        rbtnQuinNC.setText("No");
        rbtnQuinNC.setOpaque(false);

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("¿Asador?");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("¿Pileta?");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("¿Quincho?");

        javax.swing.GroupLayout panelCasaLayout = new javax.swing.GroupLayout(panelCasa);
        panelCasa.setLayout(panelCasaLayout);
        panelCasaLayout.setHorizontalGroup(
            panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCasaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addGroup(panelCasaLayout.createSequentialGroup()
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel27)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33))
                        .addGap(42, 42, 42)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCasaLayout.createSequentialGroup()
                                .addComponent(rbtnQuinSC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnQuinNC))
                            .addGroup(panelCasaLayout.createSequentialGroup()
                                .addComponent(rbtnPileSC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnPileNC))
                            .addGroup(panelCasaLayout.createSequentialGroup()
                                .addComponent(rbtnAsaSC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnAsaNC))
                            .addGroup(panelCasaLayout.createSequentialGroup()
                                .addComponent(rbtnPatioSC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnPatioNC))
                            .addGroup(panelCasaLayout.createSequentialGroup()
                                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfPisosC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(tfGarajeC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfBanoC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDormC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAmbientesC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEdificadoC, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)))))
                .addGap(21, 21, 21)
                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        panelCasaLayout.setVerticalGroup(
            panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCasaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCasaLayout.createSequentialGroup()
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tfEdificadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(tfAmbientesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(tfDormC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(tfBanoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(tfGarajeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(tfPisosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnPatioSC)
                            .addComponent(rbtnPatioNC)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnAsaSC)
                            .addComponent(rbtnAsaNC)
                            .addComponent(jLabel36)))
                    .addGroup(panelCasaLayout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPileSC)
                    .addComponent(rbtnPileNC)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnQuinSC)
                    .addComponent(rbtnQuinNC)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Casa", panelCasa);

        panelDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel5.setOpaque(false);

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Edificado");

        tfEdificadoD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("m2");

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Nro Ambientes");

        tfAmbientesD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Nro Baños");

        tfBanoD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Nro Dormitorios");

        tfDormD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        buttonGroupBalconD.add(rbtnBalconSD);
        rbtnBalconSD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnBalconSD.setForeground(new java.awt.Color(255, 255, 255));
        rbtnBalconSD.setSelected(true);
        rbtnBalconSD.setText("Si");
        rbtnBalconSD.setOpaque(false);

        buttonGroupBalconD.add(rbtnBalconND);
        rbtnBalconND.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnBalconND.setForeground(new java.awt.Color(255, 255, 255));
        rbtnBalconND.setText("No");
        rbtnBalconND.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("¿Balcon?");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("¿Asador?");

        buttonGroupAsadorD.add(rbtnAsadorSD);
        rbtnAsadorSD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAsadorSD.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAsadorSD.setSelected(true);
        rbtnAsadorSD.setText("Si");
        rbtnAsadorSD.setOpaque(false);

        buttonGroupAsadorD.add(rbtnAsadorND);
        rbtnAsadorND.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAsadorND.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAsadorND.setText("No");
        rbtnAsadorND.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("¿Cochera?");

        buttonGroupCocheraD.add(rbtnCocheraSD);
        rbtnCocheraSD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnCocheraSD.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCocheraSD.setSelected(true);
        rbtnCocheraSD.setText("Si");
        rbtnCocheraSD.setOpaque(false);

        buttonGroupCocheraD.add(rbtnCocheraND);
        rbtnCocheraND.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnCocheraND.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCocheraND.setText("No");
        rbtnCocheraND.setOpaque(false);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Piso");

        taObsD.setColumns(20);
        taObsD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsD.setLineWrap(true);
        taObsD.setRows(5);
        jScrollPane2.setViewportView(taObsD);

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Observaciones");

        cbPisoD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Planta Baja", "1", "2", "3", "4", "5", "6", "7", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        cbPisoD.setNextFocusableComponent(tfDptoD);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Departamento");

        tfDptoD.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfDptoD.setNextFocusableComponent(tfExpensas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel44)
                            .addGap(102, 102, 102)
                            .addComponent(cbPisoD, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel52)
                            .addGap(32, 32, 32)
                            .addComponent(tfDptoD, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel42)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addGap(66, 66, 66)
                                        .addComponent(tfEdificadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfBanoD, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDormD, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAmbientesD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbtnCocheraSD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnCocheraND))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbtnAsadorSD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnAsadorND))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbtnBalconSD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnBalconND)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPisoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnBalconSD)
                            .addComponent(rbtnBalconND)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnAsadorSD)
                            .addComponent(rbtnAsadorND)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCocheraSD)
                            .addComponent(rbtnCocheraND)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(tfDptoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(tfEdificadoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(tfAmbientesD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(tfDormD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(tfBanoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panelDeptoLayout = new javax.swing.GroupLayout(panelDepto);
        panelDepto.setLayout(panelDeptoLayout);
        panelDeptoLayout.setHorizontalGroup(
            panelDeptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeptoLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 158, Short.MAX_VALUE))
        );
        panelDeptoLayout.setVerticalGroup(
            panelDeptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeptoLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Departamento", panelDepto);

        panelLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel6.setOpaque(false);

        lbLocalidad3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLocalidad3.setForeground(new java.awt.Color(255, 255, 255));
        lbLocalidad3.setText("Tipo Calefacción");

        cbCalefL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbCalefL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Calefactores", "Calefacción central", "No tiene" }));
        cbCalefL.setName(""); // NOI18N
        cbCalefL.setNextFocusableComponent(taObsL);

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Edificado");

        tfEdificadoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfEdificadoL.setNextFocusableComponent(cbCalefL);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("m2");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cap. Cochera");

        tfCapacidadCL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfCapacidadCL.setNextFocusableComponent(tfAmbientesL);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("¿Estacionamiento?");

        buttonGroupEstL.add(rbtnEstSL);
        rbtnEstSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnEstSL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEstSL.setSelected(true);
        rbtnEstSL.setText("Si");
        rbtnEstSL.setOpaque(false);

        buttonGroupEstL.add(rbtnEstNL);
        rbtnEstNL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnEstNL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEstNL.setText("No");
        rbtnEstNL.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nro Ambientes");

        tfAmbientesL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfAmbientesL.setNextFocusableComponent(tfBanosL);

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("¿Cocina?");

        buttonGroupCocinaL.add(rbtnCocinaSL);
        rbtnCocinaSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnCocinaSL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCocinaSL.setSelected(true);
        rbtnCocinaSL.setText("Si");
        rbtnCocinaSL.setOpaque(false);

        buttonGroupCocinaL.add(rbtnCocinaNL);
        rbtnCocinaNL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnCocinaNL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCocinaNL.setText("No");
        rbtnCocinaNL.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nro Baños");

        tfBanosL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfBanosL.setNextFocusableComponent(tfEdificadoL);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("¿Aire acondicionado?");

        buttonGroupAireL.add(rbtnAireSL);
        rbtnAireSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAireSL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAireSL.setSelected(true);
        rbtnAireSL.setText("Si");
        rbtnAireSL.setOpaque(false);

        buttonGroupAireL.add(rbtnAireNL);
        rbtnAireNL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAireNL.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAireNL.setText("No");
        rbtnAireNL.setOpaque(false);

        jLabel53.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Observaciones");

        taObsL.setColumns(20);
        taObsL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsL.setLineWrap(true);
        taObsL.setRows(5);
        jScrollPane3.setViewportView(taObsL);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel48))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(rbtnCocinaSL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtnCocinaNL))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(rbtnAireSL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtnAireNL))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnEstSL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnEstNL)))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbLocalidad3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCalefL, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCapacidadCL)
                                    .addComponent(tfAmbientesL)
                                    .addComponent(tfBanosL)
                                    .addComponent(tfEdificadoL))))
                        .addGap(9, 9, 9)))
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfCapacidadCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tfAmbientesL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfBanosL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(tfEdificadoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCalefL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLocalidad3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(rbtnEstSL)
                            .addComponent(rbtnEstNL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(rbtnCocinaSL)
                            .addComponent(rbtnCocinaNL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(rbtnAireSL)
                            .addComponent(rbtnAireNL))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLocalLayout = new javax.swing.GroupLayout(panelLocal);
        panelLocal.setLayout(panelLocalLayout);
        panelLocalLayout.setHorizontalGroup(
            panelLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLocalLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
        );
        panelLocalLayout.setVerticalGroup(
            panelLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLocalLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Local", panelLocal);

        panelCochera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel7.setOpaque(false);

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Capacidad");

        tfCapacidadCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfCapacidadCo.setNextFocusableComponent(tfCapacidadTCo);

        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Capacidad Techada");

        tfCapacidadTCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfCapacidadTCo.setNextFocusableComponent(tfBanosCo);

        jLabel56.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Nro Oficinas");

        tfOficinasCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfOficinasCo.setNextFocusableComponent(tfPisosCo);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nro Baños");

        tfBanosCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfBanosCo.setNextFocusableComponent(tfOficinasCo);

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Nro de pisos");

        tfPisosCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfPisosCo.setNextFocusableComponent(taObsCo);

        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Observaciones");

        taObsCo.setColumns(20);
        taObsCo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsCo.setLineWrap(true);
        taObsCo.setRows(5);
        jScrollPane4.setViewportView(taObsCo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel17)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCapacidadTCo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBanosCo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOficinasCo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCapacidadCo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPisosCo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(tfCapacidadCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(tfCapacidadTCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tfBanosCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(tfOficinasCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(tfPisosCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCocheraLayout = new javax.swing.GroupLayout(panelCochera);
        panelCochera.setLayout(panelCocheraLayout);
        panelCocheraLayout.setHorizontalGroup(
            panelCocheraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCocheraLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        panelCocheraLayout.setVerticalGroup(
            panelCocheraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCocheraLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Cochera", panelCochera);

        panelCampo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel8.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tipo");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nro Galpones");

        tfGalponesCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfGalponesCam.setNextFocusableComponent(tfSilosCam);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nro Corrales");

        tfCorralesCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfCorralesCam.setNextFocusableComponent(tfBretesCam);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Nro Silos");

        tfSilosCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfSilosCam.setNextFocusableComponent(tfCorralesCam);

        buttonGroupAlamCam.add(rbtnAlamNCam);
        rbtnAlamNCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAlamNCam.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAlamNCam.setText("No");
        rbtnAlamNCam.setOpaque(false);

        buttonGroupAlamCam.add(rbtnAlamSCam);
        rbtnAlamSCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbtnAlamSCam.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAlamSCam.setSelected(true);
        rbtnAlamSCam.setText("Si");
        rbtnAlamSCam.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("¿Alambrado?");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nro de Bretes");

        tfBretesCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfBretesCam.setNextFocusableComponent(taObsCam);

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Observaciones");

        taObsCam.setColumns(20);
        taObsCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsCam.setLineWrap(true);
        taObsCam.setRows(5);
        jScrollPane5.setViewportView(taObsCam);

        tfSupGCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfSupGCam.setNextFocusableComponent(tfGalponesCam);

        tfSupACam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfSupACam.setNextFocusableComponent(tfSupGCam);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Superficie Agrícola");

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Superficie Ganadera");

        cbTipoCam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoCam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Agrícola", "Ganadero", "Agrícola-Ganadero" }));
        cbTipoCam.setNextFocusableComponent(tfSupACam);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(55, 55, 55)
                        .addComponent(cbTipoCam, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel61)
                            .addComponent(jLabel60))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSupACam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSupGCam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBretesCam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rbtnAlamSCam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnAlamNCam))
                            .addComponent(tfGalponesCam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSilosCam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCorralesCam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel59)
                            .addComponent(cbTipoCam, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(tfSupACam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(tfSupGCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tfGalponesCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(tfSilosCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(tfCorralesCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tfBretesCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAlamSCam)
                    .addComponent(rbtnAlamNCam)
                    .addComponent(jLabel25))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCampoLayout = new javax.swing.GroupLayout(panelCampo);
        panelCampo.setLayout(panelCampoLayout);
        panelCampoLayout.setHorizontalGroup(
            panelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCampoLayout.setVerticalGroup(
            panelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCampoLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Campo", panelCampo);

        panelGalpon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jPanel9.setOpaque(false);

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Edificado");

        tfEdificadoG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfEdificadoG.setNextFocusableComponent(tfCapacidadG);

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Capacidad");

        tfCapacidadG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfCapacidadG.setNextFocusableComponent(tfBanosG);

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Nro Oficinas");

        tfOficinasG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfOficinasG.setNextFocusableComponent(taObsG);

        jLabel65.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Nro Baños");

        tfBanosG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfBanosG.setNextFocusableComponent(tfOficinasG);

        jLabel66.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Observaciones");

        taObsG.setColumns(20);
        taObsG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taObsG.setLineWrap(true);
        taObsG.setRows(5);
        jScrollPane6.setViewportView(taObsG);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("m2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel65)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCapacidadG, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBanosG, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOficinasG, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tfEdificadoG, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(tfEdificadoG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(tfCapacidadG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(tfBanosG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(tfOficinasG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGalponLayout = new javax.swing.GroupLayout(panelGalpon);
        panelGalpon.setLayout(panelGalponLayout);
        panelGalponLayout.setHorizontalGroup(
            panelGalponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGalponLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );
        panelGalponLayout.setVerticalGroup(
            panelGalponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGalponLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );

        tabbInmueble.addTab("Galpón", panelGalpon);

        panelGalpon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione un tipo de inmueble");

        javax.swing.GroupLayout panelGalpon1Layout = new javax.swing.GroupLayout(panelGalpon1);
        panelGalpon1.setLayout(panelGalpon1Layout);
        panelGalpon1Layout.setHorizontalGroup(
            panelGalpon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGalpon1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel2)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        panelGalpon1Layout.setVerticalGroup(
            panelGalpon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGalpon1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        tabbInmueble.addTab(" ", panelGalpon1);

        btnVerContrato.setBackground(new java.awt.Color(255, 255, 51));
        btnVerContrato.setText("Ver Contrato");
        btnVerContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerContratoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(btnVerContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabbInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(tabbInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProvinciaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange()==1){
            Objetos.Tripla elemCB = (Objetos.Tripla) this.cbProvincia.getSelectedItem();
            Datos.Procedimientos.llenarCBLocalidad(this.cbLocalidad,(Integer) elemCB.getPrimero());
        }
    }//GEN-LAST:event_cbProvinciaItemStateChanged

    private void rbtnAquilerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAquilerMouseReleased
        // TODO add your handling code here:
        if (this.rbtnAquiler.isSelected()){
            this.tfAlquiler.setText("");
            this.tfAlquiler.setEditable(true);
            this.tfVenta.setText("");
            this.tfVenta.setEditable(false);
        }
    }//GEN-LAST:event_rbtnAquilerMouseReleased

    private void rbtnVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnVentaMouseReleased
        // TODO add your handling code here:
        if (this.rbtnVenta.isSelected()){
            this.tfAlquiler.setText("");
            this.tfAlquiler.setEditable(false);
            this.tfVenta.setText("");
            this.tfVenta.setEditable(true);
        }
    }//GEN-LAST:event_rbtnVentaMouseReleased

    private void rbtnAVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAVMouseReleased
        // TODO add your handling code here:
        if (this.rbtnAV.isSelected()){
            this.tfAlquiler.setText("");
            this.tfAlquiler.setEditable(true);
            this.tfVenta.setText("");
            this.tfVenta.setEditable(true);
        }
    }//GEN-LAST:event_rbtnAVMouseReleased

    private void btnContinuarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMousePressed
        // TODO add your handling code here:
        if (controlesOk()){
            Objetos.Inmueble inm = construirInmueble();
            if (inm!=null){
                continuar(inm);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione al menos un tipo de inmueble");
            }
        }
    }//GEN-LAST:event_btnContinuarMousePressed

    private void buttonAction1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAction1MousePressed
        AbmSector sector = new ABM.AbmSector();
        sector.mostrar();
    }//GEN-LAST:event_buttonAction1MousePressed

    private void buttonAction2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAction2MousePressed
        this.buttonAction2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            if (Instancias.getInstance().abmPersona == null){
                Instancias.getInstance().abmPersona = new ABM.AbmPersona();
            }
            Instancias.getInstance().abmPersona.mostrar("");
        this.buttonAction2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_buttonAction2MousePressed

    private void cbPropietarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPropietarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPropietarioMousePressed

    private void tabbInmuebleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbInmuebleStateChanged
        // TODO add your handling code here:
        // ojo con esto puede no andar
        //        this.condicionFiltro = "";
        //        this.tablasInmueble = " inmobiliaria.inmueble 

    }//GEN-LAST:event_tabbInmuebleStateChanged

    private void chkCasaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCasaMouseReleased
        // TODO add your handling code here:
//        panelCasa.setVisible(chkCasa.isSelected()); 
        controlInmuebleSeleccionado();
        if (chkCasa.isSelected()){
            tabbInmueble.setEnabledAt(0, true);
            tabbInmueble.setTitleAt(0, "Casa");   
            tabbInmueble.setSelectedIndex(0);
        } else {
            tabbInmueble.setEnabledAt(0, false);
            tabbInmueble.setTitleAt(0, " ");            
        }           
    }//GEN-LAST:event_chkCasaMouseReleased

    private void chkDeptoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkDeptoMouseReleased
        // TODO add your handling code here:
        controlInmuebleSeleccionado();
        if (chkDepto.isSelected()){
            tabbInmueble.setEnabledAt(1, true);
            tabbInmueble.setTitleAt(1, "Departamento");  
            tabbInmueble.setSelectedIndex(1);
        } else {
            tabbInmueble.setEnabledAt(1, false);
            tabbInmueble.setTitleAt(1, " ");
        }       
    }//GEN-LAST:event_chkDeptoMouseReleased

    private void chkLocalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkLocalMouseReleased
        // TODO add your handling code here:
        controlInmuebleSeleccionado();
        if (chkLocal.isSelected()){
            tabbInmueble.setEnabledAt(2, true);
            tabbInmueble.setTitleAt(2, "Local"); 
            tabbInmueble.setSelectedIndex(2);            
        } else {
            tabbInmueble.setEnabledAt(2, false);
            tabbInmueble.setTitleAt(2, " ");
        }         
    }//GEN-LAST:event_chkLocalMouseReleased

    private void chkCocheraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCocheraMouseReleased
        // TODO add your handling code here:
        controlInmuebleSeleccionado();
        if (chkCochera.isSelected()){
            tabbInmueble.setEnabledAt(3, true);
            tabbInmueble.setTitleAt(3, "Cochera");
            tabbInmueble.setSelectedIndex(3);            
        } else {
            tabbInmueble.setEnabledAt(3, false);
            tabbInmueble.setTitleAt(3, " ");
        }         
    }//GEN-LAST:event_chkCocheraMouseReleased

    private void chkCampoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCampoMouseReleased
        // TODO add your handling code here:
        controlInmuebleSeleccionado();
        if (chkCampo.isSelected()){
            tabbInmueble.setEnabledAt(4, true);
            tabbInmueble.setTitleAt(4, "Campo"); 
            tabbInmueble.setSelectedIndex(4);            
        } else {
            tabbInmueble.setEnabledAt(4, false);
            tabbInmueble.setTitleAt(4, " ");
        }         
    }//GEN-LAST:event_chkCampoMouseReleased

    private void chkTerrenoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTerrenoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTerrenoMouseReleased

    private void chkGalponMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkGalponMouseReleased
        // TODO add your handling code here:
        controlInmuebleSeleccionado();
        if (chkGalpon.isSelected()){
            tabbInmueble.setEnabledAt(5, true);
            tabbInmueble.setTitleAt(5, "Galpón"); 
            tabbInmueble.setSelectedIndex(5);            
        } else {
            tabbInmueble.setEnabledAt(5, false);
            tabbInmueble.setTitleAt(5, " ");
        }                
    }//GEN-LAST:event_chkGalponMouseReleased

    private void btnVerContratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerContratoMousePressed
        int idContrato = tieneContrato();
        if (idContrato>0){
            if (Datos.Instancias.getInstance().abmContratoA == null)
                Datos.Instancias.getInstance().abmContratoA = new ABM.ABMContratoA();
            Datos.Instancias.getInstance().abmContratoA.editar(idContrato);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "El inmueble no posee un contrato vigente asociado");
        }
    }//GEN-LAST:event_btnVerContratoMousePressed
    
    private boolean controlesOk(){
        if (cbSector.getItemCount()==0){
            JOptionPane.showMessageDialog(this, "No se puede insertar, Ingrese sectores");
            return false;
        }
        
        if (cbPropietario.getItemCount()==0){
            JOptionPane.showMessageDialog(this, "No se puede insertar, Ingrese propietarios");
            return false;
        }        
        
        if (this.rbtnAquiler.isSelected()){
            if (!Datos.Procedimientos.isNumber(this.tfAlquiler.getText()) ){
                JOptionPane.showMessageDialog(this, "Ingrese un valor de alquiler valido");
                this.tfAlquiler.grabFocus();
                return false;
            }else if (Datos.Procedimientos.isNumber(this.tfAlquiler.getText())){
                float alq = Float.parseFloat(this.tfAlquiler.getText());
                if (alq <=0){
                    JOptionPane.showMessageDialog(this, "Ingrese un valor de alquiler valido");
                    this.tfAlquiler.grabFocus();
                    return false;
                }
            }
        }
        if (this.rbtnVenta.isSelected()){
            if (!Datos.Procedimientos.isNumber(this.tfVenta.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese un valor de venta");
                this.tfVenta.grabFocus();
                return false;
            }
        }
        if (this.rbtnAV.isSelected()){
            if (!Datos.Procedimientos.isNumber(this.tfVenta.getText()) || !Datos.Procedimientos.isNumber(this.tfAlquiler.getText())){
                JOptionPane.showMessageDialog(this, "Ingrese los valores de venta y alquiler");
                this.tfAlquiler.grabFocus();
                return false;
            }
        }  
        if (this.tfDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una direccion para el inmueble");
            this.tfDireccion.grabFocus();
            return false;
        }
        if (!Datos.Procedimientos.isNumber(this.tfDimension.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de dimension de la propiedad");
            this.tfDimension.grabFocus();
            return false;
        }     
        
        if (!Datos.Procedimientos.isNumber(this.tfExpensas.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para las Expensas");
            this.tfExpensas.grabFocus();
            return false;
        }else{           
            if (Float.parseFloat(this.tfExpensas.getText()) < 0){
                JOptionPane.showMessageDialog(this, "El valor de las expensas debe ser positivo");
                this.tfExpensas.grabFocus();
                return false;
            }
        }        
        if (!Datos.Procedimientos.isNumber(this.tfEMOS.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para EMOS");
            this.tfEMOS.grabFocus();
            return false;
        }else{           
            if (Float.parseFloat(this.tfEMOS.getText()) < 0){
                JOptionPane.showMessageDialog(this, "El valor de EMOS debe ser positivo");
                this.tfEMOS.grabFocus();
                return false;
            }
        }        
        if (!Datos.Procedimientos.isNumber(this.tfMunicipal.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el imp municipal");
            this.tfMunicipal.grabFocus();
            return false;
        }else{           
            if (Float.parseFloat(this.tfMunicipal.getText()) < 0){
                JOptionPane.showMessageDialog(this, "El valor del imp municipal debe ser positivo");
                this.tfMunicipal.grabFocus();
                return false;
            }
        }         
        
        taObsC.setText(taObsC.getText().replace("'", "´").replace("--", "_"));
        taObsD.setText(taObsD.getText().replace("'", "´").replace("--", "_"));
        taObsCo.setText(taObsCo.getText().replace("'", "´").replace("--", "_"));
        taObsCam.setText(taObsCam.getText().replace("'", "´").replace("--", "_"));
        taObsG.setText(taObsG.getText().replace("'", "´").replace("--", "_"));
        taObsL.setText(taObsL.getText().replace("'", "´").replace("--", "_"));
        
        return true;
    }
    
    private Objetos.Inmueble construirInmueble(){
        LinkedList<String> tipos = new LinkedList();
        if (this.chkCasa.isSelected())
            tipos.add("Casa");
        if (this.chkDepto.isSelected())
            tipos.add("Departamento");
        if (this.chkLocal.isSelected())
            tipos.add("Local");
        if (this.chkCochera.isSelected())
            tipos.add("Cochera");
        if (this.chkCampo.isSelected())
            tipos.add("Campo");  
        if (chkTerreno.isSelected())
            tipos.add("Terreno");
        if (chkGalpon.isSelected())
            tipos.add("Galpon");
        if (tipos.size()==0)
            return null;        
        String tipoContrato = "";
        float mAlquiler = 0;
        float mVenta = 0;
        if (this.rbtnVenta.isSelected()){
            tipoContrato = "Venta";
            mVenta = Float.parseFloat(this.tfVenta.getText());
        } else if (this.rbtnAV.isSelected()) {
            tipoContrato = "Alquiler-Venta";
            mVenta = Float.parseFloat(this.tfVenta.getText());
            mAlquiler = Float.parseFloat(this.tfAlquiler.getText());
        } else if (this.rbtnAquiler.isSelected()){
            tipoContrato = "Alquiler";
            mAlquiler = Float.parseFloat(this.tfAlquiler.getText());
        }        
        Objetos.Inmueble inm = new Objetos.Inmueble(tipos,
                tipoContrato,
                mVenta,
                mAlquiler,
                this.chkLuz.isSelected(),
                this.chkAgua.isSelected(),
                this.chkGas.isSelected(),
                this.chkCloaca.isSelected(),
                this.chkTelefono.isSelected(),
                this.chkPavimento.isSelected(),
                this.tfDireccion.getText(),
                (Integer) ((Objetos.Tripla) this.cbLocalidad.getSelectedItem()).getPrimero(),
                (Integer) ((Objetos.Tripla) this.cbSector.getSelectedItem()).getPrimero(),
                Float.parseFloat(this.tfDimension.getText()),
                (Integer) ((Objetos.Tripla) this.cbPropietario.getSelectedItem()).getPrimero(),
                Float.parseFloat(tfEMOS.getText()),    
                Float.parseFloat(tfMunicipal.getText()),
                Float.parseFloat(tfExpensas.getText())
                );
        //float montoEMOS, float montoMunicipal, float montoExpensas
        if (editando){
            inm.setId(Integer.parseInt(idInmueble));
            inm.setDisponible(this.rbtnDisp.isSelected());
            inm.setEstadoActual(estadoInm);
        }
        return inm;
    }
    
    private void habilitarTipoCon(boolean bool){
        this.rbtnAquiler.setEnabled(bool);
        this.rbtnVenta.setEnabled(bool);
        this.rbtnAV.setEnabled(bool);
    }
    
    private void continuar(Objetos.Inmueble inm){
        // no se si estaba inicializado true o false, o toque los ifs para ver si funcionaba y no -.-
        boolean disponible = true;
        if (inm.getId()==-1){
            ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_inmueble, tipo_inmueble "
                + "FROM inmobiliaria.inmueble WHERE UPPER(direccion_inmueble)=UPPER('"+this.tfDireccion.getText()+"')");
            try {
                if (rs.next()){
                    if (chkDepto.isSelected()){
                        disponible = true;
                    }else{
                        disponible = false;
                    }
                }     
            } catch (Exception ex){
                Datos.Procedimientos.escribirEnLog("Error en linea 801 metodo continuar en la clase ABMInmueble.java: "+ex);
            }
        }
        //Si esta editando, eliminar los tipos que se sacaron y agregar los nuevos
        if (editando){
            inm.acomodarTipos();
            disponible = true;
        } else if (!disponible) {
            JOptionPane.showMessageDialog(this, "No se puede insertar, la dirección ingresada ya esta cargada con otro inmueble");
        }
        String observaciones="";
        if (disponible){
            for (int i=0; i<inm.getTipos().size(); i++){ 
                //NUEVO
                switch (inm.getTipos().get(i)) {
                    case "Casa": 
                        if (!controlCasa()){
                            tabbInmueble.setSelectedIndex(0);    
                            disponible = false;
                        }                            
                        observaciones+="Casa: "+this.taObsC.getText()+"**"; 
                        break;
                    case "Departamento":  
                        if (!controlDepto()){                            
                            tabbInmueble.setSelectedIndex(1);
                            disponible = false;
                        }                        
                        observaciones+="Departamento: "+this.taObsD.getText()+"**"; 
                        break;
                    case "Local": 
                        if (!controlLocal()){                            
                            tabbInmueble.setSelectedIndex(2);
                            disponible = false;
                        }     
                        observaciones+="Local: "+this.taObsL.getText()+"**";                      
                        break;
                    case "Campo":  
                        if (!controlCampo()){
                            tabbInmueble.setSelectedIndex(4); 
                            disponible = false;
                        }
                        observaciones+="Campo: "+this.taObsCam.getText()+"**"; 
                        break;
                    case "Cochera": 
                        if (!controlCochera()){
                            tabbInmueble.setSelectedIndex(3); 
                            disponible = false;
                        }                                               
                        observaciones+="Cochera: "+this.taObsCo.getText()+"**"; 
                        break; 
                    case "Galpon": 
                        if (!controlGalpon()){
                            tabbInmueble.setSelectedIndex(5);
                            disponible = false;
                        }
                        observaciones+="Galpon: "+this.taObsG.getText()+"**"; 
                        break;   
                    case "Terreno": 
                        observaciones+="Terreno-"; 
                        break;                           
                    default: break;    
                }
            } 
        }
        if (disponible){
            inm.setObservacion(observaciones);
            if (inm.getId()==-1){
                inm.insertarInmueble();
            } else {
                inm.actualizarDB();
            }           
            for (int i=0; i<inm.getTipos().size(); i++){
                //NUEVO
                if (inm.getTipos().get(i).equals("Casa")){
                    guardarCasa(inm);
                }
                if (inm.getTipos().get(i).equals("Departamento")){
                    guardarDepto(inm);
                }
                if (inm.getTipos().get(i).equals("Local")){
                    guardarLocal(inm);
                }                
                if (inm.getTipos().get(i).equals("Cochera")){
                    guardarCochera(inm);
                }
                if (inm.getTipos().get(i).equals("Campo")){
                    guardarCampo(inm);
                }
                if (inm.getTipos().get(i).equals("Galpon")){
                    guardarGalpon(inm);
                }
            }
            Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("Inmueble");
            limpiar();
            this.dispose();
        }
    }      
    
    private void abrirInmueble(String id){
        this.idInmueble = id;
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT valoralquiler_inmueble, valorventa_inmueble, direccion_inmueble, \n" +
        "       observacion_inmueble, dimension_inmueble, id_sector_inmueble, nombre_sector, \n" +
        "       estado_inmueble, gas_inmueble, agua_inmueble, cloaca_inmueble, telefono_inmueble, pavimento_inmueble,\n" +
        "       luz_inmueble, id_propietario_inmueble, razonsocial_persona, id_ciudad_inmueble, nombre_ciudad, id_provincia,\n" +
        "       nombre_provincia, tipo_inmueble, COALESCE(montoEMOS_inmueble, 0) as montoEMOS_inmueble, \n" +
        "       COALESCE(montoExpensas_inmueble, 0) as montoExpensas_inmueble, COALESCE(montoMunicipal_inmueble, 0) as montoMunicipal_inmueble\n" +
        "  FROM inmobiliaria.inmueble INNER JOIN inmobiliaria.ciudad ON id_ciudad=id_ciudad_inmueble\n" +
        "  INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad INNER JOIN inmobiliaria.persona ON id_persona=id_propietario_inmueble\n" +
        "  INNER JOIN inmobiliaria.sector ON id_sector=id_sector_inmueble WHERE id_inmueble="+id+";");
        try {
            if (rs.next()){                
                String[] tipos = rs.getString("tipo_inmueble").split(" ");
                for (int i=0; i<tipos.length; i++){
                    switch (tipos[i]) {
                        case "Casa": this.chkCasa.setSelected(true);  break;
                        case "Departamento": this.chkDepto.setSelected(true); break;
                        case "Local": this.chkLocal.setSelected(true); break;
                        case "Campo": this.chkCampo.setSelected(true); break;
                        case "Cochera": this.chkCochera.setSelected(true); break;
                        case "Terreno": chkTerreno.setSelected(true); break;    
                        case "Galpon": chkGalpon.setSelected(true); break;    
                        default: break;    
                    }
                }
                this.panelEstado.setVisible(true);
                //ALQUILER
                float alq = rs.getFloat("valoralquiler_inmueble");
                float venta = rs.getFloat("valorventa_inmueble");
                if (alq>0){
                    if (venta>0){
                        this.rbtnAV.setSelected(true);
                        this.tfAlquiler.setText(String.valueOf(alq));
                        this.tfVenta.setText(String.valueOf(venta));
                        tfVenta.setEditable(true);
                        tfAlquiler.setEditable(true);
                    } else {
                        this.rbtnAquiler.setSelected(true);
                        this.tfAlquiler.setText(String.valueOf(alq)); 
                        tfVenta.setEditable(false);
                        tfAlquiler.setEditable(true);
                    }
                } else if (venta>0){
                    this.rbtnVenta.setSelected(true);
                    this.tfVenta.setText(String.valueOf(venta)); 
                    tfVenta.setEditable(true);
                    tfAlquiler.setEditable(false);
                }
                //SERVICIOS
                this.chkAgua.setSelected(rs.getBoolean("agua_inmueble"));
                this.chkLuz.setSelected(rs.getBoolean("luz_inmueble"));
                this.chkGas.setSelected(rs.getBoolean("gas_inmueble"));
                this.chkCloaca.setSelected(rs.getBoolean("cloaca_inmueble"));
                chkTelefono.setSelected(rs.getBoolean("telefono_inmueble"));
                chkPavimento.setSelected(rs.getBoolean("pavimento_inmueble"));
                                
                tfEMOS.setText(rs.getString("montoEMOS_inmueble"));
                tfExpensas.setText(rs.getString("montoExpensas_inmueble"));
                tfMunicipal.setText(rs.getString("montoMunicipal_inmueble"));
                
                //DATOS
                this.estadoInm = rs.getString("estado_inmueble");
                if (estadoInm.equals("No disponible"))
                    this.rbtnNoDisp.setSelected(true);
                this.tfDireccion.setText(rs.getString("direccion_inmueble"));
                this.tfDimension.setText(rs.getString("dimension_inmueble"));
                Tripla prov = new Tripla(rs.getInt("id_provincia"),null,rs.getString("nombre_provincia"));
                this.cbProvincia.setSelectedItem(prov);                
                Tripla loc = new Tripla(rs.getInt("id_ciudad_inmueble"),null,rs.getString("nombre_ciudad"));
                this.cbLocalidad.setSelectedItem(loc); 
                Tripla sec = new Tripla(rs.getInt("id_sector_inmueble"),null,rs.getString("nombre_sector"));
                this.cbSector.setSelectedItem(sec);
                Tripla prop = new Tripla(rs.getInt("id_propietario_inmueble"),null,rs.getString("razonsocial_persona"));
                this.cbPropietario.setSelectedItem(prop);

            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error buscando el inmueble");
            }
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 440 metodo abrirInmueble en la clase ABMInmueble.java: "+e);
        }
    }
    
    public void mostrar(){
        setVisible(true);
        limpiar();
        editando = false;
    }
    
    private int tieneContrato(){
        try {
            ResultSet rs = SqlMetodo.runQuery("SELECT id_contratoalquiler "
                    + " FROM inmobiliaria.contratoalquiler "
                    + " WHERE id_inmueble_contratoalquiler="+idInmueble+" AND estado_contratoalquiler='Vigente'");
            if (rs.next()){
                return rs.getInt("id_contratoalquiler");
            } else {
                return -1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    //CASA-----
    private boolean extraerCasa(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_casa, edificado_casa, banos_casa, ambientes_casa, dormitorios_casa, \n" +
        "       patio_casa, garaje_casa, asador_casa, nropisos_casa, pileta_casa, \n" +
        "       quincho_casa, id_inmueble_casa, observacion_inmueble, observacion_casa\n" +
        " FROM inmobiliaria.casa INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_casa WHERE id_inmueble_casa="+inm.getId()+";");
        try {
            if (rs.next()){
                //NUEVO
                tabbInmueble.setEnabledAt(0, true);
                tabbInmueble.setTitleAt(0, "Casa");   
                tabbInmueble.setSelectedIndex(0);

                this.taObsC.setText(rs.getString("observacion_casa"));
                this.tfEdificadoC.setText(String.valueOf(rs.getInt("edificado_casa")));
                this.tfAmbientesC.setText(rs.getString("ambientes_casa"));
                this.tfDormC.setText(rs.getString("dormitorios_casa"));
                this.tfBanoC.setText(rs.getString("banos_casa"));
                this.tfGarajeC.setText(rs.getString("garaje_casa"));
                this.tfPisosC.setText(rs.getString("nropisos_casa"));
                if (rs.getBoolean("asador_casa"))
                    this.rbtnAsaSC.setSelected(true);
                else
                    this.rbtnAsaNC.setSelected(true);
                if (rs.getBoolean("patio_casa"))
                    this.rbtnPatioSC.setSelected(true);
                else
                    this.rbtnPatioNC.setSelected(true);
                if (rs.getBoolean("pileta_casa"))
                    this.rbtnPileSC.setSelected(true);
                else
                    this.rbtnPileNC.setSelected(true);
                if (rs.getBoolean("quincho_casa"))
                    this.rbtnQuinSC.setSelected(true);
                else
                    this.rbtnQuinNC.setSelected(true);

                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 454 metodo extraerCasa() en la clase ABMCasa.java: "+e);
            return false;
        }
    }    
    private boolean controlCasa(){
        if (!Datos.Procedimientos.isNumber(this.tfEdificadoC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de m2 edificados");
            this.tfEdificadoC.grabFocus();
            return false;
        }else{
            if (this.tfEdificadoC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser un número entero");
                this.tfEdificadoC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfEdificadoC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser mayores a 0");
                    this.tfEdificadoC.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfAmbientesC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los ambientes");
            this.tfAmbientesC.grabFocus();
            return false;
        }else{
            if (this.tfAmbientesC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de ambientes debe ser un numero entero");
                this.tfAmbientesC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfAmbientesC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de ambientes debe ser mayor a cero");
                    this.tfAmbientesC.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfDormC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los dormitorios");
            this.tfDormC.grabFocus();
            return false;
        }else{
            if (this.tfDormC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de dormitorios debe ser un numero entero");
                this.tfDormC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfDormC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de dormitorios debe ser mayor a cero");
                    this.tfDormC.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfBanoC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los baños");
            this.tfBanoC.grabFocus();
            return false;
        }else{
            if (this.tfBanoC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de baños debe ser un numero entero");
                this.tfBanoC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBanoC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a cero");
                    this.tfBanoC.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfGarajeC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para la capacidad del garaje...\nEn caso de que la casa no tenga garage, ingrese '0'");
            this.tfGarajeC.grabFocus();
            return false;
        }else{
            if (this.tfGarajeC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La capacidad del garaje debe ser un numero entero");
                this.tfGarajeC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfGarajeC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "capacidad del garaje debe ser mayor o igual a cero");
                    this.tfGarajeC.grabFocus();
                    return false;
                }
            }
        }        
        if (!Datos.Procedimientos.isNumber(this.tfPisosC.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para el número de pisos");
            this.tfPisosC.grabFocus();
            return false;
        }else{
            if (this.tfPisosC.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de pisos de la casa debe ser un numero entero");
                this.tfPisosC.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfPisosC.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de pisos de la casa debe ser mayor a cero");
                    this.tfPisosC.grabFocus();
                    return false;
                }
            }
        } 
        return true;
    }    
    private void limpiarCasa(){
        this.tfEdificadoC.setText("0");
        this.tfAmbientesC.setText("0");
        this.tfBanoC.setText("0");
        this.tfDormC.setText("0");
        this.tfGarajeC.setText("0");
        this.tfPisosC.setText("0");
        this.taObsC.setText("");
    }
    private void guardarCasa(Objetos.Inmueble inm){
        if (inm.getId()>-1){            
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Casa' FROM inmobiliaria.casa WHERE id_inmueble_casa = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.casa\n" +
                    "   SET edificado_casa="+this.tfEdificadoC.getText()+", banos_casa="+this.tfBanoC.getText()+", ambientes_casa="+this.tfAmbientesC.getText()+", \n" +
                    "       dormitorios_casa="+this.tfDormC.getText()+", patio_casa="+this.rbtnPatioSC.isSelected()+", garaje_casa="+this.tfGarajeC.getText()+", asador_casa="+this.rbtnAsaSC.isSelected()+", \n" +
                    "       nropisos_casa="+this.tfPisosC.getText()+", pileta_casa="+this.rbtnPileSC.isSelected()+", quincho_casa="+this.rbtnQuinSC.isSelected()+", observacion_casa='"+this.taObsC.getText()+"'\n" +
                    " WHERE id_inmueble_casa="+inm.getId()+";");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.casa(\n" +
                    "            edificado_casa, banos_casa, ambientes_casa, dormitorios_casa, \n" +
                    "            patio_casa, garaje_casa, asador_casa, nropisos_casa, pileta_casa, \n" +
                    "            quincho_casa, id_inmueble_casa, observacion_casa)\n" +
                    "    VALUES ("+this.tfEdificadoC.getText()+", "+this.tfBanoC.getText()+", "+this.tfAmbientesC.getText()+","+this.tfDormC.getText()+", \n" +
                    "            "+this.rbtnPatioSC.isSelected()+", "+this.tfGarajeC.getText()+", "+this.rbtnAsaSC.isSelected()+", "+this.tfPisosC.getText()+", "+this.rbtnPileSC.isSelected()+", \n" +
                    "            "+this.rbtnQuinSC.isSelected()+", "+inm.getId()+", '"+this.taObsC.getText()+"');");
                } 
            } catch(Exception ex){
                Datos.Procedimientos.escribirEnLog("Error en linea 505 metodo continuar() en la clase ABMCasa.java: "+ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "1 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }
    }   
    //----------
    //DEPTO-----
    private boolean controlDepto(){
        if(tfDptoD.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo departamento no puede ser vacío.");
            tfDptoD.grabFocus();
            return false;
        }       
        if (!Datos.Procedimientos.isNumber(this.tfEdificadoD.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de m2 edificados");
            this.tfEdificadoD.grabFocus();
            return false;
        }else{
            if (this.tfEdificadoD.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser un número entero");
                this.tfEdificadoD.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfEdificadoD.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser mayores a 0");
                    this.tfEdificadoD.grabFocus();
                    return false;
                }
            }
        }        
        if (!Datos.Procedimientos.isNumber(this.tfAmbientesD.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los ambientes");
            this.tfAmbientesD.grabFocus();
            return false;
        }else{
            if (this.tfAmbientesD.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de ambientes debe ser un numero entero");
                this.tfAmbientesD.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfAmbientesD.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de ambientes debe ser mayor a cero");
                    this.tfAmbientesD.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfDormD.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los dormitorios");
            this.tfDormD.grabFocus();
            return false;
        }else{
            if (this.tfDormD.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de dormitorios debe ser un numero entero");
                this.tfDormD.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfDormD.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de dormitorios debe ser mayor a cero");
                    this.tfDormD.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfBanoD.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los baños");
            this.tfBanoD.grabFocus();
            return false;
        }else{
            if (this.tfBanoD.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de baños debe ser un numero entero");
                this.tfBanoD.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBanoD.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a cero");
                    this.tfBanoD.grabFocus();
                    return false;
                }
            }
        }      
        return true;
    }    
    private void guardarDepto(Objetos.Inmueble inm){
        if (inm.getId()>-1){        
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Departamento' FROM inmobiliaria.departamento WHERE id_inmueble_departamento = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.departamento\n" +
                    "SET  edificado_departamento="+tfEdificadoD.getText()+", dpto_departamento='"+tfDptoD.getText()+"',\n" +
                    "banos_departamento="+tfBanoD.getText()+", ambiente_departamento="+tfAmbientesD.getText()+", balcon_departamento="+rbtnBalconSD.isSelected()+", \n" +
                    "dormitorio_departamento="+tfDormD.getText()+", asador_departamento="+rbtnAsadorSD.isSelected()+", piso_departamento="+cbPisoD.getSelectedIndex()+", \n" +
                    "cochera_departamento="+rbtnCocheraSD.isSelected()+", observacion_departamento='"+this.taObsD.getText()+"'\n" +
                    " WHERE id_inmueble_departamento = "+inm.getId()+" ;");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.departamento(\n" +
                        "            edificado_departamento, banos_departamento, ambiente_departamento, balcon_departamento, \n" +
                        "            dormitorio_departamento, asador_departamento, piso_departamento, \n" +
                        "            cochera_departamento, id_inmueble_departamento, dpto_departamento, observacion_departamento)\n" +
                        "    VALUES ("+this.tfEdificadoD.getText()+", "+this.tfBanoD.getText()+", \n" +
                        "            "+this.tfAmbientesD.getText()+", "+this.rbtnBalconSD.isSelected()+", \n" +
                        "            "+this.tfDormD.getText()+", "+this.rbtnAsadorSD.isSelected()+", "+this.cbPisoD.getSelectedIndex()+", \n" +
                        "            "+this.rbtnCocheraSD.isSelected()+", "+inm.getId()+", '"+tfDptoD.getText()+"', '"+this.taObsD.getText()+"');");
                }
            }catch(Exception ex){
                Datos.Procedimientos.escribirEnLog("Error en linea 2661 metodo guardardepto en la clase ABMInmuebles.java: "+ex);
            }            
        } else {
            JOptionPane.showMessageDialog(this, "2 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }      
    }
    private boolean extraerDepto(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_departamento, edificado_departamento,\n" +
                                        "banos_departamento, ambiente_departamento, balcon_departamento, \n" +
                                        "dormitorio_departamento, asador_departamento, piso_departamento, \n" +
                                        "cochera_departamento, observacion_inmueble, dpto_departamento, observacion_departamento\n" +
                                        "FROM inmobiliaria.departamento INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_departamento WHERE id_inmueble_departamento="+inm.getId()+";");
        try {
            if (rs.next()){
                tabbInmueble.setEnabledAt(1, true);
                tabbInmueble.setTitleAt(1, "Departamento");   
                tabbInmueble.setSelectedIndex(1);                                
                taObsD.setText(rs.getString("observacion_departamento"));
                tfEdificadoD.setText(String.valueOf(rs.getInt("edificado_departamento")));
                tfAmbientesD.setText(rs.getString("ambiente_departamento"));
                tfDormD.setText(rs.getString("dormitorio_departamento"));
                tfBanoD.setText(rs.getString("banos_departamento"));
                cbPisoD.setSelectedIndex(rs.getInt("piso_departamento"));
                tfDptoD.setText(rs.getString("dpto_departamento"));
                if (rs.getBoolean("asador_departamento"))
                    this.rbtnAsadorSD.setSelected(true);
                else
                    this.rbtnAsadorND.setSelected(true);
                if (rs.getBoolean("balcon_departamento"))
                    this.rbtnBalconSD.setSelected(true);
                else
                    this.rbtnBalconND.setSelected(true);
                if (rs.getBoolean("cochera_departamento"))
                    this.rbtnCocheraSD.setSelected(true);
                else
                    this.rbtnCocheraND.setSelected(true);

                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 511 metodo extraerDepto en la clase ABMDepto.java: "+e);
            return false;
        }
    }    
    private void limpiarDepto(){
        this.tfAmbientesD.setText("0");
        this.tfBanoD.setText("0");
        this.tfDormD.setText("0");
        this.tfEdificadoD.setText("0");
        this.tfDptoD.setText("");
        this.cbPisoD.setSelectedIndex(0);
        this.taObsD.setText("");
    }
    //----------
    //LOCAL-----
    private boolean controlLocal(){
        if (!Datos.Procedimientos.isNumber(this.tfEdificadoL.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de m2 edificados");
            this.tfEdificadoL.grabFocus();
            return false;
        }else{
            if (this.tfEdificadoL.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser un número entero");
                this.tfEdificadoL.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfEdificadoL.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "Los metros cuadrados edificados deben ser mayores a 0");
                    this.tfEdificadoL.grabFocus();
                    return false;
                }
            }
        } 
        
        if (!Datos.Procedimientos.isNumber(this.tfAmbientesL.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los ambientes");
            this.tfAmbientesL.grabFocus();
            return false;
        }else{
            if (this.tfAmbientesL.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de ambientes debe ser un numero entero");
                this.tfAmbientesL.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfAmbientesL.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de ambientes debe ser mayor a cero");
                    this.tfAmbientesL.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfBanosL.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los baños");
            this.tfBanosL.grabFocus();
            return false;
        }else{
            if (this.tfBanosL.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de baños debe ser un numero entero");
                this.tfBanosL.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBanosL.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a cero");
                    this.tfBanosL.grabFocus();
                    return false;
                }
            }
        }  
        
        if (!Datos.Procedimientos.isNumber(this.tfCapacidadCL.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para la capacidad de la cochera");
            this.tfCapacidadCL.grabFocus();
            return false;
        }else{
            if (this.tfCapacidadCL.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La capacidad de la cochera debe ser un numero entero");
                this.tfCapacidadCL.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfCapacidadCL.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "La capacidad de la cochera debe ser mayor a cero");
                    this.tfCapacidadCL.grabFocus();
                    return false;
                }
            }
        }

        return true;
    }    
    private void guardarLocal(Objetos.Inmueble inm){
        if (inm.getId()>-1){
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Local' FROM inmobiliaria.local WHERE id_inmueble_local = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.local\n" +
                        "SET  cochera_local="+tfCapacidadCL.getText()+", estacionamiento_local="+rbtnEstSL.isSelected()+", \n" +
                        "bano_local="+tfBanosL.getText()+", cocina_local="+rbtnCocinaSL.isSelected()+", calefaccion_local='"+cbCalefL.getSelectedItem()+"', edificado_local="+tfEdificadoL.getText()+", \n" +
                        "ambiente_local="+tfAmbientesL.getText()+", aire_local="+rbtnAireSL.isSelected()+", observacion_local='"+this.taObsL.getText()+"'\n" +
                        " WHERE id_inmueble_local= "+inm.getId()+" ;");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.local(\n" +
                    "            cochera_local, estacionamiento_local, \n" +
                    "            bano_local, cocina_local, calefaccion_local, edificado_local, \n" +
                    "            ambiente_local, aire_local, id_inmueble_local, observacion_local)\n" +
                    "    VALUES ("+this.tfCapacidadCL.getText()+", "+this.rbtnEstSL.isSelected()+", \n" +
                    "            "+this.tfBanosL.getText()+", "+this.rbtnCocinaSL.isSelected()+", '"+this.cbCalefL.getSelectedItem()+"', "+this.tfEdificadoL.getText()+", \n" +
                    "            "+this.tfAmbientesL.getText()+", "+this.rbtnAireSL.isSelected()+", "+inm.getId()+", '"+this.taObsL.getText()+"');");
                }
            } catch (Exception ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 471 metodo continuar en la clase ABMLocal.java: "+ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "3 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }
    }        
    private boolean extraerLocal(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_local, cochera_local, estacionamiento_local, \n" +
                                                            "bano_local, cocina_local, calefaccion_local, edificado_local, \n" +
                                                            "ambiente_local, aire_local, observacion_inmueble, observacion_local\n" +
                                                            "FROM inmobiliaria.local INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_local WHERE id_inmueble_local="+inm.getId()+";");
        try {
            if (rs.next()){
                tabbInmueble.setEnabledAt(2, true);
                tabbInmueble.setTitleAt(2, "Local");   
                tabbInmueble.setSelectedIndex(2);                 
                taObsL.setText(rs.getString("observacion_local"));                
                tfEdificadoL.setText(String.valueOf(rs.getInt("edificado_local")));
                tfAmbientesL.setText(rs.getString("ambiente_local"));
                tfBanosL.setText(rs.getString("bano_local"));
                tfCapacidadCL.setText(rs.getString("cochera_local"));
                cbCalefL.setSelectedItem(rs.getString("calefaccion_local"));
                if (rs.getBoolean("estacionamiento_local"))
                    rbtnEstSL.setSelected(true);
                else
                    rbtnEstNL.setSelected(true);
                if (rs.getBoolean("cocina_local"))
                    rbtnCocinaSL.setSelected(true);
                else
                    rbtnCocinaNL.setSelected(true);
                if (rs.getBoolean("aire_local"))
                    rbtnAireSL.setSelected(true);
                else
                    rbtnAireNL.setSelected(true);
                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 514 metodo extraerLocal en la clase ABMLocal.java: "+e);
            return false;
        }
    }    
    private void limpiarLocal(){
        this.tfAmbientesL.setText("0");
        this.tfBanosL.setText("0");
        this.tfCapacidadCL.setText("0");
        this.tfEdificadoL.setText("0");
        this.taObsL.setText("");
    }    
    //----------
    //COCHERA---
    private boolean controlCochera(){
        if (!Datos.Procedimientos.isNumber(this.tfCapacidadCo.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para la capacidad de la cochera");
            this.tfCapacidadCo.grabFocus();
            return false;
        }else{
            if (this.tfCapacidadCo.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La capacidad de la cochera debe ser un número entero");
                this.tfCapacidadCo.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfCapacidadCo.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "La capacidad de la cochera debe ser un número mayor a 0");
                    this.tfCapacidadCo.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfCapacidadTCo.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para la capacidad techada de la cochera");
            this.tfCapacidadTCo.grabFocus();
            return false;
        }else{
            if (this.tfCapacidadTCo.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La capacidad techada de la cochera debe ser un número entero");
                this.tfCapacidadTCo.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfCapacidadTCo.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "La capacidad techada de la cochera debe ser un número mayor a 0");
                    this.tfCapacidadTCo.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfOficinasCo.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para las oficinas");
            this.tfOficinasCo.grabFocus();
            return false;
        }else{
            if (this.tfOficinasCo.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de oficinas debe ser un numero entero");
                this.tfOficinasCo.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfOficinasCo.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de oficinas debe ser mayor a cero");
                    this.tfOficinasCo.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfBanosCo.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los baños");
            this.tfBanosCo.grabFocus();
            return false;
        }else{
            if (this.tfBanosCo.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de baños debe ser un numero entero");
                this.tfBanosCo.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBanosCo.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a cero");
                    this.tfBanosCo.grabFocus();
                    return false;
                }
            }
        }     
        if (!Datos.Procedimientos.isNumber(this.tfPisosCo.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para el número de pisos");
            this.tfPisosCo.grabFocus();
            return false;
        }else{
            if (this.tfPisosCo.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de pisos de la casa debe ser un numero entero");
                this.tfPisosCo.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfPisosCo.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de pisos de la casa debe ser mayor a cero");
                    this.tfPisosCo.grabFocus();
                    return false;
                }
            }
        }
 
        return true;
    }    
    private void guardarCochera(Objetos.Inmueble inm){
        if (inm.getId()>-1){        
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Cochera' FROM inmobiliaria.cochera WHERE id_inmueble_cochera = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.cochera\n" +
                                                    "SET  capacidad_cochera="+tfCapacidadCo.getText()+", capacidadtechada_cochera="+tfCapacidadTCo.getText()+", \n" +
                                                    "bano_cochera="+tfBanosCo.getText()+", oficina_cochera="+tfOficinasCo.getText()+", nropisos_cochera="+this.tfPisosCo.getText()+",\n" +
                                                    "observacion_cochera='"+this.taObsCo.getText()+"'\n" +
                                                    " WHERE id_inmueble_cochera = "+inm.getId()+" ;");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.cochera(\n" +
                    "            capacidad_cochera, capacidadtechada_cochera, bano_cochera, \n" +
                    "            oficina_cochera, nropisos_cochera, id_inmueble_cochera, observacion_cochera)\n" +
                    "    VALUES ("+this.tfCapacidadCo.getText()+", "+this.tfCapacidadTCo.getText()+", "+this.tfBanosCo.getText()+", \n" +
                    "            "+this.tfOficinasCo.getText()+", "+this.tfPisosCo.getText()+", "+inm.getId()+", '"+this.taObsCo.getText()+"');");
                } 
            } catch (Exception ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 328 metodo continuar() en la clase ABMCochera.java: "+ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "4 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }
    }  
    private boolean extraerCochera(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_cochera, capacidad_cochera, capacidadtechada_cochera, bano_cochera, \n" +
                                                            "oficina_cochera, nropisos_cochera, observacion_inmueble, observacion_cochera\n" +
                                                            " FROM inmobiliaria.cochera INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_cochera WHERE id_inmueble_cochera="+inm.getId()+";");
        try {
            if (rs.next()){
                tabbInmueble.setEnabledAt(3, true);
                tabbInmueble.setTitleAt(3, "Cochera");   
                tabbInmueble.setSelectedIndex(3);  
                
                taObsCo.setText(rs.getString("observacion_cochera")); 
                tfCapacidadCo.setText(String.valueOf(rs.getInt("capacidad_cochera")));
                tfCapacidadTCo.setText(String.valueOf(rs.getInt("capacidadtechada_cochera")));
                tfBanosCo.setText(String.valueOf(rs.getInt("bano_cochera")));
                tfOficinasCo.setText(String.valueOf(rs.getInt("oficina_cochera")));
                tfPisosCo.setText(String.valueOf(rs.getInt("nropisos_cochera")));
                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 355 metodo extraerCosecha() en la clase ABMCosecha.java: "+e);
            return false;
        }
    }    
    private void limpiarCochera(){
        this.tfBanosCo.setText("0");
        this.tfCapacidadCo.setText("0");
        this.tfCapacidadTCo.setText("0");
        this.tfOficinasCo.setText("0");
        this.tfPisosCo.setText("0");
        this.taObsCo.setText("");
    }    
    //----------
    //CAMPO-----
    private boolean controlCampo(){
        if (!Datos.Procedimientos.isNumber(this.tfSupACam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de hectareas para la superficie agrícola");
            this.tfSupACam.grabFocus();
            return false;
        }else{
            if (Integer.parseInt(this.tfSupACam.getText()) < 0){
                JOptionPane.showMessageDialog(this, "Las Ha. de superficie agrícola deben ser mayores o iguales a 0");
                this.tfSupACam.grabFocus();
                return false;
            }
        }        
        if (!Datos.Procedimientos.isNumber(this.tfSupGCam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido de hectareas para la superficie ganadera");
            this.tfSupGCam.grabFocus();
            return false;
        }else{
            if (Integer.parseInt(this.tfSupGCam.getText()) < 0){
                JOptionPane.showMessageDialog(this, "Las Ha. de superficie ganadera deben ser mayores o iguales a 0");
                this.tfSupGCam.grabFocus();
                return false;
            }
        }
        
        float sup = Float.valueOf(this.tfSupACam.getText()) + Float.valueOf(this.tfSupGCam.getText());
        if (sup>Float.parseFloat(this.tfDimension.getText())){
            JOptionPane.showMessageDialog(this, "La suma de las superficies no puede ser mayor a la superficie total del campo");
            this.tfSupACam.grabFocus();
            return false;
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfGalponesCam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida de galpones");
            this.tfGalponesCam.grabFocus();
            return false;
        }else{
            if (this.tfGalponesCam.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La cantidad de galpones debe ser un numero entero");
                this.tfGalponesCam.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfGalponesCam.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de galpones debe ser mayor a cero");
                    this.tfGalponesCam.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfSilosCam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida de silos");
            this.tfSilosCam.grabFocus();
            return false;
        }else{
            if (this.tfSilosCam.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de silos debe ser un numero entero");
                this.tfSilosCam.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfSilosCam.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de silos debe ser mayor a cero");
                    this.tfSilosCam.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfCorralesCam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida de corrales");
            this.tfCorralesCam.grabFocus();
            return false;
        }else{
            if (this.tfCorralesCam.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de corrales debe ser un numero entero");
                this.tfCorralesCam.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfCorralesCam.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de corrales debe ser mayor a cero");
                    this.tfCorralesCam.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfBretesCam.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida de bretes");
            this.tfBretesCam.grabFocus();
            return false;
        }else{
            if (this.tfBretesCam.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de bretes debe ser un numero entero");
                this.tfBretesCam.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBretesCam.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de bretes debe ser mayor a cero");
                    this.tfBretesCam.grabFocus();
                    return false;
                }
            }
        }  
        return true;
    }    
    private void guardarCampo(Objetos.Inmueble inm){
        if (inm.getId()>-1){  
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Campo' FROM inmobiliaria.campo WHERE id_inmueble_campo = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){        
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.campo\n" +
                    "SET tipo_campo='"+cbTipoCam.getSelectedItem()+"', galpon_campo="+tfGalponesCam.getText()+", silo_campo="+tfSilosCam.getText()+", corral_campo="+tfCorralesCam.getText()+", \n" +
                    "alambrado_campo="+rbtnAlamSCam.isSelected()+", brete_campo="+tfBretesCam.getText()+", superficieA_campo="+tfSupACam.getText()+", superficieG_campo="+tfSupGCam.getText()+", \n" +
                    "observacion_campo='"+this.taObsCam.getText()+"'\n" +
                    " WHERE id_inmueble_campo = "+inm.getId()+";");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.campo(\n" +
                            "            tipo_campo, galpon_campo, silo_campo, corral_campo, \n" +
                            "            alambrado_campo, brete_campo, id_inmueble_campo, superficieA_campo, superficieG_campo, observacion_campo)\n" +
                            "    VALUES ('"+this.cbTipoCam.getSelectedItem()+"', "+this.tfGalponesCam.getText()+", "+this.tfSilosCam.getText()+", "+this.tfCorralesCam.getText()+", \n" +
                            "            "+this.rbtnAlamSCam.isSelected()+", "+this.tfBretesCam.getText()+", "+inm.getId()+", "+tfSupACam.getText()+", "+tfSupGCam.getText()+", '"+this.taObsCam.getText()+"');");
                }
            } catch(Exception ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 408 metodo continuar() en la clase ABMCampo.java: "+ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "5 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }
    }  
    private boolean extraerCampo(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_campo, tipo_campo, galpon_campo, silo_campo, corral_campo, \n" +
                                                            "alambrado_campo, brete_campo, superficieA_campo, superficieG_campo, observacion_inmueble, observacion_campo\n" +
                                                            "FROM inmobiliaria.campo INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_campo WHERE id_inmueble_campo="+inm.getId()+";");
        try {
            if (rs.next()){
                tabbInmueble.setEnabledAt(4, true);
                tabbInmueble.setTitleAt(4, "Campo");   
                tabbInmueble.setSelectedIndex(4);  
                taObsCam.setText(rs.getString("observacion_campo"));                            
                cbTipoCam.setSelectedItem(rs.getString("tipo_campo"));
                tfGalponesCam.setText(String.valueOf(rs.getInt("galpon_campo")));
                tfSilosCam.setText(String.valueOf(rs.getInt("silo_campo")));
                tfCorralesCam.setText(String.valueOf(rs.getInt("corral_campo")));
                tfBretesCam.setText(String.valueOf(rs.getInt("brete_campo")));
                tfSupACam.setText(String.valueOf(rs.getInt("superficieA_campo")));
                tfSupGCam.setText(String.valueOf(rs.getInt("superficieG_campo")));
                if (rs.getBoolean("alambrado_campo"))
                    this.rbtnAlamSCam.setSelected(true);
                else
                    this.rbtnAlamNCam.setSelected(true);
                

                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 442 metodo extraerCampo() en la clase ABMCampo.java: "+e);
            return false;
        }
    }    
    private void limpiarCampo(){
        this.cbTipoCam.setSelectedIndex(0);
        this.tfSupACam.setText("0");
        this.tfSupGCam.setText("0");
        this.tfGalponesCam.setText("0");
        this.tfSilosCam.setText("0");
        this.tfCorralesCam.setText("0");
        this.tfBretesCam.setText("0");
        this.taObsCam.setText("");
    }
    //----------
    //GALPON----
    private boolean controlGalpon(){
        if (!Datos.Procedimientos.isNumber(this.tfEdificadoG.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para edificado");
            this.tfEdificadoG.grabFocus();
            return false;
        }else{
            if (this.tfEdificadoG.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "Edificado debe ser un número entero");
                this.tfEdificadoG.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfEdificadoG.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "Edificado debe ser un número mayor a 0");
                    this.tfEdificadoG.grabFocus();
                    return false;
                }
            }
        }
        
        if (!Datos.Procedimientos.isNumber(this.tfCapacidadG.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese un valor válido para la capacidad");
            this.tfCapacidadG.grabFocus();
            return false;
        }else{
            if (this.tfCapacidadG.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "La capacidad debe ser un número entero");
                this.tfCapacidadG.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfCapacidadG.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "La capacidad debe ser un número mayor a 0");
                    this.tfCapacidadG.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfOficinasG.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para las oficinas");
            this.tfOficinasG.grabFocus();
            return false;
        }else{
            if (this.tfOficinasG.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de oficinas debe ser un numero entero");
                this.tfOficinasG.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfOficinasG.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de oficinas debe ser mayor a cero");
                    this.tfOficinasG.grabFocus();
                    return false;
                }
            }
        }
        if (!Datos.Procedimientos.isNumber(this.tfBanosG.getText())){
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida para los baños");
            this.tfBanosG.grabFocus();
            return false;
        }else{
            if (this.tfBanosG.getText().contains(".")){
                JOptionPane.showMessageDialog(this, "El número de baños debe ser un numero entero");
                this.tfBanosG.grabFocus();
                return false;
            }else{
                if (Integer.parseInt(this.tfBanosG.getText()) < 0){
                    JOptionPane.showMessageDialog(this, "El número de baños debe ser mayor a cero");
                    this.tfBanosG.grabFocus();
                    return false;
                }
            }
        }   
        return true;
    }    
    private void guardarGalpon(Objetos.Inmueble inm){ 
        if (inm.getId()>-1){           
            try {
                ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT 'Galpon' FROM inmobiliaria.galpon WHERE id_inmueble_galpon = "+inm.getId());
                boolean actualizar = editando && rs.next();
                if (actualizar){         
                    ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.galpon\n" +
                        "SET  edificado_galpon="+tfEdificadoG.getText()+", capacidad_galpon="+tfCapacidadG.getText()+", \n" +
                        "bano_galpon="+tfBanosG.getText()+", oficina_galpon="+tfOficinasG.getText()+", observacion_galpon='"+this.taObsG.getText()+"'\n" +
                        " WHERE id_inmueble_galpon = "+inm.getId()+" ;");
                } else {
                    ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.galpon(\n" +
                        "            edificado_galpon, capacidad_galpon, bano_galpon, \n" +
                        "            oficina_galpon,  id_inmueble_galpon, observacion_galpon)\n" +
                        "    VALUES ("+this.tfEdificadoG.getText()+", "+this.tfCapacidadG.getText()+", "+this.tfBanosG.getText()+", \n" +
                        "            "+this.tfOficinasG.getText()+", "+inm.getId()+", '"+this.taObsG.getText()+"');");
                }    
            } catch (Exception ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 303 metodo continuar en la clase ABMGalpon.java: "+ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "6 No se puede insertar, intente nuevamente. Si el problema persiste consulte con su programador");
        }
    }  
    private boolean extraerGalpon(Objetos.Inmueble inm){
        ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_galpon, capacidad_galpon, edificado_galpon, bano_galpon, \n" +
                                                            "oficina_galpon, observacion_inmueble, observacion_galpon\n" +
                                                            "FROM inmobiliaria.galpon "
                + "INNER JOIN inmobiliaria.inmueble on id_inmueble = id_inmueble_galpon WHERE id_inmueble_galpon="+inm.getId()+";");
        try {
            if (rs.next()){
                tabbInmueble.setEnabledAt(5, true);
                tabbInmueble.setTitleAt(5, "Galpón");   
                tabbInmueble.setSelectedIndex(5);     
                
                tfEdificadoG.setText(String.valueOf(rs.getInt("edificado_galpon")));
                tfCapacidadG.setText(String.valueOf(rs.getInt("capacidad_galpon")));
                tfBanosG.setText(String.valueOf(rs.getInt("bano_galpon")));
                tfOficinasG.setText(String.valueOf(rs.getInt("oficina_galpon")));
                taObsG.setText(rs.getString("observacion_galpon"));
                
                return true;
            }else 
                return false;
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 330 metodo extraergalpon en la clase ABMGalpon.java: "+e);
            return false;
        }
    }    
    private void limpiarGalpon(){
        this.tfBanosG.setText("0");
        this.tfEdificadoG.setText("0");
        this.tfCapacidadG.setText("0");
        this.tfOficinasG.setText("0");
        this.taObsG.setText("");
    }    
    //----------
    
    //BLOQUE PARA EDICION DE INMUEBLE    
    public void editar(String idInmueble){
        limpiar();
        habilitarTipoCon(false);        
        editando = true;
        Datos.Procedimientos.llenarCBProvincia(this.cbProvincia);
        this.cbProvincia.setSelectedIndex(5);
        this.cbLocalidad.setSelectedIndex(1313);
        Datos.Procedimientos.llenarCBPersona(this.cbPropietario, "Cliente");
        Datos.Procedimientos.llenarCBSector(this.cbSector);
        this.panelEstado.setVisible(true);        
        abrirInmueble(idInmueble);
        Objetos.Inmueble inm = construirInmueble();
        //NUEVO
        extraerCasa(inm);
        extraerDepto(inm);
        extraerLocal(inm);
        extraerCochera(inm);
        extraerCampo(inm);
        extraerGalpon(inm);
        this.setVisible(true);
    }

    public void limpiar(){
        this.rbtnDisp.setSelected(true);
        this.panelEstado.setVisible(false);
        chkAgua.setSelected(true);
        chkCampo.setSelected(false);
        chkCasa.setSelected(false);
        chkCloaca.setSelected(true);
        chkCochera.setSelected(false);
        chkDepto.setSelected(false);
        chkGalpon.setSelected(false);
        tabbInmueble.setSelectedIndex(6);
        tabbInmueble.setEnabledAt(0, false);
        tabbInmueble.setTitleAt(0, " ");       
        tabbInmueble.setEnabledAt(1, false);
        tabbInmueble.setTitleAt(1, " ");       
        tabbInmueble.setEnabledAt(2, false);
        tabbInmueble.setTitleAt(2, " ");       
        tabbInmueble.setEnabledAt(3, false);
        tabbInmueble.setTitleAt(3, " ");       
        tabbInmueble.setEnabledAt(4, false);
        tabbInmueble.setTitleAt(4, " ");       
        tabbInmueble.setEnabledAt(5, false);
        tabbInmueble.setTitleAt(5, " ");       
        chkGas.setSelected(true);
        chkLocal.setSelected(false);
        chkLuz.setSelected(true);
        chkPavimento.setSelected(true);
        chkTelefono.setSelected(true);
        chkTerreno.setSelected(false);        
        rbtnAquiler.setSelected(true);
        rbtnVenta.setSelected(false);
        rbtnAV.setSelected(false);
        tfAlquiler.setText("");
        tfVenta.setText("");
        tfAlquiler.setEditable(true);
        tfVenta.setEditable(false);        
        tfDireccion.setText("");
        tfDimension.setText("0");
        habilitarTipoCon(true);
        Datos.Procedimientos.llenarCBProvincia(this.cbProvincia);
        this.cbProvincia.setSelectedIndex(5);
        this.cbLocalidad.setSelectedIndex(1313);
        Datos.Procedimientos.llenarCBPersona(this.cbPropietario, "Cliente");
        Datos.Procedimientos.llenarCBSector(this.cbSector);        
        this.tfExpensas.setText("0");
        this.tfEMOS.setText("0");
        this.tfMunicipal.setText("0");
        //NUEVO
        limpiarCasa();  
        limpiarDepto();
        limpiarLocal();
        limpiarCochera();
        limpiarCampo();
        limpiarGalpon();
    }
    
    private void controlInmuebleSeleccionado(){
        if (!chkCasa.isSelected() && !chkDepto.isSelected() && !chkLocal.isSelected() && !chkCochera.isSelected() &&
            !chkCampo.isSelected() && !chkGalpon.isSelected()){
            tabbInmueble.setSelectedIndex(6);            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction btnContinuar;
    private org.edisoncor.gui.button.ButtonColoredAction btnVerContrato;
    private org.edisoncor.gui.button.ButtonAction buttonAction1;
    private org.edisoncor.gui.button.ButtonAction buttonAction2;
    private javax.swing.ButtonGroup buttonGroupAireL;
    private javax.swing.ButtonGroup buttonGroupAlamCam;
    private javax.swing.ButtonGroup buttonGroupAsadorC;
    private javax.swing.ButtonGroup buttonGroupAsadorD;
    private javax.swing.ButtonGroup buttonGroupBalconD;
    private javax.swing.ButtonGroup buttonGroupCocheraD;
    private javax.swing.ButtonGroup buttonGroupCocinaL;
    private javax.swing.ButtonGroup buttonGroupEstL;
    private javax.swing.ButtonGroup buttonGroupPatioC;
    private javax.swing.ButtonGroup buttonGroupPiletaC;
    private javax.swing.ButtonGroup buttonGroupQuinchoC;
    private javax.swing.JComboBox cbCalefL;
    private javax.swing.JComboBox cbLocalidad;
    private javax.swing.JComboBox cbPisoD;
    public javax.swing.JComboBox cbPropietario;
    private javax.swing.JComboBox cbProvincia;
    public javax.swing.JComboBox cbSector;
    private javax.swing.JComboBox cbTipoCam;
    private javax.swing.JCheckBox chkAgua;
    private javax.swing.JCheckBox chkCampo;
    private javax.swing.JCheckBox chkCasa;
    private javax.swing.JCheckBox chkCloaca;
    private javax.swing.JCheckBox chkCochera;
    private javax.swing.JCheckBox chkDepto;
    private javax.swing.JCheckBox chkGalpon;
    private javax.swing.JCheckBox chkGas;
    private javax.swing.JCheckBox chkLocal;
    private javax.swing.JCheckBox chkLuz;
    private javax.swing.JCheckBox chkPavimento;
    private javax.swing.JCheckBox chkTelefono;
    private javax.swing.JCheckBox chkTerreno;
    private javax.swing.ButtonGroup groupContrato;
    private javax.swing.ButtonGroup groupEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbLocalidad;
    private javax.swing.JLabel lbLocalidad1;
    private javax.swing.JLabel lbLocalidad2;
    private javax.swing.JLabel lbLocalidad3;
    private javax.swing.JLabel lbProvincia;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panelCampo;
    private org.edisoncor.gui.panel.Panel panelCasa;
    private org.edisoncor.gui.panel.Panel panelCochera;
    private org.edisoncor.gui.panel.Panel panelDepto;
    private javax.swing.JPanel panelEstado;
    private org.edisoncor.gui.panel.Panel panelGalpon;
    private org.edisoncor.gui.panel.Panel panelGalpon1;
    private org.edisoncor.gui.panel.Panel panelLocal;
    private javax.swing.JPanel panelTipo;
    private javax.swing.JRadioButton rbtnAV;
    private javax.swing.JRadioButton rbtnAireNL;
    private javax.swing.JRadioButton rbtnAireSL;
    private javax.swing.JRadioButton rbtnAlamNCam;
    private javax.swing.JRadioButton rbtnAlamSCam;
    private javax.swing.JRadioButton rbtnAquiler;
    private javax.swing.JRadioButton rbtnAsaNC;
    private javax.swing.JRadioButton rbtnAsaSC;
    private javax.swing.JRadioButton rbtnAsadorND;
    private javax.swing.JRadioButton rbtnAsadorSD;
    private javax.swing.JRadioButton rbtnBalconND;
    private javax.swing.JRadioButton rbtnBalconSD;
    private javax.swing.JRadioButton rbtnCocheraND;
    private javax.swing.JRadioButton rbtnCocheraSD;
    private javax.swing.JRadioButton rbtnCocinaNL;
    private javax.swing.JRadioButton rbtnCocinaSL;
    private javax.swing.JRadioButton rbtnDisp;
    private javax.swing.JRadioButton rbtnEstNL;
    private javax.swing.JRadioButton rbtnEstSL;
    private javax.swing.JRadioButton rbtnNoDisp;
    private javax.swing.JRadioButton rbtnPatioNC;
    private javax.swing.JRadioButton rbtnPatioSC;
    private javax.swing.JRadioButton rbtnPileNC;
    private javax.swing.JRadioButton rbtnPileSC;
    private javax.swing.JRadioButton rbtnQuinNC;
    private javax.swing.JRadioButton rbtnQuinSC;
    private javax.swing.JRadioButton rbtnVenta;
    private javax.swing.JTextArea taObsC;
    private javax.swing.JTextArea taObsCam;
    private javax.swing.JTextArea taObsCo;
    private javax.swing.JTextArea taObsD;
    private javax.swing.JTextArea taObsG;
    private javax.swing.JTextArea taObsL;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbInmueble;
    private javax.swing.JTextField tfAlquiler;
    private javax.swing.JTextField tfAmbientesC;
    private javax.swing.JTextField tfAmbientesD;
    private javax.swing.JTextField tfAmbientesL;
    private javax.swing.JTextField tfBanoC;
    private javax.swing.JTextField tfBanoD;
    private javax.swing.JTextField tfBanosCo;
    private javax.swing.JTextField tfBanosG;
    private javax.swing.JTextField tfBanosL;
    private javax.swing.JTextField tfBretesCam;
    private javax.swing.JTextField tfCapacidadCL;
    private javax.swing.JTextField tfCapacidadCo;
    private javax.swing.JTextField tfCapacidadG;
    private javax.swing.JTextField tfCapacidadTCo;
    private javax.swing.JTextField tfCorralesCam;
    private javax.swing.JTextField tfDimension;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfDormC;
    private javax.swing.JTextField tfDormD;
    private javax.swing.JTextField tfDptoD;
    private javax.swing.JTextField tfEMOS;
    private javax.swing.JTextField tfEdificadoC;
    private javax.swing.JTextField tfEdificadoD;
    private javax.swing.JTextField tfEdificadoG;
    private javax.swing.JTextField tfEdificadoL;
    private javax.swing.JTextField tfExpensas;
    private javax.swing.JTextField tfGalponesCam;
    private javax.swing.JTextField tfGarajeC;
    private javax.swing.JTextField tfMunicipal;
    private javax.swing.JTextField tfOficinasCo;
    private javax.swing.JTextField tfOficinasG;
    private javax.swing.JTextField tfPisosC;
    private javax.swing.JTextField tfPisosCo;
    private javax.swing.JTextField tfSilosCam;
    private javax.swing.JTextField tfSupACam;
    private javax.swing.JTextField tfSupGCam;
    private javax.swing.JTextField tfVenta;
    // End of variables declaration//GEN-END:variables
}
