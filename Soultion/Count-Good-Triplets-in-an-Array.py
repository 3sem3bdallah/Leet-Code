class Solution(object):
    def goodTriplets(self, nums1, nums2):
        n = len(nums1)
        st = [0]*(4*n)
        def update(i, idx, l, r): # log n
            if l==r:
                st[i]=1
                return 1
            mid = (l+r)//2
            if idx<= mid:
                st[i] = update(2*i+1, idx, l, mid)+ st[2*i+2]
            else:
                st[i] = st[2*i+1]+ update(2*i+2, idx, mid+1, r)
            return st[i]

        d =[0]*n
        for i in range(n):
           d[nums2[i]]=i

        def cal(lc, i): # constant
            left_uncommon = i-lc
            right_common = n-1-d[nums1[i]]-left_uncommon
            return lc*right_common

        def left_common(i, left, right, l, r): # log n
            if right<l or left>r:
                return 0
            elif left<= l and r<= right:
                return st[i]
            else:
                mid = (l+r)//2
                return left_common(2*i+1, left, right, l, mid)+left_common(2*i+2, left, right, mid+1, r)
        out = 0
        for i in range(len(nums1)):
            lc = left_common(0, 0, d[nums1[i]], 0, n-1)
            out+= cal(lc, i)
            update(0,d[nums1[i]] , 0, n-1)
        return out