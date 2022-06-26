package vista.oficinas;

import modelo.DadosApp;
import modelo.Oficina;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosOficina extends JDialog {
    private JPanel painelPrincipal;
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
    private JTextField textTelefone;
    private JTextField textMail;
    private JButton editarButton;
    private JButton cancelarButton;
    private JTextField textNome;
    private JTextField textNomeResp;
    private JTextField textNumResp;
    private JLabel lbNome;
    private JLabel lbTelefone;
    private JLabel lbMail;
    private JLabel lbNomeResp;
    private JLabel lbNumResp;

    private MenuAux menuAux;

    private Oficina oficinaAtual;

    public DadosOficina(Oficina oficina, boolean isEditavel) {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        oficinaAtual = oficina;

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

        textNome.setText(oficina.getNome());
        textTelefone.setText(Integer.toString(oficina.getTelefone()));
        textMail.setText(oficina.getEmail());
        textNomeResp.setText(oficina.getResponsavelOficina());
        textNumResp.setText(Integer.toString(oficina.getTelefoneResponsavel()));

        if(isEditavel) {
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
        }

        cancelarButton.addActionListener(this::btnCancelarActionListener);

        pack();
        setVisible(true);
    }

    private void btnEditarActionListener(ActionEvent e) {
        String nome = textNome.getText();
        String mail = textMail.getText();
        String nomeResp = textNomeResp.getText();
        int telefone = (textTelefone.getText().isEmpty() ? -1 : Integer.parseInt(textTelefone.getText()));
        int telefoneResp = (textNumResp.getText().isEmpty() ? -1 : Integer.parseInt(textNumResp.getText()));

        if (nome.length() < 2 || nome.length() > 255)
        {
            Erros.mostrarErro(this, 1, Erros.removeLastChar(lbNome.getText()));
        }
        else if (telefone == -1 || textTelefone.getText().length() != 9)
        {
            Erros.mostrarErro(this, 5, Erros.removeLastChar(lbTelefone.getText()));
        }
        else if (!Erros.validate(mail))
        {
            Erros.mostrarErro(this, 2, Erros.removeLastChar(lbMail.getText()));
        }
        else if (nomeResp.length() < 2 || nomeResp.length() > 255)
        {
            Erros.mostrarErro(this,1, Erros.removeLastChar(lbNomeResp.getText()));
        }
        else if (telefoneResp == -1 || textNumResp.getText().length() != 9)
        {
            Erros.mostrarErro(this, 5, Erros.removeLastChar(lbNumResp.getText()));
        }
        else
        {
            oficinaAtual.setNome(nome);
            oficinaAtual.setTelefone(telefone);
            oficinaAtual.setEmail(mail);
            oficinaAtual.setResponsavelOficina(nomeResp);
            oficinaAtual.setTelefoneResponsavel(telefoneResp);
            dispose();
        }

    }

    private void btnCancelarActionListener(ActionEvent e) {
        dispose();
    }
}
