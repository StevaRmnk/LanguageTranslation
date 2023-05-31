package com.example.LanguagesTranslation.ServiceImplement;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class ExternalApiServiceImpl {

    public ModelAndView getTranslationsFromAPI( @PathVariable(value = "language") String language) throws IOException, InterruptedException {

        String target = getTarget(language);

        if(target == null) {
            ModelAndView page = new ModelAndView("helloworld");
            page.addObject("text", "Language doesn't exists!");
        } else if(!target.equalsIgnoreCase("en")) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "application/gzip")
                    .header("X-RapidAPI-Key", "6e35ed755fmsh9770bc385f97d71p166555jsn172cfe22ab75")
                    .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                    .method("POST", HttpRequest.BodyPublishers.ofString("q=Hello%2C%20world!&target=" + target + "&source=en"))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            ModelAndView page = new ModelAndView("helloworld");
            page.addObject("text", response.body().toString().split("\"translatedText\":\"")[1].split("\"}")[0]);

        }else {
            ModelAndView page = new ModelAndView("helloworld");
            page.addObject("text", "Hello World!");
        }

        return new ModelAndView("helloWorld");
    }

    private String getTarget(String language) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("localizations/localization.csv");
        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try (BufferedReader br = new BufferedReader(streamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.split(" ")[0].equalsIgnoreCase(language)) {
                    return line.split(" ")[1];
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
