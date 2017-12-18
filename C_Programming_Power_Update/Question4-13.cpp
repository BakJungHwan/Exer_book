#include <stdio.h>

int main(void)
{
	int n;
	
	while(1)
	{
		do
		{
			if(scanf("%d",&n)==EOF)
			{
				return 0;
			}
		}while(n<1);
		
		for(int i =1; i<=n; ++i)
		{
			if(!(n%i))
			{
				printf("%d ", i);
			}
		}
		printf("\n");
		
	}
	
	return 0;
}
