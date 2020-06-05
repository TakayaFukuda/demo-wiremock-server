package jp.co.sample.demo.wiremock.server;

import com.github.tomakehurst.wiremock.WireMockServer;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WireMockApplication implements CommandLineRunner {

    @Autowired
    private WireMockServer wireMockServer;

    public static void main(String[] args) {
        SpringApplication.run(WireMockApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        wireMockServer.start();
    }

    @PreDestroy
    public void tearDown() {
        wireMockServer.shutdown();
    }
}
