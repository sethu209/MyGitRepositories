import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeTrackerConstants {
	
	static double totalNotChangedRows = 0 ;
	static double totalAddedRows = 0 ;
	static double totalDeletedRows = 0 ;
	static double totalModifiedRows = 0 ;
	
	static int totalAddedFiles = 0 ;
	static int totalDeletedFiles = 0 ;
	static int totalModifiedFiles = 0 ;
	static String base13 = null;
	static String base14 = null;

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
	


}
