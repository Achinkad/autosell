package vista.transacoes;

import modelo.Armazem;
import modelo.DadosApp;
import modelo.Peca;
import modelo.Transacao;
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
        //TODO preencher campos


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

        //TODO Registar alterações
        /*armazemPresente.setNome(textNome.getText());
        armazemPresente.setTelefone(Integer.parseInt(textTelefone.getText()));

        LinkedList<Peca> pecasDoArmazem = armazemPresente.getPecas();
        int i = 0;
        int[] indices = list1.getSelectedIndices();
        for (int selectedIndex : indices) {
            pecasDoArmazem.add(todasAsPecas.get(selectedIndex-1));
        }
        armazemPresente.setPecas(pecasDoArmazem);
        armazemPresente.setQuantidadePeças(pecasDoArmazem.size());*/
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }
}
