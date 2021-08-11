package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataProvider {
	public String[][] readData(String fileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowNumber = sheet.getLastRowNum();
		
		int cellNumber =sheet.getRow(0).getLastCellNum();
		
		
		String[][]data = new String[rowNumber][cellNumber];
		
		for(int i=1; i<=rowNumber; i++)
			
			for (int j=0; j<cellNumber; j++)
			{
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = text;
			}
		
		wb.close();
		
		return data;
	}

}
