package request_repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import common_method.getData;

public class GetRequestRepository {
	
		public static String baseuri()
		{
			String baseuri = "https://reqres.in/";
			return baseuri ;
		}
		public static String resource()
		{
			String resource = "api/users?page=2";
			return resource ; 
		}
	
		public static void getExpectRspTc1() throws IOException
		{
			ArrayList<ArrayList<String>> arrayData = new ArrayList<ArrayList<String>>();
			String projectPath = System.getProperty("user.dir");
			
			
			FileInputStream fis = new FileInputStream(projectPath+"./excel testdata/test_data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
				String sheetname = workbook.getSheetName(1);
	           System.out.println(sheetname);
		
           
            	System.out.println();
            	//step 4 access the sheet and iterate through row to fetch the column in which testcase is present
				  XSSFSheet sheet = workbook.getSheetAt(1);
				  System.out.println("hi1");
				 Iterator<Row> rows = sheet.iterator();
				  Row firstRow = rows.next();
				  System.out.println("hi2");
			for(int i=0 ; rows.hasNext();i++)
			  {
				System.out.println("hi");
				  Row dataRow = rows.next();
					Iterator<Cell> dataCellValue = dataRow.cellIterator();
					for(int j=0 ; dataCellValue.hasNext();j++)
					{
						DataFormatter formate = new DataFormatter();
						String testData =formate.formatCellValue(dataCellValue.next());
						arrayData.get(j).add(testData);
						System.out.println(arrayData);
											    
					}
			
			
			  }
			System.out.println(arrayData);
			}
				}
			
		

		