package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class Fruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//@genvalue is used to define the gen strategy, here type.auto auto increments the value
	private long id;
	
	@Column()	//@column with name = value maps to what column the data is applied to.
	private String name;
	
	@Column(name = "Quantity in Kilos")
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
