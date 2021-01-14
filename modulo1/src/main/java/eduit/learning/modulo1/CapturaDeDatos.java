package eduit.learning.modulo1;

import eduit.learning.utils.Holder;
import eduit.learning.utils.Temp;
import java.util.*;

public class CapturaDeDatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese un número entero");
        String textInput = scanner.nextLine();

        Holder<Integer> result = new Holder<Integer>(0);

        if (getInteger(textInput, result) == true) {
            System.out.println("El valor capturado es: " + result.value);
        } else {
            System.out.println("El valor capturado no es un entero");
        }

        int x = 5;
        getInt(x);
        System.out.println(x);

        Temp tmp = new Temp();
        tmp.x = 5;
        getInt(tmp);
        System.out.println(tmp.x);

        //apuntador(X0AC345 alias tmp) - X0AC345-objeto(tmp)
    }

    public static void getInt(Temp apun) {
        //apuntador(X0AC345) alias apun
        System.out.println(apun.x);
        apun.x++;
        System.out.println(apun.x);
    }

    public static void getInt(int x) {
        System.out.println(x);
        x++;
        System.out.println(x);
    }

    public static int getInteger(String textInput) {
        try {
            return Integer.parseInt(textInput);
        } catch (NumberFormatException ex) {
            System.out.println("El dato capturado no es un entero. Dato: " + textInput);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar la conveersión. Error: " + ex.getMessage());
        } finally {
            System.out.println("El bloque de código dentro de finally siempre se ejecuta.");
        }

        return 0;
    }

    public static boolean getInteger(String textInput, Holder<Integer> output) {
        try {
            output.value = Integer.parseInt(textInput);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean getFloat(String textInput, Holder<Float> output) {
        try {
            Float.parseFloat(textInput);

        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static boolean getDouble(String textInput, Holder<Double> output) {
        try {
            Double.parseDouble(textInput);

        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static boolean getBoolean(String textInput, Holder<Boolean> output) {
        try {
            Boolean.parseBoolean(textInput);

        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
