package eduit.learning.modulo3.laboratorio.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Utils {

    private static final String resourceBundlePackage = "eduit.learning.modulo3.laboratorio.resourcesbundle.";
    private static ResourceBundle mensajesVentasRB;
    private static ResourceBundle etiquetasVentasRB;

    private Utils() {
    }

    public static ResourceBundle getMensajesVentasRB(Locale locale) {
        mensajesVentasRB = ResourceBundle.getBundle(resourceBundlePackage + "MensajesVentasResourceBundle", locale);
        return mensajesVentasRB;
    }

    public static ResourceBundle getEtiquetasVentasRB(Locale locale) {
        etiquetasVentasRB = ResourceBundle.getBundle(resourceBundlePackage + "EtiquetasVentasResourceBundle", locale);
        return etiquetasVentasRB;
    }
}
