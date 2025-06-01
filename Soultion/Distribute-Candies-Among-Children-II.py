class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def egy(n):
            return 0 if n<0 else (n+2)*(n+1)//2
        return egy(n) - 3 * egy(n-limit-1) + 3 * egy(n-2*(limit+1)) - egy(n-3*(limit+1))