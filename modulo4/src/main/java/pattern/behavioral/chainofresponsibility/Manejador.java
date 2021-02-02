package pattern.behavioral.chainofresponsibility;

public interface Manejador {

    void manejarPeticion(Request request);

    void intercept(Request request);

    Manejador getNext();

    void setNext(Manejador interceptor);
}
