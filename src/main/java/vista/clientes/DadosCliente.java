package vista.clientes;

import modelo.Cliente;
import modelo.FichaCliente;
import vista.Erros;
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
    private JLabel lblNome;
    private JLabel lblTelefone;
    private JLabel lblContribuinte;
    private JLabel lblMorada;
    private JLabel lblEmail;
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
        textContribuinte.setText(Integer.toString(cliente.getContribuinte()));
        textMorada.setText(cliente.getMorada());


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
        if(textNome.getText().length() < 2 || textNome.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblNome.getText()));
            return;
        }
        if(!textContribuinte.getText().matches("\\d{9}")){
            Erros.mostrarErro(this,4,Erros.removeLastChar(lblContribuinte.getText()));
            return;
        }
        if(textMorada.getText().length() < 2 || textMorada.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblMorada.getText()));
            return;
        }
        if(!textTelefone.getText().matches("\\d{9}")){
            Erros.mostrarErro(this,4,Erros.removeLastChar(lblTelefone.getText()));
            return;
        }
        if(!Erros.validate(textEmails.getText())){
            Erros.mostrarErro(this,6," ");
            return;
        }
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
