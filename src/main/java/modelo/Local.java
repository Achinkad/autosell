package modelo;

import java.util.LinkedList;

public class Local {
    private String designacao;
    private String localizacao;
    private String morada;
    private int numeroMaxVeiculos;
    private LinkedList<Veiculo> veiculos;

    public Local(String designacao, String localizacao, String morada, int numeroMaxVeiculos, LinkedList<Veiculo> veiculos) {
        this.designacao = designacao;
        this.localizacao = localizacao;
        this.morada = morada;
        this.numeroMaxVeiculos = numeroMaxVeiculos;
        this.veiculos = veiculos;
    }

    public LinkedList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(LinkedList<Veiculo> veiculos) {
        if (veiculos == null) return;

        for (Veiculo v : veiculos) {
            veiculos.add(v);
        }
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroMaxVeiculos() {
        return numeroMaxVeiculos;
    }

    public void setNumeroMaxVeiculos(int numeroMaxVeiculos) {
        this.numeroMaxVeiculos = numeroMaxVeiculos;
    }
}
