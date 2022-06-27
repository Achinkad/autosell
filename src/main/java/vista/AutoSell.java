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

        Peca p = new Peca("ref51SDe5fddse","Luka",800,"Caixa de velocidades","BMW","i8","Caixa de velocidades");
        Cliente c = new Cliente("Maria",569958748,"Leiria",93627447,"maria@gmail.com",new FichaCliente());
        Cliente z = new Cliente("Manel",123438688,"Porto",91886382,"manel@sapo.pt",new FichaCliente());
        Veiculo v = new Veiculo("MD-49_87","BMW","i8","AZUL",2300,"Usado",z,new FichaVeiculo(),"falta de caixa de Velocidades");
        Oficina oficina = new Oficina("Oficina 1 Filial Leiria", 911222333, "o1@leria.pt", "António", 919333777);
        LinkedList<Oficina> oficinas = new LinkedList<>();
        oficinas.add(oficina);
        Filial f = new Filial(oficinas,new LinkedList<>(),false,"Filial de Leiria","Leiria","Centro",120,new LinkedList<>());
        Reparacao reparacao = new Reparacao(TipoReparacao.MUDANCA_PECAS, v, oficina, "Caixa de velocidades", "21-12-2022", "22-12-2022", "Inspeção", null);

        Local local = new Local("Leiria","Leiria","Centro",120,new LinkedList<>());
        Transporte t = new Transporte<>(null,new Date(10,2,2020),new Date(10,2,2020),local);


        DadosApp.getInstancia().inserirPeca(p);
        DadosApp.getInstancia().inserirVeiculo(v);
        DadosApp.getInstancia().inserirCLiente(z);
        DadosApp.getInstancia().inserirCLiente(c);
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


