package eduit.learning.modulo2.model;

public class Departamento {

    private int departamentoID;
    private String nombre;
    private String descripcion;

    public Departamento() {

    }

    public int getDepartamentoID() {
        return this.departamentoID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDepartamentoID(int departamentoID) {
        this.departamentoID = departamentoID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
