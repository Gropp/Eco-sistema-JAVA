package com.gropp.base;

public class Calcula {

    public static void soma(double value1, double value2) {
        double resultado =  value1 + value2;
        System.out.println("A soma de "+ value1 + " e " + value2 + " é: " + resultado);
    }
    public static void subtrai(double value1, double value2) {
        double resultado =  value1 - value2;
        System.out.println("A subtração de "+ value1 + " e " + value2 + " é: " + resultado);
    }
    public static void multiplica(double value1, double value2) {
        double resultado =  value1 * value2;
        System.out.println("A multiplicação de "+ value1 + " e " + value2 + " é: " + resultado);
    }
    public static void divide(double value1, double value2) {
        double resultado =  value1 / value2;
        System.out.println("A divisão de "+ value1 + " e " + value2 + " é: " + resultado);
    }
}

