/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.earning.modulo2.viewmodel;

import com.google.gson.Gson;
import eduit.earning.modulo2.DepartamentoDialog;
import eduit.earning.modulo2.Formulario_Departamento;
import eduit.learning.modulo2.model.Departamento;
import eduit.learning.modulo2.model.Empleado;
import eduit.learning.modulo2.model.Generos;
import eduit.learning.modulo2.repository.DepartamentoRepository;
import eduit.learning.modulo2.repository.EmpleadoRepository;
import eduit.learning.modulo2.utils.EmpleadoComparator;
import eduit.learning.modulo2.utils.EmpleadoJListItemRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author abraham
 */
public class Formulario_DepartamentoViewModelDataBase {

    private final Formulario_Departamento view;
    private List<Empleado> listaEmpleados;
    private int selectedIndex;
    private EmpleadoRepository empRepository;
    private Locale locale;

    public Formulario_DepartamentoViewModelDataBase(Formulario_Departamento view) throws IOException, SQLException {
        this.view = view;

        this.InicializarEventos();

        this.LimpiarComponentes();
        this.HabilitarDeshabilitarComponentes(false);
        this.MostrarOcultarBotonesPrincipales(true);
        this.MostrarOcultarBotonesSecundarios(false);

        this.selectedIndex = -1;
        this.empRepository = new EmpleadoRepository();

        this.listaEmpleados = this.obtenerEmpleadosServicio();
        this.LlenarListaEmpleadosVista();
        this.LlenarComboDepartamento();
        this.locale = new Locale("es", "MX");
    }

    private List<Empleado> obtenerEmpleadosServicio() {
        try {
            URL url = new URL("http://localhost:8080/PrimeraAplicacionWeb/api/demo/get/json/23");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Ocurrió un error al intentar hacer la petición: " + conn.getResponseCode());
            }

            InputStreamReader sr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(sr);

            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            Gson gson = new Gson();
            this.listaEmpleados = Arrays.asList(gson.fromJson(sb.toString(), Empleado[].class));

            conn.disconnect();
        } catch (Exception ex) {

        }

        return this.listaEmpleados;
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

