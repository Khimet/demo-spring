package dev.config;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/** Classe de configuration Spring
 * @author Khalil HIMET
 *
 */
@Configuration
@ComponentScan(basePackages = {"dev.ihm", "dev.service", "dev.dao"})
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean
	public Scanner scanner () {
		
		return new Scanner(System.in);
	}
	
	

}
