// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         //Brute force - Exhaustive
//         int re = helper(coins,amount,0);
//         if(re<Integer.MAX_VALUE-10) return re;
//         return -1;
//     }
//     private int helper(int[] coins, int amount, int idx){
//         //base 
//         if(idx==coins.length || amount<0) return Integer.MAX_VALUE-10;
//         if(amount==0) return 0;
//         //logic
//         //Not choose
//         int case1= helper(coins,amount,idx+1);
//         //choose 
//         int case2=1+helper(coins,amount-coins[idx],idx);
//         return Math.min(case1,case2);
//     }
// }


// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity : O(n) where n is the amount
// Did this code successfully run on Leetcode : yes 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m= coins.length;
        int n= amount;
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]= Integer.MAX_VALUE -10;
        }
        for(int i=1; i<=m;i++){
            for(int j=coins[i-1];j<=n;j++){
                dp[j] = Math.min(dp[j],1+dp[j-coins[i-1]]); 
            }
        }
        if(dp[n]<Integer.MAX_VALUE -10) return dp[n];
        return -1;
    }
}

// Bottom up apprach - Matrix as the decision making variable are the coins and the amount.
// then i reduced it to tabluation and then to space optimization. 