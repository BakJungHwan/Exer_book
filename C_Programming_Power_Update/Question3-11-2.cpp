#include <stdio.h>

int main()
{
	int n;
	int sum=1;
	int i=2;
	
	do
	{
		scanf("%d",&n);
	}while(n<2);
	
	while(sum<=n)
	{
		sum+=i;
		++i;
	}
	
	printf("%d\n", sum-i+1);
	printf("%d\n", sum);
	
	return 0;
}
