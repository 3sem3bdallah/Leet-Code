class Solution:
    def findLucky(self, arr: List[int]) -> int:
        lucky = -1
        for num in set(arr):
            if arr.count(num) == num:
                lucky = max(lucky, num)
        return lucky