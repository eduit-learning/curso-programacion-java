package pattern.behavioral.chainofresponsibility;

/**
 * Clase base de todos los interceptores, implementa la mayoría de los métodos, excepto handleRequest.
 * El método intercept ejecuta la cadena.
 */
public abstract class AbstractManejador implements Manejador {
    private Manejador next;

    public void intercept(Request request) {
        manejarPeticion(request);
        if (getNext() != null) {
            getNext().intercept(request);
        }
    }

    public Manejador getNext() {
        return next;
    }

    public void setNext(Manejador interceptor) {
        next = interceptor;
    }
}
