package vista;

import modelo.*;
import vista.armazens.JanelaArmazens;
import vista.clientes.JanelaClientes;
import vista.estatisticas.JanelaEstatisticas;
import vista.eventos.JanelaEventos;
import vista.filiais.JanelaFiliais;
import vista.oficinas.JanelaOficinas;
import vista.pecas.DadosPeca;
import vista.pecas.JanelaPecas;
import vista.reparacoes.JanelaReparacoes;
import vista.transacoes.JanelaTransacoes;
import vista.transportes.JanelaTransportes;
import vista.veiculos.JanelaVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class AutoSell extends JFrame {
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
    private MenuAux menuAux;

    public AutoSell() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
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

        Peca p = new Peca("ref","Chinês",800,"desc","BMW","15");
        Veiculo veiculo = new Veiculo("AA-AA-AA", "Volvo", "V40", "Azul", 200000, "Muito bonito.", null, null);
        Oficina oficina = new Oficina("Mille", 911222333, "mille@oficina.com", "Marco", 919333777);

        DadosApp.getInstancia().addPeca(p);
        DadosApp.getInstancia().inserirVeiculo(veiculo);
        DadosApp.getInstancia().inserirOficina(oficina);
    }

    public static void main(String[] args) {
        new AutoSell().setVisible(true);
    }
}


