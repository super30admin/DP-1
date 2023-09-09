class Solution {
    // Exhaustive approach
    // Time complexity: O(n^2)
    public int coinChange(int[] coins, int amount) {
        // If no coin denominations are given return -1
         if(coins==null || coins.length==0)
         {
             return -1;
         }
// If amount is 0 return 0
         if(amount==0)
         {
             return 0;
         }
// Recursive function
         return recurse(coins, amount, 0, 0);        
    }


    private int recurse(int[] coins, int amount, int index, int coinsUsed)
    {
        // if the index exceeds coin length or aamount becomes negative it implies in that specific branch it is not possible to achieve the amount using specific cons denomination
        if (index == coins.length || amount<0)
        {
            return -1;
        }
        // If amount is 0 then return the coinsUsed to achieve that amount
        if(amount==0)
        {
            return coinsUsed;
        }

// case 1 where the first element from the coins array is removed and not a part of calculation further
        int case1 = recurse(coins, amount, index + 1, coinsUsed);
        // case 2 where the element from the coins array are not secluded and first element is a part of the calculation
        int case2 = recurse(coins, amount-coins[index], index, coinsUsed+1);

// If case1 does not give correct coins used return case 2
        if(case1==-1)
        {
            return case2;
        }
        // If case2 does not give correct coins used return case 1
        if(case2==-1)
        {
            return case1;
        }
        // If both the cases give us correct output the return the minimum
        return Math.min(case1, case2);

    }
}
