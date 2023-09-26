package br.com.agibank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(org.openqa.selenium.WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if(browser == null){
            this.browser = new ChromeDriver();
        }else{
            this.browser = browser;
        }
        //Serve para configurar tempo de espera de load da tela e muitos outros
        this.browser.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10,TimeUnit.SECONDS);
        this.browser.manage().window().maximize();
    }

    public void fechar(){
        this.browser.quit();

    }
}
