package eduit.learning.calculadora;

import eduit.learning.utils.Holder;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicación de calculadora");
        String result = "";

        do {
            System.out.println("Por favor seleccione una opción");
            System.out.println("1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Multiplicación");
            System.out.println("4.- División");
            System.out.println("5.- Salir");
            result = scanner.nextLine();

            boolean requestNumbers = true;
            Holder<Double> num1 = new Holder<Double>(0.0);
            Holder<Double> num2 = new Holder<Double>(0.0);

            while (requestNumbers == true) {
                System.out.println("Por favor capture el número 1");

                if (getDouble(scanner.nextLine(), num1) == false) {
                    System.out.println("El valor porporcionado no es numérico. Deseas intentarlo de nuevo (S/N).");
                    if (scanner.nextLine().toLowerCase().equals("s") == false) {
                        requestNumbers = false;
                    }
                }
            }

            if (requestNumbers == true) {
                while (requestNumbers == true) {
                    System.out.println("Por favor capture el número 2");

                    if (getDouble(scanner.nextLine(), num2) == false) {
                        System.out.println("El valor porporcionado no es numérico. Deseas intentarlo de nuevo (Y/N).");
                        if (scanner.nextLine().toLowerCase().equals("s") == false) {
                            requestNumbers = false;
                        }
                    }
                }
            }

            if (requestNumbers == true) {
                switch (result) {
                    case "1":
                        System.out.println("El resultado de " + num1.value + " + " + num2.value + " es: " + (num1.value + num2.value));
                        break;
                    case "2":
                        System.out.println("El resultado de " + num1.value + " - " + num2.value + " es: " + (num1.value + num2.value));
                        break;
                    case "3":
                        System.out.println("El resultado de " + num1.value + " * " + num2.value + " es: " + (num1.value + num2.value));
                        break;
                    case "4":
                        System.out.println("El resultado de " + num1.value + " / " + num2.value + " es: " + (num1.value + num2.value));
                        break;
                    case "5":
                        System.out.println("Nos vemos!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

            System.out.println("Desea ejecutar de nuevo. ¿S/N?");
            result = scanner.nextLine();

        } while (result.toLowerCase().equals("s") == true);
        //} while (result.toLowerCase() == "s");
    }

    public static boolean getDouble(String textInput, Holder<Double> output) {
        try {
            Double.parseDouble(textInput);

        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
