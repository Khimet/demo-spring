package dev.dao;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JpaTestConfig;

/**
 * @author Khalil HIMET
 *
 */

@SpringJUnitConfig(classes = {PlatDaoJpa.class, JpaTestConfig.class})
@ActiveProfiles("jpa")
public class PlatDaoJpaTest extends IPlatDaoTest {

}
