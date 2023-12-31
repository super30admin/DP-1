import java.util.Arrays;

public class CoinChange2 {
    //TC On
    //SC On

    public static void main(String[] args) {
        int c=coinChange(new int[]{2},11);
        System.out.println(c);
    }
        public static int coinChange(int[] coins, int amount) {
            int m=coins.length;
            int n=amount;
            // if(coins.length==0 || coins==null)return -1;
            int[][]dp=new int[m+1][n+1];
            Arrays.fill(dp[0],Integer.MAX_VALUE-10);
            dp[0][0]=0;
            for(int i=1;i<=m;i++){
                for(int j=0;j<=n;j++){
                    // till amount is less thn deno curr coin
                    if(j<coins[i-1]){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    }

                }
            }
            int re=dp[m][n];
            if(re>=999999 || re <0)
                return -1;
            return re;
        }

    }

