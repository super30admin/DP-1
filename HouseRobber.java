

// o(n) -time  , since we are linear searching the entire array
// O(1) - space  since we are updating the same auxillary data structure and not creating any new data structure inside the for loop
public class HouseRobber {

	public int rob(int[] nums) {
     
		if(nums.length==1) {
			return nums[0];
		}
		
		int dp[]= new int [nums.length];
		
		dp[0]=nums[0];
		dp[1]= Math.max(nums[0],nums[1]);
		
		for(int i=2; i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1], nums[i]+ dp[i-2]);
			
			
		}
	
		
		return dp[nums.length-1];
    }
	
	
	
	public static void main(String[] args) {
		
		HouseRobber houseRobber = new HouseRobber();  
		int nums[] = {2,7,9,3,1};
	
	int rob = houseRobber.rob(nums);
        System.out.println(rob);
	}
}
