package DynamicProgramming1;

public class question20_coinChange {
    /*
    How to solve a problem:
        a) Greedy - the best which decides the most optimal solution at each step until the program ends.
        b) Exhaustive Brute Force - it takes longer time but we might end up having the output for all test cases.
        c) DP - If nothing happens, then the dynamic programming.
*/
/*
Greedy Approch:
    After Brute Force, we can see if we can apply the Greedy algorithm for this question.
    Which means we will always choose the most optimum solution available at that moment.
    So for the test case : [1,2,5] with amount = 11. It will work.
        Explaination: We take 5 (amount left: 6); again take 5 (amount left 1), take 1. DONE !!
    But for the test case : [3,5] with amount = 11. It will not work.
        Explaination: We take 5 (amount left: 6); again take 5 (amount left 1), now we dont have         that denomination coin which equals the left amount. Therefore, greedy approch fails here.
    Then we might say that there is no possible solution using Greedy.
    In greedy we were exploring the optimal path only.
    So now, if greedy does not work, try a different approch.
    a) Greedy - not working
    b) Exhaustive Brute Force - Time Limit Exceeding
    c) DP
*/
/*
        Brute Force :
            Time Complexity: O(n)
            Space Complexity: O(1)
*/
/*
    But there is a possible solution (without using the Greedy approch)
    At step 2, when the amount left is 6; we must take 3 instead of 5.
    Again take 3 and then the amount left will 0 in the end.
*/
    public int coinChangeGreedy(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        return coinHelper(coins, amount, 0, 0);
    }

    private int coinHelper(int[] coins, int amount, int index, int minCoins) {
        //Base Case
        if(amount == 0) return minCoins;
        if(amount < 0 || index >= coins.length) return -1;

        //Main Logic
        //Here I will choose the coin
        int case1 = coinHelper(coins, amount - coins[index], index, minCoins + 1);

        //Here I won't choose the coin
        int case2 = coinHelper(coins, amount, index + 1, minCoins);

        if(case1 == -1) return case2;
        if(case2 == -1) return case1;

        return Math.min(case1, case2);
    }

    /*
Dynamic Programming:
    So now we will go for the Dynamic Programming approch.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/
    // This is the Dynamic Programming Solution

    public int coinChangeDP(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // fill in the first column
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 0;
        }

        // fill in the first row
        for(int j = 0 ; j < dp[0].length ; j++) {
            dp[0][j] = amount + 1;
        }

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                if(coins[i - 1] > j) { //denomnation is less than the amount
                    // Zero Case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Zero and One Case (both)
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result > amount) return -1;

        return result;
    }

    public static void main(String[] args) {

    }
}