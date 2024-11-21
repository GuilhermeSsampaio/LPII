package controle;

import entidade.Interpretação;
import interfaces.JanelaCadastroInterpretação;
import interfaces.JanelaCadastroRepertórios;

public class ControladorCadastroInterpretaçõesRepertório {

    public ControladorCadastroInterpretaçõesRepertório(
            JanelaCadastroRepertórios janela_cadastro_repertórios, int sequencial_repertório) {
        new JanelaCadastroInterpretação(this,
                janela_cadastro_repertórios, sequencial_repertório).setVisible(true);
    }

    public String removerInterpretação(int sequencial) {
        boolean existe_interpretação = Interpretação.existeInterpretação(sequencial);
        if (existe_interpretação) {
            return Interpretação.removerInterpretação(sequencial);
        } else {
            return "Interpretação não cadastrada";
        }
    }

    public String inserirInterpretação(Interpretação interpretação) {
        boolean existe_interpretação = Interpretação.existeInterpretação(interpretação.getRepertório().getSequencial(),
                interpretação.getPeçaMusical().getTitulo());
        if (!existe_interpretação) {
            return Interpretação.inserirInterpretação(interpretação);
        } else {
            return "Sequencial de interpretação já cadastrado";
        }
    }

}
