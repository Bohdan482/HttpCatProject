package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public class HttpImageStatusCli {
    public void askStatus() throws URISyntaxException, InterruptedException, IOException {
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
        File file = new File("image.jpg");

            while (!file.exists()) {
                System.out.println("Enter HTTP status code");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                imageDownloader.downloadStatusImage(Integer.parseInt(reader.readLine()));
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Please enter valid number");
            } catch (PageNotFoundException e) {
                System.out.println("Page not found");
            }
        }
    }
}