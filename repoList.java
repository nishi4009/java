import java.io.*;
import java.util.*;
import java.math.*;

class empNode{
	int empId;
	String name;
	int reportToId;
	List<empNode> subordinates;

	public empNode(String id, String empName, String rid){
		try{
			this.empId = Integer.parseInt(id);
			this.name = empName;
			this.reportToId = Integer.parseInt(rid);
		}catch(Exception e){
			System.err.println("Exception creating employee: " + e);
		}
	}

	List<empNode> getSubordinates(){
		return subordinates;
	}

	void setSubordinates(List<empNode> subordinates){
		this.subordinates = subordinates;
	}

	int getId(){
		return empId;
	}

	void setId(int id){
		this.empId = id;
	}

	String getName(){
		return name;
	}

	void setName(String name){
		this.name = name;
	}


	int getReportToId(){
		return reportToId;
	}

	void setReportToId(int rid){
		this.reportToId = rid;
	}
}


public class repoList{

	//private static final Scanner scanner = new Scanner(System.in);

	static Map<Integer, empNode> employees;
	static empNode root;

	public static void main(String[] args) throws IOException{

		employees = new HashMap<Integer, empNode>();
		readInputCreateMap();
		//buildHierarchy(root);
		//printTree(root,0);


	}

	private static void readInputCreateMap() throws IOException{
		//int t = scanner.nextInt();

		File myObj = new File("input.txt");
		Scanner scan = new Scanner(myObj);

		String strLn = "";
		empNode emp = null;
		while (scan.hasNextLine()){
			//System.out.println("Enter file entry: ");
			strLn = scan.nextLine();
			System.out.println(strLn);
			String[] values = strLn.split(":");
			if(values.length > 0){
				for (int i= 0; i< values.length; i++){
					System.out.print(values[i] + " ");
				}
				/*if(values.length > 1)
					emp = new empNode(values[0], values[1], values[2]);
				else
					emp = new empNode(values[0], values[1], "0");*/
			}
	/*		employees.put(emp.getId(), emp);
			if(emp.getReportToId() == 0){
				root = emp;
			}*/
		}
		scan.close();
	}
	
	private static List<empNode> getsuboridnatesbyId(int rid){
		List<empNode> subordinates = new ArrayList<empNode>();
		for(empNode e: employees.values()){
			if(e.getReportToId() == rid){
				subordinates.add(e);
			}
		}
		return subordinates;
	}

	private static void buildHierarchy(empNode localroot){
		empNode emp = localroot;
		List<empNode> subordinates = getsuboridnatesbyId(emp.getId());
		emp.setSubordinates(subordinates);
		if(subordinates.size() ==0){
			return;
		}
		for(empNode e: subordinates){
			buildHierarchy(e);
		}
	}

	private static void printTree(empNode root, int level){
		for(int i = 0; i< level; i++){
			System.out.print("\t");
		}
		System.out.println(root.getName());

		List<empNode> subordinates = root.getSubordinates();
		System.out.print(" ");
		for(empNode e: subordinates){
			printTree(e, level+1);
		}
	}
}