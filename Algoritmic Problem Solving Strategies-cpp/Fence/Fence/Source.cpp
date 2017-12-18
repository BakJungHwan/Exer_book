#include <iostream>
#include <string>
#include <algorithm>


using namespace::std;


int fence(int* height, int left, int right)
{
	int ret;

	if (left == right)
	{
		return height[left];
	}

	// 이 mid는 항상 두 값의 사이 혹은 같은 값을 가지게 된다.
	int mid = (left + right) / 2;

	ret = max(fence(height, left, mid), fence(height, mid + 1, right));

	// left == right 일때 mid == left == right이므로, 기저사례에서 해당부분이 해결된다.
	// 그러므로 hi의 overflow에 대해서 걱정할 필요는 없다.
	int lo = mid;
	int hi = mid + 1;
	int len = 2;
	int min_height;

	if (height[lo] < height[hi])
	{
		min_height = height[lo];
	}
	else
	{
		min_height = height[hi];
	}

	ret = max(ret, min_height * len);


	while (lo > left || hi < right)
	{
		if (hi<right && (lo==left || height[lo - 1] < height[hi + 1]))
		{
			++hi;
			min_height = min(min_height, height[hi]);
		}
		else
		{
			--lo;
			min_height = min(min_height, height[lo]);
		}
		ret = max(ret, min_height*(++len));
	}
	return ret;
}



int main()
{
	int C;

	cin >> C;

	for (int i = 0; i < C; ++i)
	{
		int n;

		cin >> n;

		int *height = new int[n];

		for (int j = 0; j < n; ++j)
		{
			cin >> *(height + j);
		}

		cout << fence(height, 0, n - 1);


		delete height;


	}

	return 0;
}