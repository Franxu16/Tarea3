package es.iesmz.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DiasLluviaTests {
    //Primer commit
    //Segundo commit
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
    //Tercer commit
    @Test
    void testTrimesteLluvioso() throws Exception {
        DiasLluvia A = new DiasLluvia();
        //Primer trimestre
        A.registroDia(10, 1, true);
        A.registroDia(20, 2, true);
        A.registroDia(1, 3, false);
        //Segundo trimestre
        A.registroDia(12, 4, true);
        A.registroDia(3, 5, false);
        A.registroDia(9, 6, false);
        //Tercer trimestre
        A.registroDia(22, 7, false);
        A.registroDia(15, 8, false);
        A.registroDia(7, 9, false);
        //Cuarto trimestre
        A.registroDia(2, 10, true);
        A.registroDia(24, 11, true);
        A.registroDia(6, 12, true);

        assertEquals(4, A.trimestreLluvioso());

    }

    @Test
    void testTrimestreLluviosoSinLluvia() throws Exception {
        DiasLluvia diasLluvia = new DiasLluvia();
        assertEquals(1, diasLluvia.trimestreLluvioso());
    }

    @Test
    void testTrimestreLluviosoConLluvia() throws Exception {
        DiasLluvia diasLluvia = new DiasLluvia();
        // Registramos un día lluvioso en el primer trimestre (Enero - Marzo)
        diasLluvia.registroDia(10, 1, true); // Día 10 de enero lluvioso
        assertNotEquals(0, diasLluvia.trimestreLluvioso());
    }
    //Cuarto commit
    @Test
    void testPrimerDiaLluvia() throws Exception {
        DiasLluvia A = new DiasLluvia();
        A.registroDia(1, 1, true);
        assertEquals(1, A.primerDiaLluvia());
    }

    @Test
    void testPrimerDiaLluvia2() throws Exception {
        DiasLluvia A = new DiasLluvia();
        A.registroDia(2,8, false);
        assertEquals(-1, A.primerDiaLluvia());
    }

    @Test
    void testPrimerDiaLluvia3() throws Exception {
        DiasLluvia A = new DiasLluvia();
        A.registroDia(1,1, false);
        assertNotEquals(1, A.primerDiaLluvia());
    }
}
