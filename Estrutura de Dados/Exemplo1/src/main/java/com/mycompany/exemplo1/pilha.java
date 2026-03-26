/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo1;

/**
 *
 * @author Annam
 */
import javax.swing.JOptionPane;

class no_pilha {
    int valor;
    no_pilha proximo;
    
    no_pilha(){
        valor = 0;
        proximo = null;
    }
}
class pilha {
    private no_pilha topo;
    
    public void push(){
        no_pilha temp_no = new no_pilha();
    if (temp_no != null){
        temp_no.valor = Integer.parseInt(JOptionPane.showInputDialog("Entre com um valor: "));
        
            temp_no.proximo = topo;
            
        topo = temp_no;
    }
    else{
        JOptionPane.showMessageDialog(null,"Não foi possível inserir...");}
    }
    public void pop() {

    if (topo != null) {
        JOptionPane.showMessageDialog(null,"\nValor removido: " + topo.valor);
        topo = topo.proximo;

    }
else{

    JOptionPane.showMessageDialog(null,"Pilha vazia...");
    }
  }
    public void printall(){
        if (topo == null) { 
            JOptionPane.showMessageDialog(null,"Pilha vazia..");
            return;
        }
        
        no_pilha temp_no = topo;
        String str = "Pilha:\n";
        while(temp_no != null){
            str += temp_no.valor + "\n";
            temp_no = temp_no.proximo;
        }
        JOptionPane.showMessageDialog(null,str);
    }  
}