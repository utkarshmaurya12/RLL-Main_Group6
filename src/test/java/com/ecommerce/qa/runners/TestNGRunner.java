package com.ecommerce.qa.runners;
import org.testng.annotations.Listeners;

import com.ecommerce.qa.utilities.TestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(TestListener.class)
@CucumberOptions(features = "C:\\Users\\karth\\eclipse-workspace\\RLLFinal6\\src\\test\\java\\com\\ecommerce\\qa\\features",
                    glue = {"com.ecommerce.qa.steps"},
					dryRun = false,
					plugin = {"html:target/Cucumberreport.html",
							 "pretty",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							 "timeline:test-output-thread/"
							 }
					)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
