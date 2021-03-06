package eduit.learning.modulo4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductoRepository {
    
    private String nombreTabla;

    public ProductoRepository() throws SQLException {
        this.nombreTabla = "EmpleadoAbraham";
    }

    public int insertEntity(Empleado entity) throws SQLException {
        String queryValues = "'" + entity.getNombre() + "'," + "'" + entity.getApellidos() + "'," + "'" + entity.getEmail() + "'," + "'" + entity.getDepartamento() + "',";
        queryValues += "'" + entity.getObservaciones() + "'," + entity.getEdad() + "," + entity.getGenero().getNumVal();

        String query = "INSERT INTO " + this.nombreTabla + "(nombre, apellidos, email, departamento, observaciones, edad, genero) values(" + queryValues + ");";

        int executionResult = SQLContext.getStatement("").executeUpdate(query);

        return executionResult;
    }

    public int updateEntity(Empleado entity) throws SQLException {
        String queryValues = "nombre = '" + entity.getNombre() + "', apellidos = '" + entity.getApellidos() + "', email = '" + entity.getEmail() + "', departamento = '";
        queryValues += entity.getDepartamento() + "', observaciones = '" + entity.getObservaciones() + "', edad = " + entity.getEdad() + ",genero = " + entity.getGenero().getNumVal();

        String query = "UPDATE " + this.nombreTabla + " SET " + queryValues + " WHERE empleadoID = " + entity.getEmpleadoID();

        int executionResult = SQLContext.getStatement("").executeUpdate(query);

        return executionResult;
    }

    public List<Empleado> getEntity(String filter) throws SQLException {
        String query = "SELECT * FROM " + this.nombreTabla + (filter != null && filter.trim().length() > 0 ? (" WHERE " + filter) : "");

        ResultSet rs = SQLContext.getStatement("").executeQuery(query);

        List<Empleado> empleados = new ArrayList<Empleado>();

        while (rs.next() == true) {
            Empleado emp = new Empleado();
            emp.setNombre(rs.getString("nombre"));
            emp.setApellidos(rs.getString("apellidos"));
            emp.setDepartamento(rs.getString("departamento"));
            emp.setEmail(rs.getString("email"));
            emp.setObservaciones(rs.getString("observaciones"));
            emp.setEdad(rs.getByte("edad"));
            emp.setGenero(rs.getInt("genero") == 1 ? Generos.Hombre : rs.getInt("genero") == 2 ? Generos.Mujer : Generos.Otro);
            emp.setEmpleadoID(rs.getInt("empleadoID"));

            empleados.add(emp);
        }

        rs.close();

        return empleados;
    }
    
    public int eliminarEmpleado(Empleado emp){
        return 1;
    }
}
