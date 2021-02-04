package pattern.behavioral.mediator;

import java.io.File;

public class MediatorDemo {

    public static void main(String[] args) {
        Mediator mediator = new GuiController();

        FileTree fileTree = new FileTree(mediator);
        TextEditor textEditor = new TextEditor(mediator);
        SpellChecker spellChecker = new SpellChecker(mediator);
        CountString countString = new CountString(mediator);

        fileTree.selectedFile(new File("C:\\JavaProjects\\curso-programacion-java\\README.md"));
        textEditor.appendText("Hola Mund!");
    }
}
