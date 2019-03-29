package com.mickey.steps.deliveryClub;


import com.mickey.pages.deliveryClub.DeliveryClubPage;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class DeliveryClubSteps
{

    private final DeliveryClubPage deliveryClubPage = page(DeliveryClubPage.class);

    @Пусть("пользователь открыл главную страницу")
    public void openWeb()
    {
        open("https://www.delivery-club.ru/");
    }

    @И("^пользователь ввел в поле с плейсхолдером \"([^\"]*)\" текст \"([^\"]*)\"$")
    public void addVariantOfOpenAnswer(String placeholder, String text)
    {
        deliveryClubPage.enterKeywordsInput(placeholder, text);

    }

    @И("^пользователь нажал на кнопку (.+)$")
    public void clickButtonByText(String buttonText)
    {
        deliveryClubPage.clickButtonByText(buttonText);
    }

    @И("^пользователь нажал на кнопку Корзина$")
    public void clickButtonByBasket()
    {
        deliveryClubPage.clickButtonByBasket();
    }

    @И("^пользователь нажал на чекбокс \"([^\"]*)\"$")
    public void clickOnCheckbox(String checkboxLabel)
    {
        deliveryClubPage.clickOnCheckbox(checkboxLabel);
    }

    @И("^пользователь нажал на радио-кнопку \"([^\"]*)\"$")
    public void clickOnRadioButton(String radioButtonLabel)
    {
        deliveryClubPage.clickOnRadioButton(radioButtonLabel);
    }

    @И("^пользователь нажал на ссылку (.+)$")
    public void clicklinkByText(String buttonText)
    {
        deliveryClubPage.clicklinkByText(buttonText);
    }

    @И("^пользователь выбрал меню по назвqwанию (.+) и нажал на кнопку заказать$")
    public void clickButtonByTextclick(String textLabel)
    {
        deliveryClubPage.clickButtonByTextclick(textLabel);
    }

    @И("^поле \"([^\"]*)\" имеет значение \"([^\"]*)\"$")
    public void checkTextFromField(String fieldName, String expectedText)
    {
       // deliveryClubPage.checkTextFromField(fieldName, expectedText);
    }


    @И("^пользователь нажал кнопку Добавить в заказ")
    public void clickButtonByTextPopup()
    {
        deliveryClubPage.clickButtonByTextPopup();
    }


    @Пусть("^пользователь ждет (.*) сек$")
    public void userWaits(int timeInSeconds) throws Throwable
    {
        Thread.sleep(Integer.valueOf(String.valueOf(timeInSeconds) + String.valueOf("000")));
    }

    @И("^пользователь выбрал меню по названию (.+) и нажал на кнопку (.+)$")
    public void clickButtonByText(String text, String buttonText)
    {
        deliveryClubPage.clickButtonByText(buttonText, deliveryClubPage.getBlockWithText(text));
    }
}

