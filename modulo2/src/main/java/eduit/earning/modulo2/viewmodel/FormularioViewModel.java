/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.earning.modulo2.viewmodel;

import com.google.gson.Gson;
import eduit.earning.modulo2.Formulario;
import eduit.learning.modulo2.model.Empleado;
import eduit.learning.modulo2.model.Generos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author abraham
 */
public class FormularioViewModel {

    private Formulario view;
    private List<Empleado> listaEmpleados;

    public FormularioViewModel(Formulario view) {
        this.view = view;

        InicializarEventos();

        LimpiarComponentes();
        HabilitarDeshabilitarComponentes(false);
        MostrarOcultarBotonesPrincipales(true);
        MostrarOcultarBotonesSecundarios(false);

        listaEmpleados = new ArrayList();

        this.LeerArchivo();
        this.LlenarListaEmpleadosVista();
    }

    private void InicializarEventos() {
        this.view.btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionNuevo();
            }

        });

        this.view.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionModificar();
            }

        });

        this.view.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionEliminar();
            }

        });

        this.view.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionGuardar();
            }

        });

        this.view.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCancelar();
            }

        });
    }

    private void AccionNuevo() {
        LimpiarComponentes();
        MostrarOcultarBotonesPrincipales(false);
        MostrarOcultarBotonesSecundarios(true);
        HabilitarDeshabilitarComponentes(true);
    }

    private void AccionModificar() {

    }

    private void AccionEliminar() {

    }

    private void AccionGuardar() {
        Empleado emp = new Empleado();

        emp.setNombre(this.view.txtNombre.getText());
        emp.setApellidos(this.view.txtApellidos.getText());
        emp.setDepartamento(this.view.txtDepartamento.getText());
        emp.setEmail(this.view.txtEmail.getText());
        emp.setObservaciones(this.view.txtObservaciones.getText());
        emp.setGenero(this.view.rbnHombre.isSelected() == true ? Generos.Hombre
                : this.view.rbnMujer.isSelected() == true ? Generos.Mujer
                : Generos.Otro);
        emp.setEdad(Byte.parseByte(this.view.spnEdad.getValue().toString()));

        this.listaEmpleados.add(emp);

        boolean guardadoExitoso = this.GuardarEnArchivo();
        if (guardadoExitoso == true) {
            LimpiarComponentes();
            MostrarOcultarBotonesPrincipales(true);
            MostrarOcultarBotonesSecundarios(false);
            HabilitarDeshabilitarComponentes(false);
        }

    }

    private void AccionCancelar() {
        var result = JOptionPane.showConfirmDialog(this.view, "¿Está seguro que desea cancelar la operación?", "Cancelar operación",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            LimpiarComponentes();
            MostrarOcultarBotonesPrincipales(true);
            MostrarOcultarBotonesSecundarios(false);
            HabilitarDeshabilitarComponentes(false);
        }
    }

    private void MostrarOcultarBotonesPrincipales(boolean estanVisibles) {
        this.view.btnNuevo.setVisible(estanVisibles);
        this.view.btnModificar.setVisible(estanVisibles);
        this.view.btnEliminar.setVisible(estanVisibles);
    }

    private void MostrarOcultarBotonesSecundarios(boolean estanVisibles) {
        this.view.btnGuardar.setVisible(estanVisibles);
        this.view.btnCancelar.setVisible(estanVisibles);
    }

    private void HabilitarDeshabilitarComponentes(boolean estanHabilitados) {
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

    private void LimpiarComponentes() {
        this.view.txtNombre.setText("");
        this.view.txtApellidos.setText("");
        this.view.txtDepartamento.setText("");
        this.view.txtEmail.setText("");
        this.view.txtObservaciones.setText("");

        this.view.spnEdad.setValue(18);
        this.view.btgGeneros.clearSelection();
    }

    private void LlenarListaEmpleadosVista() {
        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < this.listaEmpleados.size(); i++) {
            listModel.add(i, this.listaEmpleados.get(i).getNombre() + " " + this.listaEmpleados.get(i).getApellidos());
        }

        this.view.lstEmpleados.setModel(listModel);
    }

    private void LeerArchivo() {
        try {
            FileReader fr = new FileReader("C:\\TMP\\Formulario_ListaEmpleados.txt");
            StringBuilder sb = new StringBuilder();

            //String cadena = "Hola";
            //H, o, l, a

            int c = 0;
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
                //cadena = cadena + c;
                //H, o, l, a, r, t, y, u, t, w, 
            }

            fr.close();

            Gson gson = new Gson();
            this.listaEmpleados = Arrays.asList(gson.fromJson(sb.toString(), Empleado[].class));

        } catch (IOException ex) {

        }
    }

    private boolean GuardarEnArchivo() {
        try {
            FileWriter fw = new FileWriter("C:\\TMP\\Formulario_ListaEmpleados.txt");

            Gson gson = new Gson();
            String listaEmpleadosJson = gson.toJson(this.listaEmpleados);

            fw.write(listaEmpleadosJson);
            fw.close();

            return true;
        } catch (IOException ex) {
            var result = JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
