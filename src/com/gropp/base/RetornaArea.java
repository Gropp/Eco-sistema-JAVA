package com.gropp.base;

public class RetornaArea {
    //quadrado notavel 4 lados iguais
    public static double area(double lado){
        return lado * lado;
    }
    //retangulo notavel lados opostos iguais
    public static double area(double lado1, double lado2){
        return lado1 * lado2;
    }
    //losango notavel - tbm tem dois argumentos como o retangulo, tem que alterar a tipagem!
    public static float area(float lado1, float lado2){
        return ((lado1 * lado2)/2);
    }
    //trapezio notavel base maior, base menor e altura
    public static double area(double baseMaior, double baseMenor, double altura){
        return ((baseMaior+baseMenor)*altura)/2;
    }
}
