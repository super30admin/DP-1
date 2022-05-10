 // Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] temp=new int[amount+1];
        Arrays.fill(temp,99999);
        temp[0]=0;
        for(int i=0;i<coins.length;i++)
        {
            for(int j=0;j<temp.length;j++)
            {   
                if(j>=coins[i])
                {
                    temp[j]=Math.min(temp[j],1+temp[j-coins[i]]);
                }
                    
            }
        }
        if(temp[amount]>=9999)
            return -1;
        return temp[amount];
        
    }
}