package Principal;

import ABM.ABMContratoA;
import Datos.Instancias;
import Datos.Macros;
import ProcedimientosSQL.SqlMetodo;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PantallaLogin extends javax.swing.JFrame {
    public static SqlMetodo sql= new SqlMetodo();

    public PantallaLogin() {
        initComponents();
        tfUsuario.setUI(new HintTextFieldUI("Nombre de Usuario", true));
        tfPassword.setUI(new HintPasswordFieldUI("Contraseña", true));
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Imagenes/Iconos/DG.png")).getImage());
        String where=" recordar_usuario = 'true' limit 1"; 
        try {
            ResultSet rs = sql.getByWhere("inmobiliaria.usuario", where);
            if (rs.next() == true){
                tfPassword.setText(rs.getString("clave_usuario"));
                tfUsuario.setText(rs.getString("nombre_usuario"));
                chbRecordar.setSelected(true);
            }
        } catch (SQLException ex) {
                Datos.Procedimientos.escribirEnLog("Error en la linea 40 en la pantallaLogin: "+ex.toString());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tfPassword = new org.edisoncor.gui.passwordField.PasswordField();
        tfUsuario = new org.edisoncor.gui.textField.TextField();
        chbRecordar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión");
        setResizable(false);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setColorPrimario(new java.awt.Color(0, 73, 54));
        panel1.setColorSecundario(new java.awt.Color(0, 73, 54));

        tfPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPassword.setNextFocusableComponent(btnContinuar);
        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPasswordKeyPressed(evt);
            }
        });

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfUsuario.setNextFocusableComponent(tfPassword);
        tfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsuarioKeyPressed(evt);
            }
        });

        chbRecordar.setBackground(new java.awt.Color(0, 0, 0));
        chbRecordar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chbRecordar.setForeground(new java.awt.Color(255, 255, 255));
        chbRecordar.setText("Recordarme");
        chbRecordar.setBorder(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/logoBlancoInm.png"))); // NOI18N

        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Ingresar >");
        btnContinuar.setBorderPainted(false);
        btnContinuar.setContentAreaFilled(false);
        btnContinuar.setFocusable(false);
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnContinuarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(chbRecordar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnContinuar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(chbRecordar))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            iniciarSesion();
    }//GEN-LAST:event_tfUsuarioKeyPressed

    private void tfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            iniciarSesion();
    }//GEN-LAST:event_tfPasswordKeyPressed

    private void btnContinuarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMousePressed
        iniciarSesion();
    }//GEN-LAST:event_btnContinuarMousePressed

    private void iniciarSesion(){
        this.btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try {
            if (!this.getUser().isEmpty() && !this.getPassword().isEmpty() && controlarUsuario(this.getUser(),this.getPassword())){
                if (Instancias.getInstance().pantallaPrincipal == null)
                    Instancias.getInstance().pantallaPrincipal = new PantallaPrincipal(); 
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("Cliente");
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("Inmueble");  
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("Alquiler");  
                Instancias.getInstance().pantallaPrincipal.refrezcarListas("AlquilerTodos");  
                Instancias.getInstance().pantallaPrincipal.setVisible(true);
                ResultSet tipoUsuario = SqlMetodo.runQuery("SELECT tipo_persona\n" +
                                          "FROM inmobiliaria.persona WHERE id_persona = '"+Macros.getID_PERSONA()+"'"); 
                if (tipoUsuario.next()){
                    if (tipoUsuario.getString(1).equals("Administrador") || tipoUsuario.getString(1).equals("Empresa"))
                        Macros.setTIPO_USUARIO("Titular");
                    else
                        Macros.setTIPO_USUARIO(tipoUsuario.getString(1));
                }
                this.dispose();
            }
        } catch (SQLException ex) {
            Datos.Procedimientos.escribirEnLog("Error en la linea 242 en la pantallaLogin: "+ex.toString());
        }
        this.btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
    
    private boolean controlarUsuario( String user, String pass) throws SQLException{
        boolean control = false;
        String [] columna = {"recordar_usuario"};
        String [] valor = {"true"};
        String where=" nombre_usuario = '" + user + "' and clave_usuario = '" + pass + "'";
        ResultSet rs = sql.getByWhere("inmobiliaria.usuario", where);
        if (rs.next()){
            control = user.equals(rs.getString("nombre_usuario")) && pass.equals(rs.getString("clave_usuario"));
            if (control == true){
                Macros.setID_USUARIO(rs.getInt("id_usuario"));
                Macros.setID_PERSONA(rs.getInt("id_persona_usuario"));
            }
            llenarMacros(control,rs);
            if (control && chbRecordar.isSelected() && (rs.getString("recordar_usuario").equals("f")))
                sql.update("inmobiliaria.usuario", columna, valor, where);  
                String [] value = {"false"};
            if (control && !chbRecordar.isSelected() && (rs.getString("recordar_usuario").equals("t")))
                sql.update("inmobiliaria.usuario", columna, value, where);  
        }
        else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
            
        return control;
    }
    
    private String getUser(){
     return tfUsuario.getText();
    }
    
    private String getPassword(){
     return tfPassword.getText();
    }
    
    public void setUser(String user){
      tfUsuario.setText(user);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    public static javax.swing.JCheckBox chbRecordar;
    private javax.swing.JLabel jLabel1;
    private org.edisoncor.gui.panel.Panel panel1;
    public static org.edisoncor.gui.passwordField.PasswordField tfPassword;
    public static org.edisoncor.gui.textField.TextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    private void llenarMacros(boolean control, ResultSet rsUsuario) throws SQLException {   
        String consulta="SELECT id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, \n" +
                        "mail_persona, telefono_persona, direccion_persona, estado_persona, \n" +
                        "tipo_persona, id_ciudad_persona, nombre_ciudad, nombre_provincia\n" +
                        " FROM inmobiliaria.persona INNER JOIN inmobiliaria.ciudad ON id_ciudad_persona = id_ciudad "+
                        "INNER JOIN inmobiliaria.provincia ON id_provincia_ciudad =  id_provincia "+ 
                        "WHERE tipo_persona = 'Titular'";
        System.out.println(rsUsuario.getInt("id_persona_usuario"));
        ResultSet pers= SqlMetodo.runQuery(consulta);
        if (pers.next() == true){
            Macros.setCUIT_PROPIO(pers.getString("nrodoc_persona"));
            Macros.setRazonSocial(pers.getString("razonsocial_persona"));
            Macros.setCalle(pers.getString("direccion_persona"));
            Macros.setCiudad(pers.getString("nombre_ciudad"));
            Macros.setProvincia(pers.getString("nombre_provincia")); 
            Macros.setTelefono(pers.getString("telefono_persona"));
            Macros.setTIPO_USUARIO(pers.getString("tipo_persona"));
        }      
    }
}
