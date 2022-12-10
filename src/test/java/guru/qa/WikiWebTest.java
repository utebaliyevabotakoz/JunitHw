package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiWebTest {

    @BeforeEach
    void setUp() {
        open("https://www.wikipedia.org/");
    }

    @CsvSource(value = {
            "Acer, Acer",
            "air astana, Air Astana"
    })
    @ParameterizedTest(name = "Проверка наличия заголовка {1}" +
            " в результатах выдачи Википедии по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void wikiSearchTest(String searchQuery, String expectedLabel) {
        $("#searchInput").setValue(searchQuery).pressEnter();
        $(".mw-page-title-main").shouldHave(text(expectedLabel));

    }

}