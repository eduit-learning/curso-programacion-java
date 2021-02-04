package pattern.behavioral.mediator;

public class CountString {

    private Mediator mediator;

    public CountString(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.register(this);
    }

    public void check(String newText) {
        System.out.println("El tamaño de la nueva cadena es:" + newText.length());
    }
}
