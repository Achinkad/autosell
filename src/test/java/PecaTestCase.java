import modelo.Peca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PecaTestCase {
    @Test
    public void CreatePeca(){
        var peca = new Peca("Referencia","Marca",8.75f,"Descricao","BMW","S1","Designação da peça");

        assertEquals(peca.getReferencia(),"Referencia");
        assertEquals(peca.getMarca(),"Marca");
        assertEquals(peca.getPreco(),8.75);
        assertEquals(peca.getDescricao(),"Descricao");
        assertEquals(peca.getMarcaVeiculo(),"BMW");
        assertEquals(peca.getModeloVeiculo(),"S1");
        assertEquals(peca.getDesignacao(),"Designação da peça");
    }
}
