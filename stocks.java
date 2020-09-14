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
     * Complete the 'tracesAreSimilar' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER_ARRAY t
     */

    public static String tracesAreSimilar(List<Integer> s, List<Integer> t) {


    // Write your code here

        if(s.size() == 0 || t.size() == 0){
            return "NO";
        }
          if (s.size() != t.size()) {
            return "NO";
        }

        //HashSet<Integer> allValues = new HashSet<>();
        HashMap<Integer, Integer> allMap = new HashMap<>();
        HashMap<Integer, Integer> sMap = new HashMap<>();
        for (int i = 0, j=0; i < s.size() || j< t.size(); i ++, j++) {
             sMap.put(s.get(i), sMap.getOrDefault(s.get(i), 0)+1);
             if(i<s.size())
                allMap.put(s.get(i), allMap.getOrDefault(s.get(i), 0) +1);
             if(j<t.size()){ 
                if(allMap.containsKey(t.get(j))){
                  allMap.put(t.get(j), allMap.get(t.get(j))-1);                
                }
                else
                  allMap.put(t.get(j), 1);
              }
        }
        
        System.out.println("sMap: " + sMap);
        System.out.println("allMap: " + allMap);

        for(Map.Entry en : allMap.entrySet()){
          if((int)en.getValue() > 3)
            return "NO";
        }
        return "YES";
  }
}
public class stocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int tCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> t = IntStream.range(0, tCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.tracesAreSimilar(s, t);

        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
