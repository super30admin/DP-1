// Time Complexity : O(m*n) where m is the length of the coins[] array (or the no of diff denominations we have) and n is total Amount we need to make
// Space Complexity : O(m *n) as we need a 2D matrif of (m+1) * (n+1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class CoinChange
{

    private int target;
    private int[][] dpArray;
    private int MAX = 99999;

    public int coinChange(int[] coins, int amount)
    {
        this.target = amount;

        //initialize the dpArray
        dpArray = new int[coins.length+1][target+1];
        for(int i=0; i<= coins.length; i++)
        {
            for(int j =0; j<= target; j++)
            {
                dpArray[i][j] = MAX;
            }
        }
        return getNumberOfCoins(coins, coins.length, target);
    }

    private int getNumberOfCoins(int[] coins, int index, int leftOverAmount)
    {
        for(int i=0; i<= coins.length; i++)
        {
            for(int j =0; j<= target; j++)
            {
                if(j == 0)
                {
                    dpArray[i][j] = 0;
                }
                else if(i == 0)
                {
                    dpArray[i][j] = MAX;
                }
                else if(coins[i-1] > j)
                {
                    dpArray[i][j] = dpArray[i-1][j] ;
                }
                else
                {
                    dpArray[i][j] = Math.min( dpArray[i][j - coins[i-1]] +1,
                            dpArray[i-1][j]);
                }
            }
        }
        return dpArray[coins.length][target] == MAX ? -1 :  dpArray[coins.length][target];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1,2,5};
        int target = 11;

        System.out.println(obj.coinChange(coins, 11));
    }
}