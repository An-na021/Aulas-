/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplo1;

/**
 *
 * @author Annam
 */
import javax.swing.JOptionPane;

public class Exemplo1 {

    public static void main(String[] args)
    {  
        
    pilha aPilha = new pilha();
    int op;
    
    do{
        op = menu();
        switch(op) { 
            case 1: aPilha.push();break;
            case 2: aPilha.pop(); break;
            case 3: aPilha.printall(); break;
            
        }
    }while(op!=4);
   }
    
    public static int menu(){
        int op;
    do{
        op = Integer.parseInt(JOptionPane.showInputDialog("1 - Empilhar\n2 - Desempilhar\n3 - Imprimir\n4 - Sair\n\nOpcao:"));
    }while (op<1 || op>4);
        return (op);
    }
}
