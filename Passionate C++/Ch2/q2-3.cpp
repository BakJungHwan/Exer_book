#include <iostream>

using namespace std;

typedef struct __Point
{
	int xpos;
	int ypos;
}Point;


Point& PntAdder(const Point &p1, const Point &p2)
{
	Point * ptr = new Point;
	Point& temp = *ptr;
	temp.xpos = p1.xpos + p2.xpos;
	temp.ypos = p1.ypos + p2.ypos;
	
	return temp;
}

int main()
{
	
	Point * p1 = new Point;
	p1->xpos = 33;
	p1->ypos = 3;
	
	
	Point * p2 = new Point;
	p2->xpos = 44;
	p2->ypos = 4;
	
	Point& Pref = PntAdder(*p1,*p2);
	
	cout << Pref.xpos << endl;
	cout << Pref.ypos << endl;
	
	delete &Pref;
	delete p1;
	delete p2;
	
	
	return 0;
}
