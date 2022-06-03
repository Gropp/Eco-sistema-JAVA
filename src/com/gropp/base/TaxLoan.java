package com.gropp.base;

public class TaxLoan {

    public static int getDuasParcelas(){
        return 2;
    }
    public static int getQuatroParcelas(){
        return 4;
    }
    public static int getOitoParcelas(){
        return 8;
    }
    public static double getTaxaDuasParcelas(){
        return 0.2;
    }public static double getTaxaQuatroParcelas(){
        return 0.4;
    }public static double getTaxaOitoParcelas(){
        return 0.8;
    }

    public static void calcularJuros(double valor, int parcelas){
        if(parcelas == 2) {
            double valorFinal = valor + (valor * getTaxaDuasParcelas());
            System.out.println("Valor final do emprestimo de: " + valor + " em " + parcelas + " parcelas, será de: " + valorFinal );
        }
        if(parcelas == 4) {
            double valorFinal = valor + (valor * getTaxaQuatroParcelas());
            System.out.println("Valor final do emprestimo de: " + valor + " em " + parcelas + " parcelas, será de: " + valorFinal );
        }
        if(parcelas == 8) {
            double valorFinal = valor + (valor * getTaxaOitoParcelas());
            System.out.println("Valor final do emprestimo de: " + valor + " em " + parcelas + " parcelas, será de: " + valorFinal );
        }
        if(parcelas != 2 && parcelas != 4 && parcelas != 8 ) {
            System.out.println("Número de parcelas inválidas!");
        }
    }
}
