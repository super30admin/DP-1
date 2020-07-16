package mediumProblems;

public class HouseRobber {
	
    public int rob(int[] nums) {
        
        if(nums.length ==0 || nums == null) return 0;
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] =0;
        dp[0][1] = nums[0];
        for(int i=1; i<dp.length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        
    }
   
// BruteForce
   
//    public int rob(int[] nums) {
       
//        if(nums == null)
//            return -1;
       
//        if(nums.length ==0)
//            return 0;
       
//        return helper(nums, 0, 0);
       
//    }
   
//    private int helper(int[] nums, int i, int sum)
//    {
   
//        if(i >= nums.length) return sum;
       
//        int choosen =  helper(nums, i+2, sum + nums[i]);
       
//        int notChossen =  helper(nums, i+1, sum); 
  
//        return Math.max(choosen, notChossen);
       
//    }
//}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
