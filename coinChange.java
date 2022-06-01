import java.util.Arrays;

// for first approch
// Time Complexity : O(s^n) s = number of coins(at max 12)
// Space Complexity : O(x) x= amount using by recursive stack
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : Yes problem gave me TLE in leetcode. 

// for second approch
// Time Complexity : O(n*t) t = amount
// Space Complexity : O(n * t) + O(t) t = amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes I have tried using tabulation but I have not clearly understand it.

class Main {

    // first approch
    public static int minimumCoins1(int ind, int[] coins, int amount) {
        // here we check we have reached to index 0 then
        if (ind == 0) {
            // check if at index 0 there is possiblity that we can get our amount from x
            // number of coins
            if (amount % coins[0] == 0)
                return amount / coins[0];
            // else we return max value
            else
                // here we are returnig 10^9 as in some case it will gave overflow of int
                return (int) Math.pow(10, 9);

        }

        // first we decide we are taking coin at index ind or not if we are not taking
        // it then we reduce the index by one
        int notTake = minimumCoins1(ind - 1, coins, amount);

        // at last we are taking smallest element that's why we intialize take with max
        // value
        int take = (int) Math.pow(10, 9);

        // if at particular index remaining amount is less then the coin size then there
        // is no meaning of taking the coin as it will give negative remaining amount
        if (coins[ind] <= amount) {

            // else we take one coin and stick to the same index
            take = 1 + minimumCoins1(ind, coins, amount - coins[ind]);
        }

        // return minimum number of coin
        return Math.min(take, notTake);
    }

    // second approch

    public static int minimumCoins2(int ind, int[] coins, int amount, int[][] dp) {
        // here we check we have reached to index 0 then
        if (ind == 0) {
            // check if at index 0 there is possiblity that we can get our amount from x
            // number of coins
            if (amount % coins[0] == 0)
                return amount / coins[0];

            // else we return max value
            else
                // here we are returnig 10^9 as in some case it will gave overflow of int
                return (int) Math.pow(10, 9);
        }

        // if we already know the value of dp[ind][amount] we do not need to do further
        // calculations
        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        // first we decide we are taking coin at index ind or not if we are not taking
        // it then we reduce the index by one
        int notTake = minimumCoins2(ind - 1, coins, amount, dp);

        // at last we are taking smallest element that's why we intialize take with max
        // value
        int take = (int) Math.pow(10, 9);

        // if at particular index remaining amount is less then the coin size then there
        // is no meaning of taking the coin as it will give negative remaining amount
        if (coins[ind] <= amount) {

            // else we take one coin and stick to the same index
            take = 1 + minimumCoins2(ind, coins, amount - coins[ind], dp);
        }

        // return minimum number of coin and store it in dp array
        return dp[ind][amount] = Math.min(take, notTake);
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans1 = minimumCoins1(coins.length - 1, coins, amount);
        int ans2 = minimumCoins2(coins.length - 1, coins, amount, dp);

        System.out.println("minimum coins without tabulation: " + (ans1 >= (int) Math.pow(10, 9) ? -1 : ans1));
        System.out.println("minimum coins with tabulation: " + (ans2 >= (int) Math.pow(10, 9) ? -1 : ans2));

        return minimumCoins1(coins.length - 1, coins, amount);

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        coinChange(coins, amount);
    }
}