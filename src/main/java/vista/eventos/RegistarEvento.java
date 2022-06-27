package vista.eventos;

import modelo.*;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
        String designacaoA=designacao.getText();
        String localizacaoA = localizacao.getText();
        String moradaA=morada.getText();
        int maxVeiculo=(Integer)nMaxVeiculos.getValue();
        if (filialSelecionada==null){
            Erros.mostrarErro(this, 2, Erros.removeLastChar(filialSelecionada.getDesignacao()));

            if (localizacaoA.isEmpty() || localizacaoA.length()<2 || localizacaoA.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(localizacaoA));


            }else if(moradaA.isEmpty() || moradaA.length()<2 || moradaA.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(moradaA));

            } else if (maxVeiculo>=0 || maxVeiculo>500) {
                Erros.mostrarErro(this,9,Erros.removeLastChar(String.valueOf(maxVeiculo)));
                
            } else if (veiculosSelecionados.isEmpty()) {
                Erros.mostrarErro(this, 2, Erros.removeLastChar(null));

            } else if (dataInicio==null || dataInicio.getDia()>31 || dataInicio.getMes()>12 || dataInicio.getAno()>1900) {
                Erros.mostrarErro(this, 10, Erros.removeLastChar(dataInicio.getData()));

                
            } else if (dataFim==null || dataInicio.getDia()>31 || dataInicio.getMes()>12 || dataInicio.getAno()>1900 || dataInicio.getDia()*100000000+dataInicio.getMes()*1000000+dataInicio.getAno()*10000>dataFim.getDia()*100000000+dataFim.getMes()*1000000+dataFim.getAno()*10000) {
                Erros.mostrarErro(this, 11, Erros.removeLastChar(dataFim.getData()));

            }
        }else {
            DadosApp.getInstancia().inserirEvento(new Evento(dataInicio, dataFim, filialSelecionada, designacaoA, localizacaoA, moradaA, maxVeiculo, veiculosSelecionados));
        }
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
        JanelaEventos janelaEventos = new JanelaEventos();
        janelaEventos.setVisible(true);
    }
}
