import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;

class stringdecode{

	public static List<Integer> frequencyCount(String s) {
		// Write your code here
			int[] res = new int[26];
			int len = s.length();

			List<Integer> result = new ArrayList<Integer>(res.length);

			System.out.println("Received String " + s + " of Length " + len);
			
			int i = 0;
			while(i < len){
				int val = 0;
				if(i < len){

				if((i + 2 > len) || ((s.charAt(i + 1) != '#') && (s.charAt(i+2) != '&'))){//single num
					val = s.charAt(i) - '0';
					System.out.println("1. " + val );
					res[val-1]++;
					i++;
				}else if(s.charAt(i + 1) == '#'){
					
					val = 10 + (s.charAt(i) - '0') ;
					
//					System.out.println("2. " + val);
					res[val-1]++;
					i = i+2;
					System.out.println("2. " + val + " i " + i + " and that char " + s.charAt(i));

				}else if(s.charAt(i + 2) == '&'){//double num
					val = (s.charAt(i) - '0')*10 + (s.charAt(i + 1) - '0');
//					System.out.println("3. " + val);
					res[val-1]++;
					i = i + 3;
				}
			}
				if(i < len)
				{
					if(s.charAt(i) == '[')
					{
						int freq = 0;
						i++;
						while(s.charAt(i)!=']')
						{
							freq=freq*10+(s.charAt(i) - '0');
							i++;
						}
//						System.out.println("4. " + freq  + " val " + val);
						res[val-1] += freq-1;
						i++;
						System.out.println("4. " + freq  + " val " + val + " i " + i );

					}
				}		
			}
			//List<Integer> result = new ArrayList<Integer>(res.length);
			for(int j: res){
					result.add(j);
			}
			return result;
	}		



    public static void main(String[] args) throws java.lang.Exception
    {

       String bajj = "210#[2]2";
       String aabccc = "1[2]23[3]";
       String abzx = "1226&24&";
       String wwxyzwww = "23&[2]24&25&26&23&[3]";
       String aahana = "11814#11";
        List<String> input = new ArrayList<>();
        input.add(bajj);
        input.add(aabccc);
        input.add(abzx);
        input.add(wwxyzwww);
        input.add(aahana);
       // System.out.println(input);
        for(String s : input) {
			System.out.println(frequencyCount(s));
            //frequencyCount(s);
        }
    }

  }