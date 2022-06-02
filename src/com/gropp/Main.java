/*
* @author Fernando Gropp
*
*/

package com.gropp;

import com.gropp.base.Order;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main (String[] args) throws IOException, InterruptedException, ExecutionException  {

        int tax;
        // instancia a classe Order passa o parametro
        Order order = new Order("12345", 100);

        // manda imprimir
        System.out.println(order);
        //System.out.println(LocalDateTime.MAX.plusDays(-365243219162 - 365241780471));
        System.out.println(LocalDateTime.MAX.getDayOfYear());
        System.out.println(LocalDateTime.MAX.getDayOfMonth());

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
