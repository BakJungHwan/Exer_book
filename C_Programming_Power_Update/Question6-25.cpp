#include <stdio.h>
#include <string.h>

static char* temp;

char* StringToeknize(char * str, char * delim)
{
	char isNull;
	char * token;
	int i=0;
	
	if(str!=NULL)
	{
		temp=str;
		isNull=0;
	}
	else
	{
		isNull=1;
	}
	
	while(1)
	{
		if(temp[i]=='\0')
		{
			if(isNull)
			{
				token = temp+i+1;
				continue;
			}
		}
		
		if(temp[i]==*delim)
		{
			temp[i] = '\0';
			break;
		}
		++i;
	}
	
	temp = token;
	
	return token;
}


int main(void)
{
	char str[] = "010-1111-3333";
	char * delim = "-";
	char * token;
	
	token = StringTokenize(str, delim);
	
	while(token!=NULL)
	{
		puts(token);
		toekn=StringTokenize(NULL, delem);
	}
	return 0;
}

