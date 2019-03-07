package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Form;

import java.util.List;

public class CloudCalculatorPage extends CloudPage {

    private final String URL = BASE_URL + "products/calculator/";
    private Form form = new Form();
    private String estimatedCostPerMonth;
    @FindBy(id = "idIframe")
    private WebElement iFrame;
   @FindBy(xpath = "//div[@title='Compute Engine']")
    private WebElement computeEngineButton;
    @FindBy(name = "quantity")
    private WebElement instancesLabel;
    @FindBy(name = "label")
    private WebElement whatAreTheseInstancesForLabel;
    @FindBy(id = "select_value_label_40")
    private WebElement operationSystemLabel;
    @FindBy(id = "select_value_label_41")
    private WebElement vmClassLabel;
    @FindBy(id = "select_value_label_42")
    private WebElement instanceTypeLabel;
    @FindBy(xpath = "//*[@role='checkbox'][@aria-label='Add GPUs']")
    private WebElement addGPUsBox;
    @FindBy(xpath = "//*[@id=\"select_338\"]")
    private WebElement numberOfGPUsLabel;
    @FindBy(xpath = "//*[@id=\"select_340\"]")
    private WebElement GPUsTypeLabel;
    @FindBy(xpath = "//*[@id=\"select_value_label_43\"]")
    private WebElement localSSDLabel;
    @FindBy(id = "select_value_label_44")
    private WebElement dataCenterLabel;
    @FindBy(id = "select_value_label_45")
    private WebElement commitedUsageLabel;
    @FindBy(id = "select_container_59")
    private WebElement selectOSAndSoftwareContainer;
    @FindBy(id = "select_container_63")
    private WebElement selectVMClassContainer;
    @FindBy(id = "select_container_94")
    private WebElement selectInstanceTypeContainer;
    @FindBy(id = "select_container_330")
    private WebElement selectNumberOfGPUsContainer;
    @FindBy(id = "select_container_332")
    private WebElement selectGPUTypeContainer;
    @FindBy(id = "select_container_96")
    private WebElement selectLocalSSDContainer;
    @FindBy(id = "select_container_98")
    private WebElement selectDataCenterLocationContainer;
    @FindBy(id = "select_container_103")
    private WebElement selectCommitedUsageContainer;

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudCalculatorPage open() {
        driver.get(URL);
        return this;
    }

    public void computeEngine() {
        wait.until(ExpectedConditions.elementToBeClickable(computeEngineButton)).click();
    }

    public void setInstance(String instance) {
        wait.until(ExpectedConditions.elementToBeClickable(instancesLabel)).sendKeys(instance);
    }

    public String getInstance() {

        return instancesLabel.getAttribute("value");
    }

