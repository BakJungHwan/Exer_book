#include <iostream>
#include <cstring>
using namespace std;

namespace Printer_Const
{
	const int STR_LEN=20;
	
};


class Printer
{
private :
	char string[Printer_Const::STR_LEN];
	
public :
	void SetString(char * str);
	void ShowString();
};


void Printer::SetString(char * str)
{
	strcpy(string,str);
}

void Printer::ShowString()
{
	cout << string << endl;
}



int main(void)
{
	Printer pnt;
	pnt.SetString("Hello world!");
	pnt.ShowString();
	
	pnt.SetString("I love C++");
	pnt.ShowString();
	return 0;
}
