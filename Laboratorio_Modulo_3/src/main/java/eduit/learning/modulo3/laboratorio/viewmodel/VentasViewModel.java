package eduit.learning.modulo3.laboratorio.viewmodel;

import eduit.learning.modulo3.laboratorio.modelo.Venta;
import eduit.learning.modulo3.laboratorio.repository.SQLContext;
import eduit.learning.modulo3.laboratorio.utils.Convertidor;
import eduit.learning.modulo3.laboratorio.utils.Holder;
import eduit.learning.modulo3.laboratorio.utils.Utils;
import eduit.learning.modulo3.laboratorio.vista.VentasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VentasViewModel {

    private List<Venta> ventasArchivo;
    private List<Venta> ventasBaseDatos;
    private StringBuilder mensajesProcesamientoArchivo;
    private Locale applicationLocale;
    private ResourceBundle mensajesVentasRG;
    private ResourceBundle etiquetasVentasRG;
    private VentasView view;
    private SQLContext context;

    public VentasViewModel(VentasView view, SQLContext context) {
        this.view = view;
        this.context = context;

        this.accionCambiarIdiomaRegion("es", "MX");
        this.inicializarEtiquetas();
        this.inicializarEventos();
        this.mostrarOcultarBotonesArchivo(true);
        this.mostrarOcultarBotonesBaseDatos(false);

    }

    private void inicializarEventos() {
        this.view.tabPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                accionTabSelectionChanged();
            }
        });

        this.view.btnAbrirArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionAbrirArchivo();
            }
        });

        this.view.mitemArchivoAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionAbrirArchivo();
            }
        });
    }

    private void inicializarEtiquetas() {
        this.view.setTitle(this.etiquetasVentasRG.getString("ventas_view_tiutlo"));

        this.view.mnuArchivo.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.mnuArchivo.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.mitemArchivoAbrir.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Abrir"));
        this.view.mitemArchivoAbrir.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Abrir"));
        this.view.mitemArchivoEditar.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Editar"));
        this.view.mitemArchivoEditar.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Editar"));
        this.view.mitemArchivoGuardar.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Guardar"));
        this.view.mitemArchivoGuardar.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Guardar"));
        this.view.mitemArchivoDescartar.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Descartar"));
        this.view.mitemArchivoDescartar.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Descartar"));

        this.view.mnuBaseDatos.setText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos"));
        this.view.mnuBaseDatos.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos"));
        this.view.mitemBaseDatosGuardar.setText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos_Guadar"));
        this.view.mitemBaseDatosGuardar.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos_Guadar"));
        this.view.mitemBaseDatosActualizar.setText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos_Actualizar"));
        this.view.mitemBaseDatosActualizar.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos_Actualizar"));

        this.view.tabPanel.setTitleAt(0, this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.tabPanel.setTitleAt(1, this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos"));

        JTableHeader tableHeader = this.view.tblArchivos.getTableHeader();
        tableHeader.getColumnModel().getColumn(0).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_codigoProducto"));
        tableHeader.getColumnModel().getColumn(1).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_nombreProducto"));
        tableHeader.getColumnModel().getColumn(2).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_cantidad"));
        tableHeader.getColumnModel().getColumn(3).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_fecha"));
        tableHeader.getColumnModel().getColumn(4).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_sucursal"));
        tableHeader.getColumnModel().getColumn(5).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_precioUnitario"));
        tableHeader.getColumnModel().getColumn(6).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_factor"));
        tableHeader.getColumnModel().getColumn(7).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importe"));
        tableHeader.getColumnModel().getColumn(8).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importeUSD"));
        tableHeader.repaint();

        tableHeader = this.view.tblBaseDatos.getTableHeader();
        tableHeader.getColumnModel().getColumn(0).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_ventaID"));
        tableHeader.getColumnModel().getColumn(1).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_codigoProducto"));
        tableHeader.getColumnModel().getColumn(2).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_nombreProducto"));
        tableHeader.getColumnModel().getColumn(3).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_cantidad"));
        tableHeader.getColumnModel().getColumn(4).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_fecha"));
        tableHeader.getColumnModel().getColumn(5).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_sucursal"));
        tableHeader.getColumnModel().getColumn(6).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_precioUnitario"));
        tableHeader.getColumnModel().getColumn(7).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_factor"));
        tableHeader.getColumnModel().getColumn(8).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importe"));
        tableHeader.getColumnModel().getColumn(9).setHeaderValue(this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importeUSD"));
        tableHeader.repaint();

    }

    private void accionCambiarIdiomaRegion(String idioma, String region) {
        this.applicationLocale = new Locale(idioma, region);
        this.mensajesVentasRG = Utils.getMensajesVentasRB(this.applicationLocale);
        this.etiquetasVentasRG = Utils.getEtiquetasVentasRB(this.applicationLocale);
        this.inicializarEtiquetas();
    }

    private void accionAbrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setMultiSelectionEnabled(false);

        int result = fileChooser.showOpenDialog(this.view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.leerArchivo(selectedFile.getAbsolutePath());
            this.llenarTablaArchivo();
        }
    }

    private void accionGuardarEnBaseDatos() {

    }

    private void accionGuardarArchivo() {

    }

    private void accionDescartarArchivo() {

    }

    private void accionTabSelectionChanged() {
        if (this.view.tabPanel.getSelectedIndex() == 0) {
            this.mostrarOcultarBotonesArchivo(true);
            this.mostrarOcultarBotonesBaseDatos(false);
        } else {
            this.mostrarOcultarBotonesArchivo(false);
            this.mostrarOcultarBotonesBaseDatos(true);
        }
    }

    private void mostrarOcultarBotonesArchivo(boolean estaVisible) {
        this.view.btnAbrirArchivo.setVisible(estaVisible);
        this.view.btnEditarArchivo.setVisible(estaVisible);
        this.view.btnGuardarArchivo.setVisible(estaVisible);
        this.view.btnDescartarArchivo.setVisible(estaVisible);
    }

    private void mostrarOcultarBotonesBaseDatos(boolean estaVisible) {
        this.view.btnGuardarEnBaseDatos.setVisible(estaVisible);
        this.view.btnActualizarDeBaseDatos.setVisible(estaVisible);
    }

    private void llenarTablaArchivo() {
        String[] columnNames = new String[]{this.etiquetasVentasRG.getString("ventas_view_tabla_columna_codigoProducto"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_nombreProducto"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_cantidad"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_fecha"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_sucursal"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_precioUnitario"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_factor"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importe"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_importeUSD"),};

        DefaultTableModel tmodel = new DefaultTableModel();
        tmodel.setColumnIdentifiers(columnNames);

        for (var item : this.ventasArchivo) {
            tmodel.addRow(new Object[]{item.getCodigoProducto(), item.getNombreProducto(), item.getCantidad(), item.getFecha(),
                item.getSucursal(), item.getPrecioUnitario(), item.getFactor(), item.getImporte(), item.getImporteUSD()});
        }

        this.view.tblArchivos.setModel(tmodel);
    }

    private void leerArchivo(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            this.mensajesProcesamientoArchivo = new StringBuilder();
            this.ventasArchivo = new ArrayList();

            while ((linea = br.readLine()) != null) {
                Venta venta = new Venta();

                if (this.getVentaFromText(linea, venta) == true) {
                    venta.setImporte(venta.getPrecioUnitario() * venta.getCantidad());
                    venta.setImporteUSD(venta.getImporte() * venta.getFactor());
                    this.ventasArchivo.add(venta);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    private boolean getVentaFromText(String stringVenta, Venta output) {
        boolean resultado = true;

        if (stringVenta == null || stringVenta.length() == 0) {
            resultado = false;
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_linea_blanco"));
        } else {
            String[] campos = stringVenta.split(",");
            this.mensajesProcesamientoArchivo.append(stringVenta);

            if (campos.length >= 10) {
                if (campos[8] == null || campos[8].length() == 0) {
                    output.setRegion("US");
                } else {
                    output.setRegion(campos[8]);
                }

                if (campos[9] == null || campos[9].length() == 0) {
                    output.setIdioma("en");
                } else {
                    output.setIdioma(campos[9]);
                }

                resultado = this.validarCodigoProducto(campos[0], output);
                resultado = this.validarNombreProducto(campos[1], output);
                resultado = this.validarCantidad(campos[2], output);
                resultado = this.validarFecha(campos[3], output);
                resultado = this.validarSucursal(campos[4], output);
                resultado = this.validarPrecioUnitario(campos[5], output);
                resultado = this.validarFactor(campos[6], output);
                output.setUri(campos[7]);
            } else {
                resultado = false;
                this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_camposIncompletos"));
            }
        }

        if (resultado == true) {
            this.mensajesProcesamientoArchivo.append("100%");
        }

        this.mensajesProcesamientoArchivo.append("_______________________________________________");
        this.mensajesProcesamientoArchivo.append("\n\r\n\r\n\r");

        return resultado;
    }

    private boolean validarCodigoProducto(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_codigoProducto_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            output.setCodigoProducto(campo);
        }

        return true;
    }

    private boolean validarNombreProducto(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_nombreProducto_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            output.setNombreProducto(campo);
        }

        return true;
    }

    private boolean validarCantidad(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_cantidad_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            Holder<Double> cantidad = new Holder<>(0.0);
            if (Convertidor.getDoubleFromString(campo, cantidad) == false) {
                this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_cantidad_formato")).append(": ").append(campo);
                this.mensajesProcesamientoArchivo.append("\n\r");

                return false;
            } else {
                output.setCantidad(cantidad.getValue());
            }
        }

        return true;
    }

    private boolean validarFecha(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_fecha_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            Date fecha = new Date();
            if (Convertidor.getFechaFromString(campo, fecha, output.getIdioma(), output.getRegion()) == false) {
                this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_fecha_formato")).append(": ").append(campo);
                this.mensajesProcesamientoArchivo.append("\n\r");

                return false;
            } else {
                output.setFecha(fecha);
            }
        }

        return true;
    }

    private boolean validarSucursal(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_sucursal_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            output.setSucursal(campo);
        }

        return true;
    }

    private boolean validarPrecioUnitario(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_precioUnitario_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            Holder<Double> precioUnitario = new Holder<>(0.0);
            if (Convertidor.getDoubleFromString(campo, precioUnitario) == false) {
                this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_precioUnitario_formato")).append(": ").append(campo);
                this.mensajesProcesamientoArchivo.append("\n\r");

                return false;
            } else {
                output.setPrecioUnitario(precioUnitario.getValue());
            }
        }

        return true;
    }

    private boolean validarFactor(String campo, Venta output) {
        if (campo == null || campo.length() == 0) {
            this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_factor_vacio")).append(": ").append(campo);
            this.mensajesProcesamientoArchivo.append("\n\r");

            return false;
        } else {
            Holder<Double> factor = new Holder<>(0.0);
            if (Convertidor.getDoubleFromString(campo, factor) == false) {
                this.mensajesProcesamientoArchivo.append(this.mensajesVentasRG.getString("error_archivo_factor_formato")).append(": ").append(campo);
                this.mensajesProcesamientoArchivo.append("\n\r");

                return false;
            } else {
                output.setFactor(factor.getValue());
            }
        }

        return true;
    }
}
