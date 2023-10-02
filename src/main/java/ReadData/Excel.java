package ReadData;



import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {
    
	
	String xlFilepath = "";
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	HashMap<String,Integer> colNums = null;
	FileInputStream fis = null;
	int rowCount = 0;
	
	
	
	public Excel( String xlFilepath) {
		 
		try {
			
			this.xlFilepath = xlFilepath;
			
		FileInputStream fis = new FileInputStream(new File(this.xlFilepath));
		
		System.out.println("File Input Stream successfully added ....");
		
		wb = new XSSFWorkbook(fis);
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	public void setSheet(String sheetName) {
		
		sheet = wb.getSheet(sheetName);
		populatedColumnNums();
		rowCount = sheet.getLastRowNum();
		
	}
	
	public int getRowCount() {
		
		return rowCount+1;
		
	}
	
	public void populatedColumnNums() {
		
		colNums = new HashMap<String,Integer>();
		int colIndex = 0;
		
		Row row = sheet.getRow(0);
		Iterator<Cell> cells = row.cellIterator();
		
		while(cells.hasNext()) {
			
			Cell cell = cells.next();
			String colName  = cell.getStringCellValue();
			colNums.put(colName, colIndex);
			colIndex++;
			
		}
		
	}
	
	public int getColNumber(String colName) {
		
		return colNums.get(colName);
		
	}
	
	
    public String getCellData(int rowNum, String colName) {
    	
		String ret = "";
		int colNum = getColNumber(colName);
		ret = getCellData(rowNum, colNum);
		
		return ret;
	}
	
	public String getCellData( int rowNum, int colNum) {
		
		String  ret = "";
		
		try {
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		
		if(cell.getCellType() == CellType.STRING) {
			
			ret = cell.getStringCellValue();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
	
	public void readSheetData() {
		Iterator<Row> rows = sheet.iterator(); 
		
		while(rows.hasNext())
		{
			Row currRow = rows.next();
			Iterator<Cell> cells = currRow.cellIterator();
			
			while(cells.hasNext())
				
			{
				
				Cell currCell = cells.next();
				CellType cType = currCell.getCellType();
				
				String value ="";
				
				if(cType == CellType.STRING) 
				{
					 value = currCell.getStringCellValue();
				}
				else if(cType == CellType.NUMERIC) {
					value = "" + currCell.getNumericCellValue();
				}
				
				
				
				System.out.println("Value for cell " + value);
			}
		}
	}
	
	
	public void close() {
		try {
			 
			if(fis!= null) 
			{
				fis.close();
				wb.close();
			}
		}
		catch(Exception e) {
			
		}
	}

}
