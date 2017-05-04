//https://codility.com/programmers/lessons/4-counting_elements/max_counters/
// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        
        int[] counters = new int[N];
        
        int M = A.length;
        
        int maxvalue = 0;
        
        //check if Array is having entry whose value is N+1
        
        int actualmax = 0;
        
        for(int i=0; i< M; i++)
        {
            int val = A[i];
            
           
            if(val <= N)
            {
                counters[val-1] = Math.max(counters[val-1]+1, actualmax+1);
            
                maxvalue = Math.max(counters[val-1], maxvalue);
            }
            else if(val == (N+1))
            {
                actualmax = maxvalue;
                
                
            }
           
            
            
        }
        for(int i=0; i< N; i++)
        {
            counters[i] = Math.max(counters[i], actualmax);
        }
        
        return counters;
    }
}
