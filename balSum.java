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

public class balSum {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {

        int alen =  arr.size();
        if(alen == 1)
               return "YES";
        int totalSum=0; 
        int lSum = 0;
       // System.out.println(" Arr size is " + alen);

        for(int i = 0; i< alen; i++){
            totalSum += arr.get(i);
        }

        for(int i = 0; i< alen; i++){
            if(lSum == totalSum-arr.get(i)) return "YES";
            lSum += arr.get(i);
            totalSum -= arr.get(i);
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);
                System.out.println(result);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
