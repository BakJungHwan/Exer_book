#include <iostream>

using std::cout;
using std::endl;

void SwapPointer1(int ** ptr1, int ** ptr2)
{
	int * temp;
	temp = *ptr1;
	*ptr1 = *ptr2;
	*ptr2 = temp;
}

void SwapPointer2(int * (&ptr1), int* (&ptr2))
{
	int * temp;
	temp = ptr1;
	ptr1 = ptr2;
	ptr2 = temp;
}

int main()
{
	int num1 = 7;
	int num2 = 77;
	
	int * ptr1 = &num1;
	int * ptr2 = &num2;
	
	cout << endl;
	cout << num1 << endl;
	cout << num2 << endl;
	
	SwapPointer1(&ptr1,&ptr2);
	cout << endl;
	cout << *ptr1 << endl;
	cout << *ptr2 << endl;
	
	SwapPointer2(ptr1,ptr2);
	cout << endl;
	cout << *ptr1 << endl;
	cout << *ptr2 << endl;
	
	return 0;
}
