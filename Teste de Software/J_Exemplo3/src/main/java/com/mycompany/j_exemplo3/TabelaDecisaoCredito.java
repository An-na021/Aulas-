/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j_exemplo3;

/**
 *
 * @author 3000028997
 */

public class TabelaDecisaoCredito {

    public static String verificarCredito(int idade, double rendaMensal){
        if(idade<18){
            return "Credito não aprovado";
        
        }else if (idade<=25){
            if(rendaMensal >=2000){
                return "Credito aprovado";
            }else{
                return "Credito não aprovado";
            }
        }else{
            if(rendaMensal >=3000){
                return "Credito aprovado";
            }else{
                return "Credito não aprovado";
            }
        }
    }
        
        
    public static void main(String[] args){
        int idade = 22;
        double renda = 2500.0;
        
        String resultado = verificarCredito(idade,renda);
        System.out.println("Resultado da análise: " + resultado);
    }
}