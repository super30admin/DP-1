
public class HouseRobber {
	 public int rob(int[] nums) {
	        
	        int taken=0;
	        int nottaken=0;
	       
	    
	       int max=Integer.MIN_VALUE;
	        
	for( int i=0;i<nums.length;i++){
	    
	   int  temp= taken;
	     taken=nottaken+nums[i];
	     nottaken=Math.max(temp,nottaken);
	    max=Math.max(max,Math.max(taken,nottaken));

	}    
	        return max;
	    
	        
	        
	    }
}
