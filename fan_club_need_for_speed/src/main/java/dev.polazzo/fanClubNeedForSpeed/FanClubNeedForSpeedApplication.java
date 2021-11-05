package dev.polazzo.fanClubNeedForSpeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FanClubNeedForSpeedApplication {
    public static void main(String[] args) {
        SpringApplication.run(FanClubNeedForSpeedApplication.class, args);
    }
}
