package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement inputName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement inputNumber;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement inputSubjects;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement chkHobbiesSports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement chkHobbiesReading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement chkHobbiesMusic;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement inputAddress;

    @FindBy(xpath = "//div[text()='Select State']")
    WebElement btnState;

    @FindBy(xpath = "//div[text()='Select City']")
    WebElement btnCity;

    public void typePracticeForm(Student student) {
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputNumber.sendKeys(student.getMobileNumber());
        inputAddress.sendKeys(student.getAddress());
    }

    public void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

}
