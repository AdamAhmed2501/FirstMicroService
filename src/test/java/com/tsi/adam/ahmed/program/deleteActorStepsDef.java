package com.tsi.adam.ahmed.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
public class deleteActorStepsDef {

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
    Actor Output;
    Actor Input;


    @Given("I have the id number for the actor id like to delete")
    public void i_have_the_id_number_for_the_actor_id_like_to_delete() {
        id = 1;
        testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(id);
    }
    @When("I input the ID")
    public void i_input_the_id() {
        setup();
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Input = myFirstMicroServiceApplication.deleteActor(testActor.getActor_id()).getBody();
    }
    @Then("I get conf of delete")
    public void i_get_conf_of_delete() {
        Output = testActor;
        Assertions.assertEquals(Input, Output,"Actor not added into the database");
    }
}
