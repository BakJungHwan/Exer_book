from collections import deque

T = int(input())
for _ in range(T) :
    n = int(input())
    d = deque()
    d.extend(list(map(int,input().split())))

    s = list([2**31])

    for _ in range(n) :
        if d[-1] >= d[0] and d[-1] <= s[-1] :
            s.append(d.pop())
        elif d[-1] < d[0] and d[0] <= s[-1] :
            s.append(d.popleft())
        else :
            break

    if len(d) == 0 :
        print("Yes")
    else :
        print("No")