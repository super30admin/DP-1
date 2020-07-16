// Time Complexity : Recursive Solution take 2^n where n is the length of coins array. With DP the complexity reduced to O(n*m) 
// where m = amount and n = number of coins in array
// Space Complexity : Recursive stack take n+m(amount + coin array length) whereas DP solution take O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        return dp_solution(coins, amount);
        }
       
        // Recursive solution
    private int helper(int[] coins, int amount, int index , int min){
            
            //Base case
            if(amount == 0 ){
                return min;
            }
            if(amount < 0 || index>= coins.length)
                return -1;
            
            //logic
        
            //chose a coin - Thsi will return -1 is the amount reached less than 0
            int choseCoin = helper(coins, amount - coins[index], index, min+1); 
                
            //Not chose a coin -- This will return -1 is the index goes beyond the lenth of coins
            int notChoseCoin = helper(coins, amount, index+1, min);
            
            if(choseCoin == -1) return notChoseCoin;
            if(notChoseCoin == -1 ) return choseCoin;
            
            return Math.min(choseCoin, notChoseCoin);    
        }            
    
    // Dynamic Programing Solution 
    
//     Construct a DP array 
   private int dp_solution(int[] coins, int amount){
    
       if(coins.length ==0 || coins ==null)
           return -1;
       
       
       int[][] dp = new int[coins.length+1][amount+1];
    
       // First number is 0 which is to be filled with 0's So first colum we are filling it with 0
    for(int i = 0;i<dp.length; i++){
        dp[i][0] = 0;
    }
    
    for(int i = 0;i<dp[0].length; i++){
        dp[0][i] = 999;
    }
    
       
     for(int i = 1;i<dp.length; i++){
        for(int j=1; j< dp[0].length ; j++)
         if(j  < coins[i-1]){
            dp[i][j] = dp[i-1][j]; 
         }else{
            dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1); 
         }
    }
       
       if(dp[dp.length -1][dp[0].length-1] == 999)
           return -1;
       // return dp[coins.length][amount];
       return dp[dp.length -1][dp[0].length-1];
   }
}
