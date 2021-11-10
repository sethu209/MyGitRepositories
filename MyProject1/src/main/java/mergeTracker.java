import org.apache.commons.io.FileUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jxl.write.WritableImage;

public class mergeTracker {
	
	static double totalNotChangedRows = 0 ;
	static double totalAddedRows = 0 ;
	static double totalDeletedRows = 0 ;
	static double totalModifiedRows = 0 ;
	
	static int totalAddedFiles = 0 ;
	static int totalDeletedFiles = 0 ;
	static int totalModifiedFiles = 0 ;

	static ArrayList<File> allBaseFiles = new ArrayList<>();
	static ArrayList<File> allCustomizedFiles = new ArrayList<>();
	static ArrayList<String> addedFiles = new ArrayList<>();
	static ArrayList<String> deletedFiles = new ArrayList<>();
	static ArrayList<String> modifiedNameFiles = new ArrayList<>();
	static Map<ArrayList<String>, String> changedData = new LinkedHashMap<>();

	static ArrayList<String> allFiles = new ArrayList<>();

	static ArrayList<String> baseFileNames = new ArrayList<>();
	static ArrayList<String> customizedFileNames = new ArrayList<>();
	
	
	static ArrayList<File> modifiedFiles = new ArrayList<>();

//product model 
	
	static ArrayList<File> allBaseProductModelFiles = new ArrayList<>();
	static ArrayList<File> allCustomizedProductModelFiles = new ArrayList<>();

	static ArrayList<String> baseFileProductModelNames = new ArrayList<>();
	static ArrayList<String> customizedFileProductModelNames = new ArrayList<>();
	
	static ArrayList<File> modifiedProductModelFiles = new ArrayList<>();
	static ArrayList<String> modifiedProductModelNameFiles = new ArrayList<>();

	static ArrayList<String> addedProductModelFiles = new ArrayList<>();
	static ArrayList<String> deletedProductModelFiles = new ArrayList<>();
	
	static ArrayList<String> allProductModelFiles = new ArrayList<>();
	
//System Tables

	static ArrayList<File> allBaseSysTableFiles = new ArrayList<>();
	static ArrayList<File> allCustomizedSysTableFiles = new ArrayList<>();

	static ArrayList<String> baseFileSysTableNames = new ArrayList<>();
	static ArrayList<String> customizedFileSysTableNames = new ArrayList<>();
	
	static ArrayList<File> modifiedSysTableFiles = new ArrayList<>();
	static ArrayList<String> modifiedSysTableNameFiles = new ArrayList<>();

	static ArrayList<String> addedSysTableFiles = new ArrayList<>();
	static ArrayList<String> deletedSysTableFiles = new ArrayList<>();
	static ArrayList<String> allSysTableFiles = new ArrayList<>();
	
//Work flow

	static ArrayList<File> allBaseWFFiles = new ArrayList<>();
	static ArrayList<File> allCustomizedWFFiles = new ArrayList<>();

	static ArrayList<String> baseFileWFNames = new ArrayList<>();
	static ArrayList<String> customizedFileWFNames = new ArrayList<>();
	
	static ArrayList<File> modifiedWFFiles = new ArrayList<>();
	static ArrayList<String> modifiedWFNameFiles = new ArrayList<>();

	static ArrayList<String> addedWFFiles = new ArrayList<>();
	static ArrayList<String> deletedWFFiles = new ArrayList<>();

	static ArrayList<String> allWFFiles = new ArrayList<>();
	
//Solr Configuration
	
	static ArrayList<File> allBaseSolrFiles = new ArrayList<>();
	static ArrayList<File> allCustomizedSolrFiles = new ArrayList<>();

	static ArrayList<String> baseFileSolrNames = new ArrayList<>();
	static ArrayList<String> customizedFileSolrNames = new ArrayList<>();
	
	static ArrayList<File> modifiedSolrFiles = new ArrayList<>();
	static ArrayList<String> modifiedSolrNameFiles = new ArrayList<>();

	static ArrayList<String> addedSolrFiles = new ArrayList<>();
	static ArrayList<String> deletedSolrFiles = new ArrayList<>();
	
	static ArrayList<String> allSolrFiles = new ArrayList<>();
	
	//System data Configuration
	
		static ArrayList<File> allBaseSysDataFiles = new ArrayList<>();
		static ArrayList<File> allCustomizedSysDataFiles = new ArrayList<>();

		static ArrayList<String> baseFileSysDataNames = new ArrayList<>();
		static ArrayList<String> customizedFileSysDataNames = new ArrayList<>();
		
		static ArrayList<File> modifiedSysDataFiles = new ArrayList<>();
		static ArrayList<String> modifiedSysDataNameFiles = new ArrayList<>();

		static ArrayList<String> addedSysDataFiles = new ArrayList<>();
		static ArrayList<String> deletedSysDataFiles = new ArrayList<>();
		static ArrayList<String> allSysDataFiles = new ArrayList<>();
	
	//Other XML Files
	
		static ArrayList<File> allBaseOtherXMLFiles = new ArrayList<>();
		static ArrayList<File> allCustomizedOtherXMLFiles = new ArrayList<>();

		static ArrayList<String> baseFileOtherXMLNames = new ArrayList<>();
		static ArrayList<String> customizedFileOtherXMLNames = new ArrayList<>();
		
		static ArrayList<File> modifiedOtherXMLFiles = new ArrayList<>();
		static ArrayList<String> modifiedOtherXMLNameFiles = new ArrayList<>();

		static ArrayList<String> addedOtherXMLFiles = new ArrayList<>();
		static ArrayList<String> deletedOtherXMLFiles = new ArrayList<>();
		static ArrayList<String> allOtherXMLFiles = new ArrayList<>();
		
		//Other Non-XML Files
		
