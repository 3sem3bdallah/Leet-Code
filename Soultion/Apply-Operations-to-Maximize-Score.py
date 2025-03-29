N = 10**5 + 1
P = int(1e9) + 7
arr = defaultdict(set)

for i in range(2, N):
    if not arr[i]:
        j = i
        while j <= N:
            arr[j].add(i)
            j += i   

def modpow(a, n):
    if n == 0:
        return 1

    res = modpow(a, n >> 1) % P

    res = (res*res)%P

    return (res * a) % P if n & 1 else res

class Solution:
    def maximumScore(self, A, k):
 
        B = sorted([[v, i] for i, v in enumerate(A)], key = lambda x : x[0], reverse= True)

        n = len(A)
        
        left = [0]*n
        stk = []
        for i in range(n):
            
            while stk and len(arr[A[stk[-1]]]) < len(arr[A[i]]):
                stk.pop()
            if stk:
                left[i] = stk[-1]
            else:
                left[i] = -1
            stk.append(i)
            
        
        right = [0]*n
        stk = []
        for i in range(n-1, -1, -1):
            
            while stk and len(arr[A[stk[-1]]]) <= len(arr[A[i]]):
                stk.pop()
            if stk:
                right[i] = stk[-1]
            else:
                right[i] = n
            stk.append(i)
            

        res = 1
        for i in range(n):
            v, j = B[i]
            temp = k
            ele = (j - left[j]) * (right[j] - j)
            k = max(0, k -  ele)
            if k:
                res = (res * modpow(v, ele)) % P
            else:
                res = (res * modpow(v, temp)) % P
                break


        return res