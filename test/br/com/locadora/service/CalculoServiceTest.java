package br.com.locadora.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoServiceTest {

    @Test
    public void testCalcularValorComum() {
        CalculoService service = new CalculoService();
        double resultado = service.calcularValor(4, 5.0);
        assertEquals(20.0, resultado, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularValorInvalido() {
        CalculoService service = new CalculoService();
        service.calcularValor(-3, 5.0);
    }
}
