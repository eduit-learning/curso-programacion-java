package eduit.learning.modulo1;

import eduit.learning.utils.*;
import java.util.Date;

public class clases {

    public static void main(String[] args) {
        Persona p1 = new Persona("Abraham", "Chávez Castillo", new Date(), "Eibi");
        
        Persona p2 = new Persona("Juan", "Pérez Penas", new Date(), "Juanito");
        
        System.out.println("Nombre persona 1: " + p1.getNombre() + " Nombre persona 2: " + p2.getNombre());
        System.out.println(String.format("Nombre persona 1: %s, Nombre persona 2: %s", p1.getNombre(),
                p2.getNombre()));
        //System.out.println(s"Nombre persona 1: $p1.getNombre(), Nombre persona 2: $p2.getNombre()");
        
        Empleado e1 = new Empleado("Abraham", "Chávez Castillo", new Date(),
        "123456", "achavez@grupoeduit.com", "TI");
        e1.trabajar();
        p1.trabajar();
        p2.trabajar();
        System.out.println(e1.getIdEmpleado());
        
        Persona p3 = new Empleado("Abraham", "Chávez Castillo", new Date(),
        "123457", "achavez@grupoeduit.com", "TI");
        p3.trabajar();
        p3.descansar();
        System.out.println(((Empleado)p3).getIdEmpleado());
    }
}