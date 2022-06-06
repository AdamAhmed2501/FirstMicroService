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

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	public MyFirstMicroServiceApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

}
