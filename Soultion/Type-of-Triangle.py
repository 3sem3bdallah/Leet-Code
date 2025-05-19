class Solution:
    def triangleType(self, nums: List[int]) -> str:
        nums.sort()
        a, b, c = nums
        if a + b <= c:
            return "none"
        
        unique_sides = len(set(nums))
        if unique_sides == 1:
            return "equilateral"
        elif unique_sides == 2:
            return "isosceles"
        else:
            return "scalene"