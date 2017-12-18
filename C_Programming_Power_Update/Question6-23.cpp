#include <stdio.h>
#define STR_MAX	100

int strLen(char *str)
{
	int i=0;
	
	while(str[i]!='\0')
	{
		++i;
	}
	
	return i;
}

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


int main()
{
	char str1[STR_MAX]="Good morning?";
	char str2[STR_MAX]="HaHaHa!";
	char buffString[STR_MAX];
	
	printf("Length of \"%s\" : %d\n", str1, strLen(str1));
	printf("Length of \"%s\" : %d\n", str2, strLen(str2));
	
	strCpy(buffString, str1);
	printf("copy string : \"%s\" \n", buffString);
	
	strCat(buffString, str2);
	printf("concat string : \"%s\"\n", buffString);
	
	printf("cmp str1, st1 : %d\n", strCmp(str1, str1));
	printf("cmp str2, str2 : %d\n", strCmp(str2, str2));
	printf("cmp str1, str2 : %d\n", strCmp(str1, str2));
	printf("cmp str2, str1 : %d\n", strCmp(str2, str1));
	return 0;
}

