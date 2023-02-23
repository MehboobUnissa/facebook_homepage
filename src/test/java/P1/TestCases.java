package P1;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class TestCases {

    WebDriver driver;
    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("kristianastewert210@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Mehboob@21");
        driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\"]"))
                .click();

        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery( Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.textMatches(
                By.xpath("(//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6\"])[1]"),
                Pattern.compile("Mehboob Unissa")));
        String user = driver.findElement(By.xpath("(//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6\"])[1]"))
                .getText();
        Assert.assertEquals(user, "Mehboob Unissa");
    }

   @Test(priority = 1)
    public void searchPerson() throws InterruptedException {
        //search
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@aria-label=\"Search Facebook\"]"))));
        driver.findElement(By.xpath("//input[@aria-label=\"Search Facebook\"]"))
                .sendKeys("Mehboob");
        driver.findElement(By.xpath("//div[@class=\"x9f619 xdt5ytf xh8yej3 x1lliihq x1n2onr6 xhq5o37 x1qxoq08 x1cpjm7i x1ryaae9 x1hmns74 x1mhyesy x1y3wzot xaqea5y x30kzoy x9jhf4c x1b1mbwd xav7gou x6umtig x9lpf2z x1eqyvvh xfbg1o9 x1kphnah x1de4urk xyt8op7\"]"))
                .isDisplayed();
    }

    @Test(priority = 2)
    public void searchPage() throws InterruptedException {
        //search
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@aria-label=\"Search Facebook\"]"))));
        driver.findElement(By.xpath("//input[@aria-label=\"Search Facebook\"]"))
                .sendKeys("laughing colours");
        driver.findElement(By.xpath("//div[@class=\"x9f619 xdt5ytf xh8yej3 x1lliihq x1n2onr6 xhq5o37 x1qxoq08 x1cpjm7i x1ryaae9 x1hmns74 x1mhyesy x1y3wzot xaqea5y x30kzoy x9jhf4c x1b1mbwd xav7gou x6umtig x9lpf2z x1eqyvvh xfbg1o9 x1kphnah x1de4urk xyt8op7\"]"))
                .isDisplayed();
        driver.get("https://www.facebook.com/");
    }

    @Test(priority = 3)
    public void clickIcons() throws InterruptedException {
        //friends
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class=\"x1n2onr6\"])[2]")))).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]"))
                       .isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]")).isDisplayed());
        Thread.sleep(9000);
        String friends = driver.findElement(By.xpath(("(//div[@class=\"x78zum5 xdt5ytf x11tup63 x16z1lm9\"])[2]"))).getText();
        Assert.assertEquals(friends,"Friends");

        //watch
        driver.findElement(By.xpath("(//span[@class=\"x1n2onr6\"])[3]")).click();
        Thread.sleep(5000);
        String watch = driver.findElement(By.xpath("(//h1[@class=\"x1heor9g x1qlqyl8 x1pd3egz x1a2a7pz\"])[3]"))
                .getText();
        Assert.assertEquals(watch,"Watch");
      //market
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class=\"x1n2onr6\"])[4]")).click();
        Thread.sleep(5000);
        String market = driver.findElement(By.xpath("(//span[@class=\"x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x14z4hjw x3x7a5m xngnso2 x1qb5hxa x1xlr1w8 xzsf02u x1yc453h\"])[2]"))
                .getText();
        Assert.assertEquals(market,"Marketplace");
        //groups
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class=\"x1n2onr6\"])[5]")).click();
        Thread.sleep(5000);
        String groups = driver.findElement(By.xpath("(//div[@class=\"xwoyzhm x1rhet7l\"])[2]"))
                .getText();
        Assert.assertEquals(groups,"Groups");
    }

    @Test(priority = 4)
    public void searchStoriesReels() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x9f619 x78zum5 x2lah0s x1hshjfz x1n2onr6 x1iyjqo2 xng8ra xl56j7k xznra1h\"])[1]"))
                .click();
        driver.findElement(By.xpath("//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"]"))
                .isDisplayed();
        Assert.assertTrue
                (driver.findElement(By.xpath("//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"]"))
                        .isDisplayed());
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x9f619 x78zum5 x2lah0s x1hshjfz x1n2onr6 x1iyjqo2 xng8ra xl56j7k xznra1h\"])[2]"))
                .click();
        driver.findElement(By.xpath("(//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"])[1]"))
            .isDisplayed();
        Thread.sleep(5000);
        Assert.assertTrue
                (driver.findElement(By.xpath("(//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"])[1]")).isDisplayed());
    }

    @Test(priority = 5)
    public void statusTab() throws InterruptedException {
        //live
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[1]"))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x1iyjqo2 x2lwn1j\"])[5]"))
                .isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x1iyjqo2 x2lwn1j\"])[5]"))
                .isDisplayed());
        //home
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);

        //photo
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[2]"))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=\"x6s0dn4 xua58t2 x9f619 x78zum5 xng8ra xl56j7k\"]"))
                .isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"x6s0dn4 xua58t2 x9f619 x78zum5 xng8ra xl56j7k\"]"))
                .isDisplayed());

        //clickback
        driver.findElement(By.xpath("//div[@class=\"x1i10hfl x6umtig x1b1mbwd xaqea5y xav7gou x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x14yjl9h xudhj91 x18nykt9 xww2gxu x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 xc9qbxq x14qfxbe x1qhmfi1\"]"))
                .click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/"));

        //react
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[3]"))
                .click();
        driver.findElement(By.xpath("(//div[@class=\"x1uvtmcs x4k7w5x x1h91t0o x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1n2onr6 x1qrby5j x1jfb8zj\"])[3]"))
                .isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class=\"x1uvtmcs x4k7w5x x1h91t0o x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1n2onr6 x1qrby5j x1jfb8zj\"])[3]"))
                .isDisplayed());
        //back
        driver.findElement(By.xpath("(//div[@class=\"x1i10hfl x6umtig x1b1mbwd xaqea5y xav7gou x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x14yjl9h xudhj91 x18nykt9 xww2gxu x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 xc9qbxq x14qfxbe x1qhmfi1\"])[2]"))
                .click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/"));
    }

    @Test(priority = 6)
    public void commentsLike() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft\"])[1]"))
                 .click();
        driver.findElement(By.xpath("(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft\"])[2]"))
                .click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//div[@class=\"xzsf02u x1a2a7pz x1n2onr6 x14wi4xw notranslate\"]"))
                .sendKeys("Nice pic");
        String text = driver.findElement(By.xpath("//div[@class=\"xzsf02u x1a2a7pz x1n2onr6 x14wi4xw notranslate\"]"))
                .getText();
        Assert.assertEquals(text,"Nice pic");
    }

    @Test(priority = 7)
    public void createGroup() throws InterruptedException {
        //driver.get("https://www.facebook.com/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x1q0q8m5 x1qhh985 xu3j5b3 xcfux6l x26u7qi xm0m39n x13fuv20 x972fbf x9f619 x78zum5 x1q0g3np x1iyjqo2 xs83m0k x1qughib xat24cr x11i5rnm x1mh8g0r xdj266r xeuugli x18d9i69 x1sxyh0 xurb0ha xexx8yu x1n2onr6 x1ja2u2z x1gg8mnh\"])[50]"))
                .click();
        Thread.sleep(30000);
        driver.findElement(By.xpath("//div[@class=\"x6s0dn4 xcrg951 xgqcy7u x1lq5wgf x78zum5 x2lah0s x10w6t97 x1qughib x6ikm8r x10wlt62 x1y1aw1k x1sxyh0 xwib8y2 xurb0ha x1n2onr6 xhtitgo\"]"))
                .isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"x6s0dn4 xcrg951 xgqcy7u x1lq5wgf x78zum5 x2lah0s x10w6t97 x1qughib x6ikm8r x10wlt62 x1y1aw1k x1sxyh0 xwib8y2 xurb0ha x1n2onr6 xhtitgo\"]")).isDisplayed());

        driver.findElement(By.xpath("//input[@class=\"xjbqb8w x76ihet xwmqs3e x112ta8 xxxdfa6 x9f619 xzsf02u xt0psk2 x1jchvi3 x1fcty0u x132q4wb x1xmf6yo x1emribx x1e56ztr x1i64zmx x193iq5w x1a2a7pz xtt52l0 x1a8lsjc xo6swyp x1ad04t7 x1glnyev x1ix68h3 x19gujb8\"]"))
                .sendKeys("Ak K");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x1ypdohk x78zum5 x6ikm8r x10wlt62 x1n2onr6 x1lq5wgf xgqcy7u x30kzoy x9jhf4c xdj266r xat24cr x1y1aw1k x1sxyh0 xwib8y2 xurb0ha x8du52y\"])[1]"))
                .click();
        driver.findElement(By.xpath("//input[@class=\"xjbqb8w x76ihet xwmqs3e x112ta8 xxxdfa6 x9f619 xzsf02u xt0psk2 x1jchvi3 x1fcty0u x132q4wb x1xmf6yo x1emribx x1e56ztr x1i64zmx x193iq5w x1a2a7pz xtt52l0 x1a8lsjc xo6swyp x1ad04t7 x1glnyev x1ix68h3 x19gujb8\"]"))
                .sendKeys("Harshada Marne");
        driver.findElement(By.xpath("(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli x1qughib x6s0dn4 xozqiw3 x1q0g3np xykv574 xbmpl8g x4cne27 xifccgj\"])[2]"))
                .click();
        Thread.sleep(5000);
        String group = driver.findElement(By.xpath("//span[@class=\"x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x4zkp8e x676frb x1nxh6w3 x1sibtaa x1fcty0u xi81zsa x2b8uid\"]"))
                .getText();
        Assert.assertEquals(group, "You created this group");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
