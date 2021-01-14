package eduit.learning.modulo1;

import eduit.learning.utils.CalculadoraEstandard;
import eduit.learning.utils.Calculadoracientifica;
import eduit.learning.utils.Operaciones;

public class Cadenas {

    public static void main(String[] args) {
        String mensaje = "Hola VW";

        //[H][o][l][a][ ][V][W]
        System.out.println(mensaje.charAt(0));

        for (int i = 0; i < mensaje.length(); i++) {
            System.out.println(mensaje.charAt(i));
        }

        String nuevoMensaje = mensaje + "Lo que quiero concatenar";
        System.out.println(nuevoMensaje);

        nuevoMensaje = nuevoMensaje.concat("Una concatenación más");
        System.out.println(nuevoMensaje);

        System.out.println(nuevoMensaje.contains("Una"));
        System.out.println(nuevoMensaje.contains("más"));
        System.out.println(nuevoMensaje.contains("una"));
        System.out.println(nuevoMensaje.toLowerCase().contains("una"));
        System.out.println(nuevoMensaje.toLowerCase().replace("á", "a").contains("mas"));

        System.out.println(nuevoMensaje.endsWith("concatenación"));
        System.out.println(nuevoMensaje.endsWith("más"));

        System.out.println(nuevoMensaje.startsWith("VW"));
        System.out.println(nuevoMensaje.startsWith("Hola"));

        System.out.println(nuevoMensaje.substring(0, 3));
        System.out.println(nuevoMensaje.substring(0, 1));
        System.out.println(nuevoMensaje.substring(0, 0));

        System.out.println(nuevoMensaje.trim());
        System.out.println(nuevoMensaje.replace(" ", ""));
        System.out.println(nuevoMensaje.replace("\n\r", ""));

        var cadenas = nuevoMensaje.split(" ");
        //Hola VWLo que quiero concatenarUna concatenación más
        //Hola
        //VWLo
        //que
        //quiero
        //concatenarUna
        //concatenación
        //más
        for (String cadena : cadenas) {
            System.out.println(cadena);
        }

        CalculadoraEstandard calcEst = new CalculadoraEstandard();
        Calculadoracientifica calcCien = new Calculadoracientifica();

        System.out.println(calcEst.suma(2, 2));
        System.out.println(calcCien.suma(2, 2));
        System.out.println(calcEst.porcentaje(24, 3));
        
        Operaciones ops1 = calcEst;
        Operaciones ops2 = calcCien;
        
        System.out.println(ops1.suma(2, 2));
        System.out.println(((CalculadoraEstandard)ops1).porcentaje(24, 3));
        System.out.println(ops2.suma(2, 2));
        
        CalculadoraEstandard calcEst2 = (CalculadoraEstandard)ops1;
        Calculadoracientifica calcCien2 = (Calculadoracientifica)ops2;
        
        System.out.println(calcEst2.suma(2, 2));
        System.out.println(calcCien2.suma(2, 2));
    }
}
