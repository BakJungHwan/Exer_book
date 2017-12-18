#include <iostream>
#include <vector>
#include <string>

using namespace std;

const int dx[] = { 1,1,1,-1,-1,-1,0,0 };
const int dy[] = { 1,0,-1,1,0,-1,1,-1 };

const string map[] = { "NNNNS","NEEEN", "NEYEN", "NEEEN", "NNNNN" };

bool hasWord(int x, int y, const string& word)
{
	if (x < 0 || y < 0 || x>4 || y>4)
	{
		return false;
	}

	if (word[0] != map[x][y])
	{
		return false;
	}

	if (word.length() == 1)
	{
		return true;
	}

	for (int i = 0; i < 8; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (hasWord(nx, ny, word.substr(1)))
		{
			return true;
		}
	}

	return false;
}

int main(int argc, char argv[])
{
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			printf("[%d][%d] = %d\n", i, j, hasWord(i, j, "YES"));
		}
	}
}