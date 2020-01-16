// Time Complexity : O(2^n)
// Space Complexity : Recursive stack grows organically At max, the recursion stack will be called amount/min_denomination times. So Asymtotically O(amount/minimum denomination in coins array)
// Any problem you faced while coding this : Time Limit Exceeded on large inputs

// Your code here along with comments explaining your approach


class CoinChangeRecursive {
    public int coinChange(int[] coins, int amount) {
    return helper(coins, amount, 0, 0);  
    
    }
    
    private int helper(int[] coins, int amount, int index, int min){
        //base
        if(amount < 0 || index == coins.length) return -1;
        if(amount == 0) return min;
        //logic
        
        int case1 = helper(coins, amount, index + 1, min); //when we dont select a coin
        int case2 = helper(coins, amount - coins[index], index, min + 1); //when we select
        if(case1 == -1)
            return case2;
        else if(case2 == -1)
            return case1;
    
        return Math.min(case1, case2);
    }
}

//Main Class
class Main
{
    public static void main(String[] args)
    {
    CoinChangeRecursive obj = new CoinChangeRecursive();
    int[] coins = {1, 2, 5}; 
    int amount = 11;
    System.out.print("Minimun number of coins required to achieve amount " + amount + " is " + obj.coinChange(coins, amount));  //11 = 5 + 5 + 1
    System.out.print("\n");
    }
}