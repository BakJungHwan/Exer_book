#include <stdio.h>

int main()
{
	FILE* fp = fopen("korean.txt", "w");
	if(fp==NULL)
	{
		printf("File \"korean.txt\" couldn't be opened'");
		return -1;
	}
	
	char str[80] = "가나다라마바사아자차카타파하";
	int i=0;
	
	
	while(str[i]!='\0')
	{
		fputc(str[i],fp);
		++i;
	}
	
	fclose(fp);
	
	return 0;
}
