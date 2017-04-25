package utility;


import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtils {
	
	static FileInputStream fs = null;
	static Workbook wb = null;
	static Sheet sh = null;	

	public Sheet setExcelFile(String Path,String SheetName) throws IOException {
		try
		{
			//System.out.println("setExcelFile");
			String path1 = Constant.PATH_TESTDATA+"/"+Constant.File_TestData;
			FileInputStream fs = new FileInputStream(path1);
			Workbook wb = Workbook.getWorkbook(fs);
			//System.out.println("wb:"+wb);
			Sheet sh = wb.getSheet(SheetName);
			//System.out.println("sh:"+sh);
			return sh;
		}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();

		}
		return sh;
	}
	
	public String getCellData(Sheet s,int ColNum, int RowNum){

		try{
			//System.out.println("RowNum:"+RowNum);
			//System.out.println("ColNum:"+ColNum);
			//System.out.println("s:"+s);
			
			//String CellGetContent = ;
			//System.out.println("*****************"+CellGetContent);
						
			return s.getCell(RowNum,ColNum).getContents();
		
		}catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
			return "";
		}
	}

	public static int getCellData1(Sheet s,int ColNum, int RowNum){

		try{
			
			// To get the number of rows present in sheet
			/*int totalNoOfRows = s.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = s.getColumns();

			for (int row = 0; row < totalNoOfRows; row++) {

				for (int col = 0; col < totalNoOfCols; col++) {
					System.out.print(s.getCell(col, row).getContents() + "\t");
				}
				System.out.println();
			}*/
		
			//System.out.println("RowNum:"+RowNum);
			//System.out.println("ColNum:"+ColNum);
			
			String CellGetContent = s.getCell(RowNum,ColNum).getContents();
			//int i_CellGetContent = ;
			//System.out.println("**********"+CellGetContent);
						
			return Integer.parseInt(CellGetContent);
		
		}catch (Exception e){
			System.out.println(e);
			return 0;
		}
	}
	
	/*public static void setCellData(String Result,  int RowNum, int ColNum,String FilePath) throws Exception	{      	
		try{
			row = sheet.getRow(RowNum);
			if (row == null)
				row = sheet.createRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null)
				cell = row.createCell(ColNum);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(Result);

			// Write the output to a file
			fileOut = new FileOutputStream(FilePath);
			wb.write(fileOut);

		} finally {
			if (fileOut != null)
				fileOut.close();
			if (fileIn != null)
				fileIn.close();
		}
	}*/
	

}
