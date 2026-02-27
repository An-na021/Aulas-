/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.j_exemplo2;

import javax.swing.JOptionPane;

/**
 *
 * @author 3000028997
 */
import javax.swing.JOptionPane;

public class J_Exemplo2 {

    public static void main(String args[]) 
    {
        empregado e = new empregado();
        
           ler(e);
                
        JOptionPane.showInputDialog(null,"Nome digitado...: " + e.nome);
        JOptionPane.showInputDialog(null,"Estado digitado: " + e.salario);
    }   
    public static void ler(empregado e){
        e.nome =  JOptionPane.showInputDialog("Entre com o nome:");
        e.salario =  Float.parseFloat( JOptionPane.showInputDialog("Entre com o salario: "));
    }
}
