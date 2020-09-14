import java.io.*;
import java.util.*;

public class sampleSet{

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){

		System.out.println("Enter number of strings: ");
		int input = scan.nextInt();
		int count = 0;
		Set<String> myStrings = new HashSet<String>();

		SortedSet<String> sortedStrings = new TreeSet<String>();
		while(input-- > 0){
			String name = scan.next();
			if(myStrings.add(name)){
				
				System.out.println(count++);
			}
			sortedStrings.add(name);

		}
		scan.close();
		System.out.println("My HashSet: " + myStrings);
		System.out.println("My SortedSet: " + sortedStrings);

		for(String st:myStrings){
			System.out.print(st + " ");	
		}
		System.out.println();
		for(String str: sortedStrings){
			System.out.print(str + " ");
		}

		//String neSt = Collections.binarySearch(myStrings);
		System.out.println("binarySearch: " + Collections.binarySearch(myStrings, "nisha"));

	}
}