public class HouseRobber {

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  No

    //Using two pointers O(N) time and O(1) space
    /*public int rob(int[] nums) {
        int prev = nums[0];
        int curr = Math.max(prev, nums[1]);
        for(int i=2;i<nums.length;i++) {
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }
        return curr;
    }*/

    // Using 1D auxiliary array O(N) time and space
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(arr[0], nums[1]);
        for(int i=2;i<nums.length;i++) {
            arr[i] = Math.max(nums[i-1], nums[i]+nums[i-2]);
        }
        return arr[nums.length-1];
    }
}
