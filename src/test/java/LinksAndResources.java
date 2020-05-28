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
}


