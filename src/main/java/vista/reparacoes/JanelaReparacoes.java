package vista.reparacoes;

import modelo.DadosApp;
import modelo.Oficina;
import modelo.Reparacao;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaReparacoes extends JFrame {
    private JPanel painelReparacoes;
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
    private JList listaDeReparacoes;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarReparacaoButton;
    private MenuAux menuAux;

    private Reparacao reparacaoSelecionada;
    private LinkedList<Reparacao> reparacoes;

    public JanelaReparacoes() {
        setContentPane(painelReparacoes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // INIT MENU
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

        DadosApp dados = DadosApp.getInstancia();
        reparacoes = dados.getReparacaos();

        DefaultListModel model = new DefaultListModel();
        for (Reparacao r : reparacoes) {
            listaDeReparacoes.setModel(model);
            model.addElement("Veículo: " + r.getVeiculo().getMatricula() + "     Descrição dos trabalhos: " + r.getDescricaoTrabalhos());
        }

        listaDeReparacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarReparacaoButton.addActionListener(this::btnRegistarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
        new RegistarReparacao();
    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        // TODO
    }

    private void btnEditarActionPerformed(ActionEvent e) {
        // TODO
    }

    private void btnConsultarActionPerformed(ActionEvent e) {
        // TODO
    }
}
