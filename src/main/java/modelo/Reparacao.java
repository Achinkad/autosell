package modelo;

import java.util.Date;
import java.util.LinkedList;

public class Reparacao {
    private TipoReparacao tipoReparacao;
    private Veiculo veiculo;
    private Oficina oficina;
    private String descricaoTrabalhos;
    private String dataRececao;
    private String dataEntrega;
    private String servicosExternos;
    private LinkedList<LinhaReparacao> linhasReparacao;

    public Reparacao(TipoReparacao tipoReparacao, Veiculo veiculo, Oficina oficina, String descricaoTrabalhos, String dataRececao, String dataEntrega, String servicosExternos, LinkedList<LinhaReparacao> linhasReparacao) {
        this.tipoReparacao = tipoReparacao;
        this.veiculo = veiculo;
        this.oficina = oficina;
        this.descricaoTrabalhos = descricaoTrabalhos;
        this.dataRececao = dataRececao;
        this.dataEntrega = dataEntrega;
        this.servicosExternos = servicosExternos;
        this.linhasReparacao = linhasReparacao;
    }

    public TipoReparacao getTipoReparacao() {
        return tipoReparacao;
    }

    public void setTipoReparacao(TipoReparacao tipoReparacao) {
        this.tipoReparacao = tipoReparacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public String getDescricaoTrabalhos() {
        return descricaoTrabalhos;
    }

    public void setDescricaoTrabalhos(String descricaoTrabalhos) {
        this.descricaoTrabalhos = descricaoTrabalhos;
    }

    public String getDataRececao() {
        return dataRececao;
    }

    public void setDataRececao(String dataRececao) {
        this.dataRececao = dataRececao;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getServicosExternos() {
        return servicosExternos;
    }

    public void setServicosExternos(String servicosExternos) {
        this.servicosExternos = servicosExternos;
    }

    public LinkedList<LinhaReparacao> getLinhasReparacao() {
        return linhasReparacao;
    }

    public void setLinhasReparacao(LinkedList<LinhaReparacao> linhasReparacao) {
        this.linhasReparacao = linhasReparacao;
    }
}
