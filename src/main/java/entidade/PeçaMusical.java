package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.PeçaMusicalClássica.EstiloMúsicaClássica;
import entidade.PeçaMusicalPopular.EstiloMúsicaPopular;
import entidade.PeçaMusicalPopular.InstrumentaçãoCaracterística;
import persistência.BD;

public class PeçaMusical {

    public enum Gênero {
        clássico, romântico, jazz, rock, pop, reggae, blues, country, barroco, modernismo, samba
    };

    String titulo, compositor, tom;
    private int duracao;
    private Gênero genero;

    public PeçaMusical(String titulo, String compositor, int duracao, String tom, Gênero genero) {
        this.titulo = titulo;
        this.compositor = compositor;
        this.duracao = duracao;
        this.tom = tom;
        this.genero = genero;
    }

    public PeçaMusical(String titulo, String tom) {
        this.titulo = titulo;
        this.tom = tom;
    }

    public PeçaMusical getVisão() {
        return new PeçaMusical(titulo, tom);
    }

    public static PeçaMusical buscarPeçaMusical(String titulo) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT * FROM PeçasMusicais WHERE titulo = ?";
        String compositor = null;
        int duracao = 0;
        String tom = null;
        Gênero genero = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                titulo = lista_resultados.getString("titulo");
                compositor = lista_resultados.getString("compositor");
                duracao = lista_resultados.getInt("duracao");
                tom = lista_resultados.getString("tom");
                genero = Gênero.valueOf(lista_resultados.getString("genero"));
            }

            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
        }
        if (titulo == null) {
            return null;
        }
        sql = "SELECT Estilo_música_clássica, Muito_conhecida FROM PeçasMusicaisClássicas WHERE PeçaMusicalId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new PeçaMusicalClássica(titulo, compositor, duracao, tom, genero,
                        EstiloMúsicaClássica.values()[lista_resultados.getInt("Estilo_música_clássica")],
                        lista_resultados.getBoolean("Muito_conhecida"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
        }
        sql = "SELECT Estilo_música_popular, Instrumentação_característica FROM PeçasMusicaisPopulares WHERE PeçaMusicalId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new PeçaMusicalPopular(titulo, compositor, duracao, tom, genero,
                        EstiloMúsicaPopular.values()[lista_resultados.getInt("Estilo_música_popular")],
                        InstrumentaçãoCaracterística.values()[lista_resultados.getInt("Instrumentação_característica")]);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
        }
        return null;
    }

    public static String inserirPeçaMusical(PeçaMusical peça_musical) {
        String sql = "INSERT INTO PeçasMusicais (titulo, compositor, duracao, tom, genero) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, peça_musical.getTitulo());
            comando.setString(2, peça_musical.getCompositor());
            comando.setInt(3, peça_musical.getDuracao());
            comando.setString(4, peça_musical.getTom());
            comando.setString(5, peça_musical.getGênero().toString());
            comando.executeUpdate();
            comando.close();

        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na inserção da peça musical no BD";
        }

        if (peça_musical instanceof PeçaMusicalClássica) {
            PeçaMusicalClássica peça_musical_clássica = (PeçaMusicalClássica) peça_musical;
            sql = "INSERT INTO PeçasMusicaisClássicas ( Estilo_música_clássica, Muito_conhecida, PeçaMusicalId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, peça_musical_clássica.getEstilo_música_clássica().ordinal());
                comando.setBoolean(2, peça_musical_clássica.isMuito_conhecida());
                comando.setString(3, peça_musical_clássica.getTitulo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção) {
                exceção.printStackTrace();
                return "Erro na inserção da peça musical clássica no BD";
            }
        } else if (peça_musical instanceof PeçaMusicalPopular) {
            PeçaMusicalPopular peça_musical_popular = (PeçaMusicalPopular) peça_musical;
            sql = "INSERT INTO PeçasMusicaisPopulares ( Estilo_música_popular, Instrumentação_característica, PeçaMusicalId) VALUES (?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, peça_musical_popular.getEstilo_música_popular().ordinal());
                comando.setInt(2, peça_musical_popular.getInstrumentação_característica().ordinal());
                comando.setString(3, peça_musical_popular.getTitulo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção) {
                exceção.printStackTrace();
                return "Erro na inserção da peça musical popular no BD";
            }
        }
        return null;
    }

    public static String alterarPeçaMusical(PeçaMusical peça_musical) {
        String sql = "UPDATE PeçasMusicais SET compositor = ?, duracao = ?, tom = ?, genero = ? WHERE titulo = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, peça_musical.getCompositor());
            comando.setInt(2, peça_musical.getDuracao());
            comando.setString(3, peça_musical.getTom());
            comando.setString(4, peça_musical.getGênero().toString());
            comando.setString(5, peça_musical.getTitulo());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na alteração da peça musical no BD";
        }
        if (peça_musical instanceof PeçaMusicalClássica) {
            PeçaMusicalClássica peça_musical_clássica = (PeçaMusicalClássica) peça_musical;
            sql = "UPDATE PeçasMusicaisClássicas SET Estilo_música_clássica = ?, Muito_conhecida = ? WHERE PeçaMusicalId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, peça_musical_clássica.getEstilo_música_clássica().ordinal());
                comando.setBoolean(2, peça_musical_clássica.isMuito_conhecida());
                comando.setString(3, peça_musical_clássica.getTitulo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção) {
                exceção.printStackTrace();
                return "Erro na alteração da peça musical clássica no BD";
            }
        } else if (peça_musical instanceof PeçaMusicalPopular) {
            PeçaMusicalPopular peça_musical_popular = (PeçaMusicalPopular) peça_musical;
            sql = "UPDATE PeçasMusicaisPopulares SET Estilo_música_popular = ?, Instrumentação_característica = ? WHERE PeçaMusicalId = ?";
            try {
                PreparedStatement comando = BD.conexão.prepareStatement(sql);
                comando.setInt(1, peça_musical_popular.getEstilo_música_popular().ordinal());
                comando.setInt(2, peça_musical_popular.getInstrumentação_característica().ordinal());
                comando.setString(3, peça_musical_popular.getTitulo());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção) {
                exceção.printStackTrace();
                return "Erro na alteração da peça musical popular no BD";
            }
        }
        return null;
    }

    public static String removerPeçaMusical(String titulo) {
        String sql = "DELETE FROM PeçasMusicaisClássicas WHERE PeçaMusicalId = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na remoção da peça musical clássica no BD";
        }

        sql = "DELETE FROM PeçasMusicaisPopulares WHERE PeçaMusicalId = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na remoção da peça musical popular no BD";
        }

        sql = "DELETE FROM PeçasMusicais WHERE titulo = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            comando.executeUpdate();
            comando.close();
            return null;

        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na remoção da peça musical no BD";
        }
    }

    public static PeçaMusical[] getVisões() {
        String sql = "SELECT titulo, tom FROM PeçasMusicais";
        ResultSet lista_resultados = null;
        ArrayList<PeçaMusical> visões = new ArrayList<>();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String titulo = lista_resultados.getString("titulo");
                String tom = lista_resultados.getString("tom");
                //visões.add(new PeçaMusical(titulo, tom));
                PeçaMusical peça = buscarPeçaMusical(titulo);
                visões.add(peça);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
        }
        return visões.toArray(new PeçaMusical[visões.size()]);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCompositor() {
        return compositor;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getTom() {
        return tom;
    }

    public void setTom(String tom) {
        this.tom = tom;
    }

    public Gênero getGênero() {
        return genero;
    }

    public String toString() {
        return titulo + " [" + tom + "]";
    }

    public String toStringFull() {
        return "Título: " + titulo + "["+tom+"] \nDuração: " + duracao;
    }
}