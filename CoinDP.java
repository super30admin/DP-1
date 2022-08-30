package Day8;
//Time Complexity: O(n) Exponential complexity
//Space Complexity: O(n*k)
public class CoinDP {

    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1];

        int m = dp.length;
        int n = dp[0].length;

        for(int i=0; i<m; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<n; i++){
            dp[0][i] = 9999;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }

        int result = dp[m-1][n-1];
        if(result == 9999) return -1;
        return result;
    }

    public static void main(String args[]){
        CoinRec ob = new CoinRec();

        int[] nums = new int[]{1,2,5};

        System.out.println("The min number of required to sum up given target with given denominations: "+ ob.coinChange(nums, 11));
    }

}
