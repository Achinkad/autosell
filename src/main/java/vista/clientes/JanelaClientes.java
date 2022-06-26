package vista.clientes;

import modelo.Armazem;
import modelo.Cliente;
import modelo.DadosApp;
import vista.MenuAux;
import vista.armazens.DadosArmazem;
import vista.armazens.RegistarArmazem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaClientes extends JFrame {
    private JPanel painelClientes;
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
    private JList listaDeArmazens;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarButton;

    private MenuAux menuAux;

    private Cliente clienteSelecionado;

    private LinkedList<Cliente> clientes;

    public JanelaClientes() {
        setContentPane(painelClientes);
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

        //Lista de peças
        DadosApp da = DadosApp.getInstancia();
        clientes = da.getClientes();

        DefaultListModel model = new DefaultListModel();
        for (Cliente c : clientes) {
            listaDeArmazens.setModel(model);
            model.addElement("Nome: "+c.getNome()+"    Telefone: "+c.getTelefone());
        }


        // Define a seleção única para a lista
        listaDeArmazens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        registarButton.addActionListener(this::btnRegistarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);


        pack();
        setVisible(true);
    }
    private void btnConsultarActionPerformed(ActionEvent e){
        int selected = listaDeArmazens.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        clienteSelecionado = clientes.get(selected);
        new DadosCliente(clienteSelecionado, false);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        int selected = listaDeArmazens.getSelectedIndex();
        //System.out.println(selected+"");
        if(selected < 0) {
            return;
        }
        clienteSelecionado = clientes.get(selected);
        new DadosCliente(clienteSelecionado, true);
    }

    private void btnRegistarActionPerformed(ActionEvent e){
        new RegistarCliente();
    }
    private void btnEliminarActionPerformed(ActionEvent e){
        if(listaDeArmazens.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar esta peça ?");
            if (result == 0) {
                //Sim
                if (listaDeArmazens.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerCliente(clientes.get(listaDeArmazens.getSelectedIndex()));
                    dispose();
                }
            }
            if (result >= 1) {
                //Não
                dispose();
            }
        }
    }
}
