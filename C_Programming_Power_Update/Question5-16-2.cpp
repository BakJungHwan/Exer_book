#include <stdio.h>

int main()
{
	char a;
	
	while(1)
	{
		a = getchar();
		if(a=='\n')
		{
			break;
		}
		if(('A'<= a && a <= 'Z') || ('a' <= a && a <= 'z'))
		{
			putchar(a^32);
			continue;
		}
		putchar(a);
	}
	
	
	return 0;
}
