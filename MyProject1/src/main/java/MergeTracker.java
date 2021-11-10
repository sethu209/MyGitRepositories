import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import jxl.write.WritableImage;
import java.util.Scanner;

public class MergeTracker {
	static String base1 = null;
	static String base2 = null;
	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the Base directory :");
        base1= s1.nextLine();
		File baseDirectory = new File(base1);
		
		Scanner s2 = new Scanner(System.in);
		System.out.println("Enter the Cutomized directory :");
        base2= s2.nextLine();
		File customizedDirectory  = new File(base2);

		
		//Product Model
		Scanner s3 = new Scanner(System.in);
		System.out.println("Enter the Base Product Model directory :");
        String base3= s3.nextLine();
		File baseProductModel  = new File(base3);

		Scanner s4 = new Scanner(System.in);
		System.out.println("Enter the Customized Product Model directory :");
        String base4= s4.nextLine();
		File customizedProductModel  = new File(base4);
        
		//System Tables
		Scanner s5 = new Scanner(System.in);
		System.out.println("Enter the Base System Table directory :");
        String base5= s5.nextLine();
		File baseSysTable  = new File(base5);

		Scanner s6 = new Scanner(System.in);
		System.out.println("Enter the Cutsomized System Table directory :");
        String base6= s6.nextLine();
		File customizedSysTable  = new File(base6);
		
		//WF
		Scanner s7 = new Scanner(System.in);
		System.out.println("Enter the Base WF directory :");
        String base7= s7.nextLine();
		File baseWF = new File(base7);

		Scanner s8 = new Scanner(System.in);
		System.out.println("Enter the Customized WF directory :");
        String base8= s8.nextLine();
		File customizedWF  = new File(base8);

		//Solar Configuration
		Scanner s9 = new Scanner(System.in);
		System.out.println("Enter the Base Solr Config directory :");
        String base9= s9.nextLine();
		File baseSolr  = new File(base9);

		Scanner s10 = new Scanner(System.in);
		System.out.println("Enter the Customized Solr Config directory :");
        String base10= s10.nextLine();
		File customizedSolr  = new File(base10);
		
		//System Data Configuration
		Scanner s11 = new Scanner(System.in);
		System.out.println("Enter the Base System Data directory :");
        String base11= s11.nextLine();
		File baseSysData  = new File(base11);
		
		Scanner s12 = new Scanner(System.in);
		System.out.println("Enter the Customized System Data directory :");
        String base12= s12.nextLine();
		File customizedSysData   = new File(base12);
		

		UtilityTracker.addBaseFiles(baseDirectory.listFiles());
		UtilityTracker.addCustomizedFiles(customizedDirectory.listFiles());
		DeltaTracker.findAffectedFiles(MergeTrackerConstants.baseFileNames, MergeTrackerConstants.customizedFileNames);
		
		// product model changes
		
		UtilityTracker.addBaseFiles(baseProductModel.listFiles());
		UtilityTracker.addCustomizedFiles(customizedProductModel.listFiles());
		DeltaTracker.findAffectedProductFiles(MergeTrackerConstants.baseFileProductModelNames, MergeTrackerConstants.customizedFileProductModelNames);
		
		//System Table
		
		UtilityTracker.addBaseFiles(baseSysTable.listFiles());
		UtilityTracker.addCustomizedFiles(customizedSysTable.listFiles());
		DeltaTracker.findAffectedSysTableFiles(MergeTrackerConstants.baseFileSysTableNames, MergeTrackerConstants.customizedFileSysTableNames);
				
		//WF
		
		UtilityTracker.addBaseFiles(baseWF.listFiles());
		UtilityTracker.addCustomizedFiles(customizedWF.listFiles());
		DeltaTracker.findAffectedWFFiles(MergeTrackerConstants.baseFileWFNames, MergeTrackerConstants.customizedFileWFNames);
		
		//Solr Config
		
		UtilityTracker.addCustomizedFiles(customizedSolr.listFiles());
		DeltaTracker.findAffectedSolrFiles(MergeTrackerConstants.baseFileSolrNames, MergeTrackerConstants.customizedFileSolrNames);
		
		// System Data Configuration
		
