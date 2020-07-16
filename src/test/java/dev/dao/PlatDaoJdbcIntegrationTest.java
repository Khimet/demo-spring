package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.DataSourceH2TestConfig;
import dev.config.JdbcTestConfig;
import dev.entite.Plat;

/**
 * @author Khalil HIMET
 *
 */
@SpringJUnitConfig(classes = {PlatDaoJdbc.class, JdbcTestConfig.class})
@ActiveProfiles("jdbc")
public class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private PlatDaoJdbc platDaoJdbc;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@BeforeEach
//	void setUp() {
//		
//		platDaoJdbc = new PlatDaoJdbc(dataSourceH2TestConfig.dataSource());
//	}
	
	@Test
	void listerPlatsNonVide() {
		
		List<Plat> resultats = platDaoJdbc.listerPlats();
		
		assertThat(resultats).isNotEmpty();
		
	}
	@Test
	void ajouterPlatValide() {
		
		platDaoJdbc.ajouterPlat("Pot au feu", 123444);
		List<Plat> resultat = jdbcTemplate.query("select * from plat WHERE nom=? and prix=?",
				new Object[]{"Pot au feu", 123444},
				new PlatRowMapper());
		
		assertThat(resultat).extracting(Plat::getNom).containsExactly("Pot au feu");
		assertThat(resultat).extracting(Plat::getPrixEnCentimesEuros).containsExactly(123444);
		
		
	}
	
	
	

}
