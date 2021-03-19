package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkSoftAssertionsPage() {
        open("https://github.com/");

        $("input[name=q]").setValue("selenide").pressEnter();
        $("ul.repo-list").$("[href='/selenide/selenide']").click();
        $("nav[aria-label=Repository]").$("[data-content=Wiki]").click();
        $$("#wiki-pages-box li").shouldHave(itemWithText("SoftAssertions"));

        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
