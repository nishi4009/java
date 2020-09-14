import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
/*
* Complete the 'worstLosingStreak' function below.
*
* The function is expected to return an INTEGER.
* The function accepts INTEGER_ARRAY nums as parameter.
*/
public static int worstLosingStreak(List<Integer> prices) {
// Write your code here
		int psize = prices.size();
	    if(prices == null || psize == 0) {
            return 0;
        }

        int diff = 0;
        int max = prices.get(0);
        
        for(int i=1;i<psize;i++) {
            System.out.println("Max " + max);
            int current = prices.get(i);
            System.out.println("Current " + current);
            if(current > max) {
            	
                max = current;
            } else {
                diff = Integer.max(diff, (max - current));
                System.out.println("Diff in between " + max +" and " + current + " is " + diff);
            }
            if(i == psize -1) {
            	System.out.println("SFinal result is " + diff);
                return diff;
            }

        }
        System.out.println("SFinal result is " + diff);
        return diff;
}

public static int worstLostStreak(List<Integer> nums)
{

	int diff = Integer.MIN_VALUE;
	int asize = nums.size() ;
	//System.out.println(" List of " + asize + "elements");
	for (int i = 0; i < asize -1; i++) {
		for (int j = i + 1; j < asize; j++) {
			if(nums.get(i) > nums.get(j)){
			diff = Integer.max(diff, nums.get(i) - nums.get(j));
			 //System.out.println("Diff between " + nums.get(i) + " and " + nums.get(j) + " is " + diff);
			}
		}
	}
	if(diff < 0)
		diff = 0;
	System.out.println("NFinal result is " + diff);
	
	return diff;

}
}


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new
		InputStreamReader(System.in));

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));
		int numsCount = Integer.parseInt(bufferedReader.readLine().trim());

		/*List<Integer> nums = new ArrayList<>(numsCount);
		Random r = new Random();
		for (int i = 0 ; i< numsCount; i++){
			nums.add(r.nextInt());
		}*/
		
		List<Integer> nums = IntStream.range(0, numsCount).mapToObj(i -> {
		try {
			return bufferedReader.readLine().replaceAll("\\s+$", "");
		} catch (IOException ex) {
		throw new RuntimeException(ex);
		}
		})
		.map(String::trim)
		.map(Integer::parseInt)
		.collect(toList());
	//System.out.println("Printing List " + nums);
	long startTime = System.nanoTime();
	int result = Result.worstLosingStreak(nums);
	long stopTime = System.nanoTime();

	/*long sTime = System.nanoTime();
	int res = Result.worstLostStreak(nums);
	Long eTime = System.nanoTime();
	*/
	bufferedWriter.write(String.valueOf(result));
	bufferedWriter.newLine();
	System.out.println("SExecution time " + (stopTime - startTime));
	//System.out.println("NExecution time " + (eTime - sTime));
	bufferedReader.close();
	bufferedWriter.close();
	}
}