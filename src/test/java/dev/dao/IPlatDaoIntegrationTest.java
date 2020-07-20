package dev.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import dev.entite.Plat;

/**
 * @author Khalil HIMET
 *
 */
// EMF + Gestion Tx + DataSource
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class IPlatDaoIntegrationTest {
	
	private IPlatDao dao;
	
//	@Autowired
//	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void listerPlatsNonVide() {
		List<Plat> resultats = dao.listerPlats();
		assertThat(resultats).isNotEmpty();
	}
	
	@Test
	void ajouterPlatValide() {
		dao.ajouterPlat("Pizzaladière", 6000);

		List<Plat> resultat = jdbcTemplate.query(
				"select * from PLAT where NOM=? and PRIX=?",
				new Object[]{"Pizzaladière", 6000},
				new PlatRowMapper());

		assertThat(resultat).isNotEmpty();
	}

}
