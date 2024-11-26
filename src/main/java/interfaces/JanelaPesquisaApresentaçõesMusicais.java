/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import entidade.ApresentaçãoMusical;
import entidade.PeçaMusical;
import entidade.PeçaMusicalPopular.EstiloMúsicaPopular;

/**
 *
 * @author guilh
 */
public class JanelaPesquisaApresentaçõesMusicais extends javax.swing.JFrame {
    PainelFiltrosPeçaMusicalClássica filtros_peça_musical_clássica;
    PainelFiltrosPeçaMusicalPopular filtros_peça_musical_popular;

    /**
     * Creates new form JanelaPesquisaApresentaçõesMusicais
     */
    public JanelaPesquisaApresentaçõesMusicais() {
        initComponents();
        filtros_peça_musical_clássica = new PainelFiltrosPeçaMusicalClássica();
        filtros_peça_musical_popular = new PainelFiltrosPeçaMusicalPopular();
        filtros_especificos_peça_musicalTabbedPane.addTab("Clássica", filtros_peça_musical_clássica);
        filtros_especificos_peça_musicalTabbedPane.addTab("Popular", filtros_peça_musical_popular);
        limparFiltros(null);
    }

    // private Timestamp getDataMínima(){
    // Timestamp data_mínima = null;
    // String data_mínima_str = data_montagemRepertórioTextField.getText();
    // if(!data_mínima_str.isEmpty()){
    // String[] data_mínima_partes = data_mínima_str.toString().split("/");
    // String dia = data_mínima_partes[0];
    // String mes = data_mínima_partes[1];
    // String ano = data_mínima_partes[2];
    // if((dia.length() == 2) && (mes.length() == 2) && (ano.length() == 4)){
    // data_mínima_str = ano + "-" + mes + "-" + dia + " 00:00:00";
    // data_mínima = Timestamp.valueOf(data_mínima_str);
    // }
    // }
    // return data_mínima;
    // }

   

    private Boolean getTipoApresentação() {
        Boolean tipo_apresentação = null;
        if (nacional_simButton.isSelected()) {
            tipo_apresentação = true;
        } else if (nacional_nãoButton.isSelected()) {
            tipo_apresentação = false;
        }
        return tipo_apresentação;
    }

    private String getPrefixoRepertório() {
        return prefixoRepertórioTextField.getText();
    }

