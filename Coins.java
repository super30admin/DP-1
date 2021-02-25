//Time Complexity: O(ab)
//Space Complexity: O(ab)
//Compiled on leet code.
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int a=coins.length+1;
        int b = amount+1;     
        int [][]dp = new int[a][b];
        
        for(int i=1;i<b;i++)
            dp[0][i] = 10001;							//By storing each available value in an array we get min by end using all the values.
        for(int i=0;i<a;i++)
            dp[i][0] = 0;
        
        for(int i=1;i<a;i++)
        {
            for(int j=1; j<b;j++)						
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];						//If j that is required amount is less that denomination available at particular index. we just put the previous value.
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);			//if not we choose the min value of choose or no choose data
            }
        }
        return dp[a-1][b-1]==10001 ? -1 : dp[a-1][b-1];
    }
}