from itertools import groupby

if __name__ == '__main__' :

	string_a = input()
	temp = string_a[0]
	count_a = 0

	for i in string_a :
		if temp == i :
			count_a += 1
		else :
			print("({0}, {1})".format(count_a,temp), end=' ')
			temp = i
			count_a = 1

	if count_a != 0 :
		print("(%d, %d)" % (count_a, int(string_a[-1])))

		
		
