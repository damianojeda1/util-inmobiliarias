package ABM;

import Datos.Instancias;
import static Datos.Procedimientos.obtenerUltimo;
import Objetos.Tripla;
import ProcedimientosSQL.SqlMetodo;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AbmPersona extends javax.swing.JFrame {
    int personaSeleccionada;

    public AbmPersona() {
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

    public void mostrar(String nombre){
        Datos.Procedimientos.llenarCBProvincia(this.cbProvincia);
        this.cbProvincia.setSelectedIndex(5);
        this.cbLocalidad.setSelectedIndex(1313);
        this.setTitle("Carga de Cliente");
        ponerTodoEnBlanco(true);
        this.setVisible(true);    
        if (!nombre.isEmpty()){
            this.tfNombre.setText(nombre);
            seleccionar(nombre);
        }        
    }
    
    private void ponerTodoEnBlanco(boolean nombre){
        if (nombre)
            this.tfNombre.setText("");
        this.tfDNI.setText("");
        this.tfTel.setText("");
        this.tfDomicilio.setText("");
        this.tfMail.setText("");    
        this.cbProvincia.setSelectedIndex(5);
        this.cbLocalidad.setSelectedIndex(1313);
        this.personaSeleccionada = -1;
    }
    
    private void seleccionar(String nombre){
        try {
            ResultSet rs = ProcedimientosSQL.SqlMetodo.runQuery("SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                            "       telefono_persona, mail_persona, direccion_persona, estado_persona, \n" +
                            "       tipo_persona, id_ciudad, nombre_ciudad, id_provincia, nombre_provincia\n" +
                            "  FROM inmobiliaria.persona INNER JOIN inmobiliaria.ciudad ON id_ciudad=id_ciudad_persona" +
                            "  INNER JOIN inmobiliaria.provincia ON id_provincia=id_provincia_ciudad WHERE razonsocial_persona='"+nombre+"' AND tipo_persona='Cliente' AND estado_persona=TRUE");
            if (rs.next()){                 
                personaSeleccionada = rs.getInt("id_persona");
                this.tfNombre.setText(rs.getString("razonsocial_persona"));
                this.tfDNI.setText(rs.getString("nrodoc_persona"));
                this.tfMail.setText(rs.getString("mail_persona"));
                this.tfTel.setText(rs.getString("telefono_persona"));
                this.tfDomicilio.setText(rs.getString("direccion_persona"));
                Tripla prov = new Tripla(rs.getInt("id_provincia"),null,rs.getString("nombre_provincia"));
                this.cbProvincia.setSelectedItem(prov);                
                Tripla loc = new Tripla(rs.getInt("id_ciudad"),null,rs.getString("nombre_ciudad"));
                this.cbLocalidad.setSelectedItem(loc);    
            } else {
                personaSeleccionada = -1;
                this.ponerTodoEnBlanco(false);
            }
        } catch (Exception e) {
            Datos.Procedimientos.escribirEnLog("Error en linea 81 metodo seleccionar en la clase AbmPersona.java: "+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfDNI = new javax.swing.JTextField();
        tfTel = new javax.swing.JTextField();
        tfDomicilio = new javax.swing.JTextField();
        tfMail = new javax.swing.JTextField();
        lbProvincia = new javax.swing.JLabel();
        lbLocalidad = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox();
        cbLocalidad = new javax.swing.JComboBox();
        lbNroId = new javax.swing.JLabel();
        btnBorrar = new org.edisoncor.gui.button.ButtonColoredAction();
        btnGuardar = new org.edisoncor.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carga de Clientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N
        panel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel1KeyPressed(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Domicilio");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("E-mail");

        tfNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombre.setNextFocusableComponent(tfDNI);
        tfNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNombreFocusLost(evt);
            }
        });
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreKeyReleased(evt);
            }
        });

        tfDNI.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDNI.setNextFocusableComponent(tfDomicilio);
        tfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDNIKeyPressed(evt);
            }
        });

        tfTel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTel.setNextFocusableComponent(tfMail);
        tfTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelActionPerformed(evt);
            }
        });
        tfTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTelKeyPressed(evt);
            }
        });

        tfDomicilio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDomicilio.setNextFocusableComponent(tfTel);
        tfDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDomicilioKeyPressed(evt);
            }
        });

        tfMail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfMail.setNextFocusableComponent(btnGuardar);
        tfMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMailKeyPressed(evt);
            }
        });

        lbProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbProvincia.setForeground(new java.awt.Color(255, 255, 255));
        lbProvincia.setText("Localidad");

        lbLocalidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        lbLocalidad.setText("Provincia");

        cbProvincia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbProvincia.setNextFocusableComponent(cbLocalidad);
        cbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProvinciaItemStateChanged(evt);
            }
        });

        cbLocalidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbLocalidad.setNextFocusableComponent(btnGuardar);

        lbNroId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNroId.setForeground(new java.awt.Color(255, 255, 255));
        lbNroId.setText("Nro DNI:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbNroId))
                    .addComponent(lbProvincia)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfDomicilio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProvincia, javax.swing.GroupLayout.Alignment.LEADING, 0, 221, Short.MAX_VALUE)
                            .addComponent(tfMail))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNroId)
                    .addComponent(jLabel5)
                    .addComponent(tfDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProvincia)
                    .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalidad)
                    .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22))
        );

        btnBorrar.setBackground(new java.awt.Color(255, 51, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBorrarMousePressed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnBorrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMousePressed
        // TODO add your handling code here:
        if (personaSeleccionada>0){         
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea borrar a '"
                                            + this.tfNombre.getText() 
                                            + "'?\nPerderá toda la infomación de este Cliente\nSe recomienda NO borrar","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){          
                    borrarCliente(personaSeleccionada);
                    Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("Cliente"); 
                    ponerTodoEnBlanco(true);
            }
        }
    }//GEN-LAST:event_btnBorrarMousePressed

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // TODO add your handling code here:
        guardar();
         if (Instancias.getInstance().abmInmuebles != null){
                Datos.Procedimientos.llenarCBPersona(Instancias.getInstance().abmInmuebles.cbPropietario, "Cliente");
            }
    }//GEN-LAST:event_btnGuardarMousePressed
    
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void cbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProvinciaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange()==1){
            Objetos.Tripla elemCB = (Objetos.Tripla) this.cbProvincia.getSelectedItem();
            Datos.Procedimientos.llenarCBLocalidad(this.cbLocalidad,(Integer) elemCB.getPrimero());            
        }        
    }//GEN-LAST:event_cbProvinciaItemStateChanged

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            guardar();
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void tfNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNombreFocusLost
        // TODO add your handling code here:
