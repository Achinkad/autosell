package modelo;

import java.util.LinkedList;

public class Evento extends Local {
    private Date dataInicio;
    private Date dateFim;
    private Filial filial;

    public Evento(Date dataInicio, Date dateFim, Filial filial, String designacao, String localizacao, String morada, int numMaxVeiuclos, LinkedList<Veiculo> veiculosAssociados) {
        super(designacao, localizacao, morada, numMaxVeiuclos, veiculosAssociados);
        this.dataInicio = dataInicio;
        this.dateFim = dateFim;
        this.filial = filial;
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
}
