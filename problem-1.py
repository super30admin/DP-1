"""
Approach

1. Fact : every number has a unique prime factorization, so we can map each alphabet a-z with a prime and find the product of primes represented by a strings.
2. we will store this product as a key and the add the corresponding string to a list and add that list as value of the map
3. This way each anagrams will have a unique product and they can be gropued in the map based on their product

"""


# Time Complexity : O(nk) where k is the avereage lenght of the strings and n is the no of input strings
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]
        for str in strs:
            product = 1
            for i in range(len(str)):
                product = product *  primes[ord(str[i]) - ord('a')]
            if product in map:
                map[product].append(str)
            else:
                map[product] = []
                map[product].append(str)
        return map.values()
