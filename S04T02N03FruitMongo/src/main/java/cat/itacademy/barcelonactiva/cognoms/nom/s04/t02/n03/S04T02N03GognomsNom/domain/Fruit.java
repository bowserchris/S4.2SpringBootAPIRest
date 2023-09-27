package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

//
import jakarta.persistence.*;

@Document(collection = "Fruit")
public class Fruit {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	//@genvalue is used to define the gen strategy, here type.auto auto increments the value
	private long id;
	
	//@Column()	//@column with name = value maps to what column the data is applied to.
	private String name;
	
	//@Column(name = "Quantity in Kilos")
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
