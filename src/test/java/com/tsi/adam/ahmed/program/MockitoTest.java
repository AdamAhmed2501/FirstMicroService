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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Duration;
import java.time.Year;
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

    @Test
    public void testAddCategory(){

        Category savedCategory = new Category("testcategory");
        Category Expected = myFirstMicroServiceApplication.addCategory(savedCategory.getCategory_id(), savedCategory.get_name()).getBody();
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Category Actual = categoryArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category is not saved into the database");
    }

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


    @Test
    void testGetCity(){
        City testCity = new City("testcity");
        testCity.setCity_id(1);
        when(cityRepository.findById(1)).thenReturn(Optional.of(testCity));
        City Actual = myFirstMicroServiceApplication.getCity(testCity.getCity_id());
        City Expected = testCity;
        Assertions.assertEquals(Expected,Actual,"Could not find city with ID: ");
    }

    @Test
    public void testAddCity(){

        City savedCity = new City("testcity");
        City Expected = myFirstMicroServiceApplication.addCity(savedCity.getCity_id(), savedCity.getCity(), savedCity.getCountry_id()).getBody();
        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(cityArgumentCaptor.capture());
        City Actual = cityArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"City is not saved into the database");
    }

    @Test
    void testUpdateCity(){
        City testCity = new City("testcity");
        testCity.setCity_id(1);
        City testUpdateCity = new City("testcityUpdated");
        testUpdateCity.setCity_id(1);
        when(cityRepository.findById(testCity.getCity_id())).thenReturn(Optional.of(testUpdateCity));

        City Actual = myFirstMicroServiceApplication.updateCity(testUpdateCity.getCity_id(), testUpdateCity.getCity()).getBody();

        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(cityArgumentCaptor.capture());
        City Expected = cityArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"City was not updated.");
    }
    @Test
    void testDeleteCity(){
        City testCity = new City("testcity");
        testCity.setCity_id(1);
        City testCityDelete = new City("testcitydeleted");
        testCityDelete.setCity_id(1);
        when(cityRepository.findById(testCityDelete.getCity_id())).thenReturn(Optional.of(testCityDelete));
        doNothing().when(cityRepository).deleteById(1);
        City Actual = myFirstMicroServiceApplication.deleteCity(testCityDelete.getCity_id()).getBody();
        cityRepository.deleteById(testCityDelete.getCity_id());
        City Expected = testCityDelete;
        Assertions.assertEquals(Expected,Actual,"City was not deleted.");
    }


//    |==========================|
//    |    COUNTRY CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCountry(){
        myFirstMicroServiceApplication.getAllCustomer();
        verify(customerRepository).findAll();

    }


    @Test
    void testGetCountry(){
        Country testCountry = new Country("testcountry");
        testCountry.setCountry_id(1);
        when(countryRepository.findById(1)).thenReturn(Optional.of(testCountry));
        Country Actual = myFirstMicroServiceApplication.getCountry(testCountry.getCountry_id());
        Country Expected = testCountry;
        Assertions.assertEquals(Expected,Actual,"Could not find country with ID: ");
    }

    @Test
    public void testAddCountry(){

        Country savedCountry = new Country("testcountry");
        Country Expected = myFirstMicroServiceApplication.addCountry(savedCountry.getCountry_id(), savedCountry.getCountry()).getBody();
        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(countryArgumentCaptor.capture());
        Country Actual = countryArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Country is not saved into the database");
    }

    @Test
    void testUpdateCountry(){
        Country testCountry = new Country("testcountry");
        testCountry.setCountry_id(1);
        Country testUpdateCountry = new Country("testcountryUpdated");
        testUpdateCountry.setCountry_id(1);
        when(countryRepository.findById(testCountry.getCountry_id())).thenReturn(Optional.of(testUpdateCountry));

        Country Actual = myFirstMicroServiceApplication.updateCountry(testUpdateCountry.getCountry_id(), testUpdateCountry.getCountry()).getBody();

        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(countryArgumentCaptor.capture());
        Country Expected = countryArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Country was not updated.");
    }
    @Test
    void testDeleteCountry(){
        Country testCountry = new Country("testcountry");
        testCountry.setCountry_id(1);
        Country testCountryDelete = new Country("testcountrydeleted");
        testCountryDelete.setCountry_id(1);
        when(countryRepository.findById(testCountryDelete.getCountry_id())).thenReturn(Optional.of(testCountryDelete));
        doNothing().when(countryRepository).deleteById(1);
        Country Actual = myFirstMicroServiceApplication.deleteCountry(testCountryDelete.getCountry_id()).getBody();
        countryRepository.deleteById(testCountryDelete.getCountry_id());
        Country Expected = testCountryDelete;
        Assertions.assertEquals(Expected,Actual,"Country was not deleted.");
    }


