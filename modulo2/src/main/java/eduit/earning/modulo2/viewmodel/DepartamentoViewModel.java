package eduit.earning.modulo2.viewmodel;

import eduit.earning.modulo2.DepartamentoDialog;
import eduit.learning.modulo2.model.Departamento;
import eduit.learning.modulo2.repository.DepartamentoRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DepartamentoViewModel {

    private DepartamentoDialog view;
    private DepartamentoRepository depRepository;

    public DepartamentoViewModel(DepartamentoDialog view) {
        try {
            this.view = view;
            this.depRepository = new DepartamentoRepository();
            this.InicializarEventos();
        } catch (IOException ex) {

        } catch (Exception ex) {

        }
    }

    private void InicializarEventos() {
        this.view.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionGuardarDepartamento();
            }

        });

        this.view.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCancelar();
            }

        });
    }

    private void AccionGuardarDepartamento() {
        try {
            Departamento dep = new Departamento();
            dep.setNombre(this.view.txtNombre.getText());
            dep.setDescripcion(this.view.txtDescripcion.getText());

            int departamentosInsertados = this.depRepository.insertEntity(dep);
            if (departamentosInsertados > 0) {
                JOptionPane.showConfirmDialog(this.view, "El departamento se guardó correctamente", "Departamento guardado",
                        JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);

                this.view.setVisible(false);
                this.view.dispose();
            }

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el elemento!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this.view, "¡Ocurrió un error al intentar guardar el elemento!", "Error",
                    JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AccionCancelar() {
        this.view.setVisible(false);
        this.view.dispose();
    }
}
