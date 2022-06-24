package com.tsi.adam.ahmed.program;
import com.tsi.adam.ahmed.program.MyFirstMicroServiceApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
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
    void setUp(){
        myFirstMicroServiceApplication = new MyFirstMicroServiceApplication(actorRepository,addressRepository,
                categoryRepository,cityRepository,countryRepository,customerRepository,filmRepository);

    }

//    |==========================|
//    |     ACTOR CRUD TESTS     |
//    |==========================|
    @Test
    public void testGetAllActors(){
        myFirstMicroServiceApplication.getAllActors();
        verify(actorRepository).findAll();

    }
    @Test
    void testGetActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = myFirstMicroServiceApplication.getActor(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Could not find actor with ID: ");
    }
    @Test
    public void testAddActor(){

        Actor savedActor = new Actor("testfirstname","testlastname");
        Actor Expected = myFirstMicroServiceApplication.addActor(savedActor.getFirst_name(),savedActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Actual = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor is not saved into the database");
    }
    @Test
    void testUpdateActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Actor testUpdateActor = new Actor("testFNameUpdated" , "testLNameUpdated");
        testUpdateActor.setActor_id(1);
        when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testUpdateActor));

        Actor Actual = myFirstMicroServiceApplication.updateActor(testUpdateActor.getActor_id(), testUpdateActor).getBody();

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
    }
    @Test
    void testDeleteActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Actor testActorDelete = new Actor("testFName", "testLName");
        testActorDelete.setActor_id(1);
        when(actorRepository.findById(testActorDelete.getActor_id())).thenReturn(Optional.of(testActorDelete));
        doNothing().when(actorRepository).deleteById(1);
        Actor Actual = myFirstMicroServiceApplication.deleteActor(testActorDelete.getActor_id()).getBody();
        actorRepository.deleteById(testActorDelete.getActor_id());
        Actor Expected = testActorDelete;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }




//    |==========================|
//    |   ADDRESS CRUD TESTS     |
//    |==========================|
    @Test
    public void getAllAddress(){
        myFirstMicroServiceApplication.getAllAddress();
        verify(addressRepository).findAll();

    }




//    |==========================|
//    |   CATEGORY CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCategory(){
        myFirstMicroServiceApplication.getAllCategory();
        verify(categoryRepository).findAll();

    }




//    |==========================|
//    |     CITY CRUD TESTS      |
//    |==========================|
    @Test
    public void getAllCity(){
        myFirstMicroServiceApplication.getAllCity();
        verify(cityRepository).findAll();

    }




//    |==========================|
//    |    COUNTRY CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCountry(){
        myFirstMicroServiceApplication.getAllCountry();
        verify(countryRepository).findAll();

    }




//    |==========================|
//    |   CUSTOMER CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCustomer(){
        myFirstMicroServiceApplication.getAllCustomer();
        verify(customerRepository).findAll();

    }




//    |==========================|
//    |     FILM CRUD TESTS      |
//    |==========================|
    @Test
    public void getAllFilm(){
        myFirstMicroServiceApplication.getAllFilm();
        verify(filmRepository).findAll();

    }




}