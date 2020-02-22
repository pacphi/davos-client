package io.pivotal.davos;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "davos.uaa")
class UaaCredentials {
    private String apiEndpoint = "uaa.run.pivotal.io";
    private String username;
    private String password;
    private String clientId = "davos";
    private String clientSecret = "";
}