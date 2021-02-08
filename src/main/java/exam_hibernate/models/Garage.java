package exam_hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "garage")
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@NotBlank(message = "user cannot be blank")
	@NotNull(message = "user cannot be null")
	private User user;
	
	@Column(name = "nom", nullable = false)
	@NotBlank(message = "nom cannot be blank")
	@NotNull(message = "nom cannot be null")
	private String nom;
	
	@Column(name = "rue", nullable = false)
	@NotBlank(message = "rue cannot be blank")
	@NotNull(message = "rue cannot be null")
	private String rue;
	
	@Column(name = "code_postal", nullable = false)
	@NotBlank(message = "codePostal cannot be blank")
	@NotNull(message = "codePostal cannot be null")
	private String codePostal;
	
	@Column(name = "ville", nullable = false)
	@NotBlank(message = "ville cannot be blank")
	@NotNull(message = "ville cannot be null")
	private String ville;
	
	@Column(name = "num_telephone", nullable = false)
	@NotBlank(message = "numTelephone cannot be blank")
	@NotNull(message = "numTelephone cannot be null")
	private String numTelephone;
	
	@Column(name = "num_siret", nullable = false)
	@NotBlank(message = "numSiret cannot be blank")
	@NotNull(message = "numSiret cannot be null")
	private String numSiret;

}
