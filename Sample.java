//coin change problem
// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] mat= new int[coins.length+1][amount+1];
        
        for(int i=0; i<coins.length+1;i++)
            mat[i][0]=0;
        
        for(int j=0;j<amount+1;j++)
            mat[0][j]=99999;
        
         for(int i=1;i<=coins.length;i++)
         {
             for(int j=1;j<=amount;j++)
             {
                 if(j<coins[i-1])
                 {
                     mat[i][j]=mat[i-1][j];
                 }
                 else
                 {
                     mat[i][j]=Math.min(mat[i-1][j], 1+mat[i][j-(coins[i-1])]);
                 }
             }
         }
        return mat[coins.length][amount] ==99999 ? -1 :mat[coins.length][amount];
    }
}

//house robber
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int C=0;
        int DC=0;
        
        for(int i=0;i<nums.length;i++)
        {
            int temp=DC;
            DC=Math.max(C,DC);
            C=nums[i]+temp;
            
        }
        return Math.max(C,DC);
    }
}
