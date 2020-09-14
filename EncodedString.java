package com.foo.interviews.nbdbank.ccr;

import java.util.ArrayList;
import java.util.List;


class Result{

	public static List<Integer> frequencyCount(String s) {
		// Write your code here
			int[] res = new int[26];
			int len = s.length();
			int i = 0;
			while(i < len){
				int val = 0;
				if(i + 2 >= len || s.charAt(i + 2) != '#'){//single num
					val = s.charAt(i) - '0';
					res[val - 1]++;
					i++;
				}else if(s.charAt(i + 2) == '&'){//double num
					val = (s.charAt(i) - '0')*10 + (s.charAt(i + 1) - '0');
					res[val - 1]++;
					i = i + 3;
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
						res[val - 1] += freq - 1;
						i++;
					}
				}
			}
			List<Integer> result = new ArrayList<Integer>(res.length);
				for(int j: res){
					result.add(j);
				}
			return result;
	}		

}

public class Decode{
	
    public static void main(String[] args) throws java.lang.Exception
    {

        String bajj = "2110#(2)";
     //   String aabccc = "1(2)23(3)";
       // String abzx = "1226#24#";
        //String wwxyzwww = "23#(2)24#25#26#23#(3)";
       // String jude = "2110#";
        List<String> input = new ArrayList<>();
        input.add(bajj);

        for(String s : input) {
			System.out.println(Result.frequencyCount(s));
            //frequencyCount(s);
        }
    }

  }