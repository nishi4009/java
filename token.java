import java.io.*;
import java.util.*;

public class token {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        if(s.length() > 0 && s.length() < 400000){
            s = s.trim();
            String[] tokens = s.split("[ !,?.\\_'@.]+");
            System.out.println("Total Tokens: " + tokens.length);
            for(int i = 0; i<tokens.length; i++){
                System.out.println(tokens[i]);
            }
        }
        else
         System.out.println("0");
        // Write your code here.
        scan.close();
    }
}
