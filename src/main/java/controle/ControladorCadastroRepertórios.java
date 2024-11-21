package controle;

import entidade.Repertório;
import interfaces.JanelaCadastroRepertórios;

public class ControladorCadastroRepertórios {

    public ControladorCadastroRepertórios() {
        new JanelaCadastroRepertórios(this).setVisible(true);
    }

    public String inserirRepertório(Repertório repertório) {
        if (!Repertório.existeRepertórioMesmosAtributos(repertório)) {
            return Repertório.inserirRepertório(repertório);
        } else {
            return "Já existe um repertório com os mesmos atributos";
        }
    }

    public String alterarRepertório(Repertório repertório) {
        Repertório repertório1 = Repertório.buscarRepertório(repertório.getSequencial());
        if (repertório1 != null) {
            return Repertório.alterarRepertório(repertório);
        } else {
            return "Repertório não cadastrado";
        }
    }

    public String removerRepertório(int sequencial) {
        Repertório repertório1 = Repertório.buscarRepertório(sequencial);
        if (repertório1 != null) {
            return Repertório.removerRepertório(sequencial);
        } else {
            return "Repertório não cadastrado";
        }
    }

}
