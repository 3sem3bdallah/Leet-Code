class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        temp_dict = {}

        for s in strs:
            sorted_s = "".join(sorted(s))
            if sorted_s in temp_dict:
                temp_dict[sorted_s].append(s)
            else:
                temp_dict[sorted_s] = [s]

        for group in temp_dict.values():
            res.append(group)

        return res
