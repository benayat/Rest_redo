package com.example.rest_redo.config.elastic;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.rest_redo.repository")
@Slf4j
public class ElasticsearchClientConfiguration  extends AbstractElasticsearchConfiguration {
    @Value("${management.metrics.export.elastic.host}")
    private String elasticHost;
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        log.info("the host is:"+elasticHost);
        return new RestHighLevelClient(RestClient.builder(new HttpHost(elasticHost)));
    }

}
