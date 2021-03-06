package dev;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.ihm.Menu;

/**
 * @author Khalil HIMET
 *
 */
public class AppSpringJava {

	public static void main(String[] args) {

		// Création du contexte Spring à partir d'une configuration Java
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// définition des profils actifs
		//context.getEnvironment().setActiveProfiles("jdbc", "V2");
		//context.register(AppConfig.class);
		//context.refresh();
		
		// récupération du bean Menu
		Menu menu1 = context.getBean(Menu.class);
		menu1.afficher();
		// fermeture du Scanner
		context.getBean(Scanner.class).close();
		// fermeture du contexte Spring
		context.close();
	}

}
