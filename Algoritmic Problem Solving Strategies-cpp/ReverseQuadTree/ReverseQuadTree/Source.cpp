#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#define Max_size 64

char picture[Max_size][Max_size];

using namespace::std;

void depress(string::iterator& it, int x, int y, int size)
{
	char head = *it;
	++it;

	if (head == 'b' || head == 'w')
	{
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				picture[x+i][y+j] = head;
			}
		}
		return;
	}

	int half = size / 2;

	depress(it, x, y, half);
	depress(it, x, y + half, half);
	depress(it, x + half, y, half);
	depress(it, x + half, y + half, half);

	return;
}

void printPicture()
{
	for (int i = 0; i < Max_size; ++i)
	{
		for (int j = 0; j < Max_size; ++j)
		{
			cout << picture[i][j] << " ";
		}
		cout << endl;
	}
}


string reversePicture(string::iterator& it)
{
	char head = *it;
	++it;

	if (head == 'b' || head == 'w')
	{
		return string(1,head);
	}

	string upperLeft = reversePicture(it);
	string upperRight = reversePicture(it);
	string lowerLeft = reversePicture(it);
	string lowerRight = reversePicture(it);

	return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
}


int main()
{
	int C;

	cin >> C;

	for (int i = 0; i < C; ++i)
	{
		string input;
		cin >> input;

		string::iterator it = input.begin();

		depress(it, 0, 0, Max_size);
		printPicture();

		it = input.begin();

		cout << endl;
		cout << endl;

		string result = reversePicture(it);

		it = result.begin();
		

		depress(it, 0, 0, Max_size);

		printPicture();

	}

	return 0;
}