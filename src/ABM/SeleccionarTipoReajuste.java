package ABM;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class SeleccionarTipoReajuste extends javax.swing.JDialog {
    public boolean ok;
    public double importeAnterior;
    public double importeCalculado;
    public double importe;
    
    public SeleccionarTipoReajuste(java.awt.Frame parent, boolean modal, java.util.Date fecha, double importeAnterior, double importeCalculado) {
        super(parent, modal);
        initComponents();
        lbNuevo.setText("Actualización alquiler de "+new SimpleDateFormat("MM/yyyy").format(fecha));
        tfNuevoImporte.setText(Datos.Procedimientos.Redondear(importeCalculado,2)+"");
        ok = false;
        this.importeAnterior = importeAnterior;
        this.importeCalculado = importeCalculado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel21 = new javax.swing.JLabel();
        btnContinuar = new org.edisoncor.gui.button.ButtonAction();
        tfNuevoImporte = new javax.swing.JTextField();
        lbNuevo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar ALQUILER!");

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Imagenes/fondo1.jpg"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("$");

        btnContinuar.setText("Continuar");
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnContinuarMousePressed(evt);
            }
        });

        tfNuevoImporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfNuevoImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNuevoImporteFocusGained(evt);
            }
        });

        lbNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lbNuevo.setText("Ingrese nuevo importe alquiler");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 192, Short.MAX_VALUE)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNuevo)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMousePressed
        if (Datos.Procedimientos.isNumber(tfNuevoImporte.getText())){
            ok = true;
            importe = Double.parseDouble(tfNuevoImporte.getText());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un importe válido");
        }
    }//GEN-LAST:event_btnContinuarMousePressed

    private void tfNuevoImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNuevoImporteFocusGained
        tfNuevoImporte.setSelectionStart(0);
        tfNuevoImporte.setSelectionEnd(tfNuevoImporte.getText().length());
    }//GEN-LAST:event_tfNuevoImporteFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnContinuar;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel lbNuevo;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField tfNuevoImporte;
    // End of variables declaration//GEN-END:variables
}
