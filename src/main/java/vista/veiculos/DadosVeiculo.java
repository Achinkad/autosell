package vista.veiculos;

import modelo.Cliente;
import modelo.DadosApp;
import modelo.Veiculo;
import vista.MenuAux;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DadosVeiculo extends JDialog {
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
    private JTextField Matricula;
    private JTextField Marca;
    private JTextField Modelo;
    private JTextField MotivoVenda;
    private JTextArea Observacoes;
    private JTextField Cor;
    private JButton editarButton;
    private JSpinner Quilometragem;
    private JButton cancelarButton;
    private JComboBox<String> anteriorDono;

    private String anteriorDonoBack;

    private Cliente cliente;
    LinkedList<Cliente> clientes;
    private MenuAux menuAux;

    private Veiculo veiculoPresente;
    public DadosVeiculo(Veiculo veiculo, boolean isEditavel){
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        veiculoPresente = veiculo;

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

        Matricula.setText(veiculo.getMatricula());
        Marca.setText(veiculo.getMarca());
        Modelo.setText(veiculo.getModelo());
        Quilometragem.setValue(veiculo.getQuilometragem());
        Cor.setText(veiculo.getCor());
        Observacoes.setText(veiculo.getDescricao());
        MotivoVenda.setText(veiculo.getMotivoVenda());

        DadosApp da = DadosApp.getInstancia();
        clientes = da.getClientes();
        for (Cliente cliente : clientes) {
            anteriorDono.addItem(cliente.getNome());
        }
        anteriorDono.setSelectedItem(veiculo.getAntigoDono().getNome());
        anteriorDono.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Value: " + anteriorDono.getSelectedItem().toString());
                anteriorDonoBack=anteriorDono.getSelectedItem().toString();
            }
        });




        //registarVeiculoButton.addActionListener(this::registarVeiculoButton);



        if(isEditavel){
            editarButton.setVisible(true);
            editarButton.addActionListener(this::btnEditarActionListener);
            cancelarButton.setVisible(true);
            //cancelarButton.addActionListener(this::btnCancelarActionListener);
        }

        pack();
        setVisible(true);
    }



    private void btnEditarActionListener(ActionEvent e){

        veiculoPresente.setDescricao(Observacoes.getText());
        veiculoPresente.setMarca(Marca.getText());
        veiculoPresente.setModelo(Modelo.getText());
        veiculoPresente.setQuilometragem((Integer) Quilometragem.getValue());
        veiculoPresente.setCor(Cor.getText());
        veiculoPresente.setMotivoVenda(MotivoVenda.getText());
        for(Cliente c: clientes){
            if (c.getNome() == anteriorDonoBack){
                cliente=c;
                System.out.println(cliente);
                break;
            }
        }
        veiculoPresente.setAntigoDono(cliente);


        dispose();
    }


}
