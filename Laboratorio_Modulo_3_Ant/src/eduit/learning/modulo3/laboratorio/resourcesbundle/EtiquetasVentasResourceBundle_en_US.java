package eduit.learning.modulo3.laboratorio.resourcesbundle;

import java.util.ListResourceBundle;

public class EtiquetasVentasResourceBundle_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"ventas_view_tiutlo", "Sales"},
            {"ventas_view_mensajes_titulo", "File processing detail"},
            {"ventas_view_menu_Archivo", "File"},
            {"ventas_view_menu_Archivo_Abrir", "Open file"},
            {"ventas_view_menu_Archivo_Editar", "Edit file"},
            {"ventas_view_menu_Archivo_Guardar", "Save file"},
            {"ventas_view_menu_Archivo_Descartar", "Discard file changes"},
            {"ventas_view_menu_BaseDatos", "Data base"},
            {"ventas_view_menu_BaseDatos_Guadar", "Export file to database"},
            {"ventas_view_menu_BaseDatos_Actualizar", "Update from database"},
            {"ventas_view_menu_idioma", "Lenguage"},
            {"ventas_view_menu_idioma_espaniol", "Spanish"},
            {"ventas_view_menu_idioma_ingles", "English"},
            {"ventas_view_tabla_columna_ventaID", "Sale ID"},
            {"ventas_view_tabla_columna_codigoProducto", "Code"},
            {"ventas_view_tabla_columna_nombreProducto", "Name"},
            {"ventas_view_tabla_columna_cantidad", "Quantity"},
            {"ventas_view_tabla_columna_fecha", "Date"},
            {"ventas_view_tabla_columna_sucursal", "Branch"},
            {"ventas_view_tabla_columna_precioUnitario", "Unit price"},
            {"ventas_view_tabla_columna_factor", "Factor"},
            {"ventas_view_tabla_columna_importe", "Amount"},
            {"ventas_view_tabla_columna_importeUSD", "Amount USD"},
            {"ventas_view_descartararchivo_titulo", "Discard file changes"},
            {"ventas_view_descartararchivo_mensaje", "All changes will be discarted. Are you sure?"},
            {"ventas_view_guardararchivo_titulo", "Save file"},
            {"ventas_view_guardararchivo_mensaje", "File saved successfully"}
        };
    }
}
