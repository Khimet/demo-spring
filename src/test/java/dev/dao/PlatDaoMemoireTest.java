package dev.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;

/**
 * @author Khalil HIMET
 *
 */
class PlatDaoMemoireTest {
	
	private PlatDaoMemoire platDaoMemoire;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		
		this.platDaoMemoire = new PlatDaoMemoire();
		
	}

	@Test
	void listerPlatsVideALInitialisation() {
		List<Plat> resultatAttendu = platDaoMemoire.listerPlats();
		
		assertThat(resultatAttendu).hasSize(0);
		
	}
	
	@Test
	void ajouterPlatCasPassants() {
		
//		List<Plat> listePlatInitial = platDaoMemoire.listerPlats();
//		
//		int tailleInitiale = listePlatInitial.size();
//	
//		platDaoMemoire.ajouterPlat("pizza", 150888);
//		
//		List<Plat> listeApresAjout = platDaoMemoire.listerPlats();
//		
//		assertThat(listeApresAjout.size()).isGreaterThan(tailleInitiale);
		//((List<Plat>) assertThat(listeApresAjout.get(listeApresAjout.size() - 1)).extracting(Plat::getNom)).contains("pizza");
		
		// ##### Correction Rossi #######
		
		platDaoMemoire.ajouterPlat("pizza", 100);
		
		List<Plat> resultats = platDaoMemoire.listerPlats();
		
		assertThat(resultats).extracting(Plat::getNom).containsExactly("pizza");
		assertThat(resultats).extracting(Plat::getPrixEnCentimesEuros).containsExactly(100);
		
		
	}

}
