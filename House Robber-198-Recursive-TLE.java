class Solution {
    // Recursive Solution

  // Time Limit Exceeded Error
  // Time Complexity: O(n^2)

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }

        return recurse(nums, 0, 0);
    }

    private int recurse(int[] nums, int index, int earning)
    { 
       // base case
       if(index>=nums.length)
       {
           return earning;
       }

// Ignoring the current element and considering next adjacent element
       int case1 = recurse(nums, index+1, earning);
       // Considering current element, adding it to the earning and ignoring the adjacent element
       int case2 = recurse(nums, index+2, earning+nums[index]);
       return Math.max(case1,case2);
    }
}
