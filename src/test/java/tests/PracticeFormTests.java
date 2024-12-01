package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegistrationFormPositiveTest() {
        Student student = new Student("Anne", "Green",
                "anne111@example.com", Gender.FEMALE, "0563728882",
                "07 Mar 2001", "Math", "Reading",
                "", "St. Chelsea 17", "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }

}
