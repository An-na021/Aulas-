/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j_exemplo1;

/**
 *
 * @author Annam
 */
import javax.swing.JOptionPane;

class Pilha {
    private int tamanho;
    private char[] pilha;
    private int topo;
    
    Pilha (int x){
        tamanho = x;
        pilha= new char[tamanho];
        topo= -1;
    }
 
void push(){
    if(topo == tamanho-1){
        JOptionPane.showMessageDialog(null,"Pilha cheia...");
        return;
        }
        topo ++;
        pilha[topo]= JOptionPane.showInputDialog("Entre com um caracter para empilhar:").charAt(0);
}

    void pop() {
        if(topo == -1){
             JOptionPane.showMessageDialog(null,"Pilha vazia..." );
             return;
        }
        else{
            JOptionPane.showMessageDialog(null,"Item"+ pilha[topo]+"removido..");
            topo--;
        }
    }
    void printtop(){ //Imprime o topo
    
    if (topo == -1){
            JOptionPane.showMessageDialog(null,"Pilha vazia");
            return;
        }
        JOptionPane.showMessageDialog(null,"Topo:" + pilha[topo]);
    }
     void printall(){
        if(topo == -1){
            JOptionPane.showMessageDialog(null, "Pilha vazia...");
            return;
        }
        char  [] pilhatemp = new char[topo+1];
        int topoaux = -1;
        String saida= "";
        
     //Desempilha para uma pilha auxiliar
     while(topo != -1){
     saida +=pilha[topo]+"\n";
     topoaux++;
     pilhatemp[topoaux]=pilha[topo];
    
    }
    JOptionPane.showMessageDialog(null,"Pilha: \n" + saida);
    
    //Reconstroi a pilha
    while(topoaux != -1){
        topo++;
       pilha [topo]=pilhatemp[topoaux];
        topoaux--; 
    }
  }
    void popall(){
        while (topo != -1){
            pop();
        }
        JOptionPane.showMessageDialog(null,"Todos os itens excluídos!");
        }
}





