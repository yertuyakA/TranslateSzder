package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WBbase {
    public static WebDriver wb = new ChromeDriver();

    public static void openWebSite(String url){

        wb.manage().window().maximize();

        wb.get(url);

    }

    public static String translateKazToRus(String word) throws InterruptedException {

        WebElement panel = wb.findElement(By.id("dictionary_translate_phrase"));

        panel.sendKeys(word);

        wb.findElement(By.id("dictionary_translate_translate")).click();

        Thread.sleep(5000);

        try{

            String text = wb.findElement(By.xpath("//*[@id=\"dictionary_translate_article_translation\"]/span[2]/a")).getText();

            return text;

        }catch (Exception e){

            return null;

        }

    }
}