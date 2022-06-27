import modelo.Armazem;
import modelo.Peca;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmazemTestCase {
    @Test
    public void CreateArmazem(){
        LinkedList<Peca> pecas = new LinkedList<>();
        pecas.add(new Peca("Referencia","Marca",8.75f,"Descricao","BMW","S1","Designação da peça"));
        var armazem = new Armazem("Armazém Nome",911992255,pecas,pecas.size());

        assertEquals(armazem.getNome(),"Armazém Nome");
        assertEquals(armazem.getTelefone(),911992255);
        assertEquals(armazem.getPecas(),pecas);
        assertEquals(armazem.getQuantidadePeças(),pecas.size());
        assertEquals(armazem.getPecas().get(0).getReferencia(),"Referencia");
        assertEquals(armazem.getPecas().get(0).getMarca(),"Marca");
        assertEquals(armazem.getPecas().get(0).getPreco(),8.75);
        assertEquals(armazem.getPecas().get(0).getDescricao(),"Descricao");
        assertEquals(armazem.getPecas().get(0).getMarcaVeiculo(),"BMW");
        assertEquals(armazem.getPecas().get(0).getModeloVeiculo(),"S1");
        assertEquals(armazem.getPecas().get(0).getDesignacao(),"Designação da peça");
    }
}
