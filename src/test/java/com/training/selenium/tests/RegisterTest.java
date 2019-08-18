package com.training.selenium.tests;


import com.training.selenium.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import sun.awt.windows.WBufferStrategy;

import java.util.List;
import java.util.Set;

public class RegisterTest extends TestBase {

    @Test(priority = 0, description = "Register User With All Details", enabled = false)
    public void RegisterTestCase() throws InterruptedException {
        WebElement firstNameElement = driver.findElement(By.name("first_name"));
        WebElement lastNameElement = driver.findElement(By.name("last_name"));
        WebElement isHostingElement = driver.findElement(By.name("hosting"));

        firstNameElement.sendKeys("Hitesh");
        lastNameElement.sendKeys("Prajapati");

        Thread.sleep(3000);

        firstNameElement.clear();
        firstNameElement.sendKeys("Bhavin");

        lastNameElement.clear();
        lastNameElement.sendKeys("Patel");

        Select selectState = new Select(driver.findElement(By.name("state")));
        selectState.selectByVisibleText("Texas");
        selectState.selectByVisibleText("Washington");

        isHostingElement.click();

        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void SelectMultipleOptionsTestCase() throws InterruptedException {

        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement multipleSelectElement = driver.findElement((By.id("multi-select")));
        WebElement getAllSelectedValueElement = driver.findElement(By.id("printAll"));

        Select multiSelect = new Select(multipleSelectElement);
        multiSelect.selectByValue("New Jersey");
        multiSelect.selectByValue("Florida");
        multiSelect.selectByValue("New York");

        getAllSelectedValueElement.click();

        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void SelectMultipleOptionsUsingActionsTestCase() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement multipleSelectElement = driver.findElement((By.id("multi-select")));
        WebElement getAllSelectedValueElement = driver.findElement(By.id("printAll"));

        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 5000);
        Alert alert = driver.switchTo().alert();
        
    }



    @Test
    public void SliderTest() throws InterruptedException {
        driver.get("https://jqueryui.com/slider/#custom-handle");
        // driver.get("http://demo.automationtesting.in/Slider.html");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement sliderEle = driver.findElement(By.id("slider"));
        WebElement sliderButtonEle = sliderEle.findElement(By.id("custom-handle"));

        Point elePoint = sliderEle.getLocation();

        int sliderWidth = sliderEle.getSize().getWidth();
        Dimension sliderPointDim = sliderButtonEle.getSize();
        int slideButtonHeight = sliderPointDim.getHeight();
        int slideButtonWidth = sliderPointDim.getWidth();
        int xCord = elePoint.getX();
        int yCord = elePoint.getY();

        System.out.println("Height Of Slider is : " + sliderEle.getSize().getHeight() + " & Width Of Slider Is: " + sliderWidth);
        System.out.println("Height Of Slider Button is : " + slideButtonHeight + " & Width Of Slider Is: " + slideButtonWidth);
        System.out.println("Slider Button Is At Position (X,Y) : (" + xCord + "," + yCord +")");

        int sliderToMoveAt = 33;
        int newXCord = xCord + (int) Math.ceil((sliderWidth/100) * sliderToMoveAt) + 3;

        System.out.println("New Slider Button Should Be At Position (X,Y) : (" + newXCord + "," + yCord +")");

        Actions sliderAction = new Actions(driver);

        sliderAction.clickAndHold(sliderButtonEle)
                .moveByOffset(newXCord, yCord)
                .release()
                .build()
                .perform();



        Thread.sleep(5000);
    }

