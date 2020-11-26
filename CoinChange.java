// Time Complexity :O(N*A) where n is the number of different coins and A is the amount 
// Space Complexity :O(A) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach:storing the minimum coins required to find specific amount in an array. This can 
// be computed by iterating through alla the possible combinations of the coins to form that specific amount.

class Solution {
    public int coinChange(int[] coins, int amount) {
  //      Arrays.sort(coins);
        return find(coins,amount,new int[amount+1]);
    }
    
    public int find(int[] coins,int rem,int[] count){
        if(rem==0) return 0;
        if(rem<0) return -1;
        if(count[rem]!=0) return count[rem];
        int min=Integer.MAX_VALUE;
            for(int coin : coins){
                int res=find(coins,rem-coin,count);
                if(res>=0&& res<min)
                min=1+res;
            }
		if(min!=Integer.MAX_VALUE)
			count[rem]=min;
		else
			count[rem]=-1; 
        return count[rem];
    }
}