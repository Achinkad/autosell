package vista.eventos;

import modelo.*;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosEvento extends JDialog{
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
    private JTextField localizacao;
    private JTextField morada;
    private JTextArea designacao;
    private JButton editarButton;
    private JButton cancelarButton;
    private JSpinner dataInicio;
    private JSpinner anoFim;
    private JSpinner mesFim;
    private JSpinner dataFim;
    private JSpinner mesInicio;
    private JSpinner anoInicio;
    private JSpinner nMaxVeiculos;
    private JList listaFiliais;
    private JLabel associarVeiculos;
    private JButton associarVeiculoButton;
    private JButton desassociarVeiculoButton;
    private LinkedList<Filial> filiais;
    private Filial filialSelecionada;
    private MenuAux menuAux;

    private Evento eventoPresente;
    public DadosEvento(Evento evento, boolean isEditavel){
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        eventoPresente = evento;

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
        associarVeiculoButton.setVisible(false);
        desassociarVeiculoButton.setVisible(false);
        associarVeiculos.setVisible(false);
        designacao.setText(evento.getDesignacao());
        localizacao.setText(evento.getLocalizacao());
        morada.setText(evento.getMorada());
        nMaxVeiculos.setValue(evento.getNumeroMaxVeiculos());
        dataInicio.setValue(evento.getDataInicio().getDia());
        mesInicio.setValue(evento.getDataInicio().getMes());
        anoInicio.setValue(evento.getDataInicio().getAno());
        dataFim.setValue(evento.getDateFim().getDia());
        mesFim.setValue(evento.getDateFim().getMes());
        anoFim.setValue(evento.getDateFim().getAno());
        DadosApp da = DadosApp.getInstancia();
        filiais = da.getFiliais();
        DefaultListModel model = new DefaultListModel();
        for (Filial f : filiais) {
            listaFiliais.setModel(model);
            model.addElement("Filial: " + f.getDesignacao());
        }
        listaFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaFiliais.setSelectedValue(evento,true);





        if(isEditavel){
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
            cancelarButton.setVisible(true);
            cancelarButton.addActionListener(this::btnCancelarActionListener);
            associarVeiculoButton.setVisible(true);
            desassociarVeiculoButton.setVisible(true);
            associarVeiculos.setVisible(true);
        }

        pack();
        setVisible(true);
    }
    private void btnEditarActionListener(ActionEvent e){
        Date dateInicio= new Date((Integer)dataInicio.getValue(),(Integer)mesInicio.getValue(),(Integer)anoInicio.getValue());
        Date dateFim= new Date((Integer)dataFim.getValue(),(Integer)mesFim.getValue(),(Integer)anoFim.getValue());
        String designacaoA=designacao.getText();
        String localizacaoA = localizacao.getText();
        String moradaA=morada.getText();
        int maxVeiculo=(Integer)nMaxVeiculos.getValue();
        int selectedFilial = listaFiliais.getSelectedIndex();
        if(selectedFilial < 0) {
            return;
        }
        filialSelecionada = filiais.get(selectedFilial);
        if (filialSelecionada==null){
            Erros.mostrarErro(this, 2, Erros.removeLastChar(filialSelecionada.getDesignacao()));

            if (localizacaoA.isEmpty() || localizacaoA.length()<2 || localizacaoA.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(localizacaoA));


            }else if(moradaA.isEmpty() || moradaA.length()<2 || moradaA.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(moradaA));

            } else if (maxVeiculo>=0 || maxVeiculo>500) {
                Erros.mostrarErro(this,9,Erros.removeLastChar(String.valueOf(maxVeiculo)));

            } else if (dateInicio==null || dateInicio.getDia()>31 || dateInicio.getMes()>12 || dateInicio.getAno()>1900) {
                Erros.mostrarErro(this, 10, Erros.removeLastChar(dateInicio.getData()));


            } else if (dateFim==null || dateInicio.getDia()>31 || dateInicio.getMes()>12 || dateInicio.getAno()>1900 || dateInicio.getDia()*100000000+dateInicio.getMes()*1000000+dateInicio.getAno()*10000>dateFim.getDia()*100000000+dateFim.getMes()*1000000+dateFim.getAno()*10000) {
                Erros.mostrarErro(this, 11, Erros.removeLastChar(dateFim.getData()));

            }
        }else {
            eventoPresente.setDesignacao(designacaoA);
            eventoPresente.setLocalizacao(localizacaoA);
            eventoPresente.setMorada(moradaA);
            eventoPresente.setNumeroMaxVeiculos(maxVeiculo);
            eventoPresente.setDataInicio(dateInicio);
            eventoPresente.setDateFim(dateFim);
            eventoPresente.setFilial(filialSelecionada);
            dispose();
        }









    }
    private void btnCancelarActionListener(ActionEvent e){
        dispose();
    }

}
