package pattern.behavioral.observer;

import java.awt.Color;

/**
 * Clase cliente para ejemplificar el uso del patrón.
 */
public class Button implements Component {

    private final EventManager eventManager = new EventManager();
    private final EventManager propertyChanged = new EventManager();

    private String text;

    public void click() {
        eventManager.notify(this);
    }

    public void addListenerPropertyChanged(EventListener propertyName) {
        propertyChanged.subscribe(propertyName);
    }

    public void addListener(EventListener saveFile) {
        eventManager.subscribe(saveFile);
    }

    public void removeListener(EventListener remove) {
        eventManager.unsubscribe(remove);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        propertyChanged.notify(this);
    }
    
    public void setColor(Color color){
        //Asigno el nuevo color
        propertyChanged.notify(this);
    }
}
//1.- La version compleha de cadeja de responsabilidades
//2.- Ejemplo de como funciona Observer para notificar cuando ha cambiado una propiedad