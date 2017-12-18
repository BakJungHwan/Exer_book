#include <iostream>
#include <cstring>

using namespace std;

int main()
{
	char str1[20]="Genius";
	char str2[20] = "I am ";
	
	cout << strlen(str1) << endl;
	
	strcat(str2,str1);
	
	cout << str2 << endl;
	
	strcpy(str1, str2);
	
	cout << str1 << endl;
	
	cout << strcmp(str1,str2) << endl;
	
	return 0;
	
}
