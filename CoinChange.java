// Time Complexity :  O(MN)  M--> number of coins, N--> amount
// Space Complexity :    O(MN)  M--> number of coins, N--> amount
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


public class CoinChange{
	
	public int getCoinChange(int[] coins,int amount) {
		if(coins==null || coins.length==0) {                            //checking base case
			return 0;
		}
		
		int rows = coins.length+1;                                        //number of rows is coins.length+1 to add 0 coins dim
		int cols = amount +1;                                            //number of cols in amount+1 to include 0 amount
		
		int[][] dp = new int[rows][cols];
		
		for(int i=1;i<cols;i++) {
			dp[0][i] = amount +1;                                      //filling first row to infinity (amount+1)
		}
		
		for(int i=1;i<rows;i++) {                                     
			for(int j=1;j<cols;j++) {
				if(j<coins[i-1]) {                                        //checking whether the amount is lesser than coin dim
					dp[i][j]=dp[i-1][j];                                 
				}else{                                                              
					dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);		//if amount is greater or equal to coin then we find the min 
				}
			}
		}
		  
        if(dp[rows-1][cols-1]==amount+1){                                       //if the determined min value is less than the amount required, then return -1
            return -1;
        }
        
		return dp[rows-1][cols-1];                                      //if not then return value at last-row and last-col
	}
	
	public static void main(String[] args) {
		CoinChange ob = new CoinChange();
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(ob.getCoinChange(coins,amount));
	}
}