;import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class DadosAppTestCase {
    private DadosApp da;
    @BeforeEach
    public void DadosApp(){
        da = DadosApp.getInstancia();
    }
    @Test
    public void testarInserirEvento(){
        var dataInicio = new Date(12,02,2020);
        var dataFim = new Date(12,03,2020);
        var oficinas = new LinkedList<Oficina>();
        var armazens = new LinkedList<Armazem>();
        var veiculos = new LinkedList<Veiculo>();
        var filial = new Filial(oficinas,armazens,false,"SedeLisboa","Lisboa","Rua das flores",12,veiculos);
        var evento = new Evento(dataInicio,dataFim,filial,"Ola","Guarda","Rua das Rosas",2,veiculos);

        da.inserirEvento(evento);
        assertSame(evento, da.getEventos().get(0));
    }
    @Test
    public void testarInserirVeiculo(){
        var fichaVeiculo = new FichaVeiculo();
        var fichaCliente = new FichaCliente();
        var cliente = new Cliente("Joao", 1234567, "Rua das flores", 918292821, "joao@ola.com", fichaCliente);
        var veiculo = new Veiculo("1234567","BMW","320d","azul",200000,"Muito Bonito",cliente,fichaVeiculo,"retoma");

        da.inserirVeiculo(veiculo);
        assertSame(veiculo, da.getVeiculos().get(0));
    }
    @Test
    public void testarInserirTransporte(){
        var dataExpedicao = new Date(12,02,2020);
        var dataEntrega = new Date(12,03,2020);
        var veiculos = new LinkedList<Veiculo>();
        var local = new Local("Piscina","Marte","Rua da Terra",14,veiculos);
        var transporte = new TransporteVeiculo(veiculos,dataExpedicao,dataEntrega,local);

        da.inserirTransporte(transporte);
        assertSame(transporte, da.getTransportes().get(0));
    }
    @Test
    public void testarInserirCliente(){
        var cliente = new Cliente("Nome",622754348,"Rua .",922557485,"n@email.com",new FichaCliente());
        da.inserirCliente(cliente);
        assertSame(da.getClientes().get(0),cliente);
    }
    @Test
    public void testarRemoverCliente(){
        var cliente = new Cliente("Nome",622754348,"Rua .",922557485,"n@email.com",new FichaCliente());
        da.inserirCliente(cliente);
        assertSame(da.getClientes().size(),1);
        da.removerCliente(cliente);
        assertSame(da.getClientes().size(),0);
    }
    @Test
    public void testarInserirTransacao(){
        var cliente = new Cliente("Nome",622754348,"Rua .",922557485,"n@email.com",new FichaCliente());
        var transacao = new Transacao(cliente,new Veiculo("AS-DS-55","BMW","S1","Verde",170,"Descrição",cliente,new FichaVeiculo(),"Troca"),750.23f);
        da.inserirTransacao(transacao);
        assertSame(da.getTransacoes().get(0),transacao);
    }
}
