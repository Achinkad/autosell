package vista.oficinas;

import modelo.DadosApp;
import modelo.Filial;
import modelo.Oficina;

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

    public RegistarOficina() {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        adicionarButton.addActionListener(this::btnRegistarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
        DadosApp.getInstancia().inserirOficina(
                new Oficina(
                        textNome.getText(),
                        Integer.parseInt(textTelefone.getText()),
                        textMail.getText(),
                        textNomeResp.getText(),
                        Integer.parseInt(textNumResp.getText())
                )
        );
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
    }
}
