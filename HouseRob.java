class HouseRob { 
   public int rob(int[] nums) {
        int C = 0, DC = 0;
        int temp;
        for(int i = 0; i < nums.length; i++){
            temp = DC;
            DC = Math.max(C,DC);
            C = nums[i] + temp;
        }
        return Math.max(C, DC);
    }
}