//        seleccionar(this.tfNombre.getText());
    }//GEN-LAST:event_tfNombreFocusLost

    private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyReleased
        // TODO add your handling code here:
//        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
//            seleccionar(this.tfNombre.getText());
    }//GEN-LAST:event_tfNombreKeyReleased

    private void tfNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyPressed
        if(tfNombre.getText().length()> 99){
            tfNombre.setText(tfNombre.getText().substring(0, 99));
        }
//        if (java.awt.event.KeyEvent.VK_ESCAPE==evt.getKeyCode()){
//                dispose();
//        }
        
    }//GEN-LAST:event_tfNombreKeyPressed

    private void tfDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDNIKeyPressed
        if(tfDNI.getText().length()> 29){
            tfDNI.setText(tfDNI.getText().substring(0, 29));
        }
    }//GEN-LAST:event_tfDNIKeyPressed

    private void tfDomicilioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDomicilioKeyPressed
        if(tfDomicilio.getText().length()> 99){
            tfDomicilio.setText(tfDomicilio.getText().substring(0, 99));
        }
    }//GEN-LAST:event_tfDomicilioKeyPressed

    private void tfTelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelKeyPressed
        if(tfTel.getText().length()> 29){
            tfTel.setText(tfTel.getText().substring(0, 29));
        }
    }//GEN-LAST:event_tfTelKeyPressed

    private void tfMailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMailKeyPressed
        if(tfMail.getText().length()> 99){
            tfMail.setText(tfMail.getText().substring(0, 99));
        }
    }//GEN-LAST:event_tfMailKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:

            
    }//GEN-LAST:event_jPanel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
