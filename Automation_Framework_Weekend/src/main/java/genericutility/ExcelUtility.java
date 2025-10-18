package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Vandana
 */

public class ExcelUtility {
	
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getStringDataExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	}

	public boolean getBooleanDataExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getBooleanCellValue();
}
	
	public double getNumberDataExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
}
	
	public LocalDateTime getDateAndTimeStringDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getLocalDateTimeCellValue();
		
	}
}