/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.learning.modulo4;

/**
 *
 * @author abraham
 */
public class Empleado {

    private int empleadoID;
    private String nombre;
    private String apellidos;
    private String email;
    private String departamento;
    private String observaciones;
    private byte edad;
    private Generos genero;

    public Empleado() {

    }
    
    public int getEmpleadoID(){
        return this.empleadoID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public byte getEdad() {
        return this.edad;
    }

    public Generos getGenero() {
        return this.genero;
    }
    
    public void setEmpleadoID(int empleadoID){
        this.empleadoID = empleadoID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }
}
