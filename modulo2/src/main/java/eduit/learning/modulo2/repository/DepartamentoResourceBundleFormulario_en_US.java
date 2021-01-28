package eduit.learning.modulo2.repository;

import java.util.ListResourceBundle;

public class DepartamentoResourceBundleFormulario_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lblNombre", "First name"},
            {"lblApellidos", "Last name"},
            {"lblEdad", "Age"}
        };
    }

}
