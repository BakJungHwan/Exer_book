#include <stdio.h>

int main()
{
	double r;
	
	fputs("Input radious : ", stdout);
	scanf("%lf", &r);
	printf("area of circle : %lf", r*r*3.14);
	
	return 0;
}
