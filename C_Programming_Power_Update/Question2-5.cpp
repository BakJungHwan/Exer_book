#include <stdio.h>

int main(void)
{
	double a;
	double b;
	
	fputs("Input two real number : ", stdout);
	scanf("%lf",&a);
	scanf("%lf", &b);
	printf("The result of adding : %lf\n",a+b);
	printf("The result of subtraction : %lf\n", a-b);
	printf("The result of multiplication : %lf\n", a*b);
	printf("The result of divide : %lf\n", a/b);
		
	return 0;	
}
