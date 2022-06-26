package vista.oficinas;

import modelo.DadosApp;
import modelo.Filial;
import modelo.Oficina;
import vista.AutoSell;
import vista.Erros;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistarOficina extends JDialog {
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
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField textNome;
    private JTextField textNomeResp;
    private JTextField textNumResp;
    private JLabel lbTelefone;
    private JLabel lbMail;
    private JLabel lbNome;
    private JLabel lbNumResp;
    private JLabel lbNomeResp;

    public RegistarOficina() {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        adicionarButton.addActionListener(this::btnRegistarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
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
            DadosApp.getInstancia().inserirOficina(
                    new Oficina(
                            nome,
                            telefone,
                            mail,
                            nomeResp,
                            telefoneResp
                    )
            );
            dispose();
        }
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
    }
}
