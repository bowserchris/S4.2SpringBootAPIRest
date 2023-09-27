package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01GognomsNom.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01GognomsNom.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long>{
	
	List<Fruit> findByName(String name);
	
	List<Fruit> findByQuantityKilos(int kilos);
	
}
