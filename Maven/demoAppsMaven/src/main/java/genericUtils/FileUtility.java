package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String fetchFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\eclipse-workspace-Gaurav_Dubey\\Automation\\TestData\\CommonData.properties");
		
		Properties prop= new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
		
		public String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis= new FileInputStream("C:\\Users\\dell\\eclipse-workspace-Gaurav_Dubey\\Automation\\TestData\\ExcelData.xlsx");
			
			return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();

		}
		
		public double fetchNumericdataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis= new FileInputStream("C:\\Users\\dell\\eclipse-workspace-Gaurav_Dubey\\Automation\\TestData\\ExcelData.xlsx");
			
			return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();

		}
	}
