
public class CoinChange1 {
	public static int fun(int []coins, int p, int amount, int [][]dp )
	{
		if(amount==0) {return 0;}

		if(p>coins.length-1||amount<0) {return Integer.MAX_VALUE-1000;}

		
		if(dp[amount][p]!=-1) {
			return dp[amount][p];
			
		}else {
		int pick=1+fun(coins, p, amount-coins[p],dp);
		int skip=fun(coins, p+1, amount,dp);
		 return dp[amount][p]=Math.min(pick, skip);

	}
		}
		
	    
	    
	    
	    
	    
	    public int coinChange(int[] coins, int amount) {
	     
	        int[][]dp=new int[amount+1][coins.length+1];
	     
	     for( int i=0;i<dp.length; i++){
	         
	         for( int j=0;j<dp[0].length;j++){
	             
	             dp[i][j]=-1;
	         }
	     }
		
	   int x= (fun(coins, 0, amount,dp));
	        
	        if(x==Integer.MAX_VALUE-1000){return -1;}else{return x;}
	        
	        
	    }
}
