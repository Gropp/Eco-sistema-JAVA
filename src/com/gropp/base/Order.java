/*
* @author Fernando Gropp
* @version 1.0.0
* @see calculateFee
* @since release 1.0.0
*/
package com.gropp.base;

//classe dos pedidos
public class Order {

    private final String code;
    private final int totalValue;
    private String[] itens;


    /*
    * constructor da classe
    * @param code           codigo do pepido
    * @param totalValue     valor total do pedido
    */
    public Order(String code, int totalValue){
        this.code = code;
        this.totalValue = totalValue;
    }

    public double calculateFee() {
        switch (totalValue) {
            case 100:
                return totalValue * 0.99;
            case 200:
                return  totalValue * 1.99;
            default:
                return totalValue;
        }
//        if(totalValue > 100) {
//            return totalValue * 0.99;
//        }else {
//            return totalValue;
//        }
    }

    public void printItens(){
        int i = 0;
        while(i < itens.length){
            System.out.println(itens[i]);
            i++;
        }
    }

    // formata a saida
    @Override
    public String toString() {
        return "Order{" +
                "code='" + code + '\'' +
                ", totalValue=" + totalValue +
                '}';
    }
}
