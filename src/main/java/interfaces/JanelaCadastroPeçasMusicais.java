package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controle.ControladorCadastroPeçasMusicais;
import entidade.PeçaMusical;
import entidade.PeçaMusical.Gênero;
import entidade.PeçaMusicalClássica;
import entidade.PeçaMusicalClássica.EstiloMúsicaClássica;
import entidade.PeçaMusicalPopular;
import entidade.PeçaMusicalPopular.EstiloMúsicaPopular;
import entidade.PeçaMusicalPopular.InstrumentaçãoCaracterística;

public class JanelaCadastroPeçasMusicais extends javax.swing.JFrame {

    public static Gênero converteStringParaGênero(String genero_str) {
        switch (genero_str) {
            case "clássico":
                return Gênero.clássico;
            case "romântico":
                return Gênero.romântico;
            case "jazz":
                return Gênero.jazz;
            case "rock":
                return Gênero.rock;
            case "pop":
                return Gênero.pop;
            case "reggae":
                return Gênero.reggae;
            case "blues":
                return Gênero.blues;
            case "country":
                return Gênero.country;
            case "barroco":
                return Gênero.barroco;
            case "modernismo":
                return Gênero.modernismo;
            case "samba":
                return Gênero.samba;
            default:
                return null;
        }
    }

    ControladorCadastroPeçasMusicais controlador;
    PeçaMusical[] peças_musicais_cadastradas;
    PainelPeçaMusicalClássica peça_musical_clássicaPainel;
    PainelPeçaMusicalPopular peça_musical_popularPainel;

    public JanelaCadastroPeçasMusicais(ControladorCadastroPeçasMusicais controlador) {
        this.controlador = controlador;
        peças_musicais_cadastradas = PeçaMusical.getVisões();
        initComponents();
        peça_musical_clássicaPainel = new PainelPeçaMusicalClássica();
        peça_musical_popularPainel = new PainelPeçaMusicalPopular();
        especialização_peça_musicalTabbedPane.addTab("Peça músical Clássica", peça_musical_clássicaPainel);
        especialização_peça_musicalTabbedPane.addTab("Peça músical Popular", peça_musical_popularPainel);
        limparCampos();
    }

