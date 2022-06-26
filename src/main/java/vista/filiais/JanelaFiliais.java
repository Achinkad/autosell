package vista.filiais;

import modelo.DadosApp;
import modelo.Filial;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaFiliais extends JFrame {
    private JPanel painelFiliais;
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
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarFilialButton;
    private JList listaDeFiliais;

    private MenuAux menuAux;

    private Filial filialSelecionada;
    private LinkedList<Filial> filiais;

    public JanelaFiliais () {
        setContentPane(painelFiliais);
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

        DadosApp dados = DadosApp.getInstancia();
        filiais = dados.getFiliais();

        DefaultListModel model = new DefaultListModel();
        for (Filial f : filiais) {
            listaDeFiliais.setModel(model);
            model.addElement("Designação: " + f.getDesignacao() + "     Localização: " + f.getLocalizacao());
        }

        listaDeFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarFilialButton.addActionListener(this::btnRegistarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
        new RegistarFilial();
    }

    private void btnEditarActionPerformed(ActionEvent e) {
        int selected = listaDeFiliais.getSelectedIndex();

        if(selected < 0) return;

        filialSelecionada = filiais.get(selected);
        new DadosFilial(filialSelecionada, true);
    }

    private void btnConsultarActionPerformed(ActionEvent e) {
        int selected = listaDeFiliais.getSelectedIndex();

        if(selected < 0) return;

        filialSelecionada = filiais.get(selected);
        new DadosFilial(filialSelecionada, false);
    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        if (listaDeFiliais.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar esta filial?");

            if (result == 0) {
                if (listaDeFiliais.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerFilial(filiais.get(listaDeFiliais.getSelectedIndex()));
                    dispose();
                }
            }

            if (result >= 1) {
                dispose();
            }
        }
    }
}
