package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

/** Classe éxécutable de test du contexte Spring
 * @author Khalil HIMET
 *
 */
public class AppSpringXML {

	/**
	 * @param args non utilisés ici
	 */
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-memoire.xml");
		
		Scanner scanner = context.getBean(Scanner.class);
		
		// récupération du bean Menu
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		
		// fermeture du Scanner
		context.getBean(Scanner.class).close();
		
		context.close();

	}

}
