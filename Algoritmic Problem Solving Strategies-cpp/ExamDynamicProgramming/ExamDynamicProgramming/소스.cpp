#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace::std;

int n, triangle[100][100];
int cache[100][100];

int path2(int x, int y)
{
	int& ret = cache[x][y];
	if (ret != -1)
	{
		return ret;
	}

	if (y == n - 1)
	{
		return ret = triangle[x][y];
	}

	return ret = triangle[x][y] + max(path2(x + 1, y), path2(x + 1, y + 1));
}