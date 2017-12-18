#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define inTempLen 10


int compare(const void* a, const void* b)
{
	return strlen(*(char**)a)- strlen(*(char**)b);
}


void SortArr(char** arr, int num)
{
	qsort(arr, num, sizeof(char*),compare);
}

char* inputString()
{
	char* temp = (char*)malloc(inTempLen+1);
	int extend = 1;
	int i=0;
	
	while(1)
	{
		temp[i] = getchar();
		if(temp[i]=='\n')
		{
			temp[i]='\0';
			break;
		}
		
		if(i==inTempLen*extend)
		{
			char* tempCpy = temp;
			realloc(temp, inTempLen*(++extend)+1);
			strcpy(temp,tempCpy);
		}
		++i;
	}
	
	printf("After input : %s\n", temp);
	
	return temp;	
}

int main()
{
	char* words[5];
	
	for(int i=0; i<5; ++i)
	{
		words[i] = inputString();
	}
		
	SortArr(words,5);
		
	for(int i=0; i<5; ++i)
	{
		printf("%s\n",words[i]);
	}
	
	for(int i=0; i<5; ++i)
	{
		free(words[i]);
	}
	
	return 0;
}
