package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class Maestro {

    public enum Estilo{
        expressivo, dinâmico, leve, elegante;
    };
    
    private String nome;
    int anos_experiencia;
    private Estilo estilo;
    boolean estrangeiro;

    public Maestro(String nome, int anos_experiencia, Estilo estilo, boolean estrangeiro) {
        this.nome = nome;
        this.anos_experiencia = anos_experiencia;
        this.estilo = estilo;
        this.estrangeiro = estrangeiro;
    }

    public Maestro(String nome, int anos_experiencia) {
        this.nome = nome;
        this.anos_experiencia = anos_experiencia;
    }

    public Maestro getVisão() {
        return new Maestro(nome, anos_experiencia);
    }

    public static Maestro buscarMaestro(String nome) {
        String sql = "SELECT * FROM maestros WHERE nome = ?";
        ResultSet lista_resultados = null;
        Maestro maestro = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                maestro = new Maestro(lista_resultados.getString("nome"),
                        lista_resultados.getInt("anos_experiencia"),
                        Estilo.valueOf(lista_resultados.getString("estilo_regencia")),
                        lista_resultados.getBoolean("estrangeiro"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            maestro = null;
        }
        return maestro;
    }

    public static String inserirMaestro(Maestro maestro) {
        String sql = "INSERT INTO maestros (nome, anos_experiencia, estilo_regencia, estrangeiro) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, maestro.getNome());
            comando.setInt(2, maestro.getAnos_experiencia());
            comando.setString(3, maestro.getEstilo().toString());
            comando.setBoolean(4, maestro.isEstrangeiro());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na inserção do maestro no BD";
        }
    }

    public static String alterarMaestro(Maestro maestro) {
        String sql = "UPDATE maestros SET anos_experiencia = ?, estilo_regencia = ?, estrangeiro = ? WHERE nome = ?";

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(4, maestro.getNome());
            comando.setInt(1, maestro.getAnos_experiencia());
            comando.setString(2, maestro.getEstilo().toString());
            comando.setBoolean(3, maestro.isEstrangeiro());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na atualização do maestro no BD";
        }
    }

    public static String removerMaestro(String nome) {
        String sql = "DELETE FROM maestros WHERE nome = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na remoção do maestro no BD";
        }
    }

    public static Maestro[] getVisões() {
        String sql = "SELECT nome, anos_experiencia FROM Maestros";
        ResultSet lista_resultados = null;
        ArrayList<Maestro> visões = new ArrayList();

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                int anos_experiencia = lista_resultados.getInt("anos_experiencia");
                visões.add(new Maestro(nome, anos_experiencia));
            }
            lista_resultados.close();
            comando.close();

        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return visões.toArray(new Maestro[visões.size()]);
    }

    public String getNome() {
        return nome;
    }

    public int getAnos_experiencia() {
        return anos_experiencia;
    }

    public void setAnosExperiencia(int anos_experiencia) {
        this.anos_experiencia = anos_experiencia;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public boolean isEstrangeiro() {
        return estrangeiro;
    }

    public String getEstrangeiroString() {
        return estrangeiro ? "Sim" : "Não";
    }

    public String toString() {
        return nome + " [anos de experiência: " + anos_experiencia + "]"; // Retorna o nome do maestro para exibição no ComboBox
    }

    public String toStringFull() {
        return nome + "[" + anos_experiencia + "] - Estrangeiro: " + getEstrangeiroString();
    }
}
