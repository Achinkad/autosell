package vista.armazens;

import modelo.Armazem;
import modelo.DadosApp;
import modelo.Peca;
import vista.Erros;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class RegistarArmazem extends JDialog {
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
    private JTextField textField1;
    private JPanel painelPrincipal;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JLabel lblNome;
    private JLabel lblTelefone;
    private JLabel lblPecas;

    private MenuAux menuAux;

    private LinkedList<Peca> pecasParaOArmazem;

    public RegistarArmazem(){
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
        LinkedList<Peca> pecasParaOArmazem = DadosApp.getInstancia().getPecas();
        DefaultListModel model = new DefaultListModel();
        for (Peca p : pecasParaOArmazem) {
            list1.setModel(model);
            model.addElement("Descrição: "+p.getDescricao()+"   Marca: "+p.getMarca());
        }
        this.pecasParaOArmazem = pecasParaOArmazem;


        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
        cancelarButton.addActionListener(this::btnCancelarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e){
        LinkedList<Peca> pecasDoArmazem = new LinkedList<>();
        int i = 0;
        int[] indices = list1.getSelectedIndices();
        for (int selectedIndex : indices) {
            pecasDoArmazem.add(pecasParaOArmazem.get(selectedIndex));
        }

        if(textNome.getText().length() < 2 || textNome.getText().length() > 255){
            Erros.mostrarErro(this,1,Erros.removeLastChar(lblNome.getText()));
            return;
        }
        if(!textTelefone.getText().matches("\\d{9}")){
            Erros.mostrarErro(this,2,Erros.removeLastChar(lblTelefone.getText()));
            return;
        }
        if(pecasDoArmazem.size() <= 0){
            Erros.mostrarErro(this,2,Erros.removeLastChar(lblPecas.getText()));
            return;
        }
        if(pecasDoArmazem.size() <= 0 || !Integer.toString(pecasDoArmazem.size()).matches("\\d{1,10000}")){
            Erros.mostrarErro(this,4,"Quantidade de Peças ");
            return;
        }

        DadosApp.getInstancia().inserirArmazem(new Armazem(textNome.getText(),Integer.parseInt(textTelefone.getText()),pecasDoArmazem,pecasDoArmazem.size()));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e){
        dispose();
    }

}
