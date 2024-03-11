package es.iesmz.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DiasLluviaTests {
    //Primer commit

    @Test
    void testConsultarDias() throws Exception {
        DiasLluvia A = new DiasLluvia();
        A.registroDia(1,8, true);
        boolean lluvia = A.consultarDia(1,8);
        assertEquals(true, lluvia);
    }

    @Test
    void testContarDias() throws Exception {
        DiasLluvia A = new DiasLluvia();
        assertEquals(0, A.contarDiasLluviosos());
        A.registroDia(10, 1, true);
        A.registroDia(15, 3, false);
        assertEquals(1, A.contarDiasLluviosos());
    }

    @Test
    void testNoConsultarDias() throws Exception {
        DiasLluvia A = new DiasLluvia();
        assertNotEquals(true, A.consultarDia(1, 1));
        assertNotEquals(true, A.consultarDia(31, 12));
        assertNotEquals(true, A.consultarDia(15, 7));
    }
}
