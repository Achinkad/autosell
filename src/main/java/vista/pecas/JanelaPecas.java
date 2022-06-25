package vista.pecas;

import modelo.DadosApp;
import modelo.Peca;
import vista.MenuAux;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaPecas extends JFrame {
    private JPanel painelPecas;
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
    private JList listaDePecas;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarPeçaButton;

    private MenuAux menuAux;

    private Peca pecaSelecionada;
    private LinkedList<Peca> pecas;

    public JanelaPecas() {
        setContentPane(painelPecas);
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
        pecas = da.getPecas();

        DefaultListModel model = new DefaultListModel();
        for (Peca p : pecas) {
            listaDePecas.setModel(model);
            model.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca()+"     Modelo: "+p.getModeloVeiculo()+"   Preço: "+p.getPreco());
        }


        // Define a seleção única para a lista
        listaDePecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarPeçaButton.addActionListener(this::btnRegistarActionPerformed);


        pack();
        setVisible(true);
    }
    private void btnConsultarActionPerformed(ActionEvent e){
        int selected = listaDePecas.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        pecaSelecionada = pecas.get(selected);
        new DadosPeca(pecaSelecionada, false);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        int selected = listaDePecas.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        pecaSelecionada = pecas.get(selected);
        new DadosPeca(pecaSelecionada, true);
    }
    private void btnRegistarActionPerformed(ActionEvent e){
        new RegistarPeca();
    }
}
