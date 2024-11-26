/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import entidade.PeçaMusicalPopular.EstiloMúsicaPopular;
import persistência.BD;

/**
 *
 * @author guilh
 */
public class ApresentaçãoMusical {
    private int sequencial;
    private Timestamp data;
    private Repertório repertório;
    private Maestro maestro;
    private boolean nacional;

    // local
    public ApresentaçãoMusical(int sequencial, Timestamp data, Repertório repertório, Maestro maestro,
            boolean nacional) {
        this.sequencial = sequencial;
        this.data = data;
        this.repertório = repertório;
        this.maestro = maestro;
        this.nacional = nacional;
    }

    public ApresentaçãoMusical(int sequencial, Repertório repertório, Maestro maestro, boolean nacional) {
        this.sequencial = sequencial;
        this.repertório = repertório;
        this.maestro = maestro;
        this.nacional = nacional;
    }

    public ApresentaçãoMusical(int sequencial, Repertório repertório, Maestro maestro) {
        this.sequencial = sequencial;
        this.repertório = repertório;
        this.maestro = maestro;
    }

    public static ApresentaçãoMusical[] getVisões() {
        String sql = "SELECT Sequencial, RepertórioId, MaestroId, Nacional from ApresentaçõesMusicais";
        ResultSet lista_resultados = null;
        ArrayList<ApresentaçãoMusical> visões = new ArrayList<>();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new ApresentaçãoMusical(
                        lista_resultados.getInt("Sequencial"),
                        Repertório.buscarRepertório(lista_resultados.getInt("RepertórioId")).getVisão(),
                        Maestro.buscarMaestro(lista_resultados.getString("MaestroId")).getVisão(),
                        lista_resultados.getBoolean("Nacional")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new ApresentaçãoMusical[visões.size()]);
    }

    public static boolean existeApresentaçãoMusical(String chave_maestro, int chave_repertório) {
        String sql = "SELECT Sequencial from ApresentaçõesMusicais where MaestroId = ? and RepertórioId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_maestro);
            comando.setInt(2, chave_repertório);
            lista_resultados = comando.executeQuery();
            if (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static boolean existeApresentaçãoMusical(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) from ApresentaçõesMusicais where Sequencial = ?";
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

    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial) from ApresentaçõesMusicais";
        ResultSet lista_resultados = null;
        int último_sequencial = 0;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            if (lista_resultados.next()) {
                último_sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return último_sequencial;
    }

    public static String inserirApresentaçãoMusical(ApresentaçãoMusical apresentaçãoMusical) {
        String sql = "INSERT INTO ApresentaçõesMusicais (DataHora, RepertórioId, MaestroId, Nacional) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setTimestamp(1, apresentaçãoMusical.getDataHora());
            comando.setInt(2, apresentaçãoMusical.repertório.getSequencial());
            comando.setString(3, apresentaçãoMusical.maestro.getNome());
            comando.setBoolean(4, apresentaçãoMusical.isNacional());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao inserir apresentação musical";
        }
    }

    public static String alterarApresentaçãoMusical(ApresentaçãoMusical apresentaçãoMusical) {
        String sql = "UPDATE ApresentaçõesMusicais SET DataHora = ?, RepertórioId = ?, MaestroId = ?, Nacional = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setTimestamp(1, apresentaçãoMusical.getDataHora());
            comando.setInt(2, apresentaçãoMusical.repertório.getSequencial());
            comando.setString(3, apresentaçãoMusical.maestro.getNome());
            comando.setBoolean(4, apresentaçãoMusical.isNacional());
            comando.setInt(5, apresentaçãoMusical.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao alterar apresentação musical no BD";
        }
    }

