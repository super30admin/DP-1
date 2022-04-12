//TC:O(mn) SC:(mn)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] arr = new int[coins.length+1][amount+1];

        for(int i=0;i<amount+1;i++)
            arr[0][i] = amount+1;

        for(int m=1;m<coins.length+1;m++)
        {
            for(int n=1;n<amount+1;n++)
            {
                if(n < coins[m-1])
                    arr[m][n] = arr[m-1][n];
                else
                    arr[m][n] = Math.min(arr[m-1][n],1 + arr[m][n-coins[m-1]]);
            }
        }

        if(arr[coins.length][amount] == amount+1) return -1;
        return arr[coins.length][amount];
    }
}