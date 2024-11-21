/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author guilh
 */
public class PeçaMusicalPopular extends PeçaMusical {

    public enum EstiloMúsicaPopular {
        pop, rock, country, reggae, blues, jazz
    };

    public enum InstrumentaçãoCaracterística {
        guitarra_elétrica, baixo, bateria, teclado, saxofone, trompete, violão, sintetizador, violino, contrabaixo
    }

    private EstiloMúsicaPopular estilo_música_popular;
    private InstrumentaçãoCaracterística instrumentação_característica;

    public PeçaMusicalPopular(String titulo, String compositor, int duracao, String tom, Gênero gênero,
             EstiloMúsicaPopular estilo_música_popular, InstrumentaçãoCaracterística instrumentação_característica) {
        super(titulo, compositor, duracao, tom, gênero);
        this.estilo_música_popular = estilo_música_popular;
        this.instrumentação_característica = instrumentação_característica;
    }

    public PeçaMusicalPopular(String titulo, String tom ) {
        super(titulo, tom);
    }

    public PeçaMusicalPopular getVisão() {
        return new PeçaMusicalPopular(titulo, tom);
    }

    public EstiloMúsicaPopular getEstilo_música_popular() {
        return estilo_música_popular;
    }


    public void setEstilo_música_popular(EstiloMúsicaPopular estilo_música_popular) {
        this.estilo_música_popular = estilo_música_popular;
    }

    public InstrumentaçãoCaracterística getInstrumentação_característica() {
        return instrumentação_característica;
    }

    public void setInstrumentação_característica(InstrumentaçãoCaracterística instrumentação_característica) {
        this.instrumentação_característica = instrumentação_característica;
    }

    public String toString() {
        return "Popular - " + super.toString();
    }

    public String toStringFull() {
        return "Popular - " + super.toStringFull() + "\nEstilo: " + estilo_música_popular;
    }
}
