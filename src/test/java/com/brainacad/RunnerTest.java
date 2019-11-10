package com.brainacad;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty",
                "json:target/cucumber-report/report.json"},
        features = "src/test/resources",
        glue = "src.test.java.com.brainacad.def"
        //tags = "@myTag"
)

public class RunnerTest {
}
