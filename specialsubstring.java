import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class specialsubstring {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long strcount = 0l;
         for(int i = 0; i<s.length(); i++){
            strcount++;
            for(int j = i+1; j<s.length(); j++){

                if(s.charAt(i) != s.charAt(j)){
                    if(2*j-i < s.length()){ 
                    int tempindex = 2*j-i;
                    System.out.println("Checking for i. "+ i + " j. "+ j + " 2*j-i: " + tempindex + " 1:str: " + s.substring(i, j) + " second substr: " + s.substring(j+1, 2*j-i+1));
                        
                    if(2*j-i < s.length() && s.substring(i, j).equals(s.substring(j+1, 2*j-i+1))){
                       
                        System.out.println(" count to increase for i. "+ i + " j. "+ j + " 2*j-i: " + tempindex + " 1:str: " + s.substring(i, j) + " second substr: " + s.substring(j+1, 2*j-i+1));
                        strcount++;
                        break;
                    }
                    else
                        break;
                    }
                }
                else{
                    System.out.println(" count to increase for i. "+ i + " j. "+ j +  " 1:str: " + s.substring(i, j) );
                       
                    strcount++;    
                }
            }
        }
       return strcount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
