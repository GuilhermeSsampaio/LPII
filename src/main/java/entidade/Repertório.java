package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;

import persistência.BD;

public class Repertório {

    private int sequencial;
    private String nome;
    private Date data_montagem;
    private String descrição;

    public Repertório(int sequencial, String nome, Date data_montagem, String descrição) {
        this.sequencial = sequencial;
        this.nome = nome;
        this.data_montagem = data_montagem;
        this.descrição = descrição;
    }

    public Repertório(int sequencial, String nome) {
        this.sequencial = sequencial;
        this.nome = nome;
    }

    public static int últimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM Repertórios";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return sequencial;
    }

    public static Repertório[] getVisões() {
        String sql = "SELECT sequencial, nome FROM Repertórios";
        ResultSet lista_resultados = null;
        ArrayList<Repertório> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Repertório(lista_resultados.getInt("Sequencial"), lista_resultados.getString("nome")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Repertório[visões.size()]);
    }

    public static Boolean existeRepertórioMesmosAtributos(Repertório repertório) {
        String sql = "SELECT COUNT(Sequencial) FROM Repertórios WHERE nome = ? AND data_montagem = ? AND descrição = ?";
        ResultSet lista_resultados = null;
        int n_repertórios_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, repertório.nome);
            comando.setDate(2, repertório.data_montagem);
            comando.setString(3, repertório.descrição);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_repertórios_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_repertórios_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String inserirRepertório(Repertório repertório) {
        String sql = "INSERT INTO Repertórios (sequencial, nome, data_montagem, descrição) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, repertório.getSequencial());
            comando.setString(2, repertório.getNome());
            comando.setDate(3, repertório.getData_montagem());
            comando.setString(4, repertório.getDescrição());
            comando.execute();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na inserção do repertório no BD";
        }
    }

    public static String alterarRepertório(Repertório repertório) {
        String sql = "UPDATE Repertórios SET nome = ?, data_montagem = ?, descrição = ? WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, repertório.getNome());
            comando.setDate(2, repertório.getData_montagem());
            comando.setString(3, repertório.getDescrição());
            comando.setInt(4, repertório.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na alteração do repertório no BD";
        }
    }

    //N TEM NO TUTORIAL
    public static String removerRepertório(int sequencial) {
        String sqlDeleteInterpretacoes = "DELETE FROM Interpretações WHERE RepertórioId = ?";
        String sqlDeleteRepertorio = "DELETE FROM Repertórios WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sqlDeleteInterpretacoes);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();

            comando = BD.conexão.prepareStatement(sqlDeleteRepertorio);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();

            return null;
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            return "Erro na exclusão do repertório e suas interpretações no BD";
        }
    }

    public static Repertório buscarRepertório(int sequencial) {
        String sql = "SELECT * FROM Repertórios WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        Repertório repertório = null;

        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                repertório = new Repertório(lista_resultados.getInt("sequencial"),
                        lista_resultados.getString("nome"),
                        lista_resultados.getDate("data_montagem"),
                        lista_resultados.getString("descrição"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção) {
            exceção.printStackTrace();
            repertório = null;
        }
        return repertório;
    }

    public Repertório getVisão() {
        return new Repertório(sequencial, nome);
    }

    public String toString() {
        return "[" + getSequencial() + "] " + getNome();
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_montagem() {
        return data_montagem;
    }

    public String getDataMontagemFormatada() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data_montagem);
    }

    public void setData_montagem(Date data_montagem) {
        this.data_montagem = data_montagem;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String toStringFull() {
        return nome + " - " + data_montagem + " - " + descrição;
    }
}
