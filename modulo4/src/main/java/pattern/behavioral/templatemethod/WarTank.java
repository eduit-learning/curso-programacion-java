package pattern.behavioral.templatemethod;

public class WarTank extends Animatable {

    @Override
    public void updateFrame() {
        this.animate();
        this.paint();
        this.erase();
    }

    @Override
    public void animate() {
        setX(getX() + 2);
        setY(getY() + 2);
    }

    @Override
    public void paint() {
        System.out.printf("War tank in: (%d,%d)\n", getX(), getY());
    }

    @Override
    public void erase() {
        System.out.println("Elemento eliminado del mapa");
    }
}