    @Test(description = "Range Slider")
    public void RangeSlider() throws InterruptedException {
        driver.get("https://jqueryui.com/slider/#range");

        WebDriverWait wait = new WebDriverWait(driver,10);



        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement sliderRangeElement = driver.findElement(By.id("slider-range"));
        WebElement leftSlideTabElement = sliderRangeElement.findElements(By.tagName("span")).get(0);
        WebElement rightSlideTabElement = sliderRangeElement.findElements(By.tagName("span")).get(1);

        int sliderWidth = sliderRangeElement.getSize().getWidth();
        int leftSlideWidth = leftSlideTabElement.getSize().getWidth();
        int rightSlideWidth = rightSlideTabElement.getSize().getWidth();
        int sliderX = sliderRangeElement.getLocation().getX();
        int sliderY = sliderRangeElement.getLocation().getY();

        System.out.println("Slider Width is: " + sliderWidth);
        System.out.println("Slider Left Location is (X,Y) : (" + sliderX + ", " + sliderY + ")");
        System.out.println("Left slider tab width: " + leftSlideWidth);
        System.out.println("Right slider tab width: " + rightSlideWidth);

        Actions sliderRangeAction = new Actions(driver);

        sliderRangeAction.moveToElement(leftSlideTabElement)
                .clickAndHold()
                .moveByOffset(- (leftSlideTabElement.getLocation().getX()),sliderY)
                .release()
                .build()
                .perform();

        Thread.sleep(3000);

        sliderRangeAction.moveToElement(rightSlideTabElement)
                .clickAndHold()
                .moveByOffset(sliderWidth - rightSlideTabElement.getLocation().getX(),sliderY)
                .release()
                .build()
                .perform();



        int totalRange = 500;

        Thread.sleep(5000);
    }


    @Test(description = "Working Slider Example")
    public void SliderTestCase() throws InterruptedException {
        driver.get("http://www.globalsqa.com/demo-site/sliders");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        Thread.sleep(3000);

        WebElement redSliderElement = driver.findElement(By.id("red"));
        WebElement redSlideTabElement = redSliderElement.findElement(By.tagName("span"));
        int redX = redSliderElement.getLocation().getX();
        int redY = redSliderElement.getLocation().getY();
        int redWidth = redSliderElement.getSize().getWidth();

        WebElement greenSliderElement = driver.findElement(By.id("green"));
        WebElement greenSlideTabElement = greenSliderElement.findElement(By.tagName("span"));
        int greenX = greenSliderElement.getLocation().getX();
        int greenY = greenSliderElement.getLocation().getY();
        int greenWidth = greenSliderElement.getSize().getWidth();

        WebElement blueSliderElement = driver.findElement(By.id("blue"));
        WebElement blueSlideTabElement = blueSliderElement.findElement(By.tagName("span"));
        int blueX = blueSliderElement.getLocation().getX();
        int blueY = blueSliderElement.getLocation().getY();
        int blueWidth = blueSliderElement.getSize().getWidth();

        System.out.println("Red Slider Is At Position (X,Y) : (" + redX + "," + redY + ") having width as : " + redWidth);
        System.out.println("Green Slider Is At Position (X,Y) : (" + greenX + "," + greenY + ") having width as : " + greenWidth);
        System.out.println("Blue Slider Is At Position (X,Y) : (" + blueX + "," + blueY + ") having width as : " + blueWidth);

        Actions sliderActions = new Actions(driver);

        // Move Red Slider All the way to left
        sliderActions.moveToElement(redSlideTabElement)
                .clickAndHold()
                .moveByOffset(-(redWidth),redY)
                .release()
                .build()
                .perform();

        Thread.sleep(2000);

        // Move Green Slider All the way to left
        sliderActions.moveToElement(greenSlideTabElement)
                .clickAndHold()
                .moveByOffset(-(greenSlideTabElement.getLocation().getX() - greenX),greenY)
                .release()
                .build()
                .perform();

        Thread.sleep(2000);

        int seventyPercentGreenX = (greenX + ((greenWidth/100)*70));

        System.out.println("70% Green Slider Width Is : " + seventyPercentGreenX);

        // Move Green Slider All the way to right at 70%
        sliderActions.moveToElement(greenSlideTabElement)
                .clickAndHold()
                .moveByOffset(seventyPercentGreenX,greenY)
                .release()
                .build()
                .perform();

        Thread.sleep(2000);

        int blueXCurrentLoc = blueSlideTabElement.getLocation().getX();
        int seventyPercentBlueX = seventyPercentGreenX- blueXCurrentLoc;

        System.out.println("Blue Curr Position : " + blueXCurrentLoc);
        System.out.println("70% Blue Slider Width Is : " + seventyPercentBlueX);

        // Move Blue Slider All the way to right at 70%
        sliderActions.moveToElement(blueSlideTabElement)
                .clickAndHold()
                .moveByOffset(seventyPercentBlueX,blueY)
                .release()
                .build()
                .perform();

        Thread.sleep(5000);


    }

