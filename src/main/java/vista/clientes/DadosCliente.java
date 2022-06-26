package vista.clientes;

import modelo.Cliente;
import modelo.FichaCliente;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosCliente extends JDialog {
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
    private JTextField textField1;
    private JPanel painelArmazens;
    private JButton editarButton;
    private JButton cancelarButton;
    private JPanel painelClientes;
    private JTextField textEmails;
    private JTextField textMorada;
    private JTextField textContribuinte;
    private MenuAux menuAux;

    private Cliente clientePresente;

    private LinkedList<Cliente> todasAsPecas;

    public DadosCliente(Cliente cliente, boolean isEditavel){
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

        editarButton.setVisible(false);
        cancelarButton.setVisible(false);

        clientePresente = cliente;
        textNome.setText(cliente.getNome());
        textTelefone.setText(Integer.toString(cliente.getTelefone()));
        textEmails.setText(clientePresente.getEmail());
        textContribuinte.setText(Integer.toString(cliente.getTelefone()));
        textMorada.setText(cliente.getMorada());

        /*TODO Preencher atributos do modelo
        *  Fazer a vista de criar Cliente
        *         * remover
        *         * editar
        *         * eliminar */




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
        clientePresente.setNome(textNome.getText());
        clientePresente.setTelefone(Integer.parseInt(textTelefone.getText()));
        clientePresente.setContribuinte(Integer.parseInt(textContribuinte.getText()));
        clientePresente.setMorada(textMorada.getText());
        clientePresente.setEmail(textEmails.getText());
        clientePresente.setFicha(new FichaCliente());
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }
}
