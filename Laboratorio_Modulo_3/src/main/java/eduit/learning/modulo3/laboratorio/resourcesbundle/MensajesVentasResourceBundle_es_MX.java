package eduit.learning.modulo3.laboratorio.resourcesbundle;

import java.util.ListResourceBundle;

public class MensajesVentasResourceBundle_es_MX extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"error_archivo_linea_blanco", "No es posible procesar líneas en blanco"},
            {"error_archivo_camposIncompletos", "No hay suficientes campos para procesar la línea"},
            {"error_archivo_codigoProducto_vacio", "El código del producto no puede estar vacío"},
            {"error_archivo_nombreProducto_vacio", "El nombre del producto no puede estar vacío"},
            {"error_archivo_cantidad_vacio", "La cantidad no puede estar vacía"},
            {"error_archivo_fecha_vacio", "La fecha no puede estar vacía"},
            {"error_archivo_sucursal_vacio", "La sucursal no puede estar vacía"},
            {"error_archivo_precioUnitario_vacio", "El precio del unitario no puede estar vacío"},
            {"error_archivo_factor_vacio", "El factor no puede estar vacío"},
            {"error_archivo_cantidad_formato", "El formato del campo cantidad no es el numérico"},
            {"error_archivo_fecha_formato", "El formato del campo fecha no es correcto"},
            {"error_archivo_precioUnitario_formato", "El formato del campo precio unitario no es numérico"},
            {"error_archivo_factor_formato", "El formato del campo factor no es numérico"}
        };
    }

}
