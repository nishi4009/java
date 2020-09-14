import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class twostrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0){
            return "NO";
        }

        Map<Character, Integer> str1 = new HashMap<>();

        for(Character ch : s1.toCharArray()){
            if(str1.containsKey(ch)){
                str1.put(ch, str1.get(ch)+1);
            }
            else
                str1.put(ch, 1);
        }

        Map<Character, Integer> str2 = new HashMap<>();

        for(Character ch : s2.toCharArray()){
            if(str2.containsKey(ch)){
                str2.put(ch, str2.get(ch)+1);
            }
            else
                str2.put(ch, 1);
        }
        
        boolean result = false;
        for(Character key : str1.keySet()){
            if(str2.containsKey(key)){
                result = true;
                break;
            }
        }

        if(result)
            return "YES";
        else
            return "NO";
      //  return "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}