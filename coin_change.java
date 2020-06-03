// Time Complexity :O(n m) n-length of the array coins. m- array created with length amount+1
// Space Complexity :O(m) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :-
class Solution {
    public int coinChange(int[] coins, int amount) {
     int dp[]=new int[amount+1]; // to solve sub problems first and use it later in the array we create an array with length amount+1
	                             // amount +1 because we use index as amount and store the minimum coins required as values
	//edge cases
     if(amount==0 ) return 0;
     if(coins==null || coins.length==0) return -1;
	 
     Arrays.fill(dp,amount+1);// fill array values as a max amount as default
     int i=0,j=1;
     dp[0]=0; // no coins required for amount 0
     while(j<dp.length)
     {
         for(i=0;i<coins.length;i++)
         {
         if(coins[i]<=j) // checking if a coin is less than the amount
         {
             dp[j]=Math.min(dp[j],dp[j-coins[i]]+1); // performing j-coins[i] is one usage of coin and the rest copied from the subarray at the index j-coins[i] 
         }
         }
         j++;
    
     }
	 // On one worst case if the coin is 1 and amount is 10 it still takes 10 min coin changes. 
	 //Hence the condition dp[amount]<=amount 
	 //If the amount cant be made with the coins given then the default value amount+1 will be in dp thus will return -1  
        return dp[amount] <= amount? dp[amount]:-1; 
    }
}