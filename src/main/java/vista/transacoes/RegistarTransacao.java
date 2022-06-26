package vista.transacoes;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class RegistarTransacao extends JDialog {
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
    private JTextField textNome;
    private JTextField textTelefone;
    private JList list1;
    private JTextField textValor;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JList listClientes;
    private JList listVeiculos;
    private JComboBox comboBox1;

    private MenuAux menuAux;


    public RegistarTransacao(){
        setContentPane(painelPrincipal);
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

        //Criar novo armazém
        /*LinkedList<Peca> pecasParaOArmazem = DadosApp.getInstancia().getPecas();
        DefaultListModel model = new DefaultListModel();
        for (Peca p : pecasParaOArmazem) {
            list1.setModel(model);
            model.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca());
        }
        this.pecasParaOArmazem = pecasParaOArmazem;*/

        DefaultListModel modelV = new DefaultListModel();
        DefaultListModel modelC = new DefaultListModel();
            for (Veiculo v : DadosApp.getInstancia().getVeiculos()) {
                listVeiculos.setModel(modelV);
                modelV.addElement("Matricula: "+v.getMatricula());
            }
            for (Cliente c : DadosApp.getInstancia().getClientes()) {
                listClientes.setModel(modelC);
                modelC.addElement("Nome: "+c.getNome());
            }


        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e){
        DadosApp.getInstancia().addTransacao(new Transacao(DadosApp.getInstancia().getClientes().get(listClientes.getSelectedIndex()),DadosApp.getInstancia().getVeiculos().get(listVeiculos.getSelectedIndex()),Integer.parseInt(textValor.getText())));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }

}
