#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
	int a;
	int b;
	int c;
	
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);
	
	printf("%d", c > (a > b ? a : b) 
			? c : (a > b ? a : b));
	
	return 0;
}
