#include <stdio.h>

int main()
{
	char str[100];
	int i=0;
	int cur=0;	
	
	FILE* fp = fopen("temp.txt", "w");
	if(fp == NULL)
	{
		printf("File \"temp.txt\" couldn\'t be opened");
		return -1;
	}
	
	for(;i<5;++i)
	{
		printf("num %d sentence : ", i+1);
		fgets(str,99,stdin);
		fputs(str,fp);
	}
		
	fclose(fp);
	
	return 0;
}
