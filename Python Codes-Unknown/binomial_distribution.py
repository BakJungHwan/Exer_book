if __name__ == "__main__" :
	boys = 1.09/2.09
	girls = 1/2.09
    
	def fact(x) :
		if x==1 or x==0 :
			return 1
		return x*fact(x-1)

	def binomial(n, r) :
		return fact(n)/fact(r)/fact(n-r)

	ret = 1 - (binomial(6,0)*boys**0*girls**6 + binomial(6,1)*boys**1*girls**5 + binomial(6,2)*boys**2*girls**4)

	print("{:.3f}".format(ret))