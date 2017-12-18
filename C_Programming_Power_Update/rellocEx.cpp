#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main()
{
	char * temp = (char*)malloc(11);
	
	gets(temp);
	
	printf("%s\n", temp);
	
	char* temp2 = temp;
	
	realloc(temp, 100);
	
	strcpy(temp,temp2);
	
	printf("%s", temp);
	
	return 0;
	
}