    @Test(description = "Working Slider Range Example")
    public void SliderOfTypeRangeTest() throws InterruptedException {
        driver.get("http://www.globalsqa.com/demo-site/sliders");

        // Navigate to "Range" Tab
        driver.findElement(By.id("Range")).click();

        Thread.sleep(2000);

        driver.switchTo().frame(driver.findElements(By.className("demo-frame")).get(1));

        Thread.sleep(3000);

        // Get Slider Element
        WebElement sliderElement = driver.findElement(By.id("slider-range"));
        int sliderWidth = sliderElement.getSize().getWidth();
        int sliderX = sliderElement.getLocation().getX();
        int sliderY = sliderElement.getLocation().getY();

        // Get Left Slide Bar Element
        WebElement leftSlideBarElement = sliderElement.findElements(By.tagName("span")).get(0);
        int leftSlideBarWidth = leftSlideBarElement.getSize().width;
        int leftSlideBarX = leftSlideBarElement.getLocation().getX();
        int leftSlideBarY = leftSlideBarElement.getLocation().getY();

        // Get Right Slide Bar Element
        WebElement rightSlideBarElement = sliderElement.findElements(By.tagName("span")).get(1);
        int rightSlideBarWidth = rightSlideBarElement.getSize().width;
        int rightSlideBarX = rightSlideBarElement.getLocation().getX();
        int rightSlideBarY = rightSlideBarElement.getLocation().getY();

        // Print Slider & Bar Details
        System.out.println("Slider Is At (X,Y) : (" + sliderX + ", " + sliderY + ") Having width as : " + sliderWidth);
        System.out.println("Left Slide Bar Is At (X,Y) : (" + leftSlideBarX + ", " + leftSlideBarY + ") Having width as : " + leftSlideBarWidth);
        System.out.println("Left Slide Bar Is At (X,Y) : (" + rightSlideBarX + ", " + rightSlideBarY + ") Having width as : " + rightSlideBarWidth);

        Actions sliderAction = new Actions(driver);

        sliderAction.moveToElement(leftSlideBarElement)
                .clickAndHold()
                .moveByOffset(-(leftSlideBarX - sliderX - (leftSlideBarWidth/2)), leftSlideBarY)
                .release()
                .build()
                .perform();

        Thread.sleep(5000);

    }

    @Test(description = "Working Drag And Drop Example")
    public void dragAndDropTest() throws InterruptedException {
        driver.get("http://www.globalsqa.com/demo-site/draganddrop");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        Thread.sleep(3000);

        List<WebElement> dragElement = driver.findElement(By.id("gallery")).findElements(By.tagName("li"));
        WebElement toDragElement = driver.findElement(By.id("trash"));

        Actions dragAndDropAction = new Actions(driver);
        dragAndDropAction.moveToElement(dragElement.get(0))
                .clickAndHold()
                .moveToElement(toDragElement)
                .release(toDragElement)
                .build()
                .perform();

        Thread.sleep(1000);

        for(int i=1; i<dragElement.size(); i++) {
            dragAndDropAction.moveToElement(dragElement.get(i))
                    .dragAndDrop(dragElement.get(i), toDragElement)
                    .build()
                    .perform();
            Thread.sleep(2000);
        }

        Thread.sleep(5000);



    }

    @Test(description = "Double Click Using Actions")
    public void DoubleClickUsingActionTest() throws InterruptedException {
        driver.get("https://demoqa.com/tooltip-and-double-click/");

        Thread.sleep(3000);

        WebElement doubleClickElement = driver.findElement(By.id("doubleClickBtn"));

//        doubleClickElement.click();
//        doubleClickElement.click();

        Actions doubleClickAction = new Actions(driver);

        doubleClickAction.moveToElement(doubleClickElement)
                .doubleClick(doubleClickElement)
                .build()
                .perform();

        Thread.sleep(3000);

        // Switch to Alert & Accept It
        Alert jsAlert = driver.switchTo().alert();
        String textOnAlert = jsAlert.getText();
        jsAlert.accept();

        System.out.println("Text On Alert : " + textOnAlert);

        Thread.sleep(5000);
    }

