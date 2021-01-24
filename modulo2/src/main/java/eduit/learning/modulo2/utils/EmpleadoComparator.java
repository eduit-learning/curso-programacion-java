/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.learning.modulo2.utils;

import eduit.learning.modulo2.model.Empleado;
import java.util.Comparator;

/**
 *
 * @author abraham
 */
public class EmpleadoComparator implements Comparator<Empleado>{

    @Override
    public int compare(Empleado o1, Empleado o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
    
}
