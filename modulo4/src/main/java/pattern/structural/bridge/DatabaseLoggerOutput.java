package pattern.structural.bridge;

public class DatabaseLoggerOutput implements LoggerOutput {

    @Override
    public void output(String message) {
        System.out.println("Se imprime en base de datos el mensaje: " + message);
    }
}