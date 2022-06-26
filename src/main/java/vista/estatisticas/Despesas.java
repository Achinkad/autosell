package vista.estatisticas;

import modelo.DadosApp;
import modelo.TipoTransacao;
import modelo.Transacao;
import vista.MenuAux;

import javax.swing.*;
import java.util.LinkedList;

public class Despesas extends JDialog{
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
    private JLabel Despesas;
    private MenuAux menuAux;
    private LinkedList<Transacao> transacoes;
    public Despesas() {
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
        float despesas=0;

        DadosApp da = DadosApp.getInstancia();
        transacoes = da.getTransacoes();
        DefaultListModel model1 = new DefaultListModel();
        for (Transacao transacao : transacoes) {
            if (transacao.getTipoTransacao()==TipoTransacao.DEBITO){
                despesas=despesas+ transacao.getValor();
            }
        }
        Despesas.setText(Math.abs(despesas)+"€");

        pack();
        setVisible(true);

    }
}
