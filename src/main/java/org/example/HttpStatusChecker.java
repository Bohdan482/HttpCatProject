package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    public String getStatusImage(int code)
            throws URISyntaxException, IOException, InterruptedException, PageNotFoundException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://http.cat/" + code + ".jpg";

    HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(uri))
            .GET()
            .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404){
            throw new PageNotFoundException("Page not found");
        }
        return uri;
    }
}