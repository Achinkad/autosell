package vista.transportes;

import modelo.*;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RegistarTransporte extends JDialog {
    private JPanel registarTransporte;
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
    private JButton btnAdicionarActionPerformed;
    private JButton btnCancelarActionPerformed;
    private JList listaItems;
    private JTextField localEntrega;
    private JSpinner diaExpedicao;
    private JSpinner mesExpedicao;
    private JSpinner anoExpedicao;
    private JSpinner diaEntrega;
    private JSpinner mesEntrega;
    private JSpinner anoEntrega;
    private JCheckBox veiculoCheckBox;
    private JCheckBox pecaCheckBox;
    private JList listaLocais;
    private MenuAux menuAux;
    private LinkedList<Transporte> transportesSelecionados;
    private LinkedList<Transporte> transportes;
    private LinkedList<Veiculo> veiculos;
    private LinkedList<Peca> pecas;

    private LinkedList<Item> itemsSelecionados;
    private LinkedList<Veiculo> veiculosSelecionados;
    private LinkedList<Peca> pecasSelecionadas;
    private LinkedList<Local> locais;
    private Local localSelecionado;


    public RegistarTransporte() {
        setContentPane(registarTransporte);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menuAux = new MenuAux();
        LinkedList<JButton> menuItems = new LinkedList<>();
        pecasSelecionadas = new LinkedList<>();
        veiculosSelecionados = new LinkedList<>();
        transportesSelecionados = new LinkedList<>();
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
        veiculoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    pecaCheckBox.setSelected(false);
                    //Lista de eventos
                    DadosApp da = DadosApp.getInstancia();
                    veiculos = da.getVeiculos();
                    DefaultListModel model1 = new DefaultListModel();
                    for (Veiculo v : veiculos) {
                        listaItems.setModel(model1);
                        model1.addElement("Marca: " + v.getMarca() + "  Modelo: " + v.getModelo());
                    }
                    listaItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                } else {
                    // check box is unselected, do something else
                }
            }
        });
        pecaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    veiculoCheckBox.setSelected(false);
                    DadosApp da = DadosApp.getInstancia();
                    pecas = da.getPecas();
                    DefaultListModel model1 = new DefaultListModel();
                    for (Peca p : pecas) {
                        listaItems.setModel(model1);
                        model1.addElement("Marca: " + p.getMarca() + "  Marca carro: " + p.getMarcaVeiculo()+ "   Modelo carro: " + p.getModeloVeiculo());
                    }
                    listaItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    // do something if check box is selected
                } else {
                    // check box is unselected, do something else
                }
            }
        });


        //Lista de locais
        DadosApp da = DadosApp.getInstancia();
        locais = da.getLocais();
        DefaultListModel model1 = new DefaultListModel();
        for (Local l : locais) {
            listaLocais.setModel(model1);
            model1.addElement("Local: " + l.getDesignacao());
        }
        listaLocais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnCancelarActionPerformed.addActionListener(this::btnCancelarActionPerformed);
        btnAdicionarActionPerformed.addActionListener(this::btnAdicionarActionPerformed);
        pack();
        setVisible(true);
    }


        private void btnAdicionarActionPerformed(ActionEvent e) {
            System.out.println(anoExpedicao.getValue());
            Date dataExpedicao = new Date((Integer) diaExpedicao.getValue(), (Integer) mesExpedicao.getValue(), (Integer) anoExpedicao.getValue());
            Date dataEntrega = new Date((Integer) diaEntrega.getValue(), (Integer) mesEntrega.getValue(), (Integer) mesEntrega.getValue());
            int selectedLocal = listaLocais.getSelectedIndex();
            if (selectedLocal < 0) {
                return;
            }
            localSelecionado = locais.get(selectedLocal);
            if (dataExpedicao == null || dataExpedicao.getDia() > 31 || dataExpedicao.getMes() > 12 || dataExpedicao.getAno() > 1900) {
                Erros.mostrarErro(this, 10, Erros.removeLastChar(dataExpedicao.getData()));

                if (dataEntrega == null || dataEntrega.getDia() > 31 || dataEntrega.getMes() > 12 || dataEntrega.getAno() > 1900 || dataEntrega.getDia() * 100000000 + dataEntrega.getMes() * 1000000 + dataEntrega.getAno() * 10000 > dataEntrega.getDia() * 100000000 + dataEntrega.getMes() * 1000000 + dataEntrega.getAno() * 10000) {
                    Erros.mostrarErro(this, 12, Erros.removeLastChar(dataEntrega.getData()));
                    return;
                }

            } else {
                if (veiculoCheckBox.isSelected()) {
                    int[] selectedVeiculos = listaItems.getSelectedIndices();
                    if (selectedVeiculos.length < 0) {
                        return;
                    }
                    for (int i : selectedVeiculos) {
                        veiculosSelecionados.add(veiculos.get(i));
                    }
                    DadosApp.getInstancia().addTransporte(new TransporteVeiculo(veiculosSelecionados, dataExpedicao, dataEntrega, localSelecionado));
                    dispose();
                }
                if (pecaCheckBox.isSelected()) {
                    int[] selectedPecas = listaItems.getSelectedIndices();
                    if (selectedPecas.length < 0) {
                        return;
                    }
                    for (int i : selectedPecas) {
                        pecasSelecionadas.add(pecas.get(i));
                    }
                    DadosApp.getInstancia().addTransporte(new TransportePeca(pecasSelecionadas, dataExpedicao, dataEntrega, localSelecionado));
                    dispose();
                }
            }
        }



        private void btnCancelarActionPerformed(ActionEvent e) {
            dispose();
            JanelaTransportes janelaTransportes = new JanelaTransportes();
            janelaTransportes.setVisible(true);
        }



    }

