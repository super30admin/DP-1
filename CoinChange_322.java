package CoinChange_322;

public class CoinChange_322 {
	
	 public int coinChange(int[] coins, int amount) {
		 int[][] coin_matrix = new int[coins.length+1][amount+1];
		 
		 int m = coin_matrix.length;
		 int n = coin_matrix[0].length;
	// Populating the first row with coin value 0 with one highest possible value 	 
		 for(int i = 0 ; i<n ; i++)
		 {
			 coin_matrix[0][i] = Integer.MAX_VALUE -1;
		 }
//Populating the first column as 0 for amount 0		 
		 for(int i = 0; i<m ; i++)
			 
		 {
			 coin_matrix[i][0] = 0;
		 }
		 
		 for(int i=1 ; i<m; i++)
		 {
			 for(int j=1 ; j<n ; j++)
			 {
				 if (j < coins[i-1])
					 
				 {
					 coin_matrix[i][j] = coin_matrix[i-1][j];
				 }
					 
				 else
				 {
					 coin_matrix[i][j] = Math.min(coin_matrix[i-1][j],1+coin_matrix[i][j-coins[i-1]]);
				 }
			 }
		 }
		 
		if(coin_matrix[m-1][n-1] >= Integer.MAX_VALUE -1) 
		{
			 return -1;
		}
		 else
		 {
			 return coin_matrix[m-1][n-1];
		 }
}  
	public static void main(String[] args) {
		
		
		int[] coins = {1,2,5};
		CoinChange_322 obj = new CoinChange_322();
		int no_of_coins = obj.coinChange(coins, 11);
		System.out.println("The minimum number of coins required is : " +no_of_coins);

	}

}

//@Time Complexity = O(MN)
//Space Complexity = O(MN)