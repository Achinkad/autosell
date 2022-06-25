package vista;

import vista.armazens.JanelaArmazens;
import vista.clientes.JanelaClientes;
import vista.estatisticas.JanelaEstatisticas;
import vista.eventos.JanelaEventos;
import vista.filiais.JanelaFiliais;
import vista.oficinas.JanelaOficinas;
import vista.pecas.JanelaPecas;
import vista.reparacoes.JanelaReparacoes;
import vista.transacoes.JanelaTransacoes;
import vista.transportes.JanelaTransportes;
import vista.veiculos.JanelaVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AutoSell extends JFrame {
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

    public AutoSell() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);

        btnVeiculos.addActionListener(this::btnVeiculosActionPerformed);
        btnClientes.addActionListener(this::btnClientesActionPerformed);
        btnFiliais.addActionListener(this::btnFiliaisActionPerformed);
        btnEventos.addActionListener(this::btnEventosActionPerformed);
        btnTransacoes.addActionListener(this::btnTransacoesActionPerformed);
        btnReparacoes.addActionListener(this::btnReparacoesActionPerformed);
        btnPecas.addActionListener(this::btnPecasActionPerformed);
        btnOficinas.addActionListener(this::btnOficinasActionPerformed);
        btnArmazens.addActionListener(this::btnArmazensActionPerformed);
        btnTransportes.addActionListener(this::btnTransportesActionPerformed);
        btnEstatisticas.addActionListener(this::btnEstatisticasActionPerformed);

        pack();
    }

    private void btnVeiculosActionPerformed(ActionEvent e) {
        JanelaVeiculos janelaVeiculos = new JanelaVeiculos();
        janelaVeiculos.setVisible(true);
    }

    private void btnClientesActionPerformed(ActionEvent e) {
        JanelaClientes janelaClientes = new JanelaClientes();
        janelaClientes.setVisible(true);
    }

    private void btnFiliaisActionPerformed(ActionEvent e) {
        JanelaFiliais janelaFiliais = new JanelaFiliais();
        janelaFiliais.setVisible(true);
    }

    private void btnEventosActionPerformed(ActionEvent e) {
        JanelaEventos janelaEventos = new JanelaEventos();
        janelaEventos.setVisible(true);
    }

    private void btnTransacoesActionPerformed(ActionEvent e) {
        JanelaTransacoes janelaTransacoes = new JanelaTransacoes();
        janelaTransacoes.setVisible(true);
    }

    private void btnReparacoesActionPerformed(ActionEvent e) {
        JanelaReparacoes janelaReparacoes = new JanelaReparacoes();
        janelaReparacoes.setVisible(true);
    }

    private void btnPecasActionPerformed(ActionEvent e) {
        JanelaPecas janelaPecas = new JanelaPecas();
        janelaPecas.setVisible(true);
    }

    private void btnOficinasActionPerformed(ActionEvent e) {
        JanelaOficinas janelaOficinas = new JanelaOficinas();
        janelaOficinas.setVisible(true);
    }

    private void btnArmazensActionPerformed(ActionEvent e) {
        JanelaArmazens janelaArmazens = new JanelaArmazens();
        janelaArmazens.setVisible(true);
    }

    private void btnTransportesActionPerformed(ActionEvent e) {
        JanelaTransportes janelaTransportes = new JanelaTransportes();
        janelaTransportes.setVisible(true);
    }

    private void btnEstatisticasActionPerformed(ActionEvent e) {
        JanelaEstatisticas janelaEstatisticas = new JanelaEstatisticas();
        janelaEstatisticas.setVisible(true);
    }

    public static void main(String[] args) {
        new AutoSell().setVisible(true);
    }
}


