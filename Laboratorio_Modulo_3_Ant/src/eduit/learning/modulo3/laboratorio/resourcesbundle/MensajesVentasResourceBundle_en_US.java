package eduit.learning.modulo3.laboratorio.resourcesbundle;

import java.util.ListResourceBundle;

public class MensajesVentasResourceBundle_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"error_archivo_linea_blanco", "Unable to process blank lines"},
            {"error_archivo_camposIncompletos", "No enough fields to process the line"},
            {"error_archivo_codigoProducto_vacio", "The product code cannot be null or empty"},
            {"error_archivo_nombreProducto_vacio", "The product name cannot be null or empty"},
            {"error_archivo_cantidad_vacio", "The quantity cannot be null or empty"},
            {"error_archivo_fecha_vacio", "The date cannot be null or empty"},
            {"error_archivo_sucursal_vacio", "The branch cannot be null or empty"},
            {"error_archivo_precioUnitario_vacio", "The unit price cannot be null or empty"},
            {"error_archivo_factor_vacio", "The conversion factor cannot be null or empty"},
            {"error_archivo_cantidad_formato", "The quantity field is not a number"},
            {"error_archivo_fecha_formato", "The format of the date field is not correct"},
            {"error_archivo_precioUnitario_formato", "The unit price field is not a number"},
            {"error_archivo_factor_formato", "The factor field is not a number"}
        };
    }

}
