

//Time complexity o(mn)
//space complexity o(mn)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int res=0;
        if(coins == null || coins.length == 0)
            return -1;
        int[][] dp = new int[coins.length+1][amount+1];
        
        //As first row coin value is zero, We cannot make amounts, initilaize it to max value;
        for(int i=1;i<dp[0].length;i++)
            dp[0][i] = 9999;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++)
            {
                if( j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]); 
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1] >= 9999)
            return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}

//Time complexity o(n)
//space o(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int prevAmount = 0;
        int curAmount = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            int temp = curAmount;
            curAmount = Math.max(curAmount, nums[i] + prevAmount);
            prevAmount = temp;
        }
        return curAmount;
    }
}