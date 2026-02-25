// Solution - 1

// TimeComplexity: O(m*n) where m is coins length and n is amount
// SpaceComplexity: O(n)
// Explanation: I am using dynamic programming to build the answer from smaller subproblems. I create a 1D array matrix where matrix[k] represents the minimum number of coins needed to make amount k.
// For each coin, I iterate through all amounts and update the minimum coins required using the relation matrix[k] = min(matrix[k], 1 + matrix[k - coin]). 
// In the end, if the value at matrix[amount] is still very large, it means the amount cannot be formed, so I return -1.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[] matrix = new int[amount+1];
        for(int i=1; i<amount+1; i++) {
            matrix[i] = Integer.MAX_VALUE-5;
        }

        for(int j=1; j<m+1; j++) {
            for(int k=1; k<amount+1; k++) {
                if(k>=coins[j-1]) {
                    matrix[k] = Math.min(matrix[k], 1+matrix[k-coins[j-1]]);
                }
            }
        }

        if(matrix[amount] > Integer.MAX_VALUE-100) return -1;
        return matrix[amount];

        
    }
}


// Solution -2

// TimeComplexity:(2^(m+n)) where m is coins length and n is amount
// SpaceComplexity: O(m+n)
// Explnation: Here I use recursion to try all possible combinations. At each step, I have two choices: either take the current coin (reduce amount) or skip it (move to next coin).
// I recursively compute both choices and return the minimum. If the amount becomes negative or I exhaust all coins, I return a large value to indicate invalid.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int result= helper(coins, amount, 0);
        if (result>=Integer.MAX_VALUE-10) return -1;
        return result;
        
    }

    private int helper(int[] coins, int amount, int idx) {
        // base
        if(idx==coins.length||amount<0) return Integer.MAX_VALUE-10;
        if(amount==0) return 0;

        // choose
        int choice1 = 1+ helper(coins, amount-coins[idx], idx);


        // no choose
        int choice2 = helper(coins, amount, idx+1);

        return Math.min(choice1, choice2);
    }
}