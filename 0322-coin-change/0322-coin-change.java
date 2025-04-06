// /*This is a recursive backtracking approach to solve the coin change problem. 
// We try all possible combinations starting from the current coin index.
// At each step, we can use the current coin 0 to (amount/coin change) time
// For every possiblity, we recursively check the result with the remaining coins and amount.
// The goal is to find the minimum number of coins that make uo that amount.
// If no combination works, return -1
// */

// class Solution {
//     //Public method that kicks off recursion
//     public int coinChange(int[] coins, int amount) {
//         return coinChange(0, coins, amount);
//     }
//     //Recursive heler function
//     private int coinChange(int idxCoin, int[] coins, int amount){
//         //Base case: If amount becomes 0, no more coins needed
//         if (amount == 0)
//             return 0;
        
//         //If we have more coins to consider and the amount is positive
//         if(idxCoin<coins.length && amount>0){
//             //maxVal is the maximum number od current coins we can use
//             int maxVal = amount/coins[idxCoin];
//             //Initialize minimum cost of the current type(from 0 to maxVal)
//             int minCost = Integer.MAX_VALUE;

//             //Check if remaining amount is valid
//             for(int x=0; x<=maxVal; x++){
//                 if(amount>=x*coins[idxCoin]){
//                     //Recursively try the next coin with the remaining amount
//                     int res = coinChange(idxCoin+1, coins, amount-x*coins[idxCoin]);

//                     //Recursively try the next coin with the remaining amount
//                     if(res!=-1)
//                         minCost=Math.min(minCost,res+x);
//                 }
//             }
//             //If no valid combination was found, return -1
//             return(minCost == Integer.MAX_VALUE)?-1:minCost;
//         }
//         //If no coin left or invalid amount, return -1.
//         return-1;
//     }
// }


// //Time Complexity: O(S^n): exponential
// //Space Complexity: O(n): 

/*
Approach#2: This problem is solved using a top-down dynamic programming (recursive+ memoization) approach
We are given an array of coin denominations and a target amount.
The goal is to find the **minimum number of coins** needed to make up that amount

-We use a recursion to try all combination of coins for a given remaining amount.
-We use a memoization array('count') to store results for subproblems
ie. the minimum coins needed for every amount from 1 to'amount),
if a subproblem has already been solved, we reuse the result to avois redundants.

*/


class Solution{
    public int coinChange(int[] coins, int amount){
        if(amount<1) return 0;

        return coinChange(coins, amount, new int[amount]);

    }

    private int coinChange(int[] coins, int rem, int[] count){
        if(rem<0) return -1;
        if(rem == 0) return 0;
        if(count[rem-1] != 0) return count[rem-1];

        int min=Integer.MAX_VALUE;

        for(int coin:coins){
            int res = coinChange(coins, rem-coin, count);

            if(res>=0 && res<min)
                min=1+res;
         }

         count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;

         return count[rem-1];




        }

    }


        

        

        

        

        

        


        

 
 