package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"/Users/lipingwei/IdeaProjects/ProjectShopDemoEJunkie/src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:Report/Html_report", "junit:Report/Junit_report/ShopDemo.xml", "json:Report/Json_report/ShopDemo.json"},
        dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {
}
