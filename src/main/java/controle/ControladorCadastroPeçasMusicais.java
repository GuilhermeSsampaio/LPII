package controle;

import entidade.PeçaMusical;
import interfaces.JanelaCadastroPeçasMusicais;

public class ControladorCadastroPeçasMusicais {

    public ControladorCadastroPeçasMusicais() {
        new JanelaCadastroPeçasMusicais(this).setVisible(true);
    }

    public String inserirPeçaMusical(PeçaMusical peça_musical) {
        PeçaMusical peça_musical1 = PeçaMusical.buscarPeçaMusical(peça_musical.getTitulo());
        if (peça_musical1 == null) {
            return PeçaMusical.inserirPeçaMusical(peça_musical);
        } else {
            return "Peça musical já cadastrada";
        }
    }

    public String alterarPeçaMusical(PeçaMusical peça_musical) {
        PeçaMusical peça_musical1 = PeçaMusical.buscarPeçaMusical(peça_musical.getTitulo());
        if (peça_musical1 != null) {
            return PeçaMusical.alterarPeçaMusical(peça_musical);
        } else {
            return "Peça musical não cadastrada";
        }
    }

    public String removerPeçaMusical(String titulo) {
        PeçaMusical peça_musical1 = PeçaMusical.buscarPeçaMusical(titulo);
        if (peça_musical1 != null) {
            return PeçaMusical.removerPeçaMusical(titulo);
        } else {
            return "Peça musical não cadastrada";
        }
    }

}
