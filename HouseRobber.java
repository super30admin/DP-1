// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially could not figure out cases like [2,1,1,2] after realizing this case was able to come up with the approach 
 

// Your code here along with comments explaining your approach

// Example: [2,1,1,2,3,4]
// Initially currMax = 0 and prevMaxx = 0
// 2 : currMax = 2   prevMax = 0
// 1 : currMax = 2   prevMax = 2
// 1 : currMax = 3   prevMax = 2
// 2 : currMax = 4   prevMax = 3
// 3 : currMax = 6   prevMax = 4
// 4 : currMax = 8   prevMax = 6


class Solution {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for(int i=0;i<nums.length;i++)
        {
            int temp = currMax;
            currMax = Math.max(prevMax+nums[i],currMax);
            prevMax = temp;
            // System.out.println("Curr:"+currMax+"Prev:"+prevMax);
        }
        return currMax;
    }
}