			static ArrayList<File> allBaseOtherNonXMLFiles = new ArrayList<>();
			static ArrayList<File> allCustomizedOtherNonXMLFiles = new ArrayList<>();

			static ArrayList<String> baseFileOtherNonXMLNames = new ArrayList<>();
			static ArrayList<String> customizedFileOtherNonXMLNames = new ArrayList<>();
			
			static ArrayList<File> modifiedOtherNonXMLFiles = new ArrayList<>();
			static ArrayList<String> modifiedOtherNonXMLNameFiles = new ArrayList<>();

			static ArrayList<String> addedOtherNonXMLFiles = new ArrayList<>();
			static ArrayList<String> deletedOtherNonXMLFiles = new ArrayList<>();
		
			static ArrayList<String> allOtherNonXMLFiles = new ArrayList<>();
	
	public static void main(String[] args) {

		File baseDirectory = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base");
		File customizedDirectory = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration");
		
		//Product Model
		
		File baseProductModel = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base\\config\\resources\\productmodel");
		File customizedProductModel = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration\\config\\resources\\productmodel");
        
		//System Tables

		File baseSysTable = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base\\config\\resources\\systables");
		File customizedSysTable = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration\\config\\resources\\systables");
		
		//WF

		File baseWF = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base\\config\\workflow");
		File customizedWF = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration\\config\\workflow");

		//Solr Configuration

		File baseSolr = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base\\gsrc\\gw\\solr");
		File customizedSolr = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration\\gsrc\\gw\\solr");
		
		//System Data Configuration

		File baseSysData = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\base\\base\\config\\import");
		File customizedSysData = new File("C:\\Users\\SethuLankala\\Downloads\\gw\\PolicyCenter1001\\modules\\configuration\\config\\import");
		

		addBaseFiles(baseDirectory.listFiles());
		addCustomizedFiles(customizedDirectory.listFiles());
		findAffectedFiles(baseFileNames, customizedFileNames);
		displayModifiedFiles(modifiedFiles);
		
		// product model changes
		
		addBaseFiles(baseProductModel.listFiles());
		addCustomizedFiles(customizedProductModel.listFiles());
		findAffectedProductFiles(baseFileProductModelNames, customizedFileProductModelNames);
		displayModifiedFiles(modifiedProductModelFiles);
		
		//System Table
		
		addBaseFiles(baseSysTable.listFiles());
		addCustomizedFiles(customizedSysTable.listFiles());
		findAffectedSysTableFiles(baseFileSysTableNames, customizedFileSysTableNames);
		displayModifiedFiles(modifiedSysTableFiles);
				
		//WF
		
		addBaseFiles(baseWF.listFiles());
		addCustomizedFiles(customizedWF.listFiles());
		findAffectedWFFiles(baseFileWFNames, customizedFileWFNames);
		displayModifiedFiles(modifiedWFFiles);
		
		//Solr Config
		
		addBaseFiles(baseSolr.listFiles());
		addCustomizedFiles(customizedSolr.listFiles());
		findAffectedSolrFiles(baseFileSolrNames, customizedFileSolrNames);
		displayModifiedFiles(modifiedSolrFiles);
		
		// System Data Configuration
		
		addBaseFiles(baseSysData.listFiles());
		addCustomizedFiles(customizedSysData.listFiles());
		findAffectedSysDataFiles(baseFileSysDataNames, customizedFileSysDataNames);
		displayModifiedFiles(modifiedSysDataFiles);

		
		//Other XML Files
		findAffectedOtherXMLFiles(baseFileOtherXMLNames, customizedFileOtherXMLNames);
		displayModifiedFiles(modifiedOtherXMLFiles);
		
		//Other non-XML Files
		findAffectedOtherNonXMLFiles(baseFileOtherNonXMLNames, baseFileOtherNonXMLNames);
		displayModifiedFiles(modifiedOtherNonXMLFiles);
		
		try {
			WritableWorkbook wb = Workbook.createWorkbook(new File("C:\\Upgrade Tracker\\UpgradeTracker.xls"));
			displayStats(addedFiles, deletedFiles, modifiedFiles, wb);
			
			 createExcelAddedFiles(addedFiles, wb); createExcelDeletedFiles(deletedFiles,
			 wb); createExcelModifiedFiles(modifiedFiles, wb);
			 createExcelChangeDataFiles(changedData, wb); createExcelEntityFiles(allFiles,
			 addedFiles, deletedFiles, modifiedNameFiles, allCustomizedFiles, wb);
			  createExcelGOSUFiles(allFiles, addedFiles, deletedFiles, modifiedNameFiles,
			  allCustomizedFiles, wb); createExcelGosuEnhancementFiles(allFiles,
			  addedFiles, deletedFiles, modifiedNameFiles, allCustomizedFiles,wb);
		      createExcelGosuRulesFiles(allFiles, addedFiles, deletedFiles,
			 modifiedNameFiles, allCustomizedFiles, wb);
			  createExcelGosuTemplateFiles(allFiles, addedFiles, deletedFiles,
			  modifiedNameFiles, allCustomizedFiles, wb); createExcelGXModelFiles(allFiles,
			  addedFiles, deletedFiles, modifiedNameFiles, allCustomizedFiles, wb);
			  createExcelPCFFiles(allFiles, addedFiles, deletedFiles, modifiedNameFiles,
			  allCustomizedFiles, wb); createExcelPLuginFiles(allFiles, addedFiles,
			  deletedFiles, modifiedNameFiles, allCustomizedFiles, wb);
			 	
			createExcelProdctModelFiles(allProductModelFiles, addedProductModelFiles, deletedProductModelFiles, modifiedProductModelNameFiles, allCustomizedProductModelFiles, wb);
			
			  createExcelPropertiesFiles(allFiles, addedFiles, deletedFiles,
			  modifiedNameFiles, allCustomizedFiles, wb);
			  createExcelSystemTablesFiles(allSysTableFiles, addedSysTableFiles, deletedSysTableFiles,
			  modifiedSysTableNameFiles, allCustomizedSysTableFiles, wb);
			  createExcelTypeleistFiles(allFiles, addedFiles, deletedFiles,
			 modifiedNameFiles, allCustomizedFiles, wb); createExcelWSCFiles(allFiles,
			  addedFiles, deletedFiles, modifiedNameFiles, allCustomizedFiles, wb);
			 createExcelSolrConfigFiles(allSolrFiles,
					  addedSolrFiles, deletedSolrFiles, modifiedSolrNameFiles, allCustomizedSolrFiles, wb);
			 createExcelSysDataConfigFiles(allSysDataFiles,
					  addedSysDataFiles, deletedSysDataFiles, modifiedSysDataNameFiles, allCustomizedSysDataFiles, wb);
			 createExcelXMLSchemaFiles(allFiles, addedFiles, deletedFiles,
			 modifiedNameFiles, allCustomizedFiles, wb);
			 createExcelWorkflowFiles(allWFFiles, addedWFFiles, deletedWFFiles, modifiedWFNameFiles, allCustomizedWFFiles, wb);
			 createExcelOtherXMLFiles(allOtherXMLFiles, addedOtherXMLFiles, deletedOtherXMLFiles, modifiedOtherXMLNameFiles, allCustomizedOtherXMLFiles, wb);
			 createExcelNonOtherXMLFiles(allOtherNonXMLFiles, addedOtherNonXMLFiles, deletedOtherNonXMLFiles, modifiedOtherNonXMLNameFiles, allCustomizedOtherNonXMLFiles, wb);
			 readExcelFile(wb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addBaseFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				addBaseFiles(file.listFiles());
			} else if (!file.getAbsolutePath().contains("\\webSrc\\")
					&& !file.getAbsolutePath().contains("\\deploy\\resources\\css\\gen") && file.isFile()) {
			if(!file.getAbsolutePath().contains("\\config\\resources\\productmodel") && !file.getAbsolutePath().contains("\\config\\resources\\systables") && !file.getAbsolutePath().contains("\\config\\workflow")
					&& !file.getAbsolutePath().contains("\\gsrc\\gw\\solr") && checkFileExtension(file) && !file.getAbsolutePath().contains("\\config\\import")) {
				baseFileNames.add(file.getName());
				allBaseFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\productmodel")) {
					baseFileProductModelNames.add(file.getName());
					allBaseProductModelFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\systables")) {
				baseFileSysTableNames.add(file.getName());
				allBaseSysTableFiles.add(file);
		}else if(file.getAbsolutePath().contains("\\config\\workflow")) {
			baseFileWFNames.add(file.getName());
			allBaseWFFiles.add(file);
	 }else if(file.getAbsolutePath().contains("\\gsrc\\gw\\solr")) {
			baseFileSolrNames.add(file.getName());
			allBaseSolrFiles.add(file);
	}else if(file.getAbsolutePath().contains("\\config\\import")) {
		baseFileSysDataNames.add(file.getName());
		allBaseSysDataFiles.add(file);
}else if(file.getName().endsWith(".xml") && !file.getAbsolutePath().contains("\\config\\import")) {
		baseFileOtherXMLNames.add(file.getName());
		allBaseOtherXMLFiles.add(file);
    } else {
       	 baseFileOtherNonXMLNames.add(file.getName());
       	allBaseOtherNonXMLFiles.add(file);
          }
     	}
	}
}

