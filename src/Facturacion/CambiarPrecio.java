package Facturacion;

import Datos.Procedimientos;
import java.awt.event.KeyEvent;

public class CambiarPrecio extends javax.swing.JDialog {

    boolean todoOk;
    
    public CambiarPrecio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        todoOk = false;
    }
    
    public void mostrar(){
        tfValor.setSelectionStart(0);
        tfValor.setSelectionEnd(tfValor.getText().length());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTipoInmueble = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        lbTipoInmueble1 = new javax.swing.JLabel();
        btnCambiar = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Valor");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTipoInmueble.setBackground(new java.awt.Color(255, 255, 255));
        lbTipoInmueble.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTipoInmueble.setText("Valor $:");

        tfValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfValor.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        tfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorFocusLost(evt);
            }
        });
        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorKeyPressed(evt);
            }
        });

        lbTipoInmueble1.setBackground(new java.awt.Color(255, 255, 255));
        lbTipoInmueble1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTipoInmueble1.setText("Cambiar importe");

        btnCambiar.setText("Cambiar");
        btnCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCambiarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTipoInmueble)
                        .addGap(18, 18, 18)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbTipoInmueble1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTipoInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorFocusLost

    private void tfValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (Procedimientos.isNumber(tfValor.getText())){
                todoOk = true;
                dispose();
            }
        }
    }//GEN-LAST:event_tfValorKeyPressed

    private void btnCambiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarMousePressed
        if (Procedimientos.isNumber(tfValor.getText())){
            todoOk = true;
            dispose();
        }
    }//GEN-LAST:event_btnCambiarMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnCambiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTipoInmueble;
    private javax.swing.JLabel lbTipoInmueble1;
    public javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
