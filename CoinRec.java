// Time Complexity : n^2
// Space Complexity : 1
// Did this code successfully run on Leetcode : Time exceeded 
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

import java.util.Arrays;

public class CoinRec {

    int minCoinCount = 500000;
    int work = 0;

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        if (coins.length <= 0)
            return -1;
        else if (amount <= 0) {
            return amount;
        } else {

            for (int i = coins.length - 1; i >= 0; i--) {
                work = 0;
                int temp = minCoins(coins, i, amount);
                if (temp < minCoinCount)
                    minCoinCount = temp;
            }
        }

        return (minCoinCount == 500000001 || minCoinCount == 500000) ? -1 : minCoinCount;
    }

    public int minCoins(int[] coins, int index, int amount) {

        if (index < 0) {
            work = 500000001;
            return work;
        } else if (amount % coins[index] == 0) {
            work += amount / coins[index];
            return work;
        } else {
            work += amount / coins[index];
            return minCoins(coins, index - 1, amount % coins[index]);
        }
    }

    public static void main(String[] args) {
        CoinRec cr = new CoinRec();
        // int[] nums = { 1, 2, 5 };
        // int[] nums = { 2 };
        int[] nums = { 186, 419, 83, 408 };
        System.out.println(cr.coinChange(nums, 6249));
    }
}
