import sys

n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
x = [int(x_temp) for x_temp in input().strip().split(' ')]
x = list(set(x))
x.sort()

ret = 0
startP = 0
flag = False

for i in x :
    if i < startP :
        continue
    for j in range(n) :
        if x[j] < startP :
            continue
        if x[j]-k > i :
            startP = x[j-1]+k+1
            ret+=1
            if x[j]+k >= x[-1] :
                flag = True
            break
    if flag :
        break
ret+=1
print(ret)