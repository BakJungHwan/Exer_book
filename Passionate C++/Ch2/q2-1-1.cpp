#include <iostream>

using std::cout;
using std::endl;

void increment(int & num)
{
	++num;
}

void swapPN(int & num)
{
	num *=-1;
}

int main(void)
{
	int num=7;
	
	cout << num << endl;
	increment(num);
	cout << num << endl;
	swapPN(num);
	cout << num << endl;
		
	return 0;
}