    private void limparCampos() {
        tituloTextField.setText("");
        compositorTextField.setText("");
        duracaoTextField.setText("");
        gêneroButtonGroup.clearSelection();
        tomTextField.setText("");
        peça_musical_clássicaPainel.limparCampos();
        peça_musical_popularPainel.limparCampos();
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private PeçaMusical getVisãoAlterada(String titulo) {
        for (PeçaMusical visão : peças_musicais_cadastradas) {
            if (visão.getTitulo().equals(titulo)) {
                return visão;
            }
        }
        return null;
    }

    private PeçaMusical obterPeçaMusicalInformada() {
        String titulo = tituloTextField.getText();
        if (titulo.isEmpty()) {
            return null;
        }
        String compositor = compositorTextField.getText();
        if (compositor.isEmpty()) {
            return null;
        }
        Gênero gênero = null;
        if (gêneroComboBox.getSelectedItem() != null) {
            gênero = (Gênero) gêneroComboBox.getSelectedItem();
        } else {
            return null;
        }
        String duracao_str = duracaoTextField.getText();
        if (duracao_str.isEmpty()) {
            return null;
        }
        int duracao = Integer.parseInt(duracao_str);
        String tom = tomTextField.getText();
        if (tom.isEmpty()) {
            return null;
        }

        PeçaMusical peça_musical = null;
        int índice_aba_selecionada = especialização_peça_musicalTabbedPane.getSelectedIndex();
        switch (índice_aba_selecionada) {
            case 0:
                EstiloMúsicaClássica estilo_música_clássica = peça_musical_clássicaPainel.getSelectedEstiloMúsicaClássica();
                boolean muito_conhecida = peça_musical_clássicaPainel.isMuitoConhecida();
                peça_musical = new PeçaMusicalClássica(titulo, compositor, duracao, tom, gênero, estilo_música_clássica, muito_conhecida);
                break;
            case 1:
                EstiloMúsicaPopular estilo_música_popular = peça_musical_popularPainel.getSelectedEstiloMúsicaPopular();
                InstrumentaçãoCaracterística instrumentação_característica = peça_musical_popularPainel.getInstrumentaçãoCaracterística();
                peça_musical = new PeçaMusicalPopular(titulo, compositor, duracao, tom, gênero, estilo_música_popular, instrumentação_característica);
                break;
        }
        return peça_musical;
    }

    private void atualizarComboBox() {
        peças_musicais_cadastradas = PeçaMusical.getVisões();
        peças_musicais_cadastradasComboBox.setModel(new DefaultComboBoxModel(peças_musicais_cadastradas));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gêneroButtonGroup = new javax.swing.ButtonGroup();
        peças_musicais_cadastradasLabel = new javax.swing.JLabel();
        peças_musicais_cadastradasComboBox = new javax.swing.JComboBox();
        tituloLabel = new javax.swing.JLabel();
        compositorLabel = new javax.swing.JLabel();
        generoLabel = new javax.swing.JLabel();
        duracaoLabel = new javax.swing.JLabel();
        tomLabel = new javax.swing.JLabel();
        tomTextField = new javax.swing.JTextField();
        tituloTextField = new javax.swing.JTextField();
        compositorTextField = new javax.swing.JTextField();
        duracaoTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        cadastrarButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        gêneroComboBox = new javax.swing.JComboBox();
        especialização_peça_musicalTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Peças");
        setResizable(false);

        peças_musicais_cadastradasLabel.setText("Peças musicais cadastradas:");

        peças_musicais_cadastradasComboBox.setModel(new DefaultComboBoxModel(peças_musicais_cadastradas));

        tituloLabel.setText("Título:");

        compositorLabel.setText("Compositor:");

        generoLabel.setText("Gênero:");

        duracaoLabel.setText("Duração:");

        tomLabel.setText("Tom:");

        tomTextField.setColumns(50);
        tomTextField.setPreferredSize(new java.awt.Dimension(556, 22));

        tituloTextField.setColumns(50);
        tituloTextField.setPreferredSize(new java.awt.Dimension(556, 22));

        compositorTextField.setColumns(50);
        compositorTextField.setPreferredSize(new java.awt.Dimension(556, 22));

        duracaoTextField.setColumns(50);
        duracaoTextField.setPreferredSize(new java.awt.Dimension(556, 22));

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirPeçaMusical(evt);
            }
        });
        comandosPanel.add(cadastrarButton);

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPeçaMusical(evt);
            }
        });
        comandosPanel.add(consultarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarPeçaMusical(evt);
            }
        });
        comandosPanel.add(alterarButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPeçaMusical(evt);
            }
        });
        comandosPanel.add(removerButton);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });
        comandosPanel.add(limparButton);

        gêneroComboBox.setModel(new DefaultComboBoxModel(Gênero.values()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(tituloLabel)
                        .addGap(1, 1, 1)
                        .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compositorLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(compositorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(generoLabel)
                        .addGap(6, 6, 6)
                        .addComponent(gêneroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(duracaoLabel)
                        .addGap(2, 2, 2)
                        .addComponent(duracaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(tomLabel)
                        .addGap(3, 3, 3)
                        .addComponent(tomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(peças_musicais_cadastradasLabel)
                        .addGap(18, 18, 18)
                        .addComponent(peças_musicais_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 153, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(especialização_peça_musicalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(peças_musicais_cadastradasLabel))
                    .addComponent(peças_musicais_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(tituloLabel))
                    .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(compositorLabel))
                    .addComponent(compositorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(gêneroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(duracaoLabel))
                    .addComponent(duracaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(tomLabel))
                    .addComponent(tomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(especialização_peça_musicalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inserirPeçaMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirPeçaMusical
        PeçaMusical peça_musical = obterPeçaMusicalInformada();
        //System.out.println(peça_musical);
        String mensagem_erro = null;
        if (peça_musical != null) {
            mensagem_erro = controlador.inserirPeçaMusical(peça_musical);
            //informarSucesso("Peça musical inserida com sucesso");

        } else {
            mensagem_erro = "Preencha todos os campos";
        }

        if (mensagem_erro == null) {
            PeçaMusical visão = peça_musical.getVisão();
            peças_musicais_cadastradasComboBox.addItem(visão);
            peças_musicais_cadastradasComboBox.setSelectedItem(visão);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirPeçaMusical

    private void consultarPeçaMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarPeçaMusical
        PeçaMusical visão = (PeçaMusical) peças_musicais_cadastradasComboBox.getSelectedItem();
        PeçaMusical peça_musical = null;
        String mensagem_erro = null;

        if (visão != null) {
            peça_musical = PeçaMusical.buscarPeçaMusical(visão.getTitulo());
            //System.out.println(peça_musical);
            if (peça_musical == null) {
                mensagem_erro = "Peça musical não encontrada";
                informarErro(mensagem_erro); // Informar erro imediatamente se peça não for encontrada
                return;
            }
        } else {
            mensagem_erro = "Selecione uma peça musical, nenhuma foi selecionada";
            informarErro(mensagem_erro); // Informar erro imediatamente se nenhum item for selecionado
            return;
        }
        if (mensagem_erro == null) {
            // Preencher os campos se nenhuma mensagem de erro foi gerada
            tituloTextField.setText(peça_musical.getTitulo());
            compositorTextField.setText(peça_musical.getCompositor());
            gêneroComboBox.setSelectedItem(peça_musical.getGênero());
            duracaoTextField.setText(Integer.toString(peça_musical.getDuracao()));
            tomTextField.setText(peça_musical.getTom());

            // Verificar o tipo da peça musical e configurar os painéis apropriados
            if (peça_musical instanceof PeçaMusicalClássica) {
                especialização_peça_musicalTabbedPane.setSelectedIndex(0);
                PeçaMusicalClássica peça_musical_clássica = (PeçaMusicalClássica) peça_musical;
                peça_musical_clássicaPainel.setEstiloMusicaClássica(peça_musical_clássica.getEstilo_música_clássica().ordinal());
                peça_musical_clássicaPainel.setMuitoConhecida(peça_musical_clássica.isMuito_conhecida());
            } else if (peça_musical instanceof PeçaMusicalPopular) {
                especialização_peça_musicalTabbedPane.setSelectedIndex(1);
                PeçaMusicalPopular peça_musical_popular = (PeçaMusicalPopular) peça_musical;
                peça_musical_popularPainel.setEstiloMusicaPopular(peça_musical_popular.getEstilo_música_popular());
                peça_musical_popularPainel.setInstrumentaçãoCaracterística(peça_musical_popular.getInstrumentação_característica());
            }
        }else informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarPeçaMusical

    private void alterarPeçaMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarPeçaMusical
        PeçaMusical peça_musical = obterPeçaMusicalInformada();
        String mensagem_erro = null;
        if (peça_musical != null) {
            mensagem_erro = controlador.alterarPeçaMusical(peça_musical);
            //informarSucesso("Peça musical alterada com sucesso");
            //atualizarComboBox();
        } else {
            mensagem_erro = "Preencha todos os campos";
        }

        if (mensagem_erro == null) {
            PeçaMusical visão = getVisãoAlterada(peça_musical.getTitulo());
            if (visão != null) {
                visão.setTom(peça_musical.getTom());

                if (peça_musical instanceof PeçaMusicalClássica && visão instanceof PeçaMusicalClássica) {
                    PeçaMusicalClássica peça_musical_clássica = (PeçaMusicalClássica) peça_musical;
                    PeçaMusicalClássica visão_clássica = (PeçaMusicalClássica) visão;
                    visão_clássica.setEstilo_música_clássica(peça_musical_clássica.getEstilo_música_clássica());
                    visão_clássica.setMuito_conhecida(peça_musical_clássica.isMuito_conhecida());
                } else if (peça_musical instanceof PeçaMusicalPopular && visão instanceof PeçaMusicalPopular) {
                    PeçaMusicalPopular peça_musical_popular = (PeçaMusicalPopular) peça_musical;
                    PeçaMusicalPopular visão_popular = (PeçaMusicalPopular) visão;
                    visão_popular.setEstilo_música_popular(peça_musical_popular.getEstilo_música_popular());
                    visão_popular.setInstrumentação_característica(peça_musical_popular.getInstrumentação_característica());
                }
                peças_musicais_cadastradasComboBox.updateUI();
                peças_musicais_cadastradasComboBox.setSelectedItem(visão);
            } else {
                informarErro(mensagem_erro);
            }
        }
    }//GEN-LAST:event_alterarPeçaMusical

    private void removerPeçaMusical(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPeçaMusical
        PeçaMusical visão = (PeçaMusical) peças_musicais_cadastradasComboBox.getSelectedItem();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerPeçaMusical(visão.getTitulo());
            //informarSucesso("Peça musical removida com sucesso");
        } else {
            mensagem_erro = "Selecione uma peça musical, nenhuma foi selecionada";
        }

        if (mensagem_erro == null) {
            peças_musicais_cadastradasComboBox.removeItem(visão);
            limparCampos();
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerPeçaMusical

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JLabel compositorLabel;
    private javax.swing.JTextField compositorTextField;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel duracaoLabel;
    private javax.swing.JTextField duracaoTextField;
    private javax.swing.JTabbedPane especialização_peça_musicalTabbedPane;
    private javax.swing.JLabel generoLabel;
    private javax.swing.ButtonGroup gêneroButtonGroup;
    private javax.swing.JComboBox gêneroComboBox;
    private javax.swing.JButton limparButton;
    private javax.swing.JComboBox peças_musicais_cadastradasComboBox;
    private javax.swing.JLabel peças_musicais_cadastradasLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JTextField tituloTextField;
    private javax.swing.JLabel tomLabel;
    private javax.swing.JTextField tomTextField;
    // End of variables declaration//GEN-END:variables
}
