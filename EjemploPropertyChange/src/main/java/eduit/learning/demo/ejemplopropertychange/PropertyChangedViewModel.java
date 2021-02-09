package eduit.learning.demo.ejemplopropertychange;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class PropertyChangedViewModel {

    private EventManager eventManager;
    private PropertyChangeModel model;
    private Timer timerCronometro;
    private long milisegundos;

    public PropertyChangedViewModel(EventManager eventManager) {
        this.eventManager = eventManager;
        this.model = new PropertyChangeModel(eventManager);
        this.timerCronometro = new Timer();
        this.iniciarTimerCronometro();
    }

    private void iniciarTimerCronometro() {
        // Clase en la que está el código a ejecutar
        TimerTask timerTask = new TimerTask() {
            public void run() {
                // Aquí el código que queremos ejecutar.
                milisegundos += 100;
                model.setCronometro("" + milisegundos);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                model.setHora(dtf.format(now));
            }
        };

        this.milisegundos = 0;

        // Aquí se pone en marcha el timer cada segundo.
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos
        this.timerCronometro.scheduleAtFixedRate(timerTask, 0, 100);
    }

    public PropertyChangeModel getModel() {
        return this.model;
    }
}
