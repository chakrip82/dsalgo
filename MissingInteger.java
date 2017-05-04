https://codility.com/programmers/lessons/4-counting_elements/missing_integer/
// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MissingInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i< A.length; i++)
        {   
            set.add(A[i]);
        }
        
       int nextexpected = 1;
       
      int maxlen = set.size();
      
      int returnvalue = nextexpected;
      
      
      int i = 0;
      while(i < maxlen)
      {
          if(set.contains(nextexpected))
          {
              i++;
              nextexpected +=1;
              returnvalue = nextexpected;
          }
          else
          {
              returnvalue =  nextexpected;
              break;
          }
      }
          
            
      
    return returnvalue;        
        
        
    }
}
