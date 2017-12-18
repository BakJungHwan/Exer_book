if __name__ == "__main__" :
    p = 0.12
    q = 1 - p
    def fact(x) :
        if x==1 or x==0 :
            return 1
        return x*fact(x-1)
    def binomial(n, r) :
        return fact(n)/fact(r)/fact(n-r)
    ret1 = binomial(10,0)*q**10*p**0 + binomial(10,1)*q**9*p**1 + binomial(10,2)*q**8*p**2
    ret2 = 1 - ret1 + binomial(10,2)*q**8*p**2
    print("{0:.3f}".format(ret1))
    print("{0:.3f}".format(ret2))
