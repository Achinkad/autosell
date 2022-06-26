package modelo;

import java.util.Date;
import java.util.LinkedList;

public class Evento {
    private Date dataInicio;
    private Date dateFim;
    private Filial filial;
    private String designacao;
    private String localizacao;
    private String morada;
    private int numMaxVeiuclos;
    private LinkedList<Veiculo> veiculosAssociados;


    public Evento(Date dataInicio, Date dateFim, Filial filial, String designacao, String localizacao, String morada, int numMaxVeiuclos, LinkedList<Veiculo> veiculosAssociados) {
        this.dataInicio = dataInicio;
        this.dateFim = dateFim;
        this.filial = filial;
        this.designacao = designacao;
        this.localizacao = localizacao;
        this.morada = morada;
        this.numMaxVeiuclos = numMaxVeiuclos;
        this.veiculosAssociados = veiculosAssociados;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDateFim() {
        return dateFim;
    }

    public void setDateFim(Date dateFim) {
        this.dateFim = dateFim;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
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

    public int getNumMaxVeiuclos() {
        return numMaxVeiuclos;
    }

    public void setNumMaxVeiuclos(int numMaxVeiuclos) {
        this.numMaxVeiuclos = numMaxVeiuclos;
    }

    public LinkedList<Veiculo> getVeiculosAssociados() {
        return new LinkedList<>(veiculosAssociados);
    }

    public void adicionarVeiculosAssociados(LinkedList<Veiculo> veiculos) {
        if (veiculosAssociados.size()==numMaxVeiuclos || veiculosAssociados.size()+veiculos.size()>=numMaxVeiuclos){
            return;
        }
        for (Veiculo v: veiculos) {
            veiculosAssociados.add(v);
        }
    }
    public void removerVeiculosAssociados(Veiculo veiculo){
        if(veiculosAssociados.size()==0){
            return;
        }
        veiculosAssociados.remove(veiculo);
    }
}
