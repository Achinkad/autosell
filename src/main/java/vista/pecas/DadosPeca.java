package vista.pecas;

import modelo.Peca;
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
    private JTextArea textDescricao;
    private JTextField textMoV;
    private JButton editarButton;
    private JButton cancelarButton;

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

        textDescricao.setText(peca.getDescricao());
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
        pecaPresente.setDescricao(textDescricao.getText());
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
