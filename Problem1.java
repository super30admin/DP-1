package day7;


//Time Complexity : O(n*n) nums.length+1 * amount+1 dimension array travesal time is used.  
//Space Complexity : O(n)  nums.length+1 * amount+1 dimension array size is used.
//Did this code successfully run on Leetcode 
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
		//System.out.println(s.coinChange(coins, 11));
		System.out.println(s.coinChangeDP(coins, 11));
		

	}

}
class Solution1 {
    /*public int coinChange(int[] coins, int amount) {
    	
    	
        
    	return -1;
    }
    
    public int help(coins, target,index, minElement) {
    	
    	
    	//Base Case
    	
    	
    	//Case 1 : add the element iteselft targer number of times.
    	
    	int c1  = help (coins, target, index, minElement+)
    	
    	
    	// Case 2 :  do not the choose the element and move to the next element.
    	
    	
    }*/
    
    
   public int coinChangeDP(int[] coins, int amount) {
       
        /*
         j -->   0  1   2  3  4  5  6  7
         i  ---|---------------------------------------------------
         0  ---|-0--*---*--*--*--*--*--*-------------------------------
         1  ---|-0--1---2--3--4--5--6--7---------------------------
         2  ---|-0--1---1--2--2--3--3--4--------------------------
         5  ---|-0--1---1--2--2--1--2--2-------------------------
            ---|---------------------------------------------------
                  
        */
        
        int[][] dp = new int[coins.length+1][amount+1];    
        // Here coins.length+1 and amount +1 is taken for having the 0 denomitaion and 0 target.
        
        for(int i=0;i<dp.length;i++){  // all the rows i.e all the denomination , the target sum 0 will 0 only.
            dp[i][0] = 0;
        }
         for(int j=1;j<dp[0].length;j++){ // all the next sums in the 0 denomination. will be infinity.
            dp[0][j] = 99;
        }
        
        for(int i=1; i<dp.length; i++){
            
            for(int j=1;j<dp[0].length;j++){
                //Case 1: Copy from above in the tablar method.
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
//         for (int i = 0; i < dp.length; i++) {
//            // Loop through all elements of current row 
//             for (int j = 0; j < dp[i].length; j++){ 
//                 System.out.print(dp[i][j] + "\t"); }
        
//         System.out.println(" ");
//     }
        
        
        int result = dp[coins.length][amount];
        if(result>=99) return -1;
        else return result;
         
        
    }
	

	
    
    
}

