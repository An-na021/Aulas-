/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.j_ii_exerc1;

import javax.swing.JOptionPane;

/**
 *
 * @author Annam
 */
public class J_II_Exerc1 {

    public static void main(String[] args)
        { fila aFila = new fila();
        int op;
        
        do{  
            op=menu();
            switch (op){
                case 1: aFila.push(); break;
                case 2: aFila.printall();
            }
        }while (op!=3);
    }
    public static int menu()
    {
        int op;
        J_Leitura in = new J_Leitura();
        do{
            System.out.println("1 - Inserir");
            System.out.println("2- Imprimir");
            System.out.println("3 - Sair\n");
            System.out.println("Opção: ");
            
            op = in.Ler_int();
        } while (op<1 || op>3);
        return (op);
    }
}
class no_fila{
    public String nome;
    public no_fila proximo;
}
class fila{
    private no_fila ini;
    private no_fila fim;
    J_Leitura in = new J_Leitura();
    
    public void push() {
    no_fila temp_no = new  no_fila();
    if(temp_no !=null) {
        System.out.print("\nEntre com um nome: ");
        temp_no.nome = in.Ler();
        temp_no.proximo = null;
        if(fim != null){
            fim.proximo = temp_no;
            fim = temp_no;
        }else
            ini = fim = temp_no;
    }else
        System.out.println("\nNao foi possivel inserir...");
}
    public void printall() {
    if (fim == null){
            System.out.println("\nFila vazia...");
            in.Pause(2);
            
            return;
    }
    no_fila temp_no = ini;
    System.out.println("\nFila:");
    while(temp_no != null) {
    System.out.println(temp_no.nome);
    temp_no = temp_no.proximo;
}
    in.Pause(2); 
}
    public void pop(){
    in.Limpa_tela();

    if (ini == null){
        System.out.println("\nFila vazia...");
    }else{
    System.out.println("\nValor removido: " + ini.nome);
    ini = ini.proximo;
    if (ini == null)
        fim = null;
    }
in.Pause(2);
}
   void popAll() {
       if( ini==null)
           JOptionPane.showMessageDialog(null, "FIla vazia...");
       ini=ini.proximo;
       
       if(ini == null){
           fim =null;
       }
   }
    void printFront(){
       if (ini==null)
           JOptionPane.showMessageDialog(null,"Fila Vazia...");
       else{
               JOptionPane.showMessageDialog(null, "Primeiro elemento da fila:  " + ini.nome);
               }
           }
       }           