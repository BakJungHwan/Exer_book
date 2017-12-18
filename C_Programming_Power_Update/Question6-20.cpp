#include <stdio.h>

int DivInt(int, int, int*, int*);

int main()
{
	int n1;
	int n2;
	int a1=0;
	int a2=0;
	
	int* a1p = &a1;
	int* a2p = &a2;
	
	scanf("%d", &n1);
	scanf("%d", &n2);
	
	printf("Return Value : %d\n",DivInt(n1,n2, a1p, a2p));
	
	printf("%d %d", a1, a2);
	
	
	return 0;
}


int DivInt(int n1, int n2, int* a1, int* a2)
{
	if(n2 == 0)
	{
		return -256;
	}
	
	*a1 = n1/n2;
	*a2 = n1%n2;
		
	return 1;
}
