package eduit.earning.modulo2;

import javax.swing.JOptionPane;

public class Formulario extends javax.swing.JFrame {
    public Formulario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGeneros = new javax.swing.ButtonGroup();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        spnEdad = new javax.swing.JSpinner();
        pnlGeneros = new javax.swing.JPanel();
        rbnHombre = new javax.swing.JRadioButton();
        rbnMujer = new javax.swing.JRadioButton();
        rbnOtro = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        lblObservaciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Captura de empleado");
        setResizable(false);

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("Nombre");
        lblNombre.setToolTipText("Nombre");

        txtNombre.setToolTipText("Capture el nombre del empleado");

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellidos.setText("Apellidos");
        lblApellidos.setToolTipText("Apellidos");

        txtApellidos.setToolTipText("Capture los apellidos del empleado");

        lblEdad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEdad.setText("Edad");
        lblEdad.setToolTipText("Edad");

        spnEdad.setModel(new javax.swing.SpinnerNumberModel(Byte.valueOf((byte)18), Byte.valueOf((byte)18), Byte.valueOf((byte)75), Byte.valueOf((byte)1)));
        spnEdad.setToolTipText("Seleccione la edad del empleado");

        pnlGeneros.setBorder(javax.swing.BorderFactory.createTitledBorder("Generos"));

        btgGeneros.add(rbnHombre);
        rbnHombre.setText("Hombre");
        rbnHombre.setToolTipText("Hombre");
        rbnHombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btgGeneros.add(rbnMujer);
        rbnMujer.setText("Mujer");
        rbnMujer.setToolTipText("Mujer");
        rbnMujer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btgGeneros.add(rbnOtro);
        rbnOtro.setText("Otro");
        rbnOtro.setToolTipText("Otro");
        rbnOtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlGenerosLayout = new javax.swing.GroupLayout(pnlGeneros);
        pnlGeneros.setLayout(pnlGenerosLayout);
        pnlGenerosLayout.setHorizontalGroup(
            pnlGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnHombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbnMujer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbnOtro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGenerosLayout.setVerticalGroup(
            pnlGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGenerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnHombre)
                    .addComponent(rbnMujer)
                    .addComponent(rbnOtro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEmail.setText("Correo electrónico");
        lblEmail.setToolTipText("Correo electrónico");

        lblDepartamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDepartamento.setText("Departamento");
        lblDepartamento.setToolTipText("Departamento");

        txtEmail.setToolTipText("Capture el correo electrónico del empleado");

        txtDepartamento.setToolTipText("Capture el departamento del empleado");

        lblObservaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblObservaciones.setText("Observaciones");
        lblObservaciones.setToolTipText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setToolTipText("Capture las observaciones del empleado");
        jScrollPane1.setViewportView(txtObservaciones);
        txtObservaciones.getAccessibleContext().setAccessibleName("txtObservaciones");

        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellidos)
                                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEdad)
                                            .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblDepartamento))
                                .addGap(18, 18, 18)
                                .addComponent(pnlGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))
                    .addComponent(lblObservaciones)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblApellidos)
                            .addComponent(lblEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(lblDepartamento))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObservaciones)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lblNombre.getAccessibleContext().setAccessibleName("lblNombre");
        txtNombre.getAccessibleContext().setAccessibleName("txtNombre");
        lblApellidos.getAccessibleContext().setAccessibleName("lblApellidos");
        txtApellidos.getAccessibleContext().setAccessibleName("txtApellidos");
        lblEdad.getAccessibleContext().setAccessibleName("lblEdad");
        spnEdad.getAccessibleContext().setAccessibleName("spnEdad");
        pnlGeneros.getAccessibleContext().setAccessibleName("pnlGeneros");
        lblEmail.getAccessibleContext().setAccessibleName("lblEmail");
        lblDepartamento.getAccessibleContext().setAccessibleName("lblDepartamento");
        txtEmail.getAccessibleContext().setAccessibleName("txtEmail");
        txtDepartamento.getAccessibleContext().setAccessibleName("txtDepartamento");
        lblObservaciones.getAccessibleContext().setAccessibleName("lblObservaciones");
        btnNuevo.getAccessibleContext().setAccessibleName("btnNuevo");
        btnModificar.getAccessibleContext().setAccessibleName("btnModificar");
        btnEliminar.getAccessibleContext().setAccessibleName("btnEliminar");
        btnGuardar.getAccessibleContext().setAccessibleName("btnGuardar");
        btnCancelar.getAccessibleContext().setAccessibleName("btnCancelar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        var result = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cancelar la operación?", "Cancelar operación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            //InitializeComponents();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup btgGeneros;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JPanel pnlGeneros;
    public javax.swing.JRadioButton rbnHombre;
    public javax.swing.JRadioButton rbnMujer;
    public javax.swing.JRadioButton rbnOtro;
    public javax.swing.JSpinner spnEdad;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtDepartamento;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
