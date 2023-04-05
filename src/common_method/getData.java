package common_method;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class getData {
	public static ArrayList<String> getDataExcel(String testSheetName,String testCaseName) throws IOException
	{
		ArrayList<String> arrayData = new ArrayList<String>();
		String projectPath = System.getProperty("user.dir");
		
		//step 1 locate excel data file,by creating the object of fileinputstream
		FileInputStream fis = new FileInputStream(projectPath+"./excel testdata/test_data.xlsx");
		
		//step 2 create the object of XSSFWorkbook to open the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//step 3 access the desired sheet
		//step 3.1 fetch the count of sheets available in the excel file
		int countOfSheet = workbook.getNumberOfSheets();
		
		//step 3.2 fetch the name of sheet and compare against desired sheet name
		for(int i=0;i<countOfSheet;i++)
		{
			String sheetname = workbook.getSheetName(i);
			//System.out.println(sheetname);
			if(sheetname.equalsIgnoreCase(testSheetName))
			{
			  //step 4 access the sheet and iterate through row to fetch the column in which testcase is present
			  XSSFSheet sheet = workbook.getSheetAt(i);
			  //step 4.1 create iterator for rows
			  Iterator<Row> rows = sheet.iterator();
			  Row firstRow = rows.next();
			
			  //step 4.2 create iterator for cells
			  Iterator<Cell> cells = firstRow.cellIterator();
			  int j=0;
			  int tcColumn=0;
			  //step 4.3 read the cell value of row no1 to compare against test case name
			  while(cells.hasNext())
			  {
				  Cell cellValue = cells.next();
				  if(cellValue.getStringCellValue().equalsIgnoreCase("tc_name"))
				  {
					  tcColumn = j;
					  break;
				  }
				  j++;
			  }
			  //step 5 fetch the data for desired test case
			  while(rows.hasNext())
			  {
				  Row dataRow = rows.next();
				  if(dataRow.getCell(tcColumn).getStringCellValue().equalsIgnoreCase(testCaseName))
				  {
					Iterator<Cell> dataCellValue = dataRow.cellIterator();
					while(dataCellValue.hasNext())
					{
						//String testData = dataCellValue.next().toString().replaceAll("\\.\\d+$", "");
						//System.out.println(testData);
						
						DataFormatter formate = new DataFormatter();
						String testData =formate.formatCellValue(dataCellValue.next());
						arrayData.add(testData);
											    
					}
					/*while(dataCellValue.hasNext())
					{
					Cell dataOfCell = dataCellValue.next()
					try
					{
						String testData = dataOfCell.getStringCellValue();
						System.out.println(testData);
					}
					catch (IllegalStateException e)
					{
						//System.out.println(e);
						int inttestData = (int) dataOfCell.getNumericCellValue();
						System.out.println(inttestData);
					}
			    	CellType datatype = dataOfCell.getCellType();
				
     				if (datatype.toString() == "NUMERIC")
				{
					int inttestData = (int) dataOfCell.getNumericCellValue();
					System.out.println(inttestData);
				}
					else if (datatype.toString() == "STRING")
				{
						String testData = dataOfCell.getStringCellValue();
						System.out.println(testData);
					}*/
					
				  }
			  }
			 
		}
   		
	}
      return arrayData;
	}
}
