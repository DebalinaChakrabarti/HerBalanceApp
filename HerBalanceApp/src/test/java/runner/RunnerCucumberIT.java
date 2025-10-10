package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Constants;


@io.cucumber.testng.CucumberOptions(
		features= {"src/test/resources/features/"
		},
		glue= {"stepDefinitions","hooks"},

		plugin= {"pretty","html:target/cucumber-reports/reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"},
				publish=true,
				tags=""
)

public class RunnerCucumberIT extends AbstractTestNGCucumberTests{

//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//	return super.scenarios();  
//	}
	
//	@BeforeTest
//	@Parameters({"browser"})
//	public void defineBrowser(String browser) throws Throwable {
//
//		System.out.println("browser is" +browser);
//		Constants.browserForCrossbrowserTest = browser;
//	}
	
	
	
}
