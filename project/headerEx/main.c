#include "myString.h"

int main()
{
	char str1[STR_MAX]="Good morning?";
	char str2[STR_MAX]="HaHaHa!";
	char buffString[STR_MAX];
	
	printf("Length of \"%s\" : %d\n", str1, strLen(str1));
	printf("Length of \"%s\" : %d\n", str2, strLen(str2));
	
	strCpy(buffString, str1);
	printf("copy string : \"%s\" \n", buffString);
	
	strCat(buffString, str2);
	printf("concat string : \"%s\"\n", buffString);
	
	printf("cmp str1, st1 : %d\n", strCmp(str1, str1));
	printf("cmp str2, str2 : %d\n", strCmp(str2, str2));
	printf("cmp str1, str2 : %d\n", strCmp(str1, str2));
	printf("cmp str2, str1 : %d\n", strCmp(str2, str1));
	return 0;
}
