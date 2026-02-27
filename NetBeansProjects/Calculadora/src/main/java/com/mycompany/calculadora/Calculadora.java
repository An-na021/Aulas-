/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadora;

/**
 *
 * @author 3000028997
 */
public class Calculadora {

    public static int dividir(int a,int b) {
     if (b==0){
        throw new IllegalArgumentException("Divisão por zero não permitida.");
     }
     return a/b;
   }
    public static int maiorNumero(int a, int b, int c){
        int maior = a;
        if (b > maior){
            maior = b;
        }
        if(c> maior){
            maior = c;
        }
        return maior;
    } 
    public static boolean numeroEhPar(int n){
        return n%2==0;
    }
}
