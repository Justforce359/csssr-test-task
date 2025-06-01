import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class CsssrTest {

    @BeforeEach
    void startUp () {
        open("https://csssr.github.io/qa-engineer/");
    }

    SelenideElement beautifulInput = $("#beautiful");
    SelenideElement beautifulInputLabel = $("label[for='beautiful']");
    
    @Test
    @DisplayName("Send button should be inactive when form fields are empty")
    void sendButtonShouldBeInactiveIfFormIsEmptyTest () {
        $(".email").shouldBe(empty);
        $(".description").shouldBe(empty);
        $x(".//button[@type='submit']").scrollTo().shouldNotBe(enabled);
    }
    @Test
    @DisplayName("Bug checkbox should toggle correctly")
    void checkboxShouldToggleBack () {
        open("https://csssr.github.io/qa-engineer/");
        $(byText("НАХОДИТЬ НЕСОВЕРШЕНСТВА")).click();
        beautifulInputLabel.scrollTo();
        beautifulInput.shouldBe(selected);
        beautifulInputLabel.click();
        beautifulInput.shouldNotBe(selected);
        beautifulInputLabel.click();
        beautifulInput.shouldBe(selected);
    }
}
