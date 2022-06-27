;import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class TransporteTestCase {
    @Test
    public void testCriarTransportePeca(){
        var dataExpedicao = new Date(12,02,2020);
        var dataEntrega = new Date(12,03,2020);
        var pecas = new LinkedList<Peca>();
        var veiculos = new LinkedList<Veiculo>();
        var local = new Local("Piscina","Marte","Rua da Terra",14,veiculos);
        var transporte = new TransportePeca(pecas,dataExpedicao,dataEntrega,local);
        assertEquals(pecas,transporte.getItems());
        assertEquals(dataExpedicao,transporte.getDataExpedicao());
        assertEquals(dataEntrega,transporte.getDataEntrega());
        assertEquals(local,transporte.getLocalEntrega());
    }
    @Test
    public void testCriarTransporteVeiculo(){
        var dataExpedicao = new Date(12,02,2020);
        var dataEntrega = new Date(12,03,2020);
        var veiculos = new LinkedList<Veiculo>();
        var local = new Local("Piscina","Marte","Rua da Terra",14,veiculos);
        var transporte = new TransporteVeiculo(veiculos,dataExpedicao,dataEntrega,local);
        assertEquals(veiculos,transporte.getItems());
        assertEquals(dataExpedicao,transporte.getDataExpedicao());
        assertEquals(dataEntrega,transporte.getDataEntrega());
        assertEquals(local,transporte.getLocalEntrega());
    }
}
