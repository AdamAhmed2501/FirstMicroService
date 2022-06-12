package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.Category;

public class CategoryTest {
    Category testCategory = new Category("name");
    Category testCategory2 = new Category();

    @Test
    public void testCategory(){
        Assertions.assertEquals(0, testCategory.getCategory_id(), "Incorrect ID");
        Assertions.assertEquals("name", testCategory.get_name(), "Incorrect name");

        testCategory2.set_name("test_name");
        Assertions.assertEquals("test_name", testCategory2.get_name(), "Incorrect name");
    }
}
