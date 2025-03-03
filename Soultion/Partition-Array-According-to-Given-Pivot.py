class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        less, eq, great = [], [], []
        for num in nums:
            if num < pivot:
                less.append(num)
            elif num == pivot:
                eq.append(num)
            else:
                great.append(num)
        return less + eq + great
