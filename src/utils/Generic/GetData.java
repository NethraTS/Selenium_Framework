package utils.Generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {

	public static String FromExcel(String filepath, String sName, int RowIndex, int ColumnIndex) {
		String str = null;
		try {
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sName);
			Row r = s.getRow(RowIndex);
			Cell c = r.getCell(ColumnIndex);
			str = c.toString();

		} catch (Exception e) {

		}
		return str;
		
		
	}
	

}
