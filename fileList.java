import java.io.*;
import java.util.*;

public class fileList{

	//private static final Scanner scanner = new Scanner(System.in);

	static Map<String, List<String>> filelist;
	//static empNode root;
	static int count = 0;
	static List<String> depList = new ArrayList<String>();
	public static List<String> findDepedencies(String checkFile, Map<String, List<String>> myFilesMaps) {
		

		if(checkFile == "" || checkFile.length() == 0 || myFilesMaps.isEmpty()){
			return null;
		}
		List<String> retList = new ArrayList<String>();

		for(Map.Entry<String, List<String>> filePair :myFilesMaps.entrySet()){
			//System.out.println("Key: " + filePair.getKey() + " value: " + filePair.getValue());// = (Map.Entry)it.next();
			if(filePair.getKey().equals(checkFile)){
				if(!depList.contains(checkFile))
					depList.add(checkFile);
				List<String> tempList = filePair.getValue();
				for(int j=0;j<tempList.size();j++){
					if(!depList.contains(tempList.get(j))){
						//System.out.println("0. Adding "+ tempList.get(j));
						depList.add(tempList.get(j));

						retList = findDepedencies(tempList.get(j), myFilesMaps);
						}
				}
	
			}
			if((filePair.getValue()).contains(checkFile)){
				//System.out.println("2. adding " + filePair.getKey() + " to List");
				
				String currFile = filePair.getKey(); 

				if(!depList.contains(currFile)){
					//System.out.println("added " + currFile + "to DepList");
					depList.add(currFile);
				}
				count++;
				//System.out.println(count + ". " + depList);
				retList = findDepedencies(currFile, myFilesMaps);
			}
		}
		if(retList.size() > 0 ){
			for(int i = 0;i<retList.size(); i++){
				if(!depList.contains(retList.get(i))){
					depList.add(retList.get(i));
				}
			}
		}

		//System.out.println("Inside DepList: " + depList);
		return depList;
	}

	public static void main(String[] args) throws IOException{

		Map<String, List<String>> myFileMaps = new HashMap<String, List<String>>();
		
		File myObj = new File("input.txt");
		Scanner scan = new Scanner(myObj);

		String strLn = "";
		
		while (scan.hasNextLine()){
		
			strLn = scan.nextLine();
		//	System.out.println("1. " + strLn);
		
			String[] values = strLn.split(":");
			if(values.length > 0){
				String keyFile = values[0];
				String valueFile = values[1];
		//		System.out.println("2. Key: " + keyFile + " Value: " + valueFile);
				if(myFileMaps.containsKey(keyFile)){
					if(myFileMaps.get(keyFile).size() > 0){
						List<String> tempFiles;// = new List<String>();
						tempFiles = myFileMaps.get(keyFile);
						if(!tempFiles.contains(valueFile)){
							tempFiles.add(valueFile);
						}
					}
				}
				else{
					myFileMaps.put(keyFile, new ArrayList<String>());
					myFileMaps.get(keyFile).add(valueFile);
				}
			}
		}

		System.out.println("5. Final Map:  " + myFileMaps);
		//}
		System.out.println("Now enter value to find dependecyList: ");
		scan.close();

		Scanner scanner = new Scanner(System.in);
		String checkFile = scanner.nextLine();

		List<String> depList = new ArrayList<String>();

		depList = findDepedencies(checkFile, myFileMaps);
		if(depList.size() > 0)
			System.out.println(checkFile + " depends on " + depList);

		else
			System.out.println("No dependecies found");

		scanner.close();
		//readInputCreateMap();
		//buildHierarchy(root);
		//printTree(root,0);


	}

	//private static void readInputCreateMap() throws IOException{
	
//		}
}