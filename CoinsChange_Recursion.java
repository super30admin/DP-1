
/**
Leet Code Submitted : NA (Recursive solution)
Time Complexity : O(2^N)
Space Complexity: O(2^N)

We use decision recursion tree to either choose a coin or not a coin and then do DFS on it till we hit any of the boundary condition. Once, all the tree is traversed we find the minimum solution leaf node*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length <1)
            return -1;
        
        if(amount ==0)
            return 0;    
        
        return(decision(coins,amount,0,0));
            
    }
    int decision(int[] coins, int amount, int i,int min){
        if(amount == 0)
            return min;
        
        if(amount < 0 || i >= coins.length)
            return -1;
        
        int l = decision(coins,amount-coins[i],i,min+1);
        int r = decision(coins,amount,i+1,min);
        
        if(l == -1 && r == -1)
            return -1;
        
        if(l == -1)
            return r;
        else if(r == -1)
            return l;
        
        return Math.min(l,r);
        
    }
}

