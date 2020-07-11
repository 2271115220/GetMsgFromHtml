import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\aaaaaa.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
        sheet = workbook.createSheet("Test");//创建工作表(Sheet)


        System.setProperty("webdriver.chrome.driver", "F:\\RES\\chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();

        chromeoptions.addArguments("--headless");//无头浏览

        WebDriver driver = new ChromeDriver();//传入chromeoptions对象
        driver.get("https://www.zujuan.com/");
        By by = By.className("top-login-item");

        WebElement element = driver.findElement(by);
        String loginUrl = element.getAttribute("href");
        driver.get(loginUrl);

        By userName = By.id("user-name");
        WebElement uName = driver.findElement(userName);
        uName.sendKeys("13276382531");

        By userPwd = By.id("user-pwd");
        WebElement uPwd = driver.findElement(userPwd);
        uPwd.sendKeys("123456");

        By loginBtn = By.className("btn");
        WebElement loginBtnE = driver.findElement(loginBtn);
        loginBtnE.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("https://www.zujuan.com/question/index?xd=1&chid=2");
//
        By classBy = By.className("items");
        WebElement div = driver.findElement(classBy);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By aaa = By.tagName("ul");
        WebElement ul = div.findElement(aaa);
//        System.out.println(ul.getText());

        By bbb = By.className("question-block");
        List<WebElement> ulbbb = div.findElements(bbb);

        for (int i = 0; i < ulbbb.size(); i++) {
            try {
                ulbbb.get(i).click();
            } catch (Exception e) {

            }

        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By by1all = By.xpath("//*");
        WebElement element1 = driver.findElement(by1all);

        String outerHTML = element1.getAttribute("outerHTML");


        Document doc = null;
        try {
            doc = Jsoup.parse(outerHTML, "UTF-8");
            Elements items = doc.getElementsByClass("QUES_LI");

            for (int i = 0; i < items.size(); i++) {

                Element item = items.get(i);

                Elements img = item.getElementsByTag("img");

                for (int j = 0; j < img.size(); j++) {
//                    Element img_item = img.get(j);
//
//                    if (img_item.hasAttr("_src")) {
//
//                        String _src = img_item.attr("_src");
//                        if (_src != null) {
//                            img_item.attr("_src", "https://" + _src.substring(2, _src.length()));
//                        }
//                    }
//
//                    if (img_item.hasAttr("src")) {
//
//                        String _src = img_item.attr("src");
//                        if (_src != null) {
//                            img_item.attr("src", "https://" + _src.substring(2, _src.length()));
//                        }
//
//                    }

                }


                HSSFRow row = sheet.createRow(i);// 创建行,从0开始
                HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
                cell.setCellValue("" + item.outerHtml() + "");// 设置单元格内容
            }



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
//
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);//保存Excel文件
            out.close();//关闭文件流
            System.out.println("OK!");
        } catch (Exception e) {

        }
    }
}
