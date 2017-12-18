#include <stdio.h>
#include <string.h>

int main()
{
	char a[20];
	char b[20];
	char c[20];
	char d[20];
	char temp[20];
	
	char* wordp[4];
	wordp[0] = a;
	wordp[1] = b;
	wordp[2] = c;
	wordp[3] = d;
	
	char words[83];
	
	scanf("%s", a);
	scanf("%s", b);
	scanf("%s", c);
	scanf("%s", d);
	
	
	for(int i=0; i<3; ++i)
	{
		for(int j=0; j<3-i; ++j)
		{
			if(strcmp(wordp[j],wordp[j+1])>0)
			{
				strcpy(temp, wordp[j]);
				strcpy(wordp[j],wordp[j+1]);
				strcpy(wordp[j+1],temp);
			}
		}
	}
	
	for(int i=0; i<4; ++i)
	{
		strcat(words,wordp[i]);
		strcat(words," ");
	}
	
	puts(words);
	
	return 0;
}
