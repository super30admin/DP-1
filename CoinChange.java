/*
Time Complexity:O(coins.length * target)
Space Complexity:O(coins.length * target)
Approach:
-Made a 2d array which is the dp array storing the value of minimum  number of coins required to make the target
from 0 to target itself
- dp is about dividing into overlapping subproblems so here we are reaching to the target going with each coin
seeing whether we should take the coin or not and storing whichever gives us minimum number of coins since the
objective of question is to take minimum number of coins
 */
public class CoinChange{
    public static int minCoins(int[] coins, int target){
        int[][] dp = new int[coins.length+1][target+1];
        for(int i = 0; i <= coins.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j <= target; j++){
            dp[0][j] = 9999;
        }
        for(int i = 1;i <= coins.length; i++ ){
            for(int j = 1; j <= target;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[coins.length][target];
        return result >= 9999 ? -1 : result;
    }
public static void main(String args[]){

 System.out.println(minCoins(new int[]{1,2,5}, 11));
 System.out.println(minCoins(new int[]{2}, 3));
 System.out.println(minCoins(new int[]{2,5}, 10));
}
}