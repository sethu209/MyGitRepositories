import org.apache.commons.io.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class mergeTracker {

static ArrayList<File> allBaseFiles = new ArrayList<>();
static ArrayList<File> allCustomizedFiles = new ArrayList<>();


static ArrayList<String> baseFileNames = new ArrayList<>();
static ArrayList<String> customizedFileNames = new ArrayList<>();
static ArrayList<File> modifiedFiles = new ArrayList<>();
	
public static void main(String[] args) {

File baseDirectory = new File("C:/Users/SethuLankala/Downloads/BillingCenter1001/modules/base/base");
File customizedDirectory = new File("C:/Users/SethuLankala/Downloads/BillingCenter1001/modules/configuration");


addBaseFiles(baseDirectory.listFiles());
addCustomizedFiles(customizedDirectory.listFiles());
findAffectedFiles(baseFileNames, customizedFileNames);
displayModifiedFiles(modifiedFiles);
}

public static void addBaseFiles(File[] files) {
  for (File file : files) {
    if (file.isDirectory()) {
      addBaseFiles(file.listFiles());
    } else if(!file.getAbsolutePath().contains("\\webSrc\\") && file.isFile()) {
      baseFileNames.add(file.getName());
      allBaseFiles.add(file);

    }
  }
}

public static void addCustomizedFiles(File[] files) {
  for (File file : files) {
    if (file.isDirectory()) {
      addCustomizedFiles(file.listFiles());
    } else if(skipDirectories(file) && file.isFile()) {
      customizedFileNames.add(file.getName());
      allCustomizedFiles.add(file);
    }
  }
}

public static void findAffectedFiles(ArrayList<String> _baseFileNames , ArrayList<String> _customizedFileNames ) {
  ArrayList<String> addedFiles = new ArrayList<>();
  ArrayList<String> deletedFiles = new ArrayList<>();

  ArrayList<String> commonFiles = new ArrayList<>(_customizedFileNames);
  commonFiles.retainAll(_baseFileNames);
  HashSet<String> uniqueFiles = new HashSet<>(_customizedFileNames);
  uniqueFiles.addAll(_baseFileNames);
  uniqueFiles.removeAll(commonFiles);
  System.out.println("Newly Added/Deleted Files Count----------" + uniqueFiles.size());
  for (String i : uniqueFiles) {
    if (_baseFileNames.contains(i)) {
      deletedFiles.add(i);
    } else if (_customizedFileNames.contains(i)) {
      addedFiles.add(i);
    }
  }
  System.out.println("Added Files Count----------" + addedFiles.size());
  System.out.println("Deleted Files Count----------" + deletedFiles.size());

  for (String i : addedFiles) {
	  System.out.println("Added File--" + i);
  }
  for (String i : deletedFiles) {
	  System.out.println("Deleted File--" + i);
  }
  compareModifiedFiles(allCustomizedFiles);
}

@SuppressWarnings("resource")
public static void compareModifiedFiles( ArrayList<File> files){
    boolean isContentSame = false;
	for (File cFile : files) {
    if (skipDirectories(cFile)) {
      File bFile = findBasedFile(cFile, allBaseFiles);
      if (bFile != null && cFile != null) {
		try {
			isContentSame = FileUtils.contentEquals(cFile, bFile);
		
        if (isContentSame == false) {
          modifiedFiles.add(cFile);

          BufferedReader br1 = null;
          BufferedReader br2 = null;
          String sCurrentLine = null;
          StringBuilder sBuilder = new StringBuilder();
          ArrayList<String> list1 = new ArrayList<>();
          ArrayList<String> list2 = new ArrayList<>();
          br1 = new BufferedReader(new FileReader(bFile));
          br2 = new BufferedReader(new FileReader(cFile));
          sCurrentLine = br1.readLine();
          while (sCurrentLine != null) {
            sBuilder.append(sCurrentLine);
            sBuilder.append("-");
            sCurrentLine = br1.readLine();
            list1.add(sCurrentLine);
          }
          sCurrentLine = null;
          br1.close();
          sCurrentLine = br2.readLine();
          while (sCurrentLine != null) {
            sBuilder.append(sCurrentLine);
            sBuilder.append("-");
            sCurrentLine = br2.readLine();
            list2.add(sCurrentLine);
          }
          br2.close();
          ArrayList<String> tmpList = new ArrayList<>(list2);
          tmpList.removeAll(list1);
/*
          System.out.println("content from Customized File which is not there in Base File-- Customized File--" +cFile);
          if(tmpList.size() > 0 ) {
        	  System.out.println(tmpList); 
          }

          tmpList = list2;
          tmpList.removeAll(list1);
          */
          System.out.println("Changes in File--" +bFile.getName());

          if(tmpList.size() > 0 )
            System.out.println(tmpList) ;
        }} catch (IOException e) {
			e.printStackTrace();
		}
      }
    }
  }
}

public static File findBasedFile(File name, ArrayList<File> files)  {
  File cFile = null;
try {
    for(File file : files) {
      String bFilePath = file.getAbsolutePath().replace("C:\\Users\\SethuLankala\\Downloads\\BillingCenter1001\\modules\\base\\base","");
      String cFilePath = name.getAbsolutePath().replace("C:\\Users\\SethuLankala\\Downloads\\BillingCenter1001\\modules\\configuration","");
      if(skipDirectories(file) || file.getName()==name.getName() && bFilePath == cFilePath){
        cFile = file;
      }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  return cFile;
}

public static boolean skipDirectories(File file)  {
  return !(file.getAbsolutePath().contains("\\generated\\") || file.getAbsolutePath().contains("\\generated_classes\\")
      || file.getAbsolutePath().contains("\\build\\") || file.getAbsolutePath().contains("\\plugins\\") || file.getAbsolutePath().contains("\\webSrc\\"));
 }

public static void displayModifiedFiles(ArrayList<File> modifiedFiles2){
	System.out.println("Modified Files Count----------" + modifiedFiles2.size());
	for (File modifiedFile : modifiedFiles2) 
	{ 
		System.out.println("Modified File---"+modifiedFile.getName()+"---------Path-------"+modifiedFile);
	}
 }
}



