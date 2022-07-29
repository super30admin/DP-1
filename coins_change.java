//TC - O(m*n) m-no.of coins and n-amount by storing the vales in a 2d matrix
//SC - O(m*n) an array of m rows and n colums
//Leetcode - successful
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return -1;
        int row_coins = coins.length;
        int columns_amount = amount;
        int [][] dp = new int[row_coins+1][columns_amount+1];
        dp[0][0]=0;
        for(int i=1;i< columns_amount+1;i++){
            dp[0][i] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //checking for amount and denomination cdn
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else 
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
        
        int result = dp[row_coins][columns_amount];
        if(result > amount)
            return -1;
        return result;
    }
}

        
        
        
//tree structure soln  
//TC: O(2^n)  not sure about n but base 2 is for choosing or not choosing the coin
//SC: O(1) but since it is recursion it takes lots of mremory
//Leetcode - successful



class Solution_1 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
       return helper(coins,amount,0,0);
            
    }
    public int helper(int [] coins, int amount, int index,int min_coins){
        //base cases
        if(amount<0 || index == coins.length)
            return -1;
        if(amount == 0)
            return min_coins;
        //logic 
        //choosing the coin
       
        int case1 = helper(coins,amount-coins[index],index,min_coins+1);
        
        //Not choosing the coin
        int case2 = helper(coins,amount,index+1,min_coins);
       
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        return Math.min(case1,case2);
    }
}