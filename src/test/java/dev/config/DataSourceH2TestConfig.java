package dev.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Khalil HIMET
 *
 */
@Configuration
@Profile("jdbc | jpa")
public class DataSourceH2TestConfig {
	
	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema-h2.sql")
				.addScript("classpath:data-h2.sql")
				.build();
	}

}
