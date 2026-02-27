/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.j_exemplo;

/**
 *
 * @author 3000028997
 */
import javax.swing.JOptionPane;

class J_Exemplo {

    public static void main(String args[]) 
    {
      empregado emp = new empregado();
      emp.adress.estado = JOptionPane.showInputDialog("Entre com o estado: ");
       emp.adress.cep = JOptionPane.showInputDialog("Entre com o seu cep: ");
      emp.name.nome_ini = JOptionPane.showInputDialog("Entre com o seu   primeiro nome: ");
      JOptionPane.showInputDialog(null,"Estado digitado: " + emp.adress.estado);
      JOptionPane.showInputDialog(null,"Cep dgitado...: " + emp.adress.cep);
      JOptionPane.showInputDialog(null,"Nome digitado..:" + emp.name.nome_ini);
}}
