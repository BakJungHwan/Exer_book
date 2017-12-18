#include <stdio.h>

int main()
{
	FILE* fp = fopen("korean.txt", "r");
	int n;
	char str[80];
	int i=0;
	
	scanf("%d", &n);
	
	while(i!=n*2)
	{
		str[i] = fgetc(fp);
		
		++i;
	}
		
	fclose(fp);
	
	printf("%s", str);
	
	return 0;
}
