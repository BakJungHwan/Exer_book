#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
	int a;
	int b;
	
	scanf("%d", &a);
	scanf("%d", &b);
	
	printf("%d", a > b ? a : b);
	
	return 0;
}
