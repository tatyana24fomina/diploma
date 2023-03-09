package ru.netology;

import com.codeborne.selenide.Condition;
import data.DataHelper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TravelServiceTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    void shouldSuccessBuyingATour() {
        MainPage mainPage = new MainPage();
        mainPage.clickToPaymentGate();
        mainPage.setNumberCard(DataHelper.getApprovedNumberCard());
        mainPage.setMonth(DataHelper.getMonth());
        mainPage.setYear(DataHelper.getYear());
        mainPage.setCardHolder(DataHelper.getHolder());
        mainPage.setCVC(DataHelper.getCVC());

        mainPage.clickToContinue();
        $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title")
        .shouldHave(Condition.text("Успешно"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


        //Assertions.assertEquals("Успешно", mainPage.getStatus());
    }
}


