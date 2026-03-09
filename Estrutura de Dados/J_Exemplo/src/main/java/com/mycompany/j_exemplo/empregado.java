/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j_exemplo;

/**
 *
 * @author 3000028997
 */
public class empregado {
 nome name;
 endereco adress;
       //Construtor para evitar erro
 public empregado(){ //de referencia nula, ou seja
     name = new nome(); //java.lang.NullPointerException
     adress = new endereco();  //Ou nome name = new nome();
    
 }   //para eliminar o construtor
}
