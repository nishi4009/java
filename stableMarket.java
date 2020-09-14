import java.io.*;
import java.util.*;

public class stableMarket{

public static void findPeriod(int[] arr, int diff){
	//int[] res = new int[arr.length];
	if(arr.length == 0)
		return;

	int currStart = 0;
	int currEnd = -1;
	int finalStart = -1;
	int finalEnd = -1;
	//int resIndex = 0;
	 int diffCurr = 0;
	 int diffFinal = 0;

	for(int i =1; i< arr.length; i++){
		if(arr[i]-arr[currStart] != diff){
			System.out.println("curr: " + currStart + " arr: " + i + " diff: " + (arr[i]-arr[currStart]));
			currEnd = i;
		}
		else{
			//res[resIndex] = arr[i-1];
		/*	currStart = i-1;
			currEnd = i;			
			finalStart = currStart;
			//resIndex++;
			finalEnd = currEnd;*/
			if (currEnd != -1) {
                    diffCurr = currEnd - currStart;
                    diffFinal = finalEnd - finalStart;
                    if (diffCurr > diffFinal) {
                        finalStart = currStart-1;
                        finalEnd = currEnd;
                    }
                    currEnd = -1;
            }
            currStart = i;
			System.out.println("1. curr: " + currStart + " currEnd: " + currEnd+ " finalStart: " + finalStart + " finalend: " + finalEnd + " diffCurr: " + diffCurr + " diffFinal: " + diffFinal);
		}
	}

	if (currEnd != -1) {
            diffCurr = currEnd - currStart;
            diffFinal = finalEnd - finalStart;
            if (diffCurr > diffFinal) {
                finalStart = currStart;
                finalEnd = currEnd;
            }
        System.out.println("2. curr: " + currStart + " currEnd: " + currEnd+ " finalStart: " + finalStart + " finalend: " + finalEnd + " diffCurr: " + diffCurr + " diffFinal: " + diffFinal);
		
      }

	System.out.println("Final:: curr: " + currStart + " currEnd: " + currEnd+ " finalStart: " + finalStart + " finalend: " + finalEnd + " diffCurr: " + diffCurr + " diffFinal: " + diffFinal);
	if(finalEnd-finalStart > 0 ){
		//int[] res = new int[finalEnd-finalStart];
		for(int i= finalStart; i<= finalEnd; i++){
			//res[j] = arr[i];
			System.out.print(arr[i] + " ");

		}
	
	}
	return; //res;


}


public static void main(String[] args) throws IOException{
	int[] arr = {2,4,3,6,6,3};
	int[] arr2 = {1, 2, 1, 2, 2, 1, 3, 1, 1, 2, 2, 2, 2};
	int diff = 0;
	findPeriod(arr, 0);


}

}