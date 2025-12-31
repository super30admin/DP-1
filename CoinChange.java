import java.util.HashMap;
import java.util.Map;

// Time Complexity : Mentioned in each method
// Space Complexity : Mentioned in each method
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In creating the recursion tree and identifying recursion method calls

// Approach :
// Since we have to choose out of N coins to make an amount. There can be many combinations the coins can be selected.
// We have to choose the combination which gives the minimum amount of coins. Thus, I have used DP where the basic idea
// is to decide whether to choose coin[i] or choose coin [i-1] and find out whether there sum is equal to the amount.
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int min = findMinCoinsRecursive(coins, amount);
        int minMemo = findMinCoinsMemo(coins, amount, new HashMap<>());
        int minIterative = findMinCoinsIterative(coins, amount);
        int minIterativeSpace = findMinCoinsIterativeSpace(coins, amount);
        return min;
    }

    public int findMinCoinsRecursive(int[] coins, int amount) {
        // N : number of coins, A: given amount
        // Time Complexity : O(N^A), if we create recursion tree, at every level, I will need to make choices out n coins,
        // so each level will have N^1, N^2, N^3.... N^A recursion calls, going till the amount in the worst case
        // Space Complexity : O(A), since the recursion tree will have A levels(also the height of the tree), in worst,
        // we will have A stack frames in the recursion stack.

        // Base cases, if amount goes below 0, no coin is able to make the amount
        if (amount < 0) return -1;
        // If amount is 0, the target amount is reached and we should not proceed.
        if (amount == 0) return 0;

        // Since we need to find min count, initialize with max possible value, +infinity or amount+1
        int minCoins = amount + 1;
        // Go through all the coins(size A) in the input
        for (int coin : coins) {
            // calculate the subproblem by selecting this coin, thus removing it from amount
            int minCoinsForSubProblem = findMinCoinsRecursive(coins, amount - coin);
            if (minCoinsForSubProblem < 0) continue;
            // if there is any lesser number of coins from sub problems, override the min count.
            if (minCoinsForSubProblem < minCoins) {
                minCoins = minCoinsForSubProblem + 1;
            }
        }

        // if minCoins is still max, no subproblem is able to reach target amount, return -1.
        return minCoins == amount + 1 ? -1 : minCoins;
    }

    public int findMinCoinsMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        // N : number of coins, A: given amount
        // Time Complexity : O(N*A), in the recursion tree, since we will solve the subproblems and store it in hashmap,
        // some of the subtrees can be avoided such that at every level there are N sub problems. So if there are A levels,
        // A* N gives us the max number of recursion calls to be made.
        // Space Complexity : O(A), since the recursion tree will have A levels(also the height of the tree), in worst,
        // we will have A stack frames in the recursion stack.
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        // If the subproblem is already solved, return from memo
        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins = amount + 1;
        for (int coin : coins) {
            int minCoinsForSubProblem = findMinCoinsMemo(coins, amount - coin, memo);
            if (minCoinsForSubProblem < 0) continue;
            if (minCoinsForSubProblem < minCoins) {
                minCoins = minCoinsForSubProblem + 1;
            }
        }

        // save the new computed value in the memo
        memo.put(amount, minCoins);
        return minCoins == amount+1 ? -1: minCoins;
    }

    private int findMinCoinsIterative(int[] coins, int amount) {
        // N : number of coins, A: given amount
        // Time Complexity : O((N+1)*(A+1)) = ~ O(NxA)
        // Space Complexity : O(NxA)

        int row = coins.length + 1;
        int col = amount + 1;
        int[][] table = new int[row][col];

        // If we need to make 0 amount, we cant use any coins, so initialize with 0
        for (int i = 0; i < row; i++) {
            table[i][0] = 0;
        }

        //If we have 0 coins, we need "Infinity" coins to make any amount > 0, I am taking amount +1 as infinity
        for (int j = 1; j < col; j++) {
            table[0][j] = amount + 1;
        }

        for (int i = 1; i < row; i++) {
            int currentCoin = coins[i - 1];
            for (int j = 1; j < col; j++) {
                // Take the number of coins excluding the current coin required to make j amount
                int excluding = table[i - 1][j];

                // If the selected coin value is less than the current amount, include the current coin
                if ( currentCoin <= j) {
                    int including = 1 + table[i][j - currentCoin];
                    table[i][j] = Math.min(excluding, including);
                } else {
                    table[i][j] = excluding;
                }
            }
        }
        // If the last value still has infinity in it, return -1, total amount is not possible;
        return table[row - 1][col - 1] == (amount+1) ? -1 : table[row - 1][col - 1];
    }

    private int findMinCoinsIterativeSpace(int[] coins, int amount) {
        // N : number of coins, A: given amount
        // Time Complexity : O(A*N)
        // Space Complexity : O(A)
        int size = amount+1;
        int[] table = new int[size];

        for(int i = 1; i <= amount; i++){
            // Initialize with infinity, in this case we are using a value that is not possible.
            table[i] = amount + 1;
            for (int currentCoin: coins) {
                // if the current coin value is less than the i sum.
                if (currentCoin <= i) {
// find min of (value if we include the current coin, the count calculated including the previous coin/excluding the current coin)
                    table[i] = Math.min(table[i - currentCoin] + 1, table[i]);
                }
            }
        }
        return table[amount] == (amount+1) ? -1 :  table[amount];
    }
}
