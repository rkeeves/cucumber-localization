package com.rkeeves.github.selcumber;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.hu.Amennyiben;
import io.cucumber.java.hu.Ha;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ToolsQAStepDef {
    @Amennyiben("^a ToolsQA-ra látogat$")
    public void gotoToolsQAPage() {
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.headless = false;
        open("https://demoqa.com/");
    }

    @Amennyiben("a {string} nevű elemre kattint")
    public void clickOnByText(String elementText) {
        $(byText(elementText)).scrollIntoView(true).shouldBe(visible).click();
    }

    @Ha("^a baloldali menüsáv látszik$")
    public void leftPanelVisible() {
        $(".left-pannel").shouldBe(visible);
    }
}
