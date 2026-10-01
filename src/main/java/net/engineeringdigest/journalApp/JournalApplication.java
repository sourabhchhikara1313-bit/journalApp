package net.engineeringdigest.journalApp;


import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

//	@Bean
//	public CommandLineRunner checkDb(MongoTemplate mongoTemplate, org.springframework.core.env.Environment env) {
//		return args -> {
//			System.out.println(">>>> CONNECTED TO DATABASE: " + mongoTemplate.getDb().getName());
//            System.out.println(">>>> RAW URI PROPERTY: [" + env.getProperty("spring.data.mongodb.uri") + "]");
//			System.out.println(">>>> Collections: " + mongoTemplate.getDb().listCollectionNames().into(new java.util.ArrayList<>()));
//		};
//	}

	@Bean
	public MongoDatabaseFactory mongoDatabaseFactory(@org.springframework.beans.factory.annotation.Value("${spring.data.mongodb.uri}") String uri){
		return new SimpleMongoClientDatabaseFactory(uri);
	}
}
//PlatformTransactionManager
//MongoTransactionManager
