1class Solution:
2    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
3        order = {
4        "electronics": 0,
5        "grocery": 1,
6        "pharmacy": 2,
7        "restaurant": 3
8        }
9    
10        valid = []
11        
12        for c, b, a in zip(code, businessLine, isActive):
13            if not a:
14                continue
15            if b not in order:
16                continue
17            if not c or not re.match(r'^[A-Za-z0-9_]+$', c):
18                continue
19            
20            valid.append((order[b], c))
21        
22        valid.sort(key=lambda x: (x[0], x[1]))
23        
24        return [c for _, c in valid]