package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[@class=\"x1n2onr6\"])[2]")
    private WebElement clickFriend;

    @FindBy(xpath = "(//span[@class=\"x1n2onr6\"])[3]")
    private WebElement clickWatch;

    @FindBy(xpath = "(//span[@class=\"x1n2onr6\"])[4]")
    private WebElement clickMarketPlace;

    @FindBy(xpath = "(//span[@class=\"x1n2onr6\"])[5]")
    private WebElement clickGroups;

    @FindBy(xpath = "//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]")
    private WebElement displayFriend;

    @FindBy(xpath = "//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]")
    private WebElement displayWatch;

    @FindBy(xpath = "//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]")
    private WebElement displayMarketPlace;

    public WebElement getClickFriend() {
        return clickFriend;
    }

    public WebElement getClickWatch() {
        return clickWatch;
    }

    public WebElement getClickMarketPlace() {
        return clickMarketPlace;
    }

    public WebElement getClickGroups() {
        return clickGroups;
    }

    public WebElement getDisplayFriend() {
        return displayFriend;
    }

    public WebElement getDisplayWatch() {
        return displayWatch;
    }

    public WebElement getDisplayMarketPlace() {
        return displayMarketPlace;
    }

    public WebElement getDisplayGroups() {
        return displayGroups;
    }

    @FindBy(xpath = "//div[@class=\"x78zum5 xdt5ytf x10cihs4 x1t2pt76 x1n2onr6 x1ja2u2z\"]")
    private WebElement displayGroups;


    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x9f619 x78zum5 x2lah0s x1hshjfz x1n2onr6 x1iyjqo2 xng8ra xl56j7k xznra1h\"])[1]")
    private WebElement clickStory;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x9f619 x78zum5 x2lah0s x1hshjfz x1n2onr6 x1iyjqo2 xng8ra xl56j7k xznra1h\"])[2]")
    private WebElement clickReels;

    @FindBy(xpath = "//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"]")
    private WebElement displayStories;

    public WebElement getClickStory() {
        return clickStory;
    }

    public WebElement getClickReels() {
        return clickReels;
    }

    public WebElement getDisplayStories() {
        return displayStories;
    }

    public WebElement getDisplayReels() {
        return displayReels;
    }

    @FindBy(xpath = "(//div[@class=\"xb57i2i x1q594ok x5lxg6s x78zum5 xdt5ytf x10wlt62 x1n2onr6 x1ja2u2z x1pq812k xfk6m8 x1yqm8si xjx87ck xw2csxc x7p5m3t x9f619 xat24cr xwib8y2 x1y1aw1k x1rohswg xhfbhpw\"])[1]")
    private WebElement displayReels;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[1]")
    private WebElement clickLive;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[2]")
    private WebElement clickPhoto;

   @FindBy(xpath = "//div[@class=\"x1i10hfl x6umtig x1b1mbwd xaqea5y xav7gou x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x14yjl9h xudhj91 x18nykt9 xww2gxu x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 xc9qbxq x14qfxbe x1qhmfi1\"]")
    private WebElement clickBack;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x78zum5 xl56j7k x1rfph6h x6ikm8r x10wlt62\"])[3]")
    private WebElement clickReact;

    @FindBy(xpath = "(//div[@class=\"x1i10hfl x6umtig x1b1mbwd xaqea5y xav7gou x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8 x1hl2dhg xggy1nq x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x14yjl9h xudhj91 x18nykt9 xww2gxu x972fbf xcfux6l x1qhh985 xm0m39n x9f619 x78zum5 xl56j7k xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 xc9qbxq x14qfxbe x1qhmfi1\"])[2]")
    private WebElement clickBack1;

    @FindBy(xpath = " (//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x1iyjqo2 x2lwn1j\"])[5]")
    private WebElement liveClicked;

    @FindBy(xpath = " //div[@class=\"x6s0dn4 xua58t2 x9f619 x78zum5 xng8ra xl56j7k\"]")
    private WebElement photoClicked;

    public WebElement getClickLive() {
        return clickLive;
    }

    public WebElement getClickPhoto() {
        return clickPhoto;
    }

    public WebElement getClickBack() {
        return clickBack;
    }

    public WebElement getClickReact() {
        return clickReact;
    }

    public WebElement getClickBack1() {
        return clickBack1;
    }

    public WebElement getLiveClicked() {
        return liveClicked;
    }

    public WebElement getPhotoClicked() {
        return photoClicked;
    }

    public WebElement getReactClicked() {
        return reactClicked;
    }

    @FindBy(xpath = " (//div[@class=\"x1uvtmcs x4k7w5x x1h91t0o x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1n2onr6 x1qrby5j x1jfb8zj\"])[3]")
    private WebElement reactClicked;

    public WebElement getClickLike() {
        return clickLike;
    }

    public WebElement getClickComment() {
        return clickComment;
    }

    public WebElement getTypeComment() {
        return typeComment;
    }

    public WebElement getPostCommented() {
        return postCommented;
    }

    @FindBy(xpath = "(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft\"])[1]")
    private WebElement clickLike;

    @FindBy(xpath = "(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft\"])[2] ")
    private WebElement clickComment;

    @FindBy(xpath = "//div[@class=\"xzsf02u x1a2a7pz x1n2onr6 x14wi4xw notranslate\"]")
    private WebElement typeComment;

    @FindBy(xpath = "//div[@class=\"xzsf02u x1a2a7pz x1n2onr6 x14wi4xw notranslate\"]")
    private WebElement postCommented;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x1q0q8m5 x1qhh985 xu3j5b3 xcfux6l x26u7qi xm0m39n x13fuv20 x972fbf x9f619 x78zum5 x1q0g3np x1iyjqo2 xs83m0k x1qughib xat24cr x11i5rnm x1mh8g0r xdj266r xeuugli x18d9i69 x1sxyh0 xurb0ha xexx8yu x1n2onr6 x1ja2u2z x1gg8mnh\"])[50]")
    private WebElement createGroup;

    @FindBy(xpath = "//div[@class=\"x6s0dn4 xcrg951 xgqcy7u x1lq5wgf x78zum5 x2lah0s x10w6t97 x1qughib x6ikm8r x10wlt62 x1y1aw1k x1sxyh0 xwib8y2 xurb0ha x1n2onr6 xhtitgo\"]")
    private WebElement displayGroup;

    @FindBy(xpath = "//input[@class=\"xjbqb8w x76ihet xwmqs3e x112ta8 xxxdfa6 x9f619 xzsf02u xt0psk2 x1jchvi3 x1fcty0u x132q4wb x1xmf6yo x1emribx x1e56ztr x1i64zmx x193iq5w x1a2a7pz xtt52l0 x1a8lsjc xo6swyp x1ad04t7 x1glnyev x1ix68h3 x19gujb8\"]")
    private WebElement typeFriends;

    @FindBy(xpath = "(//div[@class=\"x6s0dn4 x1ypdohk x78zum5 x6ikm8r x10wlt62 x1n2onr6 x1lq5wgf xgqcy7u x30kzoy x9jhf4c xdj266r xat24cr x1y1aw1k x1sxyh0 xwib8y2 xurb0ha x8du52y\"])[1]")
    private WebElement addfriend;

    @FindBy(xpath = "(//div[@class=\"x9f619 x1n2onr6 x1ja2u2z x78zum5 x1r8uery x1iyjqo2 xs83m0k xeuugli x1qughib x6s0dn4 xozqiw3 x1q0g3np xykv574 xbmpl8g x4cne27 xifccgj\"])[2]")
    private WebElement addFreind2;

    public WebElement getCreateGroup() {
        return createGroup;
    }

    public WebElement getDisplayGroup() {
        return displayGroup;
    }

    public WebElement getTypeFriends() {
        return typeFriends;
    }

    public WebElement getAddfriend() {
        return addfriend;
    }

    public WebElement getAddFreind2() {
        return addFreind2;
    }

    public WebElement getCreatedGroup() {
        return createdGroup;
    }

    @FindBy(xpath = "//span[@class=\"x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x4zkp8e x676frb x1nxh6w3 x1sibtaa x1fcty0u xi81zsa x2b8uid\"]")
    private WebElement createdGroup;

    public WebElement getSendText() {
        return sendText;
    }

    public WebElement getResultDisplayed() {
        return resultDisplayed;
    }

    @FindBy(xpath="//input[@aria-label=\"Search Facebook\"]")
    private WebElement sendText;

    @FindBy(xpath = "//div[@class=\"x9f619 xdt5ytf xh8yej3 x1lliihq x1n2onr6 xhq5o37 x1qxoq08 x1cpjm7i x1ryaae9 x1hmns74 x1mhyesy x1y3wzot xaqea5y x30kzoy x9jhf4c x1b1mbwd xav7gou x6umtig x9lpf2z x1eqyvvh xfbg1o9 x1kphnah x1de4urk xyt8op7\"]")
    private WebElement resultDisplayed;

    public WebElement getPatternMatches() {
        return patternMatches;
    }

    @FindBy(xpath = "(//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6\"])[14]")
    private WebElement patternMatches;
}




