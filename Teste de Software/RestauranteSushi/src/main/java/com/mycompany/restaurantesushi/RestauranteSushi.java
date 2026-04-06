package com.mycompany.restaurantesushi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author Annam
 */
public class RestauranteSushi {

    public double calcularValorFinal(double valorPedido, String tipoCliente) {
        if (valorPedido <= 0) {
            throw new IllegalArgumentException("Valor do pedido inválido");
        }

        double desconto = 0;

        switch (tipoCliente.toLowerCase()) {
            case "vip":
                desconto = 0.15; // 15%
                break;
            case "recorrente":
                desconto = 0.10; // 10%
                break;
            case "novo":
                desconto = 0.0; // 0%
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente inválido");
        }

        return valorPedido * (1 - desconto);
    }
}
