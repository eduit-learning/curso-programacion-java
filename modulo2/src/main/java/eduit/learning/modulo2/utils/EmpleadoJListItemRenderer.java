/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.learning.modulo2.utils;

import eduit.learning.modulo2.model.Empleado;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author abraham
 */
public class EmpleadoJListItemRenderer extends javax.swing.JPanel implements ListCellRenderer<Empleado> {

    private java.awt.Color colorListEstadoNormal;
    private java.awt.Color colorListEstadoSeleccionado;
    private java.awt.Color colorListEstadoMouseEntered;

    /**
     * Creates new form EmpleadoJListItemRenderes
     */
    public EmpleadoJListItemRenderer() {
        initComponents();

        this.colorListEstadoNormal = new java.awt.Color(200, 239, 255);
        this.colorListEstadoSeleccionado = new java.awt.Color(0, 81, 120);
        this.colorListEstadoMouseEntered = new java.awt.Color(0, 81, 120, 125);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(200, 239, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 81, 120), 1, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        lblDepartamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblDepartamento)
                    .addComponent(lblCorreo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        String c = "";
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblCorreo;
    public javax.swing.JLabel lblDepartamento;
    public javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends Empleado> list, Empleado value, int index, boolean isSelected, boolean cellHasFocus) {
        this.lblNombre.setText(value.getNombre() + " " + value.getApellidos());
        this.lblDepartamento.setText(value.getDepartamento());
        this.lblCorreo.setText(value.getEmail());

        if (isSelected == true) {
            this.setBackground(this.colorListEstadoSeleccionado);
            this.setForeground(this.colorListEstadoSeleccionado);
            this.lblCorreo.setForeground(Color.WHITE);
            this.lblDepartamento.setForeground(Color.WHITE);
            this.lblNombre.setForeground(Color.WHITE);
        } else {
            this.setBackground(this.colorListEstadoNormal);
            this.setForeground(this.colorListEstadoNormal);
            this.lblCorreo.setForeground(Color.BLACK);
            this.lblDepartamento.setForeground(Color.BLACK);
            this.lblNombre.setForeground(Color.BLACK);
        }

        return this;
    }
}
