package Lecture;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.SelectRadio;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Homework4 {
    @Test
     public void test(){

        open("https://www.facebook.com/");
        $(byText("Create new account")).click();
        $(byName("firstname")).setValue("Helen");
        $(byName("lastname")).setValue("Danelia");
        $(byName("reg_email__")).setValue("Helendaneliaa@gmail.com");
        $(byName("birthday_year")).selectOption("1997");
        $(byText("Custom")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $(byName("custom_gender")).shouldBe(Condition.visible, Duration.ofMillis(2000));

        $(byText("Female")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.disappear);
        $(byName("preferred_pronoun")).shouldBe(Condition.disappear);


    }
}
