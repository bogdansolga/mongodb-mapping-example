package com.example.mapping.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ConnectionPoolSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.TimeUnit;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories("com.example.mapping.domain.model.repository")
@EnableTransactionManagement
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    private static final int NUMBER_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        // more info - http://mongodb.github.io/mongo-java-driver/4.0/driver/tutorials/connect-to-mongodb/

        ConnectionString connectionString =
                new ConnectionString("mongodb://" + username + ":" + password + "@" + host + ":" + port);
        MongoClientSettings settings = MongoClientSettings.builder()
                                                          .applicationName("com/inditex/orchestrator")
                                                          .applyConnectionString(connectionString)
                                                          .applyToConnectionPoolSettings(this::configurePooling)
                                                          .applyToClusterSettings(builder ->
                                                                  builder.hosts(
                                                                      singletonList((new ServerAddress(host, port))))
                                                                         .mode(ClusterConnectionMode.SINGLE)
                                                                         .maxWaitQueueSize(10_000))
                                                          .build();

        return MongoClients.create(settings);
    }

    private void configurePooling(ConnectionPoolSettings.Builder builder) {
        builder.minSize(1);
        builder.maxSize(NUMBER_OF_PROCESSORS);
        builder.maxWaitTime(5000L, TimeUnit.MILLISECONDS);
        builder.maxConnectionIdleTime(10000L, TimeUnit.MILLISECONDS);
    }

    @Bean
    @Primary
    public MongoCredential mongoCredential() {
        return MongoCredential.createCredential(username, databaseName, password.toCharArray());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, databaseName);
    }

    @Override
    public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
        final MongoMappingContext mongoMappingContext = super.mongoMappingContext();
        mongoMappingContext.setAutoIndexCreation(true);
        return mongoMappingContext;
    }
}
