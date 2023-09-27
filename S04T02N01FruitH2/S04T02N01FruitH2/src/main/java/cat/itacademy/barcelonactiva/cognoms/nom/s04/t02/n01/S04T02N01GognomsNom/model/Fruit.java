package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01GognomsNom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//@genvalue is used to define the gen strategy, here type.auto auto increments the value
	private long id;
	
	@Column(name = "name")	//@column with name = value maps to what column the data is applied to.
	private String name;
	
	@Column(name = "quantityKilos")
	private int quantityKilos;
	
	public Fruit() { }
	
	public Fruit(String name, int quantityKilos) {
		this.name = name;
		this.quantityKilos = quantityKilos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityKilos() {
		return quantityKilos;
	}

	public void setQuantityKilos(int quantityKilos) {
		this.quantityKilos = quantityKilos;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", quantityKilos=" + quantityKilos + "]";
	}
	
	

}
