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




//    |==========================|
//    |   	CATEGORY CRUD        |
//    |==========================|
	@GetMapping("/All_Category")
	public @ResponseBody
	Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}




//    |==========================|
//    |   	   CITY CRUD         |
//    |==========================|
	@GetMapping("/All_City")
	public @ResponseBody
	Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}




//    |==========================|
//    |   	  COUNTRY CRUD       |
//    |==========================|
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
