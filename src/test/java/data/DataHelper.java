package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    static Faker faker = new Faker();

    @Value
    public static class CardInfo {
        private String number;
        private String month;
        private String year;
        private String holder;
        private String cvc;
    }

    public static String getApprovedNumberCard() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedNumberCard() {
        return "4444 4444 4444 4442";
    }

    public static String getMonth() {
        //return String.valueOf(faker.number().numberBetween(1, 12));
        return String.valueOf(LocalDate.now().plusMonths(faker.number().numberBetween(1,12)).format(DateTimeFormatter.ofPattern("MM")));
    }

    public static String getYear() {
        //return String.valueOf(faker.date().future(5, TimeUnit.DAYS).getYear());
        return String.valueOf(LocalDate.now().plusYears(faker.number().numberBetween(1, 5)).format(DateTimeFormatter.ofPattern("yy")));
    }

    public static String getHolder() {
        return faker.name().firstName() + faker.name().lastName();
    }

    public static String getCVC() {
        return faker.number().digits(3);
    }

    public static String getRandomNumberCard() {
        return faker.number().digits(16);
    }

    public static class Registrator {
        public static CardInfo RegistrationApprovedCard() {
            return new CardInfo(getApprovedNumberCard(), getMonth(), getYear(), getHolder(), getCVC());
        }
        public static CardInfo RegistrationDeclinedCard() {
            return new CardInfo(getDeclinedNumberCard(), getMonth(), getYear(), getHolder(), getCVC());
        }
        public static CardInfo RegistrationRandomCard() {
            return new CardInfo(getRandomNumberCard(), getMonth(), getYear(), getHolder(), getCVC());
        }
    }


}
