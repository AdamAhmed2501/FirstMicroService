package com.tsi.adam.ahmed.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addActorStepsDef {

    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void setup() {
        actorRepository = mock(ActorRepository.class);
        addressRepository = mock(AddressRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        cityRepository = mock(CityRepository.class);
        countryRepository = mock(CountryRepository.class);
        customerRepository = mock(CustomerRepository.class);
        filmRepository = mock(FilmRepository.class);

        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository, addressRepository,
                categoryRepository, cityRepository, countryRepository, customerRepository, filmRepository);
    }

    int id;
    Actor testActor;
    Actor Input;
    Actor Output;


    @Given("I have the actors first name and I have the actors last name")
    public void i_have_the_actors_first_name_and_i_have_the_actors_last_name() {
        id = 1;
        testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(id);
    }

    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        setup();
        Input = myFirstMicroServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
    }

    @Then("Actor added to the database")
    public void actor_added_to_the_database() {
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Output = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Input,Output,"Actor not added into the database");
    }

    @Given("I have the actors first name but I don't have the actors last name")
    public void i_have_the_actors_first_name_but_i_don_t_have_the_actors_last_name() {
        id = 1;
        testActor = new Actor("testFName", null);
        testActor.setActor_id(id);
    }

    @Then("Actor not added to the database")
    public void actor_not_added_to_the_database() {
        Assertions.assertNotEquals(Input, "Both a first name and last name are required", "Actor added to db");
    }

    @Given("I don't have the actors first name but I have the actors last name")
    public void i_don_t_have_the_actors_first_name_but_i_have_the_actors_last_name() {
        id = 1;
        testActor = new Actor(null, "testLName");
        testActor.setActor_id(id);
    }
}







