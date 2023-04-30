package recursion_basic;

import java.util.Arrays;

public class SomeRecursive {
	  public boolean someRecursive(int[] arr, OddFunction odd) {
		 
	        if(arr.length<0)
	        return true;
	        else if(!odd.run(arr[0]))
	        	return someRecursive(Arrays.copyOfRange(arr, 1, arr.length),odd);
	        else
	        return true ;
	    }
	  
}
