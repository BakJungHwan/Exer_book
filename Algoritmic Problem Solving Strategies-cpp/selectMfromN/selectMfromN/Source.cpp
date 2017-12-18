#include <iostream>
#include <vector>

using namespace std;

void pick(int n, vector<int>& picked, int topick)
{
	if (topick == 0)
	{
		vector<int>::iterator it;
		for (it = picked.begin(); it<picked.end(); ++it)
		{
			cout << " " << *it;
		}
		cout << endl;
		return;
	}

	int smallest = picked.empty() ? 0 : picked.back() + 1;

	for (int next = smallest; next<n; ++next)
	{
		picked.push_back(next);
		pick(n, picked, topick - 1);
		picked.pop_back();
	}
}

int main()
{
	int n = 7;
	vector<int> picked;
	int topick = 4;

	pick(n, picked, topick);

	return 0;
}