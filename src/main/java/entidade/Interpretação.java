package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistência.BD;

public class Interpretação {

    private int sequencial;
    private Repertório repertório;
    private PeçaMusical peça_musical;

    public Interpretação(int sequencial, Repertório repertório, PeçaMusical peça_musical) {
        this.sequencial = sequencial;
        this.repertório = repertório;
        this.peça_musical = peça_musical;
    }

    public Interpretação(int sequencial) {
        this.sequencial = sequencial;
    }

    public Interpretação getVisão() {
        return new Interpretação(sequencial, repertório, peça_musical);
    }

    public static int últimoSequencial() {
        String sql = "SELECT MAX(sequencial) FROM Interpretações";
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

    public static Interpretação[] getVisões() {
        String sql = "SELECT sequencial, repertórioId, peçaMusicalId from Interpertações";
        ResultSet lista_resultados = null;
        ArrayList<Interpretação> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Interpretação(lista_resultados.getInt("sequencial"),
                        Repertório.buscarRepertório(lista_resultados.getInt("repertórioId")).getVisão(),
                        PeçaMusical.buscarPeçaMusical(lista_resultados.getString("PeçaMusicalId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new Interpretação[visões.size()]);
    }

    public static boolean existeInterpretação(int chave_repertório, String chave_peça_musical) {
        String sql = "SELECT Sequencial from Interpretações WHERE RepertórioId = ? AND PeçaMusicalId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, chave_repertório);
            comando.setString(2, chave_peça_musical);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static boolean existeInterpretação(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) from Interpretações WHERE sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static String inserirInterpretação(Interpretação interpretação) {
        String sql = "INSERT INTO Interpretações VALUES(?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, interpretação.getSequencial());
            comando.setInt(2, interpretação.repertório.getSequencial());
            comando.setString(3, interpretação.peça_musical.getTitulo());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao adicionar interpretação";
        }
        return null;
    }

    public static String removerInterpretação(int sequencial) {
        System.out.println("Sequencial passado para remoção: " + sequencial);
        String sql = "DELETE FROM Interpretações WHERE sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao remover interpretação";
        }
    }

    public static Interpretação[] buscarInterpretaçõesRepertório(int sequencial_repertório) {
        String sql = "SELECT * FROM Interpretações WHERE RepertórioId = ?";
        ArrayList<Interpretação> interpretações = new ArrayList<>();

        try (PreparedStatement comando = BD.conexão.prepareStatement(sql)) {
            comando.setInt(1, sequencial_repertório);
            try (ResultSet lista_resultados = comando.executeQuery()) {
                while (lista_resultados.next()) {
                    Interpretação interpretação = new Interpretação(
                            lista_resultados.getInt("Sequencial"),
                            Repertório.buscarRepertório(lista_resultados.getInt("RepertórioId")),
                            PeçaMusical.buscarPeçaMusical(lista_resultados.getString("PeçaMusicalId"))
                    );
                    interpretações.add(interpretação);
                }
            }
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return new Interpretação[0];
        }

        return interpretações.toArray(new Interpretação[0]);
    }

    public static PeçaMusical[] buscarPeçasRepertório(int sequencial_repertório){
        String sql = "SELECT PeçaMusicalId FROM Interpretações WHERE RepertórioId = ?";
        ResultSet lista_resultados = null;
        ArrayList<PeçaMusical> visões = new ArrayList<>();
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial_repertório);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                visões.add(PeçaMusical.buscarPeçaMusical(lista_resultados.getString("PeçaMusicalId")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new PeçaMusical[visões.size()]);
       
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Repertório getRepertório() {
        return repertório;
    }

    public PeçaMusical getPeçaMusical() {
        return peça_musical;
    }

    public String toString() {
        return peça_musical.getTitulo() + " [" + peça_musical.getTom() + "]";
    }
}