		UtilityTracker.addBaseFiles(baseSysData.listFiles());
		UtilityTracker.addCustomizedFiles(customizedSysData.listFiles());
		DeltaTracker.findAffectedSysDataFiles(MergeTrackerConstants.baseFileSysDataNames, MergeTrackerConstants.customizedFileSysDataNames);

		
		//Other XML Files
		DeltaTracker.findAffectedOtherXMLFiles(MergeTrackerConstants.baseFileOtherXMLNames, MergeTrackerConstants.customizedFileOtherXMLNames);
		
		//Other non-XML Files
		DeltaTracker.findAffectedOtherNonXMLFiles(MergeTrackerConstants.baseFileOtherNonXMLNames, MergeTrackerConstants.baseFileOtherNonXMLNames);
		
		try {
			WritableWorkbook wb = Workbook.createWorkbook(new File("C:\\Upgrade Tracker\\UpgradeTracker.xls"));
			displayStats(wb);
			
			 createExcelAddedFiles(MergeTrackerConstants.addedFiles, wb); createExcelDeletedFiles(MergeTrackerConstants.deletedFiles,
			 wb); createExcelModifiedFiles(MergeTrackerConstants.modifiedFiles, wb);
			 createExcelChangeDataFiles(MergeTrackerConstants.changedData, wb); createExcelEntityFiles(MergeTrackerConstants.allFiles,
					 MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			  createExcelGOSUFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles,
					  MergeTrackerConstants.allCustomizedFiles, wb); createExcelGosuEnhancementFiles(MergeTrackerConstants.allFiles,
							  MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles,wb);
		      createExcelGosuRulesFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles,
		    		  MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			  createExcelGosuTemplateFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles,
					  MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb); createExcelGXModelFiles(MergeTrackerConstants.allFiles,
							  MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			  createExcelPCFFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles,
					  MergeTrackerConstants.allCustomizedFiles, wb); createExcelPLuginFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles,
					  MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			 	
			createExcelProdctModelFiles(MergeTrackerConstants.allProductModelFiles, MergeTrackerConstants.addedProductModelFiles, MergeTrackerConstants.deletedProductModelFiles, MergeTrackerConstants.modifiedProductModelNameFiles, MergeTrackerConstants.allCustomizedProductModelFiles, wb);
			
