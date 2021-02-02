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
        System.out.println("Este es el tercer eslabón de la cadena de responsabilidades");
    }
    
}