	public static void addCustomizedFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				addCustomizedFiles(file.listFiles());
			} else if (skipDirectories(file) && file.isFile()) {
				if(!file.getAbsolutePath().contains("\\config\\resources\\productmodel")&& !file.getAbsolutePath().contains("\\config\\resources\\systables")
						&& !file.getAbsolutePath().contains("\\config\\workflow")
						&& !file.getAbsolutePath().contains("\\gsrc\\gw\\solr") && checkFileExtension(file) && !file.getAbsolutePath().contains("\\config\\import")) {
				customizedFileNames.add(file.getName());
				allCustomizedFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\productmodel")) {
					customizedFileProductModelNames.add(file.getName());
					allCustomizedProductModelFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\systables")) {
				customizedFileSysTableNames.add(file.getName());
				allCustomizedSysTableFiles.add(file);
		}else if(file.getAbsolutePath().contains("\\config\\workflow")) {
			customizedFileWFNames.add(file.getName());
			allCustomizedWFFiles.add(file);
	 }else if(file.getAbsolutePath().contains("\\gsrc\\gw\\solr")) {
			customizedFileSolrNames.add(file.getName());
			allCustomizedSolrFiles.add(file);
	}else if(file.getAbsolutePath().contains("\\config\\import")) {
		customizedFileSysDataNames.add(file.getName());
		allCustomizedSysDataFiles.add(file);
}else if(file.getName().endsWith(".xml") && !file.getAbsolutePath().contains("\\config\\import")) {
		customizedFileOtherXMLNames.add(file.getName());
		allCustomizedOtherXMLFiles.add(file);
} else {
	customizedFileOtherNonXMLNames.add(file.getName());
	allCustomizedOtherNonXMLFiles.add(file);
}
	}
}
}

	public static void findAffectedFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
		//System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				deletedFiles.add(i);
				allFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				addedFiles.add(i);
				allFiles.add(i);
			}
		}
		//System.out.println("Added Files Count----------" + addedFiles.size());
		//System.out.println("Deleted Files Count----------" + deletedFiles.size());

		for (String i : addedFiles) {
//			System.out.println("Added File--" + i);
		}
		for (String i : deletedFiles) {
	//		System.out.println("Deleted File--" + i);
		}
		compareModifiedFiles(allCustomizedFiles,false,false,false,false,false,false,false);
	}

	
	//Find Affected Product Model Files
	
	public static void findAffectedProductFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
	//	System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				deletedProductModelFiles.add(i);
				allProductModelFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				addedProductModelFiles.add(i);
				allProductModelFiles.add(i);
			}
		}
	//	System.out.println("Added Files Count----------" + addedProductModelFiles.size());
		//System.out.println("Deleted Files Count----------" + deletedProductModelFiles.size());

		for (String i : addedProductModelFiles) {
	//		System.out.println("Product Model Added File--" + i);
		}
		for (String i : deletedProductModelFiles) {
		//	System.out.println("Product Model Deleted File--" + i);
		}
		compareModifiedFiles(allCustomizedProductModelFiles, true,false,false,false,false,false,false);
	}
	

	//Find Affected System Table Files
	
	public static void findAffectedSysTableFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
	//	System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				deletedSysTableFiles.add(i);
				allSysTableFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				addedSysTableFiles.add(i);
				allSysTableFiles.add(i);
			}
		}
		/*
		 * System.out.println("Added Files Count----------" +
		 * addedProductModelFiles.size());
		 * System.out.println("Deleted Files Count----------" +
		 * deletedProductModelFiles.size());
		 */
		
		for (String i : addedSysTableFiles) {
		//	System.out.println("System Table Added File--" + i);
		}
		for (String i : deletedSysTableFiles) {
		//	System.out.println("System Table Deleted File--" + i);
		}
		compareModifiedFiles(allCustomizedSysTableFiles, false,true,false,false,false,false,false);
	}
	
	//Find Affected WF Files
	
		public static void findAffectedWFFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

			ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
			commonFiles.retainAll(_baseFileNames);
			HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
			uniqueFiles.addAll(_baseFileNames);
			uniqueFiles.removeAll(commonFiles);
		//	System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
			for (String i : uniqueFiles) {
				if (_baseFileNames.contains(i)) {
					deletedWFFiles.add(i);
					allWFFiles.add(i);
				} else if (_customizedFileNames.contains(i)) {
					addedWFFiles.add(i);
					allWFFiles.add(i);
				}
			}
			/*
			 * System.out.println("Added Files Count----------" +
			 * addedProductModelFiles.size());
			 * System.out.println("Deleted Files Count----------" +
			 * deletedProductModelFiles.size());
			 */
			
			for (String i : addedWFFiles) {
				//System.out.println("WF Added File--" + i);
			}
			for (String i : deletedWFFiles) {
				//System.out.println("WF Deleted File--" + i);
			}
			compareModifiedFiles(allCustomizedWFFiles, false,false,true,false,false,false,false);
		}
		
		
		//Find Affected Solr Files
		
			public static void findAffectedSolrFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

				ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
				commonFiles.retainAll(_baseFileNames);
				HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
				uniqueFiles.addAll(_baseFileNames);
				uniqueFiles.removeAll(commonFiles);
				//System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
				for (String i : uniqueFiles) {
					if (_baseFileNames.contains(i)) {
						deletedSolrFiles.add(i);
						allSolrFiles.add(i);
					} else if (_customizedFileNames.contains(i)) {
						addedSolrFiles.add(i);
						allSolrFiles.add(i);
					}
				}
				/*
				 * System.out.println("Added Files Count----------" +
				 * addedProductModelFiles.size());
				 * System.out.println("Deleted Files Count----------" +
				 * deletedProductModelFiles.size());
				 */
				
				for (String i : addedSolrFiles) {
					//System.out.println("Solr Added File--" + i);
				}
				for (String i : deletedSolrFiles) {
					//System.out.println("Solr Deleted File--" + i);
				}
				compareModifiedFiles(allCustomizedSolrFiles, false,false,false,true,false,false,false);
			}
			
			//Find Affected System data Files
			
				public static void findAffectedSysDataFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

					ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
					commonFiles.retainAll(_baseFileNames);
					HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
					uniqueFiles.addAll(_baseFileNames);
					uniqueFiles.removeAll(commonFiles);
					//System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
					for (String i : uniqueFiles) {
						if (_baseFileNames.contains(i)) {
							deletedSysDataFiles.add(i);
							allSysDataFiles.add(i);
						} else if (_customizedFileNames.contains(i)) {
							addedSysDataFiles.add(i);
							allSysDataFiles.add(i);
						}
					}
					/*
					 * System.out.println("Added Files Count----------" +
					 * addedProductModelFiles.size());
					 * System.out.println("Deleted Files Count----------" +
					 * deletedProductModelFiles.size());
					 */
					
					for (String i : addedSysDataFiles) {
						//System.out.println("System Data Added File--" + i);
					}
					for (String i : deletedSysDataFiles) {
						//System.out.println("System Data Deleted File--" + i);
					}
					compareModifiedFiles(allCustomizedSysDataFiles, false,false,false,false,false,false,true);
				}


		
			//Other XML Files
			
