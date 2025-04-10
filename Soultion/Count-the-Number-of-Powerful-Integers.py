class Solution(object):
    def numberOfPowerfulInt(self, start, finish, limit, s):
        def find(finish):
            n = 0
            while finish // (10**n):
                n+=1
            l = len(s)
            c = 0
            n-=1
            if int(s)>finish:
                return 0
            elif n+1 == len(s):
                if int(s)<=finish:
                    return 1
                else:
                    return 0
            while n:
                u = finish //(10**n)
                m = min(u, limit)
                if m==u:
                    c+=((limit+1)**(n-l))*m
                else:
                    c+=((limit+1)**(n-l))*(m+1)
                    return c
                finish = finish % (10**n)
                n-=1
                if n+1==l:
                    if finish >=int(s):
                        c+= 1
                    return c
            return c
        return find(finish)-find(start-1)