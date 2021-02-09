package pattern.behavioral.chainofresponsibility;

import java.util.Map;

public class ChainOfResponsibility {

    public static void main(String[] args) {

        AuthenticationManejador authenticationInterceptor = new AuthenticationManejador();
        AuthorizationManejador authorizationInterceptor = new AuthorizationManejador();
        TercerEslabon te = new TercerEslabon();

        Request request = new Request();
        request.setHeaders(Map.of("Access-Token", "123"));
        request.setUrl("http://myweb.com/forbidde");

        authenticationInterceptor.setNext(authorizationInterceptor);
        authorizationInterceptor.setNext(te);
        authenticationInterceptor.intercept(request);

        System.out.println(request.status);
    }
}
