// TC: O(N) where N is the number of elements in array which is used to store in table
// SC: O(N) where n array table using to store values

// Dynamic Programming and Brute force approach below is implemented
// DP solution (houseRob function) We are storing the sum of the values of either previous number or sum of present and 2 elements prior to the present
// element and finding the maximum of the 2 numbers, once we hvae the value of present and previous, we store in dp table. this is how we are storing over
//overlapping problems in a table so that we can reuse them


public class HouseRobber {
	
	public int houseRobber(int[] amt) {
		return helper(amt, amt.length-1);
	}
	
	public int helper(int[] nums, int i) {
		if(i<0)
			return 0; 
		return Math.max(helper(nums, i-2)+nums[i], helper(nums, i-1));	
	}
	
	public int houseRob(int[] house) {
		
		if(house.length==0)
			return 0;
		if(house.length==1)
			return house[0];
		int[] dp = new int[house.length];
		
		dp[0] = house[0];
		dp[1] = Math.max(house[0], house[1]);
		
		for(int i=2;i<house.length;i++) {
			dp[i] = Math.max(dp[i-2]+house[i], dp[i-1]);
		}
		return dp[house.length-1];
		
	}

	public static void main(String[] args) {
		
		HouseRobber hr = new HouseRobber();
		int[] amt = {2, 7, 9, 3, 1};
		System.out.println(hr.houseRob(amt));
	}
}
