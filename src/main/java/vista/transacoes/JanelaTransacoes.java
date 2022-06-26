package vista.transacoes;

import modelo.Armazem;
import modelo.DadosApp;
import modelo.Transacao;
import vista.MenuAux;
import vista.armazens.DadosArmazem;
import vista.armazens.RegistarArmazem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaTransacoes extends JFrame {
    private JPanel painelTransacoes;
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
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarButton;
    private JList listaDeTransacoes;
    private MenuAux menuAux;
    private Transacao transacaoSelecionada;
    private LinkedList<Transacao> transacoes;

    public JanelaTransacoes() {
        setContentPane(painelTransacoes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        //Lista de peças
        DadosApp da = DadosApp.getInstancia();
        transacoes = da.getTransacoes();

        DefaultListModel model = new DefaultListModel();
        for (Transacao t : transacoes) {
            listaDeTransacoes.setModel(model);
            model.addElement("Valor: "+t.getValor()+"    Nome do Veículo: "+t.getVeiculo().getDescricao());
        }


        // Define a seleção única para a lista
        listaDeTransacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarButton.addActionListener(this::btnRegistarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);


        pack();
        setVisible(true);
    }

    private void btnConsultarActionPerformed(ActionEvent e){
        int selected = listaDeTransacoes.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        transacaoSelecionada = transacoes.get(selected);
        new DadosTransacao(transacaoSelecionada, false);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        int selected = listaDeTransacoes.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        transacaoSelecionada = transacoes.get(selected);
        new DadosTransacao(transacaoSelecionada, true);
    }

    private void btnRegistarActionPerformed(ActionEvent e){
        new RegistarTransacao();
    }

    private void btnEliminarActionPerformed(ActionEvent e){
        if(listaDeTransacoes.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar esta peça ?");
            if (result == 0) {
                //Sim
                if (listaDeTransacoes.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerTransacao(transacoes.get(listaDeTransacoes.getSelectedIndex()));
                    dispose();
                }
            }
            if (result >= 1) {
                //Não
                dispose();
            }
        }
    }
}
