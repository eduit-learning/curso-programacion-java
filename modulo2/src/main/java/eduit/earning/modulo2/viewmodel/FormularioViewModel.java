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
import eduit.learning.modulo2.utils.EmpleadoComparator;
import eduit.learning.modulo2.utils.EmpleadoJListItemRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author abraham
 */
public class FormularioViewModel {

    private final Formulario view;
    private List<Empleado> listaEmpleados;
    private int selectedIndex;

    public FormularioViewModel(Formulario view) throws IOException, SQLException {
        this.view = view;

        this.InicializarEventos();

        this.LimpiarComponentes();
        this.HabilitarDeshabilitarComponentes(false);
        this.MostrarOcultarBotonesPrincipales(true);
        this.MostrarOcultarBotonesSecundarios(false);

        this.listaEmpleados = new ArrayList();
        this.selectedIndex = -1;

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

        this.view.lstEmpleados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                AccionMostrarDetalleEmpleado(view.lstEmpleados.getSelectedValue());
            }

        });

        this.view.btnCargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCargarArchivo();
            }
        });
    }

    private void AccionNuevo() {
        this.LimpiarComponentes();
        this.MostrarOcultarBotonesPrincipales(false);
        this.MostrarOcultarBotonesSecundarios(true);
        this.HabilitarDeshabilitarComponentes(true);
        this.selectedIndex = -1;
    }

    private void AccionModificar() {
        if (this.selectedIndex != -1) {
            this.HabilitarDeshabilitarComponentes(true);
            this.MostrarOcultarBotonesPrincipales(false);
            this.MostrarOcultarBotonesSecundarios(true);
            this.listaEmpleados.remove(this.selectedIndex);
        } else {
            JOptionPane.showConfirmDialog(this.view, "¡Seleccione el elemento que quiere modificar!", "Seleccione un elemento",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void AccionEliminar() {
        if (this.selectedIndex != -1) {
            var result = JOptionPane.showConfirmDialog(this.view, "¿Está seguro que desea eliminar el elemento seleccionado?", "Eliminar elemento",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                this.listaEmpleados.remove(this.selectedIndex);
                this.GuardarEnArchivo();
                this.LeerArchivo();
                this.LlenarListaEmpleadosVista();
                this.LimpiarComponentes();
            }
        } else {
            JOptionPane.showConfirmDialog(this.view, "¡Seleccione el elemento que quiere modificar!", "Seleccione un elemento",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
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

        try {
            this.listaEmpleados.add(emp);
        } catch (Exception ex) {
            String x = ex.getMessage();
        }

        boolean guardadoExitoso = this.GuardarEnArchivo();
        if (guardadoExitoso == true) {
            this.LimpiarComponentes();
            this.MostrarOcultarBotonesPrincipales(true);
            this.MostrarOcultarBotonesSecundarios(false);
            this.HabilitarDeshabilitarComponentes(false);
        }

        this.selectedIndex = -1;
    }

    private void AccionCancelar() {
        var result = JOptionPane.showConfirmDialog(this.view, "¿Está seguro que desea cancelar la operación?", "Cancelar operación",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            this.LimpiarComponentes();
            this.MostrarOcultarBotonesPrincipales(true);
            this.MostrarOcultarBotonesSecundarios(false);
            this.HabilitarDeshabilitarComponentes(false);
            this.LeerArchivo();
            this.LlenarListaEmpleadosVista();
        }

        this.selectedIndex = -1;
    }

    private void AccionMostrarDetalleEmpleado(Empleado emp) {
        if (emp != null) {
            this.selectedIndex = this.view.lstEmpleados.getSelectedIndex();
            this.view.txtNombre.setText(emp.getNombre());
            this.view.txtApellidos.setText(emp.getApellidos());
            this.view.txtDepartamento.setText(emp.getDepartamento());
            this.view.txtEmail.setText(emp.getEmail());
            this.view.txtObservaciones.setText(emp.getObservaciones());
            this.view.spnEdad.setValue(emp.getEdad());
            switch (emp.getGenero().getNumVal()) {
                case 1:
                    this.view.rbnHombre.setSelected(true);
                    break;
                case 2:
                    this.view.rbnMujer.setSelected(true);
                    break;
                default:
                    this.view.rbnOtro.setSelected(true);
                    break;
            }
        }
    }

    private void AccionCargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this.view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //this.LeerArchivo(selectedFile.getAbsolutePath());
        }
    }

    private void MostrarOcultarBotonesPrincipales(boolean estanVisibles) {
        this.view.btnNuevo.setVisible(estanVisibles);
        this.view.btnModificar.setVisible(estanVisibles);
        this.view.btnEliminar.setVisible(estanVisibles);
        this.view.btnCargarArchivo.setVisible(estanVisibles);
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

        this.view.lstEmpleados.setEnabled(!estanHabilitados);
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

        for (Empleado emp : this.listaEmpleados) {
            //listModel.addElement(emp.getNombre() + " " + emp.getApellidos());
            listModel.addElement(emp);
        }

        this.view.lstEmpleados.setModel(listModel);
        this.view.lstEmpleados.setCellRenderer(new EmpleadoJListItemRenderer());
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
            this.listaEmpleados = new ArrayList<Empleado>();

            //this.listaEmpleados = Arrays.asList(gson.fromJson(sb.toString(), Empleado[].class));
            for (var item : gson.fromJson(sb.toString(), Empleado[].class)) {
                this.listaEmpleados.add(item);
            }

            Collections.sort(this.listaEmpleados, new EmpleadoComparator());
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean GuardarEnArchivo() {
        try {
            FileWriter fw = new FileWriter("C:\\TMP\\Formulario_ListaEmpleados.txt");

            Gson gson = new Gson();
            String listaEmpleadosJson = gson.toJson(this.listaEmpleados);

            fw.write(listaEmpleadosJson);
            fw.close();

            this.LlenarListaEmpleadosVista();

            return true;
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
