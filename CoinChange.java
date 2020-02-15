// Time Complexity : m*(2^n)
// Space Complexity :O(m+n) where m the amount and n is number of coins
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
/*
Recursive approach
At every point we have 2 choices. Either to choose a coin or dont choose a coin
if we choose a coin we wound substract its value from total amount to make.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeUtil(coins, amount, 0,  0);
    }
    public int coinChangeUtil(int[] coins, int amount, int start, int min){
        //base case
        if(start >= coins.length || amount <0)
            return -1;
        if(amount == 0)
            return min;
        //choose a current coin
        int case1= coinChangeUtil(coins, amount-coins[start],  start, min+1);
        //Dont choose a coin
        int case2= coinChangeUtil(coins, amount,  start+1, min);
        if(case1 == -1)
            return case2;
        if(case2 == -1)
            return case1;
        return Math.min(case1, case2);
    }
}
/*
as we can see overlapping subproblemns in the above solution. we can memoize that in the dp matrix. 
we will be creating dp matrix which will be 2d as amount and coins are changing. 
time complexity - O(amount*total_coins)
space - O(amount*total_coins)
*/
class Solution {
    int min = Integer.MIN_VALUE;
    public int coinChange(int[] coins, int amount) {
        //2d array as 2 things are changing always. amount and coin
        int[][]dp = new int[coins.length+1][amount+1];
        
        //1st column 0 as we cant make amount 0 with any coin so number of ways 0
        for(int i=0; i< coins.length; i++)
            dp[i][0] =0;
        
        //1st column infinity, here we can take amount+1; 
        //coz even if we have 1 coin number of ways to make any amount would be amount+1
        for(int i=1; i<dp[0].length; i++)
            dp[0][i] =amount+1;
        
        for(int i=1; i< dp.length; i++){
            for(int j=1; j< dp[0].length; j++){
                //amount is less than cur coin then just take prev row value.
                if(j < coins[i-1] )
                    dp[i][j] =  dp[i-1][j];
                else{
                    //if we are taking this 5 to make amount 7 then we would add 1 to number of ways we can make 7-5 that is 2.
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                    //dp[i-1][j] => dont choose a coin]
                    //dp[i][j-coins[i]]+1 => choose a coin. 
                    //and if we are choosing a coin we say that , okay I am choosing this coin i need this 1 coin(add 1)now how many coins do i need to make amount which is amount - value of this coin. so we add 1 to that value. 
                }
             }
        }
        if( dp[dp.length-1][dp[0].length-1] > amount)
            return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}
:
