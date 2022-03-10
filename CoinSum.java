//Time Complexity: O(m*n);where m is length of coins array and n is amount
//Space Complexity: O(m*n); where m is length of coins array and n is amount
public class CoinSum {
	public int coinChange(int[] coins, int amount) {
		if(coins==null || coins.length==0) return -1;
		
		int m= coins.length+1; //rows
		int n= amount+1; //cols
		int[][] dp= new int[m][n];
		
		//Fill top row: Start from second column as first column is always 0.
		for(int j=1; j<n; j++) {
			dp[0][j]= amount+1;//some number beyond amount to show infinity			
		}
		
		//Fill rest of matrix
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				//Zero Case
				if(coins[i-1] > j) {
					dp[i][j]= dp[i-1][j];
				}else {
					dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
				}
			}
		}
		//Final answer should be present at last row and last column of matrix.
		int res= dp[m-1][n-1];
		if(res > amount) return -1;
		return res;
	}
	
	// Driver code to test above 
    public static void main(String args[]) 
    { 
    	CoinSum ob = new CoinSum();  
    	int[] arr= {1,2,5};
    	int amount=11;
        System.out.println("Min coins to make up the amount "+amount+" is: "+ob.coinChange(arr, amount));
    } 
}
