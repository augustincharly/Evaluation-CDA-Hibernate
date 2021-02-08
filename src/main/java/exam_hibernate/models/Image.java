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
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@Column(name = "nom", nullable = false)
	@NotBlank(message = "nom cannot be blank")
	@NotNull(message = "nom cannot be null")
	private String nom;
	
	@ManyToOne()
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	@NotBlank(message = "car cannot be blank")
	@NotNull(message = "car cannot be null")
	private Car car;

}
