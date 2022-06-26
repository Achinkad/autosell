package vista.clientes;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class RegistarCliente extends JDialog {
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
    private JPanel painelPrincipal;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField textEmails;
    private JTextField textMorada;
    private JTextField textContribuinte;

    private MenuAux menuAux;

    private LinkedList<Peca> pecasParaOArmazem;

    public RegistarCliente(){
        setContentPane(painelPrincipal);
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

        //Criar novo armazém

        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnAdicionarActionPerformed(ActionEvent e){
        DadosApp.getInstancia().addCLiente(new Cliente(textNome.getText(),Integer.parseInt(textContribuinte.getText()),textMorada.getText(),Integer.parseInt(textTelefone.getText()),textEmails.getText(),new FichaCliente()));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }

}
