package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiWebTest {
    @Test
    void googleTest(){

        open ("https://www.wikipedia.org/");

    }
}
