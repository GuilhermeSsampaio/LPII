package entidade;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import persistência.BD;

/**
 *
 * @author guilh
 */
public class PeçaMusical {

    public enum Gênero {
        //clássico, romântico, jazz, rock, pop, reggae, blues, country, barroco, modernismo, samba
        clássico, rock, pop, samba
    };

    private String titulo, compositor, tom;
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
        String sql = "SELECT * FROM PeçasMusicais WHERE titulo = ?";
        ResultSet lista_resultados = null;
        PeçaMusical peça_musical = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                peça_musical = new PeçaMusical(lista_resultados.getString("titulo"),
                        lista_resultados.getString("compositor"),
                        lista_resultados.getInt("duracao"),
                        lista_resultados.getString("tom"),
                        Gênero.valueOf(lista_resultados.getString("genero")));
            }
            lista_resultados.close();
            comando.close();
        } catch (Exception exceção) {
            exceção.printStackTrace();
            peça_musical = null;
        }
        return peça_musical;
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
            return null;

        } catch (Exception exceção) {
            exceção.printStackTrace();
            return "Erro na inserção da peça musical no BD";
        }
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
            return null;

        } catch (Exception exceção) {
            exceção.printStackTrace();
            return "Erro na alteração da peça musical no BD";
        }
    }

    public static String removerPeçaMusical(String titulo) {
        String sql = "DELETE FROM PeçasMusicais WHERE titulo = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, titulo);
            comando.executeUpdate();
            comando.close();
            return null;

        } catch (Exception exceção) {
            exceção.printStackTrace();
            return "Erro na remoção da peça musical no BD";
        }
    }

    public static PeçaMusical[] getVisões() {
        String sql = "SELECT titulo, tom FROM PeçasMusicais";
        ResultSet lista_resultados = null;
        ArrayList<PeçaMusical> visões = new ArrayList();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String titulo = lista_resultados.getString("titulo");
                String tom = lista_resultados.getString("tom");
                visões.add(new PeçaMusical(titulo, tom));
            }
            lista_resultados.close();
            comando.close();
        } catch (Exception exceção) {
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
        return titulo + " ["+tom+"]";
    }
}
