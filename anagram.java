import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
//import java.util.*;
import java.util.Scanner;

public class anagram {


    static boolean isAnagram(String a, String b) {
        // Complete the function

        if(a == null || b== null || a.equals("") || b.equals(""))
            return false;
        if(a.length() != b.length())
            return false;

        a = a.toLowerCase().replaceAll("[\\s]", "");
        b = b.toLowerCase().replaceAll("[\\s]", "");

        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();

        for(int i = 0; i<b.length(); i++){
            char letter = b.charAt(i);
            if(!map.containsKey(letter)){
                map.put(letter,1);
            }
            else
                map.put(letter, map.get(letter)+1);
        }

        for(int i = 0; i<a.length(); i++){
            char letter = a.charAt(i);
            if(!map.containsKey(letter)){
                return false;
            }
            int frec = map.get(letter);
            if(frec == 0){
                return false;
            }
            else 
                map.put(letter, --frec);
        }

        return true;

    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}