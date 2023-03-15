package ru.netology;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.MainPage;

import java.sql.*;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TravelServiceTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
        //1
    void shouldSuccessBuyingATour() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title")
                .shouldHave(Condition.text("Успешно"), Duration.ofSeconds(15))
            .shouldBe(Condition.visible);
    //Assertions.assertEquals("Успешно", mainPage.getStatus());
}

    @Test
        //2
    void shouldBuyingATourWithInvalidMonth() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth("13");
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверно"))
                .shouldBe(Condition.visible);
    }

    @Test
        //3
    void shouldBuyingATourWithInvalidFutureYear() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear("30");
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверно"))
                .shouldBe(Condition.visible);
    }

    @Test
        //4
    void shouldBuyingATourWithInvalidPastYear() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear("12");
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Истёк"))
                .shouldBe(Condition.visible);
    }

    @Test
        //5
    void shouldBuyingATourWithInvalidCVC() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC("23");

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(3) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверный формат"))
                .shouldBe(Condition.visible);
    }

    @Test
        //6
    void shouldSuccessBuyingTourInCredit() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title")
                .shouldHave(Condition.text("Успешно"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
        //7
    void shouldBuyingTourInCreditWithInvalidMonth() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth("14");
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверно"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
        //8
    void shouldBuyingATourInCreditWithInvalidFutureYear() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear("29");
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверно"))
                .shouldBe(Condition.visible);
    }

    @Test
        //9
    void shouldBuyingATourInCreditWithInvalidPastYear() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear("20");
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Истёк"))
                .shouldBe(Condition.visible);
    }

    @Test
        //10
    void shouldBuyingATourInCreditWithInvalidCVC() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear("20");
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC("11");

        mainPage.clickToContinue();
        $("#root > div > form > fieldset > div:nth-child(3) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub")
                .shouldHave(Condition.text("Неверный формат"))
                .shouldBe(Condition.visible);
    }

    @Test
        //11
    void shouldBuyingATourWithDeclinedCard() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationDeclinedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title")
                .shouldHave(Condition.text("Карта отклонена"))
                .shouldBe(Condition.visible);
    }

    @Test
        //12
    void shouldBuyingATourInCreditWithDeclinedCard() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationDeclinedCard();

        mainPage.clickToCreditGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();
        $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title")
                .shouldHave(Condition.text("Карта отклонена"))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldSuccessTransaction() {
        MainPage mainPage = new MainPage();
        var card = new DataHelper.Registrator().RegistrationApprovedCard();

        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(card.getNumber());
        mainPage.setMonth(card.getMonth());
        mainPage.setYear(card.getYear());
        mainPage.setCardHolder(card.getHolder());
        mainPage.setCVC(card.getCvc());

        mainPage.clickToContinue();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Ghfuf4290");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select status from payment_entity\n" +
                    "order by created desc\n" +
                    "limit 1");
            Assertions.assertEquals(rs.getString("status"),"APPROVED");
        } catch (SQLException e) {

        }
    }
}

