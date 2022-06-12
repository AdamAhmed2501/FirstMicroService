package com.tsi.adam.ahmed.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MyFirstMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepository;
	private AddressRepository addressRepository;
	private CategoryRepository categoryRepository;
	private CityRepository cityRepository;
	private CountryRepository countryRepository;
	private CustomerRepository customerRepository;
	private FilmRepository filmRepository;

	public MyFirstMicroServiceApplication(ActorRepository actorRepository, AddressRepository addressRepository,
										  CategoryRepository categoryRepository, CityRepository cityRepository,
										  CountryRepository countryRepository, CustomerRepository customerRepository,
										  FilmRepository filmRepository) {
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	public MyFirstMicroServiceApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}
	public MyFirstMicroServiceApplication(AddressRepository addressRepository){this.addressRepository = addressRepository;}
	public MyFirstMicroServiceApplication(CategoryRepository categoryRepository){this.categoryRepository = categoryRepository;}
	public MyFirstMicroServiceApplication(CityRepository cityRepository){this.cityRepository = cityRepository;}
	public MyFirstMicroServiceApplication(CountryRepository countryRepository){this.countryRepository = countryRepository;}
	public MyFirstMicroServiceApplication(CustomerRepository customerRepository){this.customerRepository = customerRepository;}
	public MyFirstMicroServiceApplication(FilmRepository filmRepository){this.filmRepository = filmRepository;}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
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
