import java.util.*;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : I have seen this problem earlier so nothing as such
// https://leetcode.com/problems/house-robber/

class HouseRobber {

  public static void main(String[] args){

  }

  private int robHouse(int[] nums){
    if(nums == null || nums.length == 1) return nums[0];

    // for each house we can rob it or we don't rob it.
    int currMax = 0;
    int prevMax = 0;
    // [1,5,10,0,0,100,70]

    for(int i = 0 ; i < nums.length ; i++){
      int temp = currMax;
      currMax = Math.max(currMax, prevMax + nums[i]);
      prevMax = temp;

    }

    return currMax;
  }
}
