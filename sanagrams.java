import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sanagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        if(s.length() == 0)
            return 0;

        Map<String, Integer> pMap = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            for(int j =i; j< s.length(); j++){
                char[] c =  s.substring(i, j+1).toCharArray();
                Arrays.sort(c);
                String str = new String(c);
                
                if(pMap.containsKey(str)){
                    pMap.put(str, pMap.get(str)+1);
                }
                else
                    pMap.put(str, 1);
            }
        }

        //System.out.println("Anagrams map: " + pMap);

        int anapairs = 0;

        for(String st : pMap.keySet()){
            int val = pMap.get(st);
            anapairs += (val *(val - 1)/2);
        }
        System.out.println("Anagram Pairs: " + anapairs);

        return anapairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
