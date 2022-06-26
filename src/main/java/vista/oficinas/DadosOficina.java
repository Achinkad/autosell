package vista.oficinas;

import modelo.Oficina;
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
        oficinaAtual.setNome(textNome.getText());
        oficinaAtual.setTelefone(Integer.parseInt(textTelefone.getText()));
        oficinaAtual.setEmail(textMail.getText());
        oficinaAtual.setResponsavelOficina(textNomeResp.getText());
        oficinaAtual.setTelefoneResponsavel(Integer.parseInt(textNumResp.getText()));
        dispose();
    }

    private void btnCancelarActionListener(ActionEvent e) {
        dispose();
    }
}
