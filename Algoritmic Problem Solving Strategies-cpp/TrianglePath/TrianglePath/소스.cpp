#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>

using namespace::std;

int n;
int triangle[100][100];
int cache[100][100];

int shortestPath(int x, int y)
{
	if (y == n - 1)
	{
		return triangle[x][y];
	}

	int& ret = triangle[x][y];
	if (ret != -1)
	{
		return cache[x][y];
	}

	return ret = max(shortestPath(x + 1, y), shortestPath(x + 1, y + 1)) + triangle[x][y];

}

