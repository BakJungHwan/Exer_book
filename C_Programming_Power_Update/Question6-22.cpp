#include <stdio.h>

int findChar(char* string, char target)
{
	int i=0;
	int ret=0;
	while(string[i]!='\0')
	{
		printf("string[i] : %c\n", string[i]);
		if(string[i]==target)
		{
			++ret;
		}
		
		++i;
	}
	
	return ret;
}


int main()
{
	char str[100];
	char a;
	
	
	gets(str);
	scanf("%c", &a);
	
	printf("%d\n",findChar(str, a));

	return 0;	
}
