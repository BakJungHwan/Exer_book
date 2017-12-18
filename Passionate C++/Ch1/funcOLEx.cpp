#include <iostream>

using namespace std;

int myFunc(int n)
{
	return 1;
}

char myFunc(char c)
{
	return 'a';
}



int main()
{
	cout << myFunc(1) << endl;
	
	cout << myFunc('a') << endl;
	
	return 0;
}
