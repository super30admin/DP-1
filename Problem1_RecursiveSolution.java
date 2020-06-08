//Coin change 
class Problem1_RecursiveSolution {
    public int coinChange(int[] coins, int amount) {
      //edge
      if(coins.length ==0 || coins == null) return -1;    
      return helper(coins, amount, 0, 0);      
    }
   
    public int helper(int[] coins, int amount, int index, int min ){
      //recursion base
      if(amount==0) return min;
      else if(amount<0 || index == coins.length) return -1;
      
      //recursive logic
      int pick = helper(coins, amount - coins[index], index, min+1);
      int reject = helper(coins, amount, index+1, min);
      
      //invalid cases
      if(pick == -1) return reject;
      if(reject == -1) return pick;
      
      return Math.min(pick, reject);
    }
  
}
/*
Time Complexity : There are 2 possibilities in each while looking at each 
element of the array and the sub problems build from there on. Therefore,
the time complexity is 2^n

Space Complexity :O(1)
Did this code successfully run on Leetcode : No. Exceeded time limit
Any problem you faced while coding this : No


Your code here along with comments explaining your approach

- Brute force approach in recursive manner
- Compute the values during 2 cases, choosing and not choosing and return the min 
of these values.
- base case of recursion is computed using the recursive logic changing parameter,
that is the amount and the index.
- Take care of edge cases too.
*/