			  createExcelPropertiesFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles,
					  MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			  createExcelSystemTablesFiles(MergeTrackerConstants.allSysTableFiles, MergeTrackerConstants.addedSysTableFiles, MergeTrackerConstants.deletedSysTableFiles,
					  MergeTrackerConstants.modifiedSysTableNameFiles, MergeTrackerConstants.allCustomizedSysTableFiles, wb);
			  createExcelTypeleistFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles,
					  MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb); createExcelWSCFiles(MergeTrackerConstants.allFiles,
					 MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles, MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			 createExcelSolrConfigFiles(MergeTrackerConstants.allSolrFiles,
					 MergeTrackerConstants.addedSolrFiles, MergeTrackerConstants.deletedSolrFiles, MergeTrackerConstants.modifiedSolrNameFiles, MergeTrackerConstants.allCustomizedSolrFiles, wb);
			 createExcelSysDataConfigFiles(MergeTrackerConstants.allSysDataFiles,
					 MergeTrackerConstants.addedSysDataFiles, MergeTrackerConstants.deletedSysDataFiles, MergeTrackerConstants.modifiedSysDataNameFiles, MergeTrackerConstants.allCustomizedSysDataFiles, wb);
			 createExcelXMLSchemaFiles(MergeTrackerConstants.allFiles, MergeTrackerConstants.addedFiles, MergeTrackerConstants.deletedFiles,
					 MergeTrackerConstants.modifiedNameFiles, MergeTrackerConstants.allCustomizedFiles, wb);
			 createExcelWorkflowFiles(MergeTrackerConstants.allWFFiles, MergeTrackerConstants.addedWFFiles, MergeTrackerConstants.deletedWFFiles, MergeTrackerConstants.modifiedWFNameFiles, MergeTrackerConstants.allCustomizedWFFiles, wb);
			 createExcelOtherXMLFiles(MergeTrackerConstants.allOtherXMLFiles, MergeTrackerConstants.addedOtherXMLFiles, MergeTrackerConstants.deletedOtherXMLFiles, MergeTrackerConstants.modifiedOtherXMLNameFiles, MergeTrackerConstants.allCustomizedOtherXMLFiles, wb);
			 createExcelNonOtherXMLFiles(MergeTrackerConstants.allOtherNonXMLFiles, MergeTrackerConstants.addedOtherNonXMLFiles, MergeTrackerConstants.deletedOtherNonXMLFiles, MergeTrackerConstants.modifiedOtherNonXMLNameFiles, MergeTrackerConstants.allCustomizedOtherNonXMLFiles, wb);
			 readExcelFile(wb);
			 closeScanners(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static File findBasedFile(File name, ArrayList<File> files) {
		File cFile = null;
		try {
			for (File file : files) {
				String bFilePath = file.getAbsolutePath()
						.replace("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base", "");
				String cFilePath = name.getAbsolutePath()
						.replace("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration", "");
				if (skipDirectories(file) && file.getName().equals(name.getName()) && bFilePath.equals(cFilePath)) {
					cFile = file;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cFile;
	}

public static boolean skipDirectories(File file) {
		return !(file.getAbsolutePath().contains("\\generated\\")
				|| file.getAbsolutePath().contains("\\generated_classes\\")
				|| file.getAbsolutePath().contains("\\build\\") || file.getAbsolutePath().contains("\\plugins\\")
				|| file.getAbsolutePath().contains("\\webSrc\\")
				|| file.getAbsolutePath().contains("modules\\configuration\\deploy\\resources\\css\\gen")
				|| file.getAbsolutePath().contains("modules\\base\\base\\deploy\\resources\\css\\gen"));
	}

public static void displayStats(WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Statistics", 0);
		MergeTrackerConstants.totalAddedFiles= (MergeTrackerConstants.addedFiles.size()+MergeTrackerConstants.addedSysDataFiles.size()+MergeTrackerConstants.addedProductModelFiles.size()+MergeTrackerConstants.addedOtherNonXMLFiles.size()+MergeTrackerConstants.addedOtherXMLFiles.size()+MergeTrackerConstants.addedSolrFiles.size()+MergeTrackerConstants.addedSysTableFiles.size()+MergeTrackerConstants.addedWFFiles.size());
		MergeTrackerConstants.totalDeletedFiles = (MergeTrackerConstants.deletedFiles.size()+MergeTrackerConstants.deletedSysTableFiles.size()+MergeTrackerConstants.deletedProductModelFiles.size()+MergeTrackerConstants.deletedOtherNonXMLFiles.size()+MergeTrackerConstants.deletedOtherXMLFiles.size()+MergeTrackerConstants.deletedSolrFiles.size()+MergeTrackerConstants.deletedSysTableFiles.size()+MergeTrackerConstants.deletedWFFiles.size());
		MergeTrackerConstants.totalModifiedFiles = (MergeTrackerConstants.modifiedFiles.size()+MergeTrackerConstants.modifiedProductModelFiles.size()+MergeTrackerConstants.modifiedOtherNonXMLFiles.size()+MergeTrackerConstants.modifiedOtherXMLFiles.size()+MergeTrackerConstants.modifiedSolrFiles.size()+MergeTrackerConstants.modifiedSysTableFiles.size()+MergeTrackerConstants.modifiedWFFiles.size());
		
		addBALogo(modifiedFile);
	}

	public static void createExcelAddedFiles(ArrayList<String> addedFiles, WritableWorkbook wb) {
		WritableSheet addedFile = wb.createSheet("AddedFiles", 1);
		int length =0;
		for (length = 0; length < addedFiles.size(); length++) {
			Label addedData = new Label(0, length, addedFiles.get(length));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   //product model
		for (int length1 = 0; length1 < MergeTrackerConstants.addedProductModelFiles.size(); length1++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedProductModelFiles.get(length1));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		//Sys Table
		for (int length2 = 0; length2 < MergeTrackerConstants.addedSysTableFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedProductModelFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//WF
		for (int length2 = 0; length2 < MergeTrackerConstants.addedWFFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedWFFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//Solr
		for (int length2 = 0; length2 < MergeTrackerConstants.addedSolrFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedSolrFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//System data Configuration
		for (int length2 = 0; length2 < MergeTrackerConstants.addedSysDataFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedSysDataFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		//Other XML Files
		for (int length2 = 0; length2 < MergeTrackerConstants.addedOtherXMLFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedOtherXMLFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		//Other non-XML Files
		for (int length2 = 0; length2 < MergeTrackerConstants.addedOtherNonXMLFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.addedOtherNonXMLFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		addBALogo(addedFile);

	}

	public static void createExcelDeletedFiles(ArrayList<String> deletedFiles, WritableWorkbook wb) {
		WritableSheet deletedFile = wb.createSheet("DeletedFiles", 2);
		int length =0;
		for (length = 0; length < deletedFiles.size(); length++) {
			Label addedData = new Label(0, length, deletedFiles.get(length));
			try {
				deletedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//product Model 
		for (int length1 = 0; length1 < MergeTrackerConstants.deletedProductModelFiles.size(); length1++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.deletedProductModelFiles.get(length1));
			try {
				deletedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Sys Table
		for (int length2 = 0; length2 < MergeTrackerConstants.deletedSysTableFiles.size(); length2++) {
			Label addedData = new Label(0, length++, MergeTrackerConstants.deletedSysTableFiles.get(length2));
			try {
				deletedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

			//WF
			for (int length3 = 0; length3 < MergeTrackerConstants.deletedWFFiles.size(); length3++) {
				Label addedData = new Label(0, length++, MergeTrackerConstants.deletedWFFiles.get(length3));
				try {
					deletedFile.addCell(addedData);
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				//Solr
				for (int length4 = 0; length4 < MergeTrackerConstants.deletedSolrFiles.size(); length4++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.deletedSolrFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//System data Configuration
				for (int length4 = 0; length4 < MergeTrackerConstants.deletedSysDataFiles.size(); length4++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.deletedSysDataFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Other XML
				for (int length4 = 0; length4 < MergeTrackerConstants.deletedOtherXMLFiles.size(); length4++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.deletedOtherXMLFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Other XML
				for (int length4 = 0; length4 < MergeTrackerConstants.deletedOtherNonXMLFiles.size(); length4++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.deletedOtherNonXMLFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


		addBALogo(deletedFile);
	}

	public static void createExcelModifiedFiles(ArrayList<File> modifiedFiles, WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("ModifiedFiles", 3);
		try {
			Label file = new Label(0, 0, "File",ConformityData.createFormatCellStatus(true));
			Label mainPath = new Label(1, 0, "Path",ConformityData.createFormatCellStatus(true));
			modifiedFile.addCell(file);
			modifiedFile.addCell(mainPath);

		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int length = 1;
		for (length = 1; length < modifiedFiles.size(); length++) {
			Label addedData = new Label(0, length, modifiedFiles.get(length).getName());
			Label path = new Label(1, length, modifiedFiles.get(length).getAbsolutePath());

			try {
				modifiedFile.addCell(addedData);
				modifiedFile.addCell(path);

			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//product Model 
				for (int length1 = 0; length1 < MergeTrackerConstants.modifiedProductModelFiles.size(); length1++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedProductModelFiles.get(length1).getName());
					Label path = new Label(1, length-1, MergeTrackerConstants.modifiedProductModelFiles.get(length1).getAbsolutePath());
					try {
						modifiedFile.addCell(addedData);
						modifiedFile.addCell(path);

					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Sys Table
				for (int length2 = 0; length2 < MergeTrackerConstants.modifiedSysTableFiles.size(); length2++) {
					Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedSysTableFiles.get(length2).getName());
					Label path = new Label(1, length-1, MergeTrackerConstants.modifiedSysTableFiles.get(length2).getAbsolutePath());
					try {
						modifiedFile.addCell(addedData);
						modifiedFile.addCell(path);

					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
				//WF
						for (int length2 = 0; length2 < MergeTrackerConstants.modifiedWFFiles.size(); length2++) {
							Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedWFFiles.get(length2).getName());
							Label path = new Label(1, length-1, MergeTrackerConstants.modifiedWFFiles.get(length2).getAbsolutePath());
							try {
								modifiedFile.addCell(addedData);
								modifiedFile.addCell(path);

							} catch (WriteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						//Solr 
								for (int length2 = 0; length2 < MergeTrackerConstants.modifiedSolrFiles.size(); length2++) {
									Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedSolrFiles.get(length2).getName());
									Label path = new Label(1, length-1, MergeTrackerConstants.modifiedSolrFiles.get(length2).getAbsolutePath());
									try {
										modifiedFile.addCell(addedData);
										modifiedFile.addCell(path);

									} catch (WriteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								//System data Configuration
								for (int length2 = 0; length2 < MergeTrackerConstants.modifiedSysDataFiles.size(); length2++) {
									Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedSysDataFiles.get(length2).getName());
									Label path = new Label(1, length-1, MergeTrackerConstants.modifiedSysDataFiles.get(length2).getAbsolutePath());
									try {
										modifiedFile.addCell(addedData);
										modifiedFile.addCell(path);

									} catch (WriteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								//Other XML Files 
										for (int length2 = 0; length2 < MergeTrackerConstants.modifiedOtherXMLFiles.size(); length2++) {
											Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedOtherXMLFiles.get(length2).getName());
											Label path = new Label(1, length-1, MergeTrackerConstants.modifiedOtherXMLFiles.get(length2).getAbsolutePath());
											try {
												modifiedFile.addCell(addedData);
												modifiedFile.addCell(path);

											} catch (WriteException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										//Other XML Files 
										for (int length2 = 0; length2 < MergeTrackerConstants.modifiedOtherNonXMLFiles.size(); length2++) {
											Label addedData = new Label(0, length++, MergeTrackerConstants.modifiedOtherNonXMLFiles.get(length2).getName());
											Label path = new Label(1, length-1, MergeTrackerConstants.modifiedOtherNonXMLFiles.get(length2).getAbsolutePath());
											try {
												modifiedFile.addCell(addedData);
												modifiedFile.addCell(path);

											} catch (WriteException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
		addBALogo(modifiedFile);
	}

	public static void addBALogo(WritableSheet wb) {
		File logo = new File("C:\\Users\\SethuLankala\\Desktop\\Confirmity Tool Code\\BALogo.png");
		WritableImage im = new WritableImage(15, 0, 4, 6, logo);
		// im.setImageAnchor(WritableImage.NO_MOVE_OR_SIZE_WITH_CELLS);
		(wb).addImage(im);
	}

	public static void createExcelChangeDataFiles(Map<ArrayList<String>, String> changedFiles, WritableWorkbook wb) {
		int i = 1;
		WritableSheet changedFile = wb.createSheet("Modified Data", 4);
		try {
			Label ModifiedFile = new Label(0, 0, "Modified File", ConformityData.createFormatCellStatus(true));
			Label ModifedData = new Label(1, 0, "Modified Data", ConformityData.createFormatCellStatus(true));
			changedFile.addCell(ModifiedFile);
			changedFile.addCell(ModifedData);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Map.Entry entry : changedFiles.entrySet()) {
			Label addedData = null;
			Label addedData1 = null;
			try {
				addedData = new Label(0, i, (String) entry.getValue(), ConformityData.createFormatCellStatus(false));
				addedData1 = new Label(1, i, entry.getKey().toString(), ConformityData.createFormatCellStatus(false));

			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			i++;

			try {
				changedFile.addCell(addedData);
				changedFile.addCell(addedData1);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addBALogo(changedFile);
		System.out.print("\nUpgrdae Tracker has been generated");
	}

//Entity files

	public static void createExcelEntityFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Entity", 5);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.90", 0.90, ".eti", ".etx");
	}

//GOSU files

	public static void createExcelGOSUFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("GOSU", 6);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.95", 0.95, ".gs", "null");

	}

//GOSU Enhancement files

	public static void createExcelGosuEnhancementFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("GOSU Enhancement", 7); // .gsx
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.95", 0.95, ".gsx", "null");

	}

//GOSU Rules

	public static void createExcelGosuRulesFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("GOSU Rules", 8); // .gr
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.90", 0.90, ".gr", "null");

	}

//GOSU Template

	public static void createExcelGosuTemplateFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("GOSU Templates", 9);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.90", 0.90, ".gst", "null");

	}

//GX Model

	public static void createExcelGXModelFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("GX Model", 10);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.75", 0.75, ".gsx", "null");

	}

//PCF Files

	public static void createExcelPCFFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("PCF Files", 11);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.90", 0.90, ".pcf", "null");

	}

//Plug ins

	public static void createExcelPLuginFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Plugins", 12);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.75", 0.75, ".gwp", "null");

	}

//Product Model

	public static void createExcelProdctModelFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Product Model", 13);
		
	createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 1.0", 1.0, ".xml", "null");
	}

//Properties

	public static void createExcelPropertiesFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Properties", 14);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.10", 0.10, ".properties", "null");

	}

//System Tables

	public static void createExcelSystemTablesFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("System Tables", 15);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.10", 0.10, ".xml", "null");

	}

//Type Lists

	public static void createExcelTypeleistFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Type Lists", 16);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.95", 0.95, ".tti", ".ttx");

	}

//XML Schemas

public static void createExcelXMLSchemaFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("XML Schema", 17);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.75", 0.75, ".xsd", ".wsdl");

	}

//web service collection

	public static void createExcelWSCFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Web Service Collection", 18);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.95", 0.95, ".wsc", "null");
	}

	
//Solr Configuration

public static void createExcelSolrConfigFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
				ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
				WritableWorkbook wb) {
			WritableSheet modifiedFile = wb.createSheet("Solr Configuration", 19);
			createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
					allCustomizedFiles, "Weight - 0.25", 0.25, ".gs", "null");
		}

//System Data Configuration

public static void createExcelSysDataConfigFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
				ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
				WritableWorkbook wb) {
			WritableSheet modifiedFile = wb.createSheet("System Data Configuration", 20);
			createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
					allCustomizedFiles, "Weight - 0.50", 0.50, "null", "null");
}

//work flow

public static void createExcelWorkflowFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
			ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
			WritableWorkbook wb) {
			WritableSheet modifiedFile = wb.createSheet("Work Flow", 21);
			createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
					allCustomizedFiles, "Weight - 0.25", 0.25, ".xml", "null");
}
//Other XML Files

public static void createExcelOtherXMLFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
				ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
				WritableWorkbook wb) {
				WritableSheet modifiedFile = wb.createSheet("Other XML", 22);
				createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
						allCustomizedFiles, "Weight - 0.50", 0.50, ".xml", "null");
}

//Other non-XML Files

public static void createExcelNonOtherXMLFiles(ArrayList<String> modifiedFiles, ArrayList<String> addedFiles,
		ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly, ArrayList<File> allCustomizedFiles,
		WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Other non-XML", 23);
		createConformityData(modifiedFile, modifiedFiles, addedFiles, deletedFiles, modifiedFilesOnly,
				allCustomizedFiles, "Weight - 0.25", 0.25, "null", "null");
}

//Reading Excel

public static void readExcelFile(WritableWorkbook wb) {
	try {
		readData(wb);
		ConformityData.createData(MergeTrackerConstants.totalAddedRows, MergeTrackerConstants.totalModifiedRows, MergeTrackerConstants.totalDeletedRows, MergeTrackerConstants.totalNotChangedRows, 1,wb.getSheet(0),"",false);
		wb.write();
		try {
			wb.close();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	} catch (IOException e) {
		e.printStackTrace();
 }
}

public static void readData(WritableWorkbook wb) {

		String [] sheetNames = wb.getSheetNames();
        Sheet sheet=null;
	     for (int sheetNumber =5; sheetNumber < sheetNames.length; sheetNumber++){
	        sheet=wb.getSheet(sheetNames[sheetNumber]);
			 
	        MergeTrackerConstants.totalNotChangedRows =MergeTrackerConstants. totalNotChangedRows+ Double.parseDouble(sheet.getCell(9, 9).getContents());
	        MergeTrackerConstants.totalAddedRows = MergeTrackerConstants.totalAddedRows+ Double.parseDouble(sheet.getCell(9, 10).getContents());
	        MergeTrackerConstants.totalModifiedRows = MergeTrackerConstants.totalModifiedRows+ Double.parseDouble(sheet.getCell(9, 11).getContents());
	        MergeTrackerConstants.totalDeletedRows = MergeTrackerConstants.totalDeletedRows+ Double.parseDouble(sheet.getCell(9, 12).getContents());
			   }
}
//Check File extensions

public static boolean checkFileExtension(File cFile) {
	if(cFile.getName().endsWith(".eti") 
			|| cFile.getName().endsWith(".etx")
			|| cFile.getName().endsWith(".tti")
			|| cFile.getName().endsWith(".ttx")
			|| cFile.getName().endsWith(".gs")
			|| cFile.getName().endsWith(".gsx")
			|| cFile.getName().endsWith(".gst")
			|| cFile.getName().endsWith(".gr")
			|| cFile.getName().endsWith(".pcf")
			|| cFile.getName().endsWith(".gwp")
			|| cFile.getName().endsWith(".xsd")
			|| cFile.getName().endsWith(".wsc")
			|| cFile.getName().endsWith(".properties")
			|| cFile.getName().endsWith(".wsdl")) {
		return true;
	} else {
		return false;
	}
}

//Check File Name extensions

public static boolean checkFileNameExtension(String cFile) {
	if(cFile.endsWith(".eti") 
			|| cFile.endsWith(".etx")
			|| cFile.endsWith(".tti")
			|| cFile.endsWith(".ttx")
			|| cFile.endsWith(".gs")
			|| cFile.endsWith(".gsx")
			|| cFile.endsWith(".gst")
			|| cFile.endsWith(".gr")
			|| cFile.endsWith(".pcf")
			|| cFile.endsWith(".gwp")
			|| cFile.endsWith(".xsd")
			|| cFile.endsWith(".wsc")
			|| cFile.endsWith(".properties")
			|| cFile.endsWith(".wsdl")) {
		return true;
	} else {
		return false;
	}
}
//Create Conformity Data

	public static void createConformityData(WritableSheet modifiedFile, ArrayList<String> modifiedFiles,
			ArrayList<String> addedFiles, ArrayList<String> deletedFiles, ArrayList<String> modifiedFilesOnly,
			ArrayList<File> allCustomizedFiles, String Weightage, double Weight, String extension1, String extension2) {
				int row = 0;
		for (int length = 0; length < modifiedFiles.size(); length++) {
			if (modifiedFiles.get(length).endsWith(extension1) || modifiedFiles.get(length).endsWith(extension2) || !checkFileNameExtension(modifiedFiles.get(length))) {
				Label addedData = new Label(0, row++, modifiedFiles.get(length));
				try {
					modifiedFile.addCell(addedData);
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

			// added Files
			int addedRow = 0;
			for (int length1 = 0; length1 < addedFiles.size(); length1++) {
				if (addedFiles.get(length1).endsWith(extension1) || addedFiles.get(length1).endsWith(extension2) || !checkFileNameExtension(addedFiles.get(length1))) {
					addedRow++;
				}
			}

			// deleted Files
			int deletedRow = 0;
			for (int length2 = 0; length2 < deletedFiles.size(); length2++) {
				if (deletedFiles.get(length2).endsWith(extension1) || deletedFiles.get(length2).endsWith(extension2) || !checkFileNameExtension(deletedFiles.get(length2))) {
					deletedRow++;
				}
			}

			// modified Files
			int modifiedRow = 0;
			for (int length3 = 0; length3 < modifiedFilesOnly.size(); length3++) {
				if (modifiedFilesOnly.get(length3).endsWith(extension1)
						|| modifiedFilesOnly.get(length3).endsWith(extension2) || !checkFileNameExtension(modifiedFilesOnly.get(length3))) {
					modifiedRow++;
				}
			}
			// Not Changed Files

			int entityCount = 0;

			for (int length4 = 0; length4 < allCustomizedFiles.size(); length4++) {
				if (allCustomizedFiles.get(length4).getName().endsWith(extension1)
						|| allCustomizedFiles.get(length4).getName().endsWith(extension2) || !checkFileExtension(allCustomizedFiles.get(length4))) {
					entityCount++;
				}
			}
			int notChangedRow = entityCount - (modifiedRow + deletedRow + addedRow);
			ConformityData.createData(addedRow, modifiedRow, deletedRow, notChangedRow, Weight,modifiedFile,Weightage,true);
	}
	public static void closeScanners(Scanner s1,Scanner s2,Scanner s3,Scanner s4,Scanner s5,Scanner s6,Scanner s7,Scanner s8,Scanner s9,Scanner s10,Scanner s11,Scanner s12) {
		s1.close();
		s2.close();
		s3.close();
		s4.close();
		s5.close();
		s6.close();
		s7.close();
		s8.close();
		s9.close();
		s10.close();
		s11.close();
		s12.close();
	}
}
