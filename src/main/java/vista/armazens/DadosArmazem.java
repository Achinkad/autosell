package vista.armazens;

import modelo.Armazem;
import modelo.DadosApp;
import modelo.Peca;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosArmazem extends JDialog {
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
    private JTextField textNome;
    private JTextField textTelefone;
    private JList list1;
    private JTextField textField1;
    private JPanel painelArmazens;
    private JButton editarButton;
    private JButton cancelarButton;
    private MenuAux menuAux;
    private Armazem armazemPresente;
    private LinkedList<Peca> todasAsPecas;

    public DadosArmazem(Armazem armazem, boolean isEditavel){
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

        armazemPresente = armazem;
        textNome.setText(armazem.getNome());
        textTelefone.setText(Integer.toString(armazem.getTelefone()));

        todasAsPecas = new LinkedList<>(armazem.getPecas());
        todasAsPecas.addAll(DadosApp.getInstancia().getPecas());

        DefaultListModel model = new DefaultListModel();
        if(!isEditavel){
            for (Peca p : armazem.getPecas()) {
                list1.setModel(model);
                model.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca());
            }
        }else{
            int i = 0;
            for (Peca p : todasAsPecas) {
                if(armazem.getPecas().size() == i) {
                    list1.setModel(model);
                    model.addElement("--- Peças não Associada ---");
                }
                list1.setModel(model);
                model.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca());

                i++;
            }
        }

        textField1.setText(Integer.toString(armazem.getPecas().size()));

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
        armazemPresente.setNome(textNome.getText());
        armazemPresente.setTelefone(Integer.parseInt(textTelefone.getText()));

        LinkedList<Peca> pecasDoArmazem = armazemPresente.getPecas();
        int i = 0;
        int[] indices = list1.getSelectedIndices();
        for (int selectedIndex : indices) {
            pecasDoArmazem.add(todasAsPecas.get(selectedIndex-1));
        }
        armazemPresente.setPecas(pecasDoArmazem);
        armazemPresente.setQuantidadePeças(pecasDoArmazem.size());
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }
}
