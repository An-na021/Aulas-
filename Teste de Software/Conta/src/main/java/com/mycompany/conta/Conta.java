/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conta;

/**
 *
 * @author Annam
 */
public class Conta {
    private double saldo;
    
    public void depositar(double valor){
        saldo +=valor;
    }
    
    public void sacar(double valor){
        saldo -= valor;
    }
    
    public double getSaldo(){
        return saldo;
    }
}
