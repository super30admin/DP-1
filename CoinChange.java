package mediumProblems;

public class CoinChange {
	
	
	public int coinChange1(int[] coins, int amount) {
		
	 if(coins.length ==0 || coins == null)
         return -1;
     
     int[][] dp = new int[coins.length+1][amount+1];
     
     //fill the first column with all zeros
     for(int i=0; i< dp.length; i++)
     {
         dp[i][0] = 0; 
     }
     
     
     //fill the first row 
     for(int i=1; i< dp[0].length; i++)
     {
         dp[0][i] = 999;     
     }
     
     for(int i=1; i<dp.length; i++)
     {
         for(int j=1; j<dp[0].length; j++)
             if(j<coins[i-1])
                 dp[i][j] = dp[i-1][j];
             else
                 dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
         
     }
     
     if(dp[dp.length-1][dp[0].length-1] >= 999)
         return -1;
     
     return dp[dp.length-1][dp[0].length-1]; 
 }
     

// Bruteforce approach   
 
//  if(coins == null || coins.length ==0)
//      return -1;
     
//  return helper(coins, amount, 0, 0);
//}
 
//  private int helper(int[] coins, int amount, int i, int min)
//  {
//      if(amount == 0) return min;
     
//      if(amount < 0 || i > coins.length-1) return -1;
  
//      int choose = helper(coins, amount -coins[i], i, min +1);
     
//      int notChoose = helper(coins, amount, i+1, min); 
  
     
//      if(choose == -1) return notChoose;
//      if(notChoose == -1) return choose;
     
//      return Math.min(choose, notChoose);
//  }
 
 
//}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
