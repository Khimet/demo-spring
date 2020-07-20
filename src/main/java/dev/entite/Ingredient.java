package dev.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Khalil HIMET
 *
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nom")
	private String nom;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Plat> plats = new ArrayList<>();

	/** Getter
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return plats
	 */
	public List<Plat> getPlats() {
		return plats;
	}

	/** Setter
	 * @param plats plats
	 */
	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}
	
	
	
	

}
