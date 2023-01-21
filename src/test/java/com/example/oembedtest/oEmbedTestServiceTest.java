package com.example.oembedtest;

import com.example.oembedtest.service.OEmbedService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class oEmbedTestServiceTest {

    @Autowired
    OEmbedService oEmbedTestService;

    @ParameterizedTest
    @ValueSource(strings = {
            "https://www.youtube.com/oembed?format=json&url=https://www.youtube.com/watch?v=dBD54EZIrZo",
            "https://publish.twitter.com/oembed?url=https://twitter.com/hellopolicy/status/867177144815804416"
    })
    void testConnection(String url) {
        String s = oEmbedTestService.httpGet(url);
        log.info("s = " + s);

        assertThat(s).contains("html");
        assertThat(s).contains("version");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "https://www.youtube.com/watch?v=dBD54EZIrZo",
            "https://www.instagram.com/p/BUawPlPF_Rx/",
            "https://twitter.com/hellopolicy/status/867177144815804416",
            "https://vimeo.com/20097015"
    })
    void urlConvTest(String url) {
        String s = oEmbedTestService.oEmbedUrlConverter(url);
        log.info("s = " + s);

        assertThat(s).contains("oembed");
    }
}