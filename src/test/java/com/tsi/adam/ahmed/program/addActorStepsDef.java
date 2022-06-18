//package com.tsi.adam.ahmed.program;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class addActorStepsDef {
//
//    private MyFirstMicroServiceApplication myFirstMicroServiceApplication;
//    @Mock
//    private ActorRepository actorRepository;
//    @Mock
//    private AddressRepository addressRepository;
//    @Mock
//    private CategoryRepository categoryRepository;
//    @Mock
//    private CityRepository cityRepository;
//    @Mock
//    private CountryRepository countryRepository;
//    @Mock
//    private CustomerRepository customerRepository;
//    @Mock
//    private FilmRepository filmRepository;
//
//    @BeforeEach
//    void setup(){
//        actorRepository = mock(ActorRepository.class);
//        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository,addressRepository,
//                categoryRepository,cityRepository,countryRepository,customerRepository,filmRepository);
//    }
//    int id;
//    Actor testActor;
//    Actor Expected;
//    Actor Actual;
//    @Given("I have the actor information")
//    public void i_have_the_actors_information() {
//        id = 1;
//        testActor = new Actor("testFName", "testLName");
//        testActor.setActor_id(id);
//    }
//    @When("I input the data into the database")
//    public void i_input_the_data_into_the_database(){
//
//        setup();
//        Actual = myFirstMicroServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
//    }
//
//    @Then("I get the success return string")
//    public void i_get_the_success_return_string() {
//
//      ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//      verify(actorRepository).save(actorArgumentCaptor.capture());
//      Expected = actorArgumentCaptor.getValue();
//      Assertions.assertEquals(Expected,Actual,"Actor not added into the database");
//      throw new io.cucumber.java.PendingException();
//    }
//}





