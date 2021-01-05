


public class HouseRobber {
	
    public int rob(int[] nums) {
        
        
        if(nums.length==0 || nums==null)
            return 0;
        
//        int[][] dp= new int[nums.length][2];
        
//        dp[0][1]=nums[0];
        
        int skip=0;
        int take= nums[0];
        
        for(int i=1;i< nums.length;i++){
            
//            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]);
//            dp[i][1]= dp[i-1][0] + nums[i];
        
        	  int temp= skip;
              skip= Math.max(skip, take);
              take= temp + nums[i];
        
        
        }
        
//        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        return Math.max(skip, take);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3,1};
		
		HouseRobber objIn= new HouseRobber();
		
		System.out.println(objIn.rob(nums));

	}

}
