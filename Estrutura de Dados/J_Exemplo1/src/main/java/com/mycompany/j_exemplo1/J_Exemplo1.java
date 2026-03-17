/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.j_exemplo1;

/**
 *
 * @author Annam
 */
import javax.swing.JOptionPane;

public class J_Exemplo1 {

    public static void main(String[] args)
        {
        Pilha aPilha = new Pilha(10);
        int op;
        do{
            op=menu();
            switch(op){
                case 1: aPilha.push(); break;
                case 2: aPilha.pop();break;
                case 3: aPilha.printtop();break;
                case 4: aPilha.printall();break;
                case 5: aPilha.popall();break;
            }
        }while(op!=5);
    }
    static int menu()
    {
        int op;
    do{
        op= Integer.parseInt(JOptionPane.showInputDialog("1 - Empilhar\n2 - Desempilhar\n3 - Listar Pilha\n4 - Mostrar Todas as pilhas\n5 - Excluir Todas as pilhas"));
        }while(op<1|| op>5);
        
        return(op);
    }
}
    
 

