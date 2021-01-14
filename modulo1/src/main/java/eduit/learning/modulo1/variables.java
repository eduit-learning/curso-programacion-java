package eduit.learning.modulo1;

public class variables {

    public static void main(String[] args) {
        short a = 0;//Número entero de 16 bits
        int b = 0;//Número entero de 32 bits
        long c = 0;//Número entero con signo de 64 bits;
        
        float e = 123.0980f;//Parte entera hasta 32 bits y parte decimal hasta 32 bits
        double d = 123.0;//Parte entera hasta 64bits y parte decimal hasta 64 bits
        
        String x = "Hola mundo de nuevo";
        
        char y = 'X';
        
        var z = "Soy cadena";
        
        z = "Modificación de cadena";
        z = z+" concatenación";
        
        var w = 0;
        
        boolean f = false;
        
        System.out.println(z);
        
        Tamanios tam = Tamanios.Grande;
        
        System.out.println(tam);
    }
    
    public enum Tamanios{
        Pequenio,
        Mediano,
        Grande
    }
}