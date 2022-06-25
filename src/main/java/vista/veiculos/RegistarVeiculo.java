package vista.veiculos;

import modelo.Veiculo;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;


public class RegistarVeiculo extends JDialog {
    private JPanel registarVeiculo;
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
    private JTextField Matricula;
    private JTextField Marca;
    private JTextField Modelo;
    private JSpinner Quilometragem;
    private JTextField Cor;
    private JTextField Observacoes;
    private JTextField MotivoVenda;
    private JComboBox AnteriorDono;
    private JButton btnAdicionarActionPerformed;
    private JButton btnCancelarActionPerformed;
    private MenuAux menuAux;


    public RegistarVeiculo() {
        setContentPane(registarVeiculo);
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
        btnCancelarActionPerformed.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e) {

        RegistarVeiculo registarVeiculo = new RegistarVeiculo();
        registarVeiculo.setVisible(true);
    }
    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
        JanelaVeiculos janelaVeiculos = new JanelaVeiculos();
        janelaVeiculos.setVisible(true);
    }
}
