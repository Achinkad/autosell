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
import java.util.LinkedList;

public class MenuAux {
    public MenuAux(){

    }
    public void iniciaMenu(LinkedList<JButton> menuItems){
        for (int i = 0; i < menuItems.size(); i++) {
            JButton item = menuItems.get(i);
            if(i==0){
                item.addActionListener(this::btnVeiculosActionPerformed);
            }
            if(i==1) {
                item.addActionListener(this::btnClientesActionPerformed);
            }
            if(i==2) {
                item.addActionListener(this::btnFiliaisActionPerformed);
            }
            if(i==3) {
                item.addActionListener(this::btnEventosActionPerformed);
            }
            if(i==4) {
                item.addActionListener(this::btnTransacoesActionPerformed);
            }
            if(i==5) {
                item.addActionListener(this::btnReparacoesActionPerformed);
            }
            if(i==6) {
                item.addActionListener(this::btnPecasActionPerformed);
            }
            if(i==7){
                item.addActionListener(this::btnOficinasActionPerformed);
            }
            if(i==8) {
                item.addActionListener(this::btnArmazensActionPerformed);
            }
            if(i==9) {
                item.addActionListener(this::btnTransportesActionPerformed);
            }
            if(i==10) {
                item.addActionListener(this::btnEstatisticasActionPerformed);
            }
        }
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
}
