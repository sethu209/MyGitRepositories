import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ConformityData {
	//create Data
	
		public static void createData(double addedRow,double modifiedRow,double deletedRow,double notChangedRow,double Weight,WritableSheet modifiedFile,String Weightage,boolean weightageorNot) {
			try {

				Label l14 = null;

				try {
					Label l2 = new Label(6, 8, "Change Type", createFormatCellStatus(true));
					Label l3 = new Label(7, 8, "Category", createFormatCellStatus(true));
					Label l4 = new Label(8, 8, "Number of Files", createFormatCellStatus(true));
					Label l5 = new Label(9, 8, "Weighted Files", createFormatCellStatus(true));

					Label l6 = new Label(6, 9, "Not Changed", createFormatCellStatus(false));
					Label l7 = new Label(6, 10, "Added By Customer", createFormatCellStatus(false));
					Label l8 = new Label(6, 11, "Edited By Customer", createFormatCellStatus(false));
					Label l9 = new Label(6, 12, "Deleted By Customer", createFormatCellStatus(false));

					Label l10 = new Label(7, 9, "A", createFormatCellStatus(false));
					Label l11 = new Label(7, 10, "C", createFormatCellStatus(false));
					Label l12 = new Label(7, 11, "B", createFormatCellStatus(false));
					Label l13 = new Label(7, 12, "B", createFormatCellStatus(false));
	                
					if(weightageorNot)
					l14 = new Label(6, 14, Weightage, createFormatCellStatus(false));

					Label l15 = new Label(11, 8, "Category", createFormatCellStatus(true));
					Label l16 = new Label(11, 9, "A", createFormatCellStatus(false));
					Label l17 = new Label(11, 10, "B", createFormatCellStatus(false));
					Label l18 = new Label(11, 11, "C", createFormatCellStatus(false));
					Label l19 = new Label(11, 13, "(B+C)", createFormatCellStatus(false));
					Label l20 = new Label(11, 14, "(A+B)", createFormatCellStatus(false));
					Label l21 = new Label(11, 15, "(B+C)/(A+B)", createFormatCellStatus(false));
					Label l22 = new Label(11, 16, "(B+C)/(A+B)*100", createFormatCellStatus(false));
					Label l23 = new Label(11, 17, "100-(B+C)/(A+B)*100", createFormatCellStatus(false));
					Label l24 = new Label(11, 12, "Formula Componenets", createFormatCellStatus(true));

					Label l25 = new Label(12, 12, "Values", createFormatCellStatus(true));

					Label l26 = new Label(12, 8, "Totals", createFormatCellStatus(true));

					Label l27 = new Label(14, 8, "File Type Conformity", createFormatCellStatus(true));

					modifiedFile.addCell(l2);
					modifiedFile.addCell(l3);
					modifiedFile.addCell(l4);
					modifiedFile.addCell(l5);
					modifiedFile.addCell(l6);
					modifiedFile.addCell(l7);
					modifiedFile.addCell(l8);
					modifiedFile.addCell(l9);
					modifiedFile.addCell(l10);
					modifiedFile.addCell(l11);
					modifiedFile.addCell(l12);
					modifiedFile.addCell(l13);
					if(l14 != null)
					modifiedFile.addCell(l14);
					modifiedFile.addCell(l15);
					modifiedFile.addCell(l16);
					modifiedFile.addCell(l17);
					modifiedFile.addCell(l18);
					modifiedFile.addCell(l19);
					modifiedFile.addCell(l20);
					modifiedFile.addCell(l21);
					modifiedFile.addCell(l22);
					modifiedFile.addCell(l23);
					modifiedFile.addCell(l24);
					modifiedFile.addCell(l25);
					modifiedFile.addCell(l26);
					modifiedFile.addCell(l27);

				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Number numberCell1;
				Number numberCell2;
				Number numberCell3;
				Number numberCell4;

				Number numberCell6;
				numberCell1 = new jxl.write.Number(8, 9, notChangedRow, createFormatCellStatus(false));

	if(weightageorNot) {
			numberCell2 = new jxl.write.Number(8, 10, addedRow, createFormatCellStatus(false));
			numberCell3 = new jxl.write.Number(8, 11, modifiedRow, createFormatCellStatus(false));
			numberCell4 = new jxl.write.Number(8, 12, deletedRow, createFormatCellStatus(false));
	} else {
		numberCell2 = new jxl.write.Number(8, 10, MergeTrackerConstants.totalAddedFiles, createFormatCellStatus(false));
		numberCell3 = new jxl.write.Number(8, 11, MergeTrackerConstants.totalModifiedFiles, createFormatCellStatus(false));
		numberCell4 = new jxl.write.Number(8, 12, MergeTrackerConstants.totalDeletedFiles, createFormatCellStatus(false));
	}
				Number numberCell5 = new jxl.write.Number(9, 9, notChangedRow, createFormatCellStatus(false));
				if(weightageorNot) {
				numberCell6 = new jxl.write.Number(9, 10, (addedRow * Weight) / 4,
						createFormatCellStatus(false));
				} else {
				numberCell6 = new jxl.write.Number(9, 10, (addedRow * Weight),
							createFormatCellStatus(false));
				}
				Number numberCell7 = new jxl.write.Number(9, 11, modifiedRow * Weight, createFormatCellStatus(false));
				Number numberCell8 = new jxl.write.Number(9, 12, deletedRow * Weight, createFormatCellStatus(false));

				double catgoryA = notChangedRow;
				double catgoryB = ((modifiedRow * Weight) + (deletedRow * Weight));
				double catgoryC = (addedRow * Weight);

				Number numberCell9 = new jxl.write.Number(12, 9, notChangedRow, createFormatCellStatus(false));
				Number numberCell10 = new jxl.write.Number(12, 10, (modifiedRow * Weight) + (deletedRow * Weight),
						createFormatCellStatus(false));
				Number numberCell11 = new jxl.write.Number(12, 11, addedRow * Weight, createFormatCellStatus(false));

				Number numberCell12 = new jxl.write.Number(12, 13, catgoryB + catgoryC, createFormatCellStatus(false));
				Number numberCell13 = new jxl.write.Number(12, 14, catgoryA + catgoryB, createFormatCellStatus(false));
				Number numberCell14 = new jxl.write.Number(12, 15, (catgoryB + catgoryC) / (catgoryA + catgoryB),
						createFormatCellStatus(false));
				Number numberCell15 = new jxl.write.Number(12, 16,
						((catgoryB + catgoryC) / (catgoryA + catgoryB)) * 100, createFormatCellStatus(false));
				Number numberCell16 = new jxl.write.Number(12, 17,
						100 - (((catgoryB + catgoryC) / (catgoryA + catgoryB)) * 100), createFormatCellStatus(false));

				Number numberCell17 = new jxl.write.Number(14, 9,
						100 - (((catgoryB + catgoryC) / (catgoryA + catgoryB)) * 100), createFormatCellStatus(false));

				modifiedFile.addCell(numberCell1);
				modifiedFile.addCell(numberCell2);
				modifiedFile.addCell(numberCell3);
				modifiedFile.addCell(numberCell4);

				modifiedFile.addCell(numberCell5);
				modifiedFile.addCell(numberCell6);
				modifiedFile.addCell(numberCell7);
				modifiedFile.addCell(numberCell8);
				modifiedFile.addCell(numberCell9);
				modifiedFile.addCell(numberCell10);
				modifiedFile.addCell(numberCell11);
				modifiedFile.addCell(numberCell12);
				modifiedFile.addCell(numberCell13);
				modifiedFile.addCell(numberCell14);
				modifiedFile.addCell(numberCell15);
				modifiedFile.addCell(numberCell16);
				modifiedFile.addCell(numberCell17);

			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//Cell format

		public static WritableCellFormat createFormatCellStatus(boolean b) throws WriteException {
			Colour colour = (b == true) ? Colour.WHITE : Colour.BLACK;
			WritableFont wfontStatus = new WritableFont(WritableFont.createFont("Arial"), WritableFont.DEFAULT_POINT_SIZE,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, colour);
			WritableCellFormat fCellstatus = new WritableCellFormat(wfontStatus);

			fCellstatus.setWrap(true);
			fCellstatus.setAlignment(jxl.format.Alignment.CENTRE);
			fCellstatus.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			if (b == true) {
				fCellstatus.setBackground(Colour.LIGHT_BLUE);
			} else {
				fCellstatus.setBackground(Colour.GREY_25_PERCENT);
			}
			fCellstatus.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
			return fCellstatus;
		}

}
