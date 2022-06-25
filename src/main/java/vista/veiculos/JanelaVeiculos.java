package vista.veiculos;

import modelo.DadosApp;
import modelo.Peca;
import modelo.Veiculo;
import vista.MenuAux;
import vista.clientes.JanelaClientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaVeiculos extends JFrame{
    private JPanel painelVeiculos;
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
    private JPanel painelVeiculos1;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarVeiculoButton;
    private JList listaDeVeiculos;
    private MenuAux menuAux;

    public JanelaVeiculos() {
        setContentPane(painelVeiculos);
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
        //Lista de veiculos
        DadosApp da = DadosApp.getInstancia();
        LinkedList<Veiculo> veiculos = da.getVeiculos();

        DefaultListModel model = new DefaultListModel();
        for (Veiculo v : veiculos) {
            listaDeVeiculos.setModel(model);
            model.addElement("Marca: "+v.getMarca()+"   Modelo: "+v.getModelo());
        }
        registarVeiculoButton.addActionListener(this::registarVeiculoButton);

        pack();
        setVisible(true);
    }
    private void registarVeiculoButton(ActionEvent e) {
        RegistarVeiculo registarVeiculo = new RegistarVeiculo();
        registarVeiculo.setVisible(true);
    }

}
