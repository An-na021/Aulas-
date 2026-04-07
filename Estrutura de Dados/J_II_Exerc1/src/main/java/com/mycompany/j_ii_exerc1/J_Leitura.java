/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j_ii_exerc1;

/**
 *
 * @author Annam
 */
import java.io.*;

    class J_Leitura {
    public String Ler ( ) {
        DataInputStream dado;
        String valor="0";
    try {
    dado = new DataInputStream(System.in);
    valor = dado.readLine();
    }
    catch (Exception e) {
    System.out.println("Entrada invalida");
        valor="0";
    }
    return (valor.trim());}
        int Ler_int() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void Pause(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void Limpa_tela() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
