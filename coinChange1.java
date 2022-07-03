/**Time Complexity :
    O(mn)
// Space Complexity :
    we are using another matrix of size m*n hence O(mn)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
     Got confused while understanding index
// Your code here along with comments explaining your approach**/



class coinChange1{
    public int coinChange(int[] coins, int amount) {
       if(coins==null || coins.length==0) return -1;
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];
        //initialize amount+1 for the first row
        for(int j=1;j<n+1;j++){
            dp[0][j]=amount+1;
        }

        //calculate 0 and 1 case, sum it up
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]==amount+1){
            return -1;
        }
        return dp[m][n];
    }
}