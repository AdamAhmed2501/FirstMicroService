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

    @Test
    void testGetAddress(){
        Address testAddress = new Address("firstline", "secondline", "area", "postal", 20009, "London");
        testAddress.setAddress_id(1);
        when(addressRepository.findById(1)).thenReturn(Optional.of(testAddress));
        Address Actual = myFirstMicroServiceApplication.getAddress(testAddress.getAddress_id());
        Address Expected = testAddress;
        Assertions.assertEquals(Expected,Actual,"Could not find address with ID: ");
    }

    @Test
    public void testAddAddress() {

        Address savedAddress = new Address("address", "address2", "district", "postal_code", 736, "location");
        Address Expected = myFirstMicroServiceApplication.addAddress(savedAddress.getAddress(), savedAddress.getAddress2(), savedAddress.getDistrict(), savedAddress.getPostal_code(), savedAddress.getPhone(), savedAddress.getLocation()).getBody();
        ArgumentCaptor<Address> addressArgumentCaptor = ArgumentCaptor.forClass(Address.class);
        verify(addressRepository).save(addressArgumentCaptor.capture());
        Address Actual = addressArgumentCaptor.getValue();
        Assertions.assertEquals(Expected, Actual, "Address is not saved into the database");

    }

    @Test
    void testUpdateAddress(){
        Address testAddress = new Address("firstline", "secondline", "area", "postal", 20009, "London");
        testAddress.setAddress_id(1);
        Address testUpdateAddress = new Address("updatedfirstline", "updatedsecondline", "updatedarea", "updatedpostal", 20009, "London");
        testUpdateAddress.setAddress_id(1);
        when(addressRepository.findById(testAddress.getAddress_id())).thenReturn(Optional.of(testUpdateAddress));

        Address Actual = myFirstMicroServiceApplication.updateAddress(testUpdateAddress.getAddress_id(), testUpdateAddress.getAddress(), testUpdateAddress.getAddress2(), testUpdateAddress.getDistrict(), testUpdateAddress.getPostal_code(), testUpdateAddress.getPhone(), testUpdateAddress.getLocation()).getBody();

        ArgumentCaptor<Address> addressArgumentCaptor = ArgumentCaptor.forClass(Address.class);
        verify(addressRepository).save(addressArgumentCaptor.capture());
        Address Expected = addressArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Address was not updated.");
    }

    @Test
    void testDeleteAddress(){
        Address testAddress = new Address("firstline", "secondline", "area", "postal", 20009, "London");
        testAddress.setAddress_id(1);
        Address testAddressDelete = new Address("firstline", "secondline", "area", "postal", 20009, "London");
        testAddressDelete.setAddress_id(1);
        when(addressRepository.findById(testAddressDelete.getAddress_id())).thenReturn(Optional.of(testAddressDelete));
        doNothing().when(addressRepository).deleteById(1);
        Address Actual = myFirstMicroServiceApplication.deleteAddress(testAddressDelete.getAddress_id()).getBody();
        addressRepository.deleteById(testAddressDelete.getAddress_id());
        Address Expected = testAddressDelete;
        Assertions.assertEquals(Expected,Actual,"Address was not deleted.");
    }

//    |==========================|
//    |   CATEGORY CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCategory(){
        myFirstMicroServiceApplication.getAllCategory();
        verify(categoryRepository).findAll();

    }

    @Test
    void testGetCategory(){
        Category testCategory = new Category("testcategory");
        testCategory.setCategory_id(1);
        when(categoryRepository.findById(1)).thenReturn(Optional.of(testCategory));
        Category Actual = myFirstMicroServiceApplication.getCategory(testCategory.getCategory_id());
        Category Expected = testCategory;
        Assertions.assertEquals(Expected,Actual,"Could not find category with ID: ");
    }
//    @Test
//    public void testAddCategory(){
//
//        Category savedCategory = new Category("testcategory");
//        Category Expected = myFirstMicroServiceApplication.addCategory(savedCategory.get_name()).getBody();
//        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
//        verify(categoryRepository).save(categoryArgumentCaptor.capture());
//        Category Actual = categoryArgumentCaptor.getValue();
//        Assertions.assertEquals(Expected,Actual,"Category is not saved into the database");
//    }

    @Test
    void testUpdateCategory(){
        Category testCategory = new Category("testcategory");
        testCategory.setCategory_id(1);
        Category testUpdateCategory = new Category("testcategoryUpdated");
        testUpdateCategory.setCategory_id(1);
        when(categoryRepository.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testUpdateCategory));

        Category Actual = myFirstMicroServiceApplication.updateCategory(testUpdateCategory.getCategory_id(), testUpdateCategory.get_name()).getBody();

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Category Expected = categoryArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Category was not updated.");
    }
    @Test
    void testDeleteCategory(){
        Category testCategory = new Category("testcategory");
        testCategory.setCategory_id(1);
        Category testCategoryDelete = new Category("testcategorydeleted");
        testCategoryDelete.setCategory_id(1);
        when(categoryRepository.findById(testCategoryDelete.getCategory_id())).thenReturn(Optional.of(testCategoryDelete));
        doNothing().when(categoryRepository).deleteById(1);
        Category Actual = myFirstMicroServiceApplication.deleteCategory(testCategoryDelete.getCategory_id()).getBody();
        categoryRepository.deleteById(testCategoryDelete.getCategory_id());
        Category Expected = testCategoryDelete;
        Assertions.assertEquals(Expected,Actual,"Category was not deleted.");
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