package eduit.learning.utils;

import java.util.Date;

public class Empleado extends Persona {
    private String idEmpleado;
    private String correoElectronico;
    private String departamento;
    
    public Empleado(String nombre, String apellidos, Date fechaNacimiento,
            String idEmpleado, String correoElectronico, String departamento){
        super(nombre, apellidos, fechaNacimiento);
        
        this.idEmpleado = idEmpleado;
        this.correoElectronico = correoElectronico;
        this.departamento = departamento;
    }
    
    public String getIdEmpleado(){
        return this.idEmpleado;
    }
    
    @Override
    public void trabajar(){
        System.out.println("Trabajo muy duro como un esclavo");
    }
    
    public void descansar(){
        System.out.println("Voy a comer");
    }
}