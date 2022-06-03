/*
* @author Fernando Gropp
*
*/

package com.gropp;

import com.gropp.base.*;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main (String[] args) throws IOException, InterruptedException, ExecutionException  {

        int tax;
        // instancia a classe Order passa o parametro
        Order order = new Order("12345", 100);

        // manda imprimir
        System.out.println(order);
//      como o metodo é static ele pode ser acessado direto pela classe
        System.out.println("Exercicio da Calculadora:");
//      chamando os metodos diretamente da classe sem instaciar
        Calcula.soma(3, 4);
        Calcula.subtrai(5, 10);
        Calcula.multiplica(4, 6);
        Calcula.divide(2, 2);

        //exercicio saudacao
        System.out.println("SAUDAÇÕES");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        // chamamos a classe DiaNoite e o metodo saudacao static diretamente
        DiaNoite.saudacao(hora);
        System.out.println(hora);

        //exercicio do emprestimo
        System.out.println("Emprestimo em 2, 4 ou 8 parcelas");
        TaxLoan.calcularJuros(1000, TaxLoan.getDuasParcelas());
        TaxLoan.calcularJuros(1000, TaxLoan.getQuatroParcelas());
        TaxLoan.calcularJuros(1000, 8);
        TaxLoan.calcularJuros(1000, 5);

        //exercicio da SOBRECARGA - NOMES IGUAIS PARAMETROS DIFERENTES
        System.out.println("SOBRECARGA DE METODOS");
        CalculaArea.area(3);
        CalculaArea.area(3d, 4d); // esta chamando o retangulo pela tipagem double
        CalculaArea.area(3f, 4f); // esta chamando o losango pela tipagem float
        CalculaArea.area(3,5,2);

        //exercicio da SOBRECARGA COM RETURN - NOMES IGUAIS PARAMETROS DIFERENTES
        System.out.println("SOBRECARGA DE METODOS NAO VOID");
        double quadrado = RetornaArea.area(3);
        double retangulo = RetornaArea.area(3d, 4d); // esta chamando o retangulo pela tipagem double
        float losango = RetornaArea.area(3f, 4f); // esta chamando o losango pela tipagem float
        double trapezio = RetornaArea.area(3,5,2);
        System.out.println("A área do Quadrado é: " + quadrado);
        System.out.println("A área do Retangulo é: " + retangulo);
        System.out.println("A área do Losango é: " + losango);
        System.out.println("A área do Trapezio é: " + trapezio);

        //System.out.println(LocalDateTime.MAX.plusDays(-365243219162 - 365241780471));
        System.out.println(LocalDateTime.MAX.getDayOfYear());
        System.out.println(LocalDateTime.MAX.getDayOfMonth());
        System.out.println(LocalDateTime.now());

        // carregando e mostrando o conteudo do arquivo
        final String content = Files.readString(Paths.get("readME.txt"), StandardCharsets.UTF_8);
        System.out.println(content);

        // chamada SINCRONA do HTTPCLIENT
        System.out.println("Sincrona");
        final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        final HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.google.com.br"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();
        final HttpResponse<String> stringHttpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(stringHttpResponse.statusCode());
        System.out.println(stringHttpResponse.body());

        // chamada ASSINCRONA do HTTPCLIENT
        System.out.println("Assincrona");
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                        .thenApply(httpResponse -> {
                            System.out.println(httpResponse.statusCode());
                            return httpResponse;
                        })
                        .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
        Thread.sleep(2000);
    }
}
