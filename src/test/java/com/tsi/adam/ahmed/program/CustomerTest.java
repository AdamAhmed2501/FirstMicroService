package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.Customer;

import java.time.LocalDate;
import java.util.Date;

public class CustomerTest {

    Customer testCustomer = new Customer("firstname", "lastname", "email", true,
            LocalDate.of(1998,01,25));
    Customer testCustomer2 = new Customer();

    @Test
    public void testCustomer(){
        Assertions.assertEquals(0, testCustomer.getCustomer_id(), "Unable to get customer ID");
        Assertions.assertEquals("firstname", testCustomer.getFirst_name(), "Unable to get customer first name");
        Assertions.assertEquals("lastname", testCustomer.getLast_name(), "Unable to get customer last name");
        Assertions.assertEquals("email", testCustomer.getEmail(), "Unable to get customer email");
        Assertions.assertEquals(true, testCustomer.isActive(), "Unable to confirm if customer is active");
        Assertions.assertEquals(LocalDate.of(1998,01,25), testCustomer.getCreate_date(), "Unable to get date of customer creation");



        testCustomer2.setFirst_name("testfname");
        Assertions.assertEquals("testfname", testCustomer2.getFirst_name(), "Unable to set first name");

        testCustomer2.setLast_name("testlname");
        Assertions.assertEquals("testlname", testCustomer2.getLast_name(), "Unable to set last name");

        testCustomer2.setEmail("testemail");
        Assertions.assertEquals("testemail", testCustomer2.getEmail(), "Unable to set email");

        testCustomer2.setActive(false);
        Assertions.assertEquals(false, testCustomer2.isActive(), "Unable to set customer active");

        testCustomer2.setCreate_date(LocalDate.of(2022,06,12));
        Assertions.assertEquals( LocalDate.of(2022,06,12), testCustomer2.getCreate_date(), "Unable to set creation date");

    }

}
