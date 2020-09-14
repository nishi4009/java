import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here

    
    	int ax = a.get(0);

    	for(int i =1; i< a.size(); i++){
    		System.out.print("lcm: " + ax + " and " + a.get(i));
    		ax = lcm(ax, a.get(i));
    		System.out.print(" is " +  ax);
    		System.out.println();
    	}

    	int bx = b.get(0);
    	for(int i = 1; i< b.size(); i++){
    		System.out.print("gcd: " + bx + " and " + b.get(i));
       		bx = gcd(bx, b.get(i));
       		System.out.print(" is " +  bx);
    		System.out.println();
    	
    	}

    	System.out.println("final lcm: "+ ax + " gcd: " + bx);

    	List<Integer> li = new ArrayList<>();
    	int temp = ax;

    	while(temp <= bx){
    		li.add(temp);
    		temp += ax;
    	}

    	System.out.println("List: " + li);

    	int counter = 0;
    	for(int f : li){
    		boolean cnt = true;
    		for(int g: b){
    			if(g%f != 0){
    				cnt = false;
    				break;
    			}    			
    		}
    		if(cnt) 
    			counter++;
    	}

    	System.out.println(counter);

    	return counter;
    }

    public static int gcd(int x, int y){
   // 	System.out.println("gcd: " + x + ", " +  y);
    	if(y==0)
    		return x;
    	return gcd(y, x%y);

    }

    public static int lcm(int x, int y){
 //   	System.out.println("lcm: " + x + ", " +  y);
    	return(x*y) /gcd(x, y);
    }

}

public class betweenSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}