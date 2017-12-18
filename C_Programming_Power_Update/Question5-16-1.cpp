#include <stdio.h>
#include <string.h>

int main(void)
{
	char a[256];
	int i=0;
		
	scanf("%s", a);
	
	while(i<strlen(a))
	{
		if(('A'<= a[i] && a[i] <= 'Z') || ('a'<=a[i] && a[i]<='z'))
		{
			printf("%c", a[i] ^ 32);
			++i;
			continue;
		}
		
		printf("%c",a[i]);
		++i;
	}
	
	return 0;
}
