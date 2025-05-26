//time complexity : O(m*n) m= coins length and n= amount
//space complexity : O(m*n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];

        for(int i=0; i<=coins.length; i++){
            dp[i][0] =0;
        }
        for(int j=0;j<=amount;j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j < coins[i-1]){
                  dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j - coins[i-1]]);
                }
            }
        }
         if( dp[m][amount] >= 99999) return -1;
        return dp[m][amount];
    }

    public static void main(){
        Solution sol = Solution();
        int[] coins = [1,2,5];
        int amount = 11;
        int result = sol.coinChange(coins,amount);
        system.out.print('Result : '+result);
    }
}