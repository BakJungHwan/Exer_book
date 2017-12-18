#include <stdio.h>

int main()
{
	int num[5];
	
	FILE* fp = fopen("numeric.dat", "w");
	if(fp == NULL)
	{
		printf("File \"numeric.dat\" couldn't be opened.");
		return -1;
	}
	
	int i=0;
	
	for(;i<5;++i)
	{
		scanf("%d",num+i);
	}
	
	fwrite(num,sizeof(int),5,fp);
	
	return 0;
}
