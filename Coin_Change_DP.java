//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : 


class Coin_Change_DP {
    public int coinChange(int[] coins, int amount) {
    	if(coins == null || coins.length == 0)
    		return 0;
    	int[][] coinChangeDP = new int[coins.length + 1][amount + 1];
    	
    	for(int column = 1; column < coinChangeDP[0].length; column++)
    	{
    		coinChangeDP[0][column] = 10000;
    	}
    	
    	for(int i = 1; i < coinChangeDP.length; i++)
    	{
    		for(int j = 1; j < coinChangeDP[0].length; j++)
    		{
    			if(j < coins[i-1])
    				coinChangeDP[i][j] = coinChangeDP[i-1][j];
    			else
    				coinChangeDP[i][j] = Math.min(coinChangeDP[i-1][j], 1 + coinChangeDP[i][j-coins[i-1]]);
    				
    		}
    	}
    
    	int result = coinChangeDP[coinChangeDP.length-1][coinChangeDP[0].length-1];
    	if(result >= 10000)
    		return -1;
    	return result;
    }
    
    public static void main(String[] args)
    {
    	int[] coins = {1,2,5};
    	int[] coins2 = {2};
    	Coin_Change_DP coinChangeDP = new Coin_Change_DP();
    	
    	System.out.println(coinChangeDP.coinChange(coins, 6789));
    	System.out.println(coinChangeDP.coinChange(coins2, 3));
    }
}
