//TimeComplexity O(mn)
//SpaceComplexity O(mn)

class CoinChange {
public int coinChange(int[] coins, int amount) {
int [][] dp = new int[coins.length + 1] [amount +1];
for(int i = 0; i <= coins.length; i++){
dp[i][0] = 0;
}
for(int j = 1; j <= amount; j++){
dp[0][j] = amount+1;   //max amount 
}
for(int i = 1; i <= coins.length; i++){
for(int j = 1; j <= amount; j++){
if(j < coins[i-1]){
dp[i][j] = dp[i-1][j];
} else{
dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
}
}
}
int result = dp[coins.length][amount];
if(result >= amount+1) return -1;
else 
	return result;
}
	public static void main(String args[]) {
     CoinChange ob=new CoinChange();
     int arr[]= {1,2,5};
	System.out.print(ob.coinChange(arr, 11));
	   }
}