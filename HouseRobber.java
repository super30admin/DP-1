// Time Complexity : O(2^n) where n is the num of integers as for each we
//                    have to go two routes but still not sure of time complexity.
// Space Complexity : O(N) aurxillary space of hashmap used to store already
//                  visited sum
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Followed approach where if I take one index then index to it cannot be taken
so, find if taking that index gives maximum or without taking it.
We keep storing sum for already visited indices since when we move in the
recursion tree, we don't have to calculate them again. */

class HouseRobber
{
    public int rob(int[] nums)
    {
        if(nums.length == 1) return nums[0];

        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int ans = Math.max(nums[0] + helper(nums, 2,map), helper(nums,1,map));

        return ans;
    }

    public int helper(int[] nums, int first, Map<Integer, Integer> map)
    {
        if(first >= nums.length) return 0;

        int sum = 0;

        if(map.containsKey(first)){
            return map.get(first);
        }

        sum = Math.max(nums[first] + helper(nums, first+2, map),
                      helper(nums, first+1, map));

        map.put(first, sum);

        return sum;

    }
}
