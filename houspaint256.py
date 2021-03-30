# Approach 1
# Time complexity - exponential - O(2**n)
# Space Complexity - O(depth of recursive tree)


class Solution:
    def __helper(self, costs: List[List[int]], row: int, color: int, amount:int):
        if (row == len(costs)):
            return amount
        
        if (color == 0):
            return min(self.__helper(costs, row + 1, 1, amount + costs[row][0]), self.__helper(costs, row + 1, 2, amount + costs[row][0]))
            
        if (color == 1):
            return min(self.__helper(costs, row + 1, 0, amount + costs[row][1]), self.__helper(costs, row + 1, 2, amount + costs[row][1]))
        
        if (color == 2):
            return min(self.__helper(costs, row + 1, 1, amount + costs[row][2]), self.__helper(costs, row + 1, 0, amount + costs[row][2]))
        
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs == None or len(costs) == 0):
            return 0
        
        case_red = self.__helper(costs, 0, 0, 0)
        case_green = self.__helper(costs, 0, 1, 0)
        case_blue = self.__helper(costs, 0, 2, 0)
        
        return min(case_red, case_green, case_blue)

# Approach 2
# Time complexity - O (#houses * #colors) - since colors is constant its O(#houses)
# Space Complexity - O(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs == None or len(costs) == 0):
            return 0
        
        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1], costs[i+1][0])
            
        return min(costs[0][0], costs[0][1], costs[0][2])
 
# Approach 3
# Time complexity - O (#houses * #colors) - since colors is constant its O(#houses)
# Space Complexity - O(1)         since only three variables used to process  

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs == None or len(costs) == 0):
            return 0
        
        cred = costs[len(costs) - 1][0]
        cgreen = costs[len(costs) - 1][1]
        cblue = costs[len(costs) - 1][2]
        
        for i in range(len(costs) - 2, -1, -1):
            temp_red = cred
            temp_green = cgreen
            
            cred = costs[i][0] + min(cgreen, cblue)
            cgreen = costs[i][1] + min(temp_red, cblue)
            cblue = costs[i][2] + min(temp_green, temp_red)
            
        return min(cred, cgreen, cblue)
            
        
        
        
