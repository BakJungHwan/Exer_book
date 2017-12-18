#include <stdio.h>
#define MAX_STRING 100

void PrintString(int i, FILE* fp);
void PrintAllString(FILE* fp);

int main(void)
{
	int sel;
	char str[MAX_STRING];
	
	FILE* fp=fopen("temp.txt", "r");
	if(fp==NULL)
	{
		puts("error");
		return -1;
	}
	
	scanf("%d", &sel);
	
	if(sel < 6)
	{
		PrintString(sel,fp);
	}
	else
	{
		PrintAllString(fp);
	}

	fclose(fp);

	return 0;
}

void PrintString(int i, FILE* fp)
{
	int j=0;
	char str[MAX_STRING];
	for(;j<i-1;++j)
	{
		fgets(str,MAX_STRING-1,fp);
	}
	fgets(str,MAX_STRING-1,fp);
	fputs(str,stdout);
}

void PrintAllString(FILE* fp)
{
	char str[MAX_STRING];
	while(1)
	{
		fgets(str,MAX_STRING-1,fp);
		if(feof(fp)!=0)
		{
			break;
		}
		fputs(str,stdout);
	}
}
