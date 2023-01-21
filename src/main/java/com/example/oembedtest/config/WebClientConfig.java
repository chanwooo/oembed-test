package com.example.oembedtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(-1))
                .build();

        WebClient webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .build();

        return webClient;
    }

}
