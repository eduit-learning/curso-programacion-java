package pattern.behavioral.chainofresponsibility;

import java.util.Arrays;
import java.util.List;

public class AuthenticationManejador extends AbstractManejador {

    private final List<String> validTokens = Arrays.asList("abc", "123");

    @Override
    public void manejarPeticion(Request request) {
        String accessToken = request.getHeaders().get("Access-Token");
        
        if (!validTokens.contains(accessToken)) {
            request.status += "El token proporcionado no se encontró\n\r";
            request.results.add(true);
        } else {
            request.status += "Token válido\n\r";
            request.status += "Request authenticated\n\r";
            request.results.add(false);
        }
    }
}
