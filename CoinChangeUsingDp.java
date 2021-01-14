class Solution2 {

	//	Time:  O(m*n) 
	//	Space O(m*n) 
	//	LeetCode: yes

	public int coinChange(int[] coins, int amount) {
		//create a dp matrix, coins and amount
		int [][] dp = new int[coins.length + 1] [amount +1];

		int m = dp.length;
		int n = dp[0].length;
		//we always consider there is a '0' coin in coins array as weel
		for(int i = 0; i < m; i++){
			//pre - setting first column as 0
			dp[i][0] = 0;
		}
		for(int j = 1; j < n; j++){
			//setting first row as infinity
			dp[0][j] = 99999;  
		}
		for(int i =1 ; i < m; i++){
			for(int j =1 ; j < n; j++){
				if(j < coins[i-1]){
					//otherwise copy values from top row until coin value reached
					dp[i][j] = dp[i-1][j];
				} else{
					//choosing minimum between top row (dp[i-1][j]) and 
					//1+ coin value back in the same row (dp[i][j - coins[i-1]])
					dp[i][j] = Math.min(dp[i-1][j], (dp[i][j - coins[i-1]])+1);
				}
			}
		}
		//last row , last column is the result in dp matrix
		int result = dp[coins.length][amount];
		if(result == 99999) return -1;
		return result;   
	}
}

