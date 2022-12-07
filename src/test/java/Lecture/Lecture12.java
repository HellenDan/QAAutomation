package Lecture;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.ShouldBe;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lecture12 {

    @Test
    public void testMethod_1() {
        open("https://ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("რეგისტრაცია")).shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byName("firstName")).setValue("Helen").shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byName("lastName")).setValue("Danelia").shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byName("email")).setValue("Helendaneliaa@gmail.com").shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byName("password")).setValue("QWERTY").shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byName("confirmPassword")).setValue("QWERTY").shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byId("singup")).shouldBe(Condition.enabled, Duration.ofMillis(3000));
    }

    @Test
    public void testMethod_2(){
        open("https://ee.ge/registration");
        $(byText("რეგისტრაცია")).shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byId("singup")).shouldBe(Condition.disabled, Duration.ofMillis(3000));
        $(byName("firstName")).click();
        $(byName("lastName")).click();
        $(byName("email")).click();
        $(byName("password")).scrollIntoView(true);
        $(byName("password")).click();
        $(byName("confirmPassword")).click();
        $(byName("password")).click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        $(byName("email")).setValue("22434");
        $(byName("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.disappear,Duration.ofMillis(3000));
        $(byName("password")).setValue("123");
        $(byName("პაროლი სავალდებულოა")).shouldBe(Condition.disappear,Duration.ofMillis(3000));
        $(byName("password")).setValue("QWERTY");
        $(byName("confirmPassword")).setValue("QWERTY");
        $(byName("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.disappear, Duration.ofMillis(3000));

    }


    @Test
    public void testMethod_3(){
        open("https://ee.ge/");
        $(byClassName("cart")).click();
        $(byId("search_list")).setValue("Apple iPhone 11 128GB Black").pressEnter();
        $(byText("დაამატე კალათში")).click();
        $(byClassName("cart")).click();
        $(byClassName("cart")).shouldBe(Condition.visible);
        $(byText("წაშლა")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

    }

    @Test
    public void testMethod_4(){
        open("https://ee.ge/");
        $(byClassName("cart")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible, Duration.ofMillis(3000));
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $(byId("search_list")).setValue("Apple iPhone 11 128GB Black").pressEnter();
        $(byText("დაამატე კალათში")).click();
        $(byClassName("cart")).click();
        $(byText("შენახვა")).click();
        $(byText("შენახული ნივთები")).shouldBe(Condition.visible);
        $(byClassName("cart")).click();
        $(byClassName("cart")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byClassName("product-list")).$(byClassName("btn")).click();
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);


    }

    }

