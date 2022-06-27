package vista.transportes;

import modelo.DadosApp;
import modelo.Local;
import modelo.Transporte;
import vista.Erros;
import vista.MenuAux;
import modelo.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DadosTransporte extends JDialog{
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
    private JTextArea designacao;
    private JButton editarButton;
    private JButton cancelarButton;
    private JSpinner dataInicio;
    private JSpinner anoFim;
    private JSpinner mesFim;
    private JSpinner dataFim;
    private JSpinner mesInicio;
    private JSpinner anoInicio;
    private JLabel Item;
    private JButton associarItemButton;
    private JButton desassociarItemButton;
    private JList listaLocais;
    private Transporte transportePresente;
    private MenuAux menuAux;
    private LinkedList<Local> locais;
    private Local localSelecionado;

    public DadosTransporte(Transporte transporte, boolean isEditavel){
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        transportePresente = transporte;

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
        associarItemButton.setVisible(false);
        desassociarItemButton.setVisible(false);
        Item.setVisible(false);

        dataInicio.setValue(transporte.getDataExpedicao().getDia());
        mesInicio.setValue(transporte.getDataExpedicao().getMes());
        anoInicio.setValue(transporte.getDataExpedicao().getAno());
        dataFim.setValue(transporte.getDataEntrega().getDia());
        mesFim.setValue(transporte.getDataEntrega().getMes());
        anoFim.setValue(transporte.getDataEntrega().getAno());
        //Lista de locais
        DadosApp da = DadosApp.getInstancia();
        locais = da.getLocais();
        DefaultListModel model1 = new DefaultListModel();
        for (Local l : locais) {
            listaLocais.setModel(model1);
            model1.addElement("Local: " + l.getDesignacao());
        }
        listaLocais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);





        if(isEditavel){
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
            cancelarButton.setVisible(true);
            cancelarButton.addActionListener(this::btnCancelarActionListener);
            associarItemButton.setVisible(true);
            desassociarItemButton.setVisible(true);
            Item.setVisible(true);
        }

        pack();
        setVisible(true);
    }
    private void btnEditarActionListener(ActionEvent e){
        Date dateExpedicao= new Date((Integer)dataInicio.getValue(),(Integer)mesInicio.getValue(),(Integer)anoInicio.getValue());
        Date dataEntrega= new Date((Integer)dataFim.getValue(),(Integer)mesFim.getValue(),(Integer)anoFim.getValue());


        int selectedFilial = listaLocais.getSelectedIndex();
        if(selectedFilial < 0) {
            return;
        }
        localSelecionado= locais.get(selectedFilial);
        if (dateExpedicao == null || dateExpedicao.getDia() > 31 || dateExpedicao.getMes() > 12 || dateExpedicao.getAno() < 1900) {
            Erros.mostrarErro(this, 10, Erros.removeLastChar(dateExpedicao.getData()));
        }else if (dataEntrega == null || dataEntrega.getDia() > 31 || dataEntrega.getMes() > 12 || dataEntrega.getAno() < 1900 || dateExpedicao.getAno() * 100000000 + dateExpedicao.getMes() * 10000 + dateExpedicao.getDia() * 100 > dataEntrega.getAno() * 100000000 + dataEntrega.getMes() * 10000 + dataEntrega.getDia() * 100) {
                Erros.mostrarErro(this, 12, Erros.removeLastChar(dataEntrega.getData()));
                return;
            }
        else {

            transportePresente.setDataEntrega(dataEntrega);
            transportePresente.setDataExpedicao(dateExpedicao);

            transportePresente.setLocalEntrega(localSelecionado);

            dispose();
        }
    }
    private void btnCancelarActionListener(ActionEvent e){
        dispose();
    }
}
