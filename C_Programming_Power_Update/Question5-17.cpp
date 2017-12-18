#include <stdio.h>
#include <string.h>

int main()
{
	char words[5][20];
	char temp[20];
	
	for(int i=0; i<5; ++i)
	{
		scanf("%s",words[i]);
	}
	
	for(int i=0; i<4; ++i)
	{
		for(int j=0; j<4-i; ++j)
		{
			if(strlen(words[j]) > strlen(words[j+1]))
			{
				strcpy(temp, words[j]);
				strcpy(words[j],words[j+1]);
				strcpy(words[j+1],temp);
			}
		}
	}

	for(int i=0; i<5; ++i)
	{
		printf("%s", words[i]);
	}
	
	return 0;
}
