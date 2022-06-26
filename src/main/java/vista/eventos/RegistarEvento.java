package vista.eventos;

import modelo.*;
import vista.MenuAux;
import vista.veiculos.DadosVeiculo;
import vista.veiculos.JanelaVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RegistarEvento extends JDialog {
    private JPanel registarEvento;
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
    private JTextField designacao;
    private JTextField localizacao;
    private JTextField morada;
    private JSpinner nMaxVeiculos;
    private JButton btnAdicionarActionPerformed;
    private JButton btnCancelarActionPerformed;
    private JSpinner diaInicio;
    private JSpinner mesInicio;
    private JSpinner anoInicio;
    private JSpinner anoDim;
    private JSpinner mesFim;
    private JSpinner diaFim;
    private JList listaFiliais;
    private JList listaVeículos;
    private LinkedList<Filial> filiais;
    private LinkedList<Veiculo> veiculos;
    private Filial filialSelecionada;

    private LinkedList<Veiculo> veiculosSelecionados;
    private MenuAux menuAux;

    public RegistarEvento() {
        setContentPane(registarEvento);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menuAux = new MenuAux();
        LinkedList<JButton> menuItems = new LinkedList<>();
        veiculosSelecionados= new LinkedList<>();
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
        //Lista de eventos
        DadosApp da = DadosApp.getInstancia();
        filiais = da.getFiliais();
        DefaultListModel model = new DefaultListModel();
        for (Filial f : filiais) {
            listaFiliais.setModel(model);
            model.addElement("Filial: " + f.getDesignacao());
        }
        listaFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        veiculos = da.getVeiculos();
        DefaultListModel model1 = new DefaultListModel();
        for (Veiculo v : veiculos) {
            listaVeículos.setModel(model1);
            model1.addElement("Marca: " + v.getMarca() + "  Modelo: " + v.getModelo());
        }
        listaVeículos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnCancelarActionPerformed.addActionListener(this::btnCancelarActionPerformed);
        btnAdicionarActionPerformed.addActionListener(this::btnAdicionarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e) {

        int selectedFilial = listaFiliais.getSelectedIndex();
        if(selectedFilial < 0) {
            return;
        }
        filialSelecionada = filiais.get(selectedFilial);
        int [] selectedVeiculos = listaVeículos.getSelectedIndices();
        if (selectedVeiculos.length<0){
            return;
        }
        for (int i: selectedVeiculos) {
            veiculosSelecionados.add(veiculos.get(i));
        }
        if(veiculos.size()>(Integer)nMaxVeiculos.getValue()){
            return;
        }
        Date dataInicio= new Date((Integer)diaInicio.getValue(),(Integer)mesInicio.getValue(),(Integer)anoInicio.getValue());
        Date dataFim= new Date((Integer)diaFim.getValue(),(Integer)mesFim.getValue(),(Integer)anoDim.getValue());


            DadosApp.getInstancia().addEvento(new Evento(dataInicio,dataFim,filialSelecionada,designacao.getText(),localizacao.getText(),morada.getText(),(Integer)nMaxVeiculos.getValue(),veiculosSelecionados));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
        JanelaEventos janelaEventos = new JanelaEventos();
        janelaEventos.setVisible(true);
    }
}
