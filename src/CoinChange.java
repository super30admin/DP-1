
/* This problem is about Coin change  In which I have 
 * used Dynamic Programming.
 * This algorithm creates a dp[][] matrix and place the values in 
 * it and in the end we get the desired value.
 * Complexity of algorithm is O(m * n), m- number of coins and n - amount need to calculated
 *  
 * */
 


public class CoinChange {
	
	
public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length ==0)
            return -1;
        
        // return helper(coins,amount,0,0);
        
        
        int[][] dp= new int[coins.length+1][amount+1];
        
        for(int i=0;i< dp[0].length;i++){
            
            dp[0][i]=9999;
        }
        
        
        for(int i=1;i< dp.length;i++){
            for(int j=1;j< dp[0].length;j++){
                
                if(coins[i-1]> j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= Math.min(dp[i-1][j],1+ dp[i][j- coins[i-1]]);
                }
                
            }
        }
        
        
        
        return dp[dp.length-1][dp[0].length-1] >= 9999 ? -1 :  dp[dp.length-1][dp[0].length-1];
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CoinChange objIn = new CoinChange();
		int[] coins = {1,2,5};
		int amount = 11 ;
		
		System.out.println(objIn.coinChange(coins, amount));

	}

}
