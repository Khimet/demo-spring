package dev.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;

/**
 * @author Khalil HIMET
 *
 */
@ContextConfiguration(classes = {PlatServiceVersion2.class, PlatDaoMemoire.class}) // ne s'utilise que pour les tests
@ExtendWith(SpringExtension.class) // laisser spring Test gérer le cycle de vie du test
@ActiveProfiles({"V2", "memoire"})
class PlatServiceVersion2IntegrationTest {
	@Autowired
	private PlatServiceVersion2 service2;


	@Test
	void lister() {
		List<Plat> resultats = service2.listerPlats();
	}
	
	@Test
	void ajouterPlatTest_Nom_et_Prix_Valides() {
		
		service2.ajouterPlat("lasagnes", 20000);
		
		List<Plat> resultats = service2.listerPlats();
		
		assertThat(resultats).extracting(Plat::getNom).containsExactly("lasagnes");
		assertThat(resultats).extracting(Plat::getPrixEnCentimesEuros).containsExactly(20000);
		
		
	}
	
	@Test
	void ajouterPlatTest_Prix_Invalide() {
		
		assertThatThrownBy(() -> service2.ajouterPlat("lasagnes", 20))
			.isInstanceOf(PlatException.class)
			.hasMessage("le prix d'un plat doit être supérieur à 10 €");
	}

}
