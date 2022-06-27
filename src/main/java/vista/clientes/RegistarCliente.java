package vista.clientes;

import modelo.*;
import vista.Erros;
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
    private JLabel lblNome;
    private JPanel lblTelefone;
    private JLabel lblEmail;
    private JLabel lblContribuinte;
    private JLabel lblMorada;
    private JLabel lblTel;

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
            Erros.mostrarErro(this,4,Erros.removeLastChar(lblTel.getText()));
            return;
        }
        if(!Erros.validate(textEmails.getText())){
            Erros.mostrarErro(this,6," ");
            return;
        }
        DadosApp.getInstancia().inserirCLiente(new Cliente(textNome.getText(),Integer.parseInt(textContribuinte.getText()),textMorada.getText(),Integer.parseInt(textTelefone.getText()),textEmails.getText(),new FichaCliente()));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }

}
