package controle;

import entidade.Maestro;
import interfaces.JanelaCadastroMaestros;

public class ControladorCadastroMaestros {

    public ControladorCadastroMaestros() {
        new JanelaCadastroMaestros(this).setVisible(true);
    }

    public String inserirMaestro(Maestro maestro) {
        Maestro maestro1 = Maestro.buscarMaestro(maestro.getNome());
        if (maestro1 == null) {
            return Maestro.inserirMaestro(maestro);
        } else {
            return "Maestro já cadastrado";
        }
    }

    public String alterarMaestro(Maestro maestro) {
        Maestro maestro1 = Maestro.buscarMaestro(maestro.getNome());
        if (maestro1 != null) {
            return Maestro.alterarMaestro(maestro);
        } else {
            return "Maestro não cadastrado";
        }
    }

    public String removerMaestro(String nome) {
        Maestro maestro1 = Maestro.buscarMaestro(nome);
        if (maestro1 != null) {
            return Maestro.removerMaestro(nome);
        } else {
            return "Maestro não cadastrado";
        }
    }
}
