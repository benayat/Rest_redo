package com.example.rest_redo.config.elastic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.rest_redo.repository")
@Slf4j
public class ElasticsearchClientConfiguration  extends AbstractElasticsearchConfiguration {
    @Value("${elastic.hostandport}")
    private String elasticHost;
    @SneakyThrows
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        log.info("the host is:"+elasticHost);
        final ClientConfiguration clientConfiguration = ClientConfiguration.create(elasticHost);
        log.info("just testing "+clientConfiguration);
        final RestHighLevelClient highLevelClient = RestClients.create(clientConfiguration).rest();
        return highLevelClient;
    }

}
