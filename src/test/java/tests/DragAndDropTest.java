package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkDragAndDropsFeature() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        String locatorA = "#column-a header";
        String locatorB = "#column-b header";
        $(locatorA).shouldHave(text("A"));
        $(locatorB).shouldHave(text("B"));

        //it doesn't work (after moving element mouse doesn't drop)
        //actions().clickAndHold($(locatorA)).moveToElement($(locatorB)).release().perform();
        //it works
        $(locatorA).dragAndDropTo($(locatorB));
        $(locatorA).shouldHave(text("B"));
        $(locatorB).shouldHave(text("A"));
    }
}
