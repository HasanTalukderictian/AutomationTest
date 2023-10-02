package ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		
		File file = new File("H:\\Excel file\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook  workbook = new XSSFWorkbook(fis);
		XSSFSheet  sheet = workbook.getSheetAt(0);
		
		String cellvalue = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cellvalue);
		
//		int rowCount = sheet.getPhysicalNumberOfRows();
//		
//		for(int i =0; i<rowCount; i++) {
//			XSSFRow  row = sheet.getRow(i);
//			
//			int cellCount  = row.getPhysicalNumberOfCells();
//			
//			for(int j =0; j< cellCount; j++) {
//				
//			}
//		}
		
//		int rowCount = sheet.getLastRowNum();
//		System.out.println("Total number of rows is "+ rowCount);
//		
		workbook.close();
		fis.close();
		
		 System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\Chrome\\chromedriver.exe");
		 
		
	        // Add options here, if needed

	        // Create a new instance of the ChromeDriver
	        ChromeDriver driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        Thread.sleep(2000);
	        
	        
	        List <WebElement > list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sb11']"));
	        
	        System.out.println(list.size());

	        // Navigate to the Google homepage
	        driver.get("https://www.google.com");

	        // Find the search input element by its name attribute (in this case, "q")
	        
              driver.findElement(By.xpath("//*[@title='সার্চ করুন']")).sendKeys(cellvalue);
              
//	        driver.findElement(By.name("q")).sendKeys(cellvalue);

	        // Enter a search query (e.g., "Selenium automation") into the search input
	       
	        

	}

}
