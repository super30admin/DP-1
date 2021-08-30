// Time Complexity : o(m*n) where m means given no of coins length and n is the amount
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //2d array with varying parameters which are coins, amount
        int[][] dp = new int[coins.length+1][amount+1];
        //initailize the first element with 0 as the amount will be 0 and coins will be 0
        dp[0][0]=0;
        //initialize the first row i.e., with 0 coins to make amount 1 ,2,3..11 with inifinity or to be written in code make it amount +1
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]= amount+1;
        }
    //iterate by taking coins at a time and also amount
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //until the amount is equal to the denominations of coins, we get the value from the previous direct above row
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                //after reaching where amount will be equal and greater than denomination of coins, it will be min of previous row vs as taking that coin 1+2steps back
                else{
                     dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
    //if the final element is greater than amount, then it means we cannot make that amount
    if(dp[dp.length-1][dp[0].length-1]>amount){
         return -1; 
    }
    //returning the last final element from 2d array as there is the ans
    return dp[dp.length-1][dp[0].length-1];
    }
}