package vista;

import modelo.*;
import modelo.Date;

import javax.swing.*;
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

        Peca p = new Peca("ref","Chinês",800,"desc","BMW","15","Oleo");
        Cliente c = new Cliente("Titi",12343,"asas",123344,"ola",null);
        Cliente z = new Cliente("Manel",12343,"asas",123344,"ola",null);
        Veiculo v = new Veiculo("123455","OLA","OLA","AZUL",123,"ASDDS",z,null,"asd");
        Filial f= new Filial(null,null,false,"as","as","as",12,null);
        Oficina oficina = new Oficina("Mille", 911222333, "mille@oficina.com", "Marco", 919333777);

        Reparacao reparacao = new Reparacao(TipoReparacao.MUDANCA_PECAS, v, oficina, "muito trabalho", "22-12-2022", "22-12-2022", "muitos", null);

        Local local = new Local("aaa","aaa","asasa",12,null);
        Transporte t = new Transporte<>(null,new Date(10,2,2020),new Date(10,2,2020),local);


        DadosApp.getInstancia().addPeca(p);
        DadosApp.getInstancia().inserirVeiculo(v);
        DadosApp.getInstancia().addCLiente(z);
        DadosApp.getInstancia().addCLiente(c);
        DadosApp.getInstancia().inserirReparacao(reparacao);

        DadosApp.getInstancia().inserirLocal(local);
        DadosApp.getInstancia().inserirOficina(oficina);
        DadosApp.getInstancia().inserirFilial(f);
        DadosApp.getInstancia().inserirTransporte(t);
    }

    public static void main(String[] args) {
        new AutoSell().setVisible(true);
    }
}


