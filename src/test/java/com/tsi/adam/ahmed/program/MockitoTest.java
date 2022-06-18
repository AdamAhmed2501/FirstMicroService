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

    @Test
    public void getAllActors(){
        myFirstMicroServiceApplication.getAllActors();
        verify(actorRepository).findAll();

    }

    @Test
    public void getAllAddress(){
        myFirstMicroServiceApplication.getAllAddress();
        verify(addressRepository).findAll();

    }

    @Test
    public void getAllCategory(){
        myFirstMicroServiceApplication.getAllCategory();
        verify(categoryRepository).findAll();

    }

    @Test
    public void getAllCity(){
        myFirstMicroServiceApplication.getAllCity();
        verify(cityRepository).findAll();

    }

    @Test
    public void getAllCountry(){
        myFirstMicroServiceApplication.getAllCountry();
        verify(countryRepository).findAll();

    }

    @Test
    public void getAllCustomer(){
        myFirstMicroServiceApplication.getAllCustomer();
        verify(customerRepository).findAll();

    }

    @Test
    public void getAllFilm(){
        myFirstMicroServiceApplication.getAllFilm();
        verify(filmRepository).findAll();

    }

}
