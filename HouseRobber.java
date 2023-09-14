public Class HouseRobber{
     public int rob(int[] nums) {
        if(nums.length<2) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        int prev = nums[0];
        int current = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            int temp = current;
            current = Math.max(current, nums[i]+prev);
            prev = temp;
        }
        return current;
    }
}