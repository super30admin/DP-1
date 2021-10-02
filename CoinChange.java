class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length+1;//row
        int m=amount+1; // column
        
        int[][] dp= new int[n][m];
        
        //init row
        for(int j=1;j<m;j++){
            dp[0][j]=amount+1;//changed from max to avoid infinity or we can choose 99999 which is 10^4 given
        }
        //col
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        //DP
        
        for(int i=1;i<n;i++){ //cols -- coins
            for(int j=1;j<m;j++){  //rows --amount
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j]; //take from previous row if amount<coin choosed
                }
                else {
                    dp[i][j]= Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                                      // /*itself*/ +/*step back *///,/*from previous*/--min of this 2
                  }
            }
        }
        return dp[n-1][m-1]==amount+1?-1 : dp[n-1][m-1];
    }
}

//time : O(n*m)--- n rows and m col nested operations
//space : O(n*m)-- storing new matrix
//ran successfuly on leetcode
//faced difficulties when o and infinity are added in rows and column while coding to specify proper index in coding after class discussion as well. :(
