
//Recursion Solution
//Time complexity: exponential 2 pow m+n
//space complexity: o(m+n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;
        return helper(coins, amount, 0, 0);
    }
    private int helper(int[] coins, int amount, int index, int count){
        //base case
        if(index>=coins.length || amount < 0)
            return -1;
        if(amount == 0)
            return count;
        //logic
        int case1 = helper(coins,amount, index+1,count);
        int case2 = helper(coins,amount - coins[index], index, count+1);
        if(case1 == -1)
            return case2;
        if(case2 == -1)
            return case1;
        return Math.min(case1,case2);
    }
}

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


//House Robbing
//Time complexity: exponential 2 pow n
//space complexity: o(n)
//Recursion
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int amount, int index){
        //base case
        if(index>=nums.length)
            return amount;
        //logic
        int case1 = helper(nums,amount, index+1);
        int case2 = helper(nums,amount+nums[index], index+2);
        return Math.max(case1, case2);
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