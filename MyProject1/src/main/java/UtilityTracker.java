import java.io.File;

public class UtilityTracker{


	public static void addBaseFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				addBaseFiles(file.listFiles());
			} else if (!file.getAbsolutePath().contains("\\webSrc\\")
					&& !file.getAbsolutePath().contains("\\deploy\\resources\\css\\gen") && file.isFile()) {
			if(!file.getAbsolutePath().contains("\\config\\resources\\productmodel") && !file.getAbsolutePath().contains("\\config\\resources\\systables") && !file.getAbsolutePath().contains("\\config\\workflow")
					&& !file.getAbsolutePath().contains("\\gsrc\\gw\\solr") && MergeTracker.checkFileExtension(file) && !file.getAbsolutePath().contains("\\config\\import")) {
				MergeTrackerConstants.baseFileNames.add(file.getName());
				MergeTrackerConstants.allBaseFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\productmodel")) {
				MergeTrackerConstants.baseFileProductModelNames.add(file.getName());
				MergeTrackerConstants.allBaseProductModelFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\systables")) {
				MergeTrackerConstants.baseFileSysTableNames.add(file.getName());
				MergeTrackerConstants.allBaseSysTableFiles.add(file);
		}else if(file.getAbsolutePath().contains("\\config\\workflow")) {
			MergeTrackerConstants.baseFileWFNames.add(file.getName());
			MergeTrackerConstants.allBaseWFFiles.add(file);
	 }else if(file.getAbsolutePath().contains("\\gsrc\\gw\\solr")) {
		 MergeTrackerConstants.baseFileSolrNames.add(file.getName());
		 MergeTrackerConstants.allBaseSolrFiles.add(file);
	}else if(file.getAbsolutePath().contains("\\config\\import")) {
		MergeTrackerConstants.baseFileSysDataNames.add(file.getName());
		MergeTrackerConstants.allBaseSysDataFiles.add(file);
}else if(file.getName().endsWith(".xml") && !file.getAbsolutePath().contains("\\config\\import")) {
	MergeTrackerConstants.baseFileOtherXMLNames.add(file.getName());
	MergeTrackerConstants.allBaseOtherXMLFiles.add(file);
    } else {
    	MergeTrackerConstants.baseFileOtherNonXMLNames.add(file.getName());
    	MergeTrackerConstants.allBaseOtherNonXMLFiles.add(file);
          }
     	}
	}
}

	public static void addCustomizedFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				addCustomizedFiles(file.listFiles());
			} else if (MergeTracker.skipDirectories(file) && file.isFile()) {
				if(!file.getAbsolutePath().contains("\\config\\resources\\productmodel")&& !file.getAbsolutePath().contains("\\config\\resources\\systables")
						&& !file.getAbsolutePath().contains("\\config\\workflow")
						&& !file.getAbsolutePath().contains("\\gsrc\\gw\\solr") && MergeTracker.checkFileExtension(file) && !file.getAbsolutePath().contains("\\config\\import")) {
					MergeTrackerConstants.customizedFileNames.add(file.getName());
					MergeTrackerConstants.allCustomizedFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\productmodel")) {
				MergeTrackerConstants.customizedFileProductModelNames.add(file.getName());
				MergeTrackerConstants.allCustomizedProductModelFiles.add(file);
			} else if(file.getAbsolutePath().contains("\\config\\resources\\systables")) {
				MergeTrackerConstants.customizedFileSysTableNames.add(file.getName());
				MergeTrackerConstants.allCustomizedSysTableFiles.add(file);
		}else if(file.getAbsolutePath().contains("\\config\\workflow")) {
			MergeTrackerConstants.customizedFileWFNames.add(file.getName());
			MergeTrackerConstants.allCustomizedWFFiles.add(file);
	 }else if(file.getAbsolutePath().contains("\\gsrc\\gw\\solr")) {
		 MergeTrackerConstants.customizedFileSolrNames.add(file.getName());
		 MergeTrackerConstants.allCustomizedSolrFiles.add(file);
	}else if(file.getAbsolutePath().contains("\\config\\import")) {
		MergeTrackerConstants.customizedFileSysDataNames.add(file.getName());
		MergeTrackerConstants.allCustomizedSysDataFiles.add(file);
}else if(file.getName().endsWith(".xml") && !file.getAbsolutePath().contains("\\config\\import")) {
	MergeTrackerConstants.customizedFileOtherXMLNames.add(file.getName());
	MergeTrackerConstants.allCustomizedOtherXMLFiles.add(file);
} else {
	MergeTrackerConstants.customizedFileOtherNonXMLNames.add(file.getName());
	MergeTrackerConstants.allCustomizedOtherNonXMLFiles.add(file);
   }
  }
 }
}
}
