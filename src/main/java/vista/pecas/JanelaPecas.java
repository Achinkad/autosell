package vista.pecas;

import modelo.DadosApp;
import modelo.Peca;
import vista.MenuAux;

import javax.swing.*;
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
        LinkedList<Peca> pecas = da.getPecas();

        DefaultListModel model = new DefaultListModel();
        for (Peca p : pecas) {
            listaDePecas.setModel(model);
            model.addElement("Nome: "+p.getNome()+"   Marca: "+p.getMarca()+"     Modelo: "+p.getModeloVeiculo()+"   Preço: "+p.getPreco());
        }
        pack();
        setVisible(true);
    }
}
