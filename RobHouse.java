import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(n)
//Space Complexity : O(n)
public class RobHouse {

		  static Map<Integer,Integer> map = new HashMap<>();

		  public static void main(String[] args) {
			  int amtArr[] = {1,2,3,1};
			  System.out.println(" total Amount robbed => " + rob(amtArr));
		  }
		    public static int rob(int[] nums) {
		        return robHelp( nums, 0);
		    }

		   private static int robHelp(int[]nums, int index  ){

		        if(index >= nums.length ) return 0;

		        if(map.get(index) != null){
		            return map.get(index);
		        }

				int robberyDone = robHelp(nums, index + 2) + nums[index];  // if u rob on particular day u need to skip the next day hence index + 2, and add current day amount 
		        int robberyNotDone = robHelp(nums, index + 1); //if u dont rob on particular day u can rob on next day.

		        int result =  Math.max(robberyDone, robberyNotDone);

		        map.put(index, result);

		        return result;
		    }
	}