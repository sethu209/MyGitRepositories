
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;

public class DeltaTracker {

	/* Find the Affected Files 
	 * Added Files , Deleted Files and Modified Files and respective counts
	 * input : Base file Names and Customized File Names
	 */
	public static void findAffectedFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				MergeTrackerConstants.deletedFiles.add(i);
				MergeTrackerConstants.allFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				MergeTrackerConstants.addedFiles.add(i);
				MergeTrackerConstants.allFiles.add(i);
			}
		}
		
		// Compare the same Base and Customized file to check the data inside teh file
		compareModifiedFiles(MergeTrackerConstants.allCustomizedFiles,false,false,false,false,false,false,false);
	}

	
	//Find Affected Product Model Files
	
	public static void findAffectedProductFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				MergeTrackerConstants.deletedProductModelFiles.add(i);
				MergeTrackerConstants.allProductModelFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				MergeTrackerConstants.addedProductModelFiles.add(i);
				MergeTrackerConstants.allProductModelFiles.add(i);
			}
		}
			compareModifiedFiles(MergeTrackerConstants.allCustomizedProductModelFiles, true,false,false,false,false,false,false);
	}
	

	//Find Affected System Table Files
	
	public static void findAffectedSysTableFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

		ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
		commonFiles.retainAll(_baseFileNames);
		HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
		uniqueFiles.addAll(_baseFileNames);
		uniqueFiles.removeAll(commonFiles);
		for (String i : uniqueFiles) {
			if (_baseFileNames.contains(i)) {
				MergeTrackerConstants.deletedSysTableFiles.add(i);
				MergeTrackerConstants.allSysTableFiles.add(i);
			} else if (_customizedFileNames.contains(i)) {
				MergeTrackerConstants.addedSysTableFiles.add(i);
				MergeTrackerConstants.allSysTableFiles.add(i);
			}
		}
				compareModifiedFiles(MergeTrackerConstants.allCustomizedSysTableFiles, false,true,false,false,false,false,false);
	}
	
	//Find Affected WF Files
	
		public static void findAffectedWFFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

			ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
			commonFiles.retainAll(_baseFileNames);
			HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
			uniqueFiles.addAll(_baseFileNames);
			uniqueFiles.removeAll(commonFiles);
			for (String i : uniqueFiles) {
				if (_baseFileNames.contains(i)) {
					MergeTrackerConstants.deletedWFFiles.add(i);
					MergeTrackerConstants.allWFFiles.add(i);
				} else if (_customizedFileNames.contains(i)) {
					MergeTrackerConstants.addedWFFiles.add(i);
					MergeTrackerConstants.allWFFiles.add(i);
				}
			}
			compareModifiedFiles(MergeTrackerConstants.allCustomizedWFFiles, false,false,true,false,false,false,false);
		}
		
		
		//Find Affected Solr Files
		
			public static void findAffectedSolrFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

				ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
				commonFiles.retainAll(_baseFileNames);
				HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
				uniqueFiles.addAll(_baseFileNames);
				uniqueFiles.removeAll(commonFiles);
				for (String i : uniqueFiles) {
					if (_baseFileNames.contains(i)) {
						MergeTrackerConstants.deletedSolrFiles.add(i);
						MergeTrackerConstants.allSolrFiles.add(i);
					} else if (_customizedFileNames.contains(i)) {
						MergeTrackerConstants.addedSolrFiles.add(i);
						MergeTrackerConstants.allSolrFiles.add(i);
					}
				}
				compareModifiedFiles(MergeTrackerConstants.allCustomizedSolrFiles, false,false,false,true,false,false,false);
			}
			
			//Find Affected System data Files
			
				public static void findAffectedSysDataFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

					ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
					commonFiles.retainAll(_baseFileNames);
					HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
					uniqueFiles.addAll(_baseFileNames);
					uniqueFiles.removeAll(commonFiles);
					for (String i : uniqueFiles) {
						if (_baseFileNames.contains(i)) {
							MergeTrackerConstants.deletedSysDataFiles.add(i);
							MergeTrackerConstants.allSysDataFiles.add(i);
						} else if (_customizedFileNames.contains(i)) {
							MergeTrackerConstants.addedSysDataFiles.add(i);
							MergeTrackerConstants.allSysDataFiles.add(i);
						}
					}
					compareModifiedFiles(MergeTrackerConstants.allCustomizedSysDataFiles, false,false,false,false,false,false,true);
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
						MergeTrackerConstants.deletedOtherXMLFiles.add(i);
						MergeTrackerConstants.allOtherXMLFiles.add(i);
					} else if (_customizedFileNames.contains(i)) {
						MergeTrackerConstants.addedOtherXMLFiles.add(i);
						MergeTrackerConstants.allOtherXMLFiles.add(i);
					}
				}
				compareModifiedFiles(MergeTrackerConstants.allCustomizedOtherXMLFiles, false,false,false,false,true,false,false);
}		
//Other non-XML Files

public static void findAffectedOtherNonXMLFiles(ArrayList<String> _baseFileNames, ArrayList<String> _customizedFileNames) {

	ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
	commonFiles.retainAll(_baseFileNames);
	HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
	uniqueFiles.addAll(_baseFileNames);
	uniqueFiles.removeAll(commonFiles);
	for (String i : uniqueFiles) {
		if (_baseFileNames.contains(i)) {
			MergeTrackerConstants.deletedOtherNonXMLFiles.add(i);
			MergeTrackerConstants.allOtherNonXMLFiles.add(i);
		} else if (_customizedFileNames.contains(i)) {
			MergeTrackerConstants.addedOtherNonXMLFiles.add(i);
			MergeTrackerConstants.allOtherNonXMLFiles.add(i);
		}
	}
	compareModifiedFiles(MergeTrackerConstants.allCustomizedOtherNonXMLFiles, false,false,false,false,false,true,false);
}		

