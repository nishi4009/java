import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class validstring {

    // Complete the isValid function below.
    static String isValid(String s) {
       // boolean cdelete = false;
        if(s.length() == 0)
            return "NO";
        Map<Character, Integer> charmap = new HashMap<>();

        for(char ch: s.toCharArray()){
            charmap.put(ch, charmap.getOrDefault(ch, 0)+1);
        } 
        //int firstfreq = charmap.get(s.charAt(0));
        System.out.println(charmap);
        Set<Integer> freqset = new HashSet<Integer>();
        for(int val : charmap.values()){
            freqset.add(val);
        }
        System.out.println("set: " + freqset);
        int minCount = 0, maxCount = 0;
        System.out.println(freqset);
        if(freqset.size() == 1){
            return "YES";
        }
        int min = Collections.min(freqset);
        int max = Collections.max(freqset);
        System.out.println(" max: " + max + " min: " + min );//+ "maxCount: " + maxCount + " minCount: "+ minCount);
       
        if(freqset.size() > 2)
            return "NO";
        //else if(max - min > 1)
          // return "NO";
        else{
            for(int val: charmap.values()){
                if(val == max)
                    maxCount++;
                else
                    minCount++;
            }
        }
        System.out.println(" max: " + max + " min: " + min + "maxCount: " + maxCount + " minCount: "+ minCount);
       
        if((maxCount == 1 && minCount >=1) || (minCount == 1 && maxCount >=1))
            return "YES";
        
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
