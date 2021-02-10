package eduit.learning.demo.primeraaplicacionweb;

public class Empleado {
    private String nombre;
    private int empleadoID;
    
    public Empleado(){
        
    }
    
    public Empleado(String nombre, int id){
        this.nombre = nombre;
        this.empleadoID = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getId(){
        return this.empleadoID;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setId(int id){
        this.empleadoID = id;
    }
}
