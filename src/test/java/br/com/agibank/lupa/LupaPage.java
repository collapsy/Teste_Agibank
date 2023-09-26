package br.com.agibank.lupa;


import br.com.agibank.PageObject;
import org.openqa.selenium.By;

public class LupaPage extends PageObject {
    public static final String URL_AGIBANK = "https://blogdoagi.com.br/";
    String palavraPesquisada;
    public LupaPage(){
        super(null);
        browser.navigate().to(URL_AGIBANK);
    }

    public void pesquisarPalavraNoBlog(String palavra) {
        browser.findElement(By.id("search-open")).click();
        browser.findElement(By.cssSelector("input[type='search']")).sendKeys(palavra);
        browser.findElement(By.cssSelector("input[type='submit']")).submit();
        palavraPesquisada = palavra;
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_AGIBANK+"?s="+palavraPesquisada);
    }

    public boolean isPalavraVisivel() {
        String pageSource = browser.getPageSource();
        return pageSource.contains(palavraPesquisada);
    }

    public String resutadoDaBuscaPor() {
        return browser.findElement(By.xpath("//*[@id='primary']//h1")).getText();
    }
}
