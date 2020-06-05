package jp.co.sample.demo.wiremock.server.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockServersFactory {
    /**
     * WireMockServer Bean
     * Use DynamicPort.
     * @return
     */
    @Bean
    public WireMockServer wireMockServer() {
        return new WireMockServer(
                WireMockConfiguration.options()
                        .port(WireMockConfiguration.DEFAULT_PORT)
        );
    }
}
