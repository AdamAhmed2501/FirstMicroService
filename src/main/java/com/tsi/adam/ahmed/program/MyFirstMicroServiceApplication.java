package com.tsi.adam.ahmed.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Year;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin(origins = "*")
public class MyFirstMicroServiceApplication {
	@Autowired    																										// Handles dependency injection.
	private ActorRepository actorRepository; 																			//Injects Actor Database.
	@Autowired    																										// Handles dependency injection.
	private AddressRepository addressRepository; 																		//Injects Address Database.
	@Autowired    																										// Handles dependency injection.
	private CategoryRepository categoryRepository; 																		//Injects Category Database.
	@Autowired    																										// Handles dependency injection.
	private CityRepository cityRepository; 																				//Injects City Database.
	@Autowired    																										// Handles dependency injection.
	private CountryRepository countryRepository; 																		//Injects Country Database.
	@Autowired    																										// Handles dependency injection.
	private CustomerRepository customerRepository; 																		//Injects Customer Database.
	@Autowired    																										// Handles dependency injection.
	private FilmRepository filmRepository; 																				//Injects Film Database.
	private String saved = "Saved";                                                                                     // Used later for confirmation.
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


//    |==========================|
//    |   	   ACTOR CRUD        |
//    |==========================|
	@GetMapping("/Actor/List")     																						// Command used to get a full list of actors.
	public @ResponseBody Iterable<Actor>getAllActors(){                                                                 // No variables required for this request.
		return actorRepository.findAll();   																			// Outputs a list of Actors.
	}

	@GetMapping("/Actor/{id}")                 																			// Command used to get a single actor by given ID.
	public Actor getActor(@PathVariable int id) {                                                                       // ID required as an input for this get request.
		return actorRepository.findById(id).orElseThrow(RuntimeException::new);                                         // Actor output or error depending on if the ID exists.
	}
	@PostMapping("/Actor/New")                                                                                          // Command used to add an actor.
	public @ResponseBody ResponseEntity<Actor> addActor(@RequestParam String first_name, String last_name){             // A first and last name are required for this request.
		Actor addActor = new Actor(first_name, last_name);                                                              // Takes the two parameters and assigns them to a variable
		if (addActor.getFirst_name() == null){                                                                          // Checks if a first name has been inputted
			ResponseEntity.ok("Both a first name and last name are required");                              		// Outputs a error message
		}
		else if (addActor.getLast_name() == null){                                                                      // Checks if a first name has been inputted
			ResponseEntity.ok("Both a first name and last name are required");     	                         	// Outputs an error message
		}
		else {
			actorRepository.save(addActor);                                                                             // Saves details to db.
		}   return ResponseEntity.ok(addActor);                                                                         // Outputs the details to conf.
	}

