package pattern.behavioral.chainofresponsibility;

public class AuthorizationManejador extends AbstractManejador {

    @Override
    public void manejarPeticion(Request request) {
        String url = request.getUrl();
        if (url.endsWith("/forbidden")) {
            throw new RuntimeException("Access Forbidden");
        }

        System.out.println("Request authorized");
    }
}
