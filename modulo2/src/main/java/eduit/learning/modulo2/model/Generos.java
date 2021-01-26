/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.learning.modulo2.model;

/**
 *
 * @author abraham
 */
public enum Generos {
    Hombre(1),
    Mujer(2),
    Otro(3);

    private int numVal;

    Generos(int numVal) {
        this.numVal = numVal;
    }
    
    public int getNumVal(){
        return this.numVal;
    }
}
