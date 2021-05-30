package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class Locators {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    /*
    Прошу помощи с заданием номер 1.
    Судя принятым ответам ребят, правильный ответ - "Разницы нет".
    У меня на пркатике получается, что это не так для сайтов со сложной структурой:
    если запустить тест, то он упадет на четвертой строке с ошибкой 'Element not found {div/h1}'
    Получается, $("div h1") ищет в элемент с помошью селектора {div h1}
    Тогда как второй способ {div/h1} сначала найдет первый попавшийся div и внутри него будет искать первый попавшийся h1,
     и если в первом div заголовка h1 нет, то тест упадет (как это видно для https://github.com/qa-guru)
    Таким образом, элемент может быть не найден без указания какого-нить дополнительного параметра, скажем, value класса,
     чтобы заведомо точно папость в нужный нам div.
     */

    @Test
    void LocatorsTest() {
        open("https://github.com/qa-guru");

        String first = $("div[class='flex-1'] h1").getText();
        String second = $("div[class='flex-1']").$("h1").getText();

        String third = $("div h1").getText();

        //Test will fail HERE
        String forth = $("div").$("h1").getText();
    }
}