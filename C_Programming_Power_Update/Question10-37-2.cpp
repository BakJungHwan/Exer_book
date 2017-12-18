#include <stdio.h>

int main()
{
	FILE* fp = fopen("numeric.dat","r");
	if(fp==NULL)
	{
		puts("File \"numeric\" couldn't be opened");
		return -1;
	}
	
	
	int num[5];
	int i=0;
	
	fread(num,sizeof(int),5,fp);
	
	for(;i<5;++i)
	{
		printf("%d\n",num[i]);
	}
	
	fclose(fp);
	
	return 0;
}
