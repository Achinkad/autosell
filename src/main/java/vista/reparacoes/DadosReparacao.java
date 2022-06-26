package vista.reparacoes;

import modelo.*;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosReparacao extends JDialog {
    private JPanel painelPrincipal;
    private JButton btnVeiculos;
    private JButton btnClientes;
    private JButton btnFiliais;
    private JButton btnEventos;
    private JButton btnTransacoes;
    private JButton btnReparacoes;
    private JButton btnPecas;
    private JButton btnOficinas;
    private JButton btnArmazens;
    private JButton btnTransportes;
    private JButton btnEstatisticas;
    private JLabel lbVeiculos;
    private JLabel lbOficina;
    private JLabel lbDescricaoTrabalhos;
    private JLabel lbTipoReparacao;
    private JLabel lbServicosExternos;
    private JButton editarButton;
    private JButton cancelarButton;
    private JComboBox cbTipoReparacao;
    private JList listVeiculos;
    private JList listOficinas;
    private JTextPane textDescricaoTrabalhos;
    private JTextPane textServicosExternos;
    private JLabel lbPeca;
    private JList listPecas;
    private JLabel lbQuantidadePeca;
    private JTextField textQuantidadePeca;
    private JLabel lbDataRececao;
    private JTextField textDataRececao;
    private JLabel lbDataEntrega;
    private JTextField textDataEntrega;

    private MenuAux menuAux;

    private Reparacao reparacaoAtual;

    private Oficina oficinaSelecionada;
    private Veiculo veiculoSelecionado;
    private Peca pecaSelecionada;

    LinkedList<Oficina> oficinas;
    LinkedList<Veiculo> veiculos;
    LinkedList<Peca> pecas;

    public DadosReparacao(Reparacao reparacao, boolean isEditavel) {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        reparacaoAtual = reparacao;

        menuAux = new MenuAux();
        LinkedList<JButton> menuItems = new LinkedList<>();
        menuItems.add(btnVeiculos);
        menuItems.add(btnClientes);
        menuItems.add(btnFiliais);
        menuItems.add(btnEventos);
        menuItems.add(btnTransacoes);
        menuItems.add(btnReparacoes);
        menuItems.add(btnPecas);
        menuItems.add(btnOficinas);
        menuItems.add(btnArmazens);
        menuItems.add(btnTransportes);
        menuItems.add(btnEstatisticas);
        menuAux.iniciaMenu(menuItems);

        editarButton.setVisible(false);

        cbTipoReparacao.addItem("Mudança de peças");
        cbTipoReparacao.addItem("Manutenção");
        cbTipoReparacao.addItem("Preparação para venda");

        if (reparacao.getTipoReparacao().toString().equals("Mudança de peças")) {
            cbTipoReparacao.setSelectedItem("Mudança de peças");
        } else if (reparacao.getTipoReparacao().toString().equals("Manutenção")) {
            cbTipoReparacao.setSelectedItem("Manutenção");
        } else {
            cbTipoReparacao.setSelectedItem("Preparação para venda");
        }

        DefaultListModel modelOficinas = new DefaultListModel();
        DefaultListModel modelVeiculos = new DefaultListModel();
        DefaultListModel modelPecas = new DefaultListModel();

        oficinas = DadosApp.getInstancia().getOficinas();
        veiculos = DadosApp.getInstancia().getVeiculos();
        pecas = DadosApp.getInstancia().getPecas();

        for (Oficina oficina : oficinas) {
            listOficinas.setModel(modelOficinas);
            modelOficinas.addElement("Nome: " + oficina.getNome());
        }

        for (Veiculo veiculo : veiculos) {
            listVeiculos.setModel(modelVeiculos);
            modelVeiculos.addElement("Matrícula: " + veiculo.getMatricula() + "     Marca: " + veiculo.getMarca() + "     Modelo: " + veiculo.getModelo());
        }

        for (Peca peca : pecas) {
            listPecas.setModel(modelPecas);
            modelPecas.addElement("Nome: " + peca.getDescricao() + "     Referência: " + peca.getReferencia());
        }

        listOficinas.setSelectedValue(reparacao.getOficina(), true);
        listOficinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listVeiculos.setSelectedValue(reparacao.getVeiculo(), true);
        listVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        LinkedList<LinhaReparacao> linhasReparacao = reparacao.getLinhasReparacao();
        if (linhasReparacao != null) {
            for (LinhaReparacao linhaReparacao : linhasReparacao) {
                listPecas.setSelectedValue(linhaReparacao.getPeca(), true);
                textQuantidadePeca.setText(Float.toString(linhaReparacao.getQuantidade()));
            }
        }

        textDataEntrega.setText(reparacao.getDataEntrega());
        textDataRececao.setText(reparacao.getDataRececao());
        textDescricaoTrabalhos.setText(reparacao.getDescricaoTrabalhos());
        textServicosExternos.setText(reparacao.getServicosExternos());

        if(isEditavel) {
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
        }

        cancelarButton.addActionListener(this::btnCancelarActionListener);

        pack();
        setVisible(true);
    }

    private void btnEditarActionListener(ActionEvent e) {
        String tipoReparacao = cbTipoReparacao.getSelectedItem().toString();
        String dataRececao = textDataRececao.getText();
        String dataEntrega = textDataEntrega.getText();
        String descricaoTrabalhos = textDescricaoTrabalhos.getText();
        String servicosExternos = textServicosExternos.getText();
        float quantidadePecas = (textQuantidadePeca.getText().isEmpty() ? -1 : Float.parseFloat(textQuantidadePeca.getText()));

        if (tipoReparacao == null)
        {
            Erros.mostrarErro(this, 2, Erros.removeLastChar(lbTipoReparacao.getText()));
        }
        else if (!Erros.checkDate(dataRececao))
        {
            Erros.mostrarErro(this, 10, Erros.removeLastChar(lbDataRececao.getText()));
        }
        else if (!Erros.checkDate(dataEntrega))
        {
            Erros.mostrarErro(this, 13, Erros.removeLastChar(lbDataEntrega.getText()));
        }
        else if (descricaoTrabalhos.length() < 2 || descricaoTrabalhos.length() > 255)
        {
            Erros.mostrarErro(this,1, Erros.removeLastChar(lbDescricaoTrabalhos.getText()));
        }
        else if (servicosExternos.length() < 2 || servicosExternos.length() > 255)
        {
            Erros.mostrarErro(this,1, Erros.removeLastChar(lbServicosExternos.getText()));
        }
        else if (quantidadePecas < 1)
        {
            Erros.mostrarErro(this, 4, Erros.removeLastChar(lbQuantidadePeca.getText()));
        }
        else
        {
            TipoReparacao tipoReparacaoEnum = null;
            if (cbTipoReparacao.getSelectedIndex() == 0) {
                tipoReparacaoEnum = TipoReparacao.MUDANCA_PECAS;
            } else if (cbTipoReparacao.getSelectedIndex() == 1) {
                tipoReparacaoEnum = TipoReparacao.MANUNTENCAO;
            } else {
                tipoReparacaoEnum = TipoReparacao.PREPARACAO_PARA_VENDA;
            }

            // Veiculo selecionado
            int indiceVeiculo = listVeiculos.getSelectedIndex();
            veiculoSelecionado = veiculos.get(indiceVeiculo);

            // Oficina selecionada
            int indiceOficina = listOficinas.getSelectedIndex();
            oficinaSelecionada = oficinas.get(indiceOficina);

            // Peca selecionada
            int indicePeca = listPecas.getSelectedIndex();
            pecaSelecionada = pecas.get(indicePeca);

            LinhaReparacao linhaReparacao = new LinhaReparacao(pecaSelecionada, quantidadePecas);

            LinkedList<LinhaReparacao> listaLinhaReparacao = new LinkedList<>();
            listaLinhaReparacao.add(linhaReparacao);

            reparacaoAtual.setVeiculo(veiculoSelecionado);
            reparacaoAtual.setServicosExternos(servicosExternos);
            reparacaoAtual.setTipoReparacao(tipoReparacaoEnum);
            reparacaoAtual.setDataRececao(dataRececao);
            reparacaoAtual.setDataEntrega(dataEntrega);
            reparacaoAtual.setDescricaoTrabalhos(descricaoTrabalhos);
            reparacaoAtual.setOficina(oficinaSelecionada);
            reparacaoAtual.setLinhasReparacao(listaLinhaReparacao);

            dispose();
        }
    }

    private void btnCancelarActionListener(ActionEvent e) {
        dispose();
    }
}
