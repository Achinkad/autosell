package modelo;

import java.util.LinkedList;

public class TransportePeca extends Transporte<Peca>{

    public TransportePeca(LinkedList<Peca> items, Date dataExpedicao, Date dataEntrega, Local localEntrega) {
        super(items, dataExpedicao, dataEntrega, localEntrega);
    }
}
