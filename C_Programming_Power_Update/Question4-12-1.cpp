#include <stdio.h>

int main(void)
{
	int n;
	
	scanf("%d", &n);
	
	if(n==2)
	{
		n=0;
	}
	
	for(int i = 0; i<4; ++i)
	{
		n += 2;
		for(int j=1; j<=9; ++j)
		{
			printf("%d X %d = %d\n", n, j, n*j);
		}
		printf("------------------------------------------------------------\n");
	}
	
	return 0;
}
