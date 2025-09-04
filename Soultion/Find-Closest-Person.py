class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        r1, r2 = abs(x - z), abs(y - z)
        if r1 == r2:
            return 0
        if r1 < r2:
            return 1
        else:
            return 2
