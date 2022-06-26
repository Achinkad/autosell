package vista.filiais;

import modelo.*;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosFilial extends JDialog {
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
    private JTextField textLocalizacao;
    private JTextField textMorada;
    private JTextField textNumMaxVeiculos;
    private JButton editarButton;
    private JButton cancelarButton;
    private JTextField textDesignacao;
    private JList listVeiculos;
    private JList listOficinas;
    private JRadioButton cbSede;
    private JList listArmazens;
    private JPanel painelPrincipal;
    private JLabel lbDesignacao;
    private JLabel lbLocalizacao;
    private JLabel lbMorada;
    private JLabel lbNumVeiculos;
    private JLabel lbSede;
    private JLabel lbVeiculos;
    private JLabel lbArmazens;
    private JLabel lbOficinas;

    private MenuAux menuAux;

    private Filial filialAtual;

    LinkedList<Oficina> oficinas;
    LinkedList<Veiculo> veiculos;
    LinkedList<Armazem> armazens;

    private LinkedList<Oficina> oficinasSelecionadas;
    private LinkedList<Veiculo> veiculosSelecionados;
    private LinkedList<Armazem> armazensSelecionados;

    public DadosFilial(Filial filial, boolean isEditavel) {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        filialAtual = filial;

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

        DefaultListModel modelOficinas = new DefaultListModel();
        DefaultListModel modelVeiculos = new DefaultListModel();
        DefaultListModel modelArmazens = new DefaultListModel();

        oficinas = filial.getOficinas();
        veiculos = filial.getVeiculos();
        armazens = filial.getArmazens();

        textDesignacao.setText(filial.getDesignacao());
        textLocalizacao.setText(filial.getLocalizacao());
        textMorada.setText(filial.getMorada());
        textNumMaxVeiculos.setText(Integer.toString(filial.getNumeroMaxVeiculos()));
        cbSede.setSelected(filial.isSede());

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

        if(isEditavel) {
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
        }

        cancelarButton.addActionListener(this::btnCancelarActionListener);

        pack();
        setVisible(true);
    }

    private void btnEditarActionListener(ActionEvent e) {
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
        else if (Erros.checkSedeEditavel(sede, filialAtual))
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

            filialAtual.setDesignacao(designacao);
            filialAtual.setLocalizacao(localizacao);
            filialAtual.setMorada(morada);
            filialAtual.setSede(sede);
            filialAtual.setVeiculos(veiculosSelecionados);
            filialAtual.setArmazens(armazensSelecionados);
            filialAtual.setOficinas(oficinasSelecionadas);
            dispose();
        }
    }

    private void btnCancelarActionListener(ActionEvent e) {
        dispose();
    }
}
