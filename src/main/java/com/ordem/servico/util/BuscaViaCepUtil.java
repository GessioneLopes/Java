package com.ordem.servico.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordem.servico.models.Endereco;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class BuscaViaCepUtil {

    public Endereco get(String cep) {
        var endereco = new Endereco();
        try {
            var request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                    .header("Content-Type", "application/json")
                    .timeout(Duration.ofSeconds(5))
                    .build();

            var httclient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(6)).build();
            var response = httclient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                var objectMapper = new ObjectMapper();
                var jsonNode = objectMapper.readTree(response.body());

                if (!jsonNode.isNull()) {
                    endereco.setBairro(jsonNode.get("bairro").asText());
                    endereco.setCidade(jsonNode.get("localidade").asText());
                    endereco.setUf(jsonNode.get("uf").asText());
                    endereco.setLogradouro(jsonNode.get("logradouro").asText());
                    endereco.setReferencia(jsonNode.get("complemento").asText());
                }
            }

        } catch (IOException | InterruptedException ex) {
            System.out.println("Erro ao buscar por cep " + ex);
        }

        return endereco;
    }

}
