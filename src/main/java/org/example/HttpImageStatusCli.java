package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class HttpImageStatusCli {
    public void askStatus() throws IOException, PageNotFoundException, URISyntaxException, InterruptedException {
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();

        System.out.println("Enter HTTP status code");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            imageDownloader.downloadStatusImage(Integer.parseInt(reader.readLine()));
        }catch (NumberFormatException ex){
            throw new InvalidFormatException("Please enter valid number");
        }
    }
}
