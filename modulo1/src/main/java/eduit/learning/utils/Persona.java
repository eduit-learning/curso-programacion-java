/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduit.learning.utils;

import java.util.Date;

/**
 *
 * @author abraham
 */
public class Persona {

    private String nombre;
    private String apellidos;
    protected String apodo;
    private Date fechaNacimiento;

    public Persona() {
        this.nombre = "bebé";
        this.apellidos = "sin asignación";
        this.fechaNacimiento = new Date();
        this.apodo = "bebé";
    }
    
    public Persona(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = new Date();
        this.apodo = "bebé";
    }
    
    public Persona (String nombre, String apellidos, String apodo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = new Date();
        this.apodo = apodo;
    }
    
    public Persona (String nombre, String apellidos, Date fechaNacimiento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.apodo = "bebé";
    }
    
    public Persona (String nombre, String apellidos, Date fechaNacimiento, String apodo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.apodo = apodo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getApodo() {
        return this.apodo;
    }
    
    public void trabajar()
    {
        System.out.println("Aún no sé cómo trabajar");
    }
    
    public void descansar(){
        System.out.println("Voy a dormir");
    }
}