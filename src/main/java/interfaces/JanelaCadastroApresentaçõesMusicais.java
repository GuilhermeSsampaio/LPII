/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import controle.ControladorCadastroApresentaçõesMusicais;
import controle.ControladorCadastroInterpretaçõesRepertório;
import entidade.ApresentaçãoMusical;
import entidade.Maestro;
import entidade.Repertório;

/**
 *
 * @author guilh
 */
public class JanelaCadastroApresentaçõesMusicais extends javax.swing.JFrame {
    
    ControladorCadastroApresentaçõesMusicais controlador;
    DefaultListModel modelo_lista_apresentações_musicais;
    Maestro[] maestros_cadastrados;
    Repertório[] repertórios_cadastrados;
    
    /**
     * Creates new form JanelaCadastroApresentaçõesMusicais
     */
    public JanelaCadastroApresentaçõesMusicais(ControladorCadastroApresentaçõesMusicais controlador) {
        this.controlador = controlador;
        maestros_cadastrados = Maestro.getVisões();
        repertórios_cadastrados = Repertório.getVisões();
        initComponents();
        inicializarListaApresentaçõesMusicais();
        limparCampos(null);

    }

    private void inicializarListaApresentaçõesMusicais(){
        modelo_lista_apresentações_musicais = (DefaultListModel) apresentações_musicaisList.getModel();
        ApresentaçãoMusical[] visões = ApresentaçãoMusical.getVisões();
        for(ApresentaçãoMusical visão : visões){
            modelo_lista_apresentações_musicais.addElement(visão);
        }
    }

    private ApresentaçãoMusical obtémApresentaçãoMusicalInformada(){
        String sequencial_str = sequencialTextField.getText();
        int sequencial= 0;
        if(!sequencial_str.isEmpty()){
            sequencial = Integer.parseInt(sequencial_str);
        }
        Maestro visão_maestro = (Maestro) maestros_cadastradosComboBox.getSelectedItem();
        if(visão_maestro == null){
            return null;
        }
        Repertório visão_repertório = (Repertório) repertórios_cadastradosComboBox.getSelectedItem();
        if(visão_repertório == null){
            return null;
        }
       Timestamp data_hora = new Timestamp(Calendar.getInstance().getTimeInMillis());
        return new ApresentaçãoMusical(sequencial, data_hora,visão_repertório, visão_maestro);
    }

