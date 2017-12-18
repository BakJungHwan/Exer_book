from itertools import product

if __name__ == "__main__" :
    K, M = list(map(int,input().split(' ')))
    N = list()
    ret = -1
    
    for i in range(K) :
        N.append(list(map(lambda x:int(x)**2,input().split(' '))))
    
    for i in product(*N) :
        ret = max(ret,sum(i) % M)
        
    print(ret)
        
    