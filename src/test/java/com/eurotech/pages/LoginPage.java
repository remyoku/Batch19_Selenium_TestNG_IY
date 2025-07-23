package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
    /**
     * PageFactory.initElements()  webElementleri locate etmek için gerekli olan  By class ının tanımla hale getirir
     * Aksi hale
     * @FindBy ile tanımlanan elementler null olarak kalır
     * NullPointerException alınır
     */

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    //WebElement emailBox = driver.findElement(By.id("email"));

    @FindBy(id="email")
    public WebElement emailBox;

    @FindBy(id="yourPassword")
    public WebElement passwordBox;

    @FindBy (xpath = "//button")
    public WebElement loginBtn;

    // And logic ile çalışır -- yani verilen tüm locotarlara sahip olan webElement i bulur
    @FindBys({
            @FindBy(id = "email"),
            @FindBy(xpath ="//input[@name='email']")
    })
    public WebElement emailBoxWithBys;

    //Or logic ile çalışır .Verilen locatorlara ilişkin bütün webElementleri bulup getirir.(Çoğul dönebilir.)
    @FindAll({
            @FindBy(css = "#yourPassword"),
            @FindBy(css = ".İrem")
    })
    public WebElement passwordBoxWithFindAll;

    @FindBy(xpath = "//div[contains(text(),'Password is incorrect. Please check')]")
    public WebElement wrongPasswordMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement getWrongEmailMessage;

    @FindBy(css = ".form-control,button")
    public List<WebElement> loginInputs;

    public void login(){
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    public void login(String userEmail, String password){
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }
}
