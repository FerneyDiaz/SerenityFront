package com.avaldigitallabs.facilpass;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        tags = "@test",
        //glue = "com.avaldigitallabs.facilpass.stepdefinitions",
        features = "src/test/resources/features"
)
public class CucumberTestSuite {
}
