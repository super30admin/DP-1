// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes
import java.util.HashSet;

class coinChange {
        public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0){
            return -1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1;i<amount+1;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]] +1);
                }
            }
        }
        if(dp[coins.length][amount]==amount+1){
            return -1;
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
    coinChange rs = new coinChange();
    int[] m1 = {1,2,5};
    int[] m2 = {2};
    int[] m3 = {1};
    System.out.println(rs.coinChange(m1,11));  // ans = 3
    System.out.println(rs.coinChange(m2,3));  // ans = -1
    System.out.println(rs.coinChange(m3,0));  // ans = 0
}

}