    public void setOperationSystem(String operationSystemToBeSelected) {
        operationSystemLabel.click();
        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));
        String XPath = "//div[@id='select_container_59']/md-select-menu/md-content/md-option/div[@class='md-text']";
        selectOption(XPath, operationSystemToBeSelected);
    }

    public String getOperationSystem() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_40']")).getText();
    }

    public void setInstanceType(String instanceType) {
        wait.until(ExpectedConditions.visibilityOf(instanceTypeLabel)).click();
        String XPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.visibilityOf(selectInstanceTypeContainer));
        selectOption(XPath, instanceType);
    }

    public String getInstanceType() {
        return driver.findElement(By.xpath("//*[@id='select_93']")).getText();
    }

    public void clickAddGPUsBox() {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUsBox)).click();
    }

    public void setVmClass(String vmClass) {
        vmClassLabel.click();
        String XPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));
        selectOption(XPath, vmClass);

    }

    public String getVmClass() {
        return vmClassLabel.getText();
    }

    public void setNumberOfGPU(String numberOfGPU) {

        String XPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_327']"))).click();
        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGPUsContainer));
        selectOption(XPath, numberOfGPU);

    }

    private String getNumberOfGPU() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_327']")).getText();

    }

    public void setGPUType(String gpuType) {
        String XPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select_value_label_328']"))).click();
        wait.until(ExpectedConditions.visibilityOf(selectGPUTypeContainer));
        selectOption(XPath, gpuType);
    }

    public String getGPUType() {
        return driver.findElement(By.xpath("//*[@id='select_value_label_328']")).getText();
    }

    public void setSSD(String localSSD) {
        String XPath = "//div[@id='select_container_96']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOf(localSSDLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectLocalSSDContainer));
        selectOption(XPath, localSSD);
    }

    public String getSSD() {
        return driver.findElement(By.xpath("//*[@id='select_95']")).getText();
    }

    public void setLocation(String datacenterLocation) {
        String XPath = "//div[@id='select_container_98']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
        wait.until(ExpectedConditions.visibilityOf(dataCenterLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectDataCenterLocationContainer));
        selectOption(XPath, datacenterLocation);
    }

    public String getLocation() {
        return driver.findElement(By.xpath("//*[@id='select_97']")).getText();
    }

    public void setCommitUsage(String commitUsage) {
        String XPath = "//div[@id='select_container_103']/md-select-menu/md-content/md-option/div[@class='md-text']";
        wait.until(ExpectedConditions.elementToBeClickable(commitedUsageLabel)).click();
        wait.until(ExpectedConditions.visibilityOf(selectCommitedUsageContainer));
        selectOption(XPath, commitUsage);
    }

    public String getCommitUsage() {
        return driver.findElement(By.xpath("//*[@id='select_102']")).getText();
    }

    public void addToEstimate() {
        fillFormFromEnteredData();
        driver.findElement(By.xpath("//*[@type='button'][@aria-label='Add to Estimate']")).click();
    }

    public void pressToEmailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email_quote"))).click();
    }

    public void addEmailToEmailEstimateForm(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("input_380"))).sendKeys(email);
    }

    public void sendEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Send Email')]"))).click();
    }

    private void fillFormFromEnteredData() {
        form.setCommittedUsage(getCommitUsage());
        form.setDatacenterLocation(getLocation());
        form.setGpuType(getGPUType());
        form.setInstanceType(getInstanceType());
        form.setLocalSSD(getSSD());
        form.setNumberOfGPUs(getNumberOfGPU());
        form.setNumberOfInstances(getInstance());
        form.setOperationSystem(getOperationSystem());
        form.setVmClass(getVmClass());

    }

    public Form getFilledFormOfEnteredData() {
        return form;
    }

    public Form getEstimatedForm() {
        Form estimatedForm = new Form();
        driver.switchTo().frame("idIframe");
        estimatedForm.setCommittedUsage(getEstimatedCommitmentTerm());
        estimatedForm.setDatacenterLocation(getEstimatedRegion());
        estimatedForm.setInstanceType(getEstimatedIntanceType());
        estimatedForm.setLocalSSD(getEstimatedLocalSSD());
        estimatedForm.setVmClass(getEstimatedVMClass());
        estimatedCostPerMonth = driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")).getText();
        driver.switchTo().defaultContent();
        return estimatedForm;
    }

    private String getEstimatedVMClass() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]")).getText();
    }

    private String getEstimatedIntanceType() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[3]")).getText();
    }

    private String getEstimatedRegion() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[4]")).getText();
    }

    private String getEstimatedLocalSSD() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[5]")).getText();
    }

    private String getEstimatedCommitmentTerm() {
        return driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[6]")).getText();
    }

    public String getEstimatedCostPerMonth() {
        if(estimatedCostPerMonth == null || estimatedCostPerMonth.equals(""))
        {
            driver.switchTo().frame("idIframe");
            estimatedCostPerMonth=driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")).getText();
            driver.switchTo().defaultContent();
        }
        return estimatedCostPerMonth;

    }

    private void selectOption(String XPath, String optionToBeSelected) {

        List<WebElement> listOfSelectOptions = driver.findElements(By.xpath(XPath));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(XPath))));
        for (WebElement webElement : listOfSelectOptions) {
            if (webElement.getText().equals(optionToBeSelected)) {
                webElement.click();
            }
        }
    }

    public void switchToFrame(String idFrame) {
        driver.switchTo().frame(idFrame);
    }

    public void leaveFrame() {
        driver.switchTo().defaultContent();
    }
}
