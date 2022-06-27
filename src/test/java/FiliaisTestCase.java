import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiliaisTestCase {
    @Test
    public void CreateFiliais(){
        LinkedList<Oficina> oficinas = new LinkedList<>();
        oficinas.add(new Oficina("nomeOf",955887584,"of@email.com","Maria",215866583));
        LinkedList<Armazem> armazens = new LinkedList<>();
        LinkedList<Peca> pecas = new LinkedList<>();
        pecas.add(new Peca("Referencia","Marca",8.75f,"Descricao","BMW","S1","Designação da peça"));
        armazens.add(new Armazem("Armazem",936658745,pecas, pecas.size()));
        LinkedList<Veiculo> veiculos = new LinkedList<>();
        var antigoDono = new Cliente("Nome",665522774,"Morada",966885744,"email@email.pt",new FichaCliente());
        veiculos.add(new Veiculo("XX-55-YY","BMW","S2","Amarelo",86,"Designação",antigoDono,new FichaVeiculo(),"Motivo"));

        var filial = new Filial(oficinas,armazens,false,"Designação","Leiria","Rua xpto",150,veiculos);
        assertEquals(filial.getOficinas(),oficinas);
        assertEquals(filial.getOficinas().size(),1);
        assertEquals(filial.isSede(),false);
        assertEquals(filial.getDesignacao(),"Designação");
        assertEquals(filial.getLocalizacao(),"Leiria");
        assertEquals(filial.getMorada(),"Rua xpto");
        assertEquals(filial.getNumeroMaxVeiculos(),150);
        assertEquals(filial.getVeiculos(),veiculos);
        assertEquals(filial.getVeiculos().size(),1);


    }
}
