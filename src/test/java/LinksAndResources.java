import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class LinksAndResources {

    private String baseUrl = "http://www.sberbank.ru/ru/person";
    private String insuranceLink = "//span[text()='Страхование']";
    private String insuranceAndBuyLink = "//a[@class='lg-menu__sub-link' and text()='Страхование путешественников']";
    private String buttonApplyOnline = "//b[text()='Оформить онлайн']/parent::a";
    private String titleAboutInsurance = "//div[@class='kit-col_xs_12 kit-col_md_0 kit-col_lg_6 kit-col_xs-bottom_20 kit-col_lg-bottom_10 kit-col_xs-top_20 kit-col_lg-top_40']//h2";
    private String minInsurance = "//h3[text()='Минимальная']/parent::div";
    private String buttonArrange = "//button[text()='Оформить']";

    private String inputSurname = "//input[@id='surname_vzr_ins_0']";
    private String inputName = "//input[@id='name_vzr_ins_0']";
    private String inputBirthDate = "//input[@id='birthDate_vzr_ins_0']";
    private String inputFirstName = "//input[@id='person_firstName']";
    private String inputMiddleName = "//input[@id='person_middleName']";
    private String inputLastName = "//input[@id='person_lastName']";
    private String inputBD = "//input[@id='person_birthDate']";
    private String inputSex = "//label[text()='Мужской']";
    private String inputPassSeries = "//input[@id='passportSeries']";
    private String inputPassNum = "//input[@id='passportNumber']";
    private String inputDatePass = "//input[@id='documentDate']";
    private String inputIssued = "//input[@id='documentIssue']";
    private String buttonSubmit = "//button[@type='submit' and contains(text(),'Продолжить')]";
    private String alert = "//div[@role='alert-form']";

    public String getAlert() {
        return alert;
    }

    public String getButtonSubmit() {
        return buttonSubmit;
    }

    public String getInputIssued() {
        return inputIssued;
    }

    public String getInputDatePass() {
        return inputDatePass;
    }

    public String getInputPassNum() {
        return inputPassNum;
    }

    public String getInputPassSeries() {
        return inputPassSeries;
    }

    public String getInputSex() {
        return inputSex;
    }

    public String getInputBD() {
        return inputBD;
    }

    public String getInputLastName() {
        return inputLastName;
    }

    public String getInputFirstName() {
        return inputFirstName;
    }

    public String getInputMiddleName() {
        return inputMiddleName;
    }

    public String getMinInsurance() {
        return minInsurance;
    }

    public String getButtonArrange() {
        return buttonArrange;
    }

    public String getInputSurname() {
        return inputSurname;
    }

    public String getInputName() {
        return inputName;
    }

    public String getInputBirthDate() {
        return inputBirthDate;
    }

    public String getTitleAboutInsurence() {
        return titleAboutInsurance;
    }

    public String getButtonApplyOnline() {
        return buttonApplyOnline;
    }

    public String getInsuranceAndBuyLink() {
        return insuranceAndBuyLink;
    }

    public String getInsuranceLink() {
        return insuranceLink;
    }

    public String getBaseUrl() {
        return baseUrl;
    }



    public Collection<Object[]> collection() {
        return  Arrays.asList(new Object[][]{{"Sokolov", "Nikita", "30.12.1987", "Соколов", "Никита", "Васильевич", "30.12.1987", "1111", "111111", "02.11.2012", "Выдан"},
                {"Bikov", "Pavel", "10.02.1988", "Быков", "Павел", "Алексеевич", "10.02.1988", "2222", "222222", "11.11.2011", "Выдан органом"},
                {"Krasnov", "Alex", "23.07.1984", "Краснов", "Александр", "Сергеевич", "23.07.1984", "3333", "333333", "16.08.2009", "Выдан государственным органом исполнительной власти "}});
    }

    @Parameterized.Parameter
    public String surname;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public String bd;
    @Parameterized.Parameter(3)
    public String lastName;
    @Parameterized.Parameter(4)
    public String firstName;
    @Parameterized.Parameter(5)
    public String middleName;
    @Parameterized.Parameter(6)
    public String birthDate;
    @Parameterized.Parameter(7)
    public String passSeries;
    @Parameterized.Parameter(8)
    public String passNum;
    @Parameterized.Parameter(9)
    public String datePass;
    @Parameterized.Parameter(10)
    public String issued;
}



