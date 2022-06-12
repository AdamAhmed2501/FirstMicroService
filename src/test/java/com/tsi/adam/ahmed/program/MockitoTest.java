package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.tsi.adam.ahmed.program.Actor;
import com.tsi.adam.ahmed.program.ActorRepository;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

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
        // actorRepository = mock(ActorRepository.class);
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
