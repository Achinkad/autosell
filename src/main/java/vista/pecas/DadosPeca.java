package vista.pecas;

import modelo.Peca;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosPeca extends JDialog {
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
    private JTextArea textDescrição;
    private JTextField textMoV;
    private JButton editarButton;
    private JButton cancelarButton;
    private JLabel lblDescricao;
    private JLabel lblReferencia;
    private JLabel lblPreco;
    private JLabel lblMarca;
    private JTextField textDesignação;
    private JLabel lblDesignacao;
    private JLabel lblmav;
    private JLabel lblmov;

    private MenuAux menuAux;

    private Peca pecaPresente;

    public DadosPeca(Peca peca, boolean isEditavel){
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pecaPresente = peca;

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

        textDesignação.setText(peca.getDesignacao());
        textDescrição.setText(peca.getDescricao());
        textMarca.setText(peca.getMarca());
        textPreco.setText(peca.getPreco()+"");
        textReferencia.setText(peca.getReferencia());
        textMaV.setText(peca.getMarcaVeiculo());
        textMoV.setText(peca.getModeloVeiculo());



        if(isEditavel){
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
            cancelarButton.setVisible(true);
            cancelarButton.addActionListener(this::btnCancelarActionListener);
        }

        pack();
        setVisible(true);
    }

    private void btnEditarActionListener(ActionEvent e){

        if(textDesignação.getText().length() < 2 || textDesignação.getText().length() > 255){
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
        if(!textPreco.getText().matches("\\d{1,5}.\\d{1,2}")){
            Erros.mostrarErro(this,4,Erros.removeLastChar(lblPreco.getText()));
            return;
        }
        if(textDescrição.getText().length() < 2 || textDescrição.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblDescricao.getText()));
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
        pecaPresente.setDesignacao(textDescrição.getText());
        pecaPresente.setDescricao(textDescrição.getText());
        pecaPresente.setMarca(textMarca.getText());
        pecaPresente.setMarcaVeiculo(textMaV.getText());
        pecaPresente.setModeloVeiculo(textMoV.getText());
        pecaPresente.setReferencia(textReferencia.getText());
        pecaPresente.setPreco(Float.parseFloat(textPreco.getText()));

        dispose();
    }
    private void btnCancelarActionListener(ActionEvent e){
        dispose();
    }


}
