package com.gropp.base;

public class CalculaArea {

    //quadrado notavel 4 lados iguais
    public static void area(double lado){
        System.out.println("A área do Quadrado é: " + lado * lado);
    }
    //retangulo notavel lados opostos iguais
    public static void area(double lado1, double lado2){
        System.out.println("A área do Retangulo é: " + lado1 * lado2);
    }
    //losango notavel - tbm tem dois argumentos como o retangulo, tem que alterar a tipagem!
    public static void area(float lado1, float lado2){
        System.out.println("A área do Losango é: " + ((lado1 * lado2)/2));
    }
    //trapezio notavel base maior, base menor e altura
    public static void area(double baseMaior, double baseMenor, double altura){
        System.out.println("A área do Trapezio é: " + ((baseMaior+baseMenor)*altura)/2);
    }
}
