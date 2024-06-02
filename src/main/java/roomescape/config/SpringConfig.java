package roomescape.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.time.Duration;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import roomescape.config.objectmapper.CustomLocalDateDeserializer;
import roomescape.config.objectmapper.CustomLocalDateSerializer;
import roomescape.config.objectmapper.CustomLocalTimeDeserializer;
import roomescape.config.objectmapper.CustomLocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.exception.RestClientResponseExceptionHandler;

@Configuration
public class SpringConfig {

    @Bean
    ObjectMapper objectMapper() {
        return JsonMapper.builder()
                .addModule(new SimpleModule().addDeserializer(LocalDate.class, new CustomLocalDateDeserializer()))
                .addModule(new SimpleModule().addDeserializer(LocalTime.class, new CustomLocalTimeDeserializer()))
                .addModule(new SimpleModule().addSerializer(LocalDate.class, new CustomLocalDateSerializer()))
                .addModule(new SimpleModule().addSerializer(LocalTime.class, new CustomLocalTimeSerializer()))
                .build();
    }

    @Bean
    public RestClient restClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder.build();
    }

    @Bean
    public RestClientCustomizer restClientCustomizer() {
        return (restClientBuilder) -> restClientBuilder
                .requestFactory(clientHttpRequestFactory())
                .defaultStatusHandler(new RestClientResponseExceptionHandler());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        ClientHttpRequestFactorySettings settings = ClientHttpRequestFactorySettings.DEFAULTS
                .withConnectTimeout(Duration.ofSeconds(3L))
                .withReadTimeout(Duration.ofSeconds(30L));
        return ClientHttpRequestFactories.get(JdkClientHttpRequestFactory.class, settings);
    }
}
