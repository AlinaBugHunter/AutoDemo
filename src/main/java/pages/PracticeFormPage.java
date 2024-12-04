package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

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

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement inputDateOfBirth;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement inputSubjects;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement inputAddress;

    @FindBy(xpath = "//div[text()='Select State']")
    WebElement btnState;

    @FindBy(xpath = "//div[text()='Select City']")
    WebElement btnCity;

    public void typePracticeForm(Student student) {
        hideBanner();
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputNumber.sendKeys(student.getMobileNumber());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        inputAddress.sendKeys(student.getAddress());
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeDateOfBirth(String dateOfBirth) {
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win")) {
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } else if (operationSystem.startsWith("Mac")) {
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String[] arrString = subjects.split(",");
        for (String str : arrString) {
            inputSubjects.sendKeys(str);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies hobbie : hobbies) {
            switch (hobbie) {
                case MUSIC:
                    driver.findElement(By.xpath(hobbie.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(hobbie.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(hobbie.getLocator())).click();
                    break;
            }
        }
    }

}
