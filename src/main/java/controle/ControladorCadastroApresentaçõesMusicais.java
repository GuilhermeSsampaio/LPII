package controle;

import entidade.ApresentaçãoMusical;
import interfaces.JanelaCadastroApresentaçõesMusicais;

public class ControladorCadastroApresentaçõesMusicais {
    public ControladorCadastroApresentaçõesMusicais() {
        new JanelaCadastroApresentaçõesMusicais(this).setVisible(true);
    }

    public String inserirApresentaçãoMusical(ApresentaçãoMusical apresentaçãoMusical) {
        if (!ApresentaçãoMusical.existeApresentaçãoMusical(apresentaçãoMusical.getMaestro().getNome(),
                apresentaçãoMusical.getRepertório().getSequencial())) {
            return ApresentaçãoMusical.inserirApresentaçãoMusical(apresentaçãoMusical);
        } else {
            return "Sequencial de apresentação musical já cadastrado";
        }
    }

    public String alterarApresentaçãoMusical(ApresentaçãoMusical apresentação_musical_informada) {
        ApresentaçãoMusical apresentaçãoMusical_cadastradas = ApresentaçãoMusical
                .buscarApresentaçãoMusical(apresentação_musical_informada.getSequencial());
        if ((apresentação_musical_informada.getMaestro().getNome()
                .equals(apresentaçãoMusical_cadastradas.getMaestro().getNome())) &&
                (apresentação_musical_informada.getRepertório().getSequencial() == apresentaçãoMusical_cadastradas
                        .getRepertório().getSequencial())) {
            return ApresentaçãoMusical.alterarApresentaçãoMusical(apresentação_musical_informada);
        } else {
            return "Alteração não permitida : chave do maestro e/ou repertório foram alteradas";
        }
    }

    public String removerApresentaçãoMusical(int sequencial) {
        if (ApresentaçãoMusical.existeApresentaçãoMusical(sequencial)) {
            return ApresentaçãoMusical.removerApresentaçãoMusical(sequencial);
        } else {
            return "Sequencial de apresentação musical não cadastrado";
        }
    }
}
