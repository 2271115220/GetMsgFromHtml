import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class GankaozhuangyuanWang {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\aaaaaa.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
        sheet = workbook.createSheet("Test");//创建工作表(Sheet)


        System.setProperty("webdriver.chrome.driver", "F:\\RES\\chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();

        chromeoptions.addArguments("--headless");//无头浏览

        WebDriver driver = new ChromeDriver();//传入chromeoptions对象
        driver.get("https://soulaoshi.gankao.com/");

        driver.get("https://soulaoshi.gankao.com/user/login");

        By loginInput = By.name("email");
        WebElement loginInputElement = driver.findElement(loginInput);

        loginInputElement.sendKeys("13276382531");


        By passwordInput = By.name("password");
        WebElement passwordInputElement = driver.findElement(passwordInput);

        passwordInputElement.sendKeys("123456");

        By doSubmit = By.id("doSubmit");
        WebElement doSubmitElement = driver.findElement(doSubmit);

        doSubmitElement.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.get("https://ziliao.gankao.com/pc/paperList?grade=1");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By ui = By.className("liItemhover");

        List<WebElement> elements = driver.findElements(ui);

        elements.get(0).click();

        String[] handles = new String[driver.getWindowHandles().size()];

        driver.getWindowHandles().toArray(handles);


        WebDriver handle1 = driver.switchTo().window(handles[1]);
        System.out.println(handle1.getCurrentUrl());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver handle12 = driver.switchTo().window(handles[0]);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elements.get(1).click();
        String[] handles2 = new String[driver.getWindowHandles().size()];

        driver.getWindowHandles().toArray(handles2);

        WebDriver handle13 = driver.switchTo().window(handles2[2]);
        System.out.println(handle13.getCurrentUrl());

    }
}
