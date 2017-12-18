#include <stdio.h>

void showBinary(int n)
{
	if(n==0)
	{
		return;
	}
	showBinary(n/2);
	printf("%d", n % 2);
	return;
}



int main(void)
{
	int n;
	scanf("%d", &n);
	
	showBinary(n);
	
	return 0;
}
