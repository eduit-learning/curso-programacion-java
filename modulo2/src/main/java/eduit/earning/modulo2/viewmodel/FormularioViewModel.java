/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.earning.modulo2.viewmodel;

import eduit.earning.modulo2.Formulario;
import eduit.learning.modulo2.model.Empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author abraham
 */
public class FormularioViewModel {
    private Formulario view;
    
    public FormularioViewModel(Formulario view){
        this.view = view;
        
        InicializarEventos();
        
        LimpiarComponentes();
        HabilitarDeshabilitarComponentes(false);
        MostrarOcultarBotonesPrincipales(true);
        MostrarOcultarBotonesSecundarios(false);
    }
    
    private void InicializarEventos(){
        this.view.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionNuevo();
            }
            
        });
        
        this.view.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionModificar();
            }
            
        });
        
        this.view.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionEliminar();
            }
            
        });
        
        this.view.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionGuardar();
            }
            
        });
        
        this.view.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCancelar();
            }
            
        });
    }
    
    private void AccionNuevo(){
        
    }
    
    private void AccionModificar(){
        
    }
    
    private void AccionEliminar(){
        
    }
    
    private void AccionGuardar(){
        
    }
    
    private void AccionCancelar(){
        
    }
    
    private void MostrarOcultarBotonesPrincipales(boolean estanVisibles){
        this.view.btnNuevo.setVisible(estanVisibles);
        this.view.btnModificar.setVisible(estanVisibles);
        this.view.btnEliminar.setVisible(estanVisibles);
    }
    
    private void MostrarOcultarBotonesSecundarios(boolean estanVisibles){
        this.view.btnGuardar.setVisible(estanVisibles);
        this.view.btnCancelar.setVisible(estanVisibles);
    }
    
    private void HabilitarDeshabilitarComponentes(boolean estanHabilitados){
        this.view.txtNombre.setEnabled(estanHabilitados);
        this.view.txtApellidos.setEnabled(estanHabilitados);
        this.view.txtDepartamento.setEnabled(estanHabilitados);
        this.view.txtEmail.setEnabled(estanHabilitados);
        this.view.txtObservaciones.setEnabled(estanHabilitados);

        this.view.spnEdad.setEnabled(estanHabilitados);
        this.view.rbnHombre.setEnabled(estanHabilitados);
        this.view.rbnMujer.setEnabled(estanHabilitados);
        this.view.rbnOtro.setEnabled(estanHabilitados);
    }
    
    private void LimpiarComponentes(){
        this.view.txtNombre.setText("");
        this.view.txtApellidos.setText("");
        this.view.txtDepartamento.setText("");
        this.view.txtEmail.setText("");
        this.view.txtObservaciones.setText("");

        this.view.spnEdad.setValue(18);
        this.view.btgGeneros.clearSelection();
    }
}