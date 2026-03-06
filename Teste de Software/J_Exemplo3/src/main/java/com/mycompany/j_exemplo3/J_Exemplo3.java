/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.j_exemplo3;

/**
 *
 * @author 3000028997
 */
import javax.swing.JOptionPane;
public class J_Exemplo3 {

    public static void main(String args[])
    {
        empregado e[] = new empregado[2];
            ler(e);
        
            for (int i=0; i<2; i++) {
               JOptionPane.showMessageDialog(null,"Nome: " + e[i].nome);
               JOptionPane.showMessageDialog(null,"Salario: " + e[i].salario);
            }
        
    }
}
