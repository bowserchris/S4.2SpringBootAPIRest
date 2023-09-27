package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.domain.Fruit;

public interface FruitRepository extends MongoRepository<Fruit, Long>{
	
	List<Fruit> findByName(String name);
	
	List<Fruit> findByQuantityKilos(int kilos);
	
}
