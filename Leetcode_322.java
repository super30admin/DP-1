//Way1
//Exhaustive - choose and no choose
//TC: 2^(m+n); SC: stack space
class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans= helper(coins,amount,0);
        if(ans==Integer.MAX_VALUE-10) return -1;
         return ans;
        
    }

    private int helper(int[] coins, int amount, int idx){
        //base case
        if(idx==coins.length || amount<0) return Integer.MAX_VALUE-10;

        if(amount==0) return 0;

        //logic:
        //no choose
        int case1 = helper(coins,amount,idx+1);

        //choose
        int case2=1+helper(coins,amount-coins[idx],idx);

        return Math.min(case1,case2);


    }
}


//Way2:
//When we have opted for choose and no choose case, we got many repeated sub problems. So, we can choose dp to solve it.
//In dp, going with bottom up i.e., tabulation method.
//TC: O(m*n); SC: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[][] dp=new int[m+1][n+1];

        //Number of coins required to make amount 0 with coins 0
        dp[0][0]=0;
        //Number of coins required to make amount n with coins 0
        for(int i=1;i<=n;i++){
            dp[0][i]=Integer.MAX_VALUE-10;
        }

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                //Using previous rows to get current row.
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                
            }
            
        }

        if(dp[m][n]==Integer.MAX_VALUE-10) return -1;
        return dp[m][n];
    }
}

//Way3:
//When we have opted for choose and no choose case, we got many repeated sub problems. So, we can choose dp to solve it.
//In dp, going with bottom up i.e., tabulation method.
//TC: O(m*n); SC: O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int[] dp=new int[n+1];

        //Number of coins required to make amount 0 with coins 0
        dp[0]=0;
        //Number of coins required to make amount n with coins 0
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE-10;
        }

      
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                //Using previous rows to get current row.
                if(j<coins[i-1]){
                    dp[j]=dp[j];
                }else{
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
                }
            }
        }

        if(dp[n]==Integer.MAX_VALUE-10) return -1;
        return dp[n];
    }
}

//Way4:
//Exhaustive - choose and no choose -- causing time limit exceeded
//So, opt for exhaustive with memoization. It means remembering the prev results
//TC: O(m*n); SC: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;

        int[][] memo=new int[m+1][n+1];

        int ans= helper(coins,amount,0,memo);
        if(ans==Integer.MAX_VALUE-10) return -1;
         return ans;
        
    }

    private int helper(int[] coins, int amount, int idx, int[][] memo){
        //base case
        if(idx==coins.length || amount<0) return Integer.MAX_VALUE-10;

        if(amount==0) return 0;

        if(memo[idx][amount]!=0) return memo[idx][amount];

        //logic:
        //no choose
        int case1 = helper(coins,amount,idx+1,memo);

        //choose
        int case2=1+helper(coins,amount-coins[idx],idx,memo);
        memo[idx][amount]=Math.min(case1,case2);
        return Math.min(case1,case2);


    }
}
