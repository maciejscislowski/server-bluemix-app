package it.scislowski.bluemix.server.config;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.dataload.DataLoader;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.spring.InitialDataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

/**
 * @author Maciej.Scislowski@gmail.com
 */
@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:bluemix.properties")
public class CloudConfig extends AbstractCloudConfig {

    @Value("${cloudant.db-name}")
    private String dbName;

    @Bean
    public CouchDbConnector couchDbConnector() throws Exception {
        CouchDbConnector connector = new StdCouchDbConnector(dbName, couchDbInstance());
        connector.createDatabaseIfNotExists();
        return connector;
    }

    @Bean
    public InitialDataLoader initialDataLoader(List<DataLoader> l, ResourceLoader rl) {
        return new InitialDataLoader(l, rl);
    }

    @Bean
    public CouchDbInstance couchDbInstance() {
        return connectionFactory().service(CouchDbInstance.class);
    }

}
