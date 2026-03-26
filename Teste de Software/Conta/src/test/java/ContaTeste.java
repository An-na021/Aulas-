/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.conta.Conta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author Annam
 */
public class ContaTeste {
   Conta conta;
   @BeforeEach
   void setup(){
       conta = new Conta();
   }
   @Test
   void testeDeposito(){
       conta.depositar(100);
       assertEquals(100, conta.getSaldo());
   }
   @Test
   void testeSaque(){
       conta.depositar(200);
       conta.sacar(50);
       assertEquals(150, conta.getSaldo());
   }
}
