package com.gropp.base;

public class DiaNoite {
    public static void saudacao (int hora) {
        switch (hora) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                System.out.println("Bom Dia!");
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                System.out.println("Boa Tarde!");
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 1:
            case 2:
            case 3:
            case 4:
                mensagemBoaNoite();
                break;
            default:
                System.out.println("Hora Inválida!");
                break;
        }
    }
    public static void mensagemBoaNoite(){
        System.out.println("Boa Noite");
    }
}


