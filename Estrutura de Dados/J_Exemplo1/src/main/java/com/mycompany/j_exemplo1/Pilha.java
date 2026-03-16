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
}
