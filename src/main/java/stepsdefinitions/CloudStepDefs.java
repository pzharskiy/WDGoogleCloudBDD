package stepsdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CloudCalculatorPage;
import pages.CloudStartPage;
import utils.Form;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CloudStepDefs {

    WebDriver driver = DriverSingleton.getDriver();
    //Возможно, стоит сделать CloudPage page и от него наслежоваться
    Form inputForm;
    Form estimatedForm;

    @Given("I opened Google Cloud Platform Pricing Calculator")
    public void iOpenedGoogleCloudPlatformPricingCalculator() {
        CloudStartPage page = new CloudStartPage(driver);
        page.open().
                exploreAllProducts().
                seePricing().
                calculate();
    }

    @When("^I fill the form with parameters:$")
    public void iFillTheFormWithParameters(DataTable dataTable) {

        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        page.switchToFrame("idIframe");
        page.computeEngine();

        for (Map<String, String> labelValue : dataTable.asMaps(String.class, String.class)
        ) {
            page.setInstance(labelValue.get("Number of instance"));
            page.setOperationSystem(labelValue.get("Operation System"));
            page.setVmClass(labelValue.get("VM Class"));
            page.setInstanceType(labelValue.get("Instance type"));
            page.clickAddGPUsBox();
            page.setNumberOfGPU(labelValue.get("Number of GPUs"));
            page.setGPUType(labelValue.get("GPU type"));
            page.setSSD(labelValue.get("SSD"));
            page.setLocation(labelValue.get("Datacenter location"));
            page.setCommitUsage(labelValue.get("Commited usage"));
        }
        page.leaveFrame();

    }

    @And("^I added this form to estimate$")
    public void iAddedThisFormToEstimate() {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        page.switchToFrame("idIframe");
        page.addToEstimate();
        inputForm = page.getFilledFormOfEnteredData();
        page.leaveFrame();
    }

    @Then("^Input and estimated data match$")
    public void inputAndEstimatedDataMatch() {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        estimatedForm = page.getEstimatedForm();
        //Избежать отдельных ассертов для полей
        assertTrue(estimatedForm.getVmClass().toLowerCase().contains(inputForm.getVmClass().toLowerCase()));
        assertTrue(estimatedForm.getInstanceType().toLowerCase().contains(inputForm.getInstanceType().toLowerCase().split(" ")[0]));
        assertTrue(estimatedForm.getLocalSSD().toLowerCase().contains(inputForm.getLocalSSD().toLowerCase()));
        assertTrue(estimatedForm.getDatacenterLocation().toLowerCase().contains(inputForm.getDatacenterLocation().toLowerCase().split(" ")[0]));
        assertTrue(estimatedForm.getCommittedUsage().toLowerCase().contains(inputForm.getCommittedUsage().toLowerCase()));
    }

    @And("^Total cost is USD ([^\"]*)$")
    public void totalCostIsUSD(String cost) {
        CloudCalculatorPage page = new CloudCalculatorPage(driver);
        //нужно распарсить estimated. + переделать функцию getEstimatedCostPerMonth
        assertTrue(page.getEstimatedCostPerMonth().contains(cost));
    }
}
