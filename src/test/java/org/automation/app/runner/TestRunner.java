package org.automation.app.runner;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"pretty","html:target/cucumber/report.html"},
                glue = {"classpath:steps"},
        tags= "@A002")
public class TestRunner {
}
