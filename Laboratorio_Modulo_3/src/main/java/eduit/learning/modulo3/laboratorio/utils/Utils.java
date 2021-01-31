package eduit.learning.modulo3.laboratorio.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Utils {

    private static final String resourceBundlePackage = "eduit.learning.modulo3.laboratorio.resourcesbundle.";
    private static ResourceBundle mensajesVentasRB;

    private Utils() {
    }

    public static ResourceBundle getMensajesVentasRB(Locale locale) {
        if (mensajesVentasRB == null) {
            mensajesVentasRB = ResourceBundle.getBundle(resourceBundlePackage + "MensajesVentasResourceBundle", locale);
        }
        return mensajesVentasRB;
    }
}
