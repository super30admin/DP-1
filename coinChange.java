//Time Complexity:O(S*n) where S is the amount and n is the number of iterations.
//Space Complexity:O(S) 
// In this program, I'll be creating an extra space for the memoization table. I'll fill up the array till amount +1. I'll be having two loops, with the outer loop iterating through the amount and the inner loop for the length of the coins array. Inside the loop I'll check if the denomination is less than my amount. In that case, I'll take the minumum of that +1 as my dp[i].If my Dp[amount] is greater than amount, then I'll return -1. Else I'll return the dp[amount].
//This program was executed successfully and got accepted in leetcode.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
            
        }
        return dp[amount]>amount?-1:dp[amount];
    }
} 