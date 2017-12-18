#include <stdio.h>

enum{A, B=1, C, D=5, E, F, G};


int main()
{
	printf("A : %d\n", A);
	printf("B : %d\n", B);
	printf("C : %d\n", C);
	printf("D : %d\n", D);
	printf("E : %d\n", E);
	printf("F : %d\n", F);
	printf("G : %d\n", G);
	
	return 0;
}
