package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegistrationFormPositiveTest() {

        List<Hobbies> hobbiesList = new ArrayList<>();
        hobbiesList.add(Hobbies.READING);
        hobbiesList.add(Hobbies.MUSIC);

        Student student = new Student("Anne", "Green",
                "anne111@example.com", Gender.FEMALE, "0563728882",
                "07 Mar 2001", "Maths,Physics,Chemistry", hobbiesList,
                "", "St. Chelsea 17", "NCR", "Delhi");

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

    }

}
