package vista.pecas;

import modelo.DadosApp;
import modelo.Peca;
import vista.Erros;

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
    private JTextField textDesignacao;
    private JLabel lblDesignacao;
    private JLabel lblDescrição;
    private JLabel lblReferencia;
    private JLabel lblMarca;
    private JLabel lblPreco;
    private JLabel lblmav;
    private JLabel lblmov;


    public RegistarPeca(){
        setContentPane(painelPecas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

        adicionarButton.addActionListener(this::btnRegistarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);
    }

    private void btnRegistarActionPerformed(ActionEvent e){
        if(textDescricao.getText().length() < 2 || textDescricao.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblDesignacao.getText()));
            return;
        }
        if(textReferencia.getText().length() < 2 || textReferencia.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblReferencia.getText()));
            return;
        }
        if(textMarca.getText().length() < 2 || textMarca.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblMarca.getText()));
            return;
        }
        if(!textPreco.getText().matches("\\d{1,5}.\\d{0,2}")){
            Erros.mostrarErro(this,4,Erros.removeLastChar(lblPreco.getText()));
            return;
        }
        if(textDescricao.getText().length() < 2 || textDescricao.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblDescrição.getText()));
            return;
        }
        if(textMaV.getText().length() < 2 || textMaV.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblmav.getText()));
            return;
        }
        if(textMoV.getText().length() < 2 || textMoV.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblmov.getText()));
            return;
        }
        DadosApp.getInstancia().addPeca(new Peca(textReferencia.getText(),textMarca.getText(),Float.parseFloat(textPreco.getText()),textDescricao.getText(),textMaV.getText(),textMoV.getText(),textDesignacao.getText()));
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }

}
