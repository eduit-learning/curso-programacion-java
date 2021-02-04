package pattern.behavioral.templatemethod;

/**
 * Un objeto 2D.
 */
public abstract class Animatable {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Este es el "Template Method". Puede ser final para que no se herede.
     */
    public void updateFrame() {
        animate();
        paint();
        erase();
    }

    public final void updateFrame2() {
        animate();
        this.status("Animando");
        
        paint();
        this.status("Pintando");
        
        erase();
        this.status("Borrando");
    }

    public abstract void animate();

    public abstract void paint();

    public abstract void erase();

    public final void status(String status) {
        System.out.println("El estatus es: " + status);
    }
}
