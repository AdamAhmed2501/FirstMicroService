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
@CrossOrigin(origins = "*")
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

	@GetMapping("/Actor/List")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Actor/{id}")
	public Actor getActor(@PathVariable int id) {
		return actorRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	@PostMapping("/Actor/New")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return saved;
	}

	@PutMapping("/Actor/Edit/{id}")
	public ResponseEntity updateActor(@PathVariable int id, @RequestParam String first_name, String last_name) {
		Actor currentActor = actorRepository.findById(id).orElseThrow(RuntimeException::new);
		currentActor.setFirst_name(first_name);
		currentActor.setLast_name(last_name);
		Actor newActor = new Actor(first_name, last_name);
		currentActor = actorRepository.save(newActor);

		return ResponseEntity.ok(currentActor);
	}

	@DeleteMapping("/Actor/Delete/{id}")
	public ResponseEntity deleteActor(@PathVariable int id) {
		actorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/Address/List")
	public @ResponseBody
	Iterable<Address> getAllAddress(){
		return addressRepository.findAll();
	}

	@GetMapping("/Address/{id}")
	public Address getAddress(@PathVariable int id) {
		return addressRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	@PostMapping("/Address/New")
	public @ResponseBody
	String addAddress(@RequestParam String address, String address2, String district, String postal_code, double phone, String location){
		Address addAddress = new Address(address, address2, district, postal_code, phone, location);
		addressRepository.save(addAddress);
		return saved;
	}
	@PutMapping("/Address/Edit/{id}")
	public ResponseEntity<Address> updateAddress(@RequestParam Integer id, @RequestParam String address, @RequestParam String address2, @RequestParam String district, @RequestParam String postal_code, @RequestParam double phone, @RequestParam String location){
		Address updateAddress = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address does not exist with id: " + id));
		updateAddress.setAddress(address);
		updateAddress.setAddress2(address2);
		updateAddress.setDistrict(district);
		updateAddress.setPostal_code(postal_code);
		updateAddress.setPhone(phone);
		updateAddress.setLocation(location);
		addressRepository.save(updateAddress);
		return ResponseEntity.ok(updateAddress);
	}

	@DeleteMapping("/Address/Delete/{id}")
	public ResponseEntity<Address> deleteAddress(@RequestParam Integer id){
		Address deleteAddress = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address does not exist with id: " + id));
		addressRepository.deleteById(id);
		return ResponseEntity.ok(deleteAddress);
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
