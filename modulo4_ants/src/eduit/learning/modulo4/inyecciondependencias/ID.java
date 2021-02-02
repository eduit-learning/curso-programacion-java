package eduit.learning.modulo4.inyecciondependencias;

import eduit.learning.modulo4.SQLContext;
import java.sql.SQLException;

public class ID {

    public static void main(String[] args) throws SQLException {

        ComportamientoCaminarBipedo ccb = new ComportamientoCaminarBipedo();
        ComportamientoCaminarRueditas ccr = new ComportamientoCaminarRueditas();

        Robot robocop = new Robot(SQLContext.getStatement(""));
        robocop.nombre = "Robocop";
        robocop.caminar = ccb;
        System.out.println("Hola soy " + robocop.nombre);
        robocop.Caminar();

        Robot terminator = new Robot(SQLContext.getStatement(""));
        terminator.nombre = "Terminator";
        terminator.caminar = ccb;
        System.out.println("Hola soy " + terminator.nombre);
        terminator.Caminar();
        System.out.println("Terminator de pone a pelear y resulta herido");
        terminator.caminar = ccr;
        terminator.Caminar();

        Robot t1000 = new Robot(SQLContext.getStatement(""));
        t1000.nombre = "T1000";
        t1000.caminar = ccb;
        System.out.println("Hola soy " + t1000.nombre);
        t1000.Caminar();

        Robot citripio = new Robot(SQLContext.getStatement(""));
        citripio.nombre = "Citripio";
        citripio.caminar = ccb;
        System.out.println("Hola soy " + citripio.nombre);
        citripio.Caminar();

        SQLContext.Dispose();
    }

}
