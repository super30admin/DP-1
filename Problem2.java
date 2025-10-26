//HOUSE ROBBER PROBLEM
/*
Time Complexity: O(n)
Space Complexity: O(1)

Approach:
 The approach uses the underlying concept that the optimal solution of robbing or not robbing a house
    depends on the optimal solution at the adjust house and the house presiding it.
 */
//HOUSE ROBBER PROBLEM
public class Problem2 {
    class Solution {
        public int rob(int[] nums) {
            // If there are one or two houses in the list
            if(nums.length==1) return nums[0];
            int previous =nums[0];
            int current = Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++){
                int temp = current;
                // Max amount by choosing or not choosing the house
                current = Math.max(current ,previous+nums[i]);
                previous = temp;
            }
            return current;
        }


    }
}
