#include <stdio.h>

int Factorial(int n)
{
	if(n<1)
	{
		return -1;
	}
	
	int sum=1;
	
	for(int i=2; i<=n; ++i)
	{
		sum*=i;
	}
	
	return sum;
}


int main(void)
{
	int n;
	
	scanf("%d",&n);
	
	printf("%d", Factorial(n));
	
	return 0;
}