public static void findAffectedOtherXMLFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

				ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
				commonFiles.retainAll(_baseFileNames);
				HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
				uniqueFiles.addAll(_baseFileNames);
				uniqueFiles.removeAll(commonFiles);
			//	System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
				for (String i : uniqueFiles) {
					if (_baseFileNames.contains(i)) {
						deletedOtherXMLFiles.add(i);
						allOtherXMLFiles.add(i);
					} else if (_customizedFileNames.contains(i)) {
						addedOtherXMLFiles.add(i);
						allOtherXMLFiles.add(i);
					}
				}
				/*
				 * System.out.println("Added Files Count----------" +
				 * addedProductModelFiles.size());
				 * System.out.println("Deleted Files Count----------" +
				 * deletedProductModelFiles.size());
				 */
				
				for (String i : addedOtherXMLFiles) {
					//System.out.println("Other XML Added File--" + i);
				}
				for (String i : deletedOtherXMLFiles) {
					//System.out.println("Other XML Deleted File--" + i);
				}
				compareModifiedFiles(allCustomizedOtherXMLFiles, false,false,false,false,true,false,false);
}		
//Other non-XML Files

public static void findAffectedOtherNonXMLFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

	ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
	commonFiles.retainAll(_baseFileNames);
	HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
	uniqueFiles.addAll(_baseFileNames);
	uniqueFiles.removeAll(commonFiles);
	//System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
	for (String i : uniqueFiles) {
		if (_baseFileNames.contains(i)) {
			deletedOtherNonXMLFiles.add(i);
			allOtherNonXMLFiles.add(i);
		} else if (_customizedFileNames.contains(i)) {
			addedOtherNonXMLFiles.add(i);
			allOtherNonXMLFiles.add(i);
		}
	}
	/*
	 * System.out.println("Added Files Count----------" +
	 * addedProductModelFiles.size());
	 * System.out.println("Deleted Files Count----------" +
	 * deletedProductModelFiles.size());
	 */
	
	for (String i : addedOtherNonXMLFiles) {
		//System.out.println("Other non-XML Added File--" + i);
	}
	for (String i : deletedOtherNonXMLFiles) {
		//System.out.println("Other non-XML Deleted File--" + i);
	}
	compareModifiedFiles(allCustomizedOtherNonXMLFiles, false,false,false,false,false,true,false);
}		


		@SuppressWarnings({ "resource", "unlikely-arg-type" })
