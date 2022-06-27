package vista.eventos;

import modelo.DadosApp;
import modelo.Evento;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.LinkedList;

public class JanelaEventos extends JFrame {
    private JPanel painelEventos;
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
    private JPanel painelEventos1;
    private JPanel painelEventos2;
    private JList listaDeEventos;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarEvento;
    private LinkedList<Evento> eventos;
    private Evento eventoSelecionado;
    private MenuAux menuAux;

    public JanelaEventos() {
        setContentPane(painelEventos);
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
        //Lista de eventos
        DadosApp da = DadosApp.getInstancia();
        eventos = da.getEventos();

        DefaultListModel model = new DefaultListModel();
        for (Evento e : eventos) {
            listaDeEventos.setModel(model);
            model.addElement("Filial: "+e.getFilial().getDesignacao()+"   Localização: "+e.getLocalizacao()+"   Data de início:"+e.getDataInicio().getData()+" Data de fim:"+e.getDateFim().getData());
        }
        listaDeEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        registarEvento.addActionListener(this::btnRegistarActionPerformed);
        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnRegistarActionPerformed(ActionEvent e) {

        RegistarEvento registarEvento = new RegistarEvento();
        registarEvento.setVisible(true);
    }
    private void btnConsultarActionPerformed(ActionEvent e){
        int selected = listaDeEventos.getSelectedIndex();
        if(selected < 0) {
            return;
        }
        eventoSelecionado = eventos.get(selected);
        new DadosEvento(eventoSelecionado, false);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        int selected = listaDeEventos.getSelectedIndex();
        if(selected < 0) {
            return;
        }
        eventoSelecionado = eventos.get(selected);
        new DadosEvento(eventoSelecionado, true);
    }
    private void btnEliminarActionPerformed(ActionEvent e){
        if(listaDeEventos.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar este evento ?");
            if (result == 0) {
                //Sim
                if (listaDeEventos.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerEvento(eventos.get(listaDeEventos.getSelectedIndex()));
                    dispose();
                }
            }
            if (result >= 1) {
                //Não
                dispose();
            }
        }
    }

}
