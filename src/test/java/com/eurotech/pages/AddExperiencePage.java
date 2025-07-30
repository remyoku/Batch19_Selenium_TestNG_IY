package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage {

    @FindBy(xpath = "//div/button[text()='Add Experience']")
    public WebElement addExperienceBtn;

    @FindBy(xpath = "//input[@id='job']")
    public WebElement jobBox;

    @FindBy(id = "todateexp")
    public WebElement toDateBox;

    @FindBy(xpath = "(//textarea[@id='description'])[1]")
    public WebElement descriptionBox;
    public void fillingAddExperienceForm(String jobName, String company,String location,String fromDate, String toDate,String descrptn){
        Actions actions = new Actions(Driver.get());

        actions.click(jobBox)
                .sendKeys(jobName + Keys.TAB)
                .sendKeys(company + Keys.TAB)
                .sendKeys(location + Keys.TAB)
                .sendKeys(fromDate + Keys.TAB + Keys.TAB).perform();

        toDateBox.sendKeys(toDate);

        actions.click(descriptionBox)
                .sendKeys(descrptn+Keys.TAB+Keys.ENTER).perform();




    }
}
