class Solution4 {
	public int rob(int[] nums) {
		
		//	Time:  O(m*n) 
		//	Space O(m*n) 
		//	LeetCode: yes
		
		if(nums == null || nums.length ==0) return 0;
		//making a dp array        
		int [][] dp = new int [nums.length ][2];
		dp[0][0] = 0;  
		dp[0][1] = nums[0];
		for(int i = 1; i < dp.length; i++){
			for(int j =0 ; j<2 ;j++){
				if(j==0){
					dp[i][j] = Math.max(dp[i-1][0],dp[i-1][1]);
				}else{
					//not chosen from prev + curr nums
					dp[i][j] = dp[i-1][0] + nums[i];
				}
			}
		}
		int n = dp.length;
		return Math.max(dp[n-1][0], dp[n-1][1]);
	}
}