package com.brainacad;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
        plugin = {"pretty",
                "json:target/cucumber-report/report.json"},
        glue = "com.brainacad.def",
        features = "src/test/resources"
        //tags = "@myTag"
)

public class RunnerTest {
}
