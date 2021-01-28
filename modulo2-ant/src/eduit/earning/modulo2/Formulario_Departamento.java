package eduit.earning.modulo2;

import eduit.earning.modulo2.viewmodel.FormularioViewModel;
import eduit.earning.modulo2.viewmodel.FormularioViewModelDataBase;
import eduit.earning.modulo2.viewmodel.Formulario_DepartamentoViewModelDataBase;
import eduit.learning.modulo2.model.Empleado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Formulario_Departamento extends javax.swing.JFrame {

    public Formulario_Departamento() throws IOException, SQLException {
        initComponents();

        //Formulario f = new Formulario();
        //FormularioViewModel fvm = new FormularioViewModel(f);
        //Esta línea de código es equivalente a las dos líneas de código comentadas en la parte de arriba
        //FormularioViewModel fvm = new FormularioViewModel(this);
        Formulario_DepartamentoViewModelDataBase fvm = new Formulario_DepartamentoViewModelDataBase(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGeneros = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        btgIdioma = new javax.swing.ButtonGroup();
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
        lblObservaciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEmpleados = new javax.swing.JList<>();
        btnCargarArchivo = new javax.swing.JButton();
        cmbDepartamento = new javax.swing.JComboBox<>();
        btnNuevoDepartamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbnEspañol = new javax.swing.JRadioButton();
        rbnIngles = new javax.swing.JRadioButton();

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

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        lstEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(lstEmpleados);

        jScrollPane3.setViewportView(jScrollPane2);

        btnCargarArchivo.setText("Cargar Archivo");
        btnCargarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNuevoDepartamento.setText("+");
        btnNuevoDepartamento.setToolTipText("Agregar un nuevo departamento");
        btnNuevoDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoDepartamento.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Idiomas"));

        btgIdioma.add(rbnEspañol);
        rbnEspañol.setSelected(true);
        rbnEspañol.setText("Español");
        rbnEspañol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btgIdioma.add(rbnIngles);
        rbnIngles.setText("Inglés");
        rbnIngles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbnEspañol)
                .addGap(18, 18, 18)
                .addComponent(rbnIngles)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnEspañol)
                    .addComponent(rbnIngles)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblObservaciones))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidos)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEdad)
                                    .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDepartamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoDepartamento))
                            .addComponent(cmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                    .addComponent(lblDepartamento)
                                    .addComponent(btnNuevoDepartamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblObservaciones)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnCargarArchivo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
        lblObservaciones.getAccessibleContext().setAccessibleName("lblObservaciones");
        btnNuevo.getAccessibleContext().setAccessibleName("btnNuevo");
        btnModificar.getAccessibleContext().setAccessibleName("btnModificar");
        btnEliminar.getAccessibleContext().setAccessibleName("btnEliminar");
        btnGuardar.getAccessibleContext().setAccessibleName("btnGuardar");
        btnCancelar.getAccessibleContext().setAccessibleName("btnCancelar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Formulario_Departamento().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Formulario_Departamento.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Formulario_Departamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup btgGeneros;
    public javax.swing.ButtonGroup btgIdioma;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCargarArchivo;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnNuevoDepartamento;
    public javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDepartamento;
    public javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmail;
    public javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    public javax.swing.JList<Empleado> lstEmpleados;
    private javax.swing.JPanel pnlGeneros;
    public javax.swing.JRadioButton rbnEspañol;
    public javax.swing.JRadioButton rbnHombre;
    public javax.swing.JRadioButton rbnIngles;
    public javax.swing.JRadioButton rbnMujer;
    public javax.swing.JRadioButton rbnOtro;
    public javax.swing.JSpinner spnEdad;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
