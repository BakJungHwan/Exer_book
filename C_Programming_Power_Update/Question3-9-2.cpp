#include <stdio.h>

int main(void)
{
	int n1;
	int n2;
	int temp;
	int sum=0;
	
	scanf("%d", &n1);
	scanf("%d", &n2);
	
	if(n1 < n2)
	{
		temp = n1;
		n1 = n2;
		n2 = temp;
	}
	
	for(int i=n2; n2<=n1; ++n2)
	{
		sum+=n2;
	}
	
	printf("%d", sum);
		
	return 0;
}
