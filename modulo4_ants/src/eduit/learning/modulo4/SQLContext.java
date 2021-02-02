package eduit.learning.modulo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLContext {

    private Connection sqlConnection;
    private Statement statement;
    public static String mensaje;

    private static SQLContext context;

    private SQLContext() throws SQLException {
        this.sqlConnection = DriverManager.getConnection("jdbc:sqlserver://eduit.database.windows.net:1433;database=Modulo_2-Formulario;user=eduit;password=Admin123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        this.statement = sqlConnection.createStatement();
    }

    public static Statement getStatement(String mensajeParam) throws SQLException {
        if (context == null) {
            context = new SQLContext();
            mensaje = mensajeParam;
        }

        return context.statement;
    }
    
    public static void Dispose() throws SQLException{
        context.sqlConnection.close();
        context.statement.close();
    }
}