/*
 * Find the respective base file of the current customized file and do the data comparison
 * store the changed files to the respective Modified list array
 * ChangedData - Captures the data changes and respective file
 */

public static void compareModifiedFiles(ArrayList<File> files, boolean productModelorNot,boolean sysTableorNot,boolean wfOrNot,
			boolean solrorNot,boolean otherXMLorNot,boolean otherNonXMLorNot,boolean sysDataorNot) {
		File bFile;
		for (File cFile : files) {
			if (MergeTracker.skipDirectories(cFile)) {
                 if(productModelorNot) {
			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseProductModelFiles);
                 }else if(sysTableorNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseSysTableFiles);
                 }else if(wfOrNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseWFFiles);
                 } else if(solrorNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseSolrFiles);
                 } else if(sysDataorNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseSysDataFiles);
                 }else if(otherXMLorNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseOtherXMLFiles);
                 } else if(otherNonXMLorNot){
 			        bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseOtherNonXMLFiles);
                 }  else {
                 bFile = MergeTracker.findBasedFile(cFile, MergeTrackerConstants.allBaseFiles);
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
					        		if(tmpList != null && tmpList.size()>0 && !(tmpList.contains("[]") || tmpList.contains("[ ]"))) {
										MergeTrackerConstants.changedData.put(tmpList, cFile.getName());
									}
									totalChanges.addAll(tmpList);
                                 tmpList = list2;
					            tmpList.removeAll(list1);
					         
					            // To prevent the null array data from storing in to changed data set.
					            if(tmpList != null && tmpList.size() > 0 && !(tmpList.contains("[ ]") || tmpList.contains("[]"))) {
									MergeTrackerConstants.changedData.put(tmpList, cFile.getName());
									}
								
					            totalChanges.addAll(tmpList);
							if (totalChanges.size() > 0 && !cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") 
									&& !cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !cFile.getAbsolutePath().contains("\\config\\workflow")
									&& !cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !cFile.getAbsolutePath().contains("\\config\\import") && MergeTracker.checkFileExtension(cFile)) {
								MergeTrackerConstants.modifiedFiles.add(cFile);
								MergeTrackerConstants.modifiedNameFiles.add(cFile.getName());
								MergeTrackerConstants.allFiles.add(cFile.getName());
							}else if(totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") && !MergeTrackerConstants.modifiedProductModelFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedProductModelNameFiles.contains(cFile.getName()) ) {
								MergeTrackerConstants.modifiedProductModelNameFiles.add(cFile.getName());
								MergeTrackerConstants.modifiedProductModelFiles.add(cFile);
								MergeTrackerConstants.allProductModelFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !MergeTrackerConstants.modifiedSysTableFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedSysTableNameFiles.contains(cFile.getName())) {
								MergeTrackerConstants.modifiedSysTableFiles.add(cFile);
								MergeTrackerConstants.modifiedSysTableNameFiles.add(cFile.getName());
								MergeTrackerConstants.allSysTableFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\workflow") && !MergeTrackerConstants.modifiedWFFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedWFNameFiles.contains(cFile.getName())) {
								MergeTrackerConstants.modifiedWFFiles.add(cFile);
								MergeTrackerConstants.modifiedWFNameFiles.add(cFile.getName());
								MergeTrackerConstants.allWFFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !MergeTrackerConstants.modifiedSolrFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedSolrNameFiles.contains(cFile.getName())) {
								MergeTrackerConstants.modifiedSolrFiles.add(cFile);
								MergeTrackerConstants.modifiedSolrNameFiles.add(cFile.getName());
								MergeTrackerConstants.allSolrFiles.add(cFile.getName());
							} else if (totalChanges.size() > 0 && cFile.getAbsolutePath().contains("\\config\\import") && !MergeTrackerConstants.modifiedSysDataFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedSysDataNameFiles.contains(cFile.getName())) {
								MergeTrackerConstants.modifiedSysDataFiles.add(cFile);
							MergeTrackerConstants.modifiedSysDataNameFiles.add(cFile.getName());
								MergeTrackerConstants.allSysDataFiles.add(cFile.getName());
							}else if (totalChanges.size() > 0 && !cFile.getAbsolutePath().contains("\\config\\resources\\productmodel") 
									&& !cFile.getAbsolutePath().contains("\\config\\resources\\systables") && !cFile.getAbsolutePath().contains("\\config\\workflow")
									&& !cFile.getAbsolutePath().contains("\\gsrc\\gw\\solr") && !cFile.getAbsolutePath().contains("\\config\\import") 
									&& cFile.getName().endsWith(".xml") && !MergeTrackerConstants.modifiedOtherXMLFiles.contains(cFile) 
									&& !MergeTrackerConstants.modifiedOtherXMLNameFiles.contains(cFile.getName())) {
								MergeTrackerConstants.modifiedOtherXMLFiles.add(cFile);
								MergeTrackerConstants.modifiedOtherXMLNameFiles.add(cFile.getName());
								MergeTrackerConstants.allOtherXMLFiles.add(cFile.getName());
							} else if(totalChanges.size() > 0  && !cFile.getName().endsWith(".xml") && !MergeTracker.checkFileExtension(cFile) && !MergeTrackerConstants.modifiedOtherNonXMLFiles.contains(cFile) 
									 && !MergeTrackerConstants.modifiedOtherNonXMLNameFiles.contains(cFile.getName())){
								MergeTrackerConstants.modifiedOtherNonXMLFiles.add(cFile);
								MergeTrackerConstants.modifiedOtherNonXMLNameFiles.add(cFile.getName());
								MergeTrackerConstants.allOtherNonXMLFiles.add(cFile.getName());	
								}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


}
