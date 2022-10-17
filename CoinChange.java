// Bottom up Approach
// Time Complexity : O(n * amount/k) ::: k is min denomination of coins.  n size od coins array
//Space Complexity: O(amount/k)

//Top Down Approach
// Time Complexity: O(n * amount/k) ::: k is min denomination of coins.  n size od coins array
////Space Complexity: O(amount/k)

public  class CoinChange {

    // bottom-up approach
    public int coinChange(int[] coins, int amount) {

        int[] dp1 = new int[amount+1];

        Arrays.fill(dp1, Integer.MAX_VALUE);
        dp1[0] =0;

        for( int coin : coins){

            for(int i = coin; i <= amount; i++){

                int select = 1 + (dp1[i-coin]==Integer.MAX_VALUE ? Integer.MAX_VALUE -1 : dp1[i-coin]);

                int notSelect = dp1[i];

                dp1[i] = Math.min(select, notSelect);

            }
        }

        return dp1[amount] == Integer.MAX_VALUE ? -1 : dp1[amount];

    }

    // Top Down memoisation approach
//     private int coinChange(int []coins, int startIndex, int amount){

//         //base

//         if(amount ==0) return 0;

//         if(amount < 0 || startIndex >= coins.length) return Integer.MAX_VALUE;


//         //recurse
//         if(dp[startIndex][amount] ==0 ){
//         int select = 1 + coinChange(coins, startIndex, amount - coins[startIndex]);

//         if(select <0) select = Integer.MAX_VALUE;

//         int notSelect = coinChange(coins, startIndex+1, amount);

//         dp[startIndex][amount]= Math.min(select, notSelect);
//     }

    //         return dp[startIndex][amount];
//     }
    public static void main(String[] args) {

    }
}