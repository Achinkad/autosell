package vista.eventos;

import modelo.DadosApp;
import modelo.Evento;
import modelo.Veiculo;
import vista.MenuAux;

import javax.swing.*;
import java.util.LinkedList;

public class JanelaEventos extends JFrame {
    private JPanel painelEventos;
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
    private JPanel painelEventos1;
    private JPanel painelEventos2;
    private JList listaDeEventos;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarEvento;
    private LinkedList<Evento> eventos;
    private MenuAux menuAux;

    public JanelaEventos() {
        setContentPane(painelEventos);
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
        //Lista de eventos
        DadosApp da = DadosApp.getInstancia();
        eventos = da.getEventos();

        DefaultListModel model = new DefaultListModel();
        for (Evento e : eventos) {
            listaDeEventos.setModel(model);
            //model.addElement("Filial: "+e.get+"   Modelo: "+v.getModelo());
        }
        pack();
        setVisible(true);
    }
}
