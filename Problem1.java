package day7;


//Time Complexity :
//Space Complexity :
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :


//Your code here along with comments explaining your approach


/*

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1 Example 2:

Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have an infinite number of each kind of coin.*/

public class Problem1 {
	
	
		public static void main(String[] args) {
		int coins[] = {1,2, 5};
		Solution1 s = new Solution1();
		System.out.println(s.coinChange(coins, 11));
		System.out.println(s.coinChangeDP(coins, 11));
		

	}

}
class Solution1 {
    public int coinChange(int[] coins, int amount) {
    	
    	
        
    	return -1;
    }
    
    public int help(coins, target,index, minElement) {
    	
    	
    	//Base Case
    	
    	
    	//Case 1 : add the element iteselft targer number of times.
    	
    	int c1  = help (coins, target, index, minElement+)
    	
    	
    	// Case 2 :  do not the choose the element and move to the next element.
    	
    	
    }
    
    
   public int coinChangeDP(int[] coins, int amount) {
        
    	return -1;
    }
    
    
}

