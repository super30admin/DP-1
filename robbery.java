//Time Complexity: O(n)
//Space Complexity: O(1)
//Compiled on leet code.

class Solution {
    public int rob(int[] nums) {
        int a = nums.length;  
        if(a==0)
            return 0;
        int C =0, DC =0;								//Intializing choose and donot choose as 0 initially.
        
        for(int n: nums)								//choose is caculated by previous do not chooose and present choose.
        {
            int temp = DC;
            DC = Math.max(C, DC);						// Do not choose is will be max of previous choose and do not choose.
            C = n+temp;
        }
        return Math.max(C, DC);
        /*int [][]dp = new int[a][2];
        
        
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        for(int i=1;i<a;i++)
        {
            dp[i][0] = nums[i]+dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
    return Math.max(dp[a-1][0],dp[a-1][1]);*/
    }
}