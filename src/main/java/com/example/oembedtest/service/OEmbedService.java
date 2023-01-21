package com.example.oembedtest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OEmbedService {

    private final WebClient webClient;

    public String httpGet(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String oEmbedUrlConverter(String url) {
        String oEmbedUrl = "";

        if (url.contains("youtube.com")) {
            oEmbedUrl += "https://www.youtube.com/oembed?format=json&url=" + url;
        } else if (url.contains("instagram.com")) {
            oEmbedUrl += "https://extractus.deno.dev/extract?apikey=rn0wbHos2e73W6ghQf705bdF&type=oembed&url=" + url;
        } else if (url.contains("twitter.com")) {
            oEmbedUrl += "https://publish.twitter.com/oembed?url=" + url;
        } else if (url.contains("vimeo.com")) {
            oEmbedUrl += "https://vimeo.com/api/oembed.json?url=" + url;
        } else {
            throw new RuntimeException("not support media");
        }
        return oEmbedUrl;
    }
}
