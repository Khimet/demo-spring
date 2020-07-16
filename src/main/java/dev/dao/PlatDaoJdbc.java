package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

/** Implémentation de l'interface dev.dao.IPlatDao qui utilise JdbcTemplate pour accéder aux données
 * @author Khalil HIMET
 *
 */
@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {
	
	private JdbcTemplate jdbcTemplate;
	
	/** Constructeur
	 * 
	 */
	public PlatDaoJdbc(DataSource ds) {
		
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Plat> listerPlats() {
		// Récupérer les plats de la base de données
		return jdbcTemplate.query("select * from plat", new PlatRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		
		Plat plat = new Plat(nomPlat, prixPlat);
		
		jdbcTemplate.update("INSERT INTO plat (nom, prix) VALUES (?,?)", plat.getNom(), plat.getPrixEnCentimesEuros());
		
	}
	
	

}
