package vista.filiais;

import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class RegistarFilial extends JDialog {
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

    private JPanel painelFiliais;
    private JTextField textLocalizacao;
    private JTextField textMorada;
    private JTextField textNumMaxVeiculos;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField textDesignacao;
    private JRadioButton cbSede;
    private JList listVeiculos;
    private JList listOficinas;
    private JList listArmazens;

    private LinkedList<Oficina> oficinasSelecionadas;
    private LinkedList<Veiculo> veiculosSelecionados;
    private LinkedList<Armazem> armazensSelecionados;

    LinkedList<Oficina> oficinas;
    LinkedList<Veiculo> veiculos;
    LinkedList<Armazem> armazens;

    public RegistarFilial() {
        setContentPane(painelFiliais);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        adicionarButton.addActionListener(this::btnRegistarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        oficinasSelecionadas = new LinkedList<>();
        veiculosSelecionados = new LinkedList<>();
        armazensSelecionados = new LinkedList<>();

        DefaultListModel modelOficinas = new DefaultListModel();
        DefaultListModel modelVeiculos = new DefaultListModel();
        DefaultListModel modelArmazens = new DefaultListModel();

        oficinas = DadosApp.getInstancia().getOficinas();
        veiculos = DadosApp.getInstancia().getVeiculos();
        armazens = DadosApp.getInstancia().getArmazens();

        for (Oficina oficina : oficinas) {
            listOficinas.setModel(modelOficinas);
            modelOficinas.addElement("Nome: " + oficina.getNome());
        }

        for (Veiculo veiculo : veiculos) {
            listVeiculos.setModel(modelVeiculos);
            modelVeiculos.addElement("Matrícula: " + veiculo.getMatricula() + "     Marca: " + veiculo.getMarca() + "     Modelo: " + veiculo.getModelo());
        }

        for (Armazem armazem : armazens) {
            listArmazens.setModel(modelArmazens);
            modelArmazens.addElement("Nome: " + armazem.getNome());
        }

        pack();
        setVisible(true);
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnRegistarActionPerformed(ActionEvent e) {
        // Oficinas selecionados
        int[] indicesOficina = listOficinas.getSelectedIndices();
        for (int selectedIndex : indicesOficina) {
            oficinasSelecionadas.add(oficinas.get(selectedIndex));
        }

        // Veiculos selecionados
        int[] indicesVeiculo = listVeiculos.getSelectedIndices();
        for (int selectedIndex : indicesVeiculo) {
            veiculosSelecionados.add(veiculos.get(selectedIndex));
        }

        // Armazens selecionados
        int[] indicesArmazem = listArmazens.getSelectedIndices();
        for (int selectedIndex : indicesArmazem) {
            armazensSelecionados.add(armazens.get(selectedIndex));
        }

        DadosApp.getInstancia().inserirFilial(
                new Filial(oficinasSelecionadas,
                        armazensSelecionados,
                        cbSede.isSelected(),
                        textDesignacao.getText(),
                        textLocalizacao.getText(),
                        textMorada.getText(),
                        Integer.parseInt(textNumMaxVeiculos.getText()),
                        veiculosSelecionados
                )
        );

        dispose();
    }
}
