// Time Complexity : There is a nested forloop, One iterating through rows and other through columns. So total Asymtotic O(m*n)
// Space Complexity : O(mn) for the dp array is the auxillary space used
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

class CoinChangeDP { 
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length + 1][amount + 1];  //auxillary dp matrix to avoiding overlapping sub-problems   
        int m = dp.length;
        int n = dp[0].length;
        for(int i = 0; i < m; i++)
        {  //first column of the dp matrix will always have 0 since 0 amount can be made using 0 coins
            dp[i][0] = 0;
        }
        for(int i = 1; i < n; i++)
        { //the 1st row of the dp matrix represents denomination 0 so we just put in infinity everywhere
            dp[0][i] = 99999;
        }
        for(int i = 1; i < m; i++)  //Iterating over the entire dp matrix
        {
            for(int j = 1; j < n; j++)
            {
                if(j < coins[i - 1])
                {
                    dp[i][j] = dp[i-1][j];   //until amount is not equal to denomination keep on taking values from the row above
                }
                else{ //amount equal to or greater than denomination
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);  //take maximum between the above row and denomination times back value plus 1. We take max because there could be negative denomination
                }
            }
        }
        int result = dp[m-1][n-1];  //finally return last element of the dp matrix which would contain the answer
        if(result >= 99999) return -1; //if amount cannot be made return -1
        return result;
                
    }
}

//Main Class
class Main
{
    public static void main(String[] args)
    {
    CoinChangeDP obj = new CoinChangeDP();
    int[] coins = {1, 2, 5}; 
    int amount = 11;
    System.out.print("Minimun number of coins required to achieve amount " + amount + " is " + obj.coinChange(coins, amount));  //11 = 5 + 5 + 1
    System.out.print("\n");
    }
}