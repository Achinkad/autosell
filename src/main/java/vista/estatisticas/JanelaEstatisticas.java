package vista.estatisticas;

import vista.MenuAux;

import javax.swing.*;
import java.util.LinkedList;

public class JanelaEstatisticas extends JFrame {
    private JPanel painelEstatisticas;
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
    private JButton marcasEModelosMaisButton;
    private JButton marcasEModelosMenosButton;
    private JButton eventosEFiliaisComButton;
    private JButton eventosEFiliaisComButton1;
    private JButton marcasEModelosQueButton;
    private JButton marcasEModelosQueButton1;
    private JButton consultarOLucroButton;
    private JButton consultarAsDespesasButton;
    private MenuAux menuAux;

    public JanelaEstatisticas() {
        setContentPane(painelEstatisticas);
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
        pack();
        setVisible(true);
    }
}
