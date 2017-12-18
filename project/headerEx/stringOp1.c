#include "myString.h"

int strLen(char *str)
{
	int i=0;
	
	while(str[i]!='\0')
	{
		++i;
	}
	
	return i;
}


int strCmp(char * str1, char * str2)
{
	int i=0;
	int cmp_range;
	int cmp_len;
	int result_minus;
	
	while(!(str1[i]=='\0' || str2[i]=='\0'))
	{
		result_minus = str1[i] - str2[i];
		if(result_minus > 0)
		{
			return -1;
		}
		else if(result_minus <0)
		{
			return 1;
		}
		++i;
	}
	
	if(strLen(str1)==strLen(str2))
	{
		return 0;
	}
	
	if(strLen(str1) > i)
	{
		return -1;
	}
	else
	{
		return 1;
	}
}
