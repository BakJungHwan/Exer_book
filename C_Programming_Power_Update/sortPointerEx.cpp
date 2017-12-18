#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare1(const void* a, const void* b)
{
	return *(int*)a- *(int*)b;
}

int compare2(const void* a, const void* b)
{
	return strcmp(*(char**) a, *(char**) b);
}

int main()
{
	int arrIntegers[7] = { 7, 3 ,2, 21, 14, 99, 98};
	char* arr[5] = {"Good", "A Morning", "D I am very nice", "C I am kind of fastidious", "Z Italian cuisine"};
		
	qsort(arrIntegers,7,sizeof(int),compare1);
	
	for(int i=0; i<7; ++i)
	{
		printf("%d ", arrIntegers[i]);
	}
	
	printf("\n");
	printf("\n");
	
	for(int i=0; i<5; ++i)
	{
		printf("%s\n", arr[i]);
	}
	printf("\n");
	
	qsort(arr,5,sizeof(char*),compare2);
	
	for(int i=0; i<5; ++i)
	{
		printf("%s\n", arr[i]);
	}
	printf("\n");
	
	
	return 0;
	
}
