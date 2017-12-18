#include <stdio.h>

int main(void)
{
	char a;
	
	
	while(scanf("%c",&a)!=EOF)
	{
		if( 0x41 <= a && a <= 0x5A )
		{
			printf("Upper Alphabet\n");
		}
		else if('a' <= a && a <='z')
		{
			printf("Lower Alphabet\n");
		}
		else if('0'<= a && a <='9')
		{
			printf("Number\n");
		}
		else
		{
			printf("Special letter\n");
		}
		
		while(getchar()!='\n');
	}
	
	return 0;
}
