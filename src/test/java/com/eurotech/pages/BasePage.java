package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    /**
     * header ve fonter gibi her sayfada karşımıza çıkacak webElementleri bu sayfada toplayabiliriz.
     * inheritance yoluyla diğer pageler altında onlara ulaşabiliriz.
     */

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(css = ".nav-item")
    public List<WebElement> tabMenu;

    @FindBy(css = "span.d-none.d-md-block.dropdown-toggle.ps-2")
    public WebElement usernameAtRightTop;

    public void navigateToTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();

    }

    public void navigateToTabs(String tabName, String moduleName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
        WebElement module = Driver.get().findElement(By.xpath("//span[text()='"+moduleName+"']"));
        module.click();
    }

}


