import java.io.*;
import java.util.*;

public class accounts{

	public static List<List<Integer>> findMatchSet(Map<Integer, List<Integer>> custAcctMap){
		
		List<List<Integer>> acctList = new ArrayList<List<Integer>>();
		if(custAcctMap.isEmpty())
			return acctList;

		Map<Integer, List<Integer>> sortedMap = new HashMap<Integer, List<Integer>>();

		for(Map.Entry<Integer, List<Integer>> acctPair :custAcctMap.entrySet()){
			List<Integer> sortedAccts = acctPair.getValue();
			Collections.sort(sortedAccts);
			sortedMap.put(acctPair.getKey(), sortedAccts);
		}
		System.out.println("Sorted Map: " + sortedMap);

		for(Map.Entry<Integer, List<Integer>> actPair :sortedMap.entrySet()){
			for(Map.Entry<Integer, List<Integer>> compPair :sortedMap.entrySet()){
				List<Integer> accs = new ArrayList<Integer>();
				int acct1 = actPair.getKey();
				int acct2 = compPair.getKey(); 
				accs.add(acct1);
				accs.add(acct2);
				List<Integer> sortedacs = new ArrayList<Integer>();
				sortedacs = accs;
			//	Collections.sort(accs);
				//System.out.println("accts: " + accs + "sorted: " + sortedacs);
				if(!acctList.containsAll(accs) && !acctList.containsAll(sortedacs)){
					if((acct1 != acct2) && actPair.getValue().equals(compPair.getValue())){
					//if(){
						acctList.add(accs);
						//acctList.add(compPair.getKey());
					}
				}
			}

		}
		return acctList;
	}

	public static void main(String[] args) throws IOException{
		File myObj = new File("customer.txt");
		Scanner scan = new Scanner(myObj);

		Map<Integer, List<Integer>> custAcctMap = new HashMap<Integer, List<Integer>>();
		//Map<String, List<String>> myFileMaps = new HashMap<String, List<String>>();

		while (scan.hasNextLine()){
			String strLn="";
		
			strLn = scan.nextLine();
			String[] vals = strLn.split(":");
		//	Integer[] values = Integer.parseInt(strLn.split(":"));
			if(vals.length > 0 ){
				int cust = Integer.parseInt(vals[0]);
				int acct = Integer.parseInt(vals[1]);
				if(custAcctMap.containsKey(cust)){
					List<Integer> curAccounts = new ArrayList<Integer>();
					curAccounts = custAcctMap.get(cust);
					if(!curAccounts.contains(acct))
						custAcctMap.get(cust).add(acct);
				}
				else{
					custAcctMap.put(cust, new ArrayList<Integer>());
					custAcctMap.get(cust).add(acct);
				}
			}
		}
		System.out.println("Map: " + custAcctMap);

		List<List<Integer>> acctList = new ArrayList<List<Integer>>();
		acctList = findMatchSet(custAcctMap);

		System.out.println("Matching Account Set: " + acctList);

	}
}