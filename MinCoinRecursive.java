/**
 * time complexity is exponential
 * space complexity is exponential 
 * time limit exceeds on leetcode
 */

public class MinCoinRecursive {
    public int coinChange(int[] coins, int amount) {
        
        int res = coinChange(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int coinChange(int[] coins, int amount, int i) {
        if(amount < 0 || i >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if(amount == 0) {
            return 0;
        }
        
        // include coin[i]
        int case1 = coinChange(coins, amount-coins[i], i);
        if(case1 != Integer.MAX_VALUE) {
            case1 = 1 + case1;
        }
        
        //don't include coin[i]
        int case2 = coinChange(coins, amount, i+1);
        

        return Math.min(case1, case2);
    }
}
