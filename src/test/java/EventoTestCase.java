import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class EventoTestCase {
    @Test
    public void testarCriarEvento(){
        var dataInicio = new Date(12,02,2020);
        var dataFim = new Date(12,03,2020);
        var oficinas = new LinkedList<Oficina>();
        var armazens = new LinkedList<Armazem>();
        var veiculos = new LinkedList<Veiculo>();
        var filial = new Filial(oficinas,armazens,false,"SedeLisboa","Lisboa","Rua das flores",12,veiculos);
        var evento = new Evento(dataInicio,dataFim,filial,"Ola","Guarda","Rua das Rosas",2,veiculos);
        assertEquals(dataInicio,evento.getDataInicio());
        assertEquals(dataFim,evento.getDateFim());
        assertEquals(filial,evento.getFilial());
        assertEquals("Ola",evento.getDesignacao());
        assertEquals("Guarda",evento.getLocalizacao());
        assertEquals("Rua das Rosas",evento.getMorada());
        assertEquals(2,evento.getNumeroMaxVeiculos());
        assertEquals(veiculos,evento.getVeiculos());
    }

}
