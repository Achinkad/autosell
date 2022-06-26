package vista.transacoes;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosTransacao extends JDialog {

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
    private JPanel painelArmazens;
    private JButton editarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JList list1;
    private JList list2;
    private MenuAux menuAux;
    private Transacao transacaoPresente;

    public DadosTransacao(Transacao transacao, boolean isEditavel){
        setContentPane(painelArmazens);
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

        editarButton.setVisible(false);
        cancelarButton.setVisible(false);

        textField1.setText(Float.toString(transacao.getValor()));

        if(transacao.getTipoTransacao() == TipoTransacao.DEBITO) {
            comboBox1.setSelectedIndex(0);
        }else{
            comboBox1.setSelectedIndex(1);
        }

        DefaultListModel modelV = new DefaultListModel();
        LinkedList<Veiculo> vl = new LinkedList<>();
        vl.add(transacao.getVeiculo());
        DefaultListModel modelC = new DefaultListModel();
        LinkedList<Cliente> cl = new LinkedList<>();
        cl.add(transacao.getCliente());

        if(!isEditavel){
            for (Veiculo v : vl) {
                list1.setModel(modelV);
                modelV.addElement("Descrição: "+v.getDescricao()+"   Marca: "+v.getMarca());
            }
            for (Cliente c : cl) {
                list2.setModel(modelC);
                modelC.addElement("Nome: "+c.getNome()+"   Email: "+c.getEmail());
            }
        }else{
            int i = 0;
            for (Veiculo p : DadosApp.getInstancia().getVeiculos()) {
                list1.setModel(modelV);
                modelV.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca());
                if(p == transacao.getVeiculo()){
                    list1.setSelectedIndex(i);
                }
                i++;
            }
            i=0;
            for (Cliente c : DadosApp.getInstancia().getClientes()) {
                list2.setModel(modelC);
                modelC.addElement("Nome: "+c.getNome()+"   Email: "+c.getEmail());
                if(c == transacao.getCliente()){
                    list2.setSelectedIndex(i);
                }
                i++;
            }
        }

        transacaoPresente = transacao;
        if(isEditavel) {
            editarButton.setVisible(true);
            cancelarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionPerformed);
            cancelarButton.addActionListener(this::btnCancelarActionPerformed);
        }

        pack();
        setVisible(true);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        transacaoPresente.setValor(Float.parseFloat(textField1.getText()));
        transacaoPresente.setCliente(DadosApp.getInstancia().getClientes().get(list2.getSelectedIndex()));
        transacaoPresente.setVeiculo(DadosApp.getInstancia().getVeiculos().get(list1.getSelectedIndex()));
        if(comboBox1.getSelectedIndex() == 0){
            transacaoPresente.setTipoTransacao(TipoTransacao.DEBITO);
        }
        if(comboBox1.getSelectedIndex() == 1){
            transacaoPresente.setTipoTransacao(TipoTransacao.CREDITO);
        }
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }
}
