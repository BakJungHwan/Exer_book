from collections import deque

def stack(d, s) :
    if len(s) > 1 :
        if s[-2] < s[-1] :
            return False

    if len(d) == 0 :
        return True
    
    d1 = deque(d)
    d2 = deque(d)
    
    s1 = list(s)
    s2 = list(s)
    
    s1.append(d1.pop())
    s2.append(d2.popleft())
    
    print("s1 = " + str(s1) + "    d1" + str(d1))
    print("s2 = " + str(s2) + "    d2" + str(d2))

    return stack(d1, s1) or stack(d2, s2)

T = int(input())

for _ in range(T) :
    n = int(input())
    d = deque()
    d.extend(list(map(int,input().split())))
    
    s = list()
    
    if stack(d,s) :
        print("Yes")
    else :
        print("No")