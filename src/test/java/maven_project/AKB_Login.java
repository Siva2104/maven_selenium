package maven_project;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class AKB_Login {
protected WebDriver driver  ;

 String parentWindowHandle;

	@Test (alwaysRun = true , description="Lauching the Browser")
	public void browser() throws InterruptedException, AWTException, IOException {
/////////////////////////////////////////////////////
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1925566\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("application_link");
		driver.manage().window().maximize();
		System.out.println("Lauching Browser");
		FileInputStream fs = new FileInputStream("C:\\BFSI_test\\automation\\login_test.xlsx");
		//Creating a workbook   (String.valueOf(version))
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int username2=(int) sheet.getRow(7).getCell(0).getNumericCellValue();
		System.out.println(username2);
		String password1=sheet.getRow(7).getCell(1).getStringCellValue();
		System.out.println(password1);
		driver.findElement(By.id("eud")).sendKeys(String.valueOf(username2));
		driver.findElement(By.id("epd")).sendKeys(password1);

		driver.findElement(By.id("login")).click();
		 parentWindowHandle = driver.getWindowHandle();

	}

}
