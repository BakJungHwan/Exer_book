#include <stdio.h>
#define STR_LEN 50

int main(void)
{
	int a;
	while (scanf("%[^EOF]",&a)!=EOF)
	{
		printf("%s\n", "OK");
	}
}