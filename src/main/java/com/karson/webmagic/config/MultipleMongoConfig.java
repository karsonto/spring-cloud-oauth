package com.karson.webmagic.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MultipleMongoConfig {

	@Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate mongoTemplate() throws Exception {
        //remove _class
        MappingMongoConverter converter =
            new MappingMongoConverter(this.primaryFactory(this.mongoProperties.getPrimary()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(this.primaryFactory(this.mongoProperties.getPrimary()), converter);
        return mongoTemplate;

      }
    


    @Bean
    @Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws Exception {
    	 //remove _class
        MappingMongoConverter converter =
            new MappingMongoConverter(this.secondaryFactory(this.mongoProperties.getSecondary()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(this.secondaryFactory(this.mongoProperties.getSecondary()), converter);
        return mongoTemplate;
    }
    
    
    
    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
    	/**no auth
    	 * */
         //return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
         //     mongo.getDatabase());
     	/**have auth**/
    	      ServerAddress server = new ServerAddress(mongo.getHost(), mongo.getPort());
    	      List<MongoCredential> credentials = new ArrayList<MongoCredential>();
    		  MongoCredential mongoCredential = MongoCredential.createCredential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
    		  credentials.add(mongoCredential);
    		  MongoClient mongoClient =  new MongoClient(server,credentials);
    		  return new SimpleMongoDbFactory(mongoClient,mongo.getDatabase());
    	
    	    
    }

    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongo) throws Exception {
    	/**no auth
    	 * */
     //  return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
       //         mongo.getDatabase());
    	/**have auth**/
    	ServerAddress server = new ServerAddress(mongo.getHost(), mongo.getPort());
		  List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		  MongoCredential mongoCredential = MongoCredential.createCredential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
		  credentials.add(mongoCredential);
		  MongoClient mongoClient =  new MongoClient(server,credentials);
		  return new SimpleMongoDbFactory(mongoClient,mongo.getDatabase());
    	 
    }
 

	

    
}