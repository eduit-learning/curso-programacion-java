package eduit.learning.modulo2.repository;

import java.util.ListResourceBundle;

public class DepartamentoResourceBundleFormulario_es_MX extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lblNombre", "Nombre"},
            {"lblApellidos", "Apellidos"},
            {"lblEdad", "Edad"}
        };
    }

}
