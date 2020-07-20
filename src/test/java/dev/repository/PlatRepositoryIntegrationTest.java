package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.xdevapi.Result;

import dev.config.JpaTestConfig;
import dev.dao.PlatDaoJpa;
import dev.entite.Plat;

/**
 * @author Khalil HIMET
 *
 */
@SpringJUnitConfig(classes = { JpaTestConfig.class })
@ActiveProfiles("jpa")
public class PlatRepositoryIntegrationTest {

	@Autowired
	private PlatRepository platRepository;

	@Test
	void testFindAll() {

		List<Plat> resultats = platRepository.findAll();

		assertThat(resultats).isNotEmpty();

	}

	@Test
	void testFindAllSortAsc() {

		List<Plat> resultats = platRepository.findAll(Sort.by(Sort.Direction.ASC, "prixEnCentimesEuros"));

		for (Plat plat : resultats) {

			System.out.println(plat.getPrixEnCentimesEuros());
		}

		assertThat(resultats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros));
	}

	@Test
	void testFindAllSortDesc() {

		List<Plat> resultats = platRepository.findAll(Sort.by(Sort.Direction.DESC, "prixEnCentimesEuros"));

		for (Plat plat : resultats) {

			System.out.println(plat.getPrixEnCentimesEuros());
		}
		
		assertThat(resultats).isSortedAccordingTo(Comparator.comparing(Plat::getPrixEnCentimesEuros).reversed());
		
	}
	
	@Test
	void testFindAllPageable() {
		
		List<Plat> plats = platRepository.findAll(PageRequest.of(0, 2, Sort.by("nom").ascending())).toList();
		assertThat(plats).extracting(Plat::getNom).containsExactly("Blanquette de veau", "Couscous");
	}
	
	@Test
	public void testFindById() {
		
		Optional<Plat> plat = platRepository.findById(1);
		assertThat(plat).contains(new Plat("Magret de canard", 1300));
	}
	
	@Test
	@Transactional
	public void testGetOne() {
		
		Plat plat = platRepository.getOne(1);
		assertThat(plat.getNom()).isEqualTo("Magret de canard");
		assertThat(plat.getPrixEnCentimesEuros()).isEqualTo(1300);
	}
	
	@Test
	public void testCount() {
		
		assertThat(platRepository.count()).isEqualTo(6);
	}
	
	@Test
	public void testFindByPrix() {
		List<Plat> plats = platRepository.findByPrixEnCentimesEuros(1300);
		assertThat(plats).hasSize(2);
	}
	
	@Test
	public void testAvgPrix() {
		double res = platRepository.avgPrix(1500);
		assertThat(res).isEqualTo(2050); //avg({1600,2500}) = 2050
	}
	
	@Test
	public void testFindByNomWithIngredients() {
		assertThat(platRepository.FindByNomWithIngredients("Moules-frites")).hasSize(6);
	}
	
	@Test
	public void testSave() {
		Plat plat = new Plat("Tarte aux escargots",1200);
		platRepository.save(plat);
		assertThat(platRepository.findAll()).contains(plat);
	}
	
	@Test
	@Transactional
	public void testChangerNom() {
		platRepository.ChangerNomPlat("Magret de canard", "Confit de canard");
		List<Plat> plats = platRepository.findAll();
		assertThat(plats).extracting(Plat::getNom).contains("Confit de canard");
		assertThat(plats).extracting(Plat::getNom).doesNotContain("Magret de canard");
	}
	
	
	
	

}
