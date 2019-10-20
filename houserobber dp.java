// here time complexity is O(n) and space complexity is O(1)
//works well
class Solution {
    public int rob(int[] nums) {
        // edge case
        if(nums.length==0|| nums==null) return 0;

   int [][] dp= new int [nums.length][2];
        //here rows will be number of houses where as columns will be 2 options chosen or not chosen.
        dp[0][0]=0;
        dp[0][1]=nums[0];
        // iterating through the array and filling the matrix
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                // for not chosen case we need to find maximum of the previous row to know uptil now what is the maximum amount .
                if(j==0)
                {
                    dp[i][j]=Math.max(dp[i-1][0],dp[i-1][1]);
                }
                else
                    dp[i][j]=dp[i-1][0]+nums[i];
            }
        }
        int a=dp.length;
        return Math.max(dp[a-1][0],dp[a-1][1]);

     }
}
