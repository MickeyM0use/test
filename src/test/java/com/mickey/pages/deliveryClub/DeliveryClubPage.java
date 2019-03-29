package com.mickey.pages.deliveryClub;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


import java.util.Arrays;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static java.lang.String.format;
import static java.lang.String.join;

public class DeliveryClubPage
{

    @FindBy(tagName = "body")
    public SelenideElement htmlBody;

    public void enterKeywordsInput(String placeholder, String text)
    {
        getInputWithPlaceholder(placeholder).scrollTo().val(text);
    }

    public SelenideElement getInputWithPlaceholder(String text)
    {
        return $(byXpath(format("//*[@placeholder='%s']", text)));
    }



    public void clickButtonByText(String buttonText, SelenideElement parent)
    {
        String linkButton = format(".//a[text()='%s']", buttonText);
        //String ButtonPopup = format(".//class[text()='%s']", buttonText); // Кривое название на сайте. Отдельно вынес на время
        String inputButton = format(".//input[@value='%s' and @type='submit']", buttonText);
        String commonButton = format(".//button[text()='%s']", buttonText);
        String spanButton = format(".//span[text()='%s']", buttonText);
        String finalXPath = join("|", Arrays.asList(linkButton, inputButton, commonButton, spanButton));

        actions().moveToElement(parent.$(By.xpath(finalXPath))).click().perform();
    }



    public void clickButtonByText(String buttonText)
    {
        clickButtonByText(buttonText, htmlBody);
    }


    public void clickOnCheckbox(String checkboxLabel)
    {
        clickOnCheckbox(checkboxLabel, htmlBody);
    }
    protected void clickOnCheckbox(String checkboxLabel, SelenideElement parent)
    {
       // parent.$(By.xpath(format(".//value[text()='%s' and .//span[@class='checkbox-span']]", checkboxLabel))).scrollTo().click();
        parent.$(By.xpath(format(".//span[text()='%s']", checkboxLabel))).click();
    }



    public void clicklinkByText(String buttonText)
    {
        clickButtonByText(buttonText);
    }



    public void clickButtonByTextclick(String buttonText)
    {
        clickButtonByText1(buttonText, htmlBody);
    }

    protected void clickButtonByText1(String checkboxLabel, SelenideElement parent)
    {

        parent.$(By.xpath(format(".//span[text()='%s']", checkboxLabel))).scrollTo();
    }


    public void clickOnRadioButton(String radioButtonLabel)
    {
        clickOnRadioButton(radioButtonLabel, htmlBody);
    }

    protected void clickOnRadioButton(String radioButtonLabel, SelenideElement parent)
    {

        parent.$(By.xpath(format(".//div[text()='%s']", radioButtonLabel))).click();
    }


    public void clickButtonByTextPopup()
    {
        $(By.xpath(".//a[@class='btn-green--sm order_button popup-dish__btn--add']")).click();
    }

    public SelenideElement getBlockWithText(String text)
    {

        return $(By.xpath(format("//span[text()='%s']//ancestor::li[1]", text))).scrollTo();
    }

    public void clickButtonByBasket()
    {
        $(By.xpath(".//a[@class='btn-green--sm order_button popup-dish__btn--add']")).click();
    }

}