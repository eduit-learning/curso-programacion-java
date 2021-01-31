package eduit.learning.modulo3.laboratorio.utils;

import eduit.learning.modulo3.laboratorio.utils.Holder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Convertidor {

    private Convertidor() {
    }

    public static boolean getDoubleFromString(String textInput, Holder<Double> output) {
        try {
            output.setValue(Double.parseDouble(textInput));

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean getIntFromString(String textInput, Holder<Integer> output) {
        try {
            output.setValue(Integer.parseInt(textInput));

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean getFechaFromString(String textInput, Date output, String language, String region) {
        try {
            Locale locale = new Locale(language, region);
            output = new SimpleDateFormat("yyyy/MM/dd", locale).parse(textInput);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
