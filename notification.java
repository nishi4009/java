import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class notification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notices = 0;

       // notices = expenditure.length;
        //System.out.println("notices: " + notices);

        int lastSum = 0;
        if(expenditure.length < d)
            return 0;

        double avg = 0.0;
        int[] temp = new int[201];

        for(int i = 0; i< d ; i++){
            temp[expenditure[i]]++;
        }
        System.out.println(temp.length);

        for(int i = d; i<expenditure.length; i++){
           int mid = getmedian(temp, d);
           System.out.println("mid: " + mid);
            if(mid <= expenditure[i]){
                notices++;
            }
            temp[expenditure[i-d]]--;
            temp[expenditure[i]]++;
            
        }
        System.out.println("notices: " + notices);
        return notices;



    }

    private static int getmedian(int[] arr, int d){
        int sum = 0;
        for(int i = 0; i<d; i++){
            sum += arr[i];
            System.out.println(arr[i] + " sum: " + sum + " d: " + d);
           
            if((2*sum) == d){
                return (2*i+1);
            }else if((2*sum) > d){
                return (i*2);
            }

        }
        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Java/ans.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
