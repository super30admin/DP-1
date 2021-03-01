//House Robber problem
// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach-Choosing between choose and dont choose options using dynamic 
//programming

class Sample {
    
    public int rob(int[] nums) {
        if(nums==null || nums.length ==0)
        {
            return 0;
        }
         int n=nums.length ;
        int m=2;
       
        int[][] dp=new int [n][m];
        
        dp[0][0]=nums[0];
        dp[0][1]=0;
        
        for (int i=1;i<n;i++)
        {
            for(int j=0; j<m ;j++)
            {
                if(j==0)
                {
                 dp[i][j]=nums[i]+ dp[i-1][1]  ;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][0],dp[i-1][1]);
                }
            }
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
        
    }
}