     private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        apresentaçõesLabel = new javax.swing.JLabel();
        apresentações_musicaisScrollPane = new javax.swing.JScrollPane();
        apresentações_musicaisList = new javax.swing.JList();
        ordem_apresentaçõesLabel = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        maestros_cadastradosLabel = new javax.swing.JLabel();
        maestros_cadastradosComboBox = new javax.swing.JComboBox<>();
        repertório_cadastradosLabel = new javax.swing.JLabel();
        repertórios_cadastradosComboBox = new javax.swing.JComboBox<>();
        data_hora_label = new javax.swing.JLabel();
        data_horaTextField = new javax.swing.JTextField();
        botõesPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        LimparButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        apresentaçõesLabel.setText("Apresentações Cadastradas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 6, 0, 0);
        getContentPane().add(apresentaçõesLabel, gridBagConstraints);

        apresentações_musicaisList.setModel(new DefaultListModel()
        );
        apresentações_musicaisScrollPane.setViewportView(apresentações_musicaisList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 57;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(29, 12, 0, 0);
        getContentPane().add(apresentações_musicaisScrollPane, gridBagConstraints);

        ordem_apresentaçõesLabel.setText("Ordem da apresentação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 22, 0, 0);
        getContentPane().add(ordem_apresentaçõesLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 12, 0, 0);
        getContentPane().add(sequencialTextField, gridBagConstraints);

        maestros_cadastradosLabel.setText("Maestros cadastrados:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 34, 0, 0);
        getContentPane().add(maestros_cadastradosLabel, gridBagConstraints);

        maestros_cadastradosComboBox.setModel(new DefaultComboBoxModel(maestros_cadastrados));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        getContentPane().add(maestros_cadastradosComboBox, gridBagConstraints);

        repertório_cadastradosLabel.setText("Repertórios cadastrados:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        getContentPane().add(repertório_cadastradosLabel, gridBagConstraints);

        repertórios_cadastradosComboBox.setModel(new DefaultComboBoxModel(repertórios_cadastrados));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        getContentPane().add(repertórios_cadastradosComboBox, gridBagConstraints);

        data_hora_label.setText("Data e hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 87, 0, 0);
        getContentPane().add(data_hora_label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        getContentPane().add(data_horaTextField, gridBagConstraints);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirApresentaçãoMusical(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarApresentaçãoMusical(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerApresentaçãoMusical(evt);
            }
        });

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarApresentaçãoMusical(evt);
            }
        });

        LimparButton.setText("Limpar");
        LimparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        javax.swing.GroupLayout botõesPanelLayout = new javax.swing.GroupLayout(botõesPanel);
        botõesPanel.setLayout(botõesPanelLayout);
        botõesPanelLayout.setHorizontalGroup(
            botõesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botõesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inserirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LimparButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botõesPanelLayout.setVerticalGroup(
            botõesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botõesPanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(botõesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserirButton)
                    .addComponent(consultarButton)
                    .addComponent(removerButton)
                    .addComponent(alterarButton)
                    .addComponent(LimparButton))
                .addGap(23, 23, 23))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 22, 6, 20);
        getContentPane().add(botõesPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirApresentaçãoMusical
        // TODO add your handling code here:
        ApresentaçãoMusical apresentação_musical = obtémApresentaçãoMusicalInformada();
        String mensagem_erro = null;
        if(apresentação_musical != null){
            mensagem_erro = controlador.inserirApresentaçãoMusical(apresentação_musical);
        }
        else{
            mensagem_erro = "Algum atributo da apresentação não foi informado";
        }
        if(mensagem_erro != null){
            int sequencial = ApresentaçãoMusical.últimoSequencial();
            apresentação_musical.setSequencial(sequencial);
            modelo_lista_apresentações_musicais.addElement(apresentação_musical.getVisão());
            apresentações_musicaisList.setSelectedIndex(modelo_lista_apresentações_musicais.size() - 1); //mudar a var apresentacoes para cadastradas
            sequencialTextField.setText("" + sequencial);
            data_horaTextField.setText(ApresentaçãoMusical.formatarDataHora(apresentação_musical.getDataHora().toString()));

        }else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirApresentaçãoMusical

    private void consultarApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarApresentaçãoMusical
        ApresentaçãoMusical visão_Apresentação_musical = (ApresentaçãoMusical) apresentações_musicaisList.getSelectedValue();
        ApresentaçãoMusical apresentação_musical = null;
        String mensagem_erro = null;
        if(visão_Apresentação_musical != null){
            apresentação_musical = ApresentaçãoMusical.buscarApresentaçãoMusical(visão_Apresentação_musical.getSequencial());
            if(apresentação_musical == null)
                mensagem_erro = "Apresentação musical não cadastrada";
        } else{
            mensagem_erro = "Nenhuma apresentação selecionada";
        }

        if(mensagem_erro == null){
            sequencialTextField.setText(apresentação_musical.getSequencial() + "");
            data_horaTextField.setText(ApresentaçãoMusical.formatarDataHora(apresentação_musical.getDataHora().toString()));
            maestros_cadastradosComboBox.setSelectedItem(apresentação_musical.getMaestro());
            repertórios_cadastradosComboBox.setSelectedItem(apresentação_musical.getRepertório());
        }
        else{
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarApresentaçãoMusical

    private void removerApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerApresentaçãoMusical
        // TODO add your handling code here:
    }//GEN-LAST:event_removerApresentaçãoMusical

    private void alterarApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarApresentaçãoMusical
        ApresentaçãoMusical apresentação_musical = obtémApresentaçãoMusicalInformada();
        String mensagem_erro = null;
        if(apresentação_musical != null){
            mensagem_erro = controlador.alterarApresentaçãoMusical(apresentação_musical);
        }
        else{
            mensagem_erro = "Algum atributo da apresentação não foi informado";
        }
    if(mensagem_erro != null){
        informarErro(mensagem_erro);
    }
    }//GEN-LAST:event_alterarApresentaçãoMusical

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        sequencialTextField.setText("");
        data_horaTextField.setText("");
        maestros_cadastradosComboBox.setSelectedIndex(-1);
        repertórios_cadastradosComboBox.setSelectedIndex(-1);
        
    }//GEN-LAST:event_limparCampos

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LimparButton;
    private javax.swing.JButton alterarButton;
    private javax.swing.JLabel apresentaçõesLabel;
    private javax.swing.JList apresentações_musicaisList;
    private javax.swing.JScrollPane apresentações_musicaisScrollPane;
    private javax.swing.JPanel botõesPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JTextField data_horaTextField;
    private javax.swing.JLabel data_hora_label;
    private javax.swing.JButton inserirButton;
    private javax.swing.JComboBox<String> maestros_cadastradosComboBox;
    private javax.swing.JLabel maestros_cadastradosLabel;
    private javax.swing.JLabel ordem_apresentaçõesLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel repertório_cadastradosLabel;
    private javax.swing.JComboBox<String> repertórios_cadastradosComboBox;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
