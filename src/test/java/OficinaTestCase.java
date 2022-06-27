import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class OficinaTestCase {
    @Test
    public void testarCriarOficina(){
        var oficina = new Oficina("Grande Oficina",929192921,"asd@ola.com","Manuel Titi",912929292);
        assertEquals("Grande Oficina",oficina.getNome());
        assertEquals(929192921,oficina.getTelefone());
        assertEquals("asd@ola.com",oficina.getEmail());
        assertEquals("Manuel Titi",oficina.getResponsavelOficina());
        assertEquals(912929292,oficina.getTelefoneResponsavel());
    }
}
