package com.nisum.contact.configuration;

import lombok.Setter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {
    @Setter
    private int maxConnectionsPerRoute = 20;
    @Setter
    private int connectionTimeout = 5000;
    @Setter
    private int socketTimeout = 60000;

    @Bean
    public HttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
        return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setConnectionManager(clientConnectionManager()).build();
    }

    @Bean(destroyMethod = "shutdown")
    public HttpClientConnectionManager clientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);
        return connectionManager;
    }

}
