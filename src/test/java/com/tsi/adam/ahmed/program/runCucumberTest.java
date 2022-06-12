package com.tsi.adam.ahmed.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin ={"Pretty"},
    features = "src/test/resources/Cucumber",
        glue = "com.tsi.adam.ahmed.program")

public class runCucumberTest {
}
