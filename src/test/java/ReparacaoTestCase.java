import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReparacaoTestCase {
    @Test
    public void CreateReparacao(){
        var antigoDono = new Cliente("Nome",665522774,"Morada",966885744,"email@email.pt",new FichaCliente());
        Veiculo v = new Veiculo("XX-55-YY","BMW","S2","Amarelo",86,"Designação",antigoDono,new FichaVeiculo(),"Motivo");
        Oficina o = new Oficina("Oficina",253844751,"email@email.pt","Maria",962547858);
        LinkedList<LinhaReparacao> lr = new LinkedList<>();
        lr.add(new LinhaReparacao(new Peca("ref","BMW",150,"Descrição","Marca V","Modelo","Designação"),1));
        var reparacao = new Reparacao(TipoReparacao.MANUNTENCAO,v,o,"Descrição T","11-11-2022","01-11-2022",null,lr);

        assertEquals(reparacao.getTipoReparacao(),TipoReparacao.MANUNTENCAO);
        assertEquals(reparacao.getVeiculo(),v);
        assertEquals(reparacao.getOficina(),o);
        assertEquals(reparacao.getDescricaoTrabalhos(),"Descrição T");
        assertEquals(reparacao.getDataRececao(),"11-11-2022");
        assertEquals(reparacao.getDataEntrega(),"01-11-2022");
        assertEquals(reparacao.getServicosExternos(),null);
        assertEquals(reparacao.getLinhasReparacao(),lr);
        assertEquals(reparacao.getLinhasReparacao().size(),1);
    }
}
