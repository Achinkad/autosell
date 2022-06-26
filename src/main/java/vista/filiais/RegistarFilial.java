package vista.filiais;

import modelo.*;
import vista.Erros;

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
    private JLabel lbDesignacao;
    private JLabel lbLocalizacao;
    private JLabel lbMorada;
    private JLabel lbNumVeiculos;
    private JLabel lbSede;
    private JLabel lbVeiculos;
    private JLabel lbArmazens;
    private JLabel lbOficinas;

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
        String designacao = textDesignacao.getText();
        String localizacao = textLocalizacao.getText();
        String morada = textMorada.getText();
        int numMaxVeiculos = (textNumMaxVeiculos.getText().isEmpty() ? -1 : Integer.parseInt(textNumMaxVeiculos.getText()));
        boolean sede = cbSede.isSelected();

        if (designacao.length() < 2 || designacao.length() > 255)
        {
            Erros.mostrarErro(this, 1, Erros.removeLastChar(lbDesignacao.getText()));
        }
        else if (localizacao.length() < 2 || localizacao.length() > 255)
        {
            Erros.mostrarErro(this, 1, Erros.removeLastChar(lbLocalizacao.getText()));
        }
        else if (morada.length() < 2 || morada.length() > 255)
        {
            Erros.mostrarErro(this, 1, Erros.removeLastChar(lbMorada.getText()));
        }
        else if (numMaxVeiculos < 0 || numMaxVeiculos > 100)
        {
            Erros.mostrarErro(this, 7, Erros.removeLastChar(lbNumVeiculos.getText()));
        }
        else if (Erros.checkSede(sede))
        {
            Erros.mostrarErro(this, 8, null);
        }
        else
        {
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

            // Oficinas selecionados
            int[] indicesOficina = listOficinas.getSelectedIndices();
            for (int selectedIndex : indicesOficina) {
                oficinasSelecionadas.add(oficinas.get(selectedIndex));
            }

            DadosApp.getInstancia().inserirFilial(
                    new Filial(
                            oficinasSelecionadas,
                            armazensSelecionados,
                            sede,
                            designacao,
                            localizacao,
                            morada,
                            numMaxVeiculos,
                            veiculosSelecionados
                    )
            );

            dispose();
        }

    }
}
