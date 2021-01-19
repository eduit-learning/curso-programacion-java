package eduit.earning.modulo1_laboratorio;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Pangramas {

    public static void main(String[] args) {
        PrintStream console = System.out;
        Scanner scanner = new Scanner(System.in);

        do {
            console.println("Bienvenido al Laboratorio 1");
            console.println("Este laboratorio identifica si un texto es un Pangrama, si el texto contiene palabras pentavocálicas y si el texto contiene palabras que son palíndromo");

            console.println("Por favor ingrese el texto a evaluar");
            String text = scanner.nextLine();

            if (text != null && text.trim().length() != 0) {
                boolean isPangrama = ValidatePangrama(text);
                console.println(isPangrama == true ? "El texto proporcinado es un pangrama" : "El texto proporcionado no es un pangrama");

                var pentavocalicWords = ValidatePentavocalic(text);

                if (pentavocalicWords != null && pentavocalicWords.size() > 0) {
                    console.println("Se encontraron las siguientes palabras pentavocálicas");
                    for (var word : pentavocalicWords) {
                        console.println(word);
                    }
                } else {
                    console.println("No se encontraron palabras pentavocálicas");
                }

                var palindromeWords = ValidatePalindrome(text);

                if (palindromeWords != null && palindromeWords.size() > 0) {
                    console.println("Se encontraron las siguientes palabras palíndromo");
                    for (var word : palindromeWords) {
                        console.println(word);
                    }
                } else {
                    console.println("No se encontraron palabras palíndromo");
                }
            } else {
                console.println("El texto proporcionado no es un pangrama, no contiene palabras pentavocálicas y no contiene parablas palíndromo");
            }

            console.println("¿Desea ejecutar de nuevo el programa (S/N)? ");
        } while (scanner.nextLine().toLowerCase().equals("s"));

        console.println("¡Hasta Luego!");
    }

    private static boolean ValidatePangrama(String text) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z"};

        boolean hasError = false;
        text = text.toLowerCase();

        for (var character : alphabet) {
            if (text.contains(character) == false) {
                hasError = true;
                break;
            }
        }

        return !hasError;
    }

    private static ArrayList<String> ValidatePentavocalic(String text) {
        ArrayList<String> words = new ArrayList<String>();
        text = text.toLowerCase();

        for (var word : text.trim().split(" ")) {
            if (word.contains("a") == true && word.contains("e") == true && word.contains("i") == true
                    && word.contains("o") == true && word.contains("u") == true) {
                words.add(word);
            }
        }

        return words;
    }

    private static ArrayList<String> ValidatePalindrome(String text) {
        ArrayList<String> words = new ArrayList<String>();

        for (var word : text.trim().split(" ")) {
            int start = 0;
            int end = word.length() - 1;
            boolean isPalindrome = true;

            while (start < end && isPalindrome == true) {
                if (word.charAt(start) == word.charAt(end)) {
                    start++;
                    end--;
                } else {
                    isPalindrome = false;
                }
            }

            if (isPalindrome == true) {
                words.add(word);
            }
        }
        return words;
    }
}
