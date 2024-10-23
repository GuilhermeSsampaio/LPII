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

import entidade.Maestro;
import entidade.Repertório;
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
    
    public ApresentaçãoMusical(int sequencial, Timestamp data, Repertório repertório, Maestro maestro){
        this.sequencial = sequencial;
        this.data = data;
        this.repertório = repertório;
        this.maestro = maestro;
    }

    public ApresentaçãoMusical(int sequencial, Repertório repertório, Maestro maestro) {
        this.sequencial = sequencial;
        this.repertório = repertório;
        this.maestro = maestro;
    }

    public static ApresentaçãoMusical[] getVisões (){
        String sql = "SELECT Sequencial, RepertórioId, MaestroId from ApresentaçõesMusicais";
        ResultSet lista_resultados = null;
        ArrayList<ApresentaçãoMusical> visões = new ArrayList();
        try{
            PreparedStatement comando  = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                visões.add(new ApresentaçãoMusical(lista_resultados.getInt("Sequencial"), 
                Repertório.buscarRepertório(lista_resultados.getInt("RepertórioId")).getVisão(),
                Maestro.buscarMaestro(lista_resultados.getString("MaestroId")).getVisão()));
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return visões.toArray(new ApresentaçãoMusical[visões.size()]);
    }

    public static boolean existeApresentaçãoMusical(String chave_maestro, int chave_repertório){
        String sql = "SELECT Sequencial from ApresentaçõesMusicais where MaestroId = ? and RepertórioId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, chave_maestro);
            comando.setInt(2, chave_repertório);
            lista_resultados = comando.executeQuery();
            if(lista_resultados.next()){
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static boolean existeApresentaçãoMusical(int sequencial){
        String sql = "SELECT COUNT(Sequencial) from ApresentaçõesMusicais where Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                    existe = true;
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return existe;
    }

    public static int últimoSequencial(){
        String sql = "SELECT MAX(Sequencial) from ApresentaçõesMusicais";
        ResultSet lista_resultados = null;
        int último_sequencial = 0;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            if(lista_resultados.next()){
                último_sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return último_sequencial;
    }

    public static String inserirApresentaçãoMusical(ApresentaçãoMusical apresentaçãoMusical){
        String sql = "INSERT INTO ApresentaçõesMusicais (DataHora,RepertórioId, MaestroId) VALUES (?,?, ?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setTimestamp(1, apresentaçãoMusical.getDataHora());
            comando.setInt(2, apresentaçãoMusical.repertório.getSequencial());
            comando.setString(3, apresentaçãoMusical.maestro.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao inserir apresentação musical";
        }
    }

    public static String alterarApresentaçãoMusical(ApresentaçãoMusical apresentaçãoMusical){
        String sql = "UPDATE ApresentaçõesMusicais SET DataHora = ? WHERE Sequencial = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setTimestamp(1, apresentaçãoMusical.getDataHora());
            comando.setInt(2, apresentaçãoMusical.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar apresentação musical no BD";
        }
    }

    public static String removerApresentaçãoMusical(int sequencial){
        String sql = "DELETE FROM ApresentaçõesMusicais WHERE Sequencial = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao remover apresentação musical";
        }
        return "Apresentação musical removida com sucesso";
    }

    public static ApresentaçãoMusical buscarApresentaçãoMusical(int sequencial){
        String sql = "SELECT * from ApresentaçõesMusicais where Sequencial = ?";
        ResultSet lista_resultados = null;
        ApresentaçãoMusical apresentação_musical = null;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            if(lista_resultados.next()){
                apresentação_musical = new ApresentaçãoMusical(sequencial, 
                lista_resultados.getTimestamp("DataHora"),
                Repertório.buscarRepertório(lista_resultados.getInt("RepertórioId")).getVisão(),
                Maestro.buscarMaestro(lista_resultados.getString("MaestroId")).getVisão());
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            apresentação_musical = null;

        }
        return apresentação_musical;
    }

    public static String formatarDataHora(String data_hora_bd){
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mês_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mês_dia[2] + "/" + ano_mês_dia[1] + "/" + ano_mês_dia[0] + " " + hora_minuto_resto[0] + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }

    public ApresentaçãoMusical(int sequencial){
        this.sequencial = sequencial;
    }

    public int getSequencial(){
        return sequencial;
    }

    public void setSequencial(int sequencial){
        this.sequencial = sequencial;
    }

    public Timestamp getDataHora(){
        return data;
    }

    public void setDataHora(Timestamp data){
        this.data = data;
    }

    public Repertório getRepertório(){
        return repertório;
    }

    public void setRepertório(Repertório repertório){
        this.repertório = repertório;
    }

    public Maestro getMaestro(){
        return maestro;
    }

    public void setMaestro(Maestro maestro){
        this.maestro = maestro;
    }

    public ApresentaçãoMusical getVisão(){
        return new ApresentaçãoMusical(sequencial);
    }

    public String toString(){
        return "[" + sequencial + "] " + repertório.getVisão() + " - " + maestro.getVisão();
    }

    

}
