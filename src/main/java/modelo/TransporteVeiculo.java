package modelo;

import java.util.LinkedList;

public class TransporteVeiculo extends Transporte<Veiculo>{
    public TransporteVeiculo(LinkedList<Veiculo> items, Date dataExpedicao, Date dataEntrega, Local localEntrega) {
        super(items, dataExpedicao, dataEntrega, localEntrega);
    }
}
