class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        n = len(skill)
        total_sum = sum(skill)

        if total_sum % (n // 2) != 0:
            return -1

        skill.sort()
        target_sum = total_sum // (n // 2)
        
        chemistry_sum = 0
        
        for i in range(n // 2):
            if skill[i] + skill[n - 1 - i] != target_sum:
                return -1
            chemistry_sum += skill[i] * skill[n - 1 - i]
        
        return chemistry_sum