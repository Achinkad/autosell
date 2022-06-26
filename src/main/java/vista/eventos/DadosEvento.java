package vista.eventos;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;
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
        nMaxVeiculos.setValue(evento.getNumMaxVeiuclos());
        dataInicio.setValue(evento.getDataInicio().getDate());
        mesInicio.setValue(evento.getDataInicio().getMonth());
        anoInicio.setValue(evento.getDataInicio().getYear());
        dataFim.setValue(evento.getDateFim().getDate());
        mesFim.setValue(evento.getDateFim().getMonth());
        anoFim.setValue(evento.getDateFim().getYear());
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
        Date dateInicio= new Date((Integer)anoInicio.getValue(),(Integer)mesInicio.getValue(),(Integer)dataInicio.getValue());
        Date dateFim= new Date((Integer)anoFim.getValue(),(Integer)mesFim.getValue(),(Integer)dataFim.getValue());
        eventoPresente.setDesignacao(designacao.getText());
        eventoPresente.setLocalizacao(localizacao.getText());
        eventoPresente.setMorada(morada.getText());
        eventoPresente.setNumMaxVeiuclos((Integer)nMaxVeiculos.getValue());
        eventoPresente.setDataInicio(dateInicio);
        eventoPresente.setDateFim(dateFim);
        int selectedFilial = listaFiliais.getSelectedIndex();
        if(selectedFilial < 0) {
            return;
        }
        filialSelecionada = filiais.get(selectedFilial);
        eventoPresente.setFilial(filialSelecionada);

        dispose();
    }
    private void btnCancelarActionListener(ActionEvent e){
        dispose();
    }

}
