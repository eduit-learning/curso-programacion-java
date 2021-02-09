/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.behavioral.chainofresponsibility;

/**
 *
 * @author abraham
 */
public class TercerEslabon extends AbstractManejador {

    @Override
    public void manejarPeticion(Request request) {
        if (request.results.get(0) == true) {
            request.status += "La tarea 1 fue saltada o no se ejecutó correctamente, no es posible ejecutar esta tarea\n\r";
        }else{
            request.status += "Fin de la cadena";
        }
    }
}
