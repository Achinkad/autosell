package vista.transportes;

import modelo.DadosApp;
import modelo.Transporte;
import modelo.Veiculo;
import vista.MenuAux;
import vista.oficinas.RegistarOficina;
import vista.veiculos.DadosVeiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.LinkedList;

public class JanelaTransportes extends JFrame {
    private JPanel painelTransportes;
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
    private JPanel painelTransportes1;
    private JPanel painelTransportes2;
    private JList listaDeTransportes;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton registarTransporteButton;
    private LinkedList<Transporte> transportes;
    private MenuAux menuAux;
    private Transporte transporteSelecionado;

    public JanelaTransportes() {
        setContentPane(painelTransportes);
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
        //Lista de transportes
        DadosApp da = DadosApp.getInstancia();
        transportes = da.getTransportes();

        DefaultListModel model = new DefaultListModel();
        for (Transporte t : transportes) {
            listaDeTransportes.setModel(model);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale());
            model.addElement("Data de expedição:"+t.getDataExpedicao().getData()+" Local entrega: "+t.getLocalEntrega().getDesignacao());

        }
        listaDeTransportes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        registarTransporteButton.addActionListener(this::btnRegistarActionPerformed);
        consultarButton.addActionListener(this::btnConsultarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        eliminarButton.addActionListener(this::btnEliminarActionPerformed);
        pack();
        setVisible(true);

    }
    private void btnRegistarActionPerformed(ActionEvent e) {
        new RegistarTransporte();
    }
    private void btnConsultarActionPerformed(ActionEvent e){
        int selected = listaDeTransportes.getSelectedIndex();
        if(selected < 0) {
            return;
        }
        transporteSelecionado = transportes.get(selected);
        new DadosTransporte(transporteSelecionado, false);
    }

    private void btnEditarActionPerformed(ActionEvent e){
        int selected = listaDeTransportes.getSelectedIndex();
        if(selected < 0) {
            return;
        }
        transporteSelecionado = transportes.get(selected);
        new DadosTransporte(transporteSelecionado, true);
    }
    private void btnEliminarActionPerformed(ActionEvent e){
        if(listaDeTransportes.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(new JFrame(), "Pretende eliminar este transporte ?");
            if (result == 0) {
                //Sim
                if (listaDeTransportes.getSelectedIndex() >= 0) {
                    DadosApp.getInstancia().removerTransporte(transportes.get(listaDeTransportes.getSelectedIndex()));
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
