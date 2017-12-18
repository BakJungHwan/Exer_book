#include "myString.h"

int strCpy(char * dest, char * source)
{
	int i=0;
	while(source[i]!='\0')
	{
		dest[i] = source[i];
		++i;
	}
	dest[i] = '\0';
	
	return strLen(source);
}

int strCat(char * dest, char * source)
{
	int end_dest = strLen(dest);
	int i=0;
	
	while(source[i]!='\0')
	{
		dest[end_dest+i] = source[i];
		++i;
	}
	
	dest[end_dest+i] = '\0';
	
	return strLen(dest);	
}
