package vista.pecas;

import modelo.DadosApp;
import modelo.Peca;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistarPeca extends JDialog {
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
    private JTextField textReferencia;
    private JTextField textMarca;
    private JTextField textPreco;
    private JTextField textMaV;
    private JTextArea textDescricao;
    private JTextField textMoV;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JPanel painelPecas;


    public RegistarPeca(){
        setContentPane(painelPecas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

        adicionarButton.addActionListener(this::btnRegistarActionPerformed);
    }

    private void btnRegistarActionPerformed(ActionEvent e){
        DadosApp.getInstancia().addPeca(new Peca(textReferencia.getText(),textMarca.getText(),Float.parseFloat(textPreco.getText()),textDescricao.getText(),textMaV.getText(),textMoV.getText()));
        dispose();
    }

}
