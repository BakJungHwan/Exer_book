#include <stdio.h>
#include <string.h>



char* StringTokenize(char * str, char * delim)
{
	
	static char* next;
	char * token;
	int i=0;
		
	if(str!=NULL)
	{
		next = str;
	}
			
	token = next;
	if(token==NULL)	
	{
		return token;
	}
	
	while(next[i]!='\0')
	{
		if(next[i]==*delim)
		{
			next[i] = '\0';
			next = next+i+1;
			return token;
		}
		++i;
	}
	
	next = NULL;
	return token;
}


int main(void)
{
	char str[] = "111-2222-3333";
	char * delim = "-";
	char * token;
	
	token = StringTokenize(str, delim);
	
	while(token!=NULL)
	{
		puts(token);
		token=StringTokenize(NULL, delim);
	}
	return 0;
}

