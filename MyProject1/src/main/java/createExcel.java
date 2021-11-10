import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class createExcel {
	public void main(ArrayList<String> addedFiles,ArrayList<String> deletedFiles,ArrayList<String> modifiedFiles) {
		try {
			WritableWorkbook wb = Workbook.createWorkbook(new File("C:\\bill\\sample.xls"));
			WritableSheet addedFile = wb.createSheet("AddedFiles", 0); 
		//	WritableSheet deletedFiles = wb.createSheet("DeletedFiles", 1); 
		//	WritableSheet modifiedFiles = wb.createSheet("ModifiedFiles", 2); 
for(int length = 0; length<addedFiles.size(); length++) {
			//WritableCell cell = addedFiles.getWritableCell(1, 2); 
			 Label addedData = new Label(0,length,addedFiles.get(length));
//			 Label deletedData = new Label(0,0,"PaymentInstrument.gs");
	//		 Label ModifiedData = new Label(0,0,"ac.etx");

			 try {
				addedFile.addCell(addedData);
//				deletedFiles.addCell(deletedData);
	//			modifiedFiles.addCell(ModifiedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
wb.write();
try {
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
