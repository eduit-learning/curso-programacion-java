package eduit.learning.demo.ejemplopropertychange;

public class PropertyChangeModel {
    
    private EventManager eventManager;
    
    private String cronometro;
    private String hora;
    private String cronometroSegundos;
    
    public PropertyChangeModel(EventManager eventManager) {
        this.eventManager = eventManager;
    }
    
    public String getCronometro() {
        return this.cronometro;
    }
    
    public String getHora() {
        return this.hora;
    }
    
    public String getCronometroSegundos() {
        return this.cronometroSegundos;
    }
    
    public void setCronometro(String cronometro) {
        this.cronometro = cronometro;
        this.notifyOnPropertyChange("Cronometro");
    }
    
    public void setHora(String hora) {
        this.hora = hora;
        this.notifyOnPropertyChange("Hora");
    }
    
    public void setCronometroSegundos(String cronometroSegundos) {
        this.cronometroSegundos = cronometroSegundos;
        this.notifyOnPropertyChange("CronometroSegundos");
    }
    
    private void notifyOnPropertyChange(String propertyName) {
        if (this.eventManager != null) {
            this.eventManager.notifyPropertyChanged(propertyName);
        }
    }
}
