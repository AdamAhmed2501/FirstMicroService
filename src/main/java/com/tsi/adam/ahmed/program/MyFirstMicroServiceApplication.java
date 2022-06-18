package com.tsi.adam.ahmed.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin
public class MyFirstMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FilmRepository filmRepository;

	private String saved = "Saved";

	public MyFirstMicroServiceApplication(ActorRepository actorRepository, AddressRepository addressRepository,
										  CategoryRepository categoryRepository, CityRepository cityRepository,
										  CountryRepository countryRepository, CustomerRepository customerRepository,
										  FilmRepository filmRepository) {

		this.actorRepository = actorRepository;
		this.addressRepository = addressRepository;
		this.categoryRepository = categoryRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.customerRepository = customerRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return saved;
	}

	@PutMapping("/Put_A_Actor")//update an actor within the actor table with the given id
	public ResponseEntity<Actor> updateActor(@RequestParam Integer id, @RequestParam String first_name, @RequestParam String last_name){
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with id: " + id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_A_Actor")//delete an actor from the actor table with the given id
	public ResponseEntity<Actor> deleteActor(@RequestParam Integer id){
		Actor deleteActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + id));
		actorRepository.deleteById(id);
		return ResponseEntity.ok(deleteActor);
	}

	@GetMapping("/All_Address")
	public @ResponseBody
	Iterable<Address> getAllAddress(){
		return addressRepository.findAll();
	}

	@GetMapping("/All_Category")
	public @ResponseBody
	Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("/All_City")
	public @ResponseBody
	Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}

	@GetMapping("/All_Country")
	public @ResponseBody
	Iterable<Country> getAllCountry(){
		return countryRepository.findAll();
	}

	@GetMapping("/All_Customer")
	public @ResponseBody
	Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}

	@GetMapping("/All_Film")
	public @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}

}
