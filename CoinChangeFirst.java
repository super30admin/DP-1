import javax.lang.model.util.ElementScanner14;

// this is a problem where we have multiple evaluations
// the brute force aproach for this problem would be to evaluate all possible combinations to get the result
// after getting all the evaluations pick the best evaluation
// however, in these evaluations we have a couple of the computation repeating
// our approach will be to use DP so that we can store these evaluations in such a way that they can be reffered for later computations

//in coin change, we want to know min number of coins that will make up the result
//we have two variables, one being coin and other being the target amount
//thus, our dp will be of 2d matrix, starting from coin min to max in column and amount in row 

// Time Complexity : O(mxn)
// Space Complexity : O(mxn)

public class CoinChangeFirst {

    public static void main(String[] args)
    {

        int[] coins = {1,2,5};
        int target = 11;
        System.out.println("Number of coins forming the amount" + target + " is " + numberOfCoins(coins,target));
    
    }

    public static int numberOfCoins(int[] coins, int target)
    {
        int m = coins.length;
        int n = target;
        int [][]dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for(int j=1; j<=n; j++)
        {
            dp[0][j] = Integer.MAX_VALUE - 10;
        }

        for (int i = 1; i<=m; i++) // i is row
        {
            for(int j = 1; j<=n; j++) // j is column
            { 
            
            if(j < coins[i-1]) // i is an index from 1, referencing 0th index and so on
            {
                dp[i][j] = dp[i-1][j];
            }
            else
            {
                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }


        }}

        if(dp[m][n] >= Integer.MAX_VALUE - 10)  return -1;

        return dp[m][n];

    }
    
}
