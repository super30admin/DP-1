// Time Complexity : Approach 1: O(n*A), Approach 2: O(n*A) where n = number of denominations, A = amount
// Space Complexity : Approach 1: O(n*A), Approach 2: O(A) where n = number of denominations, A = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1 {
    
    // Memoization Approach (Top-Down)

    private static int[][] dp;
    
    public static int coinChange1(int[] coins, int amount) {
        // dp[row][col] == 0 represents that the calculation has not been done via recursion yet
        dp = new int[coins.length][amount+1];
        int ans = coinChange1(coins, amount, 0);
        // If ans is +infinity, return -1 else return ans
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private static int coinChange1(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dp[index][amount] > 0) {
            return dp[index][amount];
        }
        
        // If I don't select the current denomination, increment index by 1
        int notselect = coinChange1(coins, amount, index + 1);
       
        // If I select the current denomination, decrease amount by coins[index].
        // If the value of select is not +infinity, increment select by 1
        int select = coinChange1(coins, amount - coins[index], index);
        if (select != Integer.MAX_VALUE) {
            select += 1;
        }
        
        // Set the calculated value (min of select and notselect) at corresponmding row and column in the dp array
        dp[index][amount] = Math.min(notselect, select);
        return dp[index][amount];
    }


    // Iterative Approach (Bottom-up)

    public static int coinChange2(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            prev[i] = Integer.MAX_VALUE;
        }
        for (int index = coins.length-1; index >= 0; index--) {
            int[] curr = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                // If I don't select the current denomination, the value is equal to the value at index i in prev array
                int notselect = prev[i];
                // If I select the current denomination, decrease amount by coins[index].
                // If the value of select is not +infinity, increment select by 1
                int select = i >= coins[index] ? curr[i-coins[index]] : Integer.MAX_VALUE;
                select = select == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + select;
                // Set the calculated value (min of select and notselect) at corresponmding index in the curr array
                curr[i] = Math.min(notselect, select);
            }
            // Set prev to curr
            prev = curr;
        }
         // If ans is +infinity, return -1 else return ans
        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int ans1 = coinChange1(coins, amount);
        int ans2 = coinChange2(coins, amount);
        System.out.println("Answer for Approach-1(Top-down approach) is : " + ans1);
        System.out.println("Answer for Approach-2(Bottom-up approach) is : " + ans2);

    }

}
