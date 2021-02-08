package exam_hibernate.models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "color")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "color_car", joinColumns = { @JoinColumn(name = "color_id") }, inverseJoinColumns = {
			@JoinColumn(name = "car_id") })
	private List<Car> cars;

	@Column(name = "libelle", nullable = false)
	@NotBlank(message = "libelle cannot be blank")
	@NotNull(message = "libelle cannot be null")
	private String libelle;

	public Color() {
		this.cars = Collections.emptyList();
	}

	public void addCar(Car car) {
		this.cars.add(car);
	}

	public void deleteCar(Car car) {
		this.cars.remove(car);
	}

	public List<Car> getCars() {
		return cars;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
