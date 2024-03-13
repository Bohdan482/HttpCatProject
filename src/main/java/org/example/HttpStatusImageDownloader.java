package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code)
            throws URISyntaxException, IOException, InterruptedException, PageNotFoundException {
        HttpClient client = HttpClient.newHttpClient();
        HttpStatusChecker statusChecker = new HttpStatusChecker();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(statusChecker.getStatusImage(code)))
                .GET()
                .build();

        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        ByteArrayInputStream responseByteArray = new ByteArrayInputStream(response.body());
        BufferedImage image = ImageIO.read(responseByteArray);
        ImageIO.write(image, "jpg", new File("image.jpg"));
    }
}
