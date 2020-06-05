package jp.co.sample.demo.wiremock.server.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockServersFactory {

    @Value("${wiremock.is-local}")
    private boolean isLocal;

    private String PWD = System.getProperty("user.dir");
    /**
     * WireMockServer Bean
     * Use DynamicPort.
     * @return
     */
    @Bean
    public WireMockServer wireMockServer() {
        String rootDir = PWD
                + (isLocal ? "/src/main/resources" : "/BOOT-INF/classes");
        return new WireMockServer(
                WireMockConfiguration.options()
                        .port(WireMockConfiguration.DEFAULT_PORT)
                        .withRootDirectory(rootDir)
        );
    }
}
