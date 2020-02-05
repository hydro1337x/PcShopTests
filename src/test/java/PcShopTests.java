import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Random;

public class PcShopTests {
    //-----------------------------------Global Variables-----------------------------------
    public String globalEmail = "bon21021@bcaoo.com";
    public String globalPassword = "abc123#$X";
    public String newEmail;
    public String loginRegisterExpectedMessage = "Odjava";
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.pcshop.hr/";
    // MARK: - Search test
    public String expectedSearchMessage = "DJI MAVIC (PRONAĐENO ARTIKLA: 12)";
    // MARK: - Add to basket and delete
    public String expectedAddToBasketMessage = "VAŠA KOŠARICA JE PRAZNA!";
    // MARK: - Category picking
    public String expectedCategoryPickMessage = "GRAFIČKE KARTICE ASUS";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }
    @Test
    public void PcShopSearchTest() throws InterruptedException {
// driver.manage().window().maximize();
        WebElement searchTextBox = driver.findElement(By.xpath("/html//input[@id='searchInput']"));
        searchTextBox.sendKeys("DJI Mavic");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("//div[@id='product-list-wrapper']//h1"));
        Assert.assertEquals(testLink.getText(), expectedSearchMessage);
        System.out.print(testLink.getText());
}

    @Test
    public void PcShopAddToBasketDeleteTest() throws InterruptedException {
        driver.findElement(By.xpath("/html//div[@class='container index-kategorije']/div[10]/a[@title='Tableti']/img[@alt='Tableti']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='product-list-wrapper']/div[4]/div[1]/div/div[@class='product-image']/a[@href='https://www.pcshop.hr/lenovo-navlaka-za-tablet-tab-4-10-plus-10/len%2Dzg38c01774/product/']/img[@alt='Lenovo navlaka za tablet Tab 4 10 Plus 10']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='kolgumb']//a[@title='Dodaj u košaricu']/div[@class='kupi']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//section[@id='product']//form[@name='form1']/div[@class='cart-info']/table/tbody/tr[2]//a[@title='Obriši artikl']/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/section/div/form/div[1]/div/div/div/div[3]/a")).click();
        Thread.sleep(3000);
        WebElement messageLabel = driver.findElement(By.xpath("//section[@id='product']//h1[@class='heading2']"));
        Thread.sleep(3000);
        Assert.assertEquals(messageLabel.getText(), expectedAddToBasketMessage);
        System.out.print(messageLabel.getText());
    }

    @Test
    public void PcShopRegistrationTest() throws InterruptedException {
        Random rand = new Random();
        int randomString = rand.nextInt(100);
        int at = globalEmail.indexOf('@');
        newEmail = globalEmail.substring(0, at) + Integer.toString(randomString) + globalEmail.substring(at);
        driver.findElement(By.xpath("/html/body/div[@class='header-wrap']/div[@class='headerbg']/div[@class='container']/div[@class='col-lg-12 rp']/div[2]/ul//a[@href='https://www.pcshop.hr/account-create.asp']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='email']")).sendKeys(newEmail);

        driver.findElement(By.xpath("/html//input[@id='passlog']")).sendKeys(globalPassword);
        driver.findElement(By.xpath("/html//input[@id='passlog2']")).sendKeys(globalPassword);
        driver.findElement(By.xpath("/html//input[@id='prezime']")).sendKeys("Ivic");
        driver.findElement(By.xpath("/html//input[@id='ime']")).sendKeys("Ivo");
        driver.findElement(By.xpath("/html//input[@id='adresa']")).sendKeys("Ante Starčevića 482");
        driver.findElement(By.xpath("/html//input[@id='posta']")).sendKeys("10000");
        driver.findElement(By.xpath("/html//input[@id='mjesto']")).sendKeys("Zagreb");
        driver.findElement(By.xpath("/html//input[@id='telefon']")).sendKeys("0982134211");
        Select dayDropDown = new Select(driver.findElement(By.xpath("/html//select[@id='Bdan']")));
        dayDropDown.selectByValue("14");
        Select monthDropDown = new Select(driver.findElement(By.xpath("/html//select[@id='Bmjesec']")));
        monthDropDown.selectByValue("12");
        Select yearDropDown = new Select(driver.findElement(By.xpath("/html//select[@id='Bgodina']")));
        yearDropDown.selectByValue("1997");
        driver.findElement(By.xpath("/html//input[@id='gdpr']")).click();
        driver.findElement(By.xpath("/html//input[@id='gumblog']")).click();
        WebElement messageLabel = driver.findElement(By.xpath("/html/body/div[@class='header-wrap']/div[@class='headerbg']/div[@class='container']/div[@class='col-lg-12 rp']/div[2]/ul//a[@href='/index.asp?MM_Logoutnow=1']/span[.='Odjava']"));
        Assert.assertEquals(messageLabel.getText(), loginRegisterExpectedMessage);
        System.out.print(messageLabel.getText());
    }

    @Test(dependsOnMethods = {"PcShopRegistrationTest"})
    public void PcShopLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[@class='header-wrap']/div[@class='headerbg']/div[@class='container']/div[@class='col-lg-12 rp']/div[2]/ul//a[@href='https://www.pcshop.hr/login.asp']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys(newEmail);
        driver.findElement(By.xpath("/html//input[@id='pass']")).sendKeys(globalPassword);
        driver.findElement(By.xpath("/html//section[@id='product']/div[@class='container']//div[@class='col-lg-12']/section[2]//form[@action='/login.asp']/div[3]/input")).click();
        WebElement messageLabel = driver.findElement(By.xpath("/html/body/div[@class='header-wrap']/div[@class='headerbg']/div[@class='container']/div[@class='col-lg-12 rp']/div[2]/ul//a[@href='/index.asp?MM_Logoutnow=1']/span[.='Odjava']"));
        Assert.assertEquals(messageLabel.getText(), loginRegisterExpectedMessage);
        System.out.print(messageLabel.getText());
    }

    @Test
    public void PcShopPickCategoryTest() throws InterruptedException {
        driver.manage().window().maximize();
        Actions hover = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("/html/body/div[@class='container']/div[1]/div/ul/li[3]/a[@title='KOMPONENTE']"));
        hover.moveToElement(category).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[@class='container']/div[1]/div/ul/li[3]/div/div[@class='col-lg-12 col-sm-12 rp']/div[1]/ul[@class='hidden-xs']/li[2]/a[@title='Grafičke kartice Asus']")).click();
        WebElement messageLabel = driver.findElement(By.xpath("//div[@id='product-list-wrapper']//h1[1]"));
        Assert.assertEquals(messageLabel.getText(), expectedCategoryPickMessage);
        System.out.print(messageLabel.getText());
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}