//    |==========================|
//    |   CUSTOMER CRUD TESTS    |
//    |==========================|
    @Test
    public void getAllCustomer(){
        myFirstMicroServiceApplication.getAllCustomer();
        verify(customerRepository).findAll();

    }

    @Test
    void testGetCustomer(){
        Customer testCustomer = new Customer("testfirstname", "testlastname", "email", true, LocalDate.of(2022,06,12));
        testCustomer.setCustomer_id(1);
        when(customerRepository.findById(1)).thenReturn(Optional.of(testCustomer));
        Customer Actual = myFirstMicroServiceApplication.getCustomer(testCustomer.getCustomer_id());
        Customer Expected = testCustomer;
        Assertions.assertEquals(Expected,Actual,"Could not find customer with ID: ");
    }

    @Test
    public void testAddCustomer(){

        Customer savedCustomer = new Customer("testfirstname", "testlastname", "email", true, LocalDate.of(2022,06,12));
        Customer Expected = myFirstMicroServiceApplication.addCustomer(savedCustomer.getFirst_name(), savedCustomer.getLast_name(), savedCustomer.getEmail(), savedCustomer.isActive(), savedCustomer.getCreate_date()).getBody();
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer Actual = customerArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Customer is not saved into the database");
    }

    @Test
    void testUpdateCustomer(){
        Customer testCustomer = new Customer("testfirstname", "testlastname", "email", true, LocalDate.of(2022,06,12));
        testCustomer.setCustomer_id(1);
        Customer testUpdateCustomer = new Customer("testfirstnameupdated", "testlastnameupdated", "emailupdated", true, LocalDate.of(2022,06,12));
        testUpdateCustomer.setCustomer_id(1);
        when(customerRepository.findById(testCustomer.getCustomer_id())).thenReturn(Optional.of(testUpdateCustomer));

        Customer Actual = myFirstMicroServiceApplication.updateCustomer(testUpdateCustomer.getCustomer_id(), testUpdateCustomer.getFirst_name(), testUpdateCustomer.getLast_name(), testUpdateCustomer.getEmail(), testUpdateCustomer.isActive(), testUpdateCustomer.getCreate_date()).getBody();

        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer Expected = customerArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Customer was not updated.");
    }


    @Test
    void testDeleteCustomer(){
        Customer testCustomer = new Customer("testfirstname", "testlastname", "email", true, LocalDate.of(2022,06,12));
        testCustomer.setCustomer_id(1);
        Customer testCustomerDelete = new Customer("testfirstnamedeleted", "testlastnamedeleted", "emaildeleted", true, LocalDate.of(2022,06,12));
        testCustomerDelete.setCustomer_id(1);
        when(customerRepository.findById(testCustomerDelete.getCustomer_id())).thenReturn(Optional.of(testCustomerDelete));
        doNothing().when(customerRepository).deleteById(1);
        Customer Actual = myFirstMicroServiceApplication.deleteCustomer(testCustomerDelete.getCustomer_id()).getBody();
        customerRepository.deleteById(testCustomerDelete.getCustomer_id());
        Customer Expected = testCustomerDelete;
        Assertions.assertEquals(Expected,Actual,"Customer was not deleted.");
    }



//    |==========================|
//    |     FILM CRUD TESTS      |
//    |==========================|
    @Test
    public void getAllFilm(){
        myFirstMicroServiceApplication.getAllFilm();
        verify(filmRepository).findAll();

    }

    @Test
    void testGetFilm(){
        Film testFilm = new Film("testtitle", "testdescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_features");
        testFilm.setFilm_id(1);
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
        Film Actual = myFirstMicroServiceApplication.getFilm(testFilm.getFilm_id());
        Film Expected = testFilm;
        Assertions.assertEquals(Expected,Actual,"Could not find film with ID: ");
    }

    @Test
    public void testAddFilm(){

        Film savedFilm = new Film("testtitle", "testdescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_features");
        Film Expected = myFirstMicroServiceApplication.addFilm(savedFilm.getTitle(), savedFilm.getDescription(), savedFilm.getRelease_year(), savedFilm.getRental_duration(), savedFilm.getRental_rate(), savedFilm.getLength(), savedFilm.getReplacement_cost(), savedFilm.getRating(), savedFilm.getSpecial_features()).getBody();
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        Film Actual = filmArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Film is not saved into the database");
    }

    @Test
    void testUpdateFilm(){
        Film testFilm = new Film("testtitle", "testdescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_features");
        testFilm.setFilm_id(1);
        Film testUpdateFilm = new Film("testUpdatetitle", "testUpdatedescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_Update_features");
        testUpdateFilm.setFilm_id(1);
        when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testUpdateFilm));

        Film Actual = myFirstMicroServiceApplication.updateFilm(testUpdateFilm.getFilm_id(), testUpdateFilm.getTitle(), testUpdateFilm.getDescription(), testUpdateFilm.getRelease_year(), testUpdateFilm.getRental_duration(), testUpdateFilm.getRental_rate(), testUpdateFilm.getLength(), testUpdateFilm.getReplacement_cost(), testUpdateFilm.getRating(), testUpdateFilm.getSpecial_features()).getBody();

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        Film Expected = filmArgumentCaptor.getValue();

        Assertions.assertEquals(Expected,Actual,"Film was not updated.");
    }


    @Test
    void testDeleteFilm(){
        Film testFilm = new Film("testtitle", "testdescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_features");
        testFilm.setFilm_id(1);
        Film testFilmDelete = new Film("testDeletetitle", "testDeletedescription", Year.of(2020), Duration.ofDays(1), 2,Duration.ofHours(0) , 2, 2, "Special_Delete_features");
        testFilmDelete.setFilm_id(1);
        when(filmRepository.findById(testFilmDelete.getFilm_id())).thenReturn(Optional.of(testFilmDelete));
        doNothing().when(filmRepository).deleteById(1);
        Film Actual = myFirstMicroServiceApplication.deleteFilm(testFilmDelete.getFilm_id()).getBody();
        filmRepository.deleteById(testFilmDelete.getFilm_id());
        Film Expected = testFilmDelete;
        Assertions.assertEquals(Expected,Actual,"Film was not deleted.");
    }


}