package dev.service;

//import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * @author Khalil HIMET
 *
 */
class PlatServiceVersion1Test {
	
	private PlatServiceVersion1 service1;
	private IPlatDao platDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		
		platDao = mock(IPlatDao.class);
		service1 = new PlatServiceVersion1(platDao);
	}

	@Test
	void ajouterPlatTest_nom_invalide() {
		
		
		assertThatThrownBy(() -> service1.ajouterPlat("ab", 1548))
			.isInstanceOf(PlatException.class)
			.hasMessage("un plat doit avoir un nom de plus de 3 caractères");
		
	
	}
	
	@Test
	void ajouterPlatPrixInvalide() {
		
		assertThatThrownBy(() -> service1.ajouterPlat("riz basmati", 20))
			.isInstanceOf(PlatException.class)
			.hasMessage("le prix d'un plat doit être supérieur à 5 €");
	}
	
	@Test
	void ajouterPlatValide() {
		
		service1.ajouterPlat("burger", 12555);
		verify(platDao).ajouterPlat("burger", 12555);
		
		
	}

}
