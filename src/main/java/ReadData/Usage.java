package ReadData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Usage {
   
	public static void main(String rs[])   throws Exception{
		Excel xl = new Excel("H:\\\\Excel file\\\\Book1.xlsx");
		xl.setSheet("Check");
	 
//		xl.readSheetData();
		
		String lastName = xl.getCellData(1, "LastName");
		System.out.println("The lastName value is " + lastName);
		
		
	
		
		//System.out.println("The Colum number is  " + xl.getColNumber("Age"));
		System.out.println("Number of rows in Data sheet is :  " + xl.getRowCount());
		xl.close();
		
		 System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\Chrome\\chromedriver.exe");
		 ChromeDriver driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        Thread.sleep(2000);
	        
	        
	        List <WebElement > list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sb11']"));
	        
	        System.out.println(list.size());

	        // Navigate to the Google homepage
	        driver.get("https://www.google.com");
	        driver.manage().window().maximize();

	        // Find the search input element by its name attribute (in this case, "q")
	        
           driver.findElement(By.xpath("//*[@title='সার্চ করুন']")).sendKeys(lastName);
           Thread.sleep(1000);
          List<WebElement> list1 = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
           
//	        driver.findElement(By.name("q")).sendKeys(cellvalue);
          System.out.println("Search Element :");
          for(WebElement ele: list) {
        	  System.out.println(ele.getText());
          }
	}
}
