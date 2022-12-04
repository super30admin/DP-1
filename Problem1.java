// Time Complexity : O(coins * amount)
// Space Complexity :O(coins * amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : How to pick the infinity and how to decide when the solution is not possible


// Your code here along with comments explaining your approach
/*
As question states that we have to take minimum number of the coins from the available coins to match the sum

At first it looks like a greedy solution. but its not always going to be the case when the coin inputs coinChange

So we have to be exhaustive to find out the minimum number of coins
*/

class Solution {
    public int coinChange(int[] coins, int amount) {

        // we see that there are two variables
        // which coin we choose and what is the amount after choosing

        int dp[][] = new int[coins.length+1][amount+1];

        dp[0][0]= 0; // Since the amount is zero we cannot further make any choices, so leaving it 0

        // filling the rest of the columns of the 0 coin

        // There would be infinite ways to make any amount greater than 0 when we have 0 as coin
        // As 1 is the lowest coint at most would be able to make the amount number of ways by taking 1
        // this means that number of ways would never be greater than the amount
        // So amount +1 would be unreachable and can be treated as the inifnity
        for(int col = 1; col<=amount; col++){
            dp[0][col] = amount+1; // 
        }

        // The most important step is done , now we have the first row, we can fill up the rest of the values

        //itarate over row and column

        for(int row = 1;row<=coins.length;row++){

            for(int col =0;col<=amount;col++){

                // the row would correspond to the coin , the col would be the target amount we can make when the coin is visited

                //if amount is less than the choosen coin, then previous value is choosen
                if(col < coins[row-1]){
                    dp[row][col] = dp[row-1][col]; // it is going to come from the above
                }
                else{
                    // We have option to choose it or not choose it

                    // so we have to check how many ways we can make the target amount when we choose and how many we have when we not choose interface
                    // then take minimum of that

                    // when we choose it, we will increase the number of coin by 1, and subtact the amount, since we already had solved it , we would just use the //   
                    //value from there
                    // when we dont choose it, we simply take it out from the choices , the answer would be same as the previous one

                    dp[row][col] = Math.min(dp[row-1][col], 1+ dp[row][col - coins[row-1]]);
                }
            }

        }
                // since we took amount + 1 as inifnity, so if the value is infinity , then solution not possible, hence return -1
                    return (dp[coins.length][amount] == amount+1) ? -1 : dp[coins.length][amount]; 

    }

}