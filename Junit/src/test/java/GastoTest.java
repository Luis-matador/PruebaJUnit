import org.example.Gasto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GastoTest {
    private Gasto gasto;

    @BeforeEach
    public void setUp() {
        gasto = new Gasto();
    }

    @Test
    public void testPedirGastoCantidadNegativa() {
        // Simular entrada por consola
        String simulatedInput = "1\n-50\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Ejecutar
        gasto.pedirGasto("Usuario", 200);

        // Comprobar que no se sumaron gastos
        Assertions.assertEquals(0, gasto.getTotalGastos(), "No debería haber agregado un gasto negativo.");
    }

    @Test
    public void testPedirGastoSaldoInsuficiente() {
        // Simular entrada por consola
        String simulatedInput = "2\n300\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Ejecutar
        gasto.pedirGasto("Usuario", 200);

        // Comprobar que no se sumaron gastos
        Assertions.assertEquals(0, gasto.getTotalGastos(), "No debería haber agregado el gasto debido a saldo insuficiente.");
    }

    @Test
    public void testPedirGastoExitoso() {
        // Simular entrada por consola
        String simulatedInput = "3\n100\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Ejecutar
        gasto.pedirGasto("Usuario", 200);

        // Comprobar que el gasto fue agregado
        Assertions.assertEquals(100, gasto.getTotalGastos(), "El gasto de 100 debería haber sido registrado.");
    }
}