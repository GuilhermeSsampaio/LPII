/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author guilh
 */
public class PeçaMusicalClássica extends PeçaMusical {

    public enum EstiloMúsicaClássica {
        barroco, romântico, clássico, modernismo
    };

    private EstiloMúsicaClássica estilo_música_clássica;
    private boolean muito_conhecida;

    public PeçaMusicalClássica(String titulo, String compositor, int duracao, String tom, Gênero gênero,
             EstiloMúsicaClássica estilo_música_clássica, boolean muito_conhecida) {
        super(titulo, compositor, duracao, tom, gênero);
        this.estilo_música_clássica = estilo_música_clássica;
        this.muito_conhecida = muito_conhecida;
    }

    public PeçaMusicalClássica(String titulo, String tom, EstiloMúsicaClássica estilo_música_clássica) {
        super(titulo, tom);
        this.estilo_música_clássica = estilo_música_clássica;
    }

    public PeçaMusicalClássica getVisão() {
        return new PeçaMusicalClássica(titulo, tom, estilo_música_clássica);
    }

    public EstiloMúsicaClássica getEstilo_música_clássica() {
        return estilo_música_clássica;
    }

    public void setEstilo_música_clássica(EstiloMúsicaClássica estilo_música_clássica) {
        this.estilo_música_clássica = estilo_música_clássica;
    }

    public boolean isMuito_conhecida() {
        return muito_conhecida;
    }

    public void setMuito_conhecida(boolean muito_conhecida) {
        this.muito_conhecida = muito_conhecida;
    }

    public String toString() {
        String str = "[" + titulo + "]";
        if (muito_conhecida) {
            str += " (muito conhecida)";
        }
        return str;
    }
}
