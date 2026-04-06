/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantesushi.RestauranteSushi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Annam
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestauranteSushiTest {

    RestauranteSushi sushi = new RestauranteSushi();

    @Test
    void testeDescontoVIP() {
        double resultado = sushi.calcularValorFinal(100, "vip");
        assertEquals(85.0, resultado);
    }

    @Test
    void testeDescontoRecorrente() {
        double resultado = sushi.calcularValorFinal(100, "recorrente");
        assertEquals(90.0, resultado);
    }

    @Test
    void testeClienteNovoSemDesconto() {
        double resultado = sushi.calcularValorFinal(100, "novo");
        assertEquals(100.0, resultado);
    }

    @Test
    void testeValorNaoNulo() {
        double resultado = sushi.calcularValorFinal(50, "vip");
        assertNotNull(resultado);
    }

    @Test
    void testeValorMenorQueOriginalParaVIP() {
        double resultado = sushi.calcularValorFinal(100, "vip");
        assertTrue(resultado < 100);
    }

    @Test
    void testeSemDescontoParaNovo() {
        double resultado = sushi.calcularValorFinal(100, "novo");
        assertFalse(resultado < 100);
    }

    @Test
    void testeValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            sushi.calcularValorFinal(0, "vip");
        });
    }

    @Test
    void testeTipoClienteInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            sushi.calcularValorFinal(100, "premium");
        });
    }
}
/* assertEquals
    assertNotNull
    assertTrue
    assertFalse
    assertThrows

    Total: 8 testes, cobrindo:
    Todos os tipos de cliente
    Casos válidos e inválidos
    Regras de negócio*/