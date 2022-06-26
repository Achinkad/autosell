package vista.estatisticas;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class Lucro extends JDialog{
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
    private JLabel Lucro;
    private MenuAux menuAux;
    private LinkedList<Transacao> transacoes;
    public Lucro() {
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
        float ganhos=0;
        float despesas=0;
        float lucro;
        DadosApp da = DadosApp.getInstancia();
        transacoes = da.getTransacoes();
        DefaultListModel model1 = new DefaultListModel();
        for (Transacao transacao : transacoes) {
          if (transacao.getTipoTransacao()== TipoTransacao.CREDITO){
              ganhos=ganhos+ transacao.getValor();
          }
          if (transacao.getTipoTransacao()==TipoTransacao.DEBITO){
              despesas=despesas+ transacao.getValor();
          }
        }
        lucro=ganhos-despesas;
        Lucro.setText(lucro+"€");

        pack();
        setVisible(true);

    }
}
