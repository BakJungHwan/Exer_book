#include <iostream>
#include <string.h>
using namespace std;

char ** MakeStrAdr(int len)
{
	char ** str = new char*[len];
	for(int i=0; i<len; ++i)
	{
		str[i] = new char[20];
	}
	
	return str;
}

int main(void)
{
	char ** str = MakeStrAdr(20);
	strcpy(str[0], "I am so happy");
	cout << str[0] << endl;
	
	for(int i=0; i<20; ++i)
	{
		delete str[i];
	}
	
	delete[] str;
	return 0;
}
