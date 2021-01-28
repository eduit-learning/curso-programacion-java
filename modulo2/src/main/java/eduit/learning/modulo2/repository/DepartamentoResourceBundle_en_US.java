package eduit.learning.modulo2.repository;

import java.util.ListResourceBundle;

public class DepartamentoResourceBundle_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"lblNombre", "Name"},
            {"lblDescripcion", "Description"}};
    }

}
