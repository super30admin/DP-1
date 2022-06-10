//T(N)= O(M*N)
// S(N) = O(M*N)

// Where M is lnegth of coins and N is len(0 to amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m =coins.length;
        int n = amount;
        
        int [][] ar= new int[m+1][n+1];
        for(int j=1; j<ar[0].length;j++)
        {
            ar[0][j]=amount+1;
        }
        for(int i=1;i<ar.length;i++)
        {
            for(int j=1;j<ar[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    ar[i][j]=ar[i-1][j];
                }
                else{
                    ar[i][j]=Math.min(ar[i-1][j],1+ ar[i][j-coins[i-1]]);
                }
            }
        }
        if(ar[m][n]>=amount+1) return -1;
        return ar[m][n];
        
        
    }
}