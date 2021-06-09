package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.pdftest.PDF;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class CheckFileContentTest {
    String txtFilePath = "./src/test/resources/txt_file.txt",
            xlsxFilePath = "./src/test/resources/excel_file.xlsx",
            pdfFilePath = "./src/test/resources/pdf_file.pdf",
            docxFilePath = "./src/test/resources/docx_file.docx",

            zipFilePath = "./src/test/resources/txt_file_for_zip.zip",
            unzipFolderPath = "./src/test/resources/unzip",
            zipPassword = "qwerty",
            unzipTxtFilePath = "./src/test/resources/unzip/txt_file_for_zip.txt",

            expectedData = "This is a text to check file content!";

    @Test
    @DisplayName("Check txt File")
    void checkTxtTest() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    @DisplayName("Check xlsx File")
    void checkXlsxTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    @DisplayName("Check pdf File")
    void checkPdfTest() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        PDF actualData = getPdf(pdfFilePath);
        assertThat(actualData, PDF.containsText(expectedData));
    }

    @Test
    @DisplayName("Check zip File")
    void checkZipTest() throws IOException, ZipException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        unzip(zipFilePath, unzipFolderPath, zipPassword);
        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    @DisplayName("Check docx File")
    void checkDocxTest() throws IOException{
        SelenideLogger.addListener("allure", new AllureSelenide());
        //String actualData = readDocxFromPath(docxFilePath);
        //assertThat(actualData, containsString(expectedData));
    }
}