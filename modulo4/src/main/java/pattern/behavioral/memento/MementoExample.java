package pattern.behavioral.memento;

public class MementoExample {

    public static void main(String[] args) {
        History history = new History();
        Console console = new Console();

        console.setCommand("ls -la");
        console.exec();
        history.addSnapshot("Version1", console.generateSnapshot());

        console.setCommand("cd ..");
        console.exec();
        history.addSnapshot("Version2", console.generateSnapshot());

        console.restoreFromSnapshot(history.getSnapshot("Version1"));
        console.exec(); // Salida: Exec command: ls -la
    }

}
