//322. Coin Change => Brute force approach
//Worst case Time complexity: O(S^n) S is the amount, complexity is exponential in the number of the coins n. // Space Complexity: O(n) worst case, maximum depth of the recursion is n. We need O(n) space used by the system recursive stack

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }

    public int helper(int[] coins, int amount, int i, int min_num){
        //Base Case
        if(i > coins.length-1 || amount<0)
            return -1;
        if(amount == 0)
            return min_num;

        //Choose the coin
        int case1 = helper(coins, amount-coins[i], i, min_num+1);

        //Don't choose the coin
        int case2 = helper(coins, amount, i+1, min_num);

        if(case1 == -1) return case2;
        else if(case2 == -1) return case1;
        else return Math.min(case1, case2);
    }
}

//322. Coin Change, DP
// Time Complexity: O(m*n) m => amount, n number of coins
//Space Complexity: O(m*n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        int m = dp.length; // number of rows; // 4
        int n = dp[0].length; // number of columns // 12

        for(int i=0;i<m; i++)
            dp[i][0] = 0;

        for(int i=1; i<n; i++)
            dp[0][i] = 99999;

        for(int i=1; i<m; i++){
            for(int j= 1; j<n; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
            }
        }
        int result = dp[m-1][n-1];
        if(result >= 99999)
            return -1;
        return result;
    }
}