        this.view.btnNuevoDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionNuevoDepartamento();
            }

        });

        this.view.rbnIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCambiarIdioma("en", "US");
            }
        });

        this.view.rbnEspañol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCambiarIdioma("es", "MX");
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
        } else {
            JOptionPane.showConfirmDialog(this.view, "¡Seleccione el elemento que quiere modificar!", "Seleccione un elemento",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void AccionEliminar() {
        try {
            if (this.selectedIndex != -1) {
                var result = JOptionPane.showConfirmDialog(this.view, "¿Está seguro que desea eliminar el elemento seleccionado?", "Eliminar elemento",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    this.empRepository.eliminarEmpleado(this.view.lstEmpleados.getSelectedValue());
                    this.listaEmpleados = this.empRepository.getEntity("");
                    this.LlenarListaEmpleadosVista();
                    this.LimpiarComponentes();
                }
            } else {
                JOptionPane.showConfirmDialog(this.view, "¡Seleccione el elemento que quiere modificar!", "Seleccione un elemento",
                        JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AccionGuardar() {
        try {
            Empleado emp = new Empleado();

            emp.setNombre(this.view.txtNombre.getText());
            emp.setApellidos(this.view.txtApellidos.getText());
            emp.setDepartamento(this.view.cmbDepartamento.getSelectedItem().toString());
            emp.setEmail(this.view.txtEmail.getText());
            emp.setObservaciones(this.view.txtObservaciones.getText());
            emp.setGenero(this.view.rbnHombre.isSelected() == true ? Generos.Hombre
                    : this.view.rbnMujer.isSelected() == true ? Generos.Mujer
                    : Generos.Otro);
            emp.setEdad(Byte.parseByte(this.view.spnEdad.getValue().toString()));

            int result = 0;

            if (this.selectedIndex != -1) {
                emp.setEmpleadoID(this.view.lstEmpleados.getSelectedValue().getEmpleadoID());
                result = this.empRepository.updateEntity(emp);
            } else {
                result = this.empRepository.insertEntity(emp);
            }

            if (result > 0) {
                this.listaEmpleados = this.empRepository.getEntity("");
                this.LlenarListaEmpleadosVista();
                this.LimpiarComponentes();
                this.MostrarOcultarBotonesPrincipales(true);
                this.MostrarOcultarBotonesSecundarios(false);
                this.HabilitarDeshabilitarComponentes(false);
            }

            this.selectedIndex = -1;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AccionCancelar() {
        try {
            var result = JOptionPane.showConfirmDialog(this.view, "¿Está seguro que desea cancelar la operación?", "Cancelar operación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                this.LimpiarComponentes();
                this.MostrarOcultarBotonesPrincipales(true);
                this.MostrarOcultarBotonesSecundarios(false);
                this.HabilitarDeshabilitarComponentes(false);
                this.listaEmpleados = this.empRepository.getEntity("");
                this.LlenarListaEmpleadosVista();
            }

            this.selectedIndex = -1;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AccionMostrarDetalleEmpleado(Empleado emp) {
        if (emp != null) {
            this.selectedIndex = this.view.lstEmpleados.getSelectedIndex();
            this.view.txtNombre.setText(emp.getNombre());
            this.view.txtApellidos.setText(emp.getApellidos());
            this.view.cmbDepartamento.setSelectedItem(emp.getDepartamento());
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
            this.LeerArchivo(selectedFile.getAbsolutePath());
        }
    }

    private void AccionNuevoDepartamento() {
        DepartamentoDialog depDialog = new DepartamentoDialog(this.view, true, this.locale);
        depDialog.setVisible(true);
        depDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //Aún no se hace el dispose
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //Ya se hizo el dispose
                LlenarComboDepartamento();
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

        });
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
        this.view.cmbDepartamento.setEnabled(estanHabilitados);
        this.view.txtEmail.setEnabled(estanHabilitados);
        this.view.txtObservaciones.setEnabled(estanHabilitados);

        this.view.spnEdad.setEnabled(estanHabilitados);
        this.view.rbnHombre.setEnabled(estanHabilitados);
        this.view.rbnMujer.setEnabled(estanHabilitados);
        this.view.rbnOtro.setEnabled(estanHabilitados);

        this.view.lstEmpleados.setEnabled(!estanHabilitados);
        this.view.btnNuevoDepartamento.setEnabled(estanHabilitados);
    }

    private void LimpiarComponentes() {
        this.view.txtNombre.setText("");
        this.view.txtApellidos.setText("");
        this.view.txtEmail.setText("");
        this.view.txtObservaciones.setText("");

        this.view.spnEdad.setValue(18);
        this.view.btgGeneros.clearSelection();
    }

    private void LlenarListaEmpleadosVista() {
        DefaultListModel listModel = new DefaultListModel();

        for (Empleado emp : this.listaEmpleados) {
            listModel.addElement(emp);
        }

        this.view.lstEmpleados.setModel(listModel);
        this.view.lstEmpleados.setCellRenderer(new EmpleadoJListItemRenderer());
    }

    private void LeerArchivo(String path) {
        try {
            FileReader fr = new FileReader(path);
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
            for (var item : gson.fromJson(sb.toString(), Empleado[].class)) {
                this.listaEmpleados.add(item);
            }

            Collections.sort(this.listaEmpleados, new EmpleadoComparator());

            this.LlenarListaEmpleadosVista();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void LlenarComboDepartamento() {
        try {
            DepartamentoRepository depRepo = new DepartamentoRepository();
            List<Departamento> departamentos = depRepo.getEntity("");

            DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>();

            for (Departamento depto : departamentos) {
                cmbModel.addElement(depto.getNombre());
            }

            this.view.cmbDepartamento.setModel(cmbModel);

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el archivo!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AccionCambiarIdioma(String idioma, String region) {
        this.locale = new Locale(idioma, region);
        ResourceBundle exampleBundle = ResourceBundle.getBundle("eduit.learning.modulo2.repository.DepartamentoResourceBundleFormulario", this.locale);

        this.view.lblNombre.setText(exampleBundle.getString("lblNombre"));
        this.view.lblApellidos.setText(exampleBundle.getString("lblApellidos"));
        this.view.lblEdad.setText(exampleBundle.getString("lblEdad"));
    }

}
