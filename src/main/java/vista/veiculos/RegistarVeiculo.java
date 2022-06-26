package vista.veiculos;

import modelo.*;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class RegistarVeiculo extends JDialog {
    private JPanel registarVeiculo;
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
    private JTextField Matricula;
    private JTextField Marca;
    private JTextField Modelo;
    private JSpinner Quilometragem;
    private JTextField Cor;
    private JTextField Observacoes;
    private JTextField MotivoVenda;
    private JComboBox<String> AnteriorDono;
    private JButton btnAdicionarActionPerformed;
    private JButton btnCancelarActionPerformed;

    private String anteriorDonoBack;
    private LinkedList<Cliente> clientes;
    private Cliente cliente;
    private MenuAux menuAux;


    public RegistarVeiculo() {
        setContentPane(registarVeiculo);
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
        DadosApp da = DadosApp.getInstancia();
        clientes = da.getClientes();
        for (Cliente cliente : clientes) {
            AnteriorDono.addItem(cliente.getNome());
        }
        AnteriorDono.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Value: " + AnteriorDono.getSelectedItem().toString());
                anteriorDonoBack=AnteriorDono.getSelectedItem().toString();
            }
        });
        btnCancelarActionPerformed.addActionListener(this::btnCancelarActionPerformed);
        btnAdicionarActionPerformed.addActionListener(this::btnAdicionarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e) {

        for(Cliente c: clientes){
            if (c.getNome() == anteriorDonoBack){
                cliente=c;
                System.out.println(cliente);
                break;
            }
        }
        DadosApp.getInstancia().addVeiculo(new Veiculo(Matricula.getText(),Marca.getText(),Modelo.getText(),Cor.getText(),(Integer) Quilometragem.getValue(),Observacoes.getText(),cliente,null,MotivoVenda.getText()));
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
        JanelaVeiculos janelaVeiculos = new JanelaVeiculos();
        janelaVeiculos.setVisible(true);
    }
}
