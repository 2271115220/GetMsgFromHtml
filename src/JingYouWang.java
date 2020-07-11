import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JingYouWang {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\aaaaaa.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
        sheet = workbook.createSheet("Test");//创建工作表(Sheet)


        System.setProperty("webdriver.chrome.driver", "F:\\RES\\chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();

        chromeoptions.addArguments("--headless");//无头浏览

        WebDriver driver = new ChromeDriver();//传入chromeoptions对象
        driver.get("http://www.jyeoo.com/math/ques/search");


        By homeDialog = By.className("tcenter");
        WebElement element = driver.findElement(homeDialog);
        element.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor driver_js = ((JavascriptExecutor) driver);
        //利用js代码键入搜索关键字
        driver_js.executeScript("openLoginUI();");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By by = By.className("btn");
        WebElement zhd = driver.findElement(by);

        setAttribute(zhd,driver,"style","display: block;");


//        for (int i = 0; i < elements.size(); i++) {
//            WebElement webElement = elements.get(i);
//
//        }

//        By by1all = By.xpath("//*");
//        WebElement element1 = driver.findElement(by1all);
//
//        String outerHTML = element1.getAttribute("outerHTML");
//
//
//        Document doc = null;


//        HSSFRow row = sheet.createRow(i);// 创建行,从0开始
//        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
//        cell.setCellValue("" + item.outerHtml() + "");// 设置单元格内容


//        By bbb2 = By.className("question-block");
//        List<WebElement> ulbbb2 = div.findElements(bbb2);
//
//        for (int i = 0; i < ulbbb2.size(); i++) {
//            try {
//
//                WebElement webElement = ulbbb2.get(i);
//                String aaaa = webElement.getText();
//
//                HSSFRow row = sheet.createRow(i);// 创建行,从0开始
//                HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
//                cell.setCellValue(aaaa);// 设置单元格内容
//                System.out.println("" + aaaa);
//            } catch (Exception e) {
//
//            }
//
//        }
//
//

//        FileOutputStream out = new FileOutputStream(filePath);
//        workbook.write(out);//保存Excel文件
//        out.close();//关闭文件流
//        System.out.println("OK!");
    }
    public static void setAttribute(WebElement e, WebDriver d, String attributeName, String value) {
        JavascriptExecutor js = (JavascriptExecutor) d;
        // 执行JavaScriptdiamante修改页面元素属性。arguments[0]-[2]后面会用e,attributeName,value替换并执行
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", e, attributeName, value);
    }


}
