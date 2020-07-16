// Time Complexity : O(n) go over the array once
// Space Complexity : O(n+1) memorization array for n+1 elems
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  // yes dp problem

// Your code here along with comments explaining your approach
  // create a memorization array that keeps record of max loot for each house.
  // strts from 0 to n+1, 0 being when no house looted and n+1 is last house.
  // then for each house see if loot two houses down + loot this house is larger
  //or is the loot larger one house down larget.
  //set this larger val in memo.

  //also since we are only looking at past two vals, we can also use the logic
  //in fibbonachi series to have two pointers that store max and last max 
  //loot. that way we wont need the memorization array.

class Solution {
    public int rob(int[] nums) {
        int memo[] = new int[nums.length+1];

        int loot = 0;
        for(int i = 0 ; i < nums.length;i++){
            memo[i+1] = Math.max(memo[i], loot+nums[i]);
            loot = memo[i];
        }
        return memo[memo.length -1];
    }
}
