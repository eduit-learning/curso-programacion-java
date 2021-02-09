package pattern.behavioral.chainofresponsibility;

public class AuthorizationManejador extends AbstractManejador {

    @Override
    public void manejarPeticion(Request request) {
        if (request.previousWasSkiped == true) {
            request.status += "La tarea previa fue saltada o no se ejecutó correctamente, no es posible ejecutar esta tarea\n\r";
            request.previousWasSkiped = true;
        } else {
            String url = request.getUrl();
            
            if (url.endsWith("/forbidden")) {
                request.status += "Acceso denegado\n\r";
                request.previousWasSkiped = true;
            } else {
                //request.status += "Acceso autorizado\n\r";
                request.status = request.status + "Acceso autorizado\n\r";
                request.previousWasSkiped = false;
            }
        }
    }
}
