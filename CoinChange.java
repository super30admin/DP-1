//Time Complexity=O(m*n)
//Space Complexity=O(m*n)
public class CoinChange {
    private int coinChange(int[] coins,int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=0;
        for(int j=1;j<=amount;j++){
            dp[0][j] =99999;
        }
        for(int i=1; i<=coins.length;i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] =Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount]>=99999)
            return -1;
        return dp[coins.length][amount];
    }



    public static void main(String[] args) {
        CoinChange coinChange=new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5},11));
    }
}
