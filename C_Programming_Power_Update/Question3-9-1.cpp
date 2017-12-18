#include <stdio.h>

int main(void){
	int n;
	int sum=0;
	
	do
	{
	scanf("%d", &n);
	}while(n<1);

	for(int i=1; i<=n; ++i)
	{
		sum+=i;
	}
	
	printf("%d\n",sum);
	w
	return 0;
	
}
