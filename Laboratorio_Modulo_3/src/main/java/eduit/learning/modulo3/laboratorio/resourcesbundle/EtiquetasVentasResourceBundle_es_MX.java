package eduit.learning.modulo3.laboratorio.resourcesbundle;

import java.util.ListResourceBundle;

public class EtiquetasVentasResourceBundle_es_MX extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"ventas_view_tiutlo", "Ventas"},
            {"ventas_view_mensajes_titulo", "Resumen procesamiento de archivo"},
            {"ventas_view_menu_Archivo", "Archivo"},
            {"ventas_view_menu_Archivo_Abrir", "Abrir archivo"},
            {"ventas_view_menu_Archivo_Editar", "Editar archivo"},
            {"ventas_view_menu_Archivo_Guardar", "Guardar archivo"},
            {"ventas_view_menu_Archivo_Descartar", "Descartar archivo"},
            {"ventas_view_menu_BaseDatos", "Base de datos"},
            {"ventas_view_menu_BaseDatos_Guadar", "Exportar archivo a base de datos"},
            {"ventas_view_menu_BaseDatos_Actualizar", "Actualizar registros desde base de datos"},
            {"ventas_view_menu_idioma", "Lenguaje"},
            {"ventas_view_menu_idioma_espaniol", "Español"},
            {"ventas_view_menu_idioma_ingles", "Inglés"},
            {"ventas_view_tabla_columna_ventaID", "ID Venta"},
            {"ventas_view_tabla_columna_codigoProducto", "Código"},
            {"ventas_view_tabla_columna_nombreProducto", "Nombre"},
            {"ventas_view_tabla_columna_cantidad", "Cantidad"},
            {"ventas_view_tabla_columna_fecha", "Fecha"},
            {"ventas_view_tabla_columna_sucursal", "Sucursal"},
            {"ventas_view_tabla_columna_precioUnitario", "Precio unitario"},
            {"ventas_view_tabla_columna_factor", "Factor"},
            {"ventas_view_tabla_columna_importe", "Importe"},
            {"ventas_view_tabla_columna_importeUSD", "Importe USD"},
            {"ventas_view_descartararchivo_titulo", "Descartar archivo"},
            {"ventas_view_descartararchivo_mensaje", "¿Está seguro que desea descartar el archivo?"},
            {"ventas_view_guardararchivo_titulo", "Guardar archivo"},
            {"ventas_view_guardararchivo_mensaje", "Guardardado exitoso"}
        };
    }
}
