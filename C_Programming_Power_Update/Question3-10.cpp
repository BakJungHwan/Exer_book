#include <stdio.h>

int main(void)
{
	int n1;
	int n2;
	int temp;
	int sum=0;
	int i;
	
	scanf("%d", &n1);
	scanf("%d", &n2);
	
	
	if(n1 > n2)
	{
		temp = n1;
		n1 = n2;
		n2 = temp;
	}
	
	for(i=n1; i<=n2; ++i)
	{
		if(i%3==0 || i%5==0) continue;
		sum+=i;
	}
	
	printf("%d",sum);
}
