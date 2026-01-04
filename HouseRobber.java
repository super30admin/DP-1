// Time Complexity : O(2pow(m)) where m house len
// Space Complexity :O(2pow(m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE
class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int max = helper(nums,0);
        return max;
    }

    private int helper(int[] nums, int index)
    {
        //base case
        if(index>=nums.length)
        {
            return 0;
        }
        //if current house is robbed
        int case1 = nums[index] + helper(nums, index+2);
        //if current house is not robbed
        int case2 = helper(nums,index+1);
        return Math.max(case1,case2);
    }
}

// Time Complexity : O(m) where m house len
// Space Complexity :O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int[] mem = new int[nums.length];
        Arrays.fill(mem,-1);
        int max = helper(nums,0,mem);
        return max;
    }

    private int helper(int[] nums, int index,int[] mem)
    {
        //base case
        if(index>=nums.length)
        {
            return 0;
        }
        //if you have seen the index, return the max possible there
        if(mem[index]!=-1)
        {
            return mem[index];
        }
        //if current house is robbed
        int case1 = nums[index] + helper(nums, index+2, mem);
        //if current house is not robbed
        int case2 = helper(nums,index+1, mem);
        int max = Math.max(case1,case2);
        mem[index] = max;
        return max;
    }
}

// Time Complexity : O(m) where m house len
// Space Complexity :O(m)-> can use same array also
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        //edge case
        if(nums.length==1)
        {
            return nums[0];
        }
        int[] mem = new int[nums.length];
        Arrays.fill(mem,-1);
        //for first element it's always the same one
        mem[0] = nums[0];
        //for second element it's max of 1st two
        mem[1] = Math.max(nums[0],nums[1]);
        //from index 2 onwards you either rob the house, then that will be current + previous-1
        //else previous
        for(int i = 2;i<nums.length;i++)
        {
            int currHouseRobbed = mem[i-2] + nums[i];
            int currHouseNotRobbed = mem[i-1];
            mem[i] = Math.max(currHouseRobbed,currHouseNotRobbed);
        }
        return mem[nums.length-1];
    }


}