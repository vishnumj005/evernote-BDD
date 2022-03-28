package runTest;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import baseClasses.Init;
import bsh.ParseException;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
        "src/test/features"
    },
    glue = {
        "classpath:"
    })

public class RunTest extends Init {

    @BeforeClass
    public static void beforeClass() throws ParseException, IOException, InterruptedException {
        initPropFile();
    }

}