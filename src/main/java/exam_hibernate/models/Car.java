package exam_hibernate.models;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cars", cascade = CascadeType.ALL)
	private List<Color> colors;

	@ManyToOne()
	@JoinColumn(name = "garage_id", referencedColumnName = "id")
	@NotBlank(message = "garage cannot be blank")
	@NotNull(message = "garage cannot be null")
	private Garage garage;

	@Column(name = "marque", nullable = false)
	@NotBlank(message = "marque cannot be blank")
	@NotNull(message = "marque cannot be null")
	private String marque;

	@Column(name = "modele", nullable = false)
	@NotBlank(message = "modele cannot be blank")
	@NotNull(message = "modele cannot be null")
	private String modele;

	@Column(name = "carburant", nullable = false)
	@NotBlank(message = "carburant cannot be blank")
	@NotNull(message = "carburant cannot be null")
	private String carburant;

	@Column(name = "annee", nullable = false, length = 11)
	@NotBlank(message = "annee cannot be blank")
	@NotNull(message = "annee cannot be null")
	private Integer annee;

	@Column(name = "kilometrage", nullable = false, length = 11)
	@NotBlank(message = "kilometrage cannot be blank")
	@NotNull(message = "kilometrage cannot be null")
	private Integer kilometrage;

	@Column(name = "prix", nullable = false, length = 11)
	@NotBlank(message = "prix cannot be blank")
	@NotNull(message = "prix cannot be null")
	private Integer prix;

	@Column(name = "date_ajout", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotBlank(message = "dateAjout cannot be blank")
	@NotNull(message = "dateAjout cannot be null")
	private Date dateAjout;

	@Column(name = "description", nullable = false)
	@Type(type = "text")
	@NotBlank(message = "description cannot be blank")
	@NotNull(message = "description cannot be null")
	private String description;

	public void Car() {
		this.colors = Collections.emptyList();
	}

	public void addColor(Color color) {
		this.colors.add(color);
	}

	public void deleteColor(Color color) {
		this.colors.remove(color);
	}

	public List<Color> getColors() {
		return this.colors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", garage=" + garage + ", marque=" + marque + ", modele=" + modele + ", carburant="
				+ carburant + ", annee=" + annee + ", kilometrage=" + kilometrage + ", prix=" + prix + ", dateAjout="
				+ dateAjout + ", description=" + description + "]";
	}

}
