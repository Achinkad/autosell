package vista.veiculos;

import modelo.*;
import vista.Erros;
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

                anteriorDonoBack=AnteriorDono.getSelectedItem().toString();
            }
        });
        btnCancelarActionPerformed.addActionListener(this::btnCancelarActionPerformed);
        btnAdicionarActionPerformed.addActionListener(this::btnAdicionarActionPerformed);

        pack();
        setVisible(true);
    }
    private void btnAdicionarActionPerformed(ActionEvent e) {
        String matricula=Matricula.getText();
        String marca = Marca.getText();
        String modelo = Modelo.getText();
        String cor = Cor.getText();
        int quilometragem = (Integer) Quilometragem.getValue();
        String observacoes = Observacoes.getText();
        String motivoVenda= MotivoVenda.getText();
        
        for(Cliente c: clientes){
            if (c.getNome() == anteriorDonoBack){
                cliente=c;
                break;
            }
        }
        if (matricula.isEmpty()|| matricula.length()<2 || matricula.length()>255){
            Erros.mostrarErro(this, 1, Erros.removeLastChar(matricula));
            if(marca.isEmpty() || marca.length()<2 || matricula.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(marca));
                return;

            } else if (modelo.isEmpty() || modelo.length()<2 || modelo.length()>255) {
                Erros.mostrarErro(this, 1, Erros.removeLastChar(modelo));
                return;

            } else if (quilometragem < 0) {
                Erros.mostrarErro(this, 4, Erros.removeLastChar(String.valueOf(quilometragem)));
                return;

            } else if (cor.isEmpty() || cor.length()<2 || cor.length()>255) {
                Erros.mostrarErro(this, 1, Erros.removeLastChar(cor));
                return;
            }else if (observacoes.isEmpty() ||observacoes.length()<2 || observacoes.length()>255){
                Erros.mostrarErro(this, 1, Erros.removeLastChar(observacoes));
                return;
            } else if (motivoVenda.isEmpty() || motivoVenda.length() < 2 || motivoVenda.length() > 255) {
                Erros.mostrarErro(this, 1, Erros.removeLastChar(motivoVenda));
                return;
            } else if (cliente==null ) {
                Erros.mostrarErro(this, 2, Erros.removeLastChar(cliente.getNome()));
                return;
            }
        }else {
            DadosApp.getInstancia().addVeiculo(new Veiculo(matricula, marca, modelo, cor,quilometragem , observacoes, cliente, null,motivoVenda));
        }
        dispose();
    }
    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
        JanelaVeiculos janelaVeiculos = new JanelaVeiculos();
        janelaVeiculos.setVisible(true);
    }
}
