import modelo.Cliente;
import modelo.FichaCliente;
import modelo.FichaVeiculo;
import org.junit.jupiter.api.Test;
import modelo.Veiculo;
import static org.junit.jupiter.api.Assertions.*;
public class VeiculoTestCase {
    @Test
    public void testCriarVeiculo(){
        var fichaVeiculo = new FichaVeiculo();
        var fichaCliente = new FichaCliente();
        var cliente = new Cliente("Joao", 1234567, "Rua das flores", 918292821, "joao@ola.com", fichaCliente);
        var veiculo = new Veiculo("1234567","BMW","320d","azul",200000,"Muito Bonito",cliente,fichaVeiculo,"retoma");

        assertEquals("1234567", veiculo.getMatricula());
        assertEquals("BMW",veiculo.getMarca());
        assertEquals("320d",veiculo.getModelo());
        assertEquals("azul",veiculo.getCor());
        assertEquals(200000,veiculo.getQuilometragem());
        assertEquals("Muito Bonito",veiculo.getDescricao());
        assertEquals(cliente,veiculo.getAntigoDono());
        assertEquals(fichaVeiculo,veiculo.getFicha());
        assertEquals("retoma",veiculo.getMotivoVenda());
    }
}