    public static String removerApresentaçãoMusical(int sequencial) {
        String sql = "DELETE FROM ApresentaçõesMusicais WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro ao remover apresentação musical";
        }
        return null;
    }

    public static ApresentaçãoMusical buscarApresentaçãoMusical(int sequencial) {
        String sql = "SELECT * from ApresentaçõesMusicais where Sequencial = ?";
        ResultSet lista_resultados = null;
        ApresentaçãoMusical apresentação_musical = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            if (lista_resultados.next()) {
                apresentação_musical = new ApresentaçãoMusical(
                        sequencial,
                        lista_resultados.getTimestamp("DataHora"),
                        Repertório.buscarRepertório(lista_resultados.getInt("RepertórioId")),
                        Maestro.buscarMaestro(lista_resultados.getString("MaestroId")),
                        lista_resultados.getBoolean("Nacional"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            apresentação_musical = null;

        }
        return apresentação_musical;
    }

    public static ArrayList<ApresentaçãoMusical> pesquisarApresentaçõesMusicais(
            Boolean tipo_apresentação,
            String prefixo_repertório,
            Boolean maestro_estrangeiro,
            char muito_conhecida,
            EstiloMúsicaPopular estilo_musica_popular,
            int duração_mínima_peça_musical,
            boolean todas_peças_repertório) {

        String sql = "SELECT DISTINCT Ap.Sequencial, Ap.DataHora, Ap.RepertórioId, Ap.MaestroId, Ap.Nacional, Interp.PeçaMusicalId"
                + " FROM Maestros Ma, Repertórios Re, ApresentaçõesMusicais Ap, Interpretações Interp, PeçasMusicais PM"
                + " WHERE Ap.MaestroId = Ma.Nome AND Ap.RepertórioId = Re.Sequencial AND Re.Sequencial = Interp.RepertórioId"
                + " AND Interp.PeçaMusicalId = PM.Titulo";

        if (tipo_apresentação != null) {
            sql += " AND Ap.Nacional = ?";
        }
        if (prefixo_repertório != null && !prefixo_repertório.isEmpty()) {
            sql += " AND Re.Nome LIKE ?";
        }
        if (maestro_estrangeiro != null) {
            sql += " AND Ma.Estrangeiro = ?";
        }
        if (duração_mínima_peça_musical > 0) {
            sql += " AND PM.Duracao >= ?";
        }

        sql += " ORDER BY Ap.Sequencial";

        ResultSet lista_resultados = null;
        ArrayList<ApresentaçãoMusical> apresentações_selecionadas = new ArrayList<>();
        int index = 1;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            if (tipo_apresentação != null) {
                comando.setBoolean(index++, tipo_apresentação);
            }
            if (prefixo_repertório != null && !prefixo_repertório.isEmpty()) {
                comando.setString(index++, prefixo_repertório + "%");
            }
            if (maestro_estrangeiro != null) {
                comando.setBoolean(index++, maestro_estrangeiro);
            }
            if (duração_mínima_peça_musical > 0) {
                comando.setInt(index++, duração_mínima_peça_musical);
            }

            lista_resultados = comando.executeQuery();

            while (lista_resultados.next()) {
                ApresentaçãoMusical apresentação_pesquisada = ApresentaçãoMusical.buscarApresentaçãoMusical(
                        lista_resultados.getInt(1));
                int sequencial_repertório = lista_resultados.getInt(3);
                String titulo_peça_musical = lista_resultados.getString(6);

                if (!peçasRepertórioAtendemFiltrosComSubclasses(sequencial_repertório, duração_mínima_peça_musical,
                        todas_peças_repertório, muito_conhecida, estilo_musica_popular)) {
                    continue;
                }

                if (estilo_musica_popular != null) {
                    if (isOkPesquisaEmPeçasMusicaisPopulares(titulo_peça_musical, estilo_musica_popular)) {
                            apresentações_selecionadas.add(apresentação_pesquisada);
                        
                    }
                } else if (muito_conhecida != 'X') {
                    if (isOkPesquisaEmPeçasMusicaisClássicas(titulo_peça_musical, muito_conhecida)) {
                            apresentações_selecionadas.add(apresentação_pesquisada);
                        
                    }
                } else {
                    if (!apresentações_selecionadas.contains(apresentação_pesquisada)) {
                        apresentações_selecionadas.add(apresentação_pesquisada);
                    }
                }
            }

            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return apresentações_selecionadas;
    }

    private static boolean isOkPesquisaEmPeçasMusicaisClássicas(String chave_peça_musical, char muito_conhecida) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM PeçasMusicaisClássicas WHERE PeçaMusicalId = ?";
        if (muito_conhecida != 'X') {
            sql += " AND Muito_conhecida = ?";
        }
        ResultSet lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_peça_musical);
            if (muito_conhecida != 'X') {
                comando.setBoolean(2, muito_conhecida == 'T');
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    private static boolean isOkPesquisaEmPeçasMusicaisPopulares(String chave_peça_musical,
            EstiloMúsicaPopular estilo_popular) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM PeçasMusicaisPopulares WHERE PeçaMusicalId = ?";
        if (estilo_popular != null) {
            sql += " AND Estilo_música_popular = ?";
        }
        ResultSet lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_peça_musical);
            if (estilo_popular != null) {
                comando.setInt(2, estilo_popular.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next())
                pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    private static boolean peçasRepertórioAtendemFiltrosComSubclasses(int sequencial_repertório,
            int duração_mínima_peça_musical,
            boolean todas_peças_repertório, char muito_conhecida, EstiloMúsicaPopular estilo_musica_popular) {
        PeçaMusical[] peças_repertório = Interpretação.buscarPeçasRepertório(sequencial_repertório);
        int total_peças_não_atendem_filtros = 0;
        for (PeçaMusical peçaMusical : peças_repertório) {
            if ((duração_mínima_peça_musical != -1) && (peçaMusical.getDuracao() < duração_mínima_peça_musical)) {
                total_peças_não_atendem_filtros++;
                if (todas_peças_repertório)
                    return false;
            }
            if (peçaMusical instanceof PeçaMusicalClássica) {
                if (!isOkPesquisaEmPeçasMusicaisClássicas(peçaMusical.getTitulo(), muito_conhecida)) {
                    total_peças_não_atendem_filtros++;
                    if (todas_peças_repertório)
                        return false;
                }
            } else if (peçaMusical instanceof PeçaMusicalPopular) {
                if (!isOkPesquisaEmPeçasMusicaisPopulares(peçaMusical.getTitulo(), estilo_musica_popular)) {
                    total_peças_não_atendem_filtros++;
                    if (todas_peças_repertório)
                        return false;
                }
            }
        }
        if (total_peças_não_atendem_filtros == 0)
            return true;
        if ((todas_peças_repertório) || (total_peças_não_atendem_filtros == peças_repertório.length))
            return false;

        return true;
    }

    private static boolean peçasRepertórioAtendemFiltros(int sequencial_repertório, int duração_mínima_peça_musical,
            boolean todas_peças_repertório) {
        PeçaMusical[] peças_repertório = Interpretação.buscarPeçasRepertório(sequencial_repertório);
        int total_peças_não_atendem_filtros = 0;
        for (PeçaMusical peçaMusical : peças_repertório) {
            if (duração_mínima_peça_musical > 0 && peçaMusical.getDuracao() < duração_mínima_peça_musical) {
                total_peças_não_atendem_filtros++;
                if (todas_peças_repertório)
                    return false;
            }
        }
        if (total_peças_não_atendem_filtros == 0)
            return true;
        if ((todas_peças_repertório) || (total_peças_não_atendem_filtros == peças_repertório.length))
            return false;
        return true;
    }

    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mês_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mês_dia[2] + "/" + ano_mês_dia[1] + "/" + ano_mês_dia[0] + " "
                + hora_minuto_resto[0] + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }

    public ApresentaçãoMusical(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Timestamp getDataHora() {
        return data;
    }

    public void setDataHora(Timestamp data) {
        this.data = data;
    }

    public Repertório getRepertório() {
        return repertório;
    }

    public void setRepertório(Repertório repertório) {
        this.repertório = repertório;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }

    public ApresentaçãoMusical getVisão() {
        return new ApresentaçãoMusical(sequencial, repertório, maestro, nacional);
    }

    public String toString() {
        return "[" + sequencial + "] Apresentação: " + repertório.getVisão() + " - " + maestro.getVisão()
                + " - Nacional: " + (nacional ? "Sim" : "Não");
    }

    public String toStringFull() {
        String str = "[" + sequencial + "] Apresentação: \nData: " + formatarDataHora(data.toString())
                +  " - " +(isNacional() ? "Nacional" : "Externa") 
                + " -- " + repertório.toStringFull()
                + " - Maestro: " + maestro.toStringFull() + "\n - Peça: ";
        PeçaMusical[] peças_repertório = Interpretação.buscarPeçasRepertório(repertório.getSequencial());
        for (PeçaMusical peça : peças_repertório) {
            str += peça.toStringFull();
        }
        return str;
    }

    // juntar esse metodo com o de cima
    // public ArrayList<String> buscarPeçasMusicais() {
    // String sql = "SELECT PeçaMusicalId FROM Interpretações WHERE RepertórioId =
    // ?";
    // ResultSet lista_resultados = null;
    // ArrayList<String> peças_musicais = new ArrayList<>();
    // try {
    // PreparedStatement comando = BD.conexão.prepareStatement(sql);
    // comando.setInt(1, this.repertório.getSequencial());
    // lista_resultados = comando.executeQuery();
    // while (lista_resultados.next()) {
    // peças_musicais.add(lista_resultados.getString("PeçaMusicalId"));
    // }
    // lista_resultados.close();
    // comando.close();
    // } catch (SQLException exceção_sql) {
    // exceção_sql.printStackTrace();
    // }
    // return peças_musicais;
    // }

}