//            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){
//            
//            dispose();
//        }
    }//GEN-LAST:event_formKeyPressed

    private void keyReleased(java.awt.event.KeyEvent evt){
        if (evt.getSource()== tfNombre) {
            if (java.awt.event.KeyEvent.VK_ESCAPE==evt.getKeyCode()){
                dispose();
                
            }
        }
    }
    
    
    
    private void panel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panel1KeyPressed

    private void tfTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelActionPerformed

    private void guardar(){
        if (controlesOk()){          
            Tripla loc = (Tripla) this.cbLocalidad.getSelectedItem();
            if (personaSeleccionada==-1){
                altaCliente(this.tfNombre.getText(),"DNI",
                                            this.tfDNI.getText(),this.tfMail.getText(),
                                            this.tfTel.getText(), this.tfDomicilio.getText(), 
                                            (Integer) loc.getPrimero(), "Cliente", 0);
                
                JOptionPane.showMessageDialog(this, "El Cliente se ha cargado con éxito");
            } else {                   
                actualizarCliente(personaSeleccionada,this.tfNombre.getText(), "DNI",
                                            this.tfDNI.getText(),this.tfMail.getText(),
                                            this.tfTel.getText(), this.tfDomicilio.getText(), 
                                            (Integer) loc.getPrimero(), "Cliente");
                JOptionPane.showMessageDialog(this, "El Cliente se actualizó con éxito");            
            }
            ponerTodoEnBlanco(true);
            Datos.Instancias.getInstance().pantallaPrincipal.refrezcarListas("Cliente");
        }   
    }
    
    public void cerrar(){
        this.dispose();
    }  
    
    private boolean controlesOk(){
        if (this.tfNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un Nombre");
            this.tfNombre.grabFocus();
            return false;
        }      
        if (tfDNI.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un número de identificación");
            tfDNI.grabFocus();
            return false;
        }
        else{
            ResultSet rs = SqlMetodo.runQuery("SELECT id_persona FROM inmobiliaria.persona WHERE nrodoc_persona = '"+tfDNI.getText()+"';");
            try {
                if (rs.next()){
                    if (personaSeleccionada != rs.getInt("id_persona")){
                        JOptionPane.showMessageDialog(this, "En número de identificación ya se encuentra registrado.");
                        tfDNI.grabFocus();
                        tfDNI.setText("");
                        return false;
                    }
                }
            } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en linea 472 metodo controlesOk en la clase AbmPersonal.java: "+ex);
            }
                
        }
            
        return true;
    }    
    
    private int altaCliente(String nombre,String tipoDoc, String nro,  String mail, String tel, String dir, int idLoc, String tipo, float montoini){
        int ultimo = obtenerUltimo("id_persona","persona");
        ProcedimientosSQL.SqlMetodo.runQuery("INSERT INTO inmobiliaria.persona(\n" +
                        "            razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                        "            mail_persona, telefono_persona, direccion_persona,  \n" +
                        "            tipo_persona, id_ciudad_persona)\n" +
                        "    VALUES (initcap('"+nombre+"'), '"+tipoDoc+"', '"+nro+"', \n" +
                        "            '"+mail+"', '"+tel+"', '"+dir+"', \n" +
                        "            '"+tipo+"', '"+idLoc+"')");
        int nuevo = obtenerUltimo("id_persona","persona");
        /*ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.cuentacorriente "
                + " SET saldoinical_cuentacorriente = "+montoini+", saldo_cuentacorriente="+montoini+" "
                + " WHERE id_persona_cuentacorriente="+nuevo);*/
        
        if (ultimo==nuevo){
            return -1;
        } else {
            return nuevo;
        }
    }
    
    private void actualizarCliente(int id, String nombre,String tipoDoc, String nro,  String mail, String tel, String dir, int idLoc, String tipo){
        ProcedimientosSQL.SqlMetodo.runQuery("UPDATE inmobiliaria.persona\n" +
            "   SET razonsocial_persona='"+nombre+"', tipodoc_persona='"+tipoDoc+"', nrodoc_persona='"+nro+"', \n" +
            "       mail_persona='"+mail+"', telefono_persona='"+tel+"', direccion_persona='"+dir+"', tipo_persona='"+tipo+"'," +
            "       id_ciudad_persona="+idLoc+"\n" +
            " WHERE id_persona="+id+" AND tipo_persona='"+tipo+"';");
    }    
    
    private void borrarCliente(int id){
        ProcedimientosSQL.SqlMetodo.runQuery("DELETE FROM inmobiliaria.persona WHERE id_persona="+id+";");  
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction btnBorrar;
    private org.edisoncor.gui.button.ButtonColoredAction btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbLocalidad;
    private javax.swing.JComboBox cbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLocalidad;
    private javax.swing.JLabel lbNroId;
    private javax.swing.JLabel lbProvincia;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField tfDNI;
    private javax.swing.JTextField tfDomicilio;
    private javax.swing.JTextField tfMail;
    public javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTel;
    // End of variables declaration//GEN-END:variables

}
