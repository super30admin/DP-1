// Time Complexity :exponential
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
       return helper(amount,coins,0,0);
        
    }
    private int helper(int amount,int[]coins,int index,int coinsUsed){
        //base or terminating conditions
        if(amount== 0) return coinsUsed;
        if(amount < 0 || index== coins.length) return -1; 
        //logic
        //choose
        int case1=helper(amount - coins[index],coins,index,coinsUsed+1);
        //not choose
        int case2=helper(amount,coins,index+1,coinsUsed);
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        return Math.min(case1,case2);
    }
}

// Your code here along with comments explaining your approach

// Time Complexity :exponential 2^nm(n is demoninations,m is amount)
// Space Complexity :
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :no

class Solution {
    public int coinChange(int[] coins, int amount) {
       int [][]dp = new int[coins.length+1][amount+1];
       dp[0][0] = 0;
        for(int j =1;j<dp.length;j++){
            dp[0][j] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               //amount<denomination
               if(j<coins[i-1]){
                   dp[i][j]=dp[i-1][j];
               }else{
                   dp[i][j] =Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
               }
           }
        }
        int result = dp[dp.length-1][dp[0].length-1];
            if(result>amount) return -1;
        return result;
    }
    
}
// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
      return helper(nums,0,0);
    }
    private int helper(int []nums,int index,int amount){
        //base or terminating condition
        if(index >= nums.length) return amount;
        //logic
        //choose
        int case1=helper(nums,index+2,amount + nums[index]);
        //not choose
        int case2=helper(nums,index+1,amount);
        
        return Math.max(case1,case2);
    }
}
///////////////////////////////////////////////////////////////////////////
// Time Complexity :exponential 2^n(n is the length of the array)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
      int [][] dp = new int[nums.length][2];
        //dp[0][0] = 0;
        int x = nums.length;
        dp[0][1] = nums[0];
            for(int i =1;i<nums.length;i++){
                //case 0(not choose)
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
                //case 1 choose
                dp[i][1] = dp[i-1][0]+nums[i];
            }
        return Math.max(dp[x-1][0],dp[x-1][1]);
    }
   
}
// Time Complexity :exponential 2^n(n is the length of the array)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int skip = 0;
        int take = nums[0];
            for(int i =1;i<nums.length;i++){
                int temp = skip;
                //skip
                skip= Math.max(skip,take);
                //take
                take = temp +nums[i];
            }
        return Math.max(skip,take);
    }
   
}