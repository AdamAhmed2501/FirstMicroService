package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.Actor;

public class ActorTest {
    Actor testActor = new Actor("First_name", "Last_name");
    Actor testActor2 = new Actor();

    @Test
    public void testActor(){
        Assertions.assertEquals(0, testActor.getActor_id(), "Incorrect ID");
        Assertions.assertEquals("First_name", testActor.getFirst_name(), "Incorrect first name");
        Assertions.assertEquals("Last_name", testActor.getLast_name(), "Incorrect last name");

        testActor2.setFirst_name("testFname");
        Assertions.assertEquals("testFname", testActor2.getFirst_name(), "Incorrect first name");
        testActor2.setLast_name("testLname");
        Assertions.assertEquals("testLname", testActor2.getLast_name(), "Incorrect last name");

    }
}
