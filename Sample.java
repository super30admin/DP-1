// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach
class Solution {
    int[][] dp=new int[coins.length+1][amount+1];
    public int coinChange(int[] coins, int amount) {
        int count=0;
        return magical_recursive(coins,amount,0,count);
    }
    
    public int magical_recursive(int[] coins,int amount,int index,int count){
        if(coins.length<=index || amount<0){
            return -1;
        }
        if(amount==0){
            return count;
        }
        int c1=magical_recursive(coins,amount,index+1,count);
        int c2=magical_recursive(coins,amount-coins[index],index,count+1);
        if(c1==-1){
            return c2;
        }
        if(c2==-1){
            return c1;
        }
        return Math.min(c1,c2);
    }
    
}
// house robber

class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
           
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
           
        }
        
        return dp[dp.length-1];
        
    }
}