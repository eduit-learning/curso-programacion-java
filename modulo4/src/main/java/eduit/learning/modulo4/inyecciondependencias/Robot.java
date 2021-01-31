package eduit.learning.modulo4.inyecciondependencias;

import java.sql.Statement;

public class Robot {
    public String nombre;
    public ComportamientoCaminar caminar;
    private Statement context;
    
    public Robot(Statement context){
        this.context = context;
    }
    
    public void Caminar(){
        this.caminar.Caminar();
    }
    
    public void Operar(){
        
    }
    
    public void Descansar(){
        
    }
}