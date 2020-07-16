package dev.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.entite.Plat;

/**
 * @author Khalil HIMET
 *
 */
public class PlatRowMapper implements RowMapper<Plat> {
	
	//1 ligne de base de données => 1 objet
	@Override
	public Plat mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Plat plat = new Plat();
		plat.setNom(resultSet.getString("nom"));
		plat.setPrixEnCentimesEuros(resultSet.getInt("prix"));
		return plat;
	}

}
