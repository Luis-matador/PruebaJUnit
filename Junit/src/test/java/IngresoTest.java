import org.example.Ingreso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class IngresoTest {
    private Ingreso ingreso;

    @BeforeEach
    public void setUp() {
        ingreso = new Ingreso();
    }

    @Test
    public void testPedirIngresoCantidadNegativa() {
        // Simular entrada por consola
        String simulatedInput = "-100\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Ejecutar
        ingreso.pedirIngreso("Usuario");

        // Comprobar que no se agregó saldo
        Assertions.assertEquals(0, ingreso.getSaldo(), "No debería haber agregado un ingreso negativo.");
    }

    @Test
    public void testPedirIngresoExitoso() {
        // Simular entrada por consola
        String simulatedInput = "150\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Ejecutar
        ingreso.pedirIngreso("Usuario");

        // Comprobar que el ingreso fue agregado
        Assertions.assertEquals(150, ingreso.getSaldo(), "El ingreso de 150 debería haber sido registrado.");
    }
}