package eduit.learning.modulo3.laboratorio.repository;

import eduit.learning.modulo3.laboratorio.modelo.Venta;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VentasRepository {

    private SQLContext context;
    private String nombreTabla;

    public VentasRepository(SQLContext context) {
        this.context = context;
        this.nombreTabla = "VentaAbraham";
    }

    public int insertEntity(Venta entity) throws SQLException {
        String queryValues = "'" + entity.getCodigoProducto() + "','" + entity.getNombreProducto() + "'," + entity.getCantidad() + ",'" + new SimpleDateFormat("yyyyMMdd").format(entity.getFecha()) + "','" + entity.getSucursal() + "',";
        queryValues += entity.getPrecioUnitario() + "," + entity.getFactor() + ",'" + entity.getUri() + "','" + entity.getRegion() + "','" + entity.getIdioma() + "',";
        queryValues += entity.getImporte() + "," + entity.getImporteUSD();

        String query = "INSERT INTO " + this.nombreTabla + "(codigoProducto,nombreProducto,cantidad,fecha,sucursal,precioUnitario,factor,uri,region,idioma,importe,importeUSD) values(" + queryValues + ");";

        int executionResult = this.context.getStatement().executeUpdate(query);

        return executionResult;
    }

    public List<Venta> getEntity(String filter) throws SQLException {
        String query = "SELECT * FROM " + this.nombreTabla + (filter != null && filter.trim().length() > 0 ? (" WHERE " + filter) : "");

        ResultSet rs = this.context.getStatement().executeQuery(query);

        List<Venta> empleados = new ArrayList<Venta>();

        while (rs.next() == true) {
            Venta vnt = new Venta();
            vnt.setVentaID(rs.getInt("ventaID"));
            vnt.setCodigoProducto(rs.getString("codigoProducto"));
            vnt.setNombreProducto(rs.getString("nombreProducto"));
            vnt.setCantidad(rs.getDouble("cantidad"));
            vnt.setFecha(rs.getDate("fecha"));
            vnt.setSucursal(rs.getString("sucursal"));
            vnt.setPrecioUnitario(rs.getDouble("precioUnitario"));
            vnt.setFactor(rs.getDouble("factor"));
            vnt.setUri(rs.getString("uri"));
            vnt.setRegion(rs.getString("region"));
            vnt.setIdioma(rs.getString("idioma"));
            vnt.setImporte(rs.getDouble("importe"));
            vnt.setImporteUSD(rs.getDouble("importeUSD"));

            empleados.add(vnt);
        }

        rs.close();
        return empleados;
    }
}
