package eduit.learning.modulo2.repository;

import eduit.earning.modulo2.Formulario;
import eduit.learning.modulo2.model.Departamento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartamentoRepository {

    private Properties properties;
    private Connection sqlConnection;
    private Statement statement;
    private String nombreTabla;

    public DepartamentoRepository() throws IOException {
        this.properties = new Properties();
        this.properties.load(Formulario.class.getClassLoader().getResourceAsStream("application.properties"));
        this.nombreTabla = "DepartamentoAbraham";
    }

    public int insertEntity(Departamento entity) throws SQLException {
        String queryValues = "'" + entity.getNombre() + "'," + "'" + entity.getDescripcion() + "'";

        String query = "INSERT INTO " + this.nombreTabla + "(nombre, descripcion) values(" + queryValues + ");";

        this.sqlConnection = DriverManager.getConnection(properties.getProperty("modulo2-formularioConnectionString"), properties);
        this.statement = sqlConnection.createStatement();
        int executionResult = statement.executeUpdate(query);

        this.sqlConnection.close();
        this.statement.close();

        return executionResult;
    }

    public List<Departamento> getEntity(String filter) throws SQLException {
        String query = "SELECT * FROM " + this.nombreTabla + (filter != null && filter.trim().length() > 0 ? (" WHERE " + filter) : "");

        this.sqlConnection = DriverManager.getConnection(properties.getProperty("modulo2-formularioConnectionString"), properties);
        this.statement = sqlConnection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        List<Departamento> departamentos = new ArrayList<Departamento>();

        while (rs.next() == true) {
            Departamento dep = new Departamento();
            dep.setDepartamentoID(rs.getInt("departamentoID"));
            dep.setNombre(rs.getString("nombre"));
            dep.setDescripcion(rs.getString("descripcion"));

            departamentos.add(dep);
        }

        rs.close();
        this.sqlConnection.close();
        this.statement.close();

        return departamentos;
    }
}
