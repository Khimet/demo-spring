package dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Classe de configuration qui contient toutes les éléments nécessaires à la
 * connexion à la bdd restaurant-bdd
 * 
 * @author Khalil HIMET
 *
 */
@Configuration
@Profile("jdbc")
public class DataSourceConfig {

	@Bean
	public DataSource dataSource(@Value("${bdd.driver}") String driver, 
			@Value("${bdd.user}") String utilisateur,
			@Value("${bdd.pass}") String motDePasse, 
			@Value("${bdd.url}") String url) {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(utilisateur);
		dataSource.setPassword(motDePasse);
		
		return dataSource;
	}

}
