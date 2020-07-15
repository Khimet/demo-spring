package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;
import dev.service.PlatServiceVersion1;
import dev.service.PlatServiceVersion2;

/**
 * @author Khalil HIMET
 *
 */
@SpringJUnitConfig(classes = {PlatDaoFichier.class})
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PlatDaoFichierTest {
	
	@Autowired
	private PlatDaoFichier daoFichier;


	@Test
	void ajouterPlatTest() {
		
		daoFichier.ajouterPlat("lokum", 155555);
		List<Plat> resultats = daoFichier.listerPlats();
		assertThat(resultats).extracting(Plat::getNom).containsExactly("lokum");
		assertThat(resultats).extracting(Plat::getPrixEnCentimesEuros).containsExactly(155555);
		assertThat(resultats).hasSize(1);
		
	}
	
	@Test
	void ajouterPlatTest2() {
		
		daoFichier.ajouterPlat("Iskender", 15668);
		List<Plat> resultats = daoFichier.listerPlats();
		assertThat(resultats).extracting(Plat::getNom).containsExactly("Iskender");
		assertThat(resultats).extracting(Plat::getPrixEnCentimesEuros).containsExactly(15668);
		assertThat(resultats).hasSize(1);
	}

}
