package vista.oficinas;

import modelo.DadosApp;
import modelo.Oficina;
import vista.MenuAux;
import vista.filiais.DadosFilial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaOficinas extends JFrame {
    private JPanel painelOficinas;
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
    private JList listaDeOficinas;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarOficinaButton;
    private MenuAux menuAux;

    private Oficina oficinaSelecionada;
    private LinkedList<Oficina> oficinas;

    public JanelaOficinas() {
        setContentPane(painelOficinas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // INIT MENU
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
        oficinas = dados.getOficinas();

        DefaultListModel model = new DefaultListModel();
        for (Oficina o : oficinas) {
            listaDeOficinas.setModel(model);
            model.addElement("Nome: " + o.getNome() + "     Telemóvel: " + o.getTelefone());
        }

        listaDeOficinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarOficinaButton.addActionListener(this::btnRegistarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
        new RegistarOficina();
    }

    private void btnEditarActionPerformed(ActionEvent e) {
        int selected = listaDeOficinas.getSelectedIndex();

        if(selected < 0) return;

        oficinaSelecionada = oficinas.get(selected);
        new DadosOficina(oficinaSelecionada, true);
    }

    private void btnConsultarActionPerformed(ActionEvent e) {
        int selected = listaDeOficinas.getSelectedIndex();

        if(selected < 0) return;

        oficinaSelecionada = oficinas.get(selected);
        new DadosOficina(oficinaSelecionada, false);
    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        if (listaDeOficinas.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar esta oficina?");

            if (result == 0) {
                if (listaDeOficinas.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerOficina(oficinas.get(listaDeOficinas.getSelectedIndex()));
                    dispose();
                }
            }

            if (result >= 1) {
                dispose();
            }
        }
    }
}
