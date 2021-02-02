package pattern.behavioral.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Clase que permite almacenar el historial ordenado de estados de un objeto.
 */
public class History {

    private Map<String, Snapshot> snapshots = new Hashtable<String, Snapshot>();

    public void addSnapshot(String name, Snapshot snapshot) {
        snapshots.put(name, snapshot);
    }

    public Snapshot getSnapshot(String name) {
        if (snapshots.containsKey(name) == true) {
            return snapshots.get(name);
        }

        return null;
    }
}
