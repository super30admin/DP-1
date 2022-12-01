
// Time Complexity :O(MN) where M is the no of coins and N is the amount
// Space Complexity :O(MN) where M is the no of coins and N is the amount
// Did this code successfully run on Leetcode :Yes

public class CoinChange {
	
	// DP
	 public int coinChange(int[] coins, int amount) {
	        if(coins==null || coins.length==0)
	            return -1;
	    // will make two dimensional array because there are two variables in recursive solution
	    //  private int helper(int[] coins, int amount,int idx,int coinsNo) coins and amount 

	    int[][] dp = new int[coins.length+1][amount+1];// +1 because we will have 0 amount and 0 demoniation coin for base cases 
	    // populate first row -- coin with demonitaion 0

	    dp[0][0] = 0;

	    int m = coins.length;
	    int n = amount;
	    for(int i=1;i<=n;i++){
	        dp[0][i] = n+1;// infinte 
	    }

	    for(int i=1;i<=m;i++){
	        for(int j=1;j<=n;j++){
	            if(j < coins[i-1])
	            {
	                dp[i][j] = dp[i-1][j];
	            }
	           else 
	                dp[i][j] = Math.min(dp[i-1][j],dp[i][j - coins[i-1]]+1);
	        }
	    }
	    if(dp[m][n]==amount+1)
	        return -1;
	    return dp[m][n];
	    
}	

	 public int coinChangeRecursive(int[] coins, int amount) {

	       if(coins==null || coins.length==0)
	        return -1;     
	       return helper(coins,amount,0,0);

	    }

	    private int helper(int[] coins, int amount,int idx,int coinsNo){
	        // base condition
	        if(idx==coins.length|| amount<0)
	            return -1;
	       
	        if(amount==0)
	            return coinsNo;
	        // logic
	        int include = helper(coins,amount-coins[idx],idx,coinsNo+1);
	        
	        int notInclude = helper(coins,amount,idx+1,coinsNo);
	        if(include == -1)
	            return notInclude;
	        else if(notInclude==-1)
	            return include;
	        else 
	            return Math.min(include,notInclude);
	    }
	    
	   
	
}
