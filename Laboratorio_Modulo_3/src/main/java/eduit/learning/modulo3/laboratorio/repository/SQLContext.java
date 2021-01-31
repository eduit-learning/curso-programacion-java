package eduit.learning.modulo3.laboratorio.repository;

import eduit.learning.modulo3.laboratorio.vista.VentasView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLContext {

    private Connection sqlConnection;
    private Statement statement;

    private static SQLContext context;

    private SQLContext() throws IOException, SQLException {
        Properties prop = new Properties();
        prop.load(VentasView.class.getClassLoader().getResourceAsStream("application.properties"));
        this.sqlConnection = DriverManager.getConnection(prop.getProperty("modulo2-formularioConnectionString"), prop);
        this.statement = sqlConnection.createStatement();
    }

    public static SQLContext getSQLContext() throws IOException, SQLException {
        if (context == null) {
            context = new SQLContext();
        }

        return context;
    }

    public Connection getConnection() {
        return this.sqlConnection;
    }

    public Statement getStatement() {
        return this.statement;
    }

    public void Dispose() throws SQLException {
        this.context.sqlConnection.close();
        this.context.statement.close();
    }
}
