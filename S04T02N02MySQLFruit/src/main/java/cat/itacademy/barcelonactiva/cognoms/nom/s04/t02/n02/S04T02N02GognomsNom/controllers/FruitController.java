package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.repository.FruitRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")		//seguramente cambio el api a fruit y aqui uso como base el getmapping al resto, pero queria asegurar para los otros funcionan bien.
public class FruitController {
	
	@Autowired			// this injects the repository bean as a local variable to the controller
	FruitRepository fruitRepository;
	
	@GetMapping("/fruit")
	public ResponseEntity<List<Fruit>> getAllFruits(@RequestParam(required = false) String name) {
		try {
			List<Fruit> fruit = new ArrayList();
			
			if (name == null) {
				fruitRepository.findAll().forEach(fruit::add);
			} else {
				fruitRepository.findByName(name).forEach(fruit::add);
			}
			
			if (fruit.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(fruit, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//add new fruit to database
	@PostMapping("/fruit/add")
	public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
		try {
			Fruit newFruit = fruitRepository.save(new Fruit(fruit.getName(), fruit.getQuantityKilos()));
			return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update fruit to database
	@PutMapping("/fruit/update/{id}")
	public ResponseEntity<Fruit> updateFruit(@PathVariable("id") long id, @RequestBody Fruit fruit) {
		Optional<Fruit> fruitData = fruitRepository.findById(id);
		
		if (fruitData.isPresent()) {
			Fruit fruitCheck = fruitData.get();
			fruitCheck.setName(fruit.getName());
			fruitCheck.setQuantityKilos(fruit.getQuantityKilos());
			return new ResponseEntity<>(fruitRepository.save(fruitCheck), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete fruit object with id to fruit
	@DeleteMapping("/fruit/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {
		try {
			fruitRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//receive info on one fruit object with id as optional
	@GetMapping("/fruit/getOne/{id}")
	public ResponseEntity<Fruit> getFruitById(@PathVariable("id") long id) {
		Optional<Fruit> fruitData = fruitRepository.findById(id);

		if (fruitData.isPresent()) {
			return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//get full list of fruits and print
	@GetMapping("/fruit/getAll")
	public ResponseEntity<List<Fruit>> getAllFruit(@RequestParam(required = false) String name) {
		try {
			
			List<Fruit> fruits = new ArrayList<Fruit>();
			
			if(name == null) {
				fruitRepository.findAll().forEach(fruits::add);
			} else {
				fruitRepository.findByName(name).forEach(fruits::add);
			}
			
			if (fruits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(fruits, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

}