    private void mostrarApresentaçõesMusicaisSelecionadas(ArrayList<ApresentaçãoMusical> apresentações_musicais) {
        pesquisasTextArea.setText(""); // Limpar a área de texto antes de adicionar novos resultados
        boolean primeira_apresentação_musical = true;
        for (ApresentaçãoMusical apresentação_musical : apresentações_musicais) {
            if (primeira_apresentação_musical) {
                pesquisasTextArea.append(apresentação_musical.toStringFull());
                primeira_apresentação_musical = false;
            } else {
                pesquisasTextArea.append("\n" + apresentação_musical.toStringFull());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estrangeiroButtonGroup = new javax.swing.ButtonGroup();
        nacionalidadApresentaçãoButtonGroup = new javax.swing.ButtonGroup();
        filtros_maestrosPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sim_estrangeiroButton = new javax.swing.JRadioButton();
        não_estrangeiroButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        filtros_repertóriosPanel = new javax.swing.JPanel();
        data_minima_montagemLabel = new javax.swing.JLabel();
        prefixoRepertórioTextField = new javax.swing.JTextField();
        filtros_apresentações_musicaisPanel = new javax.swing.JPanel();
        estilo_apresentaçãoPanel = new javax.swing.JPanel();
        nacional_simButton = new javax.swing.JRadioButton();
        nacional_nãoButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        apresentaçoes_musicais_seleciondasPanel = new javax.swing.JPanel();
        apresentações_musicais_seleciondasScrollPane = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        comandosPanel = new javax.swing.JPanel();
        pesquisarButton = new javax.swing.JButton();
        limpar_filtrosButton = new javax.swing.JButton();
        limpa_pesquisaButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        data_minima_apresentação_musicalLabel1 = new javax.swing.JLabel();
        duração_mínima_peça_musicalTextField = new javax.swing.JTextField();
        filtros_especificos_peça_musicalTabbedPane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        todas_peças_musicais_repertorioCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Apresentações Musicais");
        setPreferredSize(new java.awt.Dimension(900, 890));

        filtros_maestrosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Maestros"));
        filtros_maestrosPanel.setToolTipText("Filtros de Maestros");
        filtros_maestrosPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        estrangeiroButtonGroup.add(sim_estrangeiroButton);
        sim_estrangeiroButton.setText("Sim");

        estrangeiroButtonGroup.add(não_estrangeiroButton);
        não_estrangeiroButton.setMnemonic('\u0001');
        não_estrangeiroButton.setText("Não");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sim_estrangeiroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(não_estrangeiroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sim_estrangeiroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(não_estrangeiroButton))
                .addGap(15, 15, 15))
        );

        jLabel1.setText("Estrangeiro");

        javax.swing.GroupLayout filtros_maestrosPanelLayout = new javax.swing.GroupLayout(filtros_maestrosPanel);
        filtros_maestrosPanel.setLayout(filtros_maestrosPanelLayout);
        filtros_maestrosPanelLayout.setHorizontalGroup(
            filtros_maestrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_maestrosPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtros_maestrosPanelLayout.setVerticalGroup(
            filtros_maestrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_maestrosPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1))
            .addGroup(filtros_maestrosPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        filtros_repertóriosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Repertórios"));

        data_minima_montagemLabel.setText("Prefixo do repertório");

        javax.swing.GroupLayout filtros_repertóriosPanelLayout = new javax.swing.GroupLayout(filtros_repertóriosPanel);
        filtros_repertóriosPanel.setLayout(filtros_repertóriosPanelLayout);
        filtros_repertóriosPanelLayout.setHorizontalGroup(
            filtros_repertóriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_repertóriosPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(data_minima_montagemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prefixoRepertórioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtros_repertóriosPanelLayout.setVerticalGroup(
            filtros_repertóriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_repertóriosPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(filtros_repertóriosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data_minima_montagemLabel)
                    .addComponent(prefixoRepertórioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filtros_apresentações_musicaisPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Apresentações Musicais"));

        nacionalidadApresentaçãoButtonGroup.add(nacional_simButton);
        nacional_simButton.setText("Sim");

        nacionalidadApresentaçãoButtonGroup.add(nacional_nãoButton);
        nacional_nãoButton.setMnemonic('\u0001');
        nacional_nãoButton.setText("Não");

        javax.swing.GroupLayout estilo_apresentaçãoPanelLayout = new javax.swing.GroupLayout(estilo_apresentaçãoPanel);
        estilo_apresentaçãoPanel.setLayout(estilo_apresentaçãoPanelLayout);
        estilo_apresentaçãoPanelLayout.setHorizontalGroup(
            estilo_apresentaçãoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estilo_apresentaçãoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nacional_simButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nacional_nãoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        estilo_apresentaçãoPanelLayout.setVerticalGroup(
            estilo_apresentaçãoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estilo_apresentaçãoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(estilo_apresentaçãoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacional_simButton)
                    .addComponent(nacional_nãoButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel2.setText("Nacional:");

        javax.swing.GroupLayout filtros_apresentações_musicaisPanelLayout = new javax.swing.GroupLayout(filtros_apresentações_musicaisPanel);
        filtros_apresentações_musicaisPanel.setLayout(filtros_apresentações_musicaisPanelLayout);
        filtros_apresentações_musicaisPanelLayout.setHorizontalGroup(
            filtros_apresentações_musicaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_apresentações_musicaisPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(filtros_apresentações_musicaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estilo_apresentaçãoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        filtros_apresentações_musicaisPanelLayout.setVerticalGroup(
            filtros_apresentações_musicaisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_apresentações_musicaisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estilo_apresentaçãoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        apresentaçoes_musicais_seleciondasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Apresentações Musicais Selecionadas"));

        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        apresentações_musicais_seleciondasScrollPane.setViewportView(pesquisasTextArea);

        pesquisarButton.setText("Pesquisar");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarApresentaçõesMusicais(evt);
            }
        });

        limpar_filtrosButton.setText("Limpar Filtros");
        limpar_filtrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });

        limpa_pesquisaButton.setText("Limpar Pesquisa");
        limpa_pesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparPesquisa(evt);
            }
        });

        javax.swing.GroupLayout comandosPanelLayout = new javax.swing.GroupLayout(comandosPanel);
        comandosPanel.setLayout(comandosPanelLayout);
        comandosPanelLayout.setHorizontalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comandosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(limpar_filtrosButton)
                .addGap(18, 18, 18)
                .addComponent(limpa_pesquisaButton)
                .addGap(17, 17, 17))
        );
        comandosPanelLayout.setVerticalGroup(
            comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comandosPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(comandosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarButton)
                    .addComponent(limpar_filtrosButton)
                    .addComponent(limpa_pesquisaButton))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout apresentaçoes_musicais_seleciondasPanelLayout = new javax.swing.GroupLayout(apresentaçoes_musicais_seleciondasPanel);
        apresentaçoes_musicais_seleciondasPanel.setLayout(apresentaçoes_musicais_seleciondasPanelLayout);
        apresentaçoes_musicais_seleciondasPanelLayout.setHorizontalGroup(
            apresentaçoes_musicais_seleciondasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apresentaçoes_musicais_seleciondasPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(apresentações_musicais_seleciondasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(apresentaçoes_musicais_seleciondasPanelLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        apresentaçoes_musicais_seleciondasPanelLayout.setVerticalGroup(
            apresentaçoes_musicais_seleciondasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apresentaçoes_musicais_seleciondasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apresentações_musicais_seleciondasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Peças Musicais"));
        jPanel1.setToolTipText("Filtros de Peças Musicais");

        data_minima_apresentação_musicalLabel1.setText("Duração mínima da Peça:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Abrangência dos Filtros"));

        todas_peças_musicais_repertorioCheckBox.setText("Todas as peças do repertório");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(todas_peças_musicais_repertorioCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(todas_peças_musicais_repertorioCheckBox)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(data_minima_apresentação_musicalLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duração_mínima_peça_musicalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filtros_especificos_peça_musicalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(data_minima_apresentação_musicalLabel1)
                            .addComponent(duração_mínima_peça_musicalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filtros_especificos_peça_musicalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(filtros_maestrosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filtros_repertóriosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addComponent(filtros_apresentações_musicaisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(apresentaçoes_musicais_seleciondasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtros_maestrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtros_repertóriosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(filtros_apresentações_musicaisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apresentaçoes_musicais_seleciondasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void limparPesquisa(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_limparPesquisa
        pesquisasTextArea.setText("");
    }// GEN-LAST:event_limparPesquisa

    private void pesquisarApresentaçõesMusicais(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pesquisarApresentaçõesMusicais
        Boolean maestro_estrangeiro = null;
        if (sim_estrangeiroButton.isSelected()) {
            maestro_estrangeiro = true;
        } else if (não_estrangeiroButton.isSelected()) {
            maestro_estrangeiro = false;
        }
        
        Boolean tipo_apresentação = getTipoApresentação();
        String prefixo_repertório = getPrefixoRepertório();
        int duração_mínima_peça_musical = -1;
        if(!duração_mínima_peça_musicalTextField.getText().isEmpty()){
            duração_mínima_peça_musical = Integer.parseInt(duração_mínima_peça_musicalTextField.getText());
        }
        boolean todas_peças_repertório = todas_peças_musicais_repertorioCheckBox.isSelected();
        int indice_aba_selecionada = filtros_especificos_peça_musicalTabbedPane.getSelectedIndex();
        char muito_conhecida = 'X';
        EstiloMúsicaPopular estilo_musica_popular = null;
        if (indice_aba_selecionada == 0) {
            muito_conhecida = filtros_peça_musical_clássica.getMuitoConhecida();
        } else if (indice_aba_selecionada == 1) {
            estilo_musica_popular = filtros_peça_musical_popular.getEstiloMúsicaPopular();
        }

        ArrayList<ApresentaçãoMusical> apresentações = ApresentaçãoMusical.pesquisarApresentaçõesMusicais(
            tipo_apresentação,
            prefixo_repertório,
            maestro_estrangeiro,
            muito_conhecida,
            estilo_musica_popular,
            duração_mínima_peça_musical,
            todas_peças_repertório
        );
        System.out.println(apresentações);
        mostrarApresentaçõesMusicaisSelecionadas(apresentações);
    }// GEN-LAST:event_pesquisarApresentaçõesMusicais

    private void limparFiltros(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_limparFiltros
        estrangeiroButtonGroup.clearSelection();
        prefixoRepertórioTextField.setText("");
        duração_mínima_peça_musicalTextField.setText("");
        filtros_peça_musical_clássica.limparFiltros();
        filtros_peça_musical_popular.limparFiltros();
        nacionalidadApresentaçãoButtonGroup.clearSelection();
        todas_peças_musicais_repertorioCheckBox.setSelected(false);
    }// GEN-LAST:event_limparFiltros

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel apresentaçoes_musicais_seleciondasPanel;
    private javax.swing.JScrollPane apresentações_musicais_seleciondasScrollPane;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JLabel data_minima_apresentação_musicalLabel1;
    private javax.swing.JLabel data_minima_montagemLabel;
    private javax.swing.JTextField duração_mínima_peça_musicalTextField;
    private javax.swing.JPanel estilo_apresentaçãoPanel;
    private javax.swing.ButtonGroup estrangeiroButtonGroup;
    private javax.swing.JPanel filtros_apresentações_musicaisPanel;
    private javax.swing.JTabbedPane filtros_especificos_peça_musicalTabbedPane;
    private javax.swing.JPanel filtros_maestrosPanel;
    private javax.swing.JPanel filtros_repertóriosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton limpa_pesquisaButton;
    private javax.swing.JButton limpar_filtrosButton;
    private javax.swing.JRadioButton nacional_nãoButton;
    private javax.swing.JRadioButton nacional_simButton;
    private javax.swing.ButtonGroup nacionalidadApresentaçãoButtonGroup;
    private javax.swing.JRadioButton não_estrangeiroButton;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.JTextField prefixoRepertórioTextField;
    private javax.swing.JRadioButton sim_estrangeiroButton;
    private javax.swing.JCheckBox todas_peças_musicais_repertorioCheckBox;
    // End of variables declaration//GEN-END:variables
}
