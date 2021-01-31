package eduit.learning.modulo3.laboratorio.viewmodel;

import eduit.learning.modulo3.laboratorio.modelo.Venta;
import eduit.learning.modulo3.laboratorio.repository.SQLContext;
import eduit.learning.modulo3.laboratorio.utils.Convertidor;
import eduit.learning.modulo3.laboratorio.utils.Holder;
import eduit.learning.modulo3.laboratorio.utils.Utils;
import eduit.learning.modulo3.laboratorio.vista.VentasView;
import java.io.*;
import java.util.*;

public class VentasViewModel {
    
    private List<Venta> ventasArchivo;
    private List<Venta> ventasBaseDatos;
    private StringBuilder mensajesProcesamientoArchivo;
    private Locale applicationLocale;
    private ResourceBundle mensajesVentasRG;
    private VentasView view;
    private SQLContext context;
    
    public VentasViewModel(VentasView view, SQLContext context) {
        this.view = view;
        this.context = context;
    }
    
    private void AccionAbrirArchivo(){
        
    }
    
    private void AccionGuardarEnBaseDatos(){
        
    }
    
    private void AccionGuardarArchivo(){
        
    }
    
    private void AccionDescartarArchivo(){
        
    }
    
    private void LeerArchivo(String path) {
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
            
            if (campos.length < 10) {
                output = new Venta();
                
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
