package page.objects;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public void clickToPaymentGate() {
        $$("button").find(exactText("Купить")).click();
    }
    public void clickToCreditGate() {
        $$("button").find(exactText("Купить в кредит")).click();
    }
    public void setNumberCard(String numberCard) {
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").sendKeys(numberCard);
    }
    public void setMonth(String month) {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(month);
    }
    public void setYear(String year) {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(year);
    }
    public void setCardHolder(String cardHolder) {
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(cardHolder);
    }
    public void setCVC(String cvc) {
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(cvc);
    }
    public void clickToContinue() {
        $$("button").find(exactText("Продолжить")).click();
    }

    public String getStatus() {
        return $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title").text();
    }

}

