package com.eurotech.pages;

import com.eurotech.utilities.Driver;
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
}
