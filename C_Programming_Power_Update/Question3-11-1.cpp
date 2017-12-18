#include <stdio.h>

int main(){
	
	int n;
	int sum_e=0;
	int sum_o=0;
	
	scanf("%d", &n);
		
	for(int i=1; i<=n; ++i)
	{
		if(!(i%2))
		{
			sum_e+=i;
			continue;
		}
		sum_o+=i;
	}
	
	printf("Sum Even : %d\n", sum_e);
	printf("Sum Odd : %d\n", sum_o);
	
	return 0;
}