    @Test(description = "Right Click Demo")
    public void RightClickTest() throws InterruptedException {

        driver.get("https://demoqa.com/tooltip-and-double-click/");

        Thread.sleep(3000);

        WebElement rightClickBtnElement = driver.findElement(By.id("rightClickBtn"));

        Actions rightClickAction = new Actions(driver);

        rightClickAction.moveToElement(rightClickBtnElement)
                .contextClick(rightClickBtnElement)
                .build()
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("rightclickItem"))));

        List<WebElement> rightClickMenuElement = driver.findElement(By.id("rightclickItem")).findElements(By.className("contextMenuItem"));

        rightClickMenuElement.get(0).click();

        Thread.sleep(3000);

        Alert editAlert = driver.switchTo().alert();
        editAlert.accept();

        Thread.sleep(5000);

    }

    @Test(description = "Tool Tip Verification")
    public void ToolTipTestCase() throws InterruptedException {
        driver.get("https://demoqa.com/tooltip-and-double-click/");
        Thread.sleep(3000);

        WebElement toolTipElement = driver.findElement(By.id("tooltipDemo"));

        Actions toolTipAction = new Actions(driver);
        toolTipAction.moveToElement(toolTipElement)
                .build()
                .perform();

        WebElement toolTipTextElement = driver.findElement(By.className("tooltiptext"));


        System.out.println("Tool Tip Text: " + toolTipTextElement.getText());
        Assert.assertEquals(toolTipTextElement.getText().trim().toUpperCase(), "WE ASK FOR YOUR AGE ONLY FOR STATISTICAL PURPOSES.");

        Thread.sleep(5000);
    }

    @Test(description = "Keyboard Event Test Case")
    public void KeyboardEventTestCase() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        Thread.sleep(3000);

        WebElement textBoxElement = driver.findElement(By.id("target"));


        Actions keyBoardEventAction = new Actions(driver);

        keyBoardEventAction.moveToElement(textBoxElement)
                .keyDown(Keys.SHIFT)
                .sendKeys(textBoxElement, "hitesh prajapati")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String textBoxValue = (String) js.executeScript("return document.getElementById(\"target\").value;");

        System.out.println("Value  : " + textBoxValue);

        Assert.assertEquals(textBoxValue, "HITESH PRAJAPATI");
    }

    @Test(description = "Multi Select Using Action")
    public void MultiSelectTestCase() throws InterruptedException {
        driver.get("https://demoqa.com/selectable/");
        Thread.sleep(3000);

        List<WebElement> multiSelectElements = driver.findElement(By.id("selectable")).findElements(By.tagName("li"));

        Actions multiSelectAction = new Actions(driver);
        multiSelectAction.keyDown(Keys.CONTROL)
                .click(multiSelectElements.get(0))
                .click(multiSelectElements.get(2))
                .click(multiSelectElements.get(4))
                .click(multiSelectElements.get(6))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        Thread.sleep(5000);
    }

    @Test(description = "Switching Between Window")
    public void SwitchToWindowTestCase() throws InterruptedException {
            driver.get("https://demoqa.com/automation-practice-switch-windows/");
        Thread.sleep(3000);

        String parentWindow = driver.getWindowHandle();

        WebElement openNewWindowBtnElement = driver.findElement(By.id("button1"));
        openNewWindowBtnElement.click();

        WebDriverWait wait = new WebDriverWait(driver,60);

        Set<String> windowList = driver.getWindowHandles();

        for(String window:windowList) {
            System.out.println("Window Id :" + window);
            if(!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Successfully Switched to Window Having Id: " + window);
            }
        }

        driver.manage().window().maximize();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cookie_action_close_header"))));
        driver.findElement(By.id("cookie_action_close_header")).click();

        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(parentWindow);

        Thread.sleep(2000);

        WebElement titleElement = driver.findElement(By.className("entry-title"));

        System.out.println("Title in Parent Window Is: " + titleElement.getText());

        Assert.assertEquals(titleElement.getText().trim().toUpperCase(),"AUTOMATION PRACTICE SWITCH WINDOWS");

        Thread.sleep(5000);

    }
}
