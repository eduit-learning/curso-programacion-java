package eduit.learning.modulo3.laboratorio.viewmodel;

import eduit.learning.modulo3.laboratorio.modelo.Venta;
import eduit.learning.modulo3.laboratorio.repository.SQLContext;
import eduit.learning.modulo3.laboratorio.repository.VentasRepository;
import eduit.learning.modulo3.laboratorio.utils.Convertidor;
import eduit.learning.modulo3.laboratorio.utils.Holder;
import eduit.learning.modulo3.laboratorio.utils.Utils;
import eduit.learning.modulo3.laboratorio.vista.VentasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private VentasRepository ventasRepo;

    public VentasViewModel(VentasView view, SQLContext context) {
        this.view = view;
        this.context = context;
        this.ventasRepo = new VentasRepository(context);

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

        this.view.mitemEspaniol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.mitemEspaniol.isSelected() == true) {
                    accionCambiarIdiomaRegion("es", "MX");
                }
            }
        });

        this.view.mitemIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.mitemIngles.isSelected() == true) {
                    accionCambiarIdiomaRegion("en", "US");
                }
            }
        });

        this.view.mitemArchivoDescartar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionDescartarArchivo();
            }

        });

        this.view.btnDescartarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionDescartarArchivo();
            }

        });

        this.view.btnGuardarEnBaseDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGuardarEnBaseDatos();
            }

        });

        this.view.mitemBaseDatosGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGuardarEnBaseDatos();
            }
        });

        this.view.btnActualizarDeBaseDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionActualizarDeBaseDatos();
            }
        });

        this.view.mitemBaseDatosActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionActualizarDeBaseDatos();
            }
        });

        this.view.btnGuardarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGuardarArchivo();
            }
        });

        this.view.mitemArchivoGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGuardarArchivo();
            }
        });
    }

    private void inicializarEtiquetas() {
        this.view.setTitle(this.etiquetasVentasRG.getString("ventas_view_tiutlo"));

        this.view.mnuArchivo.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.mnuArchivo.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.mitemArchivoAbrir.setText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Abrir"));
        this.view.mitemArchivoAbrir.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_Archivo_Abrir"));
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

        this.view.mnuIdioma.setText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma"));
        this.view.mnuIdioma.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma"));
        this.view.mitemEspaniol.setText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma_espaniol"));
        this.view.mitemEspaniol.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma_espaniol"));
        this.view.mitemIngles.setText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma_ingles"));
        this.view.mitemIngles.setToolTipText(this.etiquetasVentasRG.getString("ventas_view_menu_idioma_ingles"));

        this.view.tabPanel.setTitleAt(0, this.etiquetasVentasRG.getString("ventas_view_menu_Archivo"));
        this.view.tabPanel.setTitleAt(1, this.etiquetasVentasRG.getString("ventas_view_menu_BaseDatos"));

        this.view.pnlMensajesArchivoProcesado.setBorder(javax.swing.BorderFactory.createTitledBorder(this.etiquetasVentasRG.getString("ventas_view_mensajes_titulo")));

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
        try {
            if (this.ventasArchivo != null && this.ventasArchivo.size() > 0) {
                for (var item : this.ventasArchivo) {
                    this.ventasRepo.insertEntity(item);
                }
            }

            this.accionActualizarDeBaseDatos();
            this.view.tabPanel.setSelectedIndex(1);
        } catch (SQLException ex) {

        } catch (Exception ex) {

        }
    }

    private void accionActualizarDeBaseDatos() {
        try {
            this.ventasBaseDatos = this.ventasRepo.getEntity("");
            this.llenarTablaBaseDatos();
        } catch (SQLException ex) {

        } catch (Exception ex) {

        }
    }

    private void accionGuardarArchivo() {
        try {
            if (this.ventasArchivo != null && this.ventasArchivo.size() > 0) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv");
                fileChooser.setFileFilter(filter);
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                fileChooser.setMultiSelectionEnabled(false);

                int result = fileChooser.showOpenDialog(this.view);

                if (result == JFileChooser.APPROVE_OPTION) {
                    StringBuilder sb = new StringBuilder();
                    FileWriter fw = new FileWriter(fileChooser.getSelectedFile());

                    for (var item : this.ventasArchivo) {
                        sb.append(item.getCodigoProducto());
                        sb.append(",");
                        sb.append(item.getNombreProducto());
                        sb.append(",");
                        sb.append(item.getCantidad());
                        sb.append(",");
                        sb.append(item.getFecha());
                        sb.append(",");
                        sb.append(item.getSucursal());
                        sb.append(",");
                        sb.append(item.getPrecioUnitario());
                        sb.append(",");
                        sb.append(item.getFactor());
                        sb.append(",");
                        sb.append(item.getUri());
                        sb.append(",");
                        sb.append(item.getRegion());
                        sb.append(",");
                        sb.append(item.getIdioma());
                        sb.append(",");
                        sb.append(item.getImporte());
                        sb.append(",");
                        sb.append(item.getImporteUSD());
                        sb.append("\n");
                    }

                    fw.write(sb.toString());
                    fw.close();
                    JOptionPane.showConfirmDialog(this.view, this.etiquetasVentasRG.getString("ventas_view_guardararchivo_mensaje"), this.etiquetasVentasRG.getString("ventas_view_guardararchivo_titulo"),
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException ex) {

        } catch (Exception ex) {

        }

    }

    private void accionDescartarArchivo() {
        if (this.ventasArchivo != null && this.ventasArchivo.size() > 0) {
            var result = JOptionPane.showConfirmDialog(this.view, this.etiquetasVentasRG.getString("ventas_view_descartararchivo_mensaje"), this.etiquetasVentasRG.getString("ventas_view_descartararchivo_titulo"),
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                this.ventasArchivo = new ArrayList();
                this.llenarTablaArchivo();
                this.mensajesProcesamientoArchivo = new StringBuilder();
                this.view.txtMensajesArchivoProcesado.setText("");
            }
        }
    }

    private void accionTabSelectionChanged() {
        if (this.view.tabPanel.getSelectedIndex() == 0) {
            this.mostrarOcultarBotonesArchivo(true);
            this.mostrarOcultarBotonesBaseDatos(false);
        } else {
            this.mostrarOcultarBotonesArchivo(false);
            this.mostrarOcultarBotonesBaseDatos(true);
            this.accionActualizarDeBaseDatos();
        }
    }

    private void mostrarOcultarBotonesArchivo(boolean estaVisible) {
        this.view.btnAbrirArchivo.setVisible(estaVisible);
        this.view.btnGuardarArchivo.setVisible(estaVisible);
        this.view.btnDescartarArchivo.setVisible(estaVisible);
    }

    private void mostrarOcultarBotonesBaseDatos(boolean estaVisible) {
        this.view.btnGuardarEnBaseDatos.setVisible(estaVisible);
        this.view.btnActualizarDeBaseDatos.setVisible(estaVisible);
    }

    private void llenarTablaBaseDatos() {
        String[] columnNames = new String[]{this.etiquetasVentasRG.getString("ventas_view_tabla_columna_ventaID"),
            this.etiquetasVentasRG.getString("ventas_view_tabla_columna_codigoProducto"),
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

        for (var item : this.ventasBaseDatos) {
            tmodel.addRow(new Object[]{
                item.getVentaID(),
                item.getCodigoProducto(),
                item.getNombreProducto(),
                item.getCantidad(),
                DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(item.getIdioma(), item.getRegion())).format(item.getFecha()),
                item.getSucursal(),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getPrecioUnitario()),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getFactor()),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getImporte()),
                NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(item.getImporteUSD())
            });
        }

        this.view.tblBaseDatos.setModel(tmodel);
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
            tmodel.addRow(new Object[]{
                item.getCodigoProducto(),
                item.getNombreProducto(),
                item.getCantidad(),
                DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(item.getIdioma(), item.getRegion())).format(item.getFecha()),
                item.getSucursal(),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getPrecioUnitario()),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getFactor()),
                NumberFormat.getCurrencyInstance(new Locale(item.getIdioma(), item.getRegion())).format(item.getImporte()),
                NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(item.getImporteUSD())
            });
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

            this.view.txtMensajesArchivoProcesado.setText(this.mensajesProcesamientoArchivo.toString());
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
            this.mensajesProcesamientoArchivo.append("\n\r");
            this.mensajesProcesamientoArchivo.append("100%");
            this.mensajesProcesamientoArchivo.append("\n\r");
        }

        this.mensajesProcesamientoArchivo.append("-----------------------------------------------------------------------------------------");
        this.mensajesProcesamientoArchivo.append("\n\r");

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
