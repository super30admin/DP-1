class HouseRob { 
   public int rob(int[] nums) {
        
	// C - considering, DC - Dont Consider
	int C = 0, DC = 0;
        
	//temp - Stores DC value, used in calculating C after DC is updated
	int temp;
        for(int i = 0; i < nums.length; i++){
            temp = DC;
            DC = Math.max(C,DC);   // MAX --> max profit
            C = nums[i] + temp;
        }
        return Math.max(C, DC);
    }
}
