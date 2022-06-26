package modelo;


import java.util.LinkedList;

public class Transporte <Ttipo extends Item>{

    private LinkedList<Ttipo> items;
    private Date dataExpedicao;
    private Date dataEntrega;
    private Local localEntrega;

    public Transporte(LinkedList<Ttipo> items, Date dataExpedicao, Date dataEntrega, Local localEntrega) {
        this.items = items;
        this.dataExpedicao = dataExpedicao;
        this.dataEntrega = dataEntrega;
        this.localEntrega = localEntrega;

    }

    public LinkedList<Ttipo> getItems() {
        return items;
    }

    public void setItems(LinkedList<Ttipo> items) {
        this.items = items;
    }

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Local getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(Local localEntrega) {
        this.localEntrega = localEntrega;
    }
}