	@PutMapping("/Actor/Edit/{id}")                                                                                     // Command used to edit an actor.
	public @ResponseBody ResponseEntity<Actor> updateActor(@PathVariable int id, @RequestBody Actor actor){             // An ID, a first name and a last name are required.
		Actor updatedActor = actorRepository.findById(id).orElseThrow(()                                                // Finds the current actor and assigns details to a variable,
				-> new ResourceNotFoundException("Actor does not exist with the given ID."));                           //            		  or throws out an error msg.
		updatedActor.setFirst_name(actor.getFirst_name());                                                              // Changes the first name of the variable to input.
		updatedActor.setLast_name(actor.getLast_name());                                                                // Changes the last name of the variable to input.
		actorRepository.save(updatedActor);                                                                             // Outputs the updated information to confirm completion.
		return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/Actor/Delete/{id}")                                                                                // Command used to delete a single actor by given ID.
	public ResponseEntity<Actor> deleteActor(@PathVariable int id){                                                 	// ID required as an input for this get request.
		Actor deleteActor = actorRepository.findById(id).orElseThrow(()                                					// Actor assign or error depending on if the ID exists.
				-> new ResourceNotFoundException("Actor does not exist with given ID"));
		actorRepository.deleteById(deleteActor.getActor_id());                                                          // Delete actor profile.
		return ResponseEntity.ok(deleteActor);                                                                          // Output old profile as a conf.
	}




//    |==========================|
//    |   	  ADDRESS CRUD       |
//    |==========================|
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
	ResponseEntity<Address>  addAddress(@RequestParam String address, String address2, String district, String postal_code, double phone, String location){
		Address addAddress = new Address(address, address2, district, postal_code, phone, location);
		addressRepository.save(addAddress);
		return ResponseEntity.ok(addAddress);
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




//    |==========================|
//    |   	CATEGORY CRUD        |
//    |==========================|
	@GetMapping("/All_Category")
	public @ResponseBody
	Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("/Category/{id}")
	public Category getCategory(@PathVariable int id) {
		return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/Category/New")
	public @ResponseBody
	ResponseEntity<Category> addCategory(@RequestParam int id, String category){
		Category addCategory = new Category(category);
		categoryRepository.save(addCategory);
		return ResponseEntity.ok(addCategory);
	}

	@PutMapping("/Category/Edit/{id}")
	public ResponseEntity<Category> updateCategory(@RequestParam Integer id, @RequestParam String category){
		Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: " + id));
		updateCategory.set_name(category);
		categoryRepository.save(updateCategory);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/Category/Delete/{id}")
	public ResponseEntity<Category> deleteCategory(@RequestParam Integer id){
		Category deleteCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: " + id));
		categoryRepository.deleteById(id);
		return ResponseEntity.ok(deleteCategory);
	}



//    |==========================|
//    |   	   CITY CRUD         |
//    |==========================|
	@GetMapping("/All_City")
	public @ResponseBody
	Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}

	@GetMapping("/City/{id}")
	public City getCity(@PathVariable int id) {
		return cityRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/City/New")
	public @ResponseBody
	ResponseEntity<City>   addCity(@RequestParam int id, String city, int country_id){
		City addCity = new City(city);
		cityRepository.save(addCity);
		return ResponseEntity.ok(addCity);
	}

	@PutMapping("/City/Edit/{id}")
	public ResponseEntity<City> updateCity(@RequestParam Integer id, @RequestParam String city){
		City updateCity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City does not exist with id: " + id));
		updateCity.setCity(city);
		cityRepository.save(updateCity);
		return ResponseEntity.ok(updateCity);
	}

	@DeleteMapping("/City/Delete/{id}")
	public ResponseEntity<City> deleteCity(@RequestParam Integer id){
		City deleteCity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City does not exist with id: " + id));
		cityRepository.deleteById(id);
		return ResponseEntity.ok(deleteCity);
	}





//    |==========================|
//    |   	  COUNTRY CRUD       |
//    |==========================|
	@GetMapping("/All_Country")
	public @ResponseBody
	Iterable<Country> getAllCountry(){
		return countryRepository.findAll();
	}

	@GetMapping("/Country/{id}")
	public Country getCountry(@PathVariable int id) {
		return countryRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/Country/New")
	public @ResponseBody
	ResponseEntity<Country> addCountry(@RequestParam int id, String country){
		Country addCountry = new Country(country);
		countryRepository.save(addCountry);
		return ResponseEntity.ok(addCountry);
	}

	@PutMapping("/Country/Edit/{id}")
	public ResponseEntity<Country> updateCountry(@RequestParam Integer id, @RequestParam String country){
		Country updateCountry = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country does not exist with id: " + id));
		updateCountry.setCountry(country);
		countryRepository.save(updateCountry);
		return ResponseEntity.ok(updateCountry);
	}

	@DeleteMapping("/Country/Delete/{id}")
	public ResponseEntity<Country> deleteCountry(@RequestParam Integer id){
		Country deleteCountry = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country does not exist with id: " + id));
		countryRepository.deleteById(id);
		return ResponseEntity.ok(deleteCountry);
	}



//    |==========================|
//    |      CUSTOMER CRUD       |
//    |==========================|
	@GetMapping("/All_Customer")
	public @ResponseBody
	Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}

	@GetMapping("/Customer/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/Customer/New")
	public @ResponseBody
	ResponseEntity<Customer> addCustomer(@RequestParam String first_name, String last_name, String email, Boolean active, java.time.LocalDate create_date){
		Customer addCustomer = new Customer(first_name, last_name, email, active, create_date);
		customerRepository.save(addCustomer);
		return ResponseEntity.ok(addCustomer);
	}

	@PutMapping("/Customer/Edit/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestParam int id, @RequestParam String first_name, @RequestParam String last_name, @RequestParam String email, @RequestParam Boolean active, @RequestParam java.time.LocalDate create_date){
		Customer updateCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: " + id));
		updateCustomer.setFirst_name(first_name);
		updateCustomer.setLast_name(last_name);
		updateCustomer.setEmail(email);
		updateCustomer.setActive(active);
		updateCustomer.setCreate_date(create_date);
		customerRepository.save(updateCustomer);
		return ResponseEntity.ok(updateCustomer);
	}

	@DeleteMapping("/Customer/Delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@RequestParam Integer id){
		Customer deleteCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: " + id));
		customerRepository.deleteById(id);
		return ResponseEntity.ok(deleteCustomer);
	}




//    |==========================|
//    |   	    FILM CRUD        |
//    |==========================|

	@GetMapping("/All_Film")
	public @ResponseBody
	Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}


	@GetMapping("/Film/{id}")
	public Film getFilm(@PathVariable int id) {
		return filmRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/Film/New")
	public @ResponseBody
	ResponseEntity<Film> addFilm(@RequestParam String title, String description, java.time.Year release_year, java.time.Duration rental_duration, double rental_rate, java.time.Duration length, double replacement_cost, int rating, String special_features){
		Film addFilm = new Film(title, description, Year.of(2020), Duration.ofDays(1), rental_rate, Duration.ofHours(1), replacement_cost, rating, special_features);
		filmRepository.save(addFilm);
		return ResponseEntity.ok(addFilm);
	}

	@PutMapping("/Film/Edit/{id}")
	public ResponseEntity<Film> updateFilm(@RequestParam int film_id, String title, String description, java.time.Year release_year, java.time.Duration rental_duration, double rental_rate, java.time.Duration length, double replacement_cost, int rating, String special_features){
		Film updateFilm = filmRepository.findById(film_id).orElseThrow(() -> new ResourceNotFoundException("Film does not exist with id: " + film_id));
		updateFilm.setFilm_id(film_id);
		updateFilm.setTitle(title);
		updateFilm.setDescription(description);
		updateFilm.setRelease_year(release_year);
		updateFilm.setRental_duration(rental_duration);
		updateFilm.setRental_rate(rental_rate);
		updateFilm.setLength(length);
		updateFilm.setReplacement_cost(replacement_cost);
		updateFilm.setRating(rating);
		updateFilm.setSpecial_features(special_features);
		filmRepository.save(updateFilm);
		return ResponseEntity.ok(updateFilm);
	}

	@DeleteMapping("/Film/Delete/{id}")
	public ResponseEntity<Film> deleteFilm(@RequestParam Integer id){
		Film deleteFilm = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film does not exist with id: " + id));
		filmRepository.deleteById(id);
		return ResponseEntity.ok(deleteFilm);
	}


}
