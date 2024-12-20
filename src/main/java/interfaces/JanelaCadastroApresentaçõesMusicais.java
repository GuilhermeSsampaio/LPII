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
        modelo_lista_apresentações_musicais = (DefaultListModel) apresentações_musicais_cadastradasList.getModel();
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
        boolean nacional = nacionalCheckBox.isSelected();
        return new ApresentaçãoMusical(sequencial, data_hora,visão_repertório, visão_maestro, nacional);
    }

     private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

        private Maestro getVisãoMaestroSelecionado(ApresentaçãoMusical apresentaçãoMusical) {
        String chave_maestro = apresentaçãoMusical.getMaestro().getNome();
        for (Maestro visão_maestro : maestros_cadastrados) {
            if (visão_maestro.getNome().equals(chave_maestro)) {
                return visão_maestro;
            }
        }
        return null;
    }

        private Repertório getVisãoRepertórioSelecionado(ApresentaçãoMusical apresentaçãoMusical) {
        int chave_repertório = apresentaçãoMusical.getRepertório().getSequencial();
        for (Repertório visão_repertório : repertórios_cadastrados) {
            if (visão_repertório.getSequencial() == chave_repertório) {
                return visão_repertório;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        apresentaçõesLabel = new javax.swing.JLabel();
        apresentações_musicaisScrollPane = new javax.swing.JScrollPane();
        apresentações_musicais_cadastradasList = new javax.swing.JList();
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
        nacionalCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Apresentações Musicais");

        apresentaçõesLabel.setText("Apresentações Cadastradas:");

        apresentações_musicais_cadastradasList.setModel(new DefaultListModel()
        );
        apresentações_musicaisScrollPane.setViewportView(apresentações_musicais_cadastradasList);

        ordem_apresentaçõesLabel.setText("Ordem da apresentação:");

        sequencialTextField.setEditable(false);
        sequencialTextField.setColumns(50);
        sequencialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequencialTextFieldActionPerformed(evt);
            }
        });

        maestros_cadastradosLabel.setText("Maestros cadastrados:");

        maestros_cadastradosComboBox.setModel(new DefaultComboBoxModel(maestros_cadastrados));

        repertório_cadastradosLabel.setText("Repertórios cadastrados:");

        repertórios_cadastradosComboBox.setModel(new DefaultComboBoxModel(repertórios_cadastrados));

        data_hora_label.setText("Data e hora:");

        data_horaTextField.setColumns(50);

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
                .addContainerGap(15, Short.MAX_VALUE))
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

        nacionalCheckBox.setText("Nacional");
        nacionalCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nacionalCheckBox.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(apresentaçõesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apresentações_musicaisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ordem_apresentaçõesLabel)
                                .addGap(12, 12, 12)
                                .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maestros_cadastradosLabel)
                                        .addGap(12, 12, 12)
                                        .addComponent(maestros_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(repertório_cadastradosLabel)
                                        .addGap(12, 12, 12)
                                        .addComponent(repertórios_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(data_hora_label)
                                        .addGap(12, 12, 12)
                                        .addComponent(data_horaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(botõesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(nacionalCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apresentações_musicaisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addComponent(apresentaçõesLabel)
                        .addGap(49, 49, 49)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(ordem_apresentaçõesLabel))
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(maestros_cadastradosLabel))
                    .addComponent(maestros_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(repertório_cadastradosLabel))
                    .addComponent(repertórios_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data_hora_label)
                    .addComponent(data_horaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nacionalCheckBox)
                .addGap(5, 5, 5)
                .addComponent(botõesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
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
        if (mensagem_erro == null) {
            int sequencial = ApresentaçãoMusical.últimoSequencial();
            apresentação_musical.setSequencial(sequencial);
            modelo_lista_apresentações_musicais.addElement(apresentação_musical.getVisão());
            apresentações_musicais_cadastradasList.setSelectedIndex(modelo_lista_apresentações_musicais.size() - 1); //mudar a var apresentacoes para cadastradas
            sequencialTextField.setText("" + sequencial);
            data_horaTextField.setText(ApresentaçãoMusical.formatarDataHora(apresentação_musical.getDataHora().toString()));

        }else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirApresentaçãoMusical

    private void consultarApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarApresentaçãoMusical
        ApresentaçãoMusical visão_Apresentação_musical = (ApresentaçãoMusical) apresentações_musicais_cadastradasList.getSelectedValue();
        ApresentaçãoMusical apresentação_musical = null;
        String mensagem_erro = null;
    
        if (visão_Apresentação_musical != null) {
            apresentação_musical = ApresentaçãoMusical.buscarApresentaçãoMusical(visão_Apresentação_musical.getSequencial());
            if (apresentação_musical == null) {
                mensagem_erro = "Apresentação musical não cadastrada";
            }
        } else {
            mensagem_erro = "Nenhuma apresentação selecionada";
        }
    
        if (mensagem_erro == null) {
            sequencialTextField.setText(apresentação_musical.getSequencial() + "");
            data_horaTextField.setText(ApresentaçãoMusical.formatarDataHora(apresentação_musical.getDataHora().toString()));
            maestros_cadastradosComboBox.setSelectedItem(getVisãoMaestroSelecionado(apresentação_musical));
            repertórios_cadastradosComboBox.setSelectedItem(getVisãoRepertórioSelecionado(apresentação_musical));
            nacionalCheckBox.setSelected(apresentação_musical.isNacional());
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarApresentaçãoMusical

    private void removerApresentaçãoMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerApresentaçãoMusical
        ApresentaçãoMusical visão = (ApresentaçãoMusical) apresentações_musicais_cadastradasList.getSelectedValue();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerApresentaçãoMusical(visão.getSequencial());
        } else {
            mensagem_erro = "Nenhuma apresentação selecionada";
        }
        if (mensagem_erro == null) {
            modelo_lista_apresentações_musicais.removeElement(visão);
        } else {
            informarErro(mensagem_erro);
        }
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
        nacionalCheckBox.setSelected(false);
    }//GEN-LAST:event_limparCampos

    private void sequencialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequencialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sequencialTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LimparButton;
    private javax.swing.JButton alterarButton;
    private javax.swing.JLabel apresentaçõesLabel;
    private javax.swing.JScrollPane apresentações_musicaisScrollPane;
    private javax.swing.JList apresentações_musicais_cadastradasList;
    private javax.swing.JPanel botõesPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JTextField data_horaTextField;
    private javax.swing.JLabel data_hora_label;
    private javax.swing.JButton inserirButton;
    private javax.swing.JComboBox<String> maestros_cadastradosComboBox;
    private javax.swing.JLabel maestros_cadastradosLabel;
    private javax.swing.JCheckBox nacionalCheckBox;
    private javax.swing.JLabel ordem_apresentaçõesLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel repertório_cadastradosLabel;
    private javax.swing.JComboBox<String> repertórios_cadastradosComboBox;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