public static void compareModifiedFiles(ArrayList<File> files, boolean productModelorNot,boolean sysTableorNot,boolean wfOrNot,
			boolean solrorNot,boolean otherXMLorNot,boolean otherNonXMLorNot,boolean sysDataorNot) {
		File bFile;
		for (File cFile : files) {
			if (skipDirectories(cFile)) {
                 if(productModelorNot) {
			        bFile = findBasedFile(cFile, allBaseProductModelFiles);
                 }else if(sysTableorNot){
 			        bFile = findBasedFile(cFile, allBaseSysTableFiles);
                 }else if(wfOrNot){
 			        bFile = findBasedFile(cFile, allBaseWFFiles);
                 } else if(solrorNot){
 			        bFile = findBasedFile(cFile, allBaseSolrFiles);
                 } else if(sysDataorNot){
 			        bFile = findBasedFile(cFile, allBaseSysDataFiles);
                 }else if(otherXMLorNot){
 			        bFile = findBasedFile(cFile, allBaseOtherXMLFiles);
                 } else if(otherNonXMLorNot){
 			        bFile = findBasedFile(cFile, allBaseOtherNonXMLFiles);
                 }  else {
                 bFile = findBasedFile(cFile, allBaseFiles);
         }
				if (bFile != null && cFile != null) {
					try {
						boolean isContentSame = FileUtils.contentEquals(cFile, bFile);
						if (!isContentSame) {
							BufferedReader br1 = null;
							BufferedReader br2 = null;
							String sCurrentLine = null;
							StringBuilder sBuilder = new StringBuilder();
							ArrayList<String> list1 = new ArrayList<>();
							ArrayList<String> list2 = new ArrayList<>();
							br1 = new BufferedReader(new FileReader(bFile));
							br2 = new BufferedReader(new FileReader(cFile));
					
							
							 while ((sCurrentLine = br1.readLine()) != null) {
					                list1.add(sCurrentLine);
					            }
					            while ((sCurrentLine = br2.readLine()) != null) {
					                list2.add(sCurrentLine);
					            }
					            ArrayList<String> tmpList = new ArrayList<String>(list1);
					            ArrayList<String> totalChanges = new ArrayList<String>();

					            tmpList.removeAll(list2);
					         //   System.out.println("content from test.txt which is not there in test2.txt");
					            //for(int i=0;i<tmpList.size();i++){
					                //System.out.println(tmpList.get(i));
									if(tmpList != null && tmpList.size()>0 && !(tmpList.contains("[]") || tmpList.contains("[ ]"))) {
									//	System.out.println("-------"+tmpList+"---");
										changedData.put(tmpList, cFile.getName());
									}
									totalChanges.addAll(tmpList);
								//}
					             tmpList = list2;
					            tmpList.removeAll(list1);
					          //  for(int i=0;i<tmpList.size();i++){
					             //   System.out.println(tmpList.get(i));
									if(tmpList != null && tmpList.size() > 0 && !(tmpList.contains("[ ]") || tmpList.contains("[]"))) {
										//System.out.println("-------"+tmpList+"---");
					            	changedData.put(tmpList, cFile.getName());
									}
									totalChanges.addAll(tmpList);
				            //}
					        /*
							 * sCurrentLine = br1.readLine(); while (sCurrentLine != null) {
							 * sBuilder.append(sCurrentLine); sBuilder.append("-"); sCurrentLine = n 
							 * br1.readLine(); list1.add(sCurrentLine); } sCurrentLine = null; sCurrentLine
							 * = br2.readLine(); while (sCurrentLine != null) {
							 * sBuilder.append(sCurrentLine); sBuilder.append("-"); sCurrentLine =
							 * br2.readLine(); list2.add(sCurrentLine); } ArrayList<String> tmpList = new
							 * ArrayList<>(list2); tmpList.removeAll(list1);
							 */
									System.out.println("Modified file-----"+cFile.getName()+"----size"+totalChanges.size()+"-------"+cFile.getAbsolutePath()+"-------"+checkFileExtension(cFile));
							if (totalChanges.size() > 0 && !cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") 
									&& !cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !cFile.getAbsolutePath().contains("\\config\\workflow")
									&& !cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !cFile.getAbsolutePath().contains("\\config\\import") && checkFileExtension(cFile)) {
							//m./	System.out.println("properties file----"+cFile.getName());
								modifiedFiles.add(cFile);
								modifiedNameFiles.add(cFile.getName());
								allFiles.add(cFile.getName());
							}else if(totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") && !modifiedProductModelFiles.contains(cFile) 
									 && !modifiedProductModelNameFiles.contains(cFile.getName()) ) {
								 modifiedProductModelNameFiles.add(cFile.getName());
								modifiedProductModelFiles.add(cFile);
								allProductModelFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !modifiedSysTableFiles.contains(cFile) 
									 && !modifiedSysTableNameFiles.contains(cFile.getName())) {
								modifiedSysTableFiles.add(cFile);
								modifiedSysTableNameFiles.add(cFile.getName());
								allSysTableFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\workflow") && !modifiedWFFiles.contains(cFile) 
									 && !modifiedWFNameFiles.contains(cFile.getName())) {
								modifiedWFFiles.add(cFile);
								modifiedWFNameFiles.add(cFile.getName());
								allWFFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !modifiedSolrFiles.contains(cFile) 
									 && !modifiedSolrNameFiles.contains(cFile.getName())) {
								modifiedSolrFiles.add(cFile);
								modifiedSolrNameFiles.add(cFile.getName());
								allSolrFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\import") && !modifiedSysDataFiles.contains(cFile) 
									 && !modifiedSysDataNameFiles.contains(cFile.getName())) {
								modifiedSysDataFiles.add(cFile);
								modifiedSysDataNameFiles.add(cFile.getName());
								allSysDataFiles.add(cFile.getName());
							}else if (totalChanges.size() > 0 && !cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") 
									&& !cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !cFile.getAbsolutePath().contains("\\config\\workflow")
									&& !cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !cFile.getAbsolutePath().contains("\\config\\import") 
									&& cFile.getName().endsWith(".xml") && !modifiedOtherXMLFiles.contains(cFile) 
									&& !modifiedOtherXMLNameFiles.contains(cFile.getName())) {
								modifiedOtherXMLFiles.add(cFile);
								modifiedOtherXMLNameFiles.add(cFile.getName());
								allOtherXMLFiles.add(cFile.getName());
							} else if(totalChanges.size() > 0  && !cFile.getName().endsWith(".xml") && !checkFileExtension(cFile) && !modifiedOtherNonXMLFiles.contains(cFile) 
									 && !modifiedOtherNonXMLNameFiles.contains(cFile.getName())){
								modifiedOtherNonXMLFiles.add(cFile);
								modifiedOtherNonXMLNameFiles.add(cFile.getName());
								allOtherNonXMLFiles.add(cFile.getName());	
								}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
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

	public static void displayModifiedFiles(ArrayList<File> modifiedFiles2) {
		//System.out.println("Modified Files Count----------" + modifiedFiles2.size());
		for (File modifiedFile : modifiedFiles2) {
			//System.out.println("Modified File---" + modifiedFile.getName() + "---------Path-------" + modifiedFile);
		}
	}

public static void displayStats(ArrayList<String> addedFiles, ArrayList<String> deletedFiles,
			ArrayList<File> modifiedFiles, WritableWorkbook wb) {
		WritableSheet modifiedFile = wb.createSheet("Statistics", 0);
		Label l0 = null;
		Label l1 = null;
		Label l2 = null;
		Label l3 = null;
		Label l4 = null;
		Label l5 = null;

		try {
			l0 = new Label(4, 8, "Count", createFormatCellStatus(true));
			l1 = new Label(3, 8, "Change Type", createFormatCellStatus(true));
			l2 = new Label(3, 9, "NotChangedFiles", createFormatCellStatus(false));
			l3 = new Label(3, 10, "Added Files", createFormatCellStatus(false));
			l4 = new Label(3, 11, "Edited Files", createFormatCellStatus(false));
			l5 = new Label(3, 12, "Deleted Files", createFormatCellStatus(false));
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			
			totalAddedFiles= (addedFiles.size()+addedSysDataFiles.size()+addedProductModelFiles.size()+addedOtherNonXMLFiles.size()+addedOtherXMLFiles.size()+addedSolrFiles.size()+addedSysTableFiles.size()+addedWFFiles.size());
			totalDeletedFiles = (deletedFiles.size()+deletedSysTableFiles.size()+deletedProductModelFiles.size()+deletedOtherNonXMLFiles.size()+deletedOtherXMLFiles.size()+deletedSolrFiles.size()+deletedSysTableFiles.size()+deletedWFFiles.size());
			totalModifiedFiles = (modifiedFiles.size()+modifiedSysTableFiles.size()+modifiedProductModelFiles.size()+modifiedOtherNonXMLFiles.size()+modifiedOtherXMLFiles.size()+modifiedSolrFiles.size()+modifiedWFFiles.size());
			int notChangedFiles = ((allCustomizedFiles.size()+allCustomizedSysTableFiles.size()+allCustomizedProductModelFiles.size()+allCustomizedOtherXMLFiles.size()+allCustomizedOtherNonXMLFiles.size()+allCustomizedSysTableFiles.size()+allCustomizedSolrFiles.size()+allCustomizedWFFiles.size())-(totalAddedFiles+totalDeletedFiles+totalModifiedFiles));
			Number numberCell0 = new jxl.write.Number(4, 9, notChangedFiles, createFormatCellStatus(false));
			Number numberCell1 = new jxl.write.Number(4, 10,totalAddedFiles , createFormatCellStatus(false));
			Number numberCell2 = new jxl.write.Number(4, 11, totalModifiedFiles, createFormatCellStatus(false));
			Number numberCell3 = new jxl.write.Number(4, 12,totalDeletedFiles, createFormatCellStatus(false));

			modifiedFile.addCell(numberCell0);
			modifiedFile.addCell(numberCell1);
			modifiedFile.addCell(numberCell2);
			modifiedFile.addCell(numberCell3);

		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			modifiedFile.addCell(l0);
			modifiedFile.addCell(l1);
			modifiedFile.addCell(l2);
			modifiedFile.addCell(l3);
			modifiedFile.addCell(l4);
			modifiedFile.addCell(l5);

		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		for (int length1 = 0; length1 < addedProductModelFiles.size(); length1++) {
			Label addedData = new Label(0, length++, addedProductModelFiles.get(length1));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		//Sys Table
		for (int length2 = 0; length2 < addedSysTableFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedProductModelFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//WF
		for (int length2 = 0; length2 < addedWFFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedWFFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//Solr
		for (int length2 = 0; length2 < addedSolrFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedSolrFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//System data Configuration
		for (int length2 = 0; length2 < addedSysDataFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedSysDataFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		//Other XML Files
		for (int length2 = 0; length2 < addedOtherXMLFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedOtherXMLFiles.get(length2));
			try {
				addedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		//Other non-XML Files
		for (int length2 = 0; length2 < addedOtherNonXMLFiles.size(); length2++) {
			Label addedData = new Label(0, length++, addedOtherNonXMLFiles.get(length2));
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
		for (int length1 = 0; length1 < deletedProductModelFiles.size(); length1++) {
			Label addedData = new Label(0, length++, deletedProductModelFiles.get(length1));
			try {
				deletedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Sys Table
		for (int length2 = 0; length2 < deletedSysTableFiles.size(); length2++) {
			Label addedData = new Label(0, length++, deletedSysTableFiles.get(length2));
			try {
				deletedFile.addCell(addedData);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

			//WF
			for (int length3 = 0; length3 < deletedWFFiles.size(); length3++) {
				Label addedData = new Label(0, length++, deletedWFFiles.get(length3));
				try {
					deletedFile.addCell(addedData);
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				//Solr
				for (int length4 = 0; length4 < deletedSolrFiles.size(); length4++) {
					Label addedData = new Label(0, length++, deletedSolrFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//System data Configuration
				for (int length4 = 0; length4 < deletedSysDataFiles.size(); length4++) {
					Label addedData = new Label(0, length++, deletedSysDataFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Other XML
				for (int length4 = 0; length4 < deletedOtherXMLFiles.size(); length4++) {
					Label addedData = new Label(0, length++, deletedOtherXMLFiles.get(length4));
					try {
						deletedFile.addCell(addedData);
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Other XML
				for (int length4 = 0; length4 < deletedOtherNonXMLFiles.size(); length4++) {
					Label addedData = new Label(0, length++, deletedOtherNonXMLFiles.get(length4));
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
			Label file = new Label(0, 0, "File",createFormatCellStatus(true));
			Label mainPath = new Label(1, 0, "Path",createFormatCellStatus(true));
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
				for (int length1 = 0; length1 < modifiedProductModelFiles.size(); length1++) {
					Label addedData = new Label(0, length++, modifiedProductModelFiles.get(length1).getName());
					Label path = new Label(1, length-1, modifiedProductModelFiles.get(length1).getAbsolutePath());
					try {
						modifiedFile.addCell(addedData);
						modifiedFile.addCell(path);

					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				//Sys Table
				for (int length2 = 0; length2 < modifiedSysTableFiles.size(); length2++) {
					Label addedData = new Label(0, length++, modifiedSysTableFiles.get(length2).getName());
					Label path = new Label(1, length-1, modifiedSysTableFiles.get(length2).getAbsolutePath());
					try {
						modifiedFile.addCell(addedData);
						modifiedFile.addCell(path);

					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
				//WF
						for (int length2 = 0; length2 < modifiedWFFiles.size(); length2++) {
							Label addedData = new Label(0, length++, modifiedWFFiles.get(length2).getName());
							Label path = new Label(1, length-1, modifiedWFFiles.get(length2).getAbsolutePath());
							try {
								modifiedFile.addCell(addedData);
								modifiedFile.addCell(path);

							} catch (WriteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						//Solr 
								for (int length2 = 0; length2 < modifiedSolrFiles.size(); length2++) {
									Label addedData = new Label(0, length++, modifiedSolrFiles.get(length2).getName());
									Label path = new Label(1, length-1, modifiedSolrFiles.get(length2).getAbsolutePath());
									try {
										modifiedFile.addCell(addedData);
										modifiedFile.addCell(path);

									} catch (WriteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								//System data Configuration
								for (int length2 = 0; length2 < modifiedSysDataFiles.size(); length2++) {
									Label addedData = new Label(0, length++, modifiedSysDataFiles.get(length2).getName());
									Label path = new Label(1, length-1, modifiedSysDataFiles.get(length2).getAbsolutePath());
									try {
										modifiedFile.addCell(addedData);
										modifiedFile.addCell(path);

									} catch (WriteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								//Other XML Files 
										for (int length2 = 0; length2 < modifiedOtherXMLFiles.size(); length2++) {
											Label addedData = new Label(0, length++, modifiedOtherXMLFiles.get(length2).getName());
											Label path = new Label(1, length-1, modifiedOtherXMLFiles.get(length2).getAbsolutePath());
											try {
												modifiedFile.addCell(addedData);
												modifiedFile.addCell(path);

											} catch (WriteException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										//Other XML Files 
										for (int length2 = 0; length2 < modifiedOtherNonXMLFiles.size(); length2++) {
											Label addedData = new Label(0, length++, modifiedOtherNonXMLFiles.get(length2).getName());
											Label path = new Label(1, length-1, modifiedOtherNonXMLFiles.get(length2).getAbsolutePath());
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
			Label ModifiedFile = new Label(0, 0, "Modified File", createFormatCellStatus(true));
			Label ModifedData = new Label(1, 0, "Modified Data", createFormatCellStatus(true));
			changedFile.addCell(ModifiedFile);
			changedFile.addCell(ModifedData);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Map.Entry entry : changedFiles.entrySet()) {
			@SuppressWarnings("unlikely-arg-type")
			Label addedData = null;
			Label addedData1 = null;
			try {
				addedData = new Label(0, i, (String) entry.getValue(), createFormatCellStatus(false));
				addedData1 = new Label(1, i, entry.getKey().toString(), createFormatCellStatus(false));

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
		createData(totalAddedRows, totalModifiedRows, totalDeletedRows, totalNotChangedRows, 1,wb.getSheet(0),"",false);
		wb.write();
		try {
			wb.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("created excel sheet");

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
 }
}

public static void readData(WritableWorkbook wb) {

		String [] sheetNames = wb.getSheetNames();
     Sheet sheet=null;
	     for (int sheetNumber =5; sheetNumber < sheetNames.length; sheetNumber++){
	        sheet=wb.getSheet(sheetNames[sheetNumber]);
	       // System.out.println("-----Sheet Name-----"+sheet.getName()+"------"+sheet.getCell(9, 9).getColumn()+"----"+sheet.getCell(9, 10).getColumn()+"------"+sheet.getCell(9, 11).getColumn()+"-----"+sheet.getCell(9, 12).getColumn());
			 
			  totalNotChangedRows = totalNotChangedRows+ Double.parseDouble(sheet.getCell(9, 9).getContents());
			  totalAddedRows = totalAddedRows+ Double.parseDouble(sheet.getCell(9, 10).getContents());
			  totalModifiedRows = totalModifiedRows+ Double.parseDouble(sheet.getCell(9, 11).getContents());
			  totalDeletedRows = totalDeletedRows+ Double.parseDouble(sheet.getCell(9, 12).getContents());
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
			createData(addedRow, modifiedRow, deletedRow, notChangedRow, Weight,modifiedFile,Weightage,true);
	}

//create Data
	
	public static void createData(double addedRow,double modifiedRow,double deletedRow,double notChangedRow,double Weight,WritableSheet modifiedFile,String Weightage,boolean weightageorNot) {
		try {
			
			Label l1;
			Label l2;
			Label l3;
			Label l4;
			Label l5;

			Label l6;
			Label l7;
			Label l8;
			Label l9;
			Label l10;
			Label l11;
			Label l12;
			Label l13;
			Label l14 = null;

			Label l15;
			Label l17;
			Label l18;
			Label l19;
			Label l20;
			Label l21;
			Label l22;
			Label l23;
			Label l24;
			Label l25;
			Label l26;
			Label l27;
			Label l16;

			try {
		//		l1 = new Label(6, 6, "Entity Data", createFormatCellStatus(true));
				l2 = new Label(6, 8, "Change Type", createFormatCellStatus(true));
				l3 = new Label(7, 8, "Category", createFormatCellStatus(true));
				l4 = new Label(8, 8, "Number of Files", createFormatCellStatus(true));
				l5 = new Label(9, 8, "Weighted Files", createFormatCellStatus(true));

				l6 = new Label(6, 9, "Not Changed", createFormatCellStatus(false));
				l7 = new Label(6, 10, "Added By Customer", createFormatCellStatus(false));
				l8 = new Label(6, 11, "Edited By Customer", createFormatCellStatus(false));
				l9 = new Label(6, 12, "Deleted By Customer", createFormatCellStatus(false));

				l10 = new Label(7, 9, "A", createFormatCellStatus(false));
				l11 = new Label(7, 10, "C", createFormatCellStatus(false));
				l12 = new Label(7, 11, "B", createFormatCellStatus(false));
				l13 = new Label(7, 12, "B", createFormatCellStatus(false));
                
				if(weightageorNot)
				l14 = new Label(6, 14, Weightage, createFormatCellStatus(false));

				l15 = new Label(11, 8, "Category", createFormatCellStatus(true));
				l16 = new Label(11, 9, "A", createFormatCellStatus(false));
				l17 = new Label(11, 10, "B", createFormatCellStatus(false));
				l18 = new Label(11, 11, "C", createFormatCellStatus(false));
				l19 = new Label(11, 13, "(B+C)", createFormatCellStatus(false));
				l20 = new Label(11, 14, "(A+B)", createFormatCellStatus(false));
				l21 = new Label(11, 15, "(B+C)/(A+B)", createFormatCellStatus(false));
				l22 = new Label(11, 16, "(B+C)/(A+B)*100", createFormatCellStatus(false));
				l23 = new Label(11, 17, "100-(B+C)/(A+B)*100", createFormatCellStatus(false));
				l24 = new Label(11, 12, "Formula Componenets", createFormatCellStatus(true));

				l25 = new Label(12, 12, "Values", createFormatCellStatus(true));

				l26 = new Label(12, 8, "Totals", createFormatCellStatus(true));

				l27 = new Label(14, 8, "File Type Conformity", createFormatCellStatus(true));

			//	modifiedFile.addCell(l1);
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
	numberCell2 = new jxl.write.Number(8, 10, totalAddedFiles, createFormatCellStatus(false));
	numberCell3 = new jxl.write.Number(8, 11, totalModifiedFiles, createFormatCellStatus(false));
	numberCell4 = new jxl.write.Number(8, 12, totalDeletedFiles, createFormatCellStatus(false));
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
