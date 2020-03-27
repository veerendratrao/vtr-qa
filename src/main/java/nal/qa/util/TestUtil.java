package nal.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;

//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.NumberToTextConverter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import nal.qa.base.TestBase;

public class TestUtil extends TestBase {
public static long PAGE_LOAD_TIMEOUT = 60;
public static long IMPLICIT_WAIT = 60;

static Workbook book;
static Sheet sheet;

public static String TESTDATA_SHEET_PATH = System.clearProperty("user.dir")+"/src/main/java/nal/qa/testdata/NalE2E.xlsx";

public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	System.out.println(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println(sheet.getLastRowNum() + "--------" +
	 sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = new DataFormatter().formatCellValue(sheet.getRow(i + 1).getCell(k)).toString();
			System.out.println(data[i][k]);	
		}
	}
	return data;
}

/*public ArrayList<String> getdata(String testCaseName) throws IOException
{
	ArrayList<String> a=new ArrayList<String>();
	// TODO Auto-generated method stub
	FileInputStream fis=new FileInputStream(System.clearProperty("user.dir")+"/src/main/java/nal/qa/testdata/NalE2E.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
		{
		XSSFSheet sheet=workbook.getSheetAt(i);
		Iterator<Row> rows=sheet.iterator();
		Row firstrow=rows.next();
		Iterator<Cell> cell=firstrow.cellIterator();
		int k=0;
		int column=0;
		while(cell.hasNext())
		{
		Cell value=cell.next();
		if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				{
			       column=k;
				}
		k++;
	}
		//System.out.println(column);
		
		while(rows.hasNext())
		{
			Row r=rows.next();
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				Iterator<Cell> cv=r.cellIterator();
				while(cv.hasNext())
				{
					Cell c=cv.next();
					if(c.getCellTypeEnum()==CellType.STRING)
					{
					a.add(c.getStringCellValue());
				}
					else
					{
						
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
			}
			
		}
  }

}
	
}
	workbook.close();
	return a;
	
}*/

}

