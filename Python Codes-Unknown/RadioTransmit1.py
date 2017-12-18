import sys


n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
x = [int(x_temp) for x_temp in input().strip().split(' ')]
x = list(set(x))
x.sort()

def installTrans(startP,installed, many) :
    ret = 123456789
    if len(installed) != 0 :
        if installed[-1] + k >= x[-1] :
            return many
    for i in x :
        if i < startP :
            continue
        if len(installed) != 0 :
            if i-k <= x[x.index(installed[-1])+1] :
                installed.append(i)
            else :
                break
        else :
            if i-k <= x[0] :
                installed.append(i)
            else :
                break
        ret = min(ret,installTrans(i+k+1,installed, many +1))
        installed.pop()
    return ret

print(installTrans(0,[],0))
