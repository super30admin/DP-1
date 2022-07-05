//o(n)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] tab = new int[nums.length];
        tab[0] = nums[0];
        tab[1] = Math.max(nums[0], nums[1]);
        
        int max = Math.max(tab[0], tab[1]);
        for (int i = 2; i < nums.length; i++) {
            tab[i] = Math.max(nums[i] + tab[i-2], tab[i-1]);
            max = (max < tab[i])? tab[i] : max;
        }
        
        return max;
    }
}