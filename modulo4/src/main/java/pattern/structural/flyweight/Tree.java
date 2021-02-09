package pattern.structural.flyweight;

import java.awt.Color;

/**
 * Clase contextual (context) contiene la parte extrínseca.
 */
public class Tree {
    private int x;
    private int y;
    private TreeType type;
    Color color;
    String name;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
