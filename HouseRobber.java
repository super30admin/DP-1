import java.util.HashMap;
import java.util.Map;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :
// We need to sum the money based on maximum of the values present at the two neighbors.
// The robber should take the max of the adjacent neighbor or the neighbor's neighbor.
public class HouseRobber {

    public int rob(int[] nums) {
      // int maxProfit =  robMemo(nums, 0, 0, new HashMap<>());
      //  int maxProfit = robIterative(nums);
      //  int maxProfit = robIterativeSpace(nums);
        return robRecursive(nums, 0, 0);
    }
    public int robRecursive(int[] nums, int index, int robbedMoney) {
        // N: number of elements in the nums
        // Time Complexity : O(2^N) because at every method call, we are calling two sub problems and it will for N levels,
        // at every level, the recursion calls will be 2^1, 2^2.... 2^N.
        // Space Complexity : O(N), the recursion will go N levels deep before hitting the base case,
        // so in the call stack we will have at max N frames,

        // if we are robbing a house beyond the given array, we are out of bounds and we should take the money and run
        if(index >= nums.length) return robbedMoney;

        // we should make a decision whether to rob neighbor or neighbor's neighbor, whatever makes you wealthy
        return Math.max(robRecursive(nums, index+1, robbedMoney),
                robRecursive(nums, index+2, robbedMoney+nums[index]));
    }

    public int robMemo(int[] nums, int index, int robbedMoney, Map<Integer, Integer> memo) {
        // Time Complexity : O(2N) = ~O(N)
        // We reduced calls by storing house number and robbed money in the map
        // Space Complexity : O(N), the recursion will go N levels deep before hitting the base case

        if(index >= nums.length) return robbedMoney;

        if(memo.containsKey(index)) return memo.get(index);

        int maxWealth = Math.max(robMemo(nums, index+1, robbedMoney, memo),
                robMemo(nums, index+2, robbedMoney+nums[index], memo));

        memo.put(index, maxWealth);
        return maxWealth;
    }

    // We can iterate over the nums array and calculate value based on previous two neighbors
    public int robIterative(int[] nums) {
        // Time Complexity : O(N), need to go through all the houses to find max wealth
        // Space Complexity : O(N), overrides the current data
        int len = nums.length;

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++){
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]);
        }
        return nums[len-1];
    }

    // we just need to keep 2 variables, tracking money at the adjacent house and at the previous house to that one
    public int robIterativeSpace(int[] nums) {
        // Time Complexity : O(N), need to go through all the houses to find max wealth
        // Space Complexity : O(1)
        int len = nums.length;

        int previous = 0;
        int neighbor = 0;
        for (int num : nums) {
            int current = Math.max(neighbor, num + previous);
            previous = neighbor;
            neighbor = current;
        }
        return nums[len-1];
    }

}
