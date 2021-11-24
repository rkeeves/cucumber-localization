package com.rkeeves.github.selcumber;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FormPracticeStepDef {

    @Akkor("látnia kell egy {string} című űrlapot")
    public void formWithTextExists(String title) {
        $(By.xpath("//h5[text()='"+title+"']")).shouldBe(visible);
        $(By.id("userForm")).shouldBe(visible);
    }

    @Ha("kitolti az alábbi adatokkal$")
    public void fillForm(DataTable userDataTable) {
        List<Map<String,String>> data = userDataTable.entries();
        final Map<String,String> userData = data.get(0);
        final String g = userData.get("mobil");
        $(By.id("firstName")).sendKeys(userData.get("keresztnev"));
        $(By.id("lastName")).sendKeys(userData.get("vezeteknev"));
        $(By.id("userEmail")).sendKeys(userData.get("email"));
        $(By.id("userNumber")).sendKeys(userData.get("mobil"));
        String genderOptionId = getOptionIdByGender(userData.get("neme"));
        new Actions(WebDriverRunner.getWebDriver())
                .click($(By.id(genderOptionId))).build().perform();
    }

    static String getOptionIdByGender(String gender) {
        switch (gender) {
            case "Férfi":
                return "gender-radio-1";
            case "Nő":
                return "gender-radio-2";
            case "Egyéb":
                return "gender-radio-3";
            default:
                throw new IllegalArgumentException("Unknown Gender " + gender);
        }
    }

    @Ha("beadja az űrlapot")
    public void submitForm() {
        $(By.id("submit")).scrollIntoView(true).click();
    }

    @Akkor("egy felugró ablaknak kell megjelennie {string} felirattal")
    public void popupWithTitle(String title) {
        $(By.xpath("//div[contains(@class, 'modal-content')]")).shouldBe(visible);
        $(By.id("example-modal-sizes-title-lg")).shouldBe(visible).shouldHave(text(title));
    }

    @Ha("bezárja a felugró ablakot")
    public void closePopup() {
        $(By.id("close-fixedban")).click();
        $(By.id("closeLargeModal")).click();
    }

    @Akkor("az előbb kitöltött mezők újból üresek lesznek")
    public void fieldsOfFormAreEmpty() {
        $(By.id("firstName")).shouldBe(empty);
        $(By.id("lastName")).shouldBe(empty);
        $(By.id("userEmail")).shouldBe(empty);
        $(By.id("userNumber")).shouldBe(empty);
    }
}
