package com.gropp;

import com.gropp.base.Order;

public class Main {

    public static void main(String[] args) {

        int tax;
        // instancia a classe Order passa o parametro
        Order order = new Order("12345", 100);

        // manda imprimir
        System.out.println(order);
    }
}
