package exam_hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@Column(name = "username", nullable = false, unique = true, length = 180)
	@NotBlank(message = "username cannot be blank")
	@NotNull(message = "username cannot be null")
	private String username;

	@Column(name = "roles", nullable = false)
	@Type(type = "text")
	@NotBlank(message = "roles cannot be blank")
	@NotNull(message = "roles cannot be null")
	private String roles;

	@Column(name = "password", nullable = false)
	@NotBlank(message = "password cannot be blank")
	@NotNull(message = "password cannot be null")
	private String password;

	@Column(name = "email", nullable = false)
	@NotBlank(message = "email cannot be blank")
	@NotNull(message = "email cannot be null")
	private String email;

	@Column(name = "nom", nullable = false)
	@NotBlank(message = "nom cannot be blank")
	@NotNull(message = "nom cannot be null")
	private String nom;

	@Column(name = "prenom", nullable = false)
	@NotBlank(message = "prenom cannot be blank")
	@NotNull(message = "prenom cannot be null")
	private String prenom;

	@Column(name = "num_telephone", nullable = false)
	@NotBlank(message = "numTelephone cannot be blank")
	@NotNull(message = "numTelephone cannot be null")
	private String numTelephone;

}
