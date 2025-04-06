/*
 * Approach:
 * This is arecursive backtracking appoach to solve the Coin Change problem.
 * We try all possible combinations of coin starting from the current coin index
 * At each step, we can use the current coin 0 to(amount/coin change) time.
 * For every possibility, we recursively check the result with the remaiining coins and amount.
 * The goal is to find the minmium number of coins that make up the amount.
 * If no combination works, return -1
 * 
 * Drawbacks:
 * This approach recalculates the samesubproblems multiple times leading to exponential time complexity and time limit exceed error.
 * We optimize it using Dynamic Programming with memoization.
 * 
 * Steps:
 *  Public method that kicks off the recursion
 * Recursive helper function
 * Base case: if amount becomes 0, no more coins are needed.
 * If we have more coins to consider and the amount is still positive.
 * maxVal is the maxmum number of current coins we can use.
 * Initialize minimum cost to a large value
 * Try using x coins of the current type(from 0 to maxVal)
 * Check if remaining amount is valid
 * Recursively try the next coin with the remaining amount
 * If the result is valid, update minimum cost
 * If no valid combination was found, return -1
 * If no coins left or invalid amount, return -1
 * 
 */

 public class Problem1{
    public int coinChange(int[] coins, int amount){
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(idxCoin<coins.length && amount>0){
            int maxVal=amount/coins[idxCoin];
            int minCost=Integer.MAX_VALUE;
            for(int x=0; x<=maxVal; x++){
                if(amount>=x*coins[idxCoin]){
                    int res=coinChange(idxCoin+1, coins, amount-x*coins[idxCoin]);
                    if(res!=-1)
                        minCost=Math.min(minCost, res+x);
                }
            }
            return (minCost==Integer.MAX_VALUE)?-1:minCost;
        }
        return -1;
    }
 }

 //TC: o(s^n): Exponential time complexity
 //SC: O(n)