import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class createExcel {
	public static void main(String[] args) {
		try {
			WritableWorkbook wb = Workbook.createWorkbook(new File("C:\\bill\\sample.xls"));
			WritableSheet addedFiles = wb.createSheet("AddedFiles", 0); 
			WritableSheet deletedFiles = wb.createSheet("DeletedFiles", 1); 
			WritableSheet modifiedFiles = wb.createSheet("ModifiedFiles", 2); 

			WritableCell cell = addedFiles.getWritableCell(1, 2); 
			 Label addedData = new Label(0,0,"Account.etx");
			 Label deletedData = new Label(0,0,"PaymentInstrument.gs");
			 Label ModifiedData = new Label(0,0,"ac.etx");

			 try {
				addedFiles.addCell(addedData);
				deletedFiles.addCell(deletedData);
				modifiedFiles.addCell(ModifiedData);
				wb.write();
			    wb.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("created excel sheet